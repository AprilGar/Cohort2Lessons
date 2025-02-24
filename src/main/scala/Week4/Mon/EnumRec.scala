package Week4.Mon

import scala.annotation.tailrec

object EnumRec extends App {

  /** Recursion with enums */
  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value //stating this allows us to use DayOfWeek as a type
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  //Method that returns a concatenated string of names

  //IF ELSE
  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    @tailrec
    def enumListToStringRec(dayEnums: List[DayOfWeek.Value], acc: String): String = {
      if (dayEnums.isEmpty) acc // Once the list is empty, return the acc
      else {
        val head = dayEnums.head
        val tail = dayEnums.tail
        val makeNiceToRead = if (acc.isEmpty) "" else ", " // Not essential, nice formatting only
        println(s"\nCurrent tail: $tail \nCurrent acc: $acc \nCurrent head: $head ")
        enumListToStringRec(tail, acc + makeNiceToRead + head.toString)
      }
    }

    enumListToStringRec(dayOfWeekEnums, "")
  }

  println("\n extend enumeration - If Else:")
  println(enumListToStringMatch(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday, DayOfWeek.Saturday, DayOfWeek.Sunday)))

  //PATTERN MATCH
  def enumListToStringMatch(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
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
  println("\n extend enumeration - Patten match:")
  println(enumListToStringMatch(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday, DayOfWeek.Saturday, DayOfWeek.Sunday)))

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

  //IF ELSE
  def dayNamesToString(days: List[DaysOfWeek]): String = {
    @tailrec
    def dayNamesToStringRec(remaining: List[DaysOfWeek], acc: String): String = {
      if (remaining.isEmpty) acc // Empty list case
      else {
        val head = remaining.head
        val tail = remaining.tail
        val makePretty = if (acc.isEmpty) "" else ", "
        println(s"\nCurrent tail: $tail \nCurrent acc: $acc \nCurrent head: $head ")
        dayNamesToStringRec(tail, acc + makePretty + head.toString)
      }
    }

    dayNamesToStringRec(days, "")
  }
  println("\n case objects - if else:")
  println(dayNamesToString(List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)))

  // PATTERN MATCH
  def dayNamesToStringMatch(days: List[DaysOfWeek]): String = {
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

  println("\n case objects - Match:")
  println(dayNamesToStringMatch(List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)))

}
