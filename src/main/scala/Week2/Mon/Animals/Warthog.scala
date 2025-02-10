package Week2.Mon.Animals

class Warthog(
               name: String, age: Int, val furColour: String, val hasTail: Boolean, val hasTusks: Boolean
             ) extends Animal(name, age) with Mammal{
  val dietType: DietType = Herbivore
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7.0, 11.0)
  val numberOfYoungRange: (Int, Int) = (3, 4)
}
