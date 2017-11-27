/**
 * This class will be used to represent a model to be used with the controller and view(fxml file) of this application.
 * The model's main purpose is to store the data which is given by the user to the view, and converted by the controller.
 * It will store info on the types of players being used and the info of the game being played.
 *
 * @author Teagen Kiel
 *
 */
public class BoardModel {

    /**
     * The player currently taking its turn in the game being played
     */
    private Player currentPlayer;
    /**
     * The player not currently taking its turn in the game being played
     */
    private Player otherPlayer;

    /**
     * This variable will hold the current status of the game being played
     */
    private boolean gameRunning;
    /**
     * This variable will hold the total number of moves made by the players.
     */
    private int gameCount;

    /**
     * Main constructor fot the board model.
     * @param player1 the first player with specified type given by the user
     * @param player2 the second player with specified type given by the user
     */
    public BoardModel(Player player1, Player player2){

        player1.setMoveLetter("X");
        player2.setMoveLetter("O");

        //sets players and initializes values
        currentPlayer = player1;
        otherPlayer = player2;
        gameRunning = false;
        gameCount = 0;

    }

    /**
     * @return the player currently taking its turn
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @return the player not currently taking its turn
     */
    public Player getOtherPlayer() {
        return otherPlayer;
    }

    /**
     * Method used by the controller to change the players after a move is made
     */
    public void changePlayers(){

        Player tempPlayer = currentPlayer;
        this.currentPlayer = otherPlayer;
        this.otherPlayer = tempPlayer;
    }

    /**
     * @return the current status of the game being played
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * @param gameRunning sets the current status of the game being played
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    /**
     * @return the amount of moves made in the current game
     */
    public int getGameCount() {
        return gameCount;
    }

    /**
     * @param gameCount update the amount of moves made in the current game
     */
    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
