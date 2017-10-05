/**
 *
 *
 */
import javax.swing.*;


public class RandomCircleFrame extends JFrame{

    public RandomCircleFrame(){
        super("Random circle calculator");
        this.setSize(500,500);

        Circle randomCircle = new Circle();
        randomCircle.setRandomRadius(0, Math.min(getWidth()/2, getHeight()/2));

        CircleCanvas myDrawCirclePanel = new CircleCanvas(randomCircle);

        add(myDrawCirclePanel);
    }

}
