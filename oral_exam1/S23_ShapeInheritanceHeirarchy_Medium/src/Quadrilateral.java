/**
 *
 */

import java.awt.Graphics;

public class Quadrilateral extends Polygon {

    public static final int NUMBER_OF_VERTICES = 4;
    public static final int NUMBER_OF_SIDES = 4;

    private static final int VERTEX_A_INDEX = 0;
    private static final int VERTEX_B_INDEX = 1;
    private static final int VERTEX_C_INDEX = 2;
    private static final int VERTEX_D_INDEX = 3;

    private StraightLine baseAB;
    private StraightLine sideAC;
    private StraightLine sideBD;
    private StraightLine sideCD;
    private double angleA;


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
        this.angleA = angleA;
    }

    private static void validateAngle(double angle) throws Exception{

        if(angle >= 180 || angle <= 0){
            throw new IllegalArgumentException("Invalid angle. Angles must be larger than zero degrees " +
                    "and smaller than 180 degrees");
        }
    }


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

    private static Vertex computeVertexC(double angleA, double sideACLength){

        return new Vertex(Math.cos(Math.toRadians(angleA)) * sideACLength,
                Math.cos(Math.toRadians(angleA)) * sideACLength);
    }

    /* the normal cos * BDlength computes the x-coordinate of point D in relation to point B, so we add
            the base length to put the coordinate in relation to the origin.  */
    private static Vertex computeVertexD(double angleB, double baseABLength, double sideBDLength) {

        final int angleFlipOffset = 180; //degrees

        return new Vertex(baseABLength + Math.cos(Math.toRadians(angleFlipOffset - angleB)) * sideBDLength,
                Math.sin(Math.toRadians(angleFlipOffset - angleB)) * sideBDLength);
    }

    /**
     * This method will compute the perimeter by adding together the length of each side.
     */
    private static double computePerimeter(double baseABLength, double sideACLength, double sideBDLength,
                                           double angleA, double angleB){

        double sideCDLength = StraightLine.computeDistance(computeVertexC(angleA, sideACLength),
                computeVertexD(angleB, baseABLength, sideBDLength));

        return baseABLength + sideACLength + sideBDLength + sideCDLength;
    }


    /**
     * This method will use Bretschneider's formula to compute the area of a quadrilateral.
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

        double dAB = baseABLength;
        double dAC = sideACLength;
        double dBD = sideBDLength;
        double dCD = sideCDLength;
        //these variables make the formula below easier to read and understand

        return (Math.sqrt( ((s-dAB)*(s-dAC)*(s-dBD)*(s-dCD)) -
                ((.5) * dAB * dAC * dBD * dCD * (1 + Math.cos(Math.toRadians(theta)))) ));

    }

    public void drawQuadrilateral(Graphics g, int centerX, int centerY){

        baseAB.drawStraightLine(g, centerX, centerY);
        sideAC.drawStraightLine(g, centerX, centerY);
        sideBD.drawStraightLine(g, centerX, centerY);
        sideCD.drawStraightLine(g, centerX, centerY);
    }


}
