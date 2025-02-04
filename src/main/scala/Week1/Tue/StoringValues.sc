/**
 * Melons - 50p x 5
 * Apples - 10p x 2
 * Fizzy drinks - £1.20 x 6
 * Total in pence.
 */

val melons = 5 * 50
val apples = 2 * 10
val fizzyDrinks = 6 * (100*1.20)
//val total = melons + apples + fizzyDrinks

// NOT best practice - very rarely used.
var total = 0
total = total + melons
total = total + apples

//TASK 1
//Store a val
val mysterySolvingDog = "Scooby-doo"
//Re-assign a val
mysterySolvingDog = "Scrappy-doo" //see the error - reassignment
//Store a var
var jobTitle = "Shadowing software developer"
//Re-assign a var
jobTitle = "Software developer"

//TASK 2
//John went to the shop and bought 5 lemons at 30p each, 2 bags of flour at 90p and 6 ciders priced at £2.50. What was the total cost in pence?
//  Show your working within the code.
val lemons = 5 * 30
val flour = 2 * 90
val cider = (2.50*100) *6
val total = lemons + flour + cider