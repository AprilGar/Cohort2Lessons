//MVP
//1a. Three plus four, times fifty-seven is less than three-hundred
3 + 4 * 57 < 300
//1b. One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
144 / 12 >= 12
//1c. Cat is less than Dog (strings)
"cat" < "dog"
//1d. Rabbit is less than Hamster (strings)
"rabbit" < "hamster"
//1e. Seventeen is odd (modulus)
17 % 2 != 0
//1f. Seventy-five divided by nine is less than thirty and eighty-nine divided by six is less than twenty
75 / 9 < 30 && 89 / 6 < 20

//2. “I love scala already” - has a value of type string. It’s a string literal. Print line is an expression – a side effect as it prints to console – returns a unit (not a string!).

//3. Open question. Group to feedback.

//Extension
//”STRING” == “string” True or false? Why?
val areYouEqual = "STRING" == "string"
//No - case sensitive

//Can you convert “one” to 1?
// Not simply (we can't just use .toInt). The compiler doesn't know that "one" is the same as 1. We would need to look at mapping to be able to do this, hold this thought.

//Can you convert 1 to “one”?
//No, same as above.

//Can you convert 1 to a string? Is the result as you would expect?
val convertToString = 1.toString
//Gives "1" as a string. Not one.

//Convert a lowercase string to uppercase.
val uppercase = "hello".toUpperCase

//Convert on the first letter of a string to uppercase.
val onlyFirstLetter = "hello".capitalize

//Research
//Make a val called new which is type string. Why doesn’t this compile? What do we need to do within our code to make it work? Are there any other words that you cannot use?

// val new: String = "I'm a new string"
// new is a keyword - this means it is protected. Use backticks if calling a val a keyword is unavoidable. lots of keywords, just look them up.
val `new`: String = "I'm a new string"

//other keywords include: object, if, abstract, class.... (search scala keywords online and you'll find a big list!)
