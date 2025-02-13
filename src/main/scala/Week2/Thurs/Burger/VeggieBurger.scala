package Week2.Thurs.Burger

case class VeggieBurger(override val doublePatty: Boolean,
                        override val bunType: Burger.BunType,
                        override val salad: List[Burger.Salad],
                        override val sauce: List[Burger.Sauce],
                        override val cheese: Burger.Cheese,
                       ) extends Burger(doublePatty, bunType, salad, sauce, cheese)
