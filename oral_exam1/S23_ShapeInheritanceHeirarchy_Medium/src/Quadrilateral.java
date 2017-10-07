/**
 * This class will create an object that represents a quadrilateral. Every quadrilateral has four sides and four
 * vertices. The vertices in the quadrilateral are represented by a different letter, A being the lower left, B
 * being the lower right, C being the upper left, and D being the upper right. The interior angles at each vertex and
 * the sides between each two vertices are represented accordingly.
 *
 * @author Teagen Kiel
 */

import java.awt.Graphics;

public class Quadrilateral extends Polygon {

    public static final int NUMBER_OF_VERTICES = 4;
    public static final int NUMBER_OF_SIDES = 4;

    //these static final variables are to be used with assigning and reading from an array of vertices representing
    //each vertex of the quadrilateral.
    private static final int VERTEX_A_INDEX = 0;
    private static final int VERTEX_B_INDEX = 1;
    private static final int VERTEX_C_INDEX = 2;
    private static final int VERTEX_D_INDEX = 3;

    private StraightLine baseAB;
    private StraightLine sideAC;
    private StraightLine sideBD;
    private StraightLine sideCD;

    /**
     * Main constructor for class Quadrilateral. This constructor will compute the area and perimeter and
     * give it to the superclasses constructor, validate the angles used to compute the length of the top
     * side (CD), compute the quadrilateral's coordinates and then use those coordinates to
     * create a side object representing each side of the quadrilateral.
     * @param baseABLength the length of the side from vertex A to vertex B
     * @param sideACLength the length of the side from vertex A to vertex C
     * @param sideBDLength the length of the side from vertex B to vertex D
     * @param angleA the magnitude of the interior angle at vertex A
     * @param angleB the magnitude of the interior angle at vertex B
     * @throws Exception if the angles are out of range
     */
    public Quadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA, double angleB)
            throws Exception{
        super(computeArea(baseABLength, sideACLength, sideBDLength, angleA, angleB),
                computePerimeter(baseABLength, sideACLength, sideBDLength, angleA, angleB));


        validateAngle(angleA);
        validateAngle(angleB);

        Vertex quadVertices[] =
                computeQuadrilateralCoordinates(baseABLength, sideACLength, sideBDLength, angleA, angleB);


        this.baseAB = new StraightLine(quadVertices[VERTEX_A_INDEX], quadVertices[VERTEX_B_INDEX]);
        this.sideAC = new StraightLine(quadVertices[VERTEX_A_INDEX], quadVertices[VERTEX_C_INDEX]);
        this.sideBD = new StraightLine(quadVertices[VERTEX_B_INDEX], quadVertices[VERTEX_D_INDEX]);
        this.sideCD = new StraightLine(quadVertices[VERTEX_C_INDEX], quadVertices[VERTEX_D_INDEX]);
    }

    /**
     * This method validates an interior angle of a quadrilateral making sure it does not extend
     * past 179 degrees or below 1 degree. This would make an invalid quadrilateral.
     * @param angle the angle to validate
     * @throws Exception if the angle is not in the range desired
     */
    private static void validateAngle(double angle) throws Exception{

        if(angle >= 180 || angle <= 0){
            throw new IllegalArgumentException("Invalid angle. Angles must be larger than zero degrees " +
                    "and smaller than 180 degrees");
        }
    }


    /**
     * This method will compute the coordinates of a quadrilateral. It sets the A and B coordinates so that the
     * base side is along the x-axis starting from the origin. It returns a list of vertices with each vertex
     * representing each vertex of the quadrilateral.
     * @param baseABLength the length of the side from vertex A to vertex B
     * @param sideACLength the length of the side from vertex A to vertex C
     * @param sideBDLength the length of the side from vertex B to vertex D
     * @param angleA the magnitude of the interior angle at vertex A
     * @param angleB the magnitude of the interior angle at vertex B
     * @return an array of vertices designated by the static final vertex indexes.
     */
    private static Vertex[] computeQuadrilateralCoordinates(double baseABLength, double sideACLength, double sideBDLength,
                                                              double angleA, double angleB){

        double Ax = Vertex.ORIGIN_X_COORDINATE;
        double Ay = Vertex.ORIGIN_Y_COORDINATE;
        double Bx = baseABLength;
        double By = Vertex.ORIGIN_Y_COORDINATE;

        Vertex vertexList[] = new Vertex[NUMBER_OF_VERTICES];
        vertexList[VERTEX_A_INDEX] = new Vertex(Ax, Ay);
        vertexList[VERTEX_B_INDEX] = new Vertex(Bx, By);
        vertexList[VERTEX_C_INDEX] = computeVertexC(angleA, sideACLength);
        vertexList[VERTEX_D_INDEX] = computeVertexD(angleB, baseABLength, sideBDLength);

        return vertexList;
    }

    /**
     * This method will compute the x and y coordinates of the C vertex using the SOHCAHTOA method and its
     * respective trigonometric properties.
     * @param angleA the interior angle of the quadrilateral associated with vertex A
     * @param sideACLength the length of the side from vertex A to vertex C
     * @return a Vertex object containing the x and y coordinates of the C vertex
     */
    public static Vertex computeVertexC(double angleA, double sideACLength){

        return new Vertex(Math.cos(Math.toRadians(angleA)) * sideACLength,
                Math.sin(Math.toRadians(angleA)) * sideACLength);
    }

    /* the normal cos * BDlength computes the x-coordinate of point D in relation to point B, so we add
            the base length to put the coordinate in relation to the origin.  */

    /**
     * This method will compute the x and y coordinates of the D vertex using the SOHCAHTOA method. We must
     * offset the x calculation by the base length because the calculation computes the components in regards to
     * the B vertex. We also must flip the angle by subtracting it by 180 degrees because the trigonometric identities
     * compute it facing the right side.
     * @param angleB the interior angle of the quadrilateral associated with vertex B
     * @param baseABLength the length of the base
     * @param sideBDLength the length of the side b/t vertex B and D
     * @return a Vertex object containing the x and y coordinates of the D vertex
     */
    public static Vertex computeVertexD(double angleB, double baseABLength, double sideBDLength) {

        final int angleFlipOffset = 180; //degrees

        return new Vertex(baseABLength + Math.cos(Math.toRadians(angleFlipOffset - angleB)) * sideBDLength,
                Math.sin(Math.toRadians(angleFlipOffset - angleB)) * sideBDLength);
    }

    /**
     * This method will compute the perimeter by computing the length of the top side and then
     * adding together the length of each side.
     * @param baseABLength the length of the side from vertex A to vertex B
     * @param sideACLength the length of the side from vertex A to vertex C
     * @param sideBDLength the length of the side from vertex B to vertex D
     * @param angleA the magnitude of the interior angle at vertex A
     * @param angleB the magnitude of the interior angle at vertex B
     * @return the perimeter of the quadrilateral
     */
    private static double computePerimeter(double baseABLength, double sideACLength, double sideBDLength,
                                           double angleA, double angleB){

        double sideCDLength = StraightLine.computeDistance(computeVertexC(angleA, sideACLength),
                computeVertexD(angleB, baseABLength, sideBDLength));

        return baseABLength + sideACLength + sideBDLength + sideCDLength;
    }


    /**
     * This method will use Bretschneider's formula to compute the area of a quadrilateral.
     * @param baseABLength the length of the side from vertex A to vertex B
     * @param sideACLength the length of the side from vertex A to vertex C
     * @param sideBDLength the length of the side from vertex B to vertex D
     * @param angleA the magnitude of the interior angle at vertex A
     * @param angleB the magnitude of the interior angle at vertex B
     * @return the area of the quadrilateral
     */
    public static double computeArea(double baseABLength, double sideACLength, double sideBDLength,
                                    double angleA, double angleB){

        Vertex quadVertices[] = computeQuadrilateralCoordinates(baseABLength, sideACLength, sideBDLength, angleA, angleB);
        double sideCDLength = StraightLine.computeDistance(computeVertexC(angleA, sideACLength),
                computeVertexD(angleB, baseABLength, sideBDLength));

        double s = (baseABLength + sideACLength + sideBDLength + sideCDLength) / 2; //computes semiperimeter

        double angleD = computeAngle(new StraightLine(quadVertices[VERTEX_B_INDEX], quadVertices[VERTEX_D_INDEX]),
                new StraightLine(quadVertices[VERTEX_C_INDEX], quadVertices[VERTEX_D_INDEX]));
            //computes angle between sideBD and sideCD (angle opposite of angle A)

        double theta = angleA + angleD;
        System.out.println(sideCDLength);
        System.out.println(s);
        System.out.println(angleD);
        double dAB = baseABLength;
        double dAC = sideACLength;
        double dBD = sideBDLength;
        double dCD = sideCDLength;
        //these variables make the formula below easier to read and understand

        return (Math.sqrt( ((s-dAB)*(s-dAC)*(s-dBD)*(s-dCD)) -
                ((.5) * dAB * dAC * dBD * dCD * (1 + Math.cos(Math.toRadians(theta)))) ));

    }

    /**
     * This method used the Graphics object passed to it to draw the quadrilateral object using the current coordinates.
     * To draw, use this method inside an Overridden paintComponent method.
     * @param g the AWT Graphics object
     * @param centerX the x-coordinate of the center of the panel
     * @param centerY the y-coordinate of the center of the panel
     */
    public void drawQuadrilateral(Graphics g, int centerX, int centerY){

        baseAB.drawStraightLine(g, centerX, centerY);
        sideAC.drawStraightLine(g, centerX, centerY);
        sideBD.drawStraightLine(g, centerX, centerY);
        sideCD.drawStraightLine(g, centerX, centerY);
    }

    /**
     * @return a string containing the values of the area and perimeter for this object
     */
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "Area=" + this.getArea() +
                ", Perimeter=" + this.getPerimeter() +
                "}";
    }
}
