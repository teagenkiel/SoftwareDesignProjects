/**
 * This abstract class is used to build a player for a tic tac toe game. The class specifies qualities each player
 * should have (name, move letter, etc.). It also contains an abstract method used to let the the player make the
 * move, which must be specified by the subclass.
 *
 * @author Teagen Kiel
 *
 */
public abstract class Player {

    /**
     * Stores the coordinates of the last node clicked by the user
     */
    private int[] lastGridClick;

    /**
     * Stores the moves made by this player
     */
    private int[][] moveSet;

    /**
     * Stores the letter, either X or O, used by the player in the game.
     */
    private String moveLetter;

    /**
     * Stores the name of the player.
     */
    private String name;

    /**
     * This constructor will initialize all of the created object's instance variables and prepare the player to play.
     * @param name the name of the player
     */
    public Player(String name){

        this.name = name;
        this.lastGridClick = new int[2];
        this.moveSet = new int[3][3];
    }


    /**
     * @param lastGridClick the coordinates of the last node clicked by the user
     */
    public void setLastGridClick(int[] lastGridClick) {
        this.lastGridClick = lastGridClick;
    }

    /**
     * @return the coordinates of the last node clicked by the user
     */
    public int[] getLastGridClick() {
        return lastGridClick;
    }

    /**
     * @return The moves made by the player
     */
    public int[][] getMoveSet() {
        return moveSet;
    }

    /**
     * @return the letter being used by the player in the game
     */
    public String getMoveLetter() {
        return moveLetter;
    }

    /*
     * @param moveLetter the letter being used by the player in the game
     */
    public void setMoveLetter(String moveLetter) {
        this.moveLetter = moveLetter;
    }

    /**
     * @return the name of t
     */
    public String getName() {
        return name;
    }

    public abstract int[] move(Player otherPlayer);

    public boolean checkWin(){

        //check row win
        for(int rowIndex = 0; rowIndex < 3; rowIndex++){


            //check row win
            if(moveSet[rowIndex][0] == 1 && moveSet[rowIndex][1] == 1
                    && moveSet[rowIndex][2] == 1){
                return true;
            }
        }

        //check column win
        for(int columnIndex = 0; columnIndex < 3; columnIndex++){


            if(moveSet[0][columnIndex] == 1 && moveSet[1][columnIndex] == 1
                    && moveSet[2][columnIndex] == 1){
                return true;
            }
        }

        //check diagonal wins
        if(moveSet[0][0] == 1 && moveSet[1][1] == 1
                && moveSet[2][2] == 1){
            return true;
        }

        if(moveSet[0][2] == 1 && moveSet[1][1] == 1
                && moveSet[2][0] == 1){
            return true;
        }

        return false;

    }




}
