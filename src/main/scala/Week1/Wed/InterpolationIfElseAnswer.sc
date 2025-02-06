// MVP Task 1
val numWatermelons: Int = 4 // Try out different values to make sure the if statement works as intended

// MVP Task 2 and Task 3
if (numWatermelons >0 && numWatermelons <= 3) {
  if (numWatermelons==1){
    println(s"John can carry $numWatermelons watermelon without a bag")
  }
  else println(s"John can carry $numWatermelons watermelons without a bag")
} else if (numWatermelons >=4 && numWatermelons <= 5) {
  println(s"John needs a bag to carry $numWatermelons watermelons")
} else {
  println(s"John cannot carry $numWatermelons watermelons")
}

// MVP Task 4
val hasBag: Boolean = false // Try out both true and false to make sure the if statement works as intended

// MVP Task 5
if (numWatermelons <= 3 || numWatermelons <= 5 && hasBag) {
  println(s"John can buy $numWatermelons watermelons")
} else {
  println(s"John cannot buy $numWatermelons watermelons")
}

// MVP Task 6
println(f"The total cost of the watermelons is £${numWatermelons * 1.397}%2.2f")

// Extension
// 1. Order of precedence can be found here: https://docs.scala-lang.org/tour/operators.html#:~:text=%5E%20has%20the%20highest%20precedence%20because,%3F%20%2C%20%7C%20%2C%20and%20less%20.
/**
 * (characters not shown below)
 *
 * * / %
 *
 * + -
 *
 * :
 *
 * < >
 *
 * = !
 *
 * &
 *
 * ^
 *
 * |
 *
 * (all letters, $, _)
 */
true || false && false // 2. true - & evaluated before | --> so, left with: true || false = true
(true || false) && false // 3. false - brackets (parentheses) are evaluated first --> so, left with: true && false
1 < 4 && 7 != 10 || 9 + 10 == 21 // 4. true -->
/**
 * Lets break this one down. Order would be:
 *
   * Arithmetic operators (+) have higher precedence.
   *
   * Comparison operators (<, !=, ==) come next.
   *
   * Logical AND (&&) has a lower precedence than comparison operators.
   *
   * Logical OR (||) has the lowest precedence.
 *
 * How would it evaluate:
   *
   * 9 + 10 == 21 -> 19 == 21 -> false -> (1 < 4 && 7 != 10 || false)
   *
   * 1 < 4 -> true -> (true && 7 != 10 || false)
   *
   * 7 != 10 -> true -> (true && true|| false)
   *
   * true && true -> true -> (true || false)
   *
   * true || false  →  true
   *
   * Final result = true
 */

// Research
val value1: Int = 1
val value2: Int = 2

val value3: String = if (value1 < value2) {
  "yes"
} else {
  "no"
}

// could write this in single line notation
//val value3: String = if (value1 < value2) "yes" else "no"
