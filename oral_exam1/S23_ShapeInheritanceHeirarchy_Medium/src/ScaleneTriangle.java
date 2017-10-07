/**
 *This class will create an object that represents a scalene triangle. Every scalene triangle has three sides with
 * all having a different length.
 *
 * @author Teagen Kiel
 */

public class ScaleneTriangle extends Triangle{


    /**
     * Main constructor for class ScaleneTriangle. This constructor is essentially the same as the Triangle constructor,
     * but with an extra level of validation to make sure each side length is a different value.
     * @param baseLength length of the base
     * @param side1Length length of side 1
     * @param side2Length length of side 2
     * @throws Exception if a valid triangle cannot be made, or there are two side lengths that match.
     */
    public ScaleneTriangle(double baseLength, double side1Length, double side2Length) throws Exception {

        super(baseLength, side1Length, side2Length);

        validateLengthDifference(baseLength, side1Length, side2Length);

    }

    /**
     * This extra level of validation checks to make sure all lengths are different values.
     * @param length1 first side length
     * @param length2 second side length
     * @param length3 third side length
     * @throws Exception if there are two lengths that match
     */
    private static void validateLengthDifference(double length1, double length2, double length3) throws Exception{

        if((length1 == length2) || (length1 == length3) || (length2 == length3)){

            throw new IllegalArgumentException("Triangle is not scalene. All side lengths must be different");
        }
    }
}
