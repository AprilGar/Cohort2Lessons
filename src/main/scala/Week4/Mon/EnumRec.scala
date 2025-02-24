package Week4.Mon

import scala.annotation.tailrec

object EnumRec extends App {

  /** Recursion with enums */
  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value //stating this allows us to use DayOfWeek as a type
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  //Method that returns a concatenated string of names
  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    @tailrec
    def enumListToStringRec(dayEnums: List[DayOfWeek.Value], acc: String): String = { //helper method with acc for the final string result
      dayEnums match {
        case Nil => acc // Once list is empty return the acc
        case head :: tail => // Handles everything in the non-empty list
          val makeNiceToRead = if (acc.isEmpty) "" else ", " //Not essential, nice formatting only
          println(s"\nCurrent tail: $tail \nCurrent acc: $acc \nCurrent head: $head ")
          enumListToStringRec(tail, acc + makeNiceToRead + head.toString)
      }
    }

    enumListToStringRec(dayOfWeekEnums, "")
  }

  println("\n extend enumeration:")
  println(enumListToString(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday, DayOfWeek.Saturday, DayOfWeek.Sunday)))

  //If want to print all and use .values, need to change return to a ValueSet
  //    println(enumListToString(List(DayOfWeek.values)))

  /** Recursion with case objects */

  sealed trait DaysOfWeek

  case object Monday extends DaysOfWeek

  case object Tuesday extends DaysOfWeek

  case object Wednesday extends DaysOfWeek

  case object Thursday extends DaysOfWeek

  case object Friday extends DaysOfWeek

  case object Saturday extends DaysOfWeek

  case object Sunday extends DaysOfWeek

  def dayNamesToString(days: List[DaysOfWeek]): String = {
    @tailrec
    def dayNamesToStringRec(remaining: List[DaysOfWeek], acc: String): String = {
      remaining match {
        case Nil => acc //empty list
        case head :: tail =>
          val makePretty = if (acc.isEmpty) "" else ", "
          println(s"\nCurrent tail: $tail \nCurrent acc: $acc \nCurrent head: $head ")
          dayNamesToStringRec(tail, acc + makePretty + head)
      }
    }

    dayNamesToStringRec(days, "")
  }

  println("\n case objects:")
  println(dayNamesToString(List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)))

}
