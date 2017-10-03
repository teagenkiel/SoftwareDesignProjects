/**
 *
 *
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class ShapeDrawTest {

    public static void main(String[] args){


        JFrame shapeDrawFrame = new JFrame("Let's draw some shapes!");
        shapeDrawFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ShapeDrawCanvas myShapeDrawCanvas = new ShapeDrawCanvas();
        myShapeDrawCanvas.setBackground(Color.WHITE);

        shapeDrawFrame.add(myShapeDrawCanvas);
        shapeDrawFrame.setSize(500,500);
        shapeDrawFrame.setVisible(true);

    }

}
