/**
 *
 * In Euclidean plane geometry, a rectangle is a quadrilateral with four right angles.
 *
 * @author Teagen Kiel
 */
public class Rectangle extends Parallelogram{

    private static final int RIGHT_ANGLE_DEGREES = 90;

    public Rectangle(double baseLength, double sideLength) throws Exception {

        super(baseLength, sideLength, RIGHT_ANGLE_DEGREES);
    }
}
