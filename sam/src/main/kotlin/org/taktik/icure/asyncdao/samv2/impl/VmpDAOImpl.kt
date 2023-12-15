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
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import org.taktik.couchdb.annotation.View
import org.taktik.couchdb.entity.ComplexKey
import org.taktik.couchdb.id.IDGenerator
import org.taktik.couchdb.queryView
import org.taktik.couchdb.queryViewIncludeDocs
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.impl.InternalDAOImpl
import org.taktik.icure.asyncdao.samv2.VmpDAO
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.db.sanitizeString
import org.taktik.icure.entities.samv2.Vmp
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.createQuery
import org.taktik.icure.utils.makeFromTo
import org.taktik.icure.utils.pagedViewQuery
import java.net.URI

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@Repository("vmpDAO")
@Profile("sam")
@View(name = "all", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.samv2.Vmp' && !doc.deleted) emit( null, doc._id )}")
class VmpDAOImpl(couchDbProperties: CouchDbProperties, @Qualifier("drugCouchDbDispatcher") couchDbDispatcher: CouchDbDispatcher, idGenerator: IDGenerator) : InternalDAOImpl<Vmp>(Vmp::class.java, couchDbProperties, couchDbDispatcher, idGenerator), VmpDAO {
	private val log = LoggerFactory.getLogger(javaClass)

	@View(name = "by_groupcode", map = "classpath:js/vmp/By_groupcode.js")
	override fun findVmpsByGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Vmp, String>("by_groupcode", vmpgCode, vmpgCode, paginationOffset, false), String::class.java, String::class.java, Vmp::class.java))
	}

	@View(name = "by_vmpcode", map = "classpath:js/vmp/By_vmpcode.js")
	override fun findVmpsByVmpCode(vmpCode: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Vmp, String>("by_vmpcode", vmpCode, vmpCode, paginationOffset, false), String::class.java, String::class.java, Vmp::class.java))
	}

	@View(name = "by_language_label", map = "classpath:js/vmp/By_language_label.js")
	override fun findVmpsByLabel(language: String?, label: String?, pagination: PaginationOffset<List<String>>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			makeFromTo(label, language).let { (from, to) ->
				client.queryView(
					pagedViewQuery<Vmp, ComplexKey>(
						"by_language_label",
						from,
						to,
						pagination.toPaginationOffset { sk -> ComplexKey.of(*sk.mapIndexed { i, s -> if (i == 1) sanitizeString(s) else s }.toTypedArray()) },
						false
					),
					ComplexKey::class.java, String::class.java, Vmp::class.java
				)
			}
		)
	}

	@View(name = "by_groupid", map = "classpath:js/vmp/By_groupid.js")
	override fun findVmpsByGroupId(vmpgId: String, paginationOffset: PaginationOffset<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(client.queryView(pagedViewQuery<Vmp, String>("by_groupid", vmpgId, vmpgId, paginationOffset, false), String::class.java, String::class.java, Vmp::class.java))
	}

	override fun listVmpIdsByGroupCode(vmpgCode: String) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Vmp>("by_groupcode")
					.startKey(vmpgCode)
					.endKey(vmpgCode)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listVmpIdsByGroupId(vmpgId: String): Flow<String> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryView<String, String>(
				createQuery<Vmp>("by_groupid")
					.startKey(vmpgId)
					.endKey(vmpgId)
					.reduce(false)
					.includeDocs(false)
			).map { it.id }
		)
	}

	override fun listVmpIdsByLabel(language: String?, label: String?) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			makeFromTo(label, language).let { (from, to) ->
				client.queryView<ComplexKey, String>(
					createQuery<Vmp>("by_language_label")
						.startKey(from)
						.endKey(to)
						.reduce(false)
						.includeDocs(false)
				).map { it.id }
			}
		)
	}

	override fun listVmpsByVmpCodes(vmpCodes: List<String>): Flow<Vmp> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Vmp>(
				createQuery<Vmp>("by_vmpcode")
					.keys(vmpCodes)
					.reduce(false)
					.includeDocs(true)
			).map { it.doc }
		)
	}

	override fun listVmpsByGroupIds(vmpgIds: List<String>) = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		emitAll(
			client.queryViewIncludeDocs<String, Int, Vmp>(
				createQuery<Vmp>("by_groupid")
					.keys(vmpgIds)
					.reduce(false)
					.includeDocs(true)
			).map { it.doc }
		)
	}
}
