import java.util.Random;

/**
 *
 *
 *
 */
public class ComputerPlayer extends Player{

    private Random randomGenerator = new Random();

    public ComputerPlayer(String name){

        super(name);
    }


    @Override
    public int[] move(Player otherPlayer){

        boolean availableSpace = false;
        int[] randomGridCoordinate = {0,0};

        while(!availableSpace) {

            randomGridCoordinate[0] = randomGenerator.nextInt(3);
            randomGridCoordinate[1] = randomGenerator.nextInt(3);

            if(this.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] != 1
                    && otherPlayer.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] != 1){
                availableSpace = true;
            }
        }

        this.getMoveSet()[randomGridCoordinate[0]][randomGridCoordinate[1]] = 1;

        return randomGridCoordinate;
    }

}
