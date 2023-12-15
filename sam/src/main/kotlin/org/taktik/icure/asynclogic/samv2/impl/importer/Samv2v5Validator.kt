/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asynclogic.samv2.impl.importer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import io.icure.asyncjacksonhttpclient.net.addSinglePathComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.taktik.couchdb.Client
import org.taktik.couchdb.ClientImpl
import org.taktik.couchdb.springframework.webclient.SpringWebfluxWebClient
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asynclogic.datastore.IDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.DatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.MultiDatastoreInformation
import org.taktik.icure.be.samv2v5.entities.ExportActualMedicinesType
import org.taktik.icure.be.samv2v5.entities.ExportReimbursementsType
import org.taktik.icure.be.samv2v5.entities.ExportVirtualMedicinesType
import org.taktik.icure.entities.samv2.embed.Reimbursement
import org.taktik.icure.entities.samv2.stub.VmpStub
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.Diff
import org.taktik.icure.utils.NoCloseInputStream
import java.net.URI
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.bind.JAXBContext

class Samv2v5Validate : CliktCommand() {
	private val objectMapper: ObjectMapper = ObjectMapper().registerModule(
		KotlinModule.Builder()
			.configure(KotlinFeature.NullIsSameAsDefault, true)
			.build()
	)
	private val log: Logger = LoggerFactory.getLogger(this::class.java)

	private val samv2url: String? by option(help = "The url of the zip file")
	private val url: String by option(help = "The database server to connect to").prompt("Database server url")
	private val username: String by option(help = "The Username").prompt("Username")
	private val password: String by option(help = "The Password").prompt("Password")
	private val dbName: String by option(help = "The database name").default("drugs")
	private val update: String by option(help = "Force update of existing entries").prompt("Force update")

	@OptIn(ExperimentalCoroutinesApi::class)
	override fun run() {
		val couchDbProperties = object : CouchDbProperties {
			override var username: String? = this@Samv2v5Validate.username
			override var password: String? = this@Samv2v5Validate.password
			override var url = this@Samv2v5Validate.url

			override var autoUpdateViewOnChange: Boolean = false
			var prefix: String = ""
			override var altUrls: String = ""
			override var maxConnections: Int = 500
			override var socketTimeout: Int = 60_000
			override var desingDocumentStatusCheckTimeoutMilliseconds: Long = 2000
			override var cachedDesignDocumentTtlMinutes: Long = 15
			override fun knownServerUrls() = if (altUrls.isBlank()) listOf(url) else altUrls.split(";").let { if (it.contains(url)) it else listOf(url) + it }
			override fun knownServerUris() = knownServerUrls().map { URI(it) }
			override fun preferredServerUrlForNewlyRegisteredDatabase() = knownServerUrls().last()
		}

		val httpClient = SpringWebfluxWebClient()
		val couchDbDispatcher = object : CouchDbDispatcher {
			var cl: Client? = null
			override suspend fun getClient(datastoreInformation: IDatastoreInformation, retry: Int): Client =
				cl ?: when(datastoreInformation) {
					is DatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(dbName), username, password, objectMapper)
					is GlobalDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(dbName), username, password, objectMapper)
					is MultiDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrls.first().addSinglePathComponent(dbName), username, password, objectMapper)
					else -> { throw IllegalArgumentException("Unknown datastoreInformation type ${datastoreInformation::class.simpleName}") }
				}.also { cl = it }
		}
		val reimbursements: MutableMap<Triple<String?, String?, String?>, MutableSet<Reimbursement>> = HashMap()
		val vmps: MutableMap<String, VmpStub> = HashMap()

		val zipData = if (samv2url == null) URI("https://www.vas.ehealth.fgov.be/websamcivics/samcivics/download/samv2-full-getLastVersion?xsd=5").toURL().readBytes().toString(Charsets.UTF_8).let {
			URI("https://www.vas.ehealth.fgov.be/websamcivics/samcivics/download/samv2-download?type=full&version=$it&xsd=5").toURL().openConnection()
				.getInputStream().readBytes()
		} else null

		val diffs: MutableSet<Diff> = mutableSetOf()

		(zipData?.inputStream() ?: samv2url?.let { URI(it).toURL().openStream() })?.let { zis ->
			val zip = ZipInputStream(zis)
			var entry: ZipEntry?
			while (zip.let { entry = it.nextEntry; entry != null }) {
				when {
					entry!!.name.startsWith("VMP") ->
						(JAXBContext.newInstance(ExportVirtualMedicinesType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportVirtualMedicinesType)?.let {
							runBlocking(Dispatchers.IO) {
								VirtualMedicineValidator().scanVirtualMedicines(it, vmps)
							}
						}
					entry!!.name.startsWith("RMB") ->
						(JAXBContext.newInstance(ExportReimbursementsType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportReimbursementsType)?.let {
							runBlocking(Dispatchers.IO) {
								ReimbursementValidator().validateReimbursements(it, reimbursements, couchDbProperties, couchDbDispatcher).let { ids ->
									diffs.addAll(ids)
								}
							}
						}
				}
			}
		}

		(zipData?.inputStream() ?: samv2url?.let { URI(it).toURL().openStream() })?.let { zis ->
			val zip = ZipInputStream(zis)
			var entry: ZipEntry?
			while (zip.let { entry = it.nextEntry; entry != null }) {
				when {
					entry!!.name.startsWith("AMP") ->
						runBlocking(Dispatchers.IO) {
							(JAXBContext.newInstance(ExportActualMedicinesType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportActualMedicinesType)?.let {
								diffs.addAll(ActualMedicineValidator().validateActualMedicines(it, vmps, reimbursements, couchDbProperties, couchDbDispatcher))
							}
						}
				}
			}
		}
		diffs.forEach { log.info(it.toString("")) }
	}
}
