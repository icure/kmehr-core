package org.taktik.icure.asynclogic.be.inami.importer

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import io.icure.asyncjacksonhttpclient.net.addSinglePathComponent
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.persistentHashMapOf
import kotlinx.collections.immutable.persistentHashSetOf
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentHashMap
import kotlinx.collections.immutable.toPersistentSet
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.taktik.couchdb.Client
import org.taktik.couchdb.ClientImpl
import org.taktik.couchdb.bulkUpdate
import org.taktik.couchdb.queryViewIncludeDocs
import org.taktik.couchdb.springframework.webclient.SpringWebfluxWebClient
import org.taktik.couchdb.update
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asynclogic.be.inami.importer.domain.NomenFeeCode
import org.taktik.icure.asynclogic.be.inami.importer.domain.NomensoftTarification
import org.taktik.icure.asynclogic.be.inami.importer.domain.Rubric
import org.taktik.icure.asynclogic.be.inami.importer.domain.Table
import org.taktik.icure.asynclogic.datastore.IDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.DatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.GlobalDatastoreInformation
import org.taktik.icure.asynclogic.datastore.impl.MultiDatastoreInformation
import org.taktik.icure.entities.Group
import org.taktik.icure.entities.Tarification
import org.taktik.icure.entities.embed.LetterValue
import org.taktik.icure.entities.embed.Valorisation
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.FuzzyValues
import org.taktik.icure.utils.NoCloseInputStream
import org.taktik.icure.utils.createQuery
import java.net.URI
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.bind.JAXBContext

class InamiImport : CliktCommand() {
	private val objectMapper: ObjectMapper = ObjectMapper().registerModule(
		KotlinModule.Builder()
			.configure(KotlinFeature.NullIsSameAsDefault, true)
			.build()
	)
	private val log: Logger = LoggerFactory.getLogger(this::class.java)

	private val inamiUrl: String by option(help = "The url of the inami zip file").default("https://www.inami.fgov.be/SiteCollectionDocuments/XML.ZIP")
	private val url: String by option(help = "The database server to connect to").prompt("Database server url")
	private val workers: String by option(help = "The // workers").default("10")
	private val username: String by option(help = "The Username").prompt("Username")
	private val password: String by option(help = "The Password").prompt("Password")
	private val configDbName: String by option(help = "The database name").default("icure-__-config")
	private val dbName: String by option(help = "The database name").default("icure-{}-base")
	private val year: String by option(help = "The year").default(LocalDate.now().year.toString())
	private val groupsRegex: String? by option(help = "A regex to filter the groups")
	private val farFutureCal = LocalDateTime.of(3999, 12, 31, 23, 59, 59, 999999999)

