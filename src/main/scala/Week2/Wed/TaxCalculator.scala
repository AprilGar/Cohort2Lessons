package Week2.Wed

import java.text.NumberFormat
import java.util.Locale

class TaxCalculator {

  // Tax bands (simplified to make testing a bit easier)
  private val personalAllowance: Int = 10000
  private val basicRateLimit: Int = 50000
  private val higherRateLimit: Int = 125000

  // Tax rates
  private val personalAllowanceRate: Double = 0
  private val basicRate: Double = 0.2
  private val higherRate: Double = 0.4
  private val additionalRate: Double = 0.45

  // Capital gains tax rate
  private val cgtLowerRate: Double = 0.1
  private val cgtHigherRate: Double = 0.2

  // A method to calculate the total amount of tax to be paid, returned as a double
  def calculateTax(income: Double): Double = {
    if (income <= personalAllowance) {
      0
    } else if (income <= basicRateLimit) {
      val totalForCurrentTaxBracket: Double = (income - personalAllowance) * basicRate
      totalForCurrentTaxBracket
    } else if (income <= higherRateLimit) {
      val totalFromPreviousTaxBrackets: Double = (basicRateLimit - personalAllowance) * basicRate
      val totalForCurrentTaxBracket: Double = (income - basicRateLimit) * higherRate
      totalFromPreviousTaxBrackets + totalForCurrentTaxBracket
    } else {
      val totalFromPreviousTaxBrackets: Double = (basicRateLimit - personalAllowance) * basicRate + (higherRateLimit - basicRateLimit) * higherRate
      val totalForCurrentTaxBracket: Double = (income - higherRateLimit) * additionalRate
      totalFromPreviousTaxBrackets + totalForCurrentTaxBracket
    }
  }

  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxpayer(income: Double): Boolean = {
    income > basicRateLimit
  }

  // A method that will return a string with the income limit of their current tax band.
  // The return will also be formatted, E.g: "£12,500" or "No limit"
  def formattedCurrentTaxAllowance(income: Double): String = {
    if (income <= personalAllowance) {
      formatInGbp(personalAllowance)
    } else if (income <= basicRateLimit) {
      formatInGbp(basicRateLimit)
    } else if (income <= higherRateLimit) {
      formatInGbp(higherRateLimit)
    } else {
      "No limit"
    }
  }

  private def formatInGbp(income: Int): String = {
    val formatter = NumberFormat.getCurrencyInstance(Locale.UK)
    formatter.format(income)
  }

  def calculateCapitalGainsTax(income: Double, capitalGain: Double): Double = {
    if ((income + capitalGain) <= basicRateLimit) {
      Math.round((capitalGain * cgtLowerRate) * 100.0) / 100.0
    } else if (income < basicRateLimit) {
      val taxAtLowerRate: Double = (basicRateLimit - income) * cgtLowerRate
      val taxAtHigherRate: Double = ((income + capitalGain) - basicRateLimit) * cgtHigherRate
      Math.round((taxAtLowerRate + taxAtHigherRate) * 100.0) / 100.0
    } else {
      Math.round((capitalGain * cgtHigherRate) * 100.0) / 100.0
    }
  }

  def totalTax(income: Double, capitalGain: Double): Double = {
    calculateTax(income) + calculateCapitalGainsTax(income, capitalGain)
  }

}
