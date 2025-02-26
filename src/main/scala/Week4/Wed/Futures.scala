package Week4.Wed

import Week3.Fri.Eithers.{NewError, isOdd}

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.{Failure, Random, Success}

object Futures extends App {

  //What are Futures?
  // These represent values that are not yet ready - but they will be in the future.

  //Why do we use them?
  // If we didn't use them, sometimes our programme would pause and wait for long operations to complete (for example, fetching data from a database or an API).
  // The Future allows us to run tasks in the background (like fetching data), without stopping the whole programme.

  //How do we create them?
  val futureHelloWorld: Future[String] = Future {
    Thread.sleep(2000) //Pausing the thread for 2 seconds
    "Hello Future World!"
  }

  //How can we print these Futures?

  //NOT LIKE LIKE.
  println("Standard print line: " + futureHelloWorld) //This is printing the futures itself, rather than the value.

  // 1st way - use .foreach as a callback
  futureHelloWorld.foreach(result => println(s"Using .foreach: $result"))

  //2nd way - use onComplete (use this when we want to handle success and failure)
  futureHelloWorld.onComplete {
    case Success(result) => println(s"Using onComplete: $result")
    case Failure(exception) => println(s"Failure with onComplete: ${exception.getMessage}")
  }

  //3rd way - using Await.result
  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS) //Wait 5 seconds, if you don't receive the value in 5 seconds, time out.
  println("Using await: " + Await.result(futureHelloWorld, waitTime)) //collect it, print it after you have waited for the time stated.
  //THIS WILL BLOCK THE THREAD (and therefore future cannot be used in parallel).
  //Use when essential.

  println("I'm printed after the futures are called.") //Proving that with .foreach and .onComplete this is printed before, so its happening while we are waiting for the future to be return.

  /** TASK */
  // Write a method called additionInTheFuture that takes in two Ints and returns the addition of the ints in the future.
  //Practice calling and printing the method in different way.

  def additionInTheFuture(x: Int, y: Int): Future[Int] = Future {
    Thread.sleep(1000)
    x + y
  }

  additionInTheFuture(1, 2).foreach(result => println(s"Future completed with foreach: $result"))

  additionInTheFuture(1, 2).onComplete {
    case Success(result) => println(s"Future completed successfully with onComplete: $result")
    case Failure(exception) => println(s"Future failed with onComplete: ${exception.getMessage}")
  }

  println("Using Await: " + Await.result(additionInTheFuture(1, 2), waitTime))

  def fetchIsOddOrErrorInTheFuture(number: Int): Future[Either[NewError, String]] = Future {
    Thread.sleep(1000)
    isOdd(number) //fetching from a different package
  }

  //why val? Becuase the method it is calling is already a future, and I don't need to make a new one.
  val eventualIsOddOrError: Future[Either[NewError, String]] = fetchIsOddOrErrorInTheFuture(4)

  Thread.sleep(1100) //This will force the thread to sleep before it gets to the .valve in the pattern match which forces it to get the future immediately.

  //This function only cares about deciding if the future completed or not. It will not get us out of the Either. If it completes and receives either Left or the Right, it will be a Success. If the future didn't complete due to a time out, it will hit the None. This is better than our code crashing.
  // What is .value?? This .value is immediately checking the value before the future has had time to complete
  val result = eventualIsOddOrError.value match {
    case Some(Success(complete)) => s"Future completed: $complete"
    case None => "Future did not complete in the given time."
  }

  println("isOddOrError" + result)

  //Combine futures?
  //We do this when we want multiple tasks done at once
  //Not force them to sleep, this means they will run asynchronously, in parallel, on separate threads.

  val futureInt1: Future[Int] = Future {
    100
  }
  val futureInt2: Future[Int] = Future {
    8
  }

  val combinedFutureInt = for { //for comp will wait for all results to be back before it yields the final result
    number1 <- futureInt1
    number2 <- futureInt2
  } yield number1 + number2

  println(Await.result(combinedFutureInt, waitTime))

  /** TASK 1 */
  //Create two Futures: One returning "Hello" and the other "World". Combine them into "Hello World".
  val futureHello: Future[String] = Future {
    "Hello"
  }
  val futureWorld: Future[String] = Future {
    "World"
  }
  val combinedFutureString = for {
    word1 <- futureHello
    word2 <- futureWorld
  } yield word1 + " " + word2 + "!"

  println(Await.result(combinedFutureString, waitTime))

  /** TASK 2 */
  //  Create Two Futures:
  //  1st - A Future that returns "User: Alice"
  //  2nd - A Future that returns "Order: Pizza"
  //  Combine the result of the two futures into a for comprehension so we print the user and the order.
  //  EXT: Introduce a random delay before each Future completes. For the Pizza order, refactor it to state a Order: Salad, unless they have waited too long, then Order:Pizza.

  // Simulate fetching user data with a random delay
  val fetchUser: Future[String] = Future {
    val randomDelay = Random.nextInt(2000) + 1000 // Random delay between 1-3 seconds
    Thread.sleep(randomDelay)
    "User: Alice"
  }

  // Simulate fetching order data with a random delay
  val fetchOrder: Future[String] = Future {
    val randomDelay = Random.nextInt(2000) + 1000 // Random delay between 1-3 seconds
    Thread.sleep(randomDelay)
    if (randomDelay < 2000) "Order: Salad" else "Order: Pizza"
  }

  // Combine both Futures
  val combinedResult: Future[String] = for {
    user <- fetchUser
    order <- fetchOrder
  } yield s"$user, $order"

  // Print the final result
  combinedResult.foreach(println)


  Thread.sleep(3000) //This ensures the object thread doesn't finish before the future has completed.
}
