package Week2.Tue.Vehicles

trait Electric {
  val timeToCharge: Int //abstract field - must declare at sub-class level (as soon as I extend)
  def charge: String = s"Charge me for $timeToCharge hours"
}
