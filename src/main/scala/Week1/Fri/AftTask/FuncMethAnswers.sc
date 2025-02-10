/** MVP */

//1.	Write a method to calculate the square of an Int. It should have an input parameter, Int and return type, Int.
def newSquared (number: Int): Int = number * number
newSquared(3) //calling to check it works

//2.	Write a method to check if a number is odd. It should have an input parameter, Int and return type, Boolean.
def isOdd(number: Int): Boolean  = number % 2 != 0
isOdd(3) //calling to check it works

//3.	Using a for comprehension and your methods from MVP Q1 and Q2, write a method that will filter the odd squared numbers from a List and return the sum of these odd squared numbers. It should have an input parameter, List[Int] and return type, Int.
val numbers:List[Int] = List(1,2,3,4,5,6,7,8,9,10)
def sumOfOddNumbers(numbers: List[Int]): Int = {
  val oddSquares = for {
    number <- numbers //iterate over the list
    square = newSquared(number) //calculate square (each value). Need to use = as the newSquared method returns an Int.
    if isOdd(square) //use an if guard, filter and keep only the odd values of square
  } yield square //collect all the odd squares
  oddSquares.sum //sum filtered odd squares by calling your val
}
sumOfOddNumbers(numbers)

// 4. Grading system

val studentScore: List[Int] = List(97, 75, 89)

def calculateAverage(scores: List[Int]): Double = {
  scores.sum / scores.length
}

def determineGrade(average: Double): String = {
  if (average >= 90) "A"
  else if (average >=80) "B"
  else if (average >=70) "C"
  else if (average >=60) "D"
  else "E"
}

def studentFinalGrade(scores:List[Int]): String = determineGrade(calculateAverage(scores))

studentFinalGrade(studentScore)

/** EXTENSION */
//SEE OBJECTS IN PACKAGE

/** Research */


/** Pure and Impure Functions */
//Pure: Given the same input(s) the output will always be the same.
//Impure: Given the same input(s) the output will be different if passed in multiple times.
//Bit of a spot the difference - val/var.

//Pure: Given the same input(s) the output will always be the same.
//Impure: Given the same input(s) the output will be different if passed in multiple times.

///**Example of pure: */
val sentence: String = ""

def append(sentence:String, word: String): String =
  sentence + " " + word.trim()

val a = append(sentence, "Allo") // "Allo"
val b = append(sentence, "Allo") // "Allo"

/** Example of impure: */
var sentence: String = ""

def append(word: String): String = {
  sentence = sentence + " " + word
  sentence.trim()
}

val a = append("Allo") // "Allo"
val b = append("Allo") // "Allo Allo"

////WHY? val and var. Immutable vs mutable.
//// passing in empty string as sentence for the pure.
//// Aim for pure! We want safe code!