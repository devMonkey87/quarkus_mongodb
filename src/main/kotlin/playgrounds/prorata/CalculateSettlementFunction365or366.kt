/*
package com.allianz.bmp.retail.core.offer.functions.calculateSettlement

import com.prowidesoftware.swift.utils.SwiftFormatUtils.isLeapYear
import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@ApplicationScoped
class CalculateSettlementFunction365or366 {
    fun calculate(calculateSettlementInput: CalculateSettlementInput, pricingCalcConfigDays: String): BigDecimal {
        val prorataDays = countDaysBetween(
            calculateSettlementInput.amendmentOfferData.effectiveDate, calculateSettlementInput.policyData.paymentPeriod?.endDate!!,
            pricingCalcConfigDays
        ).toBigDecimal()

        val premiumDays = countDaysBetween(
            calculateSettlementInput.policyData.paymentPeriod.startDate, calculateSettlementInput.policyData.paymentPeriod.endDate,
            pricingCalcConfigDays
        ).toBigDecimal()

        val oldAmounts = createAmounts(
            calculateSettlementInput.policyData.periodPremium!!,
            calculateSettlementInput.policyData.taxes
        )

        val nonConsumedPremium = calculateTotalTaxAndPremium(oldAmounts, premiumDays, prorataDays)

        val newAmount = createAmounts(
            calculateSettlementInput.amendmentOfferData.periodPremium!!,
            calculateSettlementInput.amendmentOfferData.taxes
        )

        val newAmendmentPremium = calculateTotalTaxAndPremium(newAmount, premiumDays, prorataDays)

        val settlement = newAmendmentPremium - nonConsumedPremium

        return settlement.setScale(SCALE, RoundingMode.HALF_UP)
    }

    private fun countDaysBetween(start: LocalDateTime, end: LocalDateTime, configDays: String): Int {
        val countOfDays = ChronoUnit.DAYS.between(start, end).toInt()
        if (configDays == "365" && checkIsLeapYear(start, end)) return countOfDays - 1

        return countOfDays
    }

    private fun checkIsLeapYear(start: LocalDateTime, end: LocalDateTime): Boolean =
        isLeapYear(start.year) && start.isBefore(createLocalDateTime(start.year, 2, 29)) && end.isAfter(
            createLocalDateTime(
                end.year,
                2,
                29
            )
        )

    private fun createLocalDateTime(year: Int, month: Int, day: Int): LocalDateTime = LocalDateTime.of(year, month, day, 0, 0, 0)
    private fun calculatePremiumForNumberOfDays(amount: BigDecimal, daysBtwnPremium: BigDecimal, diffDays: BigDecimal): BigDecimal =
        amount.divide(daysBtwnPremium, MathContext.DECIMAL128).multiply(diffDays)

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

    private fun calculateTotalTaxAndPremium(amounts: List<BigDecimal>, daysBtwnPremium: BigDecimal, diffDays: BigDecimal): BigDecimal {
        return amounts.fold(BigDecimal.ZERO) { acc, amount ->
            acc + calculatePremiumForNumberOfDays(amount, daysBtwnPremium, diffDays)
        }
    }

    companion object {
        private const val SCALE = 2
    }
}
*/
