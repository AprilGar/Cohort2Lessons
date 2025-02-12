package Wk2Wed
import Week2.Wed.FizzBuzz
import org.scalatest.flatspec.AnyFlatSpec

//AnyFlatSpec is FLAT - don't need {} after should
//If you are going to use nested test you'll need to use another testing spec.

class FizzBuzzTestSpec extends AnyFlatSpec {

  val fizzBuzz = new FizzBuzz //declaring my new FizzBuzz class

  "fizzBuzz" should "if divisible by 3 return fizz" in {
    assert(fizzBuzz.fizzBuzz(3) == "Fizz")
  }

  "fizzBuzz" should "if divisible by 5 return buzz" in {
    assert(fizzBuzz.fizzBuzz(5) == "Buzz")
  }

  "fizzBuzz" should "if divisible by 3 and 5 return FizzBuzz" in {
    assert(fizzBuzz.fizzBuzz(15) == "FizzBuzz")
  }

  //hitting my else - edge cases (error catching)
  "fizzBuzz" should "if not divisible by 3 or 5 return original number" in {
    assert(fizzBuzz.fizzBuzz(13) == "13")
  }

  "fizzBuzz" should "return 0 if 0 is original number" in {
    assert(fizzBuzz.fizzBuzz(0) == "0")
  }

}
