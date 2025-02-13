package Week2.Thurs.Burger

//abstract class Burger(val doublePatty: Boolean, val bunType: String) {
////def makeItAMeal: Boolean // TODO: THINK ABOUT THIS LATER
//}

abstract class Burger(
                       val doublePatty: Boolean,
                       val bunType: Burger.BunType, //1 choice
                       val salad: List[Burger.Salad], //can choose many
                       val sauce: List[Burger.Sauce], //can choose many
                       val cheese: Burger.Cheese //1 choice
                     ) {
  //def makeItAMeal: Boolean // TODO: THINK ABOUT THIS LATER
}

object Burger {

  sealed trait BunType

  case object SeededBun extends BunType

  case object LettuceBun extends BunType

  case object GlutenFree extends BunType


  sealed trait Salad

  case object Lettuce extends Salad

  case object Tomato extends Salad

  case object Onions extends Salad

  case object NoSalad extends Salad //want to make sure they can choose nothing as we have it as a parameter to make a burger so they must choose something. (There is a better way, we will look at this in week 3.)


  sealed trait Sauce

  case object Ketchup extends Sauce

  case object Mayo extends Sauce

  case object HotSauce extends Sauce

  case object NoSauce extends Sauce


  sealed trait Cheese

  case object StandardCheese extends Cheese

  case object ExtraCheese extends Cheese

  case object NoCheese extends Cheese

}