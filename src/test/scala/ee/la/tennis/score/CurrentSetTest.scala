package ee.la.tennis.score

import ee.la.tennis.PlayerOne
import org.scalatest.{FlatSpec, Matchers}


class CurrentSetTest extends FlatSpec with Matchers {

  "SetGame " should " be 15:0 after one added point" in {
    val set = CurrentSet()
    val current = set.addPoint(PlayerOne)

    current shouldBe a[CurrentSet]

    val currentSet = current.asInstanceOf[CurrentSet]

    currentSet.playedGames shouldBe Nil
    currentSet.currentGame.player1Score shouldBe `15`
    currentSet.currentGame.player2Score shouldBe `0`


  }

  it should " turn current game to win after 4 points " in {
    val set = CurrentSet()
    val current = set.addPoint(PlayerOne).asInstanceOf[CurrentSet].
      addPoint(PlayerOne).asInstanceOf[CurrentSet].
      addPoint(PlayerOne).asInstanceOf[CurrentSet].
      addPoint(PlayerOne).asInstanceOf[CurrentSet]


    current shouldBe a[CurrentSet]

    val currentSet = current.asInstanceOf[CurrentSet]

    currentSet.playedGames should not be Nil
    currentSet.playedGames.size shouldBe 1
    currentSet.playedGames should contain theSameElementsAs List(EndedGame(PlayerOne))
    currentSet.currentGame.player1Score shouldBe `0`
    currentSet.currentGame.player2Score shouldBe `0`


  }

}
