/**
 *This class extends the OneDimensionalShape class in order to create an object which is a straight line
 * between two vertices. This class adds the instance variables "length" and "slope" which are used to store
 * the value of the straight-path distance between the vertices and the slope in relation to the coordinate plane,
 * respectively. Lastly, there is a method which will use the Graphics AWT to draw a line on the screen when used in
 * conjunction with the paintComponent method of the JPanel swing GUI.
 *
 * @author Teagen Kiel
 */

import java.awt.Graphics;

public class StraightLine extends OneDimensionalShape{

    private double length;
    private double slope;

    /**
     * Main constructor for class StraightLine
     * @param vertex1 the first vertex, or start of the line
     * @param vertex2 the second vertex, or end of the line
     */
    public StraightLine(Vertex vertex1, Vertex vertex2){

        super(new Vertex(vertex1), new Vertex(vertex2));
        this.length = computeDistance(vertex1, vertex2);
        this.slope = computeSlope(vertex1, vertex2);

    }

    /**
     * Copy constructor for class StraightLine
     * @param straightLine the StraightLine to copy from
     */
    public StraightLine(StraightLine straightLine){

        this(straightLine.getVertex1(), straightLine.getVertex2());
    }

    /**
     * This method overrides the same method in the superclass to include the computation and storage of the
     * length and slope variables.
     * @param vertex1 the first vertex to set
     * @param vertex2 the second vertex to set
     */
    @Override
    public void setNewCoordinates(Vertex vertex1, Vertex vertex2) {

        super.setNewCoordinates(vertex1, vertex2);
        this.length = computeDistance(vertex1, vertex2);
        this.slope = computeSlope(vertex1, vertex2);
    }

    /**
     * @return the length of the straight line between vertices 1 and 2
     */
    public double getLength() {
        return length;
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
        int adjustedVertex1X = centerX + (int) getVertex1().getX();
        /* we subtract here because the y-coordinate is flipped in JPanel */
        int adjustedVertex1Y = centerY - (int) getVertex1().getY();
        int adjustedVertex2X = centerX + (int) getVertex2().getX();
        int adjustedVertex2Y = centerY - (int) getVertex2().getY();

        /* draws the line on a given JPanel using the adjusted coordinates*/
        g.drawLine(adjustedVertex1X, adjustedVertex1Y, adjustedVertex2X, adjustedVertex2Y);

    }

    /**
     *This method will use the distance formula to calculate the straight-path distance between two vertices.
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the straight-path distance from the vertex1 to vertex2
     */
    public static double computeDistance(Vertex vertex1, Vertex vertex2){

        final int secondPower = 2;

        return Math.sqrt( Math.pow((vertex2.getX()-vertex1.getX()), secondPower)
                + Math.pow((vertex2.getY() - vertex1.getY()), secondPower));

    }

    /**
     * This method computes the slope of the line using the two coordinate pairs that belong to the object.
     * Slope equation: m = (y2-y1)/(x2-x1)
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the slope of the line between vertex1 and vertex2
     */
    private static double computeSlope(Vertex vertex1, Vertex vertex2){

        return  (vertex2.getY() - vertex1.getY())
                    / (vertex2.getX() - vertex1.getX());

    }

    /**
     * toString method for StraightLine. Displays the calculated length and slope of the line.
     * @return a string containing the instance variable's current values
     */
    @Override
    public String toString() {
        return "StraightLine{" +
                "length = " + length +
                ", slope = " + slope +
                '}';
    }
}
