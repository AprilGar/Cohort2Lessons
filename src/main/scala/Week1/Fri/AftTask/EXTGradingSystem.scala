package Week1.Fri.AftTask

object EXTGradingSystem extends App {

    // Pure Function: Calculates the average score
    def calculateAverage(scores: List[Double]): Double = {
      scores.sum / scores.length
    }

    // Pure Function: Determines the grade based on average score
    def determineGrade(average: Double): String = {
      if (average >= 90) "A"
      else if (average >=80) "B"
      else if (average >=70) "C"
      else if (average >=60) "D"
      else "E"
    }

    // Impure Function: Reads input from the user
    def getUserScores(subjects: List[String]): List[Double] = {
      subjects.map { subject =>
        println(s"Enter score for $subject: ")
        scala.io.StdIn.readDouble() // Impure: reads input from the console
      }
    }

    // Impure Function: Logs a message to the console
    def logGrade(average: Double, grade: String): Unit = {
      println(s"Average Score: ${average.toInt}")
      println(s"Final Grade: $grade")
    }

  // List of subjects
  val subjects = List("Math", "Science", "English")

  // Impure: Get user input for scores
  val scores = getUserScores(subjects)

  // Pure: Calculate the average score
  val average = calculateAverage(scores)

  // Pure: Determine the grade
  val grade = determineGrade(average)

  // Impure: Log the grade to the console
  logGrade(average, grade)


}
