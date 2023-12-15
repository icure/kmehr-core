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
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.taktik.couchdb.Client
import org.taktik.couchdb.ClientImpl
import org.taktik.couchdb.create
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.couchdb.springframework.webclient.SpringWebfluxWebClient
import org.taktik.couchdb.update
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.AmpDAOImpl
import org.taktik.icure.asynclogic.datastore.IDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.DatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.MultiDatastoreInformation
import org.taktik.icure.be.samv2v5.entities.CommentedClassificationDataType
import org.taktik.icure.be.samv2v5.entities.CommentedClassificationFullDataType
import org.taktik.icure.be.samv2v5.entities.ExportActualMedicinesType
import org.taktik.icure.be.samv2v5.entities.ExportChapterIVType
import org.taktik.icure.be.samv2v5.entities.ExportNonMedicinalType
import org.taktik.icure.be.samv2v5.entities.ExportReimbursementsType
import org.taktik.icure.be.samv2v5.entities.ExportVirtualMedicinesType
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.entities.samv2.SamVersion
import org.taktik.icure.entities.samv2.embed.CommentedClassification
import org.taktik.icure.entities.samv2.embed.Reimbursement
import org.taktik.icure.entities.samv2.embed.SamText
import org.taktik.icure.entities.samv2.stub.VmpStub
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.GzipDeflateInputStream
import org.taktik.icure.utils.NoCloseInputStream
import org.taktik.icure.utils.toFlow
import java.net.URI
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.bind.JAXBContext
import kotlin.system.exitProcess

fun commentedClassificationMapper(cc: CommentedClassificationFullDataType): CommentedClassification? = cc.data.maxByOrNull { d: CommentedClassificationDataType -> d.from.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null).timeInMillis }?.let { lcc ->
	CommentedClassification(
		lcc.title?.let { SamText(it.fr, it.nl, it.de, it.en) },
		lcc.url?.let { SamText(it.fr, it.nl, it.de, it.en) },
		cc.commentedClassification?.mapNotNull { cc -> commentedClassificationMapper(cc) }?.toSet() ?: setOf()
	)
}

@Suppress("NestedLambdaShadowedImplicitParameter")
class Samv2v5Import : CliktCommand() {
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
	private val chapivDbName: String by option(help = "The database name for chap IV data").default("chapiv")
	private val checksearch: String? by option(help = "Search for those entries at the end")
	private val update: String by option(help = "Force update of existing entries").prompt("Force update")

