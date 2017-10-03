/**
 *Either you have two vertices and a length between them or you have nothing.
 *
 */

import java.awt.Graphics;

public class StraightLine extends OneDimensionalShape{

    private double length;
    private double slope;

    public StraightLine(Vertex vertex1, Vertex vertex2){

        super(vertex1, vertex2);
        this.length = computeDistance(vertex1, vertex2);
        this.slope = computeSlope(vertex1, vertex2);

    }

    /**
     * This overridden method double checks to make sure that the object's length has been set. If it hasn't,
     * compute the length by using the new coordinates given. It will also compute the
     * @param x1 x-coordinate 1
     * @param y1 y-coordinate 1
     * @param x2 x-coordinate 2
     * @param y2 y-coordinate 2
     */
    @Override
    public void setNewCoordinates(double x1, double y1, double x2, double y2) {

        super.setNewCoordinates(x1, y1, x2, y2);
        if(this.getLength() == 0) {
            this.setLength(computeDistance(x1, y1, x2, y2));
        }
        this.slope = computeSlope(x1, y1, x2, y2);
    }

    /**
     * @return the slope of the line with the given coordinates
     */
    public double getSlope() {

        return slope;
    }

    /**
     * This method will use the given Graphics awt to draw a straight line between the two coordinate pairs defined.
     * To use, call it in the overridden paintComponent method in your JPanel object of choice. Pass in the
     * center coordinates of your JPanel to treat the center vertex as the origin vertex, and offset each
     * coordinate accordingly.
     * This method can altered for use in any coordinate-based drawing program.
     * @param g the Graphics awt object being used
     * @param centerX  the center x-coordinate of the JPanel
     * @param centerY the center y-coordinate of the JPanel
     */
    public void drawStraightLine(Graphics g, int centerX, int centerY ){

        /* add center coordinate to original coordinate */
        int adjustedVertex1X = centerX + (int) getVertex1()[VertexIndex.X_COORDINATE];
        /* we subtract here because the y-coordinate is flipped in JPanel */
        int adjustedVertex1Y = centerY - (int) getVertex1()[VertexIndex.Y_COORDINATE];
        int adjustedVertex2X = centerX + (int) getVertex2()[VertexIndex.X_COORDINATE];
        int adjustedVertex2Y = centerY - (int) getVertex2()[VertexIndex.Y_COORDINATE];

        g.drawLine(adjustedVertex1X, adjustedVertex1Y, adjustedVertex2X, adjustedVertex2Y);

    }

    /**
     *
     * @param vertex1
     * @param vertex2
     * @return
     */
    private static double computeDistance(double vertex1[], double vertex2[]){


        return Math.sqrt( Math.pow((vertex2[VertexIndex.X_COORDINATE]-vertex1[VertexIndex.X_COORDINATE]), 2)
                + Math.pow((vertex2[VertexIndex.Y_COORDINATE] - vertex1[VertexIndex.Y_COORDINATE]), 2));

    }

    /**
     * This method computes the slope of the line using the two coordinate pairs that belong to the object.
     * Slope equation: m = (y2-y1)/(x2-x1)
     */
    private static double computeSlope(double vertex1[], double vertex2[]){

        return  (vertex2[VertexIndex.Y_COORDINATE] - vertex1[VertexIndex.Y_COORDINATE])
                    / (vertex2[VertexIndex.X_COORDINATE] - vertex1[VertexIndex.X_COORDINATE]);

    }

}
