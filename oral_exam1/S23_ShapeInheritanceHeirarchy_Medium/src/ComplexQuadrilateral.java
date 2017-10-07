/**
 *A self-intersecting quadrilateral is called variously a cross-quadrilateral, crossed quadrilateral,
 * butterfly quadrilateral or bow-tie quadrilateral. In a crossed quadrilateral, the four "interior" angles on either
 * side of the crossing (two acute and two reflex, all on the left or all on the right as the figure is traced out) add
 * up to 720°.
 *
 * Create other constructor for radians/degrees? Radians should be default, makes code easier to read
 *
 */
public class ComplexQuadrilateral extends Quadrilateral{

    public static final int INTERIOR_ANGLE_SUM_DEGREES = 720;

    /**
     * Adds another layer of validation
     * @param baseABLength
     * @param sideACLength
     * @param sideBDLength
     * @param angleA
     * @param angleB
     * @throws Exception
     */
    public ComplexQuadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA,
                                double angleB) throws Exception {

        super(baseABLength, sideACLength, sideBDLength, angleA, angleB);

        validateComplexQuadrilateral(baseABLength, sideACLength, sideBDLength, angleA, angleB);
    }

    private static void validateComplexQuadrilateral(double baseABLength, double sideACLength, double sideBDLength,
                                                     double angleA, double angleB){

        Vertex vertexC = computeVertexC(angleA, sideACLength);
        Vertex vertexD = computeVertexD(angleB, baseABLength, sideBDLength);

        //the x-coordinate of point C must be bigger than the x-component of point D for it to be a complex quadrilateral
        if(vertexC.getX() <= vertexD.getX()){
            throw new IllegalArgumentException("Invalid complex quadrilateral. Sides AC and BD must intersect.");
        }
    }
}
