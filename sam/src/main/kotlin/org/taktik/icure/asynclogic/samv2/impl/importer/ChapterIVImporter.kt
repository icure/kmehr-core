package org.taktik.icure.asynclogic.samv2.impl.importer

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.taktik.couchdb.id.UUIDGenerator
import org.taktik.icure.asyncdao.CouchDbDispatcher
import org.taktik.icure.asyncdao.samv2.impl.AmpDAOImpl
import org.taktik.icure.asyncdao.samv2.impl.ParagraphDAOImpl
import org.taktik.icure.asyncdao.samv2.impl.VerseDAOImpl
import org.taktik.icure.be.samv2v5.entities.ExportChapterIVType
import org.taktik.icure.entities.samv2.Paragraph
import org.taktik.icure.entities.samv2.Verse
import org.taktik.icure.entities.samv2.embed.AddedDocument
import org.taktik.icure.properties.CouchDbProperties
import org.taktik.icure.utils.suspendRetry
import java.util.*

class ChapterIVImporter {

	suspend fun importChapterIV(export: ExportChapterIVType, couchDbProperties: CouchDbProperties, couchDbDispatcher: CouchDbDispatcher, force: Boolean): Pair<List<Paragraph>, List<Verse>> {
		val log = LoggerFactory.getLogger(this::class.java)

		val ampDAO = AmpDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }
		val paragraphDAO = ParagraphDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator(), ampDAO).apply { forceInitStandardDesignDocument(true) }
		val verseDAO = VerseDAOImpl(couchDbProperties, couchDbDispatcher, UUIDGenerator()).apply { forceInitStandardDesignDocument(true) }

		val currentParagraphs = HashSet(suspendRetry(50) { paragraphDAO.getEntityIds().toList() })
		val currentVerses = HashSet(suspendRetry(50) { verseDAO.getEntityIds().toList() })

		val paragraphsAndVerses = export.paragraph.map { p ->
			val cName = p.chapterName.toString()
			val pName = p.paragraphName.toString()

			p.data.map { d ->
				val from = d.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
				val to = d.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

				Paragraph(
					chapterName = cName,
					paragraphName = pName,
					startDate = from,
					createdTms = d.createdTimestamp?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
					createdUserId = d.createdUserId,
					endDate = to,
					keyStringNl = d.keyStringNl,
					keyStringFr = d.keyStringFr,
					agreementType = d.agreementType,
					processType = d.processType?.toLong(),
					legalReference = d.legalReference,
					publicationDate = d.publicationDate?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
					modificationDate = d.modificationDate?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
					processTypeOverrule = d.processTypeOverrule,
					paragraphVersion = d.paragraphVersion.toLong(),
					agreementTypePro = d.agreementTypePro,
					modificationStatus = d.modificationStatus,
					id = "$cName:$pName:$from:${to ?: ""}",
				)
			} to p.verse.flatMap { vfd ->
				vfd.data.mapNotNull { vd ->
					val verseFrom = vd.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
					val verseTo = vd.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis

					Verse(
						chapterName = p.chapterName,
						paragraphName = p.paragraphName,
						verseSeq = vfd.verseSeq.toLong(),
						startDate = verseFrom,
						createdTms = vd.createdTimestamp?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
						createdUserId = vd.createdUserId,
						endDate = verseTo,
						verseNum = vd.verseNum.toLong(),
						verseSeqParent = vd.verseSeqParent.toLong(),
						verseLevel = vd.verseLevel.toLong(),
						verseType = vd.verseType,
						checkBoxInd = vd.isCheckBoxInd.toString(),
						minCheckNum = vd.minCheckNum?.toLong(),
						andClauseNum = vd.andClauseNum?.toLong(),
						textFr = vd.textFr,
						textNl = vd.textNl,
						requestType = vd.requestType,
						agreementTerm = vd.agreementTerm?.toLong(),
						agreementTermUnit = vd.agreementTermUnit,
						maxPackageNumber = vd.maxPackageNumber?.toLong(),
						purchasingAdvisorQualList = vd.purchasingAdvisorQualList,
						legalReference = vd.legalReference,
						modificationDate = vd.modificationDate?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis,
						addedDocuments = vfd.addedDocument.flatMap { adfd ->
							adfd.data.mapNotNull { ad ->
								val adFrom = ad.from?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
								val adTo = ad.to?.toGregorianCalendar(TimeZone.getTimeZone("UTC"), null, null)?.timeInMillis
								if ((adFrom ?: 0) < (verseTo ?: Long.MAX_VALUE) && (adTo ?: Long.MAX_VALUE) > (verseFrom ?: 0)) AddedDocument(
									from = adFrom,
									to = adTo,
									verseSeq = vfd.verseSeq.toLong(),
									documentSeq = adfd.documentSeq.toLong(),
									mimeType = ad.mimeType,
									addressUrl = ad.addressUrl,
								) else null
							}
						},
						agreementYearMax = vd.agreementYearMax?.toLong(),
						agreementRenewalMax = vd.agreementRenewalMax?.toLong(),
						sexRestricted = vd.sexRestricted,
						minimumAgeAuthorized = vd.minimumAgeAuthorized?.toDouble(),
						maximumAgeAuthorized = vd.maximumAgeAuthorized?.toDouble(),
						maximumContentQuantity = vd.maximumContentQuantity?.toDouble(),
						maximumContentUnit = vd.maximumContentUnit,
						maximumStrengthQuantity = vd.maximumStrengthQuantity?.toDouble(),
						maximumStrengthUnit = vd.maximumStrengthUnit,
						maximumDurationQuantity = vd.maximumDurationQuantity?.toDouble(),
						maximumDurationUnit = vd.maximumDurationUnit,
						otherAddedDocumentInd = vd.isOtherAddedDocumentInd?.toString(),
						minimumAgeAuthorizedUnit = vd.minimumAgeAuthorizedUnit,
						maximumAgeAuthorizedUnit = vd.maximumAgeAuthorizedUnit,
						modificationStatus = vd.modificationStatus,
						id = "$cName:$pName:${vd.verseNum}:$verseFrom:${verseTo ?: ""}",
					)
				}
			}
		}
		val (paragraphs, verses) = paragraphsAndVerses.chunked(100).mapIndexed { index, chunk ->
			log.warn("Treating chunk $index/${paragraphsAndVerses.size / 100}")

			val currentParagraphsWithDoc = paragraphDAO.getEntities(chunk.flatMap { (p, _) -> p.map { it.id } }.filter { currentParagraphs.contains(it) }).toList()
			val currentVersesWithDoc = verseDAO.getEntities(chunk.flatMap { (_, verses) -> verses }.map { v -> v.id }.filter { currentVerses.contains(it) }).toList()

			chunk.flatMap { (paragraphs, _) -> paragraphs }.let { paragraphs ->
				(paragraphs.filter { !currentParagraphs.contains(it.id) }.takeIf { it.isNotEmpty() }?.let { paragraphs ->
					paragraphs.forEach { paragraph -> log.info("New Paragraph:${paragraph.id}") }
					try {
						paragraphDAO.save(paragraphs).toList().let { dids -> paragraphs.map { it.copy(rev = dids.find { did -> did.id == it.id }!!.rev) } }
					} catch (e: Exception) {
						paragraphs.mapNotNull { paragraph ->
							try {
								paragraphDAO.get(paragraph.id)?.let { paragraphDAO.update(paragraph.copy(rev = it.rev)) }
							} catch (e: Exception) {
								null
							}
						}
					}
				} ?: listOf()) + if (force) {
					paragraphs.filter { currentParagraphs.contains(it.id) }.mapNotNull { paragraph ->
						val prev = (currentParagraphsWithDoc.find { it.id == paragraph.id } ?: paragraphDAO.get(paragraph.id))!!
						paragraph.copy(rev = prev.rev).let {
							if (prev.copy(createdTms = it.createdTms) != it) {
								log.info("Modified Paragraph:${it.id}")
								it
							} else {
								log.debug("No change to paragraph:${it.id}")
								null
							}
						}
					}.takeIf { it.isNotEmpty() }?.let { paragraphs ->
						paragraphDAO.save(paragraphs).toList().let { dids -> paragraphs.map { it.copy(rev = dids.find { did -> did.id == it.id }!!.rev) } }
					} ?: listOf()
				} else listOf()
			} to chunk.flatMap { (_, verses) -> verses }.let { verses ->
				(verses.filter { !currentVerses.contains(it.id) }.takeIf { it.isNotEmpty() }?.let { verses ->
					verses.forEach { verse -> log.info("New Verse:${verse.id}") }
					try {
						verseDAO.save(verses).toList().let { dids -> verses.map { it.copy(rev = dids.find { did -> did.id == it.id }!!.rev) } }
					} catch (e: Exception) {
						verses.mapNotNull { verse ->
							try {
								verseDAO.get(verse.id)?.let { verseDAO.update(verse.copy(rev = it.rev)) }
							} catch (e: Exception) {
								null
							}
						}
					}
				} ?: listOf()) + (if (force) {
					verses.filter { currentVerses.contains(it.id) }.mapNotNull { verse ->
						val prev = (currentVersesWithDoc.find { it.id == verse.id } ?: verseDAO.get(verse.id))!!
						verse.copy(rev = prev.rev).let {
							if (prev.copy(createdTms = it.createdTms) != it) {
								log.info("Modified Verse:${it.id}")
								verse
							} else {
								log.debug("No change to verse:${it.id}")
								null
							}
						}
					}.takeIf { it.isNotEmpty() }?.let { verses ->
						verseDAO.save(verses).toList().let { dids -> verses.map { it.copy(rev = dids.find { did -> did.id == it.id }!!.rev) } }
					} ?: listOf()
				} else listOf())
			}
		}.fold<Pair<List<Paragraph>, List<Verse>>, Pair<List<Paragraph>, List<Verse>>>(emptyList<Paragraph>() to emptyList()) { (pParagraphs, pVerses), (paragraphs, verses) -> (pParagraphs + paragraphs) to (pVerses + verses) }

		val tbdParagraphs = (currentParagraphs - paragraphsAndVerses.flatMap { (p, _) -> p.map { it.id } }.toSet())
		tbdParagraphs.forEach { log.info("Delete Paragraph:${it}") }
		tbdParagraphs.chunked(100).forEach { paragraphDAO.purge(paragraphDAO.getEntities(it)).collect() }

		val tbdVerses = (currentVerses - paragraphsAndVerses.flatMap { (_, v) -> v.map { it.id } }.toSet())
		tbdVerses.forEach { log.info("Delete Paragraph:${it}") }
		tbdVerses.chunked(100).forEach { verseDAO.purge(verseDAO.getEntities(it)).collect() }

		return paragraphs to verses
	}
}
