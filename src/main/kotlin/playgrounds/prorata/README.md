# Calculate Settlement Function

## Functionality

Calculate the settlement of an amendment offer to be included in the first next payment using a 360-day year calculation. It determines the settlement (premium difference before and after the amendment) based on the number of days between the amendment effective date and the invoice end date.

To calculate the number of days between the start and end date it uses 360-day year calculation method, where a year has 360 days and all the months have 30 days (no other values are considered). In this way, all payment installments are equal, regardless of frequency. The following invoices (subsequent invoicing) of the amendment, if any, should be covered by the normal calculation of the premium.

- Example 1: if the start date is 2024/03/27 and the end date is 2024/03/30, the number of days to consider is 3.
- Example 2: if the start date is 2024/03/27 and the end date is 2024/03/31, the number of days to consider is 3.

Both examples have the same number of days because of the 360-day year calculation method, hence the returned settlement amount will be the same for both. Every month has 30 days and day 31 is ignored.

The settlement amount is calculated as:

```text
numberOfDays = countDaysBetweenBased360(amendmentEffectiveDate, endInvoiceDate)
ncp = (policyAnnualNetPremium / 360) * numberOfDays
nap = (amendmentAnnualNetPremium / 360) * numberOfDays
settlement = nap - ncp
```

## How to use

The function can be used **only** for one-year policies.

### Function input

The method takes a single input object, `CalculateSettlementInput`, containing all the needed data:

- `amendmentOfferData.effectiveDate`: amendment offer effective date.
- `amendmentOfferData.annualNetPremium`: amendment offer annual net premium.
- `policyData.annualNetPremium`: policy annual net premium.
- `financeData.endNextInvoiceDate`: payment period end date.

### Function output

The function returns the calculated settlement as a `BigDecimal` rounded half-up to two decimals precision. A positive value is what the client has to pay, and a negative value is the amount to return to the client.
