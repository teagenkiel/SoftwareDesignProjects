/**
 *
 */

import java.awt.Graphics;

public class Quadrilateral extends Polygon {

    private StraightLine baseAB;
    private StraightLine sideAC;
    private StraightLine sideBD;
    private StraightLine sideCD;
    private double angleA;



    public Quadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA, double angleB)
            throws Exception{
        final int vertexAIndex = 0;
        final int vertexBIndex = 1;
        final int vertexCIndex = 2;
        final int vertexDIndex = 3;

        validateAngle(angleA);
        validateAngle(angleB);

        double[][] quadVertices =
                computeQuadrilateralCoordinates(baseABLength, sideACLength, sideBDLength, angleA, angleB);



        this.baseAB = new StraightLine(quadVertices[vertexAIndex], quadVertices[vertexBIndex]);
        this.sideAC = sideAC;
        this.sideBD = sideBD;
        this.sideCD = sideCD;
        this.angleA = angleA;
    }

    private static void validateAngle(double angle) throws Exception{

        if(angle >= 180 || angle <= 0){
            throw new IllegalArgumentException("Invalid angle. Angles must be larger than zero degrees " +
                    "and smaller than 180 degrees");
        }
    }


    private static double[][] computeQuadrilateralCoordinates(double baseABLength, double sideACLength, double sideBDLength,
                                                              double angleA, double angleB){

        double Ax = 0;
        double Ay = 0;
        double Bx = baseABLength;
        double By = 0;
        double Cx = Math.cos(Math.toRadians(angleA)) * sideACLength;
        double Cy = Math.sin(Math.toRadians(angleA)) * sideACLength;
        /* the normal cos * BDlength computes the x-coordinate of point D in relation to point B, so we add
            the base length to put the coordinate in relation to the origin. */
        double Dx = baseABLength + Math.cos(Math.toRadians(180 - angleB)) * sideBDLength;
        double Dy = Math.sin(Math.toRadians(180 - angleB)) * sideBDLength;


        return new double[][]{{Ax,Ay},{Bx,By},{Cx,Cy},{Dx,Dy}};
    }

    public void drawQuadrilateral(Graphics g, int centerX, int centerY){

        baseAB.drawStraightLine(g, centerX, centerY);
        sideAC.drawStraightLine(g, centerX, centerY);
        sideBD.drawStraightLine(g, centerX, centerY);
        sideCD.drawStraightLine(g, centerX, centerY);
    }


    /**
     * This method will compute the perimeter by adding together the length of each side.
     */
    private void computePerimeter(){

        this.setPerimeter(baseAB.getLength() + sideAC.getLength() + sideBD.getLength() + sideCD.getLength());
    }


    /**
     * This method will use Bretschneider's formula to compute the area of a quadrilateral.
     */
    private void computeArea(){

        if(this.getPerimeter() == 0){
            computePerimeter();
        }

        double s = this.getPerimeter() / 2; //computes semiperimeter
        double theta = angleA + computeAngle(sideBD, sideCD);
        double dAB = baseAB.getLength();
        double dAC = sideAC.getLength();
        double dBD = sideBD.getLength();
        double dCD = sideCD.getLength();

        this.setArea(Math.sqrt( ((s-dAB)*(s-dAC)*(s-dBD)*(s-dCD)) -
                ((.5) * dAB * dAC * dBD * dCD * (1 + Math.cos(Math.toRadians(theta)))) ));

    }


}
