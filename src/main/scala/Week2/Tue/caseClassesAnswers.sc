//MVP Exercise 1
//Classes act as a blueprint, used to make something, case classes are a form of abstraction that represents immutable data.
//Classes come with the keyword “new” when creating an instance of that class, 'new' is not needed for a case class.
//Classes are compared by reference, case classes are compared by their structure.

// MVP Exercise 2

case class Person(name: String, age: Int, nationality: String, isStudent: Boolean)
val firstPerson = new Person("Carlos", 23, "Spanish", true)
val secondPerson = Person("Carlos", 23, "Spanish", true)
val thirdPerson = Person("Chloe", 25, "British", false)

class Animal(name: String, colour: String, pet: Boolean)
//val cat = Animal("cat", "black", true)
val dog = new Animal("dog", "white", true)

//‘f’ (the line i have commented out above on L14) is the only line that will not run. This is because the keyword “new” is missing,  and therefore the class “cat” cannot be constructed. Remember classes need ‘new’ to give them the additional functionality that we get built in with case classes.
//‘b’ is runnable even though it’s a case class with the keyword ‘new’. ‘new’ is not essential for case classes but still can be used.

// MVP Exercise 3

case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("choocolate", 2.50, "MercatorBakery")

chocolateMuffin == anotherChocolateMuffin
chocolateMuffin == oneMoreChocolateMuffin //Case sensitive

// Extension Exercise 1

case class Car(manufacturer: String, colour: String, price: BigDecimal, ukManufacturer: Boolean, noOfSeats: Int)

case object Mazda


// Extension Exercise 2

val bmw = Car("BMW", "blue", 65000.00, ukManufacturer = false, 2)
val mini = Car("Mini", "red", 40000.50, ukManufacturer = true, 5)
val ford = Car("Ford", "grey", 30000.00, ukManufacturer = false, 5)

// Extension Exercise 3

val bmwX5 = bmw.copy(price = 85000, noOfSeats = 5)
val blueMini = mini.copy(colour = "blue")
val ukFord = ford.copy(ukManufacturer = true)

// Extension Exercise 4

println(bmwX5.price.toString)
println(firstPerson.age.toString)

// Extension Exercise 5

bmw.equals(ford)
bmwX5.equals(firstPerson)
bmw.equals(bmw)
firstPerson.equals(secondPerson)

// Research
//1.
val displayClass = bmw.getClass
val notEquals = firstPerson.!=(secondPerson)
val canEqual = mini.canEqual(ford)
val hashcode = ford.hashCode()
val doubleEqualsSymbolSameCaseClass = thirdPerson==firstPerson
val doubleEqualsSymbolDifferentCaseClass = bmwX5==(firstPerson)

//2.
//At face value there seems to be no difference between “.==“ and “.equals” because they both check structural equality, but there are a few.
//",equals" is inherited from Java’s Object class, ".==" is defined as a method on the Any class.
//Main purpose of “.==“ is that it handles internally nulls, as “.equals” doesn’t and need to do it manually.
//“.equals” is sometimes overriden by developers for custom equality checks.