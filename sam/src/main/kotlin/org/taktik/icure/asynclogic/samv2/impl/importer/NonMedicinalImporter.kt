package org.taktik.icure.asynclogic.samv2.impl.importer

import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.NmpDAOImpl
import org.taktik.icure.be.samv2v5.entities.ExportNonMedicinalType
import org.taktik.icure.entities.samv2.Nmp
import org.taktik.icure.entities.samv2.embed.SamText
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.md5
import org.taktik.icure.utils.suspendRetry
import java.util.*

class NonMedicinalImporter {

	suspend fun importNonMedicinals(export: ExportNonMedicinalType, couchDbProperties: CouchDbProperties, couchDbDispatcher: CouchDbDispatcher, force: Boolean): Pair<Map<String, String>, Set<String>> {
		val log = LoggerFactory.getLogger(this::class.java)
		val updatedIds: MutableSet<String> = mutableSetOf()
		val result = HashMap<String, String>()
		val nmpDAO = NmpDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }
		val currentNmps = HashSet(suspendRetry(50) { nmpDAO.getEntityIds().toList() })
		val newNmpIds = mutableListOf<String>()

		export.nonMedicinalProduct.flatMap { nmp ->
			nmp.data.map { d ->
				val code = nmp.code.toString()
				val from = d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = d.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				val id = "NMP:$code:$from".md5()
				newNmpIds.add(id)
				if (result["SAMID:$id"] != null && result["SAMID:$id"] != nmp.productId) {
					throw IllegalStateException("duplicate nmp in db $code - $from")
				}
				result["SAMID:$id"] = nmp.productId

				Nmp(
					id = id,
					from = from,
					to = to,
					code = code,
					name = d.name?.let { SamText(it.fr, it.nl, it.de, it.en) },
					producer = d.producer?.let { SamText(it.fr, it.nl, it.de, it.en) },
					distributor = d.producer?.let { SamText(it.fr, it.nl, it.de, it.en) }
				)
			}
		}.chunked(100).map { nmps ->
			val currentNmpsWithDoc = nmpDAO.getEntities(nmps.map { it.id }.filter { currentNmps.contains(it) }).toList()
			nmps.map { nmp ->
				if (!currentNmps.contains(nmp.id)) {
					log.info("New NMP NMP:${nmp.code}:${nmp.from} with id ${nmp.id}")
					try {
						nmpDAO.save(nmp)
					} catch (e: Exception) {
						nmpDAO.get(nmp.id)?.let { prev -> nmpDAO.update(nmp.copy(rev = prev.rev)) }
					}
				} else if (force) {
					val prev = currentNmpsWithDoc.find { it.id == nmp.id }!!
					nmp.copy(rev = prev.rev).let {
						if (prev != it) {
							log.info("Modified NMP NMP:${it.code}:${it.from} with id ${it.id}")
							updatedIds.add(it.id)
							nmpDAO.update(it)
						} else prev
					}
				} else nmp
			}
		}
		(currentNmps - newNmpIds.toSet()).chunked(100).forEach { nmpDAO.remove(nmpDAO.getEntities(it)) }
		return result to updatedIds
	}
}
