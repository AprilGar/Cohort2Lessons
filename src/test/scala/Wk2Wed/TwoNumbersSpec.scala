package Wk2Wed

import Week2.Wed.TwoNumbers
import org.scalatest.flatspec.AnyFlatSpec

class TwoNumbersSpec extends AnyFlatSpec {

  "add" should "add x and y" in {
    val numbers = new TwoNumbers(1,2) //making a new instance of my class so I can access the methods.
    assert(numbers.add == 3) //this will return a boolean. Method == Expected
  }

  "subtract" should "subtract x from y" in { //y-x = 2-1
    val numbers = new TwoNumbers(1, 2)
    assert(numbers.subtract == 1)
  }

  "multipy" should "multipy x and y" in {
    val numbers = new TwoNumbers(4, 5)
    assert(numbers.multipy == 20)
  }

  // We want to test edge cases. We want our tests to be able to fail, but they still need to compile.
//  "multipy" should "error when the input is a double" in {
//    val numbers = new TwoNumbers(4.5, 5)
//    assert(numbers.multipy != 22)
//  }


}
