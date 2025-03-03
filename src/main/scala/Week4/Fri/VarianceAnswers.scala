package Week4.Fri

object VarianceAnswers extends App {
  // 1.
  abstract class Animal {
    val name: String
    val foodType: String
  }

  case class Cat(name: String, foodType: String) extends Animal
  case class Dog(name: String, foodType: String) extends Animal

  val garfieldTheCat = Cat("Garfield", "Lasagna")
  val odieTheDog = Dog("Odie", "dog food")

  val animal: Animal = garfieldTheCat
  // 1A Answer: A Cat is a subtype of Animal as we've extended it, therefore we can assign it to this val without an issue

  // 2.
  class Solitary[A]

  val solitaryCat: Solitary[Cat] = new Solitary[Cat]
//  val solitaryAnimal: Solitary[Animal] = solitaryCat
  // 2A Answer: We've said Solitary is invariant in A so Solitary[Cat] and Solitary[Animal] are 2 completely different
  // types. It would like were were assigning a String to an val x: Int

  // 3.
  case class Swan(name: String, foodType: String) extends Animal

  case class Pair[+A](animal1: A, animal2: A)

  val swanPair: Pair[Swan] = Pair[Swan](Swan("Cyril", "Swan food"), Swan("Clyde", "Swan food"))
  val animalPair: Pair[Animal] = swanPair
  // 3A Answer: Yes it does compile, we've said Pair is covariant in A so Pair[Swan] IS A SUBTYPE OF Solitary[Animal] and
  // so we can assign it to this more generic val


  // 4.
  class Feeder[-A] {
    def feedAnimal(a: A): Unit = print("Feeding an animal")
  }

  val animalFeeder: Feeder[Animal] = new Feeder[Animal] {
    override def feedAnimal(a: Animal): Unit = println(s"Fed ${a.name} some ${a.foodType}")
  }

  val dogFeeder: Feeder[Dog] = animalFeeder
  // 4A Answer: Yes it does compile as Feeder[Animal] is a subtype of Feeder[Dog] therefore we can compile this without
  // an issue, just like the first question
  dogFeeder.feedAnimal(odieTheDog)
  // 4B Answer: We've overridden the method in Feeder[Animal] so we are calling the new method body, even though we
  // haven't implemented it in Feeder[Dog], so at runtime we print "Fed Odie some Dog Food"
//  dogFeeder.feedAnimal(garfieldTheCat)
  // Answer: Even though we've specified that feedAnimal from Feeder[Animal] can use an Animal, feedAnimal from the Feeder[Dog]
  // is expecting a Dog at compile time, which garfieldTheCat isn't.

  // Extension 1
  abstract class Pack[+A] {
//    def addToPack(elem: A): NonEmptyPack[A] = NonEmptyPack(elem, this)
    // Answer E1A: This form of addToPack can't guarantee the arguments will be of type A, as Pack is covariant in A, meaning
    // a subtype of A could, in theory, be used in the argument - the compiler won't know if it's dealing with A or a subtype of A,
    // which might have extra properties that A doesn't have. It MUST only accept A or supertypes of A, i.e a lower type bound,
    // as then it is guaranteed to know which properties are available to use.
    def addToPack[B >: A](elem: B): NonEmptyPack[B] = NonEmptyPack(elem, this)
  }

  case class NonEmptyPack[+A](head: A, tail: Pack[A]) extends Pack[A]

  object EmptyPack extends Pack[Nothing]

  val catPack: Pack[Cat] = NonEmptyPack(garfieldTheCat, EmptyPack)
  val dogPack: Pack[Dog] = EmptyPack.addToPack(odieTheDog)

  val animalPack: Pack[Animal] = dogPack.addToPack(garfieldTheCat)

  // Extension 2
  class Vet[-A] {
//    def healAnimal(): A = ???
    // Answer E2A: This form of healAnimal can't guarantee the resulting type will be of type A. Vet is contravariant in its type, so a supertype
    // of A could, in theory, be returned by the method, which wouldn't be type safe as the compiler can't guarantee the
    // properties of output type are contained within the type of the value we're assigning it to. So we must specify that B is a subtype of A to make sure the compiler
    // knows that healAnimal is guaranteed to return A or a subtype of A when it's evaluated.
    def healAnimal[B <: A](animalToHeal: B): B = animalToHeal
  }

  val animalVet: Vet[Animal] = new Vet[Animal]
  animalVet.healAnimal(odieTheDog)

  val dogVet: Vet[Dog] = animalVet
//  dogVet.healAnimal(garfieldTheCat)

}
