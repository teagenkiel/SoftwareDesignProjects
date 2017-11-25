/**
 *
 *
 *
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name){

        super(name);
    }

    @Override
    public int[] move(Player otherPlayer) {

        int[] gridClick = this.getLastGridClick();

        this.getMoveSet()[gridClick[0]][gridClick[1]] = 1;

        return gridClick;
    }
}
