/** MVP */

//1.
// a) Make a List of the numbers from 1-5, and a Seq of the primary colours.
val a: List[Int] = List(1,2,3,4,5)
val b: Seq[String] = Seq("Blue", "Yellow", "Red")
// b) Multiply all the values in your List by 3.
a.map( num => num * 3)
// c) Remove “Blue” from your Seq.
b.filter( col => col != "Blue")
// d) Returns ‘true’ if your Seq contains “Orange”
b.contains("Orange")

//Write a function that maps each value in your List to true or false, depending on whether they are odd.
a.map(num => num % 2 == 1)

//3. David has a Map of his pets.
val pets: Map[String, String] = Map(
  "Spot" -> "Dog",
  "Deborah" -> "Fish",
  "Paul" -> "Cat",
  "Marvin" -> "Dog")

//4. Return a List of the names of David’s dog(s).
val dogs = pets.filter(pet => pet._2 == "Dog").keys.flatten //use .keys if you only want to see the key

//Alternative if putting species as key. Key must be unique or it will be overwritten.
val davidsPets: Map[String, List[String]] = Map(
  "Dog" -> List("Spot", "Marvin"),
  "Fish" -> List("Deborah"),
  "Cat" -> List("Paul")
)
davidsPets.filter(pet => pet._1 == "Dog").values.flatten.mkString(", ")//Approach 1
//Use .values to get the List("Spot", "Marvin")
//Use .flatten to get out the List
//Use .mkString to make a string and (", ") does the formatting so , and space between.
davidsPets("Dog").mkString(", ")// Approach 2 - simplified

/** EXTENSION */

//1. Starting with a Seq(1-9), come up with 2 filters that, when used together, will return Seq(1,2,5,7).
val nums = Seq(1,2,3,4,5,6,7,8,9)
nums.filter(n => n%3 != 0).filter(n => n%4 != 0)

//2. The .head function returns the first element of a list, and the .tail function returns everything except the first element. Use head and tail to get the 3rd element of a List.
val a = List(1,2,3,4,5)
val third = a.tail.tail.head


/** RESEARCH*/

//1. What makes a Set different from a Seq? What should Set(1,2) == Set(2,1,1,1) return?
//1. Answer: A Set only contains unique values, no duplicates. Will return true.
Set(1,2) == Set(2,1,1,1) //overrides duplicates so Set(2,1)

//2. What do you think List(3,4) == Seq(3,4) will return? Why? What about List(5,6) == Set(5,6)?
//2. Answer:
List(3,4) == Seq(3,4)
// Will return true, since scala checks the elements against each other, and they are comparable data types.
List(5,6) == Set(5,6)
// Will return false, since these data types store data in different ways (ordered vs unordered).