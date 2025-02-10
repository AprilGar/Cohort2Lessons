package Week2.Mon.Family

class Dog (val name: String, val age: Int, val goodDog: Boolean) {

  def speak: String = s"$name wants a treat!"

  def giveAge: Int = age

  def areYouAGoodDog: String = if (goodDog) "Such a good dog!!" else "You are not on the santa paws list..."

}

object Dog {
  def apply(name: String, age: Int, goodDog: Boolean) : Dog = new Dog(name, age, goodDog)
}
