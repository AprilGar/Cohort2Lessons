package Wk2Wed

import Week2.Wed.TaxCalculator
import org.scalatest.wordspec.AnyWordSpec

class TaxCalculatorSpec extends AnyWordSpec {

  val taxCalculator: TaxCalculator = new TaxCalculator

  // I've done the first test for you!
  "TaxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }
      "the income is at the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(10000)

        assert(result == 0)
      }
      "the income is within the basic rate limit" in {
        val result: Double = taxCalculator.calculateTax(20000)

        assert(result == 2000)
      }
      "the income is at the basic rate limit" in {
        val result: Double = taxCalculator.calculateTax(50000)

        assert(result == 8000)
      }
      "the income is within the higher rate limit" in {
        val result: Double = taxCalculator.calculateTax(60000)

        assert(result == 12000)
      }
      "the income is at the higher rate limit" in {
        val result: Double = taxCalculator.calculateTax(125000)

        assert(result == 38000)
      }
      "the income is above the higher rate limit" in {
        val result: Double = taxCalculator.calculateTax(150000)

        assert(result == 49250)
      }
    }
  }
  "TaxCalculator.isHigherRateTaxpayer" should {
    "return true" when {
      "the income level is just above the basic rate limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(50001)

        assert(result)
      }
      "the income level is far above the basic rate limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(250000)

        assert(result)
      }
    }
    "return false" when {
      "the income level is at the basic rate limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(50000)

        assert(!result)
      }
      "the income level is far below the basic rate limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(5000)

        assert(!result)
      }
    }
  }
  "TaxCalculator.formattedCurrentTaxAllowance" should {
    "return £10,000" when {
      "taxpayer is below the personal allowance threshold" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(5000)

        assert(result == "£10,000.00")
      }
    }
    "return £50,000" when {
      "taxpayer is in the basic tax rate band" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(30000)

        assert(result == "£50,000.00")
      }
    }
    "return £125,000" when {
      "taxpayer is within the higher tax rate band" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(75000)

        assert(result == "£125,000.00")
      }
    }
    "return No limit" when {
      "taxpayer is above the higher tax rate band" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(150000)

        assert(result == "No limit")
      }
    }
  }
  "TaxCalculator.calculateCapitalGainsTax" should {
    "return the total capital gains tax" when {
      "total income is below £50,000" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(5000, 10000)

        assert(result == 1000)
      }
      "income is below £50,000 and capital gains take total income above £50,000" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(45000, 10000)

        assert(result == 1500)
      }
      "income is above £50,000" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(55000, 10000)

        assert(result == 2000)
      }
      "total income equals £49,999.50" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(25000, 24999.5)

        assert(result == 2499.95)
      }
      "total income equals £50,000" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(25000, 25000)

        assert(result == 2500)
      }
      "total income equals £50,000.50" in {
        val result: Double = taxCalculator.calculateCapitalGainsTax(25000, 25000.5)

        assert(result == 2500.1)
      }
    }
  }

  // No need to add too many unit tests. The other methods we are calling have already been tested extensively!
  "TaxCalculator.totalTax" should {
    "return the total tax amount" when {
      "income tax and capital gains are defined" in {
        val result: Double = taxCalculator.totalTax(40000, 40000)

        assert(result == 13000)
      }
    }
  }
}
