package Week2.Tue.Vehicles

class Car (brand: String, val fuelType: String) extends Vehicle(brand) {
  override def drive: String = s"This $brand car is using $fuelType"
}
