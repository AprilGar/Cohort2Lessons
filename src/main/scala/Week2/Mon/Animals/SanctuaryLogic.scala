package Week2.Mon.Animals

object SanctuaryLogic extends App {

  val pumba: Warthog = new Warthog(name = "Pumba", age = 3, furColour = "Brown", hasTail = true, hasTusks = true)
  println(pumba.averageLifespanRange)
  println(pumba.feedAnimal(pumba.name))

  val hedwig = new Owl("Hedwig", "Snowy Owl", 8, 2, "White", 150)
  println(hedwig.wingspan)

  val jeff = new Dragonfly("Jeff", "Blue Eyed Darner", 1, 12, 10, 1)
  println(jeff.speciesName)

}
