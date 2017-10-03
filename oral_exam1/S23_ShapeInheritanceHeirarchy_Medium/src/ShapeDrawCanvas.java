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
            SimpleQuadrilateral myQuadrilateral = new SimpleQuadrilateral(100, 200,
                    200, 90, 75);
            myQuadrilateral.drawQuadrilateral(g, getWidth()/2, getHeight()/2);

        } catch (Exception quadrilateralException) {
            System.out.printf("Exception: %s%n", quadrilateralException.getMessage());
        }


    }
}
