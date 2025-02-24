package Week3.Fri

case class Name(value: String) //Q1

object Name { //Q10

  def nameOrError(maybeName: String): Either[InvalidNameError, Name] =
    if (maybeName.exists(_.isDigit)) //if it contains an int...
      Left(InvalidNameError("Not a valid name"))
    else //if it doesn't...
      Right(Name(maybeName))
}

case class Postcode(value: String) //Q1

object Postcode { //Q9
  def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] =
    maybePostCode match {
      case postcode if postcode.split(" ").length == 2 => Right(Postcode(maybePostCode))
      case _ => Left(InvalidPostcodeError("Not a valid postcode"))
    }
}

case class Letter(name: Name, postCode: Postcode) //Q2

object Letter { //Q11
  def letterOrError(maybeName: String, maybePostcode: String): Either[GenericPostageError, Letter] =
    for {
      name <- Name.nameOrError(maybeName)
      postCode <- Postcode.postcodeOrError(maybePostcode)
    } yield {
      Letter(name, postCode)
    }
}

trait GenericPostageError { //Q3
  def message: String
}

case class InvalidNameError(message: String) extends GenericPostageError //Q4

case class InvalidPostcodeError(message: String) extends GenericPostageError //Q5


object EitherLogic extends App {
  //  val letter: Right[GenericPostageError, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3"))) //Q6

  //  val invalidLetter: Left[InvalidNameError, Letter] = Left(InvalidNameError("Not a name!!!")) //Q6

  val letter: Right[Nothing, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3"))) //Q7

  val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError("Not a name!!!")) //Q7

  println("Right of a valid letter: " + letter) //Q8
  println("Left of an invalid letter: " + invalidLetter) //Q8

  val letterWithANumberInName: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12 CD3") //Q12

  val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh", maybePostcode = "AB12CD3") //Q12

  val letterAllInvalid: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12CD3") //Q12

  val letterAllValid: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh", maybePostcode = "AB12 CD3") //Q12

  println("\nMade using the .letterOrError method:")
  println("Left of a letter due to having numbers in the name: " + letterWithANumberInName) //Q13
  println("Left of a letter due to having no space in the postcode: " + letterWithAnInvalidPostcode) //Q13
  println("Left of a letter due to having invalid name and postcode: " + letterAllInvalid) //Q13 Name error printed as checks that first, finds it invalid and then leaves the for comp.
  println("Right of a valid letter: " + letterAllValid) //Q13

}

//RESEARCH - Explore error handling with Either compared to two other approaches; Try and Option.

//Either:
// - Good for expected error (e.g. validation)
// - Can be of multiple types including a Throwable
// - Makes error handling more explicit

//Try:
// - Good for unknown errors (exceptions)
// - Always of type Throwable
// - Handles capture of implicit exceptions

//Option:
// - Can handle the absence of values
// - Always of type None
// - Less informative