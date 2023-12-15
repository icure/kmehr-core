package org.taktik.icure.asynclogic.be.inami.importer

import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.persistentHashMapOf
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toPersistentList
import org.taktik.icure.asynclogic.be.inami.importer.domain.NomenFeeCode
import org.taktik.icure.asynclogic.be.inami.importer.domain.NomensoftTarification
import org.taktik.icure.asynclogic.be.inami.importer.domain.NomensoftValorisation
import org.taktik.icure.asynclogic.be.inami.importer.domain.Rubric
import org.taktik.icure.asynclogic.be.inami.importer.domain.Table
import java.text.Normalizer
import java.time.LocalDateTime
import java.util.*

val twoYearsAgo: Calendar = GregorianCalendar.getInstance().apply {
	set(this.get(Calendar.YEAR), 0, 0, 0, 0, 0)
	set(Calendar.MILLISECOND, 0)
	add(Calendar.YEAR, -2)
}

fun importGroups(table: Table, tarifications: PersistentMap<String, NomensoftTarification>) =
	table.nomenSummaryExt.fold(persistentHashMapOf<String, Rubric>() to tarifications) { (rubrics, tarifications), sumExt ->
		val tar = (tarifications[sumExt.nomenCode] ?: NomensoftTarification(id = sumExt.nomenCode)).copyWith(sumExt)
		rubrics.put(
			sumExt.nomenGrpN,
			rubrics[sumExt.nomenGrpN]?.let { it.copy(tarifications = it.tarifications + tar.id) }
				?: Rubric(
					id = sumExt.nomenGrpN,
					fr = sumExt.nomenGrpNDescFr,
					nl = sumExt.nomenGrpNDescNl,
					tarifications = persistentListOf(tar.id)
				)
		) to tarifications.put(sumExt.nomenCode, tar)
	}

fun importFees(table: Table, tarifications: PersistentMap<String, NomensoftTarification>): Triple<PersistentMap<Int, NomenFeeCode>, PersistentMap<String, NomensoftTarification>, PersistentMap<String, Int>> {
	val missingValorisations = tarifications.values.fold(persistentHashMapOf<Int, PersistentSet<String>>()) { map, tar ->
		tar.valorisations.fold(map) { map, valo ->
			if (valo.code == null) {
				map.put(valo.type, (map[valo.type] ?: persistentSetOf()).add(tar.id))
			} else map
		}
	}
	return table.nomenFeeCodes.fold(Triple(persistentHashMapOf(), tarifications, persistentHashMapOf())) { (fees, tarifications, unknown), fee ->
		val key = fee.feeCode
		val cat = fee.feeCodeCat
		if (cat != "07") {
			val frt = Normalizer.normalize(fee.feeCodeDescFr, Normalizer.Form.NFD).replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "").lowercase()
				.replace(Regex("[^a-z\\d]+"), "_")
				.replace(Regex("(honoraires?|rembour?sement|intervention(?:.+l_assurance)?|montant_de_l_de_l_assurance_|montant_+de_+l_+de_+l_+assurance|montant_de_l_indemnite|part_personnelle_|beneficiaires?)_?"), "")
				.replace(Regex("_pour_prestation_dans_categorie.+"), "").replace(Regex("__+"), "_")
				.replace(Regex("__+"), "_").replace(Regex("__+"), "_").replace(Regex("__+"), "_")

			val isSupported = !frt.startsWith("le_numero_de_code_est_supprime") && !frt.startsWith("base_de_remboursement") && !frt.contains("pas_encore_repris_de_tarifs_dans_nomensoft") && !frt.contains("listes_limitatives") && !frt.contains("liste_limitative") && !frt.contains("ticket_moderateur") && !frt.contains("pas_de_tarifs")

			val (frtCode, unknown) = if (isSupported) {
				Refs.refs[frt]?.let { it to unknown } ?: ("_$frt" to unknown.put(frt, (unknown[frt] ?: 0) + 1))
			} else null to unknown
			val code = NomenFeeCode(
				fr = fee.feeCodeDescFr,
				nl = fee.feeCodeDescNl,
				key = key,
				cat = cat,
				code = frt,
				predicate = frtCode?.let { Refs.conditions[it] } ?: "false&&'${frtCode ?: frt}'"
			)
			Triple(
				fees.put(key, code),
				missingValorisations[key]?.let {
					it.fold(tarifications) { tarifications, tarId ->
						tarifications[tarId]?.let { tar ->
							tarifications.put(
								tar.id,
								tar.copy(
									valorisations = tar.valorisations.map { valorisation ->
										valorisation.takeIf { v -> v.type == key }?.let {
											it.copy(code = code)
										} ?: valorisation
									}.toPersistentList()
								)
							)
						} ?: tarifications
					}
				} ?: tarifications,
				unknown
			)
		} else {
			Triple(fees, tarifications, unknown)
		}
	}
}

fun importCodeFees(table: Table, tarifications: PersistentMap<String, NomensoftTarification>, fees: Map<Int, NomenFeeCode>) =
	(table.nomenCodeFeeLim + table.nomenCodeFeeBisLim + table.nomenCodeFeeLimHist + table.nomenCodeFeeBisLimHist).fold(tarifications) { tarifications, codeFee ->
		val tar = tarifications[codeFee.nomenCode] ?: NomensoftTarification(id = codeFee.nomenCode)
		if (codeFee.dbeginFee.toGregorianCalendar() > twoYearsAgo) {
			val f = fees[codeFee.feeCode]
			tarifications.put(
				codeFee.nomenCode,
				tar.copy(
					valorisations = tar.valorisations.add(
						NomensoftValorisation(
							id = codeFee.nomenCode,
							code = f,
							type = codeFee.feeCode,
							from = codeFee.dbeginFee?.toGregorianCalendar()?.let { c -> LocalDateTime.ofInstant(c.toInstant(), c.timeZone.toZoneId()) },
							to = codeFee.dendFee?.toGregorianCalendar()?.let { c -> LocalDateTime.ofInstant(c.toInstant(), c.timeZone.toZoneId()).plusDays(1) },
							amount = codeFee.fee,
						)
					)
				)
			)
		} else tarifications
	}
