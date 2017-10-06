/**
 *
 *
 */
import javax.swing.*;


public class RandomCircleFrame extends JFrame{

    public RandomCircleFrame(){
        super("Random Circle Calculator");
        this.setSize(500,500);

        RandomCircleCanvas myDrawCirclePanel = new RandomCircleCanvas(Math.min(getWidth()/2, getHeight()/2));
        add(myDrawCirclePanel);
    }

}
