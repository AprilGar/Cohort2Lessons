/**
 * Int - whole numbers --> 4 bytes
 * Long - whole number --> 8 bytes
 * Short - whole number --> 2 bytes
 * Double - simple decimal (same in java)
 * Float - 2.0f (Rarely seen) (compiles on smaller memory - short of decimals)
 * String - "Text"
 */

val one: Int = 1
val inferredOne = 1 // Haven't told Scala it is an Int - it has inferred the type. Not safe.

// Task 1
val int: Int = 30000
val string: String = "Hello, World!"
val boolean: Boolean = false //Or true
//val changedString:String = 3 //type mismatch error

// Task 2
val double: Double = 3.4
val biggestInt: Int = 2147483647
val long: Long = 3147483647L