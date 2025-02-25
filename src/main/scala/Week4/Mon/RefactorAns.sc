import scala.annotation.tailrec


// MVP Exercise 1

object Euro2024 extends Enumeration {
  val albania = Value("Albania")
  val austria = Value("Austria")
  val belgium = Value("Belgium")
  val czechia = Value("Czechia")
  val croatia = Value("Croatia")
  val denmark = Value("Denmark")
  val england = Value("England")
  val france = Value("France")
  val georgia = Value("Georgia")
  val germany = Value("Germany")
  val hungary = Value("Hungary")
  val italy = Value("Italy")
  val netherlands = Value("Netherlands")
  val poland = Value("Poland")
  val portugal = Value("Portugal")
  val romania = Value("Romania")
  val scotland = Value("Scotland")
  val serbia = Value("Serbia")
  val slovakia = Value("Slovakia")
  val slovenia = Value("Slovenia")
  val spain = Value("Spain")
  val switzerland = Value("Switzerland")
  val turkey = Value("Turkey")
  val ukraine = Value("Ukraine")

}

//IF/ELSE
def euroListToString(fullEuroEnums: List[Euro2024.ValueSet]): String = {
  @tailrec
  def euroListToStringRec(euroEnums: List[Euro2024.ValueSet], acc: String): String = {
    if (euroEnums.isEmpty) acc // Base case: empty list
    else {
      val head = euroEnums.head
      val tail = euroEnums.tail
      val makeNiceToRead = if (acc.isEmpty) "" else ", "
      euroListToStringRec(tail, acc + makeNiceToRead + head.toString)
    }
  }

  euroListToStringRec(fullEuroEnums, "")
}
println("Q1 using if/else:")
println(euroListToString(List(Euro2024.values)))
//MATCH
def euroListToStringMatch(fullEuroEnums: List[Euro2024.ValueSet]): String = {
  @tailrec
  def euroListToStringRec(euroEnums: List[Euro2024.ValueSet], acc: String): String = {
    euroEnums match {
      case Nil => acc
      case head :: tail =>
        val makeNiceToRead = if (acc.isEmpty) "" else ", "
        euroListToStringRec(tail, acc + makeNiceToRead + head.toString)
    }
  }

  euroListToStringRec(fullEuroEnums, "")
}
println("Q1 using Match case:")
println(euroListToStringMatch(List(Euro2024.values)))

// MVP Exercise 2

sealed class Team(val name: String) //Val in the class params to make it accessible.

object Team {
  case object albania extends Team("Albania")

  case object austria extends Team("Austria")

  case object belgium extends Team("Belgium")

  case object czechia extends Team("Czechia")

  case object croatia extends Team("Croatia")

  case object denmark extends Team("Denmark")

  case object england extends Team("England")

  case object france extends Team("France")

  case object georgia extends Team("Georgia")

  case object germany extends Team("Germany")

  case object hungary extends Team("Hungary")

  case object italy extends Team("Italy")

  case object netherlands extends Team("Netherlands")

  case object poland extends Team("Poland")

  case object portugal extends Team("Portugal")

  case object romania extends Team("Romania")

  case object scotland extends Team("Scotland")

  case object serbia extends Team("Serbia")

  case object slovakia extends Team("Slovakia")

  case object slovenia extends Team("Slovenia")

  case object spain extends Team("Spain")

  case object switzerland extends Team("Switzerland")

  case object turkey extends Team("Turkey")

  case object ukraine extends Team("Ukraine")
}

//There are too many to write out...
val teamList = List(Team.albania, Team.austria, Team.belgium, Team.czechia, Team.croatia)

//If/else
def teamNamesToString(teams: List[Team]): String = {
  @tailrec
  def teamNamesToStringRec(remaining: List[Team], acc: String): String = {
    if (remaining.isEmpty) acc // Base case: empty list
    else {
      val head = remaining.head
      val tail = remaining.tail
      val makeNiceToRead = if (acc.isEmpty) "" else ", "
      teamNamesToStringRec(tail, acc + makeNiceToRead + head.name)
    }
  }

  teamNamesToStringRec(teams, "")
}
println("Q2 using if/else:")
println(teamNamesToString(teamList))

