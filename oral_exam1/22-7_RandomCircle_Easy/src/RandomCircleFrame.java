/**
 * This class's main purpose is to create a frame object for use of the RandomCircleTest JPanel.
 *
 * @author Teagen Kiel
 * @see RandomCircleCanvas
 */
import javax.swing.*;

public class RandomCircleFrame extends JFrame{

    /**
     * This default no-argument constructor will initialize the frame with a title, create a
     * new RandomCircleCanvas JPanel, and attach it to the frame.
     */
    public RandomCircleFrame(){
        super("Random Circle Calculator");
        this.setSize(500,500); //so we can pass in these values to the circle canvas

        RandomCircleCanvas myRandomCircleCanvas = new RandomCircleCanvas(Math.min(getWidth()/2, getHeight()/2));
        //we give the circleCanvas the smaller of half the width and height so that the radius of the circle does not
        //extend past the frame of the application.

        add(myRandomCircleCanvas);
    }

}
