/**
 *The only stipulation for simple quadrilaterals is that they cannot self-intersect,
 * therefor lines AC and BD cannot intersect.
 *
 */
public class SimpleQuadrilateral extends Quadrilateral {


    public SimpleQuadrilateral(double baseABLength, double sideACLength, double sideBDLength, double angleA,
                               double angleB) throws Exception {
        super(baseABLength, sideACLength, sideBDLength, angleA, angleB);


        validateSimpleQuadrilateral(baseABLength, sideACLength, sideBDLength, angleA, angleB);

    }

    private static void validateSimpleQuadrilateral(double baseABLength, double sideACLength, double sideBDLength,
                                                     double angleA, double angleB){

        double Cx = sideACLength * Math.cos(Math.toRadians(angleA)); //x-coordinate of point C
        double Dx = baseABLength + (sideBDLength * Math.cos(Math.toRadians(180 - angleB))); //x-coordinate of point D

        //the x-coordinate of point C must be bigger than the x-component of point D for it to be a complex quadrilateral
        if(Cx >= Dx){
            throw new IllegalArgumentException("Invalid simple quadrilateral. Sides AC and BD cannot intersect.");

        }
    }

}
