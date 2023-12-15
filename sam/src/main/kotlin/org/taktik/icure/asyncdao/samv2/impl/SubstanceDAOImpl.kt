/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asyncdao.samv2.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import org.taktik.couchdb.annotation.View
import org.taktik.couchdb.id.IDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.impl.InternalDAOImpl
import org.taktik.icure.asyncdao.samv2.SubstanceDAO
import org.taktik.icure.entities.samv2.Substance
import org.taktik.icure.properties.CouchDbProperties

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@Repository("substanceDAO")
@Profile("sam")
@View(name = "all", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.samv2.embed.Substance') emit( null, doc._id )}")
class SubstanceDAOImpl(couchDbProperties: CouchDbProperties, @Qualifier("drugCouchDbDispatcher") couchDbDispatcher: CouchDbDispatcher, idGenerator: IDGenerator) : InternalDAOImpl<Substance>(Substance::class.java, couchDbProperties, couchDbDispatcher, idGenerator), SubstanceDAO