//Match
def teamNamesToStringMatch(teams: List[Team]): String = {
  @tailrec
  def teamNamesToStringRec(remaining: List[Team], acc: String): String = {
    remaining match {
      case Nil => acc
      case ::(head, tail) =>
        val makeNiceToRead = if (acc.isEmpty) "" else ", "
        teamNamesToStringRec(tail, acc + makeNiceToRead + head.name)
    }
  }

  teamNamesToStringRec(teams, "")
}
println("Q2 using Match case:")
println(teamNamesToStringMatch(teamList))
//No simple method to access the full list, like we could with enums.


// MVP Exercise 3

//If/else
def additionCalculator(upperNumber: Int): Int = {
  @tailrec
  def calculation(acc: Int, number: Int): Int = {
    if (number == 0) acc
    else calculation(acc + number, number - 1)
  }

  calculation(0, upperNumber)
}
println(additionCalculator(5))

//Match
def additionCalculatorMatch(upperNumber: Int): Int = {
  @tailrec
  def calculation(acc: Int, number: Int): Int = {
    number match {
      case 0 => acc
      case _ => calculation(acc + number, number - 1)
    }
  }

  calculation(0, upperNumber)
}
println(additionCalculatorMatch(5))

// MVP Exercise 4

//val numbers: List[Int] = (1 to 20).toList
val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

//IF/ELSE
def isEven(index: Int): Either[String, Boolean] = {
  @tailrec
  def checkEven(numlist: List[Int], index: Int): Either[String, Boolean] = {
    if (index < 0) Left("Index is out of bounds as negative.") // Negative
    else if (numlist.isEmpty) Left("Index is out of bounds.") // Empty list
    else if (index == 0) Right(numlist.head % 2 == 0) // Check if first element is even
    else checkEven(numlist.tail, index - 1) // Keep tail, decrease index by 1
  }

  checkEven(numlist = numbers, index)
}
println("\nQ4 using if/else:")
isEven(index = -23) //left - out of bounds
isEven(index = 42) //left - out of bounds
isEven(index = 0) //right - false = odd
isEven(index = 1) //right - true = even
isEven(index = 2) //right - false = odd

//MATCH
def isEvenMatch(index: Int): Either[String, Boolean] = {
  // the helper method below will recursively move through a list until it reaches the inputted index position.
  def checkEven(numlist: List[Int], index: Int): Either[String, Boolean] = {
    (numlist, index) match {
      // If index is out of bounds, return an error
      case (_, negNum) if negNum < 0 => Left("Index is out of bounds as negative.")
      //Check empty list
      case (Nil, _) => Left("Index is out of bounds.")
      // If index is 0, check the element for even/odd. x represents the head of the list here and _ represents the tail.
      case (x :: _, 0) => Right(x % 2 == 0)
      // Recursively check the next element. _ represents the head and x represents the tail.
      case (_ :: x, i) => checkEven(x, i - 1) //keep the tail, decrease index position by 1.
    }
  }

  checkEven(numlist = numbers, index)
}
println("\nQ4 using match:")
isEvenMatch(index = -23) //left - out of bounds
isEvenMatch(index = 42) //left - out of bounds
isEvenMatch(index = 0) //right - false = odd
isEvenMatch(index = 1) //right - true = even
isEvenMatch(index = 2) //right - false = odd
//Broken down for index = 2
// first call: hits _ :: x --> 1 :: 2,3,4 etc => checkEven(2,3,4 etc, 2(index position)-1)
// second call: hits _ :: x --> 2 :: 3,4,5 etc => checkEven(3,4,5etc, 1-0)
// third call: hits x :: _ --> 3 :: 4,5,6 etc => Right(3 % 2 == 0) == false


/** Research
 * Enums
 * Pros:
 * Easy to define and use.
 * Built-in support for iterating over values and comparing them.
 * Cons:
 * Less type-safe compared to case objects.
 * Limited extensibility and pattern matching capabilities.
 * Enumeration values are not as rich as case objects, lacking custom methods and fields.
 * Case objects:
 * Pros:
 * Strong type-safety: Each case object is a distinct type, making it easier to catch errors at compile time.
 * Extensible: Case objects can implement traits, contain methods, and have additional fields.
 * Powerful pattern matching: Pattern matching with case objects is more powerful and expressive.
 * Better support for recursion: Since you can define methods and fields, you can more easily use them in recursive algorithms.
 * Cons:
 * Slightly more boilerplate code compared to enumerations.
 *
 * Use enums with simpler code, case objects with more complex code. Remember using 'sealed' will help make matches exhaustive.
 * */