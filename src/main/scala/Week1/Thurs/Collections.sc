import scala.collection.immutable.ListMap
// Seq, List, Map (notice the uppercase)

val firstSeq: Seq[Int] = Seq(1,2,3,4,5)
val firstList: List[Int] = List(1,2,3,4,5)
val firstMap: Map[String, Int] = Map(
  "one" -> 1,
  "two" -> 2,
  "three" -> 3,
  "four" -> 4,
  "five" -> 5
)
// Map has key value pairs (key -> value)
// Must declare the types of both key and value in the parameters

/** Accessing data */
  //SEQ
val getSeqData: Int = firstSeq(0)
val getSeqHead: Int = firstSeq.head //get the first element (index position 0)
val getSeqTail: Seq[Int] = firstSeq.tail //get everything except the head (index position 0)
val getSeq2Data: Int = firstSeq(2)
//val getTooMuchData: Int = firstSeq(12) //out of bounds exception thrown as we don't have any data in the 12th index position.
//LIST
val getList1Data: Int = firstList(1)
val getListTail: List[Int] = firstList.tail
val getLastInList: Int = firstList.last
//MAP
val getMapData = firstMap("three") //enter key to get the value

/** Manipulating data - using map */
val tripledList: List[Int] = firstList.map{
  number => number * 3
}

val tripledSeq: Seq[Int] = firstSeq.map{
  _ * 3
} // bad practice to not name your data type

val tripledMap: Map[String, Int] = firstMap.map {
  case (key, value) => (key, value * 3)
}

val changeKey: Map[String, Int] = firstMap.map {
  case (key, value) => (key.capitalize, value)
}

val changeKeyAndValue: Map[String, Int] = firstMap.map {
  case (key, value) => (key.capitalize, value *3)
}

/** Manipulating data - filtering */
// filter
// filterNot (works similar to !=)

val filteredSeq: Seq[Int] = firstSeq.filter(
  number => number >= 2
)
val filteredList: List[Int] = firstList.filter(
  number => number >= 2
)
filteredSeq == filteredList //true despite the val names not being the same. We are checking for the resulting value.

val filteredMap: Map[String, Int] = firstMap.filter(
  number => number._2 >= 2
)
// _1 --> access key
// _2 --> access value

val filterNotList: List[Int] = firstList.filterNot(number => number >= 2)

val filterNotAlternativeList: List[Int] = firstList.filter(
  number => !(number >= 2)
)

/** Manipulating data - check if an element is present */
//Get boolean result

  //EXISTS
val existsSeq: Boolean = firstSeq.exists(number => number >= 7)

val existsList: Boolean = firstList.exists(number => number >= 2)

val existsMap: Boolean = firstMap.exists(number => number._2 >= 2)

//CONTAINS - give it a specific piece of data to look for.
val containsSeq: Boolean = filteredSeq.contains(7)
val containsList: Boolean = filteredList.contains(2)
val containsMap: Boolean = firstMap.contains("two") //checks the keys!
val containsOrSeq: Boolean = filteredSeq.contains(7) || firstSeq.contains(12)

/**TASK 1*/
//1. Create a Seq of the names of everybody on the course
val names: Seq[String] = Seq("Scooby", "Shaggy", "Fred", "Velma", "Daphne")
//2. Create a Map of 1-“red”, 2-“yellow”, 3-“blue”, 4-“green” and play with accessing the elements
val colours: Map[Int, String] = Map(1 -> "red", 2 -> "yellow", 3 -> "blue", 4 -> "green")
val filteredForColourBlue: Map[Int, String] = colours.filter(num => num._1 == 3)
val filteredForColourBlueV2: Map[Int, String] = colours.filter(num => num._2 == "blue")
//3. Add 1 to all numbers in a collection.
val addOneSeq = firstList.map { number => number + 1 }
//4.Remove all even numbers from a collection.
val oddNumbersOnly = firstList.filter {
  number => number % 2 != 0
}
//could use filterNot == rather than !=
val oddNumbersOnlyFilterNot = firstList.filterNot {
  number => number % 2 == 0
}
//5. Return true if a Seq has a String that contains the letter “r” .
val containsLetterR = names.exists(name => name.contains("r"))

/**TASK 2*/
//1.We have looked at the Seq and Map iterables. We haven’t looked at Sets. What are they? How are they different?
//HastSet, SortedSet etc. Cannot contain duplicate elements (if we had two names the same for our names list, we wouldn't be able to use a set).

//2. flatMap is another cool method we can call on collections. Research what is does and when it could be useful. Write an example.
//Combo of map and flatten method. You can iterate through each item, apply a function and separate them (the inner grouping is removed). This is helpful in cases where you need to access data that is buried e.g. lists within lists.
val flatMapNames: Seq[Char] = names.flatMap(_.toCharArray) //print char
val flatMapNames: Seq[Char] = names.flatMap(_.toUpperCase) //can apply functions to each char
//returns a Seq[char] rather than strings

/** Making additions - prepend (start) or append (end) */

val x: Seq[Int] = Seq[Int]()
x :+ 1
x :+ 2
x //won't work = immutable

val y: Seq[Int] = Seq(3,4,5)
// Append (add to end)
val appendY = y:+ 6
// Prepend (add to start)
val prependY = 2 +: appendY
val multipleInts = Seq(0,1,2) +: y
val multipleInts = Seq(0,1,2) ++ y

//Append Map
val appendMap = firstMap + ("six" -> 6)
//To order use ListMap rather than Map.

/** Deleting */
val removeHead = firstSeq.tail //remove head
val removeLast = firstSeq.init //remove last index position

//Removing Map
val removeValueInMap = firstMap - "three" //call to the key
val removeMultipleValuesInMap = firstMap - ("three", "one") //call to the key