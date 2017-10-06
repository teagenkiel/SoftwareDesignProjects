/**
 * This class's purpose is to be the main driver program to test our RandomCircleFrame. The RandomCircleFrame
 * utilizes the RandomCircleCanvas JPanel to create a random circle that is adjustable with a display of the
 * dimensions.
 *
 * @author Teagen Kiel
 * @see RandomCircleFrame
 * @see RandomCircleCanvas
 *
 */

import javax.swing.*;

public class RandomCircleTest {

    public static void main(String args[]){

        RandomCircleFrame myRandomCircleFrame = new RandomCircleFrame();
        myRandomCircleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myRandomCircleFrame.setVisible(true);

    }
}
