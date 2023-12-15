package org.taktik.icure.asynclogic.samv2.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import org.taktik.couchdb.ViewQueryResultEvent
import org.taktik.couchdb.ViewRowWithDoc
import org.taktik.couchdb.entity.ComplexKey
import org.taktik.icure.asyncdao.samv2.*
import org.taktik.icure.asynclogic.samv2.SamV2Logic
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.db.sanitize
import org.taktik.icure.entities.samv2.*
import org.taktik.icure.entities.samv2.embed.SamText
import org.taktik.icure.utils.aggregateResults
import org.taktik.icure.utils.bufferedChunks
import org.taktik.icure.utils.distinct
import java.util.*

@Service
@Profile("sam")
class SamV2LogicImpl(
    private val ampDAO: AmpDAO,
    private val vmpDAO: VmpDAO,
    private val vmpGroupDAO: VmpGroupDAO,
    private val nmpDAO: NmpDAO,
    private val substanceDAO: SubstanceDAO,
    private val pharmaceuticalFormDAO: PharmaceuticalFormDAO,
    private val paragraphDAO: ParagraphDAO,
    private val verseDAO: VerseDAO
) : SamV2Logic {
    private val mutex = Mutex()

    private var ampProductIds: Map<String, String>? = null
    private var nmpProductIds: Map<String, String>? = null
    private var vmpProductIds: Map<String, String>? = null

    override fun findVmpsByGroupId(vmpgId: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return vmpDAO.findVmpsByGroupId(vmpgId, paginationOffset)
    }

    override fun findAmpsByVmpGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByVmpGroupCode(vmpgCode, paginationOffset)
    }

    override fun findAmpsByVmpGroupId(vmpgId: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByVmpGroupId(vmpgId, paginationOffset)
    }

    override fun findAmpsByVmpCode(vmpCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByVmpCode(vmpCode, paginationOffset)
    }

    override fun findAmpsByVmpId(vmpId: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByVmpId(vmpId, paginationOffset)
    }

    override fun findAmpsByDmppCode(dmppCode: String): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByDmppCode(dmppCode)
    }

    override fun findAmpsByAmpCode(ampCode: String): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByAmpCode(ampCode)
    }

    override fun listVmpIdsByGroupCode(vmpgCode: String): Flow<String> {
        return vmpDAO.listVmpIdsByGroupCode(vmpgCode)
    }

    override fun listVmpIdsByGroupId(vmpgId: String): Flow<String> {
        return vmpDAO.listVmpIdsByGroupId(vmpgId)
    }

    override fun listAmpIdsByVmpGroupCode(vmpgCode: String): Flow<String> {
        return ampDAO.listAmpIdsByVmpGroupCode(vmpgCode)
    }

    override fun listAmpIdsByVmpGroupId(vmpgId: String): Flow<String> {
        return ampDAO.listAmpIdsByVmpGroupId(vmpgId)
    }

    override fun listAmpIdsByVmpCode(vmpCode: String): Flow<String> {
        return ampDAO.listAmpIdsByVmpCode(vmpCode)
    }

    override fun listAmpIdsByVmpId(vmpId: String): Flow<String> {
        return ampDAO.listAmpIdsByVmpId(vmpId)
    }

    override suspend fun getVersion(): SamVersion? {
        return ampDAO.getVersion()
    }

    override suspend fun listAmpProductIds(ids: Collection<String>): List<ProductId?> {
        mutex.withLock {
            if (this.ampProductIds == null) {
                this.ampProductIds = ampDAO.getProductIdsFromSignature("amp")
                return ids.map { id -> this.ampProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
            }
        }
        return ids.map { id -> this.ampProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
    }

    override suspend fun listVmpgProductIds(ids: Collection<String>): List<ProductId?> {
        mutex.withLock {
            if (this.vmpProductIds == null) {
                this.vmpProductIds = ampDAO.getProductIdsFromSignature("vmp")
                return ids.map { id -> this.vmpProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
            }
        }
        return ids.map { id -> this.vmpProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
    }

    override suspend fun listNmpProductIds(ids: Collection<String>): List<ProductId?> {
        mutex.withLock {
            if (this.nmpProductIds == null) {
                this.nmpProductIds = ampDAO.getProductIdsFromSignature("nmp")
                return ids.map { id -> this.nmpProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
            }
        }
        return ids.map { id -> this.nmpProductIds?.get(id)?.let { ProductId(id = id, productId = it) } }
    }

    override fun findVmpsByGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return vmpDAO.findVmpsByGroupCode(vmpgCode, paginationOffset)
    }

    override fun findAmpsByLabel(language: String?, label: String, paginationOffset: PaginationOffset<List<String>>): Flow<Amp> = flow {
        val labelComponents = label.split(" ").mapNotNull { it.sanitize() }
        val ampIds = ampDAO.listAmpIdsByLabel(language, labelComponents.maxByOrNull { it.length }).toSet(TreeSet())

        emitAll(
            aggregateResults(
                ids = ampIds,
                limit = paginationOffset.limit,
                supplier = { ids -> ampDAO.getEntities(ids) },
                filter = { amp -> labelComponents.all { labelComponent ->
                    listOfNotNull(
                        amp.officialName,
                        amp.abbreviatedName?.localized(language)?.sanitize(),
                        amp.prescriptionName?.localized(language)?.sanitize(),
                        amp.name?.localized(language)?.sanitize(),
                    ).any { it.contains(other = labelComponent, ignoreCase = true) }
                } },
                startDocumentId = paginationOffset.startDocumentId,
            ).asFlow()
        )
    }

    private fun SamText.localized(language: String?) = when (language) {
        "fr" -> this.fr
        "en" -> this.en
        "de" -> this.de
        "nl" -> this.nl
        else -> null
    }

    override fun listAmpIdsByLabel(language: String?, label: String?): Flow<String> {
        return ampDAO.listAmpIdsByLabel(language, label)
    }

    override fun findVmpsByLabel(language: String?, label: String?, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> {
        return vmpDAO.findVmpsByLabel(language, label, paginationOffset)
    }

    override fun listVmpIdsByLabel(language: String?, label: String?): Flow<String> {
        return vmpDAO.listVmpIdsByLabel(language, label)
    }

    override fun findVmpGroupsByLabel(language: String?, label: String?, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> {
        return vmpGroupDAO.findVmpGroupsByLabel(language, label, paginationOffset)
    }

    override fun findVmpGroupsByVmpGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return vmpGroupDAO.findVmpGroupsByVmpGroupCode(vmpgCode, paginationOffset)
    }

    override fun findVmpGroups(paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return vmpGroupDAO.findVmpGroups(paginationOffset)
    }

    override fun findVmpsByVmpCode(vmpCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return vmpDAO.findVmpsByVmpCode(vmpCode, paginationOffset)
    }

    override fun listVmpGroupIdsByLabel(language: String?, label: String?): Flow<String> {
        return vmpGroupDAO.listVmpGroupIdsByLabel(language, label)
    }

    override fun findNmpsByLabel(language: String?, label: String?, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent> {
        return nmpDAO.findNmpsByLabel(language, label, paginationOffset)
    }

    override fun listNmpIdsByLabel(language: String?, label: String?): Flow<String> {
        return nmpDAO.listNmpIdsByLabel(language, label)
    }

    override fun listSubstances(): Flow<Substance> {
        return substanceDAO.getEntities()
    }

    override fun listPharmaceuticalForms(): Flow<PharmaceuticalForm> {
        return pharmaceuticalFormDAO.getEntities()
    }

    override fun listVmpsByVmpCodes(vmpCodes: List<String>): Flow<Vmp> {
        return vmpDAO.listVmpsByVmpCodes(vmpCodes)
    }

    override fun findAmpsByAtcCode(atcCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent> {
        return ampDAO.findAmpsByAtc(atcCode, paginationOffset)
    }

    override fun listVmpsByGroupIds(vmpgIds: List<String>): Flow<Vmp> {
        return vmpDAO.listVmpsByGroupIds(vmpgIds)
    }

    override fun listAmpsByGroupCodes(vmpgCodes: List<String>): Flow<Amp> {
        return ampDAO.listAmpsByVmpGroupCodes(vmpgCodes)
    }

    override fun listAmpsByDmppCodes(dmppCodes: List<String>): Flow<Amp> {
        return ampDAO.listAmpsByDmppCodes(dmppCodes)
    }

    override fun listAmpsByGroupIds(groupIds: List<String>): Flow<Amp> {
        return ampDAO.listAmpsByVmpGroupIds(groupIds)
    }

    override fun listAmpsByVmpCodes(vmpgCodes: List<String>): Flow<Amp> {
        return ampDAO.listAmpsByVmpCodes(vmpgCodes)
    }

    override fun listAmpsByVmpIds(vmpIds: List<String>): Flow<Amp> {
        return ampDAO.listAmpsByVmpIds(vmpIds)
    }

    override fun listVmpGroupsByVmpGroupCodes(vmpgCodes: List<String>): Flow<VmpGroup> {
        return vmpGroupDAO.listVmpGroupsByVmpGroupCodes(vmpgCodes)
    }

    override fun listNmpsByCnks(cnks: List<String>): Flow<Nmp> {
        return nmpDAO.listNmpsByCnks(cnks)
    }

    override fun findParagraphs(searchString: String, language: String): Flow<Paragraph> {
        return paragraphDAO.findParagraphs(searchString, language, PaginationOffset(1000))
            .filterIsInstance<ViewRowWithDoc<ComplexKey, Int, Paragraph>>()
            .map { it.doc }
    }

    override fun findParagraphsWithCnk(cnk: Long, language: String): Flow<Paragraph> {
        return paragraphDAO.findParagraphsWithCnk(cnk, language)
    }

    override suspend fun getParagraphInfos(chapterName: String, paragraphName: String): Paragraph {
        return paragraphDAO.getParagraph(chapterName, paragraphName)
    }

    override suspend fun getVersesHierarchy(chapterName: String, paragraphName: String): Verse? {
        val allVerses: List<Verse> = listVerses(chapterName, paragraphName).toList()

        fun fillChildren(v: Verse): Verse = v.copy(children = allVerses.filter { it.verseSeqParent == v.verseSeq }.map { fillChildren(it) })

        return allVerses.takeIf { it.isNotEmpty() }?.let { fillChildren(it.first()) }
    }

    override fun listVerses(
        chapterName: String,
        paragraphName: String
    ) = verseDAO.listVerses(chapterName, paragraphName)

    override fun getAmpsForParagraph(chapterName: String, paragraphName: String): Flow<Amp> {
        return ampDAO.findAmpsByChapterParagraph(chapterName, paragraphName, PaginationOffset(1000))
            .filterIsInstance<ViewRowWithDoc<ComplexKey, Int, Amp>>()
            .map { it.doc }
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun getVtmNamesForParagraph(chapterName: String, paragraphName: String, language: String): Flow<String> {
        return getAmpsForParagraph(chapterName, paragraphName).bufferedChunks(100, 200).flatMapConcat {
            vmpDAO.getEntities(it.mapNotNull { it.vmp?.id }).mapNotNull {
                it.vtm?.name?.let { t ->
                    when (language) {
                        "fr" -> t.fr
                        "en" -> t.en
                        "de" -> t.de
                        "nl" -> t.nl
                        else -> null
                    }
                }
            }
        }.distinct()
    }
}
