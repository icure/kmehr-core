package org.taktik.icure.asynclogic.samv2.impl.importer

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.AmpDAOImpl
import org.taktik.icure.be.samv2v5.entities.AmppComponentDataType
import org.taktik.icure.be.samv2v5.entities.AmppDataType
import org.taktik.icure.be.samv2v5.entities.CompanyDataType
import org.taktik.icure.be.samv2v5.entities.DmppDataType
import org.taktik.icure.be.samv2v5.entities.ExportActualMedicinesType
import org.taktik.icure.be.samv2v5.entities.RealActualIngredientDataType
import org.taktik.icure.entities.base.CodeStub
import org.taktik.icure.entities.samv2.Amp
import org.taktik.icure.entities.samv2.embed.AmpComponent
import org.taktik.icure.entities.samv2.embed.AmpStatus
import org.taktik.icure.entities.samv2.embed.Ampp
import org.taktik.icure.entities.samv2.embed.AmppComponent
import org.taktik.icure.entities.samv2.embed.Atc
import org.taktik.icure.entities.samv2.embed.Commercialization
import org.taktik.icure.entities.samv2.embed.Company
import org.taktik.icure.entities.samv2.embed.ContainsAlcohol
import org.taktik.icure.entities.samv2.embed.ContentType
import org.taktik.icure.entities.samv2.embed.Crushable
import org.taktik.icure.entities.samv2.embed.DeliveryEnvironment
import org.taktik.icure.entities.samv2.embed.DeviceType
import org.taktik.icure.entities.samv2.embed.Dmpp
import org.taktik.icure.entities.samv2.embed.DmppCodeType
import org.taktik.icure.entities.samv2.embed.Ingredient
import org.taktik.icure.entities.samv2.embed.IngredientType
import org.taktik.icure.entities.samv2.embed.MedicineType
import org.taktik.icure.entities.samv2.embed.PackagingType
import org.taktik.icure.entities.samv2.embed.Quantity
import org.taktik.icure.entities.samv2.embed.Reimbursement
import org.taktik.icure.entities.samv2.embed.RouteOfAdministration
import org.taktik.icure.entities.samv2.embed.SamText
import org.taktik.icure.entities.samv2.embed.StandardSubstance
import org.taktik.icure.entities.samv2.embed.StandardSubstanceType
import org.taktik.icure.entities.samv2.embed.SupplyProblem
import org.taktik.icure.entities.samv2.stub.PharmaceuticalFormStub
import org.taktik.icure.entities.samv2.stub.SubstanceStub
import org.taktik.icure.entities.samv2.stub.VmpStub
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.Diff
import org.taktik.icure.utils.explainDifferences
import org.taktik.icure.utils.md5
import org.taktik.icure.utils.suspendRetry
import java.util.*

class ActualMedicineValidator {
	@OptIn(ExperimentalCoroutinesApi::class)
	val vaccineIndicationsMap = ObjectMapper().registerModule(
		KotlinModule.Builder()
			.configure(KotlinFeature.NullIsSameAsDefault, true)
			.build()
	).readValue(
		this.javaClass.getResource("vaccines.json")!!.openStream().bufferedReader(), object : TypeReference<List<Samv2v5Import.VaccineCode>>() {}
	).fold(mutableMapOf<String, List<String>>()) { map, it ->
		it.cnk?.let { cnk -> map[cnk] = it.codes }
		map
	}.toMap()

	suspend fun validateActualMedicines(export: ExportActualMedicinesType, vmps: Map<String, VmpStub>, reimbursements: Map<Triple<String?, String?, String?>, MutableSet<Reimbursement>>, couchDbProperties: CouchDbProperties, couchDbDispatcher: CouchDbDispatcher): List<Diff> {
		val diffs: MutableList<Diff> = mutableListOf()
		val log = LoggerFactory.getLogger(this::class.java)

		val result = HashMap<String, String>()

		val ampDAO = AmpDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }

		val currentAmps = HashSet(suspendRetry(50) { ampDAO.getEntityIds().toList() })
		val newAmpIds = mutableListOf<String>()

		val substances = mutableMapOf<String, SubstanceStub>()
		val pharmaceuticalForms = mutableMapOf<String, PharmaceuticalFormStub>()

