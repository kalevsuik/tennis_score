package ee.la.tennis.score

import ee.la.tennis.{PlayerTwo, PlayerOne}
import org.scalatest.{FlatSpec, Matchers}


class CurrentGameTest extends FlatSpec with Matchers {

  "CurrentGame " should " be 15:0 after one added point" in {
    val game = CurrentGame()
    val current = game.addPoint(PlayerOne)

    current shouldBe a[CurrentGame]

    val currentGame = current.asInstanceOf[CurrentGame]

    currentGame.player1Score shouldBe `15`
    currentGame.player2Score shouldBe `0`


  }

  it should " be 15:30 after one added point for serving player and two for other" in {
    val game = CurrentGame()
    val current = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerTwo).asInstanceOf[CurrentGame].addPoint(PlayerTwo)

    current shouldBe a[CurrentGame]

    val currentGame = current.asInstanceOf[CurrentGame]

    currentGame.player1Score shouldBe `15`
    currentGame.player2Score shouldBe `30`


  }


  it should " end after adding 5 points if other have 0" in {
    val game = CurrentGame()
    val endGame = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerOne)

    endGame shouldBe a[EndedGame]

    val egame = endGame.asInstanceOf[EndedGame]
    egame.winner shouldBe PlayerOne

  }

  it should " end after adding 5 points if other have 30" in {
    val game = CurrentGame()
    val endGame = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerOne).asInstanceOf[CurrentGame].addPoint(PlayerTwo).asInstanceOf[CurrentGame].addPoint(PlayerTwo).asInstanceOf[CurrentGame].addPoint(PlayerTwo).asInstanceOf[CurrentGame].addPoint(PlayerTwo)

    endGame shouldBe a[EndedGame]

    val egame = endGame.asInstanceOf[EndedGame]
    egame.winner shouldBe PlayerTwo

  }

  it should " be adv:advOut after one added point for serving player on 40:40" in {
    val game = CurrentGame()
    val current = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerOne)

    current shouldBe a[CurrentGame]

    val currentGame = current.asInstanceOf[CurrentGame]

    currentGame.player1Score shouldBe `adv`
    currentGame.player2Score shouldBe `advOut`


  }

  it should " be win after two added points for serving player on 40:40" in {
    val game = CurrentGame()
    val current = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne)

    current shouldBe a[EndedGame]

    val currentGame = current.asInstanceOf[EndedGame]

    val egame = currentGame.asInstanceOf[EndedGame]
    egame.winner shouldBe PlayerOne


  }


  it should " be deuce after both added points  on 40:40" in {
    val game = CurrentGame()
    val current = game.addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo).asInstanceOf[CurrentGame].
      addPoint(PlayerOne).asInstanceOf[CurrentGame].
      addPoint(PlayerTwo)

    current shouldBe a[CurrentGame]

    val currentGame = current.asInstanceOf[CurrentGame]

    currentGame.player1Score shouldBe `deuce`
    currentGame.player2Score shouldBe `deuce`


  }

  it should " be adv:advOut after one point  on deuce " in {
    val game = CurrentGame(`deuce`,`deuce`)
    val current = game.addPoint(PlayerTwo)

    current shouldBe a[CurrentGame]

    val currentGame = current.asInstanceOf[CurrentGame]

    currentGame.player1Score shouldBe `advOut`
    currentGame.player2Score shouldBe `adv`


  }


}
