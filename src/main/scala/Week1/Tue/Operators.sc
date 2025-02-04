/**
 * Arithmetic Operators
 */

val a: Int = 10
val b: Int = 5
val c: Int = 3

//Add
a + b
//Subtract
a - b
b - c
//Divide
a / b
b / c
//Multiply
a * b
b * a
c * c
//Modulus
a % c // (10 % 3) - 3 goes into 10 3 times with 1 left over. Get result of the left over = 1
a % b

/** Relational */

//Equality ==
a == a
a == b
//Inequality !=
a != a
a != b
//Less than <
b < a
a < c
//Less than or equals to <=
b <= a
a <= a
//Greater than >
a > b
b > c
//Greater than or equals to >=
a >= c
c >= c
"dog" >= "dog"

/**
 * Logical
 */

//AND &&
true && true
true && false
(3<6) && (6>7)

//Or ||
true || false
false || true
false || false
(3>6) || (6<7)

//NOT !
!false
!true

//Task 1 - on ppt
//Task 2
//(scala will do bodmas automatically - brackets, orders, division, multiplication, addition, subtraction.
//a) Four plus three, times fifty-five is less than three-hundred
4 + 3 * 55 < 300
//b) ninety-six divided by twelve is greater than eight or exactly eight
96 / 12 >= 8
//c) Hamster is less than Hippo (strings)
"hamster" < "hippo"
//d) Eight is even (modulus)
8 % 2 == 0
//e) One-hundred and fifty-six divided by eight is less than twenty and fifty-four is less than 20 and fifty-four divided by four is less than fourteen
156 / 8 < 20 && 54 < 20 && 54 / 4 < 14