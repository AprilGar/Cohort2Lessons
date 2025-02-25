package Week4

import Week4.Mon.FibonacciCalc
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FibonacciCalcSpec extends AnyWordSpec with Matchers {

  val fibonacciCalc = new FibonacciCalc

  "fibonacciCalculator" should {

    "return a left" when {

      "return a string when negative inputs" in {
        fibonacciCalc.fibonacci(-1) shouldEqual Left("Enter a number greater than 0.")
      }
      "return 0 for fibonacci(0)" in {
        fibonacciCalc.fibonacci(0) shouldEqual Left("Enter a number greater than 0.")
      }

    }

    "return a right" when {

      "return 0 for fibonacci(1)" in {
        fibonacciCalc.fibonacci(1) shouldEqual Right(0)
      }

      "return 1 for fibonacci(2)" in {
        fibonacciCalc.fibonacci(2) shouldEqual Right(1)
      }

      "return 2 for fibonacci(3)" in {
        fibonacciCalc.fibonacci(3) shouldEqual Right(2)
      }

      "return 3 for fibonacci(4)" in {
        fibonacciCalc.fibonacci(4) shouldEqual Right(3)
      }

      "return 5 for fibonacci(5)" in {
        fibonacciCalc.fibonacci(5) shouldEqual Right(5)
      }

      "return 8 for fibonacci(6)" in {
        fibonacciCalc.fibonacci(6) shouldEqual Right(8)
      }

      "return 13 for fibonacci(7)" in {
        fibonacciCalc.fibonacci(7) shouldEqual Right(13)
      }

      "return 21 for fibonacci(8)" in {
        fibonacciCalc.fibonacci(8) shouldEqual Right(21)
      }

      "return 34 for fibonacci(9)" in {
        fibonacciCalc.fibonacci(9) shouldEqual Right(34)
      }

      "return 55 for fibonacci(10)" in {
        fibonacciCalc.fibonacci(10) shouldEqual Right(55)
      }

      "return 6765 for fibonacci(20)" in {
        fibonacciCalc.fibonacci(20) shouldEqual Right(6765)
      }
    }
  }
}
