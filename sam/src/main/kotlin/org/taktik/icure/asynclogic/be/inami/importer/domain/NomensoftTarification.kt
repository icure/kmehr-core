package org.taktik.icure.asynclogic.be.inami.importer.domain

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDateTime

data class NomensoftTarification(
	val id: String,
	val amb: Boolean = false,
	val startCode: LocalDateTime? = null,
	val fr: String? = null,
	val nl: String? = null,
	val rubric: String? = null,
	val letter1: String? = null,
	val letterIndex1: String? = null,
	val coeff1: Double? = null,
	val letter1Value: Double? = null,
	val letter2: String? = null,
	val letterIndex2: String? = null,
	val coeff2: Double? = null,
	val letter2Value: Double? = null,
	val letter3: String? = null,
	val letterIndex3: String? = null,
	val coeff3: Double? = null,
	val letter3Value: Double? = null,
	val valorisations: PersistentList<NomensoftValorisation> = persistentListOf(),
) {
	fun copyWith(e: NomenSummaryExt) = this.copy(
		id = e.nomenCode,
		amb = e.ambhosPatCat != "2",
		startCode = e.dbegin.toGregorianCalendar().let { c -> LocalDateTime.ofInstant(c.toInstant(), c.timeZone.toZoneId()) },
		fr = e.nomenDescFr,
		nl = e.nomenDescNl,
		rubric = e.nomenGrpN,
		letter1 = e.keyLetter1,
		letterIndex1 = e.keyLetterIndex1,
		coeff1 = e.keyCoeff1,
		letter1Value = e.keyLetter1Value,
		letter2 = e.keyLetter2,
		letterIndex2 = e.keyLetterIndex2,
		coeff2 = e.keyCoeff2,
		letter2Value = e.keyLetter2Value,
		letter3 = e.keyLetter3,
		letterIndex3 = e.keyLetterIndex3,
		coeff3 = e.keyCoeff3,
		letter3Value = e.keyLetter3Value
	)
}
