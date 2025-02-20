package Week3

object PatternMatching extends App {

  val weather: String = "Cold"

  if (weather.toLowerCase == "cold") {
    println(s"It is $weather! Take a coat.")
  } else if (weather == "raining") {
    println(s"It is $weather! Take an umbrella.")
  } else {
    println(s"$weather is not valid")
  }

  weather.toLowerCase match {
    case "cold" => println(s"It is $weather! Take a coat.")
    case "raining" => println(s"It is $weather! Take an umbrella.")
    case _ => println(s"$weather is not valid") //Wildcard - this will catch anything else
  }

  val numOfWatermelons: Int = 9
  numOfWatermelons match {
    case 1 | 2 | 3 => println("He can carry them without a bag")
    case 4 | 5 => println("He needs a bag")
    case x => println(s"$x is invalid") //if you want to use interpolation with an int, need to assign it to x rather than _
  }

  abstract class Notification //Have to extend this - abstract
  case class Email (sender: String, title: String, body:String) extends Notification
  case class Text (sender: String, body:String) extends Notification
  case class VoiceNote (sender: String, lengthOfBody:Int) extends Notification

  val notification: Notification = Text ("Mum", "Where are you?")

  notification match {
    case Email(sender, title, body) => println("Email from " + sender)
    case Text(sender, body) if sender == "Mum" => println("Text from " + sender + ". Message: " + body)
    case Text(sender, body) => println("Text from " + sender)
    case VoiceNote(sender, lengthOfBody) => println("Voice note from " + sender + " Length: " +lengthOfBody)
  }

//TASK 1
  val flavour: String = "bbq"
  flavour match {
    case "spicy" => println("American Hot")
    case "bbq" => println("BBQ chicken")
    case "veggie" => println("Veggie")
    case "sweet" => println("Hawaiian")
    case _ => println("Not valid.")
  }

  //TASK 2
  val pizzaSize: Int = 14
  val pizzaSizeMatch = pizzaSize match {
    case 7 => "personal"
    case 9 => "small"
    case 14 => "large"
    case _ => "Enter a valid size"
  }
  println(pizzaSizeMatch)

  case class Pizza(size: Int, crust: String)
  val pizzaOrder: Pizza = Pizza(10, "stuffed")
  val getPrice = pizzaOrder match {
    case Pizza(7, "classic") => 5.99
    case Pizza(9, "classic") => 10.99
    case Pizza(9, "italian") => 10.99
    case Pizza(11, "classic") => 12.99
    case Pizza(11, "italian") => 12.99
    case Pizza(11, "stuffed") => 15.98
    case Pizza(14, "classic") => 14.99
    case Pizza(14, "italian") => 14.99
    case Pizza(14, "stuffed") => 17.98
    case _ => "Enter a valid pizza"
  }
  println(getPrice)


}
