/**
 *
 */

import java.awt.Graphics;

public class Quadrilateral extends TwoDimensionalPolygon {

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
        double Dx = Math.cos(Math.toRadians(180 - angleB)) * sideBD.getLength();
        System.out.println("Dx: " + Dx);
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





}
