// MVP

// Passing a function as an argument

// Q1
def intDoubler(input: Int): Int = input * 2

// Define the Higher-Order Function
def applyTwice(input: Int, f: Int => Int): Int = f(f(input))

// Use the Higher-Order Function
println(applyTwice(4, intDoubler))

// Q2

// Define the Higher-Order Function
def IntManipulator(input1: Double, input2: Double, operation: (Double, Double) => Double): Double = {
  operation(input1, input2)
}

def add(num1: Double, num2:Double): Double = {
  num1+num2
}

def multiply(num1: Double, num2:Double): Double = {
  num1*num2
}

def divide(num1: Double, num2:Double): Double = {
  num1/num2
}

def subtract(num1: Double, num2:Double): Double = {
  num1-num2
}

// Use the Higher-Order Function
IntManipulator(10,5, add)
IntManipulator(10,5, multiply)
IntManipulator(10,5, divide)
IntManipulator(10,5, subtract)

// Returning a function

// Q3

def convertToUpperCase(input: String): String = input.toUpperCase
def convertToLowerCase(input: String): String = input.toLowerCase

// Define the Higher-Order Function
def stringConverter(makeStringUpperCase: Boolean): String => String = {
  if (makeStringUpperCase) {
    convertToUpperCase
  } else {
    convertToLowerCase
  }
}
val testString = "cOnVeRtMe"
// Use the Higher-Order Function
stringConverter(true)(testString)
stringConverter(false)(testString)

// Q4

// 4a. Define the Higher-Order Function
def calculate(operation: String): (Double, Double) => Double  = {
  operation match {
    case "add" => add
    case "subtract" => subtract
    case "multiply" => multiply
    case "divide" => divide
  }
}

// 4b. Use the Higher-Order Function
val addFunc = calculate("add")
val subtractFunc = calculate("subtract")
val multiplyFunc = calculate("multiply")
val divideFunc = calculate("divide")

// 4c. Update to be an Either to return the edge cases
def calculateWithEitherReturn(operation: String): Either[String, (Double, Double) => Double]  = {
  operation match {
    case "add" => Right(add)
    case "subtract" => Right(subtract)
    case "multiply" => Right(multiply)
    case "divide" => Right(divide)
    case _ => Left("Enter a valid method; add, subtract, multiply or divide.")
  }
}

// Extension

// Q1
// Define the Higher-Order Function
def maxListNum (list: List[Double], f: (Double, Double) => Double): Double = {
  list.reduce(f)
}

def max(input1:Double, input2:Double): Double = input1 max input2

val listOfNumbers:List[Double] = List(1,5,3,233,4,9,8,7,6,66)

// Use the Higher-Order Function
maxListNum(listOfNumbers, max)

//Q2
// Define the Higher-Order Function
def applyFunc(func: Int => Int, givenInt: Int): Int = {
  func(givenInt) // Apply the function to the givenInt
}

def triple: Int => Int = (num: Int) => num * 3
def square: Int => Int = (num: Int) => num * num

// Use the Higher-Order Function
applyFunc(triple, 5)
applyFunc(square, 5)

//Q3
// Define the Higher-Order Function
def power(exponent: Int): Int => Int = {
  (base: Int) => Math.pow(base, exponent).toInt // returning a function
}

// Define power function
val square = power(2)

// Use the power function to calculate the square
square(6)

