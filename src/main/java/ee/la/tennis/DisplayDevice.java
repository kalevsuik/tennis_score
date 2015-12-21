package ee.la.tennis;

/**
 * The display device uses this method to display scoreboard
 */
public interface DisplayDevice {
    /**
     * Print the current scoreboard. Only when game is started, show player names and scores, otherwise show only first
     * row, other 2 rows are empty.
     *
     * @return Scoreboard will be returned as follows:
     * | Name          | Score | Advantage | Sets won |
     * | Player 0 name | 15    |           | 1        |
     * | Player 1 name | 30    |           | 2        |
     */
    String getScoreBoard();

    /**
     * Method that display device is polling. When game is not finished, scoreboard is shown, otherwise getWinner method
     * is invoked and winners name is displayed on screen
     *
     * @return True when game is finished
     */
    boolean isFinished();

    /**
     * Get the name of the winner
     *
     * @return Winners name
     */
    String getWinner();
}


