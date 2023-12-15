package org.taktik.icure.asynclogic.samv2.impl.importer

import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.VmpDAOImpl
import org.taktik.icure.asyncdao.samv2.impl.VmpGroupDAOImpl
import org.taktik.icure.be.samv2v5.entities.ExportVirtualMedicinesType
import org.taktik.icure.be.samv2v5.entities.VirtualIngredientDataType
import org.taktik.icure.be.samv2v5.entities.VmpComponentDataType
import org.taktik.icure.be.samv2v5.entities.VmpGroupDataType
import org.taktik.icure.entities.base.CodeStub
import org.taktik.icure.entities.samv2.Vmp
import org.taktik.icure.entities.samv2.VmpGroup
import org.taktik.icure.entities.samv2.embed.IngredientType
import org.taktik.icure.entities.samv2.embed.NoGenericPrescriptionReason
import org.taktik.icure.entities.samv2.embed.NoSwitchReason
import org.taktik.icure.entities.samv2.embed.NumeratorRange
import org.taktik.icure.entities.samv2.embed.Quantity
import org.taktik.icure.entities.samv2.embed.RouteOfAdministration
import org.taktik.icure.entities.samv2.embed.SamText
import org.taktik.icure.entities.samv2.embed.StandardSubstance
import org.taktik.icure.entities.samv2.embed.StandardSubstanceType
import org.taktik.icure.entities.samv2.embed.StrengthRange
import org.taktik.icure.entities.samv2.embed.VirtualForm
import org.taktik.icure.entities.samv2.embed.VirtualIngredient
import org.taktik.icure.entities.samv2.embed.VmpComponent
import org.taktik.icure.entities.samv2.embed.Vtm
import org.taktik.icure.entities.samv2.embed.Wada
import org.taktik.icure.entities.samv2.stub.SubstanceStub
import org.taktik.icure.entities.samv2.stub.VmpGroupStub
import org.taktik.icure.entities.samv2.stub.VmpStub
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.md5
import org.taktik.icure.utils.suspendRetry
import java.util.*

class VirtualMedicineImporter {

