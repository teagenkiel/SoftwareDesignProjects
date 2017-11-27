import java.util.Random;

/**
 * This class specifies the Computer player. it extends from the Player class and implements the abstract move
 * method to specify how a computer player moves in a tic tac toe game.
 *
 * @author Teagen Kiel
 *
 *
 */
public class ComputerPlayer extends Player{


    /**
     * This variable will hold the random generator used to compute a random row and column index to move with
     */
    private Random randomGenerator = new Random();

    /**
     * This constructor will ustilize the super constructor to initialize the variables needed
     * @param name the name of the player
     */
    public ComputerPlayer(String name){

        super(name);
    }

    /**
     * This method implements the move method to be specific to the computer player type. It will pick two random numbers
     * between 0 and 2 to act as coordinates for its next move. In takes the other player as an argument to make sure it
     * won't pick a spot that is already occupied.
     * @param otherPlayer the player who is currently not in turn
     * @return the coordinates of the node computed by the method
     */
    @Override
    public int[] move(Player otherPlayer){

        boolean availableSpace = false;
        int[] randomGridCoordinate = {0,0};

        //while there is not an available space open
        while(!availableSpace) {

            randomGridCoordinate[0] = randomGenerator.nextInt(3);
            randomGridCoordinate[1] = randomGenerator.nextInt(3);

            if(this.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] != 1
                    && otherPlayer.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] != 1){
                availableSpace = true;
            }
        }

        //mark the current player's corresponding move in the move set as taken
        this.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] = 1;

        return randomGridCoordinate;
    }

}
