package Week2.Mon.Animals

class Dragonfly (
                  val name: String,
                  val speciesName: String,
                  val age: Double,
                  val wingspan: Double,
                  val numberOfLimbs: Int,
                  val antennaeLength: Double
                ) extends Insect with Species with Flyable {
  val canFly: Boolean = true
  val dietType: DietType = Carnivore
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (0.125, 0.167)
  val numberOfYoungRange: (Int, Int) = (24, 200)
}

