package Week1.Fri.AftTask

object EXTTerminalChat extends App {

  import scala.io.StdIn.readLine //must add the import

  val whatIsYourName = (name: String) => println(s"Hello $name")
  whatIsYourName(readLine("What is your name?"))
  val weather = (weather: String) => println(s"$weather is my favourite!")
  weather(readLine("What is the weather like today?"))

  //  val whatIsInAName = (name: String) => println(s"Hello $name")
  //  val nameInput = readLine("What is your name?")
  //  whatIsInAName(nameInput)
  //
  //  println("How old are you?")
  //  val ageInput = readInt()
  //  val ageIsJustANumber = (age: Int) =>
  //    println(s"Nice to meet you $nameInput. I have never met someone who is $age, you look great for your age!")
  //  ageIsJustANumber(ageInput)

}
