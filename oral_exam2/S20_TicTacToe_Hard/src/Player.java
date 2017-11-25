/**
 *
 *
 */
public abstract class Player {


    private boolean gridClicked;
    private int[] lastGridClick = new int[2];

    private int[][] moveSet = new int[3][3];

    private String moveLetter;
    private String name;

    public Player(String name){

        this.name = name;
    }


    public void setLastGridClick(int[] lastGridClick) {
        this.lastGridClick = lastGridClick;
    }


    public int[] getLastGridClick() {
        return lastGridClick;
    }

    public int[][] getMoveSet() {
        return moveSet;
    }

    public String getMoveLetter() {
        return moveLetter;
    }

    public void setMoveLetter(String moveLetter) {
        this.moveLetter = moveLetter;
    }

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
