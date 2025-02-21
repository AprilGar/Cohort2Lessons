package Week3.Thurs

import scala.reflect.{ClassTag, classTag}

object week3Day1Answer extends App {

  //1.

  def capitalCityOf(country: String): String = {
    country.toLowerCase.trim match {
      case "england" => "London"
      case "france" => "Paris"
      case "india" => "New Delhi"
      case "germany" => "Berlin"
      case "china" => "Beijing"
      case "columbia" => "Bogota"
      case _ => "Unknown"
    }
  }

  println("MVP 1:")
  println(capitalCityOf(" FrAnCE  ")) //Paris
  println(capitalCityOf("India")) //New Delhi
  println(capitalCityOf(" china")) //Beijing
  println(capitalCityOf("COLUMBIA")) //Bogota
  println(capitalCityOf("Australia")) //Unknown

  //2.
  sealed trait Animal
  case object Panda extends Animal
  case object Moose extends Animal
  case object Squirrel extends Animal

  def animalFact(animal: Animal): String = {
    animal match {
      case Panda => "Distinct black-and-white markings have two functions: camouflage and communication."
      case Moose => "Antlers stretch nearly six feet wide from tip to tip"
      case Squirrel => "Have four front teeth which never stop growing throughout their lives."
    }
  }

  println("\n\nMVP 2:")
  println(animalFact(Moose))


  //3a.

  import java.time.{LocalDate, Month}
  import java.time.temporal.ChronoUnit

  case class InputPerson(fullName: String, dateOfBirth: LocalDate, occupation: Option[String], lastCountryLivedIn: String, dateOfDeath: Option[LocalDate])

  case class Person(fullName: String, dateOfBirth: LocalDate, occupation: Option[String], lastCountryLivedIn: String, dateOfDeath: Option[LocalDate], age: Int, starSign: StarSign, ageAtDeath: Option[Int])

  sealed trait StarSign

  case object Aries extends StarSign

  case object Taurus extends StarSign

  case object Gemini extends StarSign

  case object Cancer extends StarSign

  case object Leo extends StarSign

  case object Virgo extends StarSign

  case object Libra extends StarSign

  case object Scorpio extends StarSign

  case object Sagittarius extends StarSign

  case object Capricorn extends StarSign

  case object Aquarius extends StarSign

  case object Pisces extends StarSign

  object StarSign {
    def determineStarSign(birthDate: LocalDate): StarSign = {
      val month: Month = birthDate.getMonth
      val day: Int = birthDate.getDayOfMonth
      if ((month == Month.MARCH && day >= 21 && day <= 31) || (month == Month.APRIL && day >= 1 && day <= 20)) Aries
      else if ((month == Month.APRIL && day >= 21 && day <= 30) || (month == Month.MAY && day >= 1 && day <= 21)) Taurus
      else if ((month == Month.MAY && day >= 22 && day <= 31) || (month == Month.JUNE && day >= 1 && day <= 21)) Gemini
      else if ((month == Month.JUNE && day >= 22 && day <= 30) || (month == Month.JULY && day >= 1 && day <= 22)) Cancer
      else if ((month == Month.JULY && day >= 23 && day <= 31) || (month == Month.AUGUST && day >= 1 && day <= 23)) Leo
      else if ((month == Month.AUGUST && day >= 24 && day <= 31) || (month == Month.SEPTEMBER && day >= 1 && day <= 22))
        Virgo
      else if ((month == Month.SEPTEMBER && day >= 23 && day <= 30) || (month == Month.OCTOBER && day >= 1 && day <= 23))
        Libra
      else if ((month == Month.OCTOBER && day >= 24 && day <= 31) || (month == Month.NOVEMBER && day >= 1 && day <= 22))
        Scorpio
      else if ((month == Month.NOVEMBER && day >= 23 && day <= 30) || (month == Month.DECEMBER && day >= 1 && day <= 22))
        Sagittarius
      else if ((month == Month.DECEMBER && day >= 23 && day <= 31) || (month == Month.JANUARY && day >= 1 && day <= 20))
        Capricorn
      else if ((month == Month.JANUARY && day >= 21 && day <= 31) || (month == Month.FEBRUARY && day >= 1 && day <= 19))
        Aquarius
      else Pisces
    }
  }

  def createPerson(input: InputPerson): Person = {
    val age: Int = input.dateOfDeath match {
      case Some(deathDate) => ChronoUnit.YEARS.between(input.dateOfBirth, deathDate).toInt
      case None => ChronoUnit.YEARS.between(input.dateOfBirth, LocalDate.now()).toInt
    }
    val starSign: StarSign = StarSign.determineStarSign(input.dateOfBirth)
    val ageAtDeath: Option[Int] = input.dateOfDeath match {
      case Some(deathDate) => Some(ChronoUnit.YEARS.between(input.dateOfBirth, deathDate).toInt)
      case None => None
    }

    Person(
      fullName = input.fullName,
      dateOfBirth = input.dateOfBirth,
      occupation = input.occupation,
      lastCountryLivedIn = input.lastCountryLivedIn,
      dateOfDeath = input.dateOfDeath,
      age = age,
      starSign = starSign,
      ageAtDeath = ageAtDeath
    )
  }

  val input = InputPerson(fullName = "Sir Fred of Foxly",
    dateOfBirth = LocalDate.of(2004, 2, 16),
    occupation = None,
    lastCountryLivedIn = "Canada",
    dateOfDeath = Some(LocalDate.of(2013, 11, 7)))

