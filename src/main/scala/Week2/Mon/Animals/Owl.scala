package Week2.Mon.Animals

class Owl(
           val name: String,
           val speciesName: String,
           val age: Double,
           val beakLength: Double,
           val featherColour: String,
           val wingspan: Double
         ) extends Bird with Species with Flyable {
  val canFly: Boolean = true
  val dietType: DietType = Omnivore
  val hootsPerNight: Int = 12
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7, 11)
  val numberOfYoungRange: (Int, Int) = (4, 6)
}
