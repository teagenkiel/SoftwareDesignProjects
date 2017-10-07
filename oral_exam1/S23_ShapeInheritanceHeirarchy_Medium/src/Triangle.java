/**
 *
 */

import java.awt.Graphics;

public class Triangle extends Polygon {

    public static final int NUMBER_OF_VERTICES = 3;
    public static final int NUMBER_OF_SIDES = 3;
    public static final int INTERIOR_ANGLE_SUM_DEGREES = 180;

    /* Where each vertex of a triangle should lie in a created vertex array */
    public static final int VERTEX_A_INDEX = 0;
    public static final int VERTEX_B_INDEX = 1;
    public static final int VERTEX_C_INDEX = 2;

    private StraightLine base;
    private StraightLine side1;
    private StraightLine side2;

    /**
     * Main constructor for class Triangle. The constructor takes in the lengths of all three sides, creates
     * a StraightLine object (with corresponding length) for each, and sets them equal to the instance variables.
     * @param baseLength the length of the base
     * @param side1Length the length of side 1
     * @param side2Length the length of side 2
     */
    public Triangle(double baseLength, double side1Length, double side2Length) throws Exception {
        super(computeArea(baseLength,side1Length,side2Length), computePerimeter(baseLength,side1Length,side2Length));

        validateTriangle(baseLength, side1Length, side2Length);

        Vertex[] vertexList = computeTriangleCoordinates(baseLength, side1Length, side2Length);
        this.base = new StraightLine(vertexList[VERTEX_A_INDEX], vertexList[VERTEX_B_INDEX]);
        this.side1 = new StraightLine(vertexList[VERTEX_A_INDEX], vertexList[VERTEX_C_INDEX]);
        this.side2 = new StraightLine(vertexList[VERTEX_B_INDEX], vertexList[VERTEX_C_INDEX]);
    }

    /**
     * This method will create and store new measurements in the same fashion as the constructor
     * based on the side lengths given.
     * @param baseLength the length of the base
     * @param side1Length the length of side1
     * @param side2Length the length of side2
     * @throws Exception if these sides cannot make a valid triangle
     */
    public void setNewMeasurements(double baseLength, double side1Length, double side2Length) throws Exception{
        super.setNewMeasurements(computeArea(baseLength,side1Length,side2Length),
                computePerimeter(baseLength,side1Length,side2Length));

        validateTriangle(baseLength, side1Length, side2Length);

        Vertex[] vertexList = computeTriangleCoordinates(baseLength, side1Length, side2Length);

        base.setNewCoordinates(vertexList[VERTEX_A_INDEX], vertexList[VERTEX_B_INDEX]);
        side1.setNewCoordinates(vertexList[VERTEX_A_INDEX], vertexList[VERTEX_C_INDEX]);
        side2.setNewCoordinates(vertexList[VERTEX_B_INDEX], vertexList[VERTEX_C_INDEX]);
    }

    /**
     * This method checks if a valid triangle can be made from the given side lengths. A triangle cannot be
     * made if one side is greater than or equal to the sum of the other two sides.
     * @param side1 first side of the triangle
     * @param side2 second side of the triangle
     * @param side3 third side of the triangle
     * @throws Exception if a valid triangle cannot be made
     */
    private static void validateTriangle(double side1, double side2, double side3) throws Exception{
        if( (side1 + side2) <= side3 || (side1 + side3) <= side2 || (side2 + side3) <= side1){

            throw new IllegalArgumentException("Invalid triangle. One side cannot be larger than " +
                    "or equal to the other two combined");
        }
    }

    /**
     * This method will compute the third vertex of the triangle when we assume that we know the two vertices of
     * the base edge, which are (0,0) and (length of base, 0). This computation is done by using the three distance
     * formulas for each side and solving for the x and y coordinate of the third vertex, with help from
     * math.stackexchange.com. This method also simplifies the variables to ease the readability of the code.
     * The base has vertices 'A' and 'B' and the vertex 'C' is the coordinate we are solving for.
     * Base = line AB, side1 = line AC, side2 = line BC.
     * @param baseLength baselength
     * @param side1Length side 1 length
     * @param side2Length side 2 length
     *
     */
    private static Vertex[] computeTriangleCoordinates(double baseLength, double side1Length, double side2Length){

        double dAB = baseLength; //distance between point A and point B, aka base length
        double dAC = side1Length; //distance between point A and point C, aka side1 length
        double dBC = side2Length; //distance between point B and point C, aka side2 length


        double Ax = Vertex.ORIGIN_X_COORDINATE; //x-coordinate of A
        double Ay = Vertex.ORIGIN_Y_COORDINATE; //y-coordinate of A
        double Bx = baseLength; //x-coordinate of B
        double By = Vertex.ORIGIN_Y_COORDINATE; //y-coordinate of B
        double Cx = ((dAB*dAB) + (dAC*dAC) - (dBC*dBC)) / (2 * dAB); //computes x-coordinate of C
        double Cy = (Math.sqrt((dAB+dAC+dBC)*(dAB+dAC-dBC)*(dAB-dAC+dBC)*(-dAB+dAC+dBC))) / (2*dAB); //computes y-coordinate of C

        Vertex vertexList[] = new Vertex[NUMBER_OF_VERTICES];
        vertexList[VERTEX_A_INDEX] = new Vertex(Ax,Ay);
        vertexList[VERTEX_B_INDEX] = new Vertex(Bx,By);
        vertexList[VERTEX_C_INDEX] = new Vertex(Cx,Cy);
        return vertexList; //returns list of created vertices
    }

    /**
     * This method uses the "drawStraightLine()" method in each edge of the triangle to draw the built triangle using
     * swing GUI paintComponent method. The method first calls the compute coordinates method to make sure each
     * StraightLine has the correct coordinates.
     * @param g the Graphics awt object
     * @param centerX the center x-coordinate of the JPanel
     * @param centerY the center y-coordinate of the JPanel
     */
    public void drawTriangle(Graphics g, int centerX, int centerY){

        base.drawStraightLine(g, centerX, centerY);
        side1.drawStraightLine(g, centerX, centerY);
        side2.drawStraightLine(g, centerX, centerY);
    }

    /*
     * This method computes the perimeter of a triangle by adding the lengths of all three sides of the triangle.
     */
    private static double computePerimeter(double baseLength, double side1Length, double side2Length){

        return baseLength + side1Length + side2Length;
    }

    /*
     * This method uses Heron's formula to calculate the area of a triangle, which doesn't require a base, angle,
     * or height to be known. We are using Heron's formula here in the case that the height cannot be computed
     * (i.e. side 2 extends past the base). This formula is sqrt(s * (s-a) * (s-b) * (s-c)) where s is the semiperimeter
     * and a,b,c are the sides of the triangle.
     * @return the area of the triangle computed using three side lengths
     */
    private static double computeArea(double baseLength, double side1Length, double side2Length){

        double semiperimeter = ((baseLength + side1Length + side2Length) / 2);

         return (Math.sqrt((semiperimeter) * (semiperimeter - baseLength) * (semiperimeter - side1Length)
            * (semiperimeter - side2Length)));

    }

    /**
     * @return a string containing the values of the instance variables in an object of this class
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "Area=" + this.getArea() +
                ", Perimeter=" + this.getPerimeter() + '}';
    }
}
