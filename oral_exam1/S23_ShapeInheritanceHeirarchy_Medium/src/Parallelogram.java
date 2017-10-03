/**
 *In Euclidean geometry, a parallelogram is a simple (non-self-intersecting) quadrilateral with two pairs
 * of parallel sides. The opposite or facing sides of a parallelogram are of equal length and the opposite angles of
 * a parallelogram are of equal measure.
 *
 */
public class Parallelogram extends SimpleQuadrilateral{


    public Parallelogram(double baseLength, double sideLength, double angleAandC) throws Exception {

        super(baseLength, sideLength, sideLength, angleAandC, (180 - angleAandC));

    }

    //@Override
    //public double getArea(){
    //}

    public void computeParallelogramArea(){

        double height;
    }




}
