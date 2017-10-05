/**
 *
 *
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CircleCanvas extends JPanel {

    private final Circle circleToDraw;

    public CircleCanvas(Circle circle){


        this.circleToDraw = circle;

        setLayout(new BorderLayout());

        JTextArea dimensionsTextArea = new JTextArea(5, 15);
        dimensionsTextArea.setText(circleToDraw.toString());
        dimensionsTextArea.setEditable(false);
        add(dimensionsTextArea, BorderLayout.NORTH);

        JButton newCircleButton = new JButton("Get Random Circle");
        newCircleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        circleToDraw.setRandomRadius(0, Math.min(getWidth()/2, getHeight()/2));
                        dimensionsTextArea.setText(circleToDraw.toString());
                        repaint();
                    }
                }
        );
        add(newCircleButton, BorderLayout.SOUTH);
        //initialized max is the radius of the first random circle cause we know that's a valid value
        JSlider radiusSlider = new JSlider(SwingConstants.VERTICAL, 1, (int)circleToDraw.getRadius(), 10);
        radiusSlider.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        try {
                            radiusSlider.setMaximum(Math.min(getWidth()/2, getHeight()/2));
                            circleToDraw.setRadius(radiusSlider.getValue());
                            dimensionsTextArea.setText(circleToDraw.toString());
                            repaint();
                        } catch (Exception e1) {
                            System.out.printf("Exception: %s%n", e1.getMessage());
                        }
                    }
                }
        );
        add(radiusSlider, BorderLayout.EAST);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.YELLOW);
        g.setColor(Color.BLACK);


        circleToDraw.drawCircle(g, getWidth() / 2, getHeight() / 2); //center coords are half of width and height
    }


}
