/**
 * This class will create an object that represents an equilateral triangle. All equilateral triangles
 * have three sides of equal length and three angles of equal magnitude.
 *
 * @author Teagen Kiel
 */
public class EquilateralTriangle extends Triangle {

    /**
     * Main constructor to create EquilateralTriangle object. Since all sides have the same length, the
     * super constructor is called with three of the same side length.
     *
     * @param sideLength the length of all three sides desired
     * @throws Exception if a valid triangle cannot be made (impossible in this case b/c all sides are equal)
     */
    EquilateralTriangle(double sideLength) throws Exception {

        super(sideLength, sideLength, sideLength);
    }
}
