/**
 *In Euclidean geometry, a parallelogram is a simple (non-self-intersecting) quadrilateral with two pairs
 * of parallel sides. The opposite or facing sides of a parallelogram are of equal length and the opposite angles of
 * a parallelogram are of equal measure.
 *
 */
public class Parallelogram extends SimpleQuadrilateral{



    public Parallelogram(double baseLength, double sideLength, double angleAandC) throws Exception {

        super(baseLength, sideLength, sideLength, angleAandC, computeAdjacentAngle(angleAandC));

    }

    private static double computeAdjacentAngle(double interiorAngle){

        final int angleSum = 180; //sum of both of the angles is always 180

        return angleSum - interiorAngle;
    }




}
