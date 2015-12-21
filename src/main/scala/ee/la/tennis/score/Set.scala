package ee.la.tennis.score

import ee.la.tennis.Player

sealed trait Set {
  val playedGames: List[EndedGame]
}

case class CurrentSet(currentGame: CurrentGame = CurrentGame(), playedGames: List[EndedGame] = Nil) extends Set {
  def addPoint(player: Player): Set = {
    currentGame.addPoint(player) match {
      case game: CurrentGame => CurrentSet(currentGame = game, playedGames)
      case game: EndedGame =>
        val games = playedGames ::: List(game)
        val numGames: Map[Player, Int] = games.groupBy(eg => eg.winner).map(geg => (geg._1, geg._2.size))
        if (math.abs(numGames.head._2 - numGames.last._2) > 2 && numGames.values.max > 6) {
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