	@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
	override fun run() {
		val couchDbProperties = object : CouchDbProperties {
			override var username: String? = this@InamiImport.username
			override var password: String? = this@InamiImport.password
			override var url = this@InamiImport.url

			override var autoUpdateViewOnChange: Boolean = false
			override var altUrls: String = ""
			override var maxConnections: Int = 500
			override var socketTimeout: Int = 60_000
			override var desingDocumentStatusCheckTimeoutMilliseconds: Long = 2000
			override var cachedDesignDocumentTtlMinutes: Long = 15
			override fun knownServerUrls() = if (altUrls.isBlank()) listOf(url) else altUrls.split(";").let { if (it.contains(url)) it else listOf(url) + it }
			override fun knownServerUris() = knownServerUrls().map { URI(it) }
			override fun preferredServerUrlForNewlyRegisteredDatabase() = knownServerUrls().last()
		}

		data class TarificationCodeInfo(
			val code: String,
			val prescriber: Boolean,
			val relatedCode: Boolean,
			val relatedCodes: List<String>,
		)

		log.info("Starting process with $workers workers")

		val tarificationInfos = this::class.java.getResourceAsStream("prescriberRelatedCodes.json")
			?.let { objectMapper.readValue(it, object : TypeReference<List<TarificationCodeInfo>>() {}) }
			?.fold(persistentHashMapOf<String, TarificationCodeInfo>()) { map, tci -> map.put(tci.code, tci) }
			?: emptyMap()

		val httpClient = SpringWebfluxWebClient()
		fun configCouchDbDispatcher() = object : CouchDbDispatcher {
			var cl: Client? = null
			override suspend fun getClient(datastoreInformation: IDatastoreInformation, retry: Int): Client =
				cl ?: when(datastoreInformation) {
					is DatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(configDbName), username, password, objectMapper)
					is GlobalDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(configDbName), username, password, objectMapper)
					is MultiDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrls.first().addSinglePathComponent(configDbName), username, password, objectMapper)
					else -> { throw IllegalArgumentException("Unknown datastoreInformation type ${datastoreInformation::class.simpleName}") }
				}.also { cl = it }
		}

		fun baseCouchDbDispatcher() = object : CouchDbDispatcher {
			var cl: Client? = null
			override suspend fun getClient(datastoreInformation: IDatastoreInformation, retry: Int): Client =
				cl ?: when(datastoreInformation) {
					is DatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(dbName.replace("{}", datastoreInformation.groupId ?: "")), username, password, objectMapper)
					is GlobalDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrl.addSinglePathComponent(dbName.replace("{}", "")), username, password, objectMapper)
					is MultiDatastoreInformation -> ClientImpl(httpClient, datastoreInformation.dbInstanceUrls.first().addSinglePathComponent(dbName.replace("{}", datastoreInformation.groupId ?: "")), username, password, objectMapper)
					else -> { throw IllegalArgumentException("Unknown datastoreInformation type ${datastoreInformation::class.simpleName}") }
				}.also { cl = it }
		}

		val dbInstanceUri = URI(couchDbProperties.url)

		val zipInputStream = URI(inamiUrl).toURL().openConnection().getInputStream()

		zipInputStream?.let { zis ->
			val zip = ZipInputStream(zis)
			var entry: ZipEntry?

			var groups: Map<String, Rubric> = persistentHashMapOf()
			var fees: Map<Int, NomenFeeCode> = persistentHashMapOf()
			var unknowns: Map<String, Int> = persistentHashMapOf()
			var tarifications: PersistentMap<String, NomensoftTarification> = persistentHashMapOf()

			while (zip.let { entry = it.nextEntry; entry != null }) {
				when {
					entry!!.name.uppercase().let { it.contains("NOMEN_SUMMARY_EXT.XML") && it.endsWith(".XML") } ->
						(JAXBContext.newInstance(Table::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? Table)?.let { table ->
							runBlocking(Dispatchers.IO) {
								importGroups(table, tarifications).let { groups = it.first; tarifications = it.second }
							}
						}
					entry!!.name.uppercase().contains("NOMEN_FEECODES.XML") ->
						(JAXBContext.newInstance(Table::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? Table)?.let { table ->
							runBlocking(Dispatchers.IO) {
								importFees(table, tarifications).let { fees = it.first; tarifications = it.second; unknowns = it.third }
							}
						}
					entry!!.name.uppercase().let { it.contains("NOMEN_CODE_FEE_") && it.endsWith(".XML") } ->
						(JAXBContext.newInstance(Table::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? Table)?.let { table ->
							runBlocking(Dispatchers.IO) {
								importCodeFees(table, tarifications, fees).let { tarifications = it }
							}
						}
					entry!!.name.uppercase().contains("NOMEN_FEECODES_CAT.XML") ->
						(JAXBContext.newInstance(Table::class.java).createUnmarshaller().unmarshal(NoCloseInputStream(zip)) as? Table)?.let { table ->
							runBlocking(Dispatchers.IO) {
								if (table.nomenFeeCodesCat.map { it.feeCodeCat }.sorted().joinToString("") != "010203040506071314") {
									throw RuntimeException("NOMEN_FEECODES_CAT.XML has changed")
								}
							}
						}
				}
			}

			runBlocking(Dispatchers.IO) {
				val pool = newFixedThreadPoolContext(workers.toInt(), "Importer.pool")
				val cClient = configCouchDbDispatcher().getClient(GlobalDatastoreInformation(dbInstanceUri))
				val dbs = cClient.queryViewIncludeDocs<String, String, Group>(
					createQuery<Group>("all").includeDocs(true)
				).mapNotNull { it.doc }.toList()

				val regex = groupsRegex?.toPattern()
				val filteredDbs = dbs.filter { regex?.matcher(it.id)?.matches() ?: true }
				val awaits = filteredDbs.chunked((filteredDbs.size / workers.toInt()).coerceAtLeast(1)).mapIndexed { idx, dbs ->
					log.info("Launching thread $idx with ${dbs.size} dbs")
					async(pool) {
						dbs.forEachIndexed { dbIdx, db ->
							log.info("Treating ${db.id} in Thread $idx. ($dbIdx/${dbs.size})" )
							try {
								val client = baseCouchDbDispatcher().getClient(DatastoreInformation(
									db.servers?.firstOrNull()?.let { URI(it) } ?: dbInstanceUri,
									db.id
								))
								val groupTarifications = groups.entries.fold(persistentHashMapOf<String, Tarification>()) { map, (_, group) ->
									group.tarifications.sortedBy { it }.fold(map) { map, tId ->
										tarifications[tId]?.let { tar ->
											val valorisations = tar.valorisations.filter { v -> v.code != null }.map { v ->
												val vt = v.code!!
												Valorisation(
													startOfValidity = v.from?.let { f -> FuzzyValues.getFuzzyDateTime(f, ChronoUnit.SECONDS) }
														?: ((year.toLong() * 10000 + 101) * 1000000),
													endOfValidity = v.to?.takeIf { it < farFutureCal }?.let { FuzzyValues.getFuzzyDateTime(it, ChronoUnit.SECONDS) }
														?: (((year.toLong() + 1L) * 10000 + 101) * 1000000L),
													label = mapOf("fr" to vt.fr, "nl" to vt.nl),
													predicate = vt.predicate,
													patientIntervention = v.patientIntervention ?: 0.0,
													reimbursement = v.reimbursement ?: 0.0,
													doctorSupplement = 0.0,
													totalAmount = v.fee ?: (
														(v.patientIntervention ?: 0.0) + (
															v.reimbursement
																?: 0.0
															)
														),
													vat = 0.0
												)
											}.toSet()
											val compactedValorisations = valorisations.fold(persistentHashSetOf<Valorisation>()) { set, v ->
												val eq = set.find { e -> e != v && e.predicate == v.predicate && e.startOfValidity == v.startOfValidity && e.endOfValidity == v.endOfValidity }
												eq?.let {
													if ((eq.totalAmount ?: 0.0) > 0.0 && (v.totalAmount ?: 0.0) > 0.0) {
														set.add(v)
													} else {
														set.remove(eq).add(
															eq.copy(
																label = (v.label ?: emptyMap()).entries.fold((eq.label ?: emptyMap()).toPersistentHashMap()) { label, (k, v) ->
																	label.put(k, ((label[k]?.let { listOf(it) } ?: emptyList()) + listOf(v)).sorted().joinToString { ", " })
																},
																patientIntervention = (
																	eq.patientIntervention
																		?: 0.0
																	) + (v.patientIntervention ?: 0.0),
																reimbursement = (eq.reimbursement ?: 0.0) + (v.reimbursement ?: 0.0),
																totalAmount = (eq.totalAmount ?: 0.0) + (v.totalAmount ?: 0.0),
																vat = (eq.vat ?: 0.0) + (v.vat ?: 0.0)
															)
														)
													}
												} ?: set.add(v)
											}
											val trueCode = compactedValorisations.find { it.predicate == "true" }
											val tci = tarificationInfos[tar.id]
											val t = Tarification(
												id = "INAMI-RIZIV|${tar.id}|1.0",
												label = listOfNotNull(tar.fr?.let { "fr" to it }, tar.nl?.let { "nl" to it }).toMap(),
												regions = setOf("be", "fr"),
												type = "INAMI-RIZIV",
												code = tar.id,
												version = "1.0",
												ngroup = group.id,
												letterValues = listOfNotNull(
													tar.letter1?.takeIf { l -> l != "-" }?.let { l -> LetterValue(l, tar.letterIndex1, tar.coeff1, tar.letter1Value) },
													tar.letter2?.takeIf { l -> l != "-" }?.let { l -> LetterValue(l, tar.letterIndex2, tar.coeff2, tar.letter2Value) },
													tar.letter3?.takeIf { l -> l != "-" }?.let { l -> LetterValue(l, tar.letterIndex3, tar.coeff3, tar.letter3Value) },
												),
												category = mapOf("fr" to group.fr, "nl" to group.nl),
												valorisations = if (trueCode != null) {
													compactedValorisations
														.remove(trueCode)
														.removeAll(compactedValorisations.filter { v -> v.totalAmount == trueCode.totalAmount && v.reimbursement == 0.0 && v.patientIntervention == 0.0 })
														.fold(persistentHashSetOf<Valorisation>() to persistentListOf<String>()) { (valorisations, predicates), v ->
															if (v.totalAmount == 0.0) {
																valorisations.add(v.copy(totalAmount = trueCode.totalAmount)) to predicates.add("( ${v.predicate} )")
															} else valorisations.add(v) to predicates
														}.let { (valorisations, predicates) -> valorisations.add(if (predicates.isEmpty()) trueCode else trueCode.copy(predicate = "!(${predicates.joinToString(" || ")})")) }
												} else compactedValorisations,
												needsPrescriber = tci?.prescriber == true,
												hasRelatedCode = tci?.relatedCode == true,
												relatedCodes = tci?.relatedCodes?.toSet() ?: emptySet()
											)
											map.put(t.id, t)
										} ?: map
									}
								}

								val currentTarifications = retry(10) {
									client
										.queryViewIncludeDocs<String, String, Tarification>(
											createQuery<Tarification>("all").includeDocs(true)
										).mapNotNull { it.doc }
										.fold(persistentHashMapOf<String, Tarification>()) { map, t -> map.put(t.id, t) }
								}

								val updatedTarifications = groupTarifications.values.mapNotNull { newCode ->
									val modCode = currentTarifications[newCode.id]
									if (modCode == null) {
										newCode
									} else {
										val originalVals = modCode.valorisations

										@Suppress("UselessCallOnCollection") val combinedVals = modCode.valorisations.filterNotNull().mapNotNull { v ->
											val vSov = v.startOfValidity?.let {
												it.takeIf { it >= 29991231 } ?: (it * 1000000L)
											} ?: 20000101000000
											val vEov = v.endOfValidity?.let {
												it.takeIf { it >= 29991231 } ?: (it * 1000000L)
											} ?: 29991231235999

											val (normVSov, normVEov) = newCode.valorisations.filter { it.predicate == v.predicate }.fold<Valorisation, Pair<Long?, Long?>>(vSov to vEov) { (vSov, vEov), nv ->
												if (vSov == null || vEov == null) {
													null to null
												} else {
													val nvSov = nv.startOfValidity ?: 20000101000000
													val nvEov = nv.endOfValidity ?: 29991231235999L

													val normVSov = if (vSov in nvSov..nvEov) {
														nvEov.coerceAtMost(vEov)
													} else vSov

													val normVEov = if (vEov in nvSov..nvEov) {
														nvSov.coerceAtLeast(normVSov)
													} else vEov

													if (((normVSov >= nvSov - 1000000) && (normVEov <= nvEov + 1000000)) || normVSov >= normVEov) {
														null to null
													} else (normVSov to normVEov)
												}
											}

											if (normVSov != null) {
												v.copy(
													startOfValidity = normVSov,
													endOfValidity = normVEov,
												)
											} else null
										}.toPersistentSet().addAll(newCode.valorisations)

										@Suppress("UselessCallOnCollection") val sameVals = combinedVals.map { it.copy(label = null) }.toSet() == originalVals.filterNotNull().map { it.copy(label = null) }.toSet()

										val strippedModCode = modCode.copy(
											valorisations = emptySet()
										)

										val strippedNewCode = newCode.copy(
											valorisations = emptySet(),
											rev = modCode.rev
										)

										if (strippedModCode == strippedNewCode && sameVals) {
											null
										} else {
											modCode.copy(
												valorisations = combinedVals,
												needsPrescriber = newCode.needsPrescriber,
												ngroup = newCode.ngroup,
												letterValues = newCode.letterValues,
												hasRelatedCode = newCode.hasRelatedCode,
												category = newCode.category,
												consultationCode = newCode.consultationCode,
												label = newCode.label,
												relatedCodes = newCode.relatedCodes,
											)
										}
									}
								}
								log.warn("${db.id}: updating ${updatedTarifications.size} codes")
								updatedTarifications.chunked(1000).flatMap {
									try {
										retry(2) { client.bulkUpdate(it).mapNotNull { r -> if (r.ok == true) r.id to r.rev else null }.toList() }
									} catch (e: Exception) {
										it.mapNotNull { t ->
											try {
												client.update(t).let { r -> r.id to r.rev }
											} catch (e: Exception) {
												null
											}
										}
									}
								}
							} catch (e: Exception) {
								log.error("General error while importing in ${db.id}", e)
							}
						}
					}
				}
				awaits.forEach { it.await() }
			}
		}
	}

	private suspend fun <E> retry(count: Int, executor: suspend () -> E): E {
		return try {
			executor()
		} catch (e: Exception) {
			if (count > 0) retry(count - 1, executor) else throw e
		}
	}
}
