package Week2.Thurs.Burger

import Week2.Thurs.Burger.BeefBurger.{Medium, Rare}
import Week2.Thurs.Burger.Burger._

object BurgerLogic extends App {

  val veggieBurger = VeggieBurger(
    doublePatty = true,
    bunType = SeededBun,
    salad = List(Lettuce),
    sauce = List(Mayo),
    cheese = ExtraCheese
  )

  println("\n---Veggie---")
  println(veggieBurger.doublePatty)
  println(veggieBurger.bunType)
  println(veggieBurger.salad)
  println(veggieBurger.sauce)
  println(veggieBurger.cheese)

  val chickenBurger = ChickenBurger(
    doublePatty = true,
    bunType = SeededBun,
    salad = List(Lettuce, Tomato, Onions),
    sauce = List(Ketchup, Mayo),
    cheese = NoCheese
  )
  println("\n---Chicken---")
  println(chickenBurger.salad)
  println(chickenBurger.grilledOrFried(ChickenBurger.Grilled))
  println(chickenBurger.grilledOrFried(ChickenBurger.Fried))

  val beefBurger = BeefBurger(
    doublePatty = false,
    bunType = SeededBun,
    salad = List(Lettuce, Tomato),
    sauce = List(HotSauce),
    cheese = ExtraCheese,
    howDoYouWantItCooked = Medium
  )
  println("\n---Beef---")
  println(beefBurger.howDoYouWantItCooked)

}
