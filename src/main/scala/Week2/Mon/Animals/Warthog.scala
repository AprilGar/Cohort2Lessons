package Week2.Mon.Animals

class Warthog (val name: String, val age: Int) extends Animal with Mammal {
  def talk: String = "I'm a Warthog"
}

class Worm extends Animal {
  override def hasEyes: Boolean = false
}