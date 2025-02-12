package Wk2Wed

import Week2.Wed.NameLength
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NameLengthSpec extends AnyWordSpec with Matchers {

  val nameLength = new NameLength

  "NameLength" should {

    "return the length of the first name" when {
      "it is longer than the surname" in {
        val input = nameLength.getNameLength("Elizabeth", "Olsen")
        val expectedResult = 9
        input shouldBe expectedResult
      }
    }

    "return the length of the surname" when {
      "it is longer than the first name" in {
        val input = nameLength.getNameLength("Tom", "Hiddleston")
        val expectedResult = 10
        input shouldBe expectedResult
      }
    }

    "return 0" when {
      "the surname is equal in length to the first name" in {
        val input = nameLength.getNameLength("Chris", "Pratt")
        val expectedResult = 0
        input shouldBe expectedResult
      }

      //edge cases
      "empty strings are entered" in {
        val input = nameLength.getNameLength("", "")
        val expectedResult = 0
        input shouldBe expectedResult
      }

    }
  }
}
