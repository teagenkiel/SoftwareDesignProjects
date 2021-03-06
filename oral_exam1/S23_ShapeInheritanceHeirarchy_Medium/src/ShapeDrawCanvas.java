/**
 *
 *
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ShapeDrawCanvas extends JPanel{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);


        try {
           Square myParallelogram = new Square(200);
            myParallelogram.drawQuadrilateral(g, getWidth()/2, getHeight()/2);

        } catch (Exception quadrilateralException) {
            System.out.printf("Exception: %s%n", quadrilateralException.getMessage());
        }


    }
}
