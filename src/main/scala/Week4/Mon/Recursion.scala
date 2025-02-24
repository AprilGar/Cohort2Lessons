package Week4.Mon

import scala.annotation.tailrec

object Recursion extends App {

  //Standard recursion
  // recursive calls which call the original method inside the method
  // each new call adds to the call stack
  // method will remember all of these calls before completing
  // will continue to recursively call until the base case is reached
  // Once base case is reached, it will resolve in reverse order

  //Factorial method - multiply all positive Ints in a list (input = 4 --> 4x3x2x1)
  def factorial(n: Int): Int = {
    if (n <= 1) { //HOW I ESCAPE TO RECURSION
      1 //base case - when you get to 1, return 1 and then the stored call stack can start unwinding
    } else {
      println(s"Incoming n is: $n")
      println(s"New n: ${n - 1}")
      val finalResult = n * factorial(n - 1)
      println(s"Final n call: $n") //won't reach this until the base case has been reached and it starts unwinding through the call stack
      finalResult
    }
  }

  println(factorial(4))
  //Pseudocode - factorial(4)
  //Recursive loop - call stack -- not yet evaluated (waiting until the loop ends to evaluate)
  // factorial(4) --> 4 X factorial(4-1) --> factorial(3) - Bottom
  // factorial(3) --> 3 X factorial(3-1) --> factorial(2)
  // factorial(2) --> 2 X factorial(2-1) --> factorial(1) - top
  // factorial(1) --> hitting the base case (exit the recursive loop) --> return 1
  //UNWIND --> top to bottom
  // factorial(2) --> 2 X factorial(2-1) --> 2 X factorial(1) --> 2 X 1 = 2
  // factorial(3) --> 3 X factorial(3-1) --> 3 X factorial(2) --> 3 X 2 = 6
  // factorial(4) --> 4 X factorial(4-1) --> 4 X factorial(3) --> 4 X 6 = 24
  // Final result = 24

  //Stack overflow error - there is only so much memory in the call stack. If this is exceeded we get this error.
  //  println(factorial(10000))

  /** TAIL recursion */
  // Smarter way to write recursion because it stops stack overflow errors.
  // Key differences:
  // 1. recursive call must be the last operation a function performs. (@tailrec - will check this)
  // 2. Prevents stack overflow error:
  // a. doesn't need to remember all previous values, all needed information is passed through as an accumulator (acc).
  // b. Scala replaces recursive calls with a simple loop under the hood, called Tail call optimization (TCO).
  // Replaces and updates the acc with every recursive call.

  //1st - with a helper method

  def smarterFactorial(n: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int = { // helper - don't have to change the original method signature
      if (x <= 1) {
        println(s"\nCurrent X inside if: $x")
        println(s"Value of current acc inside if: $acc")
        acc
      } //acc = superstar - stores the intermediate value, don't need to have a large memory as call stack is being updated each time. Acc will store, pass in and update each time.
      else {
        println(s"\nCurrent X inside else: $x")
        println(s"Value of current acc inside else: $acc")
        factorialHelper(x-1, acc * x) //last expression = tail rec. Override old values and pass in a new updated acc each time.
        // x-1 --> moving down our numbers list
        // acc * x --> running total
      }
    }
    factorialHelper(n, 1) //call the helper, pass in the original n so we start the recursion at the top level, acc will start at the if case.
  }

  println("\nTail rec with helper: " + smarterFactorial(4))

  //Tail rec without helper method
  @tailrec
  def smarterFactorialWithoutHelper(n: Int, acc:Int = 1): Int = {
    if (n <= 1) acc
    else smarterFactorialWithoutHelper(n-1, acc * n)
  }
  println("\nTail rec without helper: " + smarterFactorialWithoutHelper(4))

    // Example with string
    @tailrec
    def concatenateWords(aWord: String, n:Int, acc:String): String = {
    if (n<=0) {
      println(s"current aWord inside if: $aWord")
      println(s"current acc inside if: $acc")
      acc
    }
    else {
      println(s"current aWord inside else: $aWord")
      println(s"current acc inside else: $acc")
      concatenateWords(aWord, n - 1, aWord + acc)
    }
  }
  println(concatenateWords("Hello World!", 3, ""))

  /** TASK 1 */
  val lettersList: List[String] = List("A", "B", "C")

  // a - standard recursion using if/else
  def numOfElementsInListIfElse(list: List[String]): Int = {
    if (list.isEmpty) {
      println(s"Inside if: $list")
      0
    }
    else {
      println(s"Inside else: $list")
      1 + numOfElementsInListIfElse(list.tail)
    }
  }

  println("\nTask 1 - recursion - if/else:")
  println("numOfElementsIfElse: " + numOfElementsInListIfElse(lettersList))

  // b - tail recursion using if/else (no helper)
  @tailrec
  def tailNumOfElementsInListIfElse(list: List[String], accumulator: Int): Int = {
    if (list.isEmpty) accumulator
    else tailNumOfElementsInListIfElse(list.tail, accumulator + 1)
  }

  println("\nTask 1 - tail recursion - if/else:")
  println("tailNumOfElementsInListIfElse: " + tailNumOfElementsInListIfElse(lettersList, 0))

  //b - tail recursion using if/else (with helper)
  def tailNumOfElementsInListIfElseHelperMethod(list: List[String]) = {
    @tailrec
    def tailNumOfElementsInListIfElseHelper(list: List[String], accumulator: Int): Int = {
      if (list.isEmpty) accumulator
      else tailNumOfElementsInListIfElseHelper(list.tail, accumulator + 1)
    }

    tailNumOfElementsInListIfElseHelper(list, 0)
  }

  println(("tailNumOfElementsInListIfElse with helper: " + tailNumOfElementsInListIfElseHelperMethod(lettersList)))

  // Extension - standard recursion using pattern matching
  def numOfElementsInListMatch(list: List[String]): Int = list match {
    case Nil => 0
    case head :: tail =>
      //      println(s"Current head: $head")
      //      println(s"Current tail: $tail")
      1 + numOfElementsInListMatch(tail)
  }

  println("\nTask 1 - recursion - pattern match:")
  println("numOfElementsInListMatch: " + numOfElementsInListMatch(lettersList))

  //Extension - tail recursion using pattern matching (no helper)
  @tailrec
  def tailNumOfElementsInListMatch(list: List[String], accumulator: Int): Int = list match {
    case Nil => accumulator
    case head :: tail => tailNumOfElementsInListMatch(tail, accumulator + 1)
  }

  println("\nTask 1 - tail recursion - pattern match:")
  println("tailNumOfElementsInListMatch: " + tailNumOfElementsInListMatch(lettersList, 0))

  //Extension - tail recursion using pattern matching (with helper)
  def tailNumOfElementsInListMatchHelperMethod(list: List[String]): Int = {
    @tailrec
    def tailNumOfElementsInListMatchHelper(list: List[String], accumulator: Int): Int = list match {
      case Nil => accumulator
      case head :: tail => tailNumOfElementsInListMatchHelper(tail, accumulator + 1)
    }

    tailNumOfElementsInListMatchHelper(list, 0)
  }

  println("\nTask 1 - tail recursion - pattern match:")
  println("tailNumOfElementsInListMatch: " + tailNumOfElementsInListMatchHelperMethod(lettersList))

 }
