/** Examples */

(number: Int) => number +1 //Anonymous function - cannot reuse anywhere else
val addition = (number: Int) => number +1 //Named function - only name when we want to reuse. We cannot override. Immutable.
def addition (number:Int): Int = number +1 //Method (also a type of function). Named so can reuse. Must be named!!
def addition (number:Int): Int = number + 10 // Override

val aValue = 6<3
def aDifferentValue: Int = {
  if (aValue) 564 else 865
  42 //last expression must match the methods return type
}
aDifferentValue // only 42 will be returned because it is the last expression in the method.

def makeACoffee: String = {
  "Add coffee to boiling water"
  "Add sugar or/and milk if required"
  "Stir"
  "Enjoy!"
}
makeACoffee

def makeATea(sugar:Int, splashesOfMilk: Int): String = {
  s"Add boiling water to your cup with a teabag, add $sugar spoons of sugar and $splashesOfMilk splashes of milk, stir and enjoy!"
}
makeATea(4, 6)
makeATea(sugar = 7, splashesOfMilk = 6) //we can name the parameter when calling the method. This is helpful for readability when the types are the same.

val vat: Double = 1.2
//def priceIncVat(priceOfItem: Double): Double = {
//  priceOfItem * vat
//}
def priceIncVat(priceOfItem: Double): Double =
  priceOfItem * vat //don't need {} if only 1 line
priceIncVat(3.99)

//TASK1
def getBigVal (input1: Int, input2: Int): String = {
  if (input1 > input2){
    "first"
  } else if (input1 < input2) {
    "second"
  } else if (input1 == input2) {
    "same"
  } else {
    "something has gone wrong here..."
  }
}
getBigVal(6,4)
getBigVal(2,4)
getBigVal(4,4)

//TASK2
def nameLength(firstName: String, surname: String): Int = {
  if(firstName.length > surname.length){
    firstName.length
  } else if (firstName.length < surname.length){
    surname.length
  } else {
    0
  }
}
nameLength("Tom", "Hiddleston")
nameLength("Elizabeth", "Olsen")
nameLength("Chris", "Pratt")

/** Referential transparency */
// We say something has referential transparency when a functions return value is based solely on the inputs.
// Example: addition(1,2) always = 3
def addTwoInts(x:Int, y:Int):Int = x + y
3 + 3
3 + addTwoInts(1,2)
addTwoInts(1,2) + addTwoInts(1,2)
6
//Just something to think about when writing more complex code. What is simpler for our brains?