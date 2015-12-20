package ee.la.tennis


sealed trait Player {
  val playername:String
}
case object PalyerOne
case object PlayerTwo
