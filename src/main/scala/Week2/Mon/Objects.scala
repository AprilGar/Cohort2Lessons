package Week2.Mon

object Objects extends App {

  object PrimaryColours { // grouping!
    val blue: String = "blue"
    val yellow: String = "yellow"
    val red: String = "red"
  }
  //calling the objects
  println(PrimaryColours.red)
  println(PrimaryColours.red.toUpperCase)

  // Task 1
  object Weekdays {
    val monday: String = "Monday"
    val tuesday: String = "Tuesday"
    val wednesday: String = "Wednesday"
    val thursday: String = "Thursday"
    val friday: String = "Friday"
    val saturday: String = "Saturday"
    val sunday: String = "Sunday"
  }
  println(Weekdays.monday)

}
