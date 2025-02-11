package Week2.Tue.Vehicles

object VehicleLogic extends App {

  println("\n----Car-----\n")
  //Car is a Class
  val ford = new Car("Ford", "Petrol") //object of Car
  println(ford.fuelType) //Coming from car
  println(ford.drive) //Come from Vehicle, override in Car
  println(ford.brand) //Come Vehicle
  println(ford.description) //Come from Vehicle

  println("\n-----ElectricCar-----\n")
  val electricFord = ElectricCar("Ford") //new ElectricCar object
  println(electricFord.fuelType)
  println(electricFord.drive)
  println(electricFord.brand)
  println(electricFord.description)
  println(electricFord.noisyToDrive) //coming from ElectricCar
  println(electricFord.timeToCharge) //coming from Electric trait
  println(electricFord.charge) //coming from Electric trait

}
