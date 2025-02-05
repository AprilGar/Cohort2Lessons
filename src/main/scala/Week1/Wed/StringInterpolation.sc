/** String Interpolation */

// S
val name: String = "April"
println(s"My name is $name.") //$ tells Scala what val to look for.

println(s"3 x 3 = ${3*3}")

val a: Int = 1976
val b: Int = 6
println(s"a X b = ${a * b}")

// Helpful when debugging code. Print the result at certain points in a method.

//f
//Common format specifiers (type safety):
// %f - Float, Double
// %d - Int, Long
// %s - String

val height: Double = 1.9
println(f"$name%s is $height%.2f metres tall") //2 d.p.
println(s"$name%s is $height%.2f metres tall") // s interpolation won't recognise formatting.

math.Pi // build in library
println(f"Pi to 2 d.p is ${math.Pi}%.2f")
println(f"Pi to 5 d.p is ${math.Pi}%.5f")
println(f"Pi to 1 d.p is ${math.Pi}%.1f")
println(f"Pi to 1 d.p is ${math.Pi}%20.1f") //Add padding
println(f"Pi to 1 d.p is ${math.Pi}%20.1f" + "      '") //Add padding after (badly...)
println(f"Pi to 1 d.p is ${math.Pi}%20.1f      '") //Add padding after (badly...)

//printf - Sting
printf("'%s'", "Hello")
printf("'%20s'", "Hello")//Padding before
printf("'%-20s'", "Hello")//Padding after
printf("'%25s%-20s'", "Hello", "")//Padding before and after

//raw
println(s"I'm going onto a \nnew line") //will drop onto a new line with 's'
println(raw"I'm going onto a \nnew line")

// Common use --> Regex

//TASK
//Create 2 strings for two peoples names. Then using those names use string interpolation to print “A is older than B”
val personA:String = "Arnold"
val personB:String = "Bart"
println(s"$personA is older than $personB")

//Create 2 integers for the age of each person. Then use string interpolation to calculate how much older the first person is and print “A is X years older than B”
val wholeAgeA: Int = 35
val wholeAgeB: Int = 29
println(s"$personA is ${wholeAgeA - wholeAgeB} years older than $personB")

//Change your 2 integers to doubles and provide new decimal point values. Using string interpolation update the previous task so that the sentence remains the same but will give the answer to 1d.p.
val ageA: Double = 35.40
val ageB: Double = 29.30
println(f"$personA is ${ageA - ageB}%.1f years older than $personB")

//Use string interpolation to avoid the new lines from this string. “\n\n\n\n\n\n\n\nsameline\n\n”
println(raw"\n\n\n\n\n\n\n\nsameline\n\n")

