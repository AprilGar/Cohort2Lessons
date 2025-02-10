package Week2.Mon.Family

object FamilyLogic extends App {

  // Everytime we make a new instance of a class using the keyword new, we are making an object.
  new Child("Alice") //1 use
  val child1 = new Child("Alice") // reuse because I can call it with the val
  val child2 = new Child("Alice")
  println("Is child1 and 2 the same? " + (child1 == child2)) // false, each is a new object in memory.

  println(child1.forename)
  println(child1.under18)
//  println(child1.idPlease) // cannot access because the method is private in the Child class

  val Nick = new Child("Nick")

  // ADULT - typesafe
  val adult1: Adult = Adult.apply(new Forename("April"), new Surname("Garlington")) //with apply method
  val adult2: Adult = new Adult(new Forename("April"), new Surname("Garlington")) //without apply method - need to use keyword new
  println(adult1.forename) //accessing the class level of Forename
  println(adult1.forename.name) //accessing inside the Forename class to get to the string

  /** TASK - DOG */
  val loki: Dog = Dog("Loki", 5, false)
  val moose: Dog = Dog("Moose", 6, false)
  val maple: Dog = Dog("Maple", 6, true)
  println("\n Task - DOG")
  println(loki.name)
  println(loki.speak)
  println(loki.giveAge)
  println(loki.areYouAGoodDog)
  println(maple.areYouAGoodDog)


}
