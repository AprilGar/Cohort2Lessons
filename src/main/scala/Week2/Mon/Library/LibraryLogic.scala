package Week2.Mon.Library

import Week2.Mon.Family.{Adult, Forename, Surname}

object LibraryLogic extends App {

  val harryPotter: Book = new Book("Harry Potter", Adult(new Forename("J.K"), new Surname("Rowling"))) with Fantasy with AudioBook with DigitalBook with PhysicalBook

  println(harryPotter.author.forename.name)
  println(harryPotter.title)
  println(harryPotter.read)
  println(harryPotter.enjoy)

  val goneGirl: Book = new Book("Gone Girl",Adult(new Forename("Gillian"), new Surname("Flynn"))) with Thriller
  println(goneGirl.enjoy)

}
