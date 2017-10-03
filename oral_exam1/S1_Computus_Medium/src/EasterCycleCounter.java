/**
 * This class will be used to calculate and print the number of times Easter falls on each date
 * over a 5,700,000 year period. The class does not need to be constructed to be able to do this, because the count and
 * print methods are static functions. They are static because we can compute and print the cycle without creating an
 * object, and will be the same for all instances of the class if we decide to create objects of it for analyzing
 * purposes. This class uses composition and "has-a" object of the EasterCalculator class to compute the dates for
 * every year in the cycle.
 *
 *
 * @author Teagen Kiel
 * @since 2017-09-25
 * @see EasterCalculator
 * @see Calendar
 */

import java.util.Arrays;
public class EasterCycleCounter {


    private static final int monthIndexMax = 2; //array will have 2 rows, since easter only occurs in two months(march and april)
    private static final int dayIndexMax = 31; //array has a column for every possible day in each of the two months
    private static final int monthIndexOffset = 3; //offset to convert array index to month number
    private static final int dayIndexOffset = 1; //offset to convert array index to day number

    /* array to hold a value for each day of each month. The array is initialized in the countEasters() method.*/
    private static final int[][] dateCounterArray = new int[monthIndexMax][dayIndexMax];
    /* This array is a purposefully empty array to be used to compare and check to see if the dateCounterArray is empty
     * i.e. to check if the "countEasters()" method has or has not been called yet. */
    private static final int[][] emptyComparatorArray = new int[monthIndexMax][dayIndexMax];


    /**
     * Main constructor for this class. If non static instance variables or methods are added to this class for the
     * purpose of analyzing this data, they should be initialized here. The countEasters method is added here to
     * make sure the cycle is computed before analyzing the data.
     */
    public EasterCycleCounter(){
        EasterCycleCounter.countEasters();
    }

    /**
     * This method will count the amount of times Easter falls on each date over a 5,700,000 year period.
     * For each year from 0 to 5,700,000, it will use the EasterCalculator given to
     * compute the easter date and increment the value held in the array that is associated with that date.
     * This method only needs to be executed once after the object is created, so it is called only in the constructor.
     * This method is not static because we need to have a built object with a stored cycle count in order for the
     * printEasterCycles function to work.
     */
    private static void countEasters() {

        final int easterCycleMax = 5700000;
        final int easterCycleMin = 0;
        EasterCalculator calculatorForCycle = new EasterCalculator(0); //easter calculator used to calculate dates

        System.out.println("Please wait: calculating cycle of Easters...");

        for (int yearCounter = easterCycleMin; yearCounter < easterCycleMax; yearCounter++) {

            calculatorForCycle.setYear(yearCounter);
            dateCounterArray[(calculatorForCycle.getMonthAsInteger()) - monthIndexOffset]
                    [(calculatorForCycle.getDay()) - dayIndexOffset]++;

        }

    }

    /**
     * This class iterates through the dateCounter array and if the value held in the array is not zero(i.e. Easter
     * does not and cannot occur on that date) then it will display the date and the amount of times that it occurs
     * in the 5,700,000 year cycle. If the dateCounterArray has not been initialized yet, the countEaster method will
     * be called.
     */
    public static void printEasterCount(){

        /* This statement checks to see if the dateCounterArray has been initialized or not. If it hasn't (i.e.
        * countEasters() has not been called yet) call the method to initialize it. (Thanks Stack Overflow!)*/
        if(Arrays.deepEquals(dateCounterArray, emptyComparatorArray)) {
            EasterCycleCounter.countEasters();
        }

        final int indexMin = 0;  //The minimum value of the index of the dateCounter array
        final int emptyArrayValue = 0; //to compare with the array to see if the value it holds is zero

        for (int monthIndexCounter = indexMin; monthIndexCounter < monthIndexMax; monthIndexCounter++) {

            for (int dayIndexCounter = indexMin; dayIndexCounter < dayIndexMax; dayIndexCounter++){

                if(dateCounterArray[monthIndexCounter][dayIndexCounter] != emptyArrayValue){ //if the value held isn't empty

                    System.out.println(
                            Calendar.getMonthName(monthIndexCounter + monthIndexOffset) + " " +
                                    (dayIndexCounter + dayIndexOffset) + ": " +
                                    dateCounterArray[monthIndexCounter][dayIndexCounter]

                    );

                }

            }
        }
    }

}
