package org.taktik.icure.asynclogic.be.inami.importer.domain

import java.time.LocalDateTime

data class NomensoftValorisation(
	val id: String,
	val code: NomenFeeCode?,
	val type: Int,
	val from: LocalDateTime?,
	val to: LocalDateTime?,
	val amount: Double,
) {
	val fee: Double?
		get() = amount.takeIf { code?.cat == "01" }

	val reimbursement: Double?
		get() = amount.takeIf { listOf("02", "03", "04", "06").contains(code?.cat) }

	val patientIntervention: Double?
		get() = amount.takeIf { listOf("05", "13", "14").contains(code?.cat) }

	override fun toString(): String {
		return "NomensoftValorisation(id='$id', type='$type', amount=$amount)"
	}
}
