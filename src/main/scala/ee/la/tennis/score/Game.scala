package ee.la.tennis.score

import ee.la.tennis.score.Point.Point
import ee.la.tennis.{PlayerTwo, PlayerOne, Player}


sealed trait Game {}

//case class CurrentGame(player1Score:Point=`0`, player2Score:Point=`0`) extends Game{
case class CurrentGame(player1Score: Point = Point.`0`, player2Score: Point = Point.`0`) extends Game {

  def getScore = {
    (player1Score, player2Score)
  }

  def addPoint(player: Player) = {
    player match {
      case PlayerOne => Point +(player1Score, player2Score) match {
        case (Point.`win`, Point.`lose`) => EndedGame(player)
        case (player1, player2) => CurrentGame(player1, player2)
      }
      case PlayerTwo => Point +(player2Score, player1Score) match {
        case (Point.`win`, Point.`lose`) => EndedGame(player)
        case (player2, player1) => CurrentGame(player1, player2)
      }
    }
  }
}

case object CurrentGame {
  def apply = {
    new CurrentGame
  }
}

case class EndedGame(winner: Player) extends Game
