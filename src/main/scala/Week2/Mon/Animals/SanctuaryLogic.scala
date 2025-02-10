package Week2.Mon.Animals

object SanctuaryLogic extends App {

 val pumba: Warthog = new Warthog(name = "Pumba", age = 3, furColour = "Brown", hasTail = true, hasTusks = true)
println(pumba.averageLifespanRange)

  println(pumba.feedAnimal(pumba.name))


}
