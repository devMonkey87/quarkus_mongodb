/*
package com.allianz.bmp.retail.core.offer.functions.calculateSettlement

import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.time.LocalDateTime
import kotlin.math.min

@ApplicationScoped
class CalculateSettlementFunction360 {
    fun calculate(calculateSettlementInput: CalculateSettlementInput): BigDecimal {
        val numberOfDays = countDaysBetween(
            calculateSettlementInput.amendmentOfferData.effectiveDate, calculateSettlementInput.financeData?.endInvoiceDate!!
        ).toBigDecimal()

        val oldAmounts = createAmounts(
            calculateSettlementInput.policyData.annualNetPremium!!,
            calculateSettlementInput.policyData.taxes
        )

        val nonConsumedPremium = calculateTotalTaxAndPremium(oldAmounts, numberOfDays)

        val newAmounts = createAmounts(
            calculateSettlementInput.amendmentOfferData.annualNetPremium!!,
            calculateSettlementInput.amendmentOfferData.taxes
        )

        val newAmendmentPremium = calculateTotalTaxAndPremium(newAmounts, numberOfDays)

        val settlement = newAmendmentPremium - nonConsumedPremium
        return settlement.setScale(SCALE, RoundingMode.HALF_UP)
    }

    private fun countDaysBetween(start: LocalDateTime, end: LocalDateTime): Int = normalizeDate(end) - normalizeDate(start)

    private fun normalizeDate(date: LocalDateTime): Int = date.year * DAYS_360 + date.monthValue * DAYS_30 + min(DAYS_30, date.dayOfMonth)

    private fun calculateAmountForNumberOfDays(amount: BigDecimal, numberOfDays: BigDecimal): BigDecimal =
        amount.divide(DAYS_360.toBigDecimal(), MathContext.DECIMAL128).multiply(numberOfDays)

    private fun createAmounts(netPremium: BigDecimal, taxes: MutableList<BigDecimal>?): MutableList<BigDecimal> {
        val amounts = mutableListOf(netPremium)
        if (taxes.isNullOrEmpty()) {
            return amounts
        }
        for (tax in taxes) {
            amounts.add(tax)
        }
        return amounts
    }

    private fun calculateTotalTaxAndPremium(amounts: List<BigDecimal>, numberOfDays: BigDecimal): BigDecimal {
        return amounts.fold(BigDecimal.ZERO) { acc, amount ->
            acc + calculateAmountForNumberOfDays(amount, numberOfDays)
        }
    }

    companion object {
        private const val DAYS_360 = 360
        private const val DAYS_30 = 30
        private const val SCALE = 2
    }
}
*/
