/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asyncdao.samv2.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URI
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
import org.taktik.icure.asyncdao.samv2.NmpDAO
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.db.sanitizeString
import org.taktik.icure.entities.samv2.Nmp
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.createQuery
import org.taktik.icure.utils.pagedViewQuery

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@Repository("nmpDAO")
@Profile("sam")
@View(name = "all", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.samv2.Nmp' && !doc.deleted) emit( null, doc._id )}")
class NmpDAOImpl(couchDbProperties: CouchDbProperties, @Qualifier("drugCouchDbDispatcher") couchDbDispatcher: CouchDbDispatcher, idGenerator: IDGenerator) : InternalDAOImpl<Nmp>(Nmp::class.java, couchDbProperties, couchDbDispatcher, idGenerator), NmpDAO {
	@View(name = "by_language_label", map = "classpath:js/nmp/By_language_label.js")
	override fun findNmpsByLabel(language: String?, label: String?, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		val sanitizedLabel = label?.let { sanitizeString(it) }
		val from = ComplexKey.of(
			language ?: "\u0000",
			sanitizedLabel ?: "\u0000"
		)
		val to = ComplexKey.of(
			language ?: ComplexKey.emptyObject(),
			if (sanitizedLabel == null) ComplexKey.emptyObject() else sanitizedLabel + "\ufff0"
		)
		val viewQuery = pagedViewQuery<Nmp, ComplexKey>(
			"by_language_label",
			from,
			to,
			paginationOffset.toPaginationOffset { sk -> ComplexKey.of(*sk.mapIndexed { i, s -> if (i == 1) sanitizeString(s) else s }.toTypedArray()) },
			false
		)
		emitAll(client.queryView(viewQuery, ComplexKey::class.java, String::class.java, Nmp::class.java))
	}

	override fun listNmpIdsByLabel(language: String?, label: String?): Flow<String> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		val sanitizedLabel = label?.let { sanitizeString(it) }
		val from = ComplexKey.of(
			language ?: "\u0000",
			sanitizedLabel ?: "\u0000"
		)
		val to = ComplexKey.of(
			language ?: ComplexKey.emptyObject(),
			if (sanitizedLabel == null) ComplexKey.emptyObject() else sanitizedLabel + "\ufff0"
		)
		val viewQuery = createQuery<Nmp>("by_language_label")
			.startKey(from)
			.endKey(to)
			.reduce(false)
			.includeDocs(false)
		emitAll(client.queryView<ComplexKey, String>(viewQuery).map { it.id })
	}

	@View(name = "by_cnk", map = "classpath:js/nmp/By_cnk.js")
	override fun listNmpsByCnks(cnks: List<String>): Flow<Nmp> = flow {
		val client = couchDbDispatcher.getClient(GlobalDatastoreInformation(URI(couchDbProperties.url)))
		val viewQuery = createQuery<Nmp>("by_cnk")
			.keys(cnks)
			.reduce(false)
			.includeDocs(true)
		emitAll(client.queryViewIncludeDocs<String, Int, Nmp>(viewQuery).map { it.doc })
	}
}
