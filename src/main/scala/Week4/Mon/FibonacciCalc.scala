package Week4.Mon

import scala.annotation.tailrec

class FibonacciCalc {

  def fibonacci(n: Int): Either[String, Int] = {
    @tailrec
    def calc(i: Int, acc: Int, prevPrev: Int): Either[String, Int] = {
      if (i >= n) Right(acc) //if index position(i) has reached the n (inputted position) return the fib number at that position.
      else calc(i + 1, acc + prevPrev, acc) //i - keeps track of the index position, acc - holds the current number, prevPrev - holds the previous number
    }
    if (n <= 0) Left("Enter a number greater than 0.") //ensures we are entering a number greater than 1
    else if (n == 1) Right(0) //First fib num is 0 so return this if position 1 is asked as `n`
    else calc(2, 1, 1) //starts the recursive method. Start at index position 2 as 0 and 1 are already defined above in the if and else if.
  }

}
