package ee.la.tennis.score


object Point extends Enumeration {
  type Point = Value
  val `0` = Value(0)

  val `15` = Value(15)

  val `30` = Value(30)

  val `40` = Value(40)

  val adv = Value("adv")

  val advOut = Value("advOut")

  val deuce = Value("deuce")

  val win = Value("win")

  val lose = Value("lose")

  def +(current: Point, other: Point): (Point, Point) = {
    current match {
      case `adv` => (win, lose)
      case `advOut` => (deuce, deuce)
      case `deuce` => (adv, advOut)
      case `0` => (`15`, other)
      case `15` => (`30`, other)
      case `30` => (`40`, other)
      case `40` => other match {
        case `40` => (adv, advOut)
        case _ => (win, lose)
      }
    }
  }
}
