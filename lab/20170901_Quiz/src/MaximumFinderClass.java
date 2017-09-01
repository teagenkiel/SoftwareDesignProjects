/**
 * Created by teagenkiel on 9/1/17.
 */
public class MaximumFinderClass {

    public static double maximum(double x, double y, double z) {
        double maximumValue = x; // assume x is the largest to start

        // determine whether y is greater than maximumValue
        if (y > maximumValue)
            maximumValue = y;

        // determine whether z is greater than maximumValue
        if (z > maximumValue)
            maximumValue = z;

        return maximumValue;
    }

}
