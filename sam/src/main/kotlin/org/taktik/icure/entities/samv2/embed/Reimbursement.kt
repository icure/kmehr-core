/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.entities.samv2.embed

import java.math.BigDecimal
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Reimbursement(
	override val from: Long? = null,
	override val to: Long? = null,
	val deliveryEnvironment: DeliveryEnvironment? = null,
	val code: String? = null,
	val codeType: DmppCodeType? = null,
	val multiple: MultipleType? = null,
	val temporary: Boolean? = null,
	val reference: Boolean? = null,
	val legalReferencePath: String? = null,
	val flatRateSystem: Boolean? = null,
	val reimbursementBasePrice: BigDecimal? = null,
	val referenceBasePrice: BigDecimal? = null,
	val copaymentSupplement: BigDecimal? = null,
	val pricingUnit: Pricing? = null,
	val pricingSlice: Pricing? = null,
	val reimbursementCriterion: ReimbursementCriterion? = null,
	val copayments: Set<Copayment>? = null
) : DataPeriod, Comparable<Reimbursement> {
	override fun compareTo(other: Reimbursement): Int {
		return if (this == other) {
			0
		} else compareValuesBy(this, other, { it.from }, { it.codeType }, { it.code }, { it.deliveryEnvironment }, { it.flatRateSystem }, { it.reference }, { it.legalReferencePath }, { it.multiple }, { it.temporary }, { it.to })
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Reimbursement) return false

		if (from != other.from) return false
		if (to != other.to) return false

		if (deliveryEnvironment != other.deliveryEnvironment) return false
		if (code != other.code) return false
		if (codeType != other.codeType) return false
		if (multiple != other.multiple) return false
		if (temporary != other.temporary) return false
		if (reference != other.reference) return false
		if (legalReferencePath != other.legalReferencePath) return false
		if (flatRateSystem != other.flatRateSystem) return false
		if (reimbursementBasePrice != null && other.reimbursementBasePrice == null || reimbursementBasePrice == null && other.reimbursementBasePrice != null || (reimbursementBasePrice?.compareTo(other.reimbursementBasePrice) != 0 && reimbursementBasePrice != other.reimbursementBasePrice)) return false
		if (referenceBasePrice != null && other.referenceBasePrice == null || referenceBasePrice == null && other.referenceBasePrice != null || (referenceBasePrice?.compareTo(other.referenceBasePrice) != 0 && referenceBasePrice != other.referenceBasePrice)) return false
		if (copaymentSupplement != null && other.copaymentSupplement == null || copaymentSupplement == null && other.copaymentSupplement != null || (copaymentSupplement?.compareTo(other.copaymentSupplement) != 0 && copaymentSupplement != other.copaymentSupplement)) return false
		if (pricingUnit != other.pricingUnit) return false
		if (pricingSlice != other.pricingSlice) return false
		if (reimbursementCriterion != other.reimbursementCriterion) return false
		if (copayments != other.copayments) return false

		return true
	}

	override fun hashCode(): Int {
		var result = from?.hashCode() ?: 0
		result = 31 * result + (to?.hashCode() ?: 0)
		result = 31 * result + (deliveryEnvironment?.hashCode() ?: 0)
		result = 31 * result + (code?.hashCode() ?: 0)
		result = 31 * result + (codeType?.hashCode() ?: 0)
		result = 31 * result + (multiple?.hashCode() ?: 0)
		result = 31 * result + (temporary?.hashCode() ?: 0)
		result = 31 * result + (reference?.hashCode() ?: 0)
		result = 31 * result + (legalReferencePath?.hashCode() ?: 0)
		result = 31 * result + (flatRateSystem?.hashCode() ?: 0)
		result = 31 * result + (reimbursementBasePrice?.toInt() ?: 0)
		result = 31 * result + (referenceBasePrice?.toInt() ?: 0)
		result = 31 * result + (copaymentSupplement?.toInt() ?: 0)
		result = 31 * result + (pricingUnit?.hashCode() ?: 0)
		result = 31 * result + (pricingSlice?.hashCode() ?: 0)
		result = 31 * result + (reimbursementCriterion?.hashCode() ?: 0)
		result = 31 * result + (copayments?.hashCode() ?: 0)
		return result
	}
}
