package Week2.Tue.Vehicles

case class ElectricCar (override val brand: String) extends Car(brand, "Electric") with Electric {
  override val timeToCharge: Int = 8
  val noisyToDrive: Boolean = false //specific to ElectricCar
}

// override val - WHY?
// Class -> Case class. Case class will autogenerate the val field, we also have the val field being passed down with inheritance.
// We need to explicitly redefine the inherited val.