	suspend fun importVirtualMedicines(export: ExportVirtualMedicinesType, vmpsMap: MutableMap<String, VmpStub>, couchDbProperties: CouchDbProperties, couchDbDispatcher: CouchDbDispatcher, force: Boolean): Pair<Map<String, String>, Set<String>> {
		val log = LoggerFactory.getLogger(this::class.java)
		val updatedIds: MutableSet<String> = mutableSetOf()
		val result = HashMap<String, String>()
		val vmpGroupDAO = VmpGroupDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }
		val vmpDAO = VmpDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }

		val currentVmpGroups = HashSet(suspendRetry(50) { vmpGroupDAO.getEntityIds().toList() })
		val currentVmps = HashSet(suspendRetry(50) { vmpDAO.getEntityIds().toList() })

		val vmpGroupIds = HashMap<Int, String>()

		val newVmpIds = mutableListOf<String>()
		val newVmpGroupIds = mutableListOf<String>()

		export.vmpGroup.forEach { vmpg ->
			vmpg.data.map { d ->
				val code = vmpg.code.toString()
				val from = d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = d.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				val id = "VMPGROUP:$code:$from".md5()

				result["SAMID:$id"] = vmpg.productId
				newVmpGroupIds.add(id)
				VmpGroup(
					id = id,
					from = from,
					to = to,
					name = d.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
					code = code,
					noGenericPrescriptionReason = d.noGenericPrescriptionReason?.let { reason ->
						NoGenericPrescriptionReason(reason.code, reason.description?.let { SamText(it.fr, it.nl, it.de, it.en) })
					},
					noSwitchReason = d.noSwitchReason?.let { reason ->
						NoSwitchReason(reason.code, reason.description?.let { SamText(it.fr, it.nl, it.de, it.en) })
					}
				).let { vmpg ->
					if (!currentVmpGroups.contains(id)) {
						log.info("New VMP group VMPGROUP:$code:$from with id $id")
						try {
							vmpGroupDAO.save(vmpg)
						} catch (e: Exception) {
							vmpGroupDAO.get(vmpg.id)?.let { vmpGroupDAO.update(vmpg.copy(rev = it.rev)) }
						}
					} else if (force) {
						val prev = vmpGroupDAO.get(vmpg.id)
						vmpg.copy(rev = prev?.rev).let {
							if (prev != it) {
								log.info("Modified VMP group VMPGROUP:$code:$from with id $id")
								vmpGroupDAO.update(it)
							} else vmpg
						}
					} else vmpg
				}
			}.filterNotNull().maxByOrNull { it.to ?: Long.MAX_VALUE }?.let { latestVmpGroup ->
				vmpGroupIds[vmpg.code] = latestVmpGroup.id
			}
		}
		export.vmp.flatMap { vmp ->
			vmp.data.map { d ->
				val code = vmp.code.toString()
				val from = d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = d.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				val id = "VMP:$code:$from".md5()
				newVmpIds.add(id)

				Vmp(
					id = id,
					from = from,
					to = to,
					code = code,
					vmpGroup = d.vmpGroup?.let {
						vmpGroupIds[d.vmpGroup.code]?.let { vmpgId ->
							VmpGroupStub(
								id = vmpgId, code = it.code.toString(),
								name = it.data.maxByOrNull { c: VmpGroupDataType ->
									c.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis ?: 0L
								}?.name?.let { SamText(it.fr, it.nl, it.de, it.en) }
							)
						}
					},
					name = d.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
					abbreviation = d.abbreviation?.let { SamText(it.fr, it.nl, it.de, it.en) },
					vtm = Vtm(code = d.vtm?.code?.toString(), name = d.vtm?.data?.last()?.name?.let { SamText(it.fr, it.nl, it.de, it.en) }),
					commentedClassifications = d.commentedClassification?.mapNotNull { cc -> commentedClassificationMapper(cc) }
						?.toSet() ?: setOf(),
					components = vmp.vmpComponent?.mapNotNull { vmpc ->
						vmpc?.data?.maxByOrNull { d: VmpComponentDataType ->
							d.from.toGregorianCalendar(
								TimeZone.getTimeZone("UTC"),
								null,
								null
							).timeInMillis
						}?.let { comp ->
							VmpComponent(
								code = vmpc.code.toString(),
								virtualForm = comp.virtualForm?.let { virtualForm ->
									VirtualForm(virtualForm.name?.let { SamText(it.fr, it.nl, it.de, it.en) }, virtualForm.standardForm?.map { CodeStub.from(it.standard.value(), it.code, "1.0") }?.toSet() ?: setOf())
								},
								routeOfAdministrations = comp.routeOfAdministration?.map { roa ->
									RouteOfAdministration(roa.name?.let { SamText(it.fr, it.nl, it.de, it.en) }, roa.standardRoute?.map { CodeStub.from(it.standard.value(), it.code, "1.0") }?.toSet() ?: setOf())
								}?.toSet() ?: setOf(),
								phaseNumber = comp.phaseNumber,
								name = comp.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
								virtualIngredients = vmpc.virtualIngredient?.mapNotNull { vi ->
									vi.data.maxByOrNull { d: VirtualIngredientDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let {
										VirtualIngredient(
											from = it.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											to = it.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
											rank = vi.rank.toInt(),
											type = it.type?.let { IngredientType.valueOf(it.value()) },
											strengthRange = it.strength?.let { StrengthRange(NumeratorRange(it.numeratorRange.min, it.numeratorRange.max, it.numeratorRange.unit), Quantity(it.denominator.value, it.denominator.unit)) },
											substance = it.substance?.let {
												SubstanceStub(
													id = "SAM-SUBSTANCE:${it.code}:${it.chemicalForm}".md5(),
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
												)
											}
										)
									}
								}?.toSet()
							)
						}
					}?.toSet() ?: setOf(),
					wadas = d.wada.mapNotNull { Wada(code = it.code, name = it.name?.let { SamText(it.fr, it.nl, it.de, it.en) }, description = it.description?.let { SamText(it.fr, it.nl, it.de, it.en) }) }.toSet()
				)
			}
		}.chunked(100).map { vmps ->
			val ids = vmps.map { it.id }.filter { currentVmps.contains(it) }
			val currentVmpsWithDoc = vmpDAO.getEntities(ids).toList()
			vmps.forEach { vmp ->
				vmp.code?.let { vmpsMap[it] = VmpStub(code = vmp.code, id = vmp.id, vmpGroup = vmp.vmpGroup?.let { VmpGroupStub(it.id, it.code, it.name) }, name = vmp.name) }
				if (!currentVmps.contains(vmp.id)) {
					log.info("New VMP VMP:${vmp.code}:${vmp.from} with id ${vmp.id}")
					try {
						vmpDAO.save(vmp)
					} catch (e: Exception) {
						vmpDAO.get(vmp.id)?.let { prev -> vmpDAO.update(vmp.copy(rev = prev.rev)) }
					}
				} else if (force) {
					val prev = currentVmpsWithDoc.find { it.id == vmp.id }!!
					vmp.copy(rev = prev.rev).let {
						if (prev != it) {
							log.info("Modified VMP VMP:${it.code}:${it.from} with id ${it.id}")
							updatedIds.add(it.id)
							vmpDAO.update(it)
						} else prev
					}
				} else vmp
			}
		}

		(currentVmpGroups - newVmpGroupIds).chunked(100).forEach { vmpGroupDAO.remove(vmpGroupDAO.getEntities(it)) }
		(currentVmps - newVmpIds).chunked(100).forEach { vmpDAO.remove(vmpDAO.getEntities(it)) }

		return result to updatedIds
	}
}
