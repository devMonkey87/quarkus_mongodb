/*
package com.allianz.bmp.retail.core.offer.functions.calculateSettlement

import com.allianz.bmp.retail.core.error.ServerException
import com.allianz.bmp.retail.core.offer.configuration.QuoteCoreConfiguration
import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal
import java.time.LocalDateTime

data class CalculateSettlementInput(
    val amendmentOfferData: AmendmentOfferData,
    val policyData: PolicyData,
    val financeData: FinanceData? = null,
)

data class AmendmentOfferData(
    val effectiveDate: LocalDateTime,
    val annualNetPremium: BigDecimal? = null,
    val periodPremium: BigDecimal? = null,
    val taxes: MutableList<BigDecimal>? = null,
)

data class PolicyData(
    val annualNetPremium: BigDecimal? = null,
    val periodPremium: BigDecimal? = null,
    val paymentPeriod: PaymentPeriod? = null,
    val taxes: MutableList<BigDecimal>? = null,
)

data class FinanceData(val endInvoiceDate: LocalDateTime)
data class PaymentPeriod(val startDate: LocalDateTime, val endDate: LocalDateTime)

@ApplicationScoped
class CalculateSettlementFunction(
    private val quoteCoreConfiguration: QuoteCoreConfiguration,
    private val calculateSettlementFunction360: CalculateSettlementFunction360,
    private val calculateSettlementFunction365or366: CalculateSettlementFunction365or366,
) {
    fun calculate(calculateSettlementInput: CalculateSettlementInput): BigDecimal {
        val daysConfig = getPricingCalculationMode()
        return when (daysConfig) {
            "360" -> calculateSettlementFunction360.calculate(calculateSettlementInput)
            "365", "366" -> calculateSettlementFunction365or366.calculate(calculateSettlementInput, daysConfig)
            else -> throw ServerException("Invalid pricing calculation mode.")
        }
    }

    private fun getPricingCalculationMode(): String = quoteCoreConfiguration.functions().settlement().pricingCalculationMode()
}
*/
