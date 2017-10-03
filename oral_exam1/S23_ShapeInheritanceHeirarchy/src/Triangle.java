/**
 *
 */

import java.awt.Graphics;

public class Triangle extends TwoDimensionalShape{

    private StraightLine base;
    private StraightLine side1;
    private StraightLine side2;

    /**
     * Main constructor for class Triangle. Takes in three straight line objects and will for them into a
     * triangle.
     * @param base
     * @param side1
     * @param side2
     */
    public Triangle(StraightLine base, StraightLine side1, StraightLine side2){
        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
    }

    /**
     * Easier constructor if the user wants to enter side lengths instead of instantiating 3 StraightLine Objects
     * @param baseLength the length of the base
     * @param side1Length the length of side 1
     * @param side2Length the length of side 2
     */
    public Triangle(double baseLength, double side1Length, double side2Length){
        StraightLine base = new StraightLine(baseLength);
        StraightLine side1 = new StraightLine(side1Length);
        StraightLine side2 = new StraightLine(side2Length);

        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
    }

    /**
     * This method will compute the third vertex of the triangle when we assume that we know the two vertices of
     * the base edge, which are (0,0) and (length of base, 0). This computation is done by using the three distance
     * formulas for each side and solving for the x and y coordinate of the third vertex, and with help from
     * math.stackexchange.com. This method also simplifies the variables to ease the readability of the code.
     * The base has vertices 'A' and 'B' and the vertex 'C' is the coordinate we are solving for.
     * Base = line AB, side1 = line AC, side2 = line BC.
     */
    private void computeTriangleCoordinates(){

        double dAB = base.getLength(); //distance between point A and point B, aka base length
        double dAC = side1.getLength(); //distance between point A and point C, aka side1 length
        double dBC = side2.getLength(); //distance between point B and point C, aka side2 length

        double Ax = 0; //x-coordinate of A
        double Ay = 0; //y-coordinate of A
        double Bx = base.getLength(); //x-coordinate of B
        double By = 0; //y-coordinate of B
        double Cx = ((dAB*dAB) + (dAC*dAC) - (dBC*dBC)) / (2 * dAB); //computes x-coordinate of C
        double Cy = (Math.sqrt((dAB+dAC+dBC)*(dAB+dAC-dBC)*(dAB-dAC+dBC)*(-dAB+dAC+dBC))) / (2*dAB); //computes y-coordinate of C

        base.setNewCoordinates(Ax, Ay, Bx, By); //Sets coordinates of base to A and B
        side1.setNewCoordinates(Ax, Ay, Cx, Cy); //Sets coordinates of side1 to A and C
        side2.setNewCoordinates(Bx, By, Cx, Cy); //Sets coordinates of side2 to B and C

    }

    public void drawTriangle(Graphics g, int centerX, int centerY){

        base.drawStraightLine(g, centerX, centerY);
        side1.drawStraightLine(g, centerX, centerY);
        side2.drawStraightLine(g, centerX, centerY);

    }

    /**
     * This method computes the perimeter of a triangle by adding the lengths of all three sides of the triangle.
     */
    private void computePerimeter(){

        setPerimeter(base.getLength() + side1.getLength() + side2.getLength());
    }

    /**
     * This method uses Heron's formula to calculate the area of a triangle, which doesn't require a base, angle,
     * or height to be known. We are using Heron's formula here in the case that the height cannot be computed
     * (i.e. side 2 extends past the base). This formula is sqrt(s * (s-a) * (s-b) * (s-c)) where s is the semiperimeter
     * and a,b,c are the sides of the triangle.
     */
    private void computeArea(){
        if(this.getPerimeter() == 0){ //if perimeter is zero i.e. it hasn't been computed yet, do the computation.
            this.computePerimeter();
        }
        double semiperimeter = (this.getPerimeter() / 2);

         setArea(Math.sqrt((semiperimeter) * (semiperimeter - base.getLength()) * (semiperimeter - side1.getLength())
            * (semiperimeter - side2.getLength())));

    }


}
