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



