package ee.la.tennis.score

import ee.la.tennis.Player


sealed trait Game

case class CurrentCame(player1Score:Point,player2Score:Point) extends Game{
  def getScore = {
    (player1Score,player2Score)
  }
}

case class EndedGame(winner:Player) extends Game
