/**
 *A polygon (/ˈpɒlɪɡɒn/) is a plane figure that is bounded by a finite chain of straight line segments closing in a
 * loop to form a closed polygonal chain or circuit. These segments are called its edges or sides,
 * and the points where two edges meet are the polygon's vertices (singular: vertex) or corners.
 */

public class Polygon extends TwoDimensionalShape{

    private double perimeter;


    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }


    /**
     * This static method will compute the angle between two intersecting lines using the
     * equation: tangent(theta) = |(m1-m2)/(1+m1m2)|. This method will return zero if the
     * lines are parallel. The coordinates of each line must be set or computed prior to
     * calling this method.
     * @param line1 the first intersecting line
     * @param line2 the second intersecting line
     * @return the computed angle in degrees
     */
    public static double computeAngle(StraightLine line1, StraightLine line2){

        double slope1 = 0;
        double slope2 = 0;
        try {
             slope1 = line1.getSlope();
             slope2 = line2.getSlope();
        } catch (Exception e) { //catches exception if the coordinates are not set in either of the line objects
            System.out.printf("Exception: %s%n", e.getMessage());
        }


        return Math.toDegrees(Math.atan(Math.abs( (slope1 - slope2) / (1 + (slope1 * slope2)))));

    }

}


