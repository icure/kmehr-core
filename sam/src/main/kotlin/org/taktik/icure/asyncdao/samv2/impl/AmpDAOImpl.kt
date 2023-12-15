/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asyncdao.samv2.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import org.taktik.couchdb.ViewQueryResultEvent
import org.taktik.couchdb.annotation.View
import org.taktik.couchdb.entity.ComplexKey
import org.taktik.couchdb.id.IDGenerator
import org.taktik.couchdb.queryView
import org.taktik.couchdb.queryViewIncludeDocs
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.impl.InternalDAOImpl
import org.taktik.icure.asyncdao.samv2.AmpDAO
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.db.sanitizeString
import org.taktik.icure.entities.samv2.Amp
import org.taktik.icure.entities.samv2.SamVersion
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.createQuery
import org.taktik.icure.utils.makeFromTo
import org.taktik.icure.utils.pagedViewQuery
import org.taktik.icure.utils.toInputStream
import java.net.URI
import java.util.zip.GZIPInputStream

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@Repository("ampDAO")
@Profile("sam")
@View(name = "all", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.samv2.Amp' && !doc.deleted) emit( null, doc._id )}")
class AmpDAOImpl(
	couchDbProperties: CouchDbProperties,
	@Qualifier("drugCouchDbDispatcher") couchDbDispatcher: CouchDbDispatcher,
	idGenerator: IDGenerator
) : InternalDAOImpl<Amp>(Amp::class.java, couchDbProperties, couchDbDispatcher, idGenerator), AmpDAO {

	companion object {
		const val ampPaginationLimit = 101
	}

	@View(name = "by_dmppcode", map = "classpath:js/amp/By_dmppcode.js")
	override fun findAmpsByDmppCode(dmppCode: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView(
				createQuery<Amp>("by_dmppcode")
					.startKey(dmppCode)
					.endKey(dmppCode)
					.includeDocs(true)
					.limit(ampPaginationLimit),
				String::class.java, String::class.java, Amp::class.java
			)
		)
	}

	@View(name = "by_ampcode", map = "classpath:js/amp/By_ampcode.js")
	override fun findAmpsByAmpCode(ampCode: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView(
				createQuery<Amp>("by_ampcode")
					.startKey(ampCode)
					.endKey(ampCode)
					.includeDocs(true)
					.limit(ampPaginationLimit),
				String::class.java, String::class.java, Amp::class.java
			)
		)
	}

	@View(name = "by_groupcode", map = "classpath:js/amp/By_groupcode.js")
	override fun findAmpsByVmpGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Amp, String>("by_groupcode", vmpgCode, vmpgCode, paginationOffset.copy(limit = paginationOffset.limit.coerceAtMost(ampPaginationLimit)), false), String::class.java, String::class.java, Amp::class.java))
	}

	@View(name = "by_atc", map = "classpath:js/amp/By_atc.js")
	override fun findAmpsByAtc(atc: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Amp, String>("by_atc", atc, atc, paginationOffset.copy(limit = paginationOffset.limit.coerceAtMost(ampPaginationLimit)), false), String::class.java, String::class.java, Amp::class.java))
	}

	@View(name = "by_groupid", map = "classpath:js/amp/By_groupid.js")
	override fun findAmpsByVmpGroupId(vmpgId: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Amp, String>("by_groupid", vmpgId, vmpgId, paginationOffset.copy(limit = paginationOffset.limit.coerceAtMost(ampPaginationLimit)), false), String::class.java, String::class.java, Amp::class.java))
	}

	@View(name = "by_vmpcode", map = "classpath:js/amp/By_vmpcode.js")
	override fun findAmpsByVmpCode(vmpCode: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Amp, String>("by_vmpcode", vmpCode, vmpCode, paginationOffset.copy(limit = paginationOffset.limit.coerceAtMost(ampPaginationLimit)), false), String::class.java, String::class.java, Amp::class.java))
	}

	@View(name = "by_vmpid", map = "classpath:js/amp/By_vmpid.js")
	override fun findAmpsByVmpId(vmpId: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Amp, String>("by_vmpid", vmpId, vmpId, paginationOffset, false), String::class.java, String::class.java, Amp::class.java))
	}

	override fun listAmpIdsByVmpGroupCode(vmpgCode: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Amp>("by_groupcode")
					.startKey(vmpgCode)
					.endKey(vmpgCode)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listAmpIdsByVmpGroupId(vmpgId: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Amp>("by_groupid")
					.startKey(vmpgId)
					.endKey(vmpgId)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listAmpIdsByVmpCode(vmpCode: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Amp>("by_code")
					.startKey(vmpCode)
					.endKey(vmpCode)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listAmpIdsByVmpId(vmpId: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Amp>("by_id")
					.startKey(vmpId)
					.endKey(vmpId)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listAmpsByVmpGroupCodes(vmpgCodes: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Amp>(
				createQuery<Amp>("by_groupcode")
					.keys(vmpgCodes)
					.reduce(false)
					.includeDocs(true)
					.limit(ampPaginationLimit)
			).map { it.doc }
		)
	}

	override fun listAmpsByDmppCodes(dmppCodes: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Amp>(
				createQuery<Amp>("by_dmppcode")
					.keys(dmppCodes)
					.reduce(false)
					.includeDocs(true)
					.limit(ampPaginationLimit)
			).map { it.doc }
		)
	}

	override fun listAmpsByVmpGroupIds(vmpGroupIds: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Amp>(
				createQuery<Amp>("by_groupid")
					.keys(vmpGroupIds)
					.reduce(false)
					.includeDocs(true)
					.limit(ampPaginationLimit)
			).map { it.doc }
		)
	}

	override fun listAmpsByVmpCodes(vmpCodes: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Amp>(
				createQuery<Amp>("by_vmpcode")
					.keys(vmpCodes)
					.reduce(false)
					.includeDocs(true)
					.limit(ampPaginationLimit)
			).map { it.doc }
		)
	}

	override fun listAmpsByVmpIds(vmpIds: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Amp>(
				createQuery<Amp>("by_vmpid")
					.keys(vmpIds)
					.reduce(false)
					.includeDocs(true)
					.limit(ampPaginationLimit)
			).map { it.doc }
		)
	}

	override suspend fun getVersion() = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		.get("org.taktik.icure.samv2", SamVersion::class.java)

	override suspend fun getSignature(clazz: String) = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		.get("org.taktik.icure.samv2.signatures.$clazz", SamVersion::class.java)

	override suspend fun getProductIdsFromSignature(type: String): Map<String, String> {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))

		return client.get("org.taktik.icure.samv2.signatures.$type", SamVersion::class.java)?.let { samVersion ->
			GZIPInputStream(client.getAttachment(samVersion.id, "signatures", samVersion.rev).toInputStream()).reader(Charsets.UTF_8).useLines {
				it.fold(HashMap()) { acc, l -> acc.also { l.split('|').let { parts -> acc[parts[0]] = parts[1] } } }
			}
		} ?: throw IllegalArgumentException("Signature $type does not exist")
	}

	@View(name = "by_language_label", map = "classpath:js/amp/By_language_label.js")
	override fun findAmpsByLabel(language: String?, label: String?, pagination: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))

		val (from, to) = makeFromTo(label, language)
		val viewQuery = pagedViewQuery<Amp, ComplexKey>(
			"by_language_label",
			from,
			to,
			pagination.toPaginationOffset { sk -> ComplexKey.of(*sk.mapIndexed { i, s -> if (i == 1) sanitizeString(s) else s }.toTypedArray()) }.let {
			  it.copy(limit = it.limit.coerceAtMost(ampPaginationLimit))
			},
			false
		)
		emitAll(client.queryView(viewQuery, ComplexKey::class.java, String::class.java, Amp::class.java))
	}

	@View(name = "by_chapter_paragraph", map = "classpath:js/amp/By_chapter_paragraph.js")
	override fun findAmpsByChapterParagraph(chapter: String, paragraph: String, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))

		val viewQuery = pagedViewQuery<Amp, ComplexKey>(
			"by_chapter_paragraph",
			ComplexKey.of(chapter, paragraph),
			ComplexKey.of(chapter, paragraph),
			paginationOffset.toPaginationOffset { sk -> ComplexKey.of(*sk.mapIndexed { i, s -> if (i == 1) sanitizeString(s) else s }.toTypedArray()) },
			false
		)
		emitAll(client.queryView(viewQuery, ComplexKey::class.java, Int::class.java, Amp::class.java))
	}

	override fun listAmpIdsByLabel(language: String?, label: String?): Flow<String> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		val (from, to) = makeFromTo(label, language)
		val viewQuery = createQuery<Amp>("by_language_label")
			.startKey(from)
			.endKey(to)
			.reduce(false)
			.includeDocs(false)
		emitAll(client.queryView<ComplexKey, String>(viewQuery).map { it.id })
	}
}
