/**
 *
 *
 */
public class IsoscelesTriangle extends Triangle{


    /**
     * Main constructor for class IsoscelesTriangle. In an Isosceles triangle there is one base with two sides of
     * equal length, this constructor calls the constructor of Triangle appropriately.
     * @param baseLength the length of the base of the Triangle
     * @param sideLength the length of both equal sides.
     * @throws Exception if a valid triangle cannot be made (i.e. the base length is larger than the sum of both side
     * lengths)
     */
    public IsoscelesTriangle(double baseLength, double sideLength) throws Exception {

            super(baseLength, sideLength, sideLength);

    }


}
