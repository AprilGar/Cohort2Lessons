package Week3.Fri

import java.time.LocalDate

object Eithers extends App {

  // Takes 2 different params - Left (Error) and Right (Success)
  // Right biased
  // Main use - error handling.

  //  def isOdd(x: Int): Either[Boolean, String] = if (x % 2 != 0) Right(s"$x is odd") else Left(false)
  //  println(isOdd(4)) //Left
  //  println(isOdd(7)) //Right

  //Let's make it better!!
  // 1. Error handle using extends Exception --> custom errors but have to make sure we use val to make params reachable
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception

  // Custom error
  case object IsOddError extends NewError(400, " Input is not odd, it is even.")

  def isOdd(x: Int): Either[NewError, String] = if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(4)) //Left
  println(isOdd(7)) //Right

  //2. Error handle using Try/Catch - gives more inbuilt information

  def plusOne(x: String): Either[String, Int] = {
    try {
      Right(x.toInt + 1)
    } catch {
      case exception: Exception => Left(s"failed due to: $exception") //wildcard - keeps code running
    }
  }

  println(plusOne("1")) //Right
  println(plusOne("one")) //Left

  // Eithers with for comps
  // Fail fast -- this means as soon as one condition hits a Left, we exit to for comp.

  // Validate a User.

  case class User(username: String, password: String, dateOfBirth: LocalDate)
  // Conditions:
  // 1. Username must be at least 12 char long
  // 2. Password must be a mixture of upper and lower case
  // 3. Date of birth - must be 18

  case class ValidatedUser(username: String, password: String, dateOfBirth: LocalDate) //Return type of final method

  case object UsernameError extends NewError(400, "Username is less than 12 characters long")
  case object PasswordError extends NewError(400, "Password is not a mixture of upper and lower case")
  case object dateOfBirthError extends NewError(400, "Not yet 18")

  val usernameBad = User("user", "Password", LocalDate.of(1960, 6, 5)) // Everything fine except Username
  val passwordBad = User("validusername", "password", LocalDate.of(1960, 6, 5)) // Everything fine except password
  val dateOfBirthBad = User("validusername", "Password", LocalDate.of(2022, 6, 5)) // Everything fine except DOB
  val validUser = User("validusername", "Password", LocalDate.of(1960, 6, 5)) // Everything fine

  //1. Username
  def validateUsername(username: String): Either[NewError, String] = {
    if (username.length < 12) Left(UsernameError)
    else Right(username)
  }

  println("\nValidate username (bad - left): " + validateUsername(usernameBad.username))
  println("\nValidate username (success - right): " + validateUsername(validUser.username))

  //2. Password
  def validatePassword(password: String): Either[NewError, String] = {
    if (password.toUpperCase == password || password.toLowerCase == password) Left(PasswordError)
    else Right(password)
  }

  println("\nValidate password (bad - left): " + validatePassword(passwordBad.password))
  println("\nValidate password (success - right): " + validatePassword(validUser.password))

  //3. Date of birth
  def validateAge(dateOfBirth: LocalDate): Either[NewError, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left(dateOfBirthError)
    else Right(dateOfBirth)
  }

  println("\nValidate Age (bad - left): " + validateAge(dateOfBirthBad.dateOfBirth))
  println("\nValidate age (success - right): " + validateAge(validUser.dateOfBirth))

  // 4. Put all the methods together and return the ValidatedUser if they are all happy.
  def validateUser(user:User): Either[NewError, ValidatedUser] = {
    for {
      storedUsername <- validateUsername(user.username) //calling method, if happy (right), store in the val called username. If unhappy (left) - exit for comp.
      storedPassword <- validatePassword(user.password)
      storedDateOfBirth <- validateAge(user.dateOfBirth)
      validatedUser = ValidatedUser(storedUsername, storedPassword, storedDateOfBirth) //make case class using the stored data from the for comp
    } yield validatedUser //final return type
  }

  println("\nValidateUser - bad username: " + validateUser(usernameBad)) //username error
  println("\nValidateUser - bad password: " + validateUser(passwordBad)) // password error
  println("\nValidateUser - bad date of birth: " + validateUser(dateOfBirthBad)) //DOB error
  println("\nValidateUser - everything ok: " + validateUser(validUser)) // Right - ValidatedUser case class


  /** Task
   *
   * This is just ONE way to do it!! Could have used more classes or passed in the full NewError rather than just the message*/
  //Samantha wants to buy a flat.
  //She earns £45,000 per annum and has a deposit of £20,000.
  //The flat she wants to buy is £280,000.
  //Her credit score is 577.

  //Conditions:
  //  Mortgage = x4 salary per annum
  //  Deposit = 10% of purchase price
  //  Minimum credit score to qualify for a mortgage = 550

  //Write the logic to validate whether:
  //  a. she is able to get a mortgage and if so, how much can she borrow?
  //  b. she can purchase her flat at the current asking price.

  def getMaxMortgage(salary:Int): Int = {
    salary*4
  }

  case object IneligibleDeposit extends NewError(400, "Deposit is less than 10% of the purchase price")

  def isDepositEnough(deposit:Int, purchasePrice: Int): Either[String, Boolean] = {
    if (deposit >= purchasePrice*0.1) {
      Right(true)
    } else {
      Left(IneligibleDeposit.errorMessage)
    }
  }

  case object IneligibleCreditScore extends NewError(400, "Credit score is not high enough")

  def isCreditScoreEnough(creditScore: Int): Either[String, Boolean] = {
    if (creditScore >= 550) Right(true) else Left(IneligibleCreditScore.errorMessage)
  }

  def getMortgage(salary: Int, creditScore:Int): Either[String, Int] = {
    for {
      creditScoreCheck <- isCreditScoreEnough(creditScore)
    } yield getMaxMortgage(salary)
  }

  case class MortgageOffer(eligibleDeposit: Boolean, maxMortgage: Int)

  def canSheBuyTheFlat(deposit: Int, purchasePrice:Int, creditScore:Int, salary: Int): Either[String, MortgageOffer] = {
    for {
      deposit <- isDepositEnough(deposit, purchasePrice)
      mortgage <- getMortgage(salary,creditScore)
      mortgageOffer = MortgageOffer(deposit, mortgage)
    } yield mortgageOffer
  }
  println(canSheBuyTheFlat(deposit = 20000, purchasePrice = 280000, 577, 45000 ))

}
