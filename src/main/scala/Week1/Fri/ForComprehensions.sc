// These work on monadic types -- Seq, List, Option, Either, Future
// Will not work Int, String, Boolean

// <- (backwards arrow), simply way of writing a function (flatmap, filter, map, foreach)
//yield -- call the map

//classic
def retrieveNumbers: Seq[Int] = for (number <- 1 to 10) yield number
retrieveNumbers
// (1 to 10).foreach(number => println(number))

//use operators
def squaredNumbers: Seq[Int] = for (number <- 1 to 5) yield number * number
squaredNumbers

//if guards
def useIfGuard: Seq[Int] = for (number <- 1 to 10 if number % 2 ==0) yield number
useIfGuard

val animals: List[String] = List("Hippo", "Bear", "Seal", "Pig")

def addS(animalList:List[String]): List[String] = animalList.map(animal => animal + "s")
addS(animals)

def lowerCaseAnimals(animalList: List[String]): List[String] = animalList.map(animal => animal.toLowerCase)
lowerCaseAnimals(animals)

def lowercaseAndAddS(animalList:List[String]): List[String] = for {
  addAnS <- addS(animalList)
  lowerCase <- lowerCaseAnimals(List(addAnS))
} yield lowerCase

lowercaseAndAddS(animals) //give a list
lowercaseAndAddS(animals).mkString(", ") //change a list to a string


// TASK 1
val names: List[String] = List("aRIa", "BaRT", "ChUCk")
def lowercaseNames(nameInput: List[String]):List[String] = nameInput.map(name => name.toLowerCase)
def capitaliseNames(nameInput: List[String]):List[String] = nameInput.map(name => name.capitalize)

// TASK 2
def capitaliseList(nameInput: List[String]): List[String] =
  for {
    lower <- lowercaseNames(nameInput) //apply the lower case method
    capital <- capitaliseNames(List(lower)) //apply the capitalize method
  } yield capital

capitaliseList(names).map(name => name + "!").mkString(" ")    