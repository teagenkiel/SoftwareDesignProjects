/**
 *This class will create a simple quadrilateral. A simple quadrilateral has no crossing sides (i.e there are no
 * intersections)
 *
 * @Teagen Kiel
 */
public class SimpleQuadrilateral extends Quadrilateral {

    public static final int INTERIOR_ANGLE_SUM_DEGREES = 360;


    public SimpleQuadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA,
                               double angleB) throws Exception {
        super(baseABLength, sideACLength, sideBDLength, angleA, angleB);


        validateSimpleQuadrilateral(baseABLength, sideACLength, sideBDLength, angleA, angleB);

    }

    private static void validateSimpleQuadrilateral(double baseABLength, double sideACLength, double sideBDLength,
                                                     double angleA, double angleB){

        Vertex vertexC = computeVertexC(angleA, sideACLength);
        Vertex vertexD = computeVertexD(angleB, baseABLength, sideBDLength);

        //the x-coordinate of point C must be bigger than the x-component of point D for it to be a complex quadrilateral
        if(vertexC.getX() >= vertexD.getX()){
            throw new IllegalArgumentException("Invalid simple quadrilateral. Sides AC and BD cannot intersect.");

        }
    }

}