	@OptIn(ExperimentalCoroutinesApi::class)
	override fun run() {
		val couchDbProperties = object : CouchDbProperties {
			override var username: String? = this@Samv2v5Import.username
			override var password: String? = this@Samv2v5Import.password
			override var url = this@Samv2v5Import.url

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
		val drugsDouchDbDispatcher = object : CouchDbDispatcher {
			var cl: Client? = null
			override suspend fun getClient(datastoreInformation: IDatastoreInformation, retry: Int): Client =
				cl ?: when(datastoreInformation) {
					is DatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(chapivDbName), username, password, objectMapper)
					is GlobalDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(chapivDbName), username, password, objectMapper)
					is MultiDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrls.first().addSinglePathComponent(chapivDbName), username, password, objectMapper)
					else -> { throw IllegalArgumentException("Unknown datastoreInformation type ${datastoreInformation::class.simpleName}") }
				}.also { cl = it }
		}
		val chapivCouchDbDispatcher = object : CouchDbDispatcher {
			var cl: Client? = null
			override suspend fun getClient(datastoreInformation: IDatastoreInformation, retry: Int): Client =
				cl ?: when(datastoreInformation) {
					is DatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(chapivDbName), username, password, objectMapper)
					is GlobalDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(chapivDbName), username, password, objectMapper)
					is MultiDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrls.first().addSinglePathComponent(chapivDbName), username, password, objectMapper)
					else -> { throw IllegalArgumentException("Unknown datastoreInformation type ${datastoreInformation::class.simpleName}") }
				}.also { cl = it }

		}

		val updateExistingDocs = (update == "true" || update == "yes")
		val reimbursements: MutableMap<Triple<String?, String?, String?>, MutableSet<Reimbursement>> = HashMap()
		val vmps: MutableMap<String, VmpStub> = HashMap()
		var vers: String? = null
		var fileName: String? = null
		val ampProductIds = HashMap<String, String>()
		val nmpProductIds = HashMap<String, String>()
		val vmpProductIds = HashMap<String, String>()

		val dbInstanceUri = URI(couchDbProperties.url)

		val zipData = if (samv2url == null) URI("https://www.vas.ehealth.fgov.be/websamcivics/samcivics/download/samv2-full-getLastVersion?xsd=5").toURL().readBytes().toString(Charsets.UTF_8).let {
			URI("https://www.vas.ehealth.fgov.be/websamcivics/samcivics/download/samv2-download?type=full&version=$it&xsd=5").toURL().openConnection().let { conn ->
				fileName = (
					conn.headerFields["Content-Disposition"]
						?: conn.headerFields["content-disposition"]
					)?.let { it[0].replace(Regex("attachment;filename=\"(.+)\""), "$1") }
				conn.getInputStream().readBytes()
			}
		} else null

		val updatedAmpIds: MutableSet<String> = mutableSetOf()
		val versionDate = fileName?.replace(Regex("([0-9]{4})-([0-9]{4})-([0-9]{2})-([0-9]{2})-([0-9]{2})-([0-9]{2})-([0-9]{2})\\.zip"), "$2$3$4")?.toInt()
			?: 99999999
		(zipData?.inputStream() ?: samv2url?.let { URI(it).toURL().openStream() })?.let { zis ->
			val zip = ZipInputStream(zis)
			var entry: ZipEntry?
			while (zip.let { entry = it.nextEntry; entry != null }) {
				when {
					entry!!.name.startsWith("CHAPTERIV") ->
						(JAXBContext.newInstance(ExportChapterIVType::class.java).createUnmarshaller().unmarshal(
							NoCloseInputStream(zip)
						) as? ExportChapterIVType)?.let {
							runBlocking(Dispatchers.IO) {
								ChapterIVImporter().importChapterIV(it, couchDbProperties, chapivCouchDbDispatcher, updateExistingDocs)
							}
						}
					entry!!.name.startsWith("VMP") ->
						(JAXBContext.newInstance(ExportVirtualMedicinesType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportVirtualMedicinesType)?.let {
							runBlocking(Dispatchers.IO) {
								VirtualMedicineImporter().importVirtualMedicines(it, vmps, couchDbProperties, drugsDouchDbDispatcher, updateExistingDocs).let { (pids, ids) ->
									vmpProductIds.putAll(pids)
									log.warn("Updated ${ids.size} VMPs")
								}
							}
						}
					entry!!.name.startsWith("RMB") ->
						(JAXBContext.newInstance(ExportReimbursementsType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportReimbursementsType)?.let {
							runBlocking(Dispatchers.IO) {
								ReimbursementImporter().importReimbursements(it, reimbursements, couchDbProperties, drugsDouchDbDispatcher).let { ids ->
									updatedAmpIds.addAll(ids)
								}
							}
						}
					entry!!.name.startsWith("NONMEDICINAL") ->
						(JAXBContext.newInstance(ExportNonMedicinalType::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? ExportNonMedicinalType)?.let {
							runBlocking(Dispatchers.IO) {
								NonMedicinalImporter().importNonMedicinals(it, couchDbProperties, drugsDouchDbDispatcher, updateExistingDocs).let { (pids, ids) ->
									nmpProductIds.putAll(pids)
									log.warn("Updated ${ids.size} NMPs")
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
								vers = it.samId
								ActualMedicineImporter().importActualMedicines(it, vmps, reimbursements, couchDbProperties, drugsDouchDbDispatcher, updateExistingDocs).let { (pids, ids) ->
									ampProductIds.putAll(pids)
									updatedAmpIds.addAll(ids)
									log.warn("Updated ${updatedAmpIds.size} AMPs")
								}
							}
						}
				}
			}
		}

		runBlocking {
			val client = drugsDouchDbDispatcher.getClient(GlobalDatastoreInformation(dbInstanceUri))
			val ampDAO = AmpDAOImpl(couchDbProperties, drugsDouchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }

			val samVersion = ampDAO.getVersion()
			samVersion?.let { client.update(it.copy(version = vers, date = versionDate)) }
				?: client.create(SamVersion(id = "org.taktik.icure.samv2", version = vers, date = versionDate))

			(
				ampDAO.getSignature("nmp")?.let { client.update(it.copy(version = vers, date = versionDate)) }
					?: client.create(SamVersion(id = "org.taktik.icure.samv2.signatures.nmp", version = vers, date = versionDate))
				)
				.let { client.createAttachment(it.id, "signatures", it.rev!!, "application/gzip", makeSignatures(nmpProductIds)) }

			(
				ampDAO.getSignature("amp")?.let { client.update(it.copy(version = vers, date = versionDate)) }
					?: client.create(SamVersion(id = "org.taktik.icure.samv2.signatures.amp", version = vers, date = versionDate))
				).let { client.createAttachment(it.id, "signatures", it.rev!!, "application/gzip", makeSignatures(ampProductIds)) }

			(
				ampDAO.getSignature("vmp")?.let { client.update(it.copy(version = vers, date = versionDate)) }
					?: client.create(SamVersion(id = "org.taktik.icure.samv2.signatures.vmp", version = vers, date = versionDate))
				).let { client.createAttachment(it.id, "signatures", it.rev!!, "application/gzip", makeSignatures(vmpProductIds)) }

			checksearch?.takeIf { it.isNotBlank() }?.split(",")?.forEach {
				if (retry(5) { ampDAO.findAmpsByLabel("fr", it, PaginationOffset(limit = 10)).toList() }.isEmpty()) {
					log.error("Check search failed for $it aborting")
					exitProcess(1)
				} else {
					log.info("Found $it in New SAM")
				}
			}
		}
	}

	private fun makeSignatures(nmpProductIds: HashMap<String, String>) =
		GzipDeflateInputStream(
			nmpProductIds.entries.sortedBy { it.key }
				.map { "${it.key}|${it.value}" }
				.joinToString("\n")
				.byteInputStream(Charsets.UTF_8)
		).toFlow()

	private suspend fun <E> retry(count: Int, executor: suspend () -> E): E {
		return try {
			executor()
		} catch (e: Exception) {
			if (count > 0) retry(count - 1, executor) else throw e
		}
	}

	class VaccineCode {
		var cnk: String? = null
		var codes: List<String> = listOf()
	}
}
