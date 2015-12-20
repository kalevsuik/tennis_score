package ee.la.tennis.score


sealed trait Point {
  case object Love extends Point
  case object `15` extends Point
  case object `30`extends Point
  case object `40` extends Point
  case object adv extends Point
  case object deuce extends Point

}
