import java.util.concurrent.ThreadLocalRandom;

/**
 *
 *
 *
 *
 */
public class ThreeDimensionalShape extends Shape{

    private double surfaceArea;
    private double volume;

    public ThreeDimensionalShape(double surfaceArea, double volume){

        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setNewMeasurements(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }



}
