package Week2.Mon.Family

class Forename (val name: String)

class Surname (surname: String) //this cannot be access because we haven't assigned the val!

class Adult (val forename: Forename, val surname: Surname) { //type safe because we are using classes as types.
  val under18: Boolean = false
}

object Adult {
  def apply(forename:Forename, surname: Surname): Adult = new Adult(forename, surname)
}



