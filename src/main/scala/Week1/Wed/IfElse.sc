/**
 * If Else
 */

// Depending on the weather, tell me what to wear.

val weather: String = "hot"

if (weather == "hot") {
  s"It is $weather, no coat needed."
} else {
  s"You need a coat, it is $weather"
}

// if true --> hits the first string inside the 'if'
// if false --> hits the second string inside the 'else'

if (weather.toLowerCase == "hot") {
  s"It is $weather, no coat needed."
} else if (weather.toLowerCase == "raining") {
  s"It is $weather, take a coat with a hood."
} else {
  s"$weather is not valid, please enter raining or hot"
}

//Multiple options
val season: String = "summer"
if (weather.toLowerCase == "cold" || season.toLowerCase == "winter") {
  s"It is $weather, take a coat"
} else {
  "A light jacket is fine"
}
//TASK 1
val studentGrade: Int = -59

if (studentGrade >= 90 && studentGrade <= 100) {
 "A! Well done!"
} else if (studentGrade >=80 && studentGrade <= 89){
  "B"
}else if (studentGrade >=70 && studentGrade <= 79){
 "C"
}else if (studentGrade >=60 && studentGrade <= 69){
  "D"
}else if (studentGrade >=50 && studentGrade <= 59){
  "E"
} else if (studentGrade >=40 && studentGrade <= 49) {
  "F"
} else if (studentGrade >=0 && studentGrade <= 39){
  s"$studentGrade is a U grade"
} else {
  s"$studentGrade is not valid"
}

//TASK 2
val givenAge: Int = 3

if (givenAge >= 18){
  println("Films ratings: U, PG, 12A, 15 or 18")
} else if (givenAge >= 15){
  println("Films ratings: U, PG, 12A or 15")
} else if (givenAge >= 12){
  println("Films ratings: U, PG or 12A")
} else if (givenAge >= 8){
  println("Films ratings: U or PG")
}  else if (givenAge >= 4 && givenAge >= 0 ){
  println("Films ratings: U only")
} else {
  println(s"$givenAge is too young to attend the cinema")
}