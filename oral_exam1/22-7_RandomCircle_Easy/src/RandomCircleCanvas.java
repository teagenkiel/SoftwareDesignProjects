/**
 * This class's purpose is to provide a JPanel with a canvas on which a random circle will be drawn. This canvas will
 * also include various components to alter, renew, and display the dimensions of the circle that is currently drawn.
 *
 * @author Teagen Kiel
 * @see Circle
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class RandomCircleCanvas extends JPanel {

    private Circle circleToDraw;

    /**
     * This is the main constructor for the class RandomCircleCanvas. The constructor will create a circle for use
     * with the object, and set it with a random radius regarding the constraints given. The constructor will
     * then initialize three components, a JTextArea that will display the dimensions of the circle, a JButton that will
     * set the radius of the circle to a new random number, and a JSlider that will change the radius of the circle
     * based on where the user slides it. We then add the appropriate listeners to the listenerList of the
     * button, slider, and the object itself and define the handler for each as an anonymous inner class
     * defining the actions upon receiving an event.
     * @param maximumRadius the maximum radius the circle can take upon initialization. After initialization, the
     *                      maximum radius will changed based on the height and width of this JPanel object.
     */
    public RandomCircleCanvas(int maximumRadius){


        this.circleToDraw = new Circle();
        circleToDraw.setRandomRadius(Circle.MINIMUM_RADIUS, maximumRadius);

        setLayout(new BorderLayout());

        JTextArea dimensionsTextArea = new JTextArea(5, 10); //creates text area with area needed to display dimensions
        dimensionsTextArea.setText(circleToDraw.toString()); //adds circle dimensions to TextArea
        dimensionsTextArea.setEditable(false);
        add(dimensionsTextArea, BorderLayout.NORTH);

        JButton newCircleButton = new JButton("Get Random Circle"); //button to get a new random circle
        add(newCircleButton, BorderLayout.SOUTH);

        JSlider radiusSlider = new JSlider(SwingConstants.VERTICAL, Circle.MINIMUM_RADIUS, maximumRadius,
                (int)circleToDraw.getRadius()); //slider to increase or decrease the radius of the circle
        add(radiusSlider, BorderLayout.EAST);

        newCircleButton.addActionListener( //adds actionListener to listenerList of the newCircleButton
                new ActionListener() { //anonymous inner class describes how to handle event
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        circleToDraw.setRandomRadius(Circle.MINIMUM_RADIUS, Math.min(getWidth()/2, getHeight()/2));
                        //max bound being the smaller of half of the width and height of the panel (maximum radius)
                        dimensionsTextArea.setText(circleToDraw.toString()); //shows new dimensions on TextArea
                        radiusSlider.setValue((int)circleToDraw.getRadius());
                        //set the current value of the slider to the current radius
                        repaint();
                    }
                }
        );

        radiusSlider.addChangeListener( //adds changeListener to listenerList of radiusSlider
                new ChangeListener() { //anonymous inner class describes how to handle event
                    @Override
                    public void stateChanged(ChangeEvent event) {
                        try {
                            circleToDraw.setRadius(radiusSlider.getValue());
                            //set new radius of the circle to the new value of the JSlider
                        } catch (Exception e1) { //if the radius of the circle is below 1
                            System.out.printf("Exception: %s%n", e1.getMessage());
                        }
                        dimensionsTextArea.setText(circleToDraw.toString());
                        //show dimensions of the new circle in the TextArea
                        repaint();
                    }
                }
        );

        this.addComponentListener( //adds a ComponentListener to listenerList of this object
                new ComponentAdapter() { //using adapter here because we only need to declare one method
                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);

                        radiusSlider.setMaximum(Math.min(getWidth()/2, getHeight()/2));
                        //sets new maximum of the JSlider if the panel has changed size the the smaller half-coordinate
                    }
                }
        );

    }


    /**
     * This method allows the user to see the circle desired on the screen. It calls the drawCircle method of the
     * circle which uses the Graphics object to draw a circle on the JPanel with the current radius of the circle.
     * @param g the Graphics AWT object used to draw to the screen
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.setBackground(Color.YELLOW); //go
        g.setColor(Color.BLACK);         //hawks

        circleToDraw.drawCircle(g, getWidth() / 2, getHeight() / 2); //center coords are half of width and height
    }


}
