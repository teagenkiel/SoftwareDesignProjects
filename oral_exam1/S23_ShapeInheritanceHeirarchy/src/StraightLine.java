/**
 *
 *
 */

import java.awt.Graphics;

public class StraightLine extends OneDimensionalShape{


    public StraightLine(double x1, double y1, double x2, double y2){

        super(x1, y1, x2, y2);
        setLength(computeDistance(x1, y1, x2, y1));

    }


    public StraightLine(double length) throws Exception{
        super(length);
    }

    public StraightLine(){ super(); }


    @Override
    public void setNewCoordinates(double x1, double y1, double x2, double y2) {

        super.setNewCoordinates(x1, y1, x2, y2);
        this.setLength(computeDistance(x1, y1, x2, y2));
    }



    /**
     * This method will use the given Graphics awt to draw a straight line between the two coordinate pairs defined.
     * To use, call it in the overridden paintComponent method in your JPanel object of choice. Pass in the
     * center coordinates of your JPanel in order for the line to be placed in relation to the center of your panel.
     * This method can altered for use in any coordinate-based drawing program.
     * @param g the Graphics awt object being used
     * @param centerX  the center x-coordinate of the JPanel
     * @param centerY the center y-coordinate of the JPanel
     */
    public void drawStraightLine(Graphics g, int centerX, int centerY ){

        int adjustedPoint1X = centerX + (int)getCoordinatePair1()[0]; //add center coordinate to original coordinate
        int adjustedPoint1Y = centerY - (int)getCoordinatePair1()[1]; //we subtract here because the y-coordinate is flipped in JPane
        int adjustedPoint2X = centerX + (int)getCoordinatePair2()[0];
        int adjustedPoint2Y = centerY - (int)getCoordinatePair2()[1];

        g.drawLine(adjustedPoint1X, adjustedPoint1Y, adjustedPoint2X, adjustedPoint2Y);

    }

    /**
     * This method will use the distance formula to compute the straight-line distance between two coordinates.
     * @param x1 x-coordinate 1
     * @param y1 y-coordinate 1
     * @param x2 x-coordinate 2
     * @param y2 y-coordinate 2
     * @return the distance between the two coordinates
     */
    private static double computeDistance(double x1, double y1, double x2, double y2){

        return Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));

    }

}