  println("\n\nMVP 3a:")
  println(createPerson(input)) //Person(Sir Fred of Foxly,2004-02-16,None,Canada,Some(2013-11-07),9,Aquarius,Some(9))

  //3b.
  def horoscope(birthDate: LocalDate): (StarSign, String) = {
    StarSign.determineStarSign(birthDate) match {
      case Aries => (Aries, "\nDon't let fear stand in your way. Move ahead.")
      case Taurus => (Taurus, "\nDon't be too hard on yourself if you're dragging a little toward the end of the day. ")
      case Gemini => (Gemini, "\nA new sense of stability and security may settle on love relationships and close friendships.")
      case Cancer => (Cancer, "\nYou might be introduced to new contacts, leading to increased opportunities.")
      case Leo => (Leo, "\nYour mind is in just the right space to participate in anything involving communication.")
      case Virgo => (Virgo, "\nYou're on a roll and it's likely to continue. Just pace yourself.")
      case Libra => (Libra, "\nIn spite of all the great things in your life, you might find yourself feeling a little blue sometime during the day.")
      case Scorpio => (Scorpio, "\nConsider the situation and list your tasks in order of urgency.")
      case Sagittarius => (Sagittarius, "\nA depressed friend may need cheering up.")
      case Capricorn => (Capricorn, "\nDon't be afraid to ask for a little help.")
      case Aquarius => (Aquarius, "\nYou might be considering a travel adventure or perhaps going back to school for an advanced degree.")
      case Pisces => (Pisces, "\nTonight, don't be surprised if you have vivid dreams - some great, some sad.")
    }
  }

  println("\n\nMVP 3b:")
  println(horoscope(LocalDate.of(1997, 5, 14)))

  //Extension 1.a.
  sealed trait AnimalExt1
  case class Elephant(speciesName: String) extends AnimalExt1
  case class Rhinoceros(speciesName: String) extends AnimalExt1
  case class Dog(speciesName: String) extends AnimalExt1
  case class Turtle(speciesName: String) extends AnimalExt1

  //Extension 1.b.
  val criticallyEndangered: List[String] = List("black rhino", "african forest elephant", "orangutan", "hawksbill turtle", "sunda tiger", "javan rhino")

  def animalFacts(animal: AnimalExt1): List[String] = {
    animal match {
      case Elephant(speciesName) if criticallyEndangered.contains(speciesName.toLowerCase.trim) =>
        List(s"$speciesName have 26 teeth and 6 set in lifetime.", s"The $speciesName is a critically endangered species.")
      case Elephant(speciesName) => List(s"$speciesName have 26 teeth and 6 through 6 set in lifetime.")
      case Rhinoceros(speciesName) if criticallyEndangered.contains(speciesName.toLowerCase.trim) => List(s"$speciesName can weigh over 3 tonnes.", s"The $speciesName is a critically endangered species.")
      case Rhinoceros(speciesName) => List(s"$speciesName can weigh over 3 tonnes.")
      case Dog(speciesName) if criticallyEndangered.contains(speciesName.toLowerCase.trim) => List(s"$speciesName sense of smell is at least 40x better than humans", s"The $speciesName is a critically endangered species.")
      case Dog(speciesName) => List(s"$speciesName sense of smell is at least 40x better than humans")
      case Turtle(speciesName) if criticallyEndangered.contains(speciesName.toLowerCase.trim) => List(s"$speciesName date back to the time of the dinosaurs, over 200 million years ago.", s"The $speciesName is a critically endangered species.")
      case Turtle(speciesName) => List(s"$speciesName date back to the time of the dinosaurs, over 200 million years ago.")
    }
  }

  println("\n\nEx 1.b:")
  println(animalFacts(Elephant("African forest Elephant")))// critically endangered species.
  println(animalFacts(Elephant("African savanna Elephant")))
  println(animalFacts(Rhinoceros("White Rhino")))
  println(animalFacts(Rhinoceros("Black Rhino"))) // critically endangered species.
  println(animalFacts(Dog("Samoyed")))
  println(animalFacts(Turtle("hawksbill turtle"))) // critically endangered species.
  println(animalFacts(Turtle("Leatherback Turtle")))

  //1.b.
  // The answer to question EXT1b using pattern matching is not exhaustive when using if guards. Can you make this method exhaustive for pattern matching?
  //Move the if statement to after the =>

  //Research:
  // Always returns a list of doubles. WHy? Type erasure.
  // The type (T) is erased when run, meaning that List[T] is actually List[Any] when we pattern match.

  println("\n\nResearch:")

//  def checkListType[T](list: List[T]): String = list match {
//    case _: List[Double] => "List of Doubles"
//    case _: List[String] => "List of Strings"
//    case _: List[Int] => "List of Ints"
//    case _ => "Unknown"
//  }

  val numList: List[Int] = List(1, 2, 3)
  val doubleList: List[Double] = List(1.0, 2.0, 3.0)
  val stringList: List[String] = List("1", "2", "3")

  println(checkListType(numList))
  println(checkListType(doubleList))
  println(checkListType(stringList))

  // A get around - use a class tag - this will need to be imported and will preserve the type information at runtime.

  def checkListType[T](list: List[T])(implicit ct: ClassTag[T]): String = ct match {
    case _ if ct == classTag[Double] => "List of Doubles"
    case _ if ct == classTag[String] => "List of Strings"
    case _ if ct == classTag[Int]    => "List of Ints"
    case _ => "Unknown"
  }

}
