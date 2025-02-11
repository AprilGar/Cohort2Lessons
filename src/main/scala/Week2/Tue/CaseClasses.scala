package Week2.Tue

object CaseClasses extends App {

  // Standard Class
  //  class SuperHero(val realName: String, val heroName:String, val weakness: String)
  //  new SuperHero("Clark Kent", "Superman", "Kryptonite") //made a new SuperHero object from the SuperHero class.

  //Case class
  case class SuperHero(realName: String, heroName: String, weakness: String) //each parameter is a val by default.

  val superMan = SuperHero.apply("Clark Kent", "Superman", "Kryptonite") //.apply method is built in. Object made using the SuperHero case class.
  val superMan3 = SuperHero("Clark Kent", "Superman", "Kryptonite") // Scala is clever enough to know to use .apply without us telling it to.
  val superMan2 = SuperHero.apply("Clark Kent", "Superman", "Kryptonite")
  println(superMan == superMan2) //true - compares the field values not the object reference/memory location (like classes).

  // .copy method
  val copiedSuperman = superMan.copy(weakness = "gravity") //Make a new val! Not mutating the original.
  println(copiedSuperman.weakness)
  println(superMan.weakness) //Original is not being reassigned.
  val updatedName = superMan.copy(realName = "Andy Probert", weakness = "pints")
  println(updatedName.realName + updatedName.weakness)

  //TASK
  println("\nTask\n")
  //1.
  case class Dog(name: String, breed: String, age:Int)
  //2.
  val loki = Dog("Loki", "collie X", 5)
  val marley = Dog("Marley", "lab", 4)
  val scoobyDoo = Dog("Scooby Doo", "Great Dane", 2)
  val lassie = Dog("Lassie", "Rough Collie", 7)
  //3.
  case class Kennel(name: String, dogs: List[Dog])
  //4.
  val dogs: List[Dog] = List(loki, marley, scoobyDoo, lassie)
  val sydneyKennel = Kennel("Sydney Kennel", dogs)
  println(sydneyKennel)
  //5.
  val renamedSydneyKennel = sydneyKennel.copy(name = "Loki & friends")
  println(renamedSydneyKennel)
  //Extension A and B.
  case class Cat(name: String, breed: String, age: Int)
  val cats: List[Cat] = List()
  case class Bird(name: String, species: String, wingSpan: Int)
  val birds: List[Bird] = List()
  case class updatedKennel(name: String, dogs: List[Dog], cats: List[Cat], birds: List[Bird]) {
    def addDog (dog: Dog) : updatedKennel = {
      updatedKennel(name, dogs:+ dog, cats, birds)
    }
    def addCat(cat: Cat): updatedKennel = {
      updatedKennel(name, dogs, cats :+ cat, birds)
    }
    def addBird(bird: Bird): updatedKennel = {
      updatedKennel(name, dogs, cats, birds :+ bird)
    }
  }
  val sydneyKennel1 = updatedKennel("Sydney Kennel", dogs, cats, birds)
  println(sydneyKennel)
  val renamedSydneyKennel1 = sydneyKennel1.copy(name = "Loki & friends")
  println(renamedSydneyKennel)
  val addDogCatBird = renamedSydneyKennel1.addDog(Dog ("Toto", "Cairn Terrier", 10)).addCat(Cat("Garfield", "Persian", 5)).addBird(Bird("Hedwig","Snowy", 60))
  println(addDogCatBird)



}
