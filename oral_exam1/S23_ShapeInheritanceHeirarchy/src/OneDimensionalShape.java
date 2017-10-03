/**
 * This class will create a one-dimensional object. Characteristics of every 1D object includes
 * two points (defined by coordinates) that are connected.
 *
 */
public class OneDimensionalShape extends Shape {

    private double length; //every 1D shape has a length, but different ways to compute it
    private double coordinatePair1[];
    private double coordinatePair2[];

    /**
     *
     * @param x1 x-component for coordinate 1
     * @param y1
     * @param x2
     * @param y2
     */
    public OneDimensionalShape(double x1, double y1, double x2, double y2){

        coordinatePair1 = new double[]{x1, y1};
        coordinatePair2 = new double[]{x2, y2};

    }

    public OneDimensionalShape(double length){
        this.length = length;
    }

    public void setNewCoordinates(double x1, double y1, double x2, double y2) {

        coordinatePair1 = new double[]{x1, y1};
        coordinatePair2 = new double[]{x2, y2};
    }

    public double[] getCoordinatePair1() {
        return coordinatePair1;
    }

    public double[] getCoordinatePair2() {
        return coordinatePair2;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}

