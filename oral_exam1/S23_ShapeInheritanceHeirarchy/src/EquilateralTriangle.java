/**
 *
 */
public class EquilateralTriangle extends Triangle {


    /**
     * Main constructor to create EquilateralTriangle object. Since all sides have the same length,
     *
     * @param side
     */
    EquilateralTriangle(StraightLine side){

        super(side, side, side);
    }

    EquilateralTriangle(double sideLength){

        super(sideLength, sideLength, sideLength);
    }
}
