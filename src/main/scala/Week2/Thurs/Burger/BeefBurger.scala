package Week2.Thurs.Burger

import Week2.Thurs.Burger.BeefBurger.Medium

case class BeefBurger(
                         override val doublePatty: Boolean,
                         override val bunType: Burger.BunType,
                         override val salad: List[Burger.Salad],
                         override val sauce: List[Burger.Sauce],
                         override val cheese: Burger.Cheese,
                         howDoYouWantItCooked: BeefBurger.Doneness //additional parameter for BeefBurger
                       ) extends Burger(doublePatty, bunType, salad, sauce, cheese) {
  }

  object BeefBurger {

    sealed trait Doneness

    case object Rare extends Doneness

    case object Medium extends Doneness

    case object WellDone extends Doneness
  }