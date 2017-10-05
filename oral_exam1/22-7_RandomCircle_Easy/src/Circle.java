/**
 *
 *
 *
 */

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Circle {

    private double radius;
    private double diameter;
    private double circumference;
    private double area;

    /**
     * This constructor sets the diameter of the circle to the given value.
     * @param radius the diameter of the circle desired
     * @throws Exception if the radius is less than or equal to zero
     */
    public Circle(double radius) throws Exception{

        if (radius <= 0 ){
            throw new IllegalArgumentException("Invalid radius. Radius must be larger than zero");
        }
        this.radius = radius;
        this.diameter = computeDiameter(radius);
        this.circumference = computeCircumference(radius);
        this.area = computeArea(radius);

    }

    /**
     * Default no-argument constructor for class Circle. Will instantiate all instance variables to zero.
     */
    public Circle(){

        this.radius = 0;
        this.diameter = 0;
        this.circumference = 0;
        this.area = 0;
    }

    /**
     * This method sets the radius of the circle to a random integer between the lower and upper bounds
     * that are given. To compute the random number, we create a random number generator isolated to the current
     * thread, and give it our lower and upper bounds. After setting the random radius we compute the other
     * qualities of the circle appropriately. Didn't set this as a constructor so we can have a named method.
     * @param lowerBound the lowest value the random number can have.
     * @param upperBound the highest value the random number can have.
     */
    public void setRandomRadius(int lowerBound, int upperBound){

        this.radius = ThreadLocalRandom.current().nextInt(lowerBound,
                upperBound + 1);

        this.diameter = computeDiameter(radius);
        this.circumference = computeCircumference(radius);
        this.area = computeArea(radius);
    }

    /**
     * This method sets a new radius for the circle and computes the other qualities of the circle
     * appropriately.
     * @param radius the radius of the circle
     * @throws Exception if the radius is less than or equal to zero
     */
    public void setRadius(double radius) throws Exception{

        if (radius <= 0 ){
            throw new IllegalArgumentException("Invalid radius. Radius must be larger than zero");
        }
        this.radius = radius;
        this.diameter = computeDiameter(radius);
        this.circumference = computeCircumference(radius);
        this.area = computeArea(radius);
    }

    /**
     * This method will use the Graphics AWT object given to draw the object of this class. Use this method
     * in a paintComponent method in a swing environment to appropriately view this drawing.
     * Since the "fillOval" method of Graphics draws an oval using the width and height of its surrounding rectangle
     * starting from the upper left vertex, we must offset the center coordinate accordingly.
     * Also, since the coordinates of a JPanel are integers, we must unfortunately cast the radius to an integer
     * so it can be displayed appropriately. We use "radiusAsInteger*2" instead of this object's diameter for the
     * width and height because they may be different values after casting. (ex: if r=1.5 and d=3)
     * @param g the Graphics object given
     * @param centerX the center X coordinate of the canvas
     * @param centerY the center Y coordinate of the canvas
     */
    public void drawCircle(Graphics g, int centerX, int centerY){

        final int radiusAsInteger = (int)radius;
        int adjustedXCoordinate = centerX - radiusAsInteger;
        int adjustedYCoordinate = centerY - radiusAsInteger;

        g.fillOval(adjustedXCoordinate, adjustedYCoordinate, radiusAsInteger*2, radiusAsInteger*2);

    }

    /**
     * This method computes the diameter of a circle given the radius. d = r*2
     * @param radius the radius of the circle
     * @return the diameter of the circle
     */
    public static double computeDiameter(double radius){

        return radius * 2;
    }

    /**
     * This method computes the circumference of a circle given the radius. C = 2*r*pi
     * @param radius the radius of the circle
     * @return the circumference of the circle
     */
    public static double computeCircumference(double radius){

        return 2 * radius * Math.PI;
    }

    /**
     * This method computes the area of a circle using the formula for the area of a circle. A = pi * r^2
     * @param radius the radius of the circle
     * @return the area of the circle
     */
    public static double computeArea(double radius){

        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * @return the diameter of the circle
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @return the circumference of the circle
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     * @return the area of the circle
     */
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Circle Dimensions" +
                "\nRadius = " + radius +
                "\nDiameter = " + diameter +
                "\nCircumference = " + circumference +
                "\nArea = " + area;
    }
}
