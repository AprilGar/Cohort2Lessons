package Week2.Mon.Family

class Child (val forename: String) { // () - class parameters {} - body of the class. All the logic goes in the body.

  val under18: Boolean = true
  private def idPlease: String = "Can I see your Id?" // private - reduce the scope of where it is accessible - only can be called within the class body.

}

//Companion object
object Child {
    def apply(forename: String): Child = new Child(forename) //short hand to make new instances of you class.

  //Access the companion classes private methods
  val bob = Child.apply("Bob")
  println(bob.idPlease)

}
