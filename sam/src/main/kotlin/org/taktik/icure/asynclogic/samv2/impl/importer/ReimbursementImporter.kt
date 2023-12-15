package org.taktik.icure.asynclogic.samv2.impl.importer

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.toList
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.AmpDAOImpl
import org.taktik.icure.be.samv2v5.entities.CopaymentDataType
import org.taktik.icure.be.samv2v5.entities.ExportReimbursementsType
import org.taktik.icure.entities.samv2.Amp
import org.taktik.icure.entities.samv2.embed.*
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.suspendRetry
import java.util.*

class ReimbursementImporter {
	val log: Logger = LoggerFactory.getLogger(this::class.java)
	private val updatedIds: MutableSet<String> = mutableSetOf()

	suspend fun importReimbursements(export: ExportReimbursementsType, reimbursements: MutableMap<Triple<String?, String?, String?>, MutableSet<Reimbursement>>, couchDbProperties: CouchDbProperties, couchDbDispatcher: CouchDbDispatcher): Set<String> {
		export.reimbursementContext.forEach { reimb ->
			reimb.data.forEach { reimbd ->
				val from = reimbd.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = reimbd.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				reimbursements[Triple(reimb.deliveryEnvironment?.value(), reimb.codeType?.value(), reimb.code)].let {
					it ?: sortedSetOf<Reimbursement>().also {
							reimbursements[Triple(reimb.deliveryEnvironment?.value(), reimb.codeType?.value(), reimb.code)] = it
						}
				}.add(
					Reimbursement(
						from = from,
						to = to,
						deliveryEnvironment = reimb.deliveryEnvironment?.let { DeliveryEnvironment.valueOf(it.value()) },
						code = reimb.code,
						codeType = reimb.codeType?.let { DmppCodeType.valueOf(it.value()) },
						multiple = reimbd.multiple?.let { MultipleType.valueOf(it.value()) },
						temporary = reimbd.isTemporary,
						reference = reimbd.isReference,
						legalReferencePath = reimb.legalReferencePath,
						flatRateSystem = reimbd.isFlatRateSystem,
						reimbursementBasePrice = reimbd.reimbursementBasePrice,
						referenceBasePrice = reimbd.referenceBasePrice,
						reimbursementCriterion = reimbd.reimbursementCriterion?.let { ReimbursementCriterion(it.category, it.code, it.description?.let { SamText(it.fr, it.nl, it.de, it.en) }) },
						copaymentSupplement = reimbd.copaymentSupplement,
						pricingUnit = reimbd.pricingUnit?.let { Pricing(it.quantity, it.label?.let { SamText(it.fr, it.nl, it.de, it.en) }) },
						pricingSlice = reimbd.pricingSlice?.let { Pricing(it.quantity, it.label?.let { SamText(it.fr, it.nl, it.de, it.en) }) },
						copayments = reimb.copayment?.mapNotNull { cop ->
							cop.data.maxByOrNull { d: CopaymentDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }
								?.let { copd ->
									Copayment(
										regimeType = cop.regimeType,
										from = copd.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										to = copd.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
										feeAmount = copd.feeAmount?.toString()
									)
								}
						}?.toSet()
					)
				)
			}
		}

		val ampDAO = AmpDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }
		HashSet<String>(suspendRetry(50) { ampDAO.getEntityIds().toList() }).chunked(100).forEach { ids ->
			ampDAO.save(
				ampDAO.getEntities(ids).fold(listOf<Amp>()) { acc, amp ->
					val ampps = amp.ampps.map {
						it.copy(
							dmpps = it.dmpps.map { dmpp: Dmpp ->
								reimbursements[Triple(dmpp.deliveryEnvironment?.name, dmpp.codeType?.name, dmpp.code)]?.let {
									if (dmpp.reimbursements != it) {
										val rbAsList = it.toList()
										dmpp.reimbursements?.forEachIndexed { index, reimbursement ->
											if (index >= it.size) {
												log.info("≠ in the number of reimbursements for dmpp ${dmpp.codeType?.name}-${dmpp.code}")
											} else {
												if (reimbursement != rbAsList[index]) {
													log.info("≠ in the reimbursement $index for dmpp ${dmpp.codeType?.name}-${dmpp.code}")
												}
											}
										}
										dmpp.copy(reimbursements = it)
									} else dmpp
								} ?: dmpp
							}.toSet()
						)
					}.toSet()
					if (ampps != amp.ampps) {
						updatedIds.add(amp.id)
						acc + amp.copy(ampps = ampps)
					} else acc
				}.asFlow()
			)
		}
		return updatedIds
	}
}
