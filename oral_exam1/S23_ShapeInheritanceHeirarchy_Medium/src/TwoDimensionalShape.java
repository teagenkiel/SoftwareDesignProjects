/**
 *
 *
 *
 *
 */
public class TwoDimensionalShape extends Shape {

    private double area;

    TwoDimensionalShape(double area) {

        this.area = area;
    }

    public void setNewMeasurements(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }


}
