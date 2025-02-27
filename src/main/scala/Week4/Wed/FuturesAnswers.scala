package Week4.Wed

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

case class Name(value: String)

object Name {
    def nameOrError(maybeName: String): Either[InvalidNameError, Name] =
        if (maybeName.exists(_.isDigit)) //if it contains an int...
            Left(InvalidNameError("Not a valid name"))
        else //if it doesn't...
            Right(Name(maybeName))
}

case class Postcode(value: String)

object Postcode{
    def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] =
        maybePostCode match {
            case postcode if postcode.split(" ").length == 2 => Right(Postcode(maybePostCode))
            case _ => Left(InvalidPostcodeError("Not a valid postcode"))
        }
}

case class Letter(name: Name, postCode: Postcode)

object Letter {
    def letterOrError(maybeName: String, maybePostcode: String): Either[GenericPostageError, Letter] =
        for {
            name <- Name.nameOrError(maybeName)
            postCode <- Postcode.postcodeOrError(maybePostcode)
        } yield {
            Letter(name, postCode)
        }
}

trait GenericPostageError {
    def message: String
}

case class InvalidNameError(message: String) extends GenericPostageError

case class InvalidPostcodeError(message: String) extends GenericPostageError

object EitherLogic extends App  {
    implicit val ec: ExecutionContext = ExecutionContext.global //Q1

    private val letter: Right[Nothing, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3")))

    private val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError("Not a name!!!"))

    private val letterWithANumberInName: Either[GenericPostageError, Letter] =
        Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12 CD3")

    private val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] =
        Letter.letterOrError(maybeName = "Simon Singh", maybePostcode = "AB12CD3")

    private val letterAllInvalid: Either[GenericPostageError, Letter] =
        Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12CD3")

    private def fetchLetter(): Future[Letter] = Future { //Q2
//        Thread.sleep(10000000) //Q7 - waiting to long, getting a time out and hitting the left.
        Thread.sleep(2)
        Letter(Name("Simon Singh"), Postcode("AB12 CD3"))
    }

    private val eventualLetter: Future[Letter] = fetchLetter() //Q3

    //EXT Q1
    private def fetchLetterOrError(name: String, postCode: String): Future[Either[GenericPostageError, Letter]] =
        Future {
            Thread.sleep(2)
//            Thread.sleep(10000000)
            Letter.letterOrError(name, postCode)
        }

    //EXT Q2
    private val eventualLetterOrError: Future[Either[GenericPostageError, Letter]] =
//        fetchLetterOrError("123", "ABC") //Invalid - hit left
        fetchLetterOrError("Simon Singh", "AB12 CD3") //Valid - hit right


        println(letter)
        println(invalidLetter)
        println(letterWithANumberInName)
        println(letterWithAnInvalidPostcode)
        println(letterAllInvalid)

        eventualLetter.value match { //Q5
            case Some(Success(foundLetter)) =>
                println(s"Letter found! $foundLetter")
            case Some(Failure(exception)) =>
                println(s"The future completed with an $exception")
            case None =>
                println("Future did not complete in the given time")
        }

    // EXT Q4
        eventualLetterOrError.value match {
            case Some(Success(foundLetter)) =>
                println(s"Letter found! $foundLetter")
            case Some(Failure(exception)) =>
                println(s"The future completed with an  $exception")
            case None =>
                println("Future did not complete in the given time")
        }

        Await.ready(eventualLetter, 2.seconds) //Q4
        Await.ready(eventualLetterOrError, 2.seconds) //EXT Q3


    }

