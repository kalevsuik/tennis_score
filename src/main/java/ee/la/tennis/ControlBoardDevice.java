package ee.la.tennis;

/**
 * A control board device uses this interface to interact with business logic components
 */
public interface ControlBoardDevice {
    /**
     * Add new player to game. Currently 2 player tennis is supported, so adding more than 2 players will invoke an
     * exception. When adding first player, its index will be 0 and when second player is added, its index will be 1.
     *
     * @param name Player name
     * @throws GameException Exception when more than 2 players or player with no name is added to the system
     */
    void addPlayer(String name) throws GameException;

    /**
     * Increment player score under index 'playerIndex'. The control board device has 2 buttons, one to increment player
     * index 0 score and other to increment player index 1 score
     *
     * @param playerIndex Players index
     * @throws GameException Exception when accessing player index that does not exist, adding score when game is
     *                       finished
     */
    void score(int playerIndex) throws GameException;

    /**
     * Start game when players have been entered.
     *
     * @throws GameException Exception when trying to start a game without 2 players or starting a game that is already
     *                       started
     */
    void start() throws GameException;
}
