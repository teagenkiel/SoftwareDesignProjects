/**
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class DrawCirclePanel extends JPanel {

    private int circleDiameter;

    public DrawCirclePanel(){

       this.circleDiameter = ThreadLocalRandom.current().nextInt(0, Math.min(getHeight(), getWidth()) + 1);
        // creates a random number generator isolated to the current thread, and computes a random number between the
        //two bounds given (here the smaller of the height and width of this JComponent
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.fillOval(getWidth()/2, getHeight()/2, circleDiameter, circleDiameter);

    }
}
