package Week2.Thurs.Burger

case class ChickenBurger(
                          override val doublePatty: Boolean,
                          override val bunType: Burger.BunType,
                          override val salad: List[Burger.Salad],
                          override val sauce: List[Burger.Sauce],
                          override val cheese: Burger.Cheese
                   ) extends Burger(doublePatty, bunType, salad, sauce, cheese) {
  def grilledOrFried(chickenType: ChickenBurger.ChickenType): String = if (chickenType == ChickenBurger.Grilled) "Grilled please." else "Fried please."
}

object ChickenBurger {
  sealed trait ChickenType

  case object Grilled extends ChickenType

  case object Fried extends ChickenType
}
