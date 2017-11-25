/**
 *
 *
 */
public class BoardModel {

    private Player currentPlayer;
    private Player otherPlayer;


    private boolean gameRunning;
    private int gameCount;


    public BoardModel(Player player1, Player player2){

        player1.setMoveLetter("X");
        player2.setMoveLetter("O");

        currentPlayer = player1;
        otherPlayer = player2;
        gameRunning = false;
        gameCount = 0;

    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void changePlayers(){

        Player tempPlayer = currentPlayer;
        this.currentPlayer = otherPlayer;
        this.otherPlayer = tempPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
