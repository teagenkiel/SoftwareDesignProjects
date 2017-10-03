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
    private double angleB;



    public Quadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA, double angleB)
            throws Exception{

        validateAngle(angleA);
        validateAngle(angleB);

        StraightLine baseAB = new StraightLine(baseABLength);
        StraightLine sideAC = new StraightLine(sideACLength);
        StraightLine sideBD = new StraightLine(sideBDLength);
        StraightLine sideCD = new StraightLine();

        this.baseAB = baseAB;
        this.sideAC = sideAC;
        this.sideBD = sideBD;
        this.sideCD = sideCD;
        this.angleA = angleA;
        this.angleB = angleB;
    }

    private static void validateAngle(double angle) throws Exception{

        if(angle >= 180 || angle <= 0){
            throw new IllegalArgumentException("Invalid angle. Angles must be larger than zero degrees " +
                    "and smaller than 180 degrees");
        }
    }


    private void computeQuadrilateralCoordinates(){

        System.out.println("sideBD length" + sideBD.getLength());

        double Ax = 0;
        double Ay = 0;
        double Bx = baseAB.getLength();
        double By = 0;
        double Cx = Math.cos(Math.toRadians(angleA)) * sideAC.getLength();
        double Cy = Math.sin(Math.toRadians(angleA)) * sideAC.getLength();
        /* the normal cos * BDlength computes the x-coordinate of point D in relation to point B, so we add
            the base length to put the coordinate in relation to the origin. */
        double Dx = baseAB.getLength() + Math.cos(Math.toRadians(180 - angleB)) * sideBD.getLength();
        double Dy = Math.sin(Math.toRadians(180 - angleB)) * sideBD.getLength();

        baseAB.setNewCoordinates(Ax, Ay, Bx, By);
        sideAC.setNewCoordinates(Ax, Ay, Cx, Cy);
        sideBD.setNewCoordinates(Bx, By, Dx, Dy);
        sideCD.setNewCoordinates(Cx, Cy, Dx, Dy);

    }

    public void drawQuadrilateral(Graphics g, int centerX, int centerY){

        this.computeQuadrilateralCoordinates();
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
