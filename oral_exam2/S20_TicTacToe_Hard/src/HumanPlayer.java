/**
 *This class specifies the Human type of player to be used to play tic tac toe. The human play will implement the move method
 * polymorphically just like any other player would be able to do.
 *
 * @author Teagen Kiel
 *
 *
 */
public class HumanPlayer extends Player {

    /**
     * This constructor utilizes the super constructor to set the name of the player
     * @param name the name of the player
     */
    public HumanPlayer(String name){

        super(name);
    }

    /**
     * This method implements the abstract method in the super class by specifying how a human player should move
     * in a game of tic tac toe. When given the last grid clicked by the user, the method will mark the move in the
     * move set and return the move to the controller.
     * @param otherPlayer the other player in the game
     * @return the move coordinates to be made
     */
    @Override
    public int[] move(Player otherPlayer) {

        int[] gridClick = this.getLastGridClick();

        this.getMoveSet()[gridClick[0]][gridClick[1]] = 1;

        return gridClick;
    }
}