		export.amp.flatMap { amp ->
			amp.data.map { d ->
				val code = amp.code.toString()
				val from = d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = d.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				val id = "AMP:$code:$from".md5()
				newAmpIds.add(id)

				Amp(
					id = id,
					from = from,
					to = to,
					code = code,
					name = d.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
					abbreviatedName = d.abbreviatedName?.let { SamText(it.fr, it.nl, it.de, it.en) },
					officialName = d.officialName,
					vmp = amp.vmpCode?.let { vmps[it.toString()] },
					status = d.status?.value()?.let { AmpStatus.valueOf(it) },
					blackTriangle = d.isBlackTriangle,
					medicineType = d.medicineType?.value()?.let { MedicineType.valueOf(it) },
					company = d.company?.data?.maxByOrNull { c: CompanyDataType ->
						c.from?.toGregorianCalendar(
							TimeZone.getTimeZone("UTC"),
							null,
							null
						)?.timeInMillis ?: 0L
					}?.let {
						Company(
							it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis, it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis, it.authorisationNr,
							it.vatNr?.countryCode?.let { cc -> it.vatNr.value?.let { v -> mapOf(Pair(cc, v)) } }, it.europeanNr, it.denomination, it.legalForm, it.building,
							it.streetName, it.streetNum, it.postbox, it.postcode, it.city, it.countryCode, it.phone, it.language?.value(), it.website
						)
					},
					proprietarySuffix = d.proprietarySuffix?.let { SamText(it.fr, it.nl, it.de, it.en) },
					prescriptionName = (d.prescriptionNameFamhp ?: d.prescriptionName)?.let { SamText(it.fr ?: d.prescriptionName?.fr, it.nl ?: d.prescriptionName?.nl, it.de ?: d.prescriptionName?.de, it.en ?: d.prescriptionName?.en) },
					ampps = amp.ampp?.mapNotNull { ampp ->
						ampp.data.maxByOrNull { d: AmppDataType ->
							d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis ?: 0
						}?.let { amppd ->
							Ampp(
								from = amppd.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
								to = amppd.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
								index = amppd.index?.toDouble(),
								ctiExtended = ampp.ctiExtended,
								orphan = amppd.isOrphan,
								leafletLink = amppd.leafletLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								spcLink = amppd.spcLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								rmaPatientLink = amppd.rmaPatientLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								rmaProfessionalLink = amppd.rmaProfessionalLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								parallelCircuit = amppd.parallelCircuit,
								parallelDistributor = amppd.parallelDistributor,
								packMultiplier = amppd.packMultiplier,
								packAmount = amppd.packAmount?.let { Quantity(amppd.packAmount.value, amppd.packAmount?.unit) },
								packDisplayValue = amppd.packDisplayValue,
								status = amppd.status?.value()?.let { AmpStatus.valueOf(it) },
								atcs = amppd.atc?.map { Atc(it.code, it.description) }?.toSet() ?: setOf(),
								crmLink = amppd.crmLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								deliveryModusCode = amppd.deliveryModus?.code,
								deliveryModus = amppd.deliveryModus?.description?.let { SamText(it.fr, it.nl, it.de, it.en) },
								deliveryModusSpecification = amppd.deliveryModusSpecification?.let { it.description?.let { SamText(it.fr, it.nl, it.de, it.en) } ?: it.code?.let { SamText(it, it, it, it) } },
								dhpcLink = amppd.dhpcLink?.let { SamText(it.fr, it.nl, it.de, it.en) },
								distributorCompany = amppd.distributorCompany?.let {
									it.data.maxByOrNull { d: CompanyDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										Company(
											it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis, it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis, it.authorisationNr,
											it.vatNr?.countryCode?.let { cc -> it.vatNr.value?.let { v -> mapOf(Pair(cc, v)) } }, it.europeanNr, it.denomination, it.legalForm, it.building,
											it.streetName, it.streetNum, it.postbox, it.postcode, it.city, it.countryCode, it.phone, it.language?.value(), it.website
										)
									}
								},
								singleUse = amppd.isSingleUse,
								speciallyRegulated = amppd.speciallyRegulated,
								abbreviatedName = amppd.abbreviatedName?.let { SamText(it.fr, it.nl, it.de, it.en) },
								prescriptionName = (amppd.prescriptionNameFamhp ?: amppd.prescriptionName)?.let { SamText(it.fr ?: amppd.prescriptionName?.fr, it.nl ?: amppd.prescriptionName?.nl, it.de ?: amppd.prescriptionName?.de, it.en ?: amppd.prescriptionName?.en) },
								note = amppd.note?.let { SamText(it.fr, it.nl, it.de, it.en) },
								posologyNote = amppd.posologyNote?.let { SamText(it.fr, it.nl, it.de, it.en) },
								noGenericPrescriptionReasons = amppd.noGenericPrescriptionReason?.map { SamText(it.description.fr, it.description.nl, it.description.de, it.description.en) }?.toSet() ?: setOf(),
								exFactoryPrice = amppd.exFactoryPrice?.toDouble(),
								reimbursementCode = amppd.reimbursementCode,
								definedDailyDose = Quantity(amppd.definedDailyDose?.value, amppd.definedDailyDose?.unit),
								officialExFactoryPrice = amppd.officialExFactoryPrice?.toDouble(),
								realExFactoryPrice = amppd.realExFactoryPrice?.toDouble(),
								pricingInformationDecisionDate = amppd.pricingInformationDecisionDate?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
								components = ampp.amppComponent?.map { component ->
									component.data.maxByOrNull { d: AmppComponentDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										AmppComponent(
											from = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis, to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											contentType = it.contentType?.let { ContentType.valueOf(it.value()) },
											deviceType = it.deviceType?.let { DeviceType(code = it.code, edqmCode = it.edqmCode, edqmDefinition = it.edqmDefinition, name = it.name?.let { SamText(it.fr, it.nl, it.de, it.en) }) },
											packagingType = it.packagingType?.let { PackagingType(code = it.code, edqmCode = it.edqmCode, edqmDefinition = it.edqmDefinition, name = it.name?.let { SamText(it.fr, it.nl, it.de, it.en) }) },
											packSpecification = it.packSpecification,
											contentMultiplier = it.contentMultiplier
										)
									}
								}?.toSet() ?: setOf(),
								commercializations = ampp.commercialization?.data?.mapNotNull {
									Commercialization(
										from = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										reason = it.reason?.let { SamText(it.fr, it.nl, it.de, it.en) },
										endOfComercialization = it.endOfCommercialization?.let { SamText(it.fr, it.nl, it.de, it.en) },
										impact = it.impact?.let { SamText(it.fr, it.nl, it.de, it.en) },
										additionalInformation = it.additionalInformation?.let { SamText(it.fr, it.nl, it.de, it.en) }
									)
								}?.toSet() ?: setOf(),
								supplyProblems = ampp.supplyProblem?.data?.mapNotNull {
									SupplyProblem(
										from = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										reason = it.reason?.let { SamText(it.fr, it.nl, it.de, it.en) },
										expectedEndOn = it.expectedEndOn?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										impact = it.impact?.let { SamText(it.fr, it.nl, it.de, it.en) },
										additionalInformation = it.additionalInformation?.let { SamText(it.fr, it.nl, it.de, it.en) }
									)
								}?.toSet(),
								dmpps = ampp.dmpp?.mapNotNull { dmpp ->
									dmpp.data.maxByOrNull { d: DmppDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										val dmppFrom = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
										val dmppId = "AMP:$code:$from:AMPP:${ampp.ctiExtended}:DMPP:${dmpp.code}:$dmppFrom:${dmpp.deliveryEnvironment}".md5()
										if (result["SAMID:$dmppId"] != null && result["SAMID:$dmppId"] != dmpp.productId) {
											throw IllegalStateException("duplicate dmpp in db $code - $from")
										}
										result["SAMID:$dmppId"] = dmpp.productId

										Dmpp(
											id = dmppId,
											from = dmppFrom,
											to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											deliveryEnvironment = dmpp.deliveryEnvironment?.let { DeliveryEnvironment.valueOf(it.value()) },
											code = dmpp.code,
											codeType = dmpp.codeType?.let { DmppCodeType.valueOf(it.value()) },
											price = it.price?.toString(), cheap = it.isCheap, cheapest = it.isCheapest, reimbursable = it.isReimbursable,
											reimbursements = reimbursements[Triple(dmpp.deliveryEnvironment?.value(), dmpp.codeType?.value(), dmpp.code)]
										)
									}
								}?.toSet() ?: setOf(),
								vaccineIndicationCodes = ampp.dmpp?.flatMap { dmpp ->
									dmpp.data.maxByOrNull { d: DmppDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										vaccineIndicationsMap[dmpp.code]
									} ?: listOf()
								}?.toSet()
							)
						}
					}?.toSet() ?: setOf(),
					components = amp.ampComponent?.mapNotNull { ampc ->
						ampc?.data?.maxByOrNull { d ->
							d.from.toGregorianCalendar(
								TimeZone.getTimeZone("UTC"),
								null,
								null
							).timeInMillis
						}?.let { comp ->
							AmpComponent(
								pharmaceuticalForms = comp.pharmaceuticalForm?.map { pharmForm ->
									val id = "SAM-PHARMAFORM:${pharmForm.code}:${pharmForm.name?.fr}:${pharmForm.name?.nl}:${pharmForm.name?.de}:${pharmForm.name?.en}".md5()
									pharmaceuticalForms[id] ?: PharmaceuticalFormStub(
										id = id,
										code = pharmForm.code,
										name = pharmForm.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
										standardForms = pharmForm.standardForm?.map { CodeStub.from(it.standard.value(), it.code, "1.0") }?.toSet() ?: setOf()
									).also {
										pharmaceuticalForms[id] = it
									}
								}?.toSet() ?: setOf(),
								routeOfAdministrations = comp.routeOfAdministration?.map { roa ->
									RouteOfAdministration(roa.name?.let { SamText(it.fr, it.nl, it.de, it.en) }, roa.standardRoute?.map { CodeStub.from(it.standard.value(), it.code, "1.0") }?.toSet() ?: setOf())
								}?.toSet() ?: setOf(),
								dividable = comp.dividable,
								scored = comp.scored,
								crushable = comp.crushable?.value()?.let { Crushable.valueOf(it) },
								containsAlcohol = comp.containsAlcohol?.value()?.let { ContainsAlcohol.valueOf(it) },
								sugarFree = comp.isSugarFree,
								modifiedReleaseType = comp.modifiedReleaseType,
								specificDrugDevice = comp.specificDrugDevice,
								dimensions = comp.dimensions,
								name = comp.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
								note = comp.note?.let { SamText(it.fr, it.nl, it.de, it.en) },
								ingredients = ampc.realActualIngredient?.mapNotNull { ingredient ->
									ingredient.data.maxByOrNull { d: RealActualIngredientDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										Ingredient(
											from = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											rank = ingredient.rank.toInt(),
											type = it.type?.let { IngredientType.valueOf(it.value()) },
											knownEffect = it.isKnownEffect,
											strength = it.strength?.let { Quantity(it.value, it.unit) },
											strengthDescription = it.strengthDescription,
											additionalInformation = it.additionalInformation,
											substance = it.substance?.let { it ->
												val id = "SAM-SUBSTANCE:${it.code}:${it.chemicalForm}".md5()
												substances[id] ?: SubstanceStub(
													id = id,
													code = it.code,
													chemicalForm = it.chemicalForm,
													name = it.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
													note = it.note?.let { SamText(it.fr, it.nl, it.de, it.en) },
													standardSubstances = it.standardSubstance?.mapNotNull {
														StandardSubstance(
															code = it.code,
															type = it.standard?.let { StandardSubstanceType.withValue(it.value()) },
															name = it.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
															url = it.url,
															definition = it.definition?.let { SamText(it.fr, it.nl, it.de, it.en) }
														)
													}?.toSet() ?: setOf()
												).also {
													substances[id] = it
												}
											}
										)
									}
								}?.toSet() ?: setOf()
							)
						}
					}?.toSet() ?: setOf()
				)
			}
		}.chunked(100).mapIndexed { index, amps ->
			log.info("${index * 100} AMPs treated")
			val currentAmpsWithDoc = ampDAO.getEntities(amps.map { it.id }.filter { currentAmps.contains(it) }).toList()
			amps.forEach { amp ->
				if (!currentAmps.contains(amp.id)) {
					log.info("New AMP AMP:${amp.code}:${amp.from} with id ${amp.id}")
				} else {
					val prev = (currentAmpsWithDoc.find { it.id == amp.id } ?: ampDAO.get(amp.id))!!.let {
						if (amp.ampps.all { it.dmpps.all { it.reimbursements == null } }) {
							it.copy(ampps = it.ampps.map { it.copy(dmpps = it.dmpps.map { it.copy(reimbursements = null) }.toSet()) }.toSet())
						} else it
					}
					amp.copy(rev = prev.rev).let {
						if (prev != it && prev.copy(prescriptionName = null, ampps = prev.ampps.map { it.copy(prescriptionName = null) }.toSet()) != it.copy(prescriptionName = null, ampps = prev.ampps.map { it.copy(prescriptionName = null) }.toSet())) {
							diffs.add(Diff("Amp[${it.code}]", amp.explainDifferences(prev)))
						} else prev
					}
				}
			}
		}

		return diffs
	}
}
