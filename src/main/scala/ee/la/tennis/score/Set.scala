package ee.la.tennis.score

import ee.la.tennis.Player

sealed trait Set {
  val playedGames: List[EndedGame]
  val MIN_NUMBER_OF_GAMES=6
  val WINNING_THRESHOLD=2
}

case class CurrentSet(currentGame: CurrentGame = CurrentGame(), playedGames: List[EndedGame] = Nil) extends Set {
  def addPoint(player: Player): Set = {
    currentGame.addPoint(player) match {
      case game: CurrentGame => CurrentSet(currentGame = game, playedGames)
      case game: EndedGame =>
        val games = playedGames ::: List(game)
        val numGames = games.groupBy(_.winner).map(geg => (geg._1, geg._2.size))
        if (math.abs(numGames.head._2 - numGames.last._2) > WINNING_THRESHOLD && numGames.values.max > MIN_NUMBER_OF_GAMES) {
          EndedSet(games)
        } else {
          CurrentSet(playedGames = games)
        }
    }
  }
}

case object CurrentSet {
  def apply() = {
    new CurrentSet()
  }
}

case class EndedSet(playedGames: List[EndedGame]) extends Set


