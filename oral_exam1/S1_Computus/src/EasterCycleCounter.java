/**
 * This class will be used to calculate and print the number of times Easter falls on each date
 * over a 5,700,000 year period. It calculates and stores this upon construction so that the time-consuming
 * calculation only needs to computed once and can be printed multiple times without recomputing. This class uses
 * composition and "has-a" object of the EasterCalculator class to compute the dates for every year in the cycle.
 * Note: Upon construction, the object will calculate and store the cycle count, because it only needs to executed
 * once per object, therefore it is best to create your object at the beginning of your program(or before any loops)
 * so that you only need to do the lengthy computation once.
 *
 * @author Teagen Kiel
 * @since 2017-09-25
 * @see EasterCalculator
 * @see Calendar
 */
public class EasterCycleCounter {


    private final int monthIndexMax = 2; //array will have 2 rows, since easter only occurs in two months(march and april)
    private final int dayIndexMax = 31; //array has a column for every possible day in each of the two months
    private final int monthIndexOffset = 3; //offset to convert array index to month number
    private final int dayIndexOffset = 1; //offset to convert array index to day number

    private final int[][] dateCounterArray = new int[monthIndexMax][dayIndexMax]; //array to hold a value for each day of each month
    private EasterCalculator calculatorForCycle;  //instance variable which holds the EasterCalculator given by user


    /**
     * Main constructor for this class. Calls the "countEasters" method so that we only have to compute and store the
     * amount of easters per date once.
     */
    public EasterCycleCounter(){

        this.countEasters();

    }

    /**
     * This method will count the amount of times Easter falls on each date over a 5,700,000 year period.
     * For each year from 0 to 5,700,000, it will use the EasterCalculator given to
     * compute the easter date and increment the value held in the array that is associated with that date.
     * This method only needs to be executed once after the object is created, so it is called only in the constructor.
     * This method is not static because we need to have a built object with a stored cycle count in order for the
     * printEasterCycles function to work.
     */
    private void countEasters() {

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
     * in the 5,700,000 year cycle.
     */
    public void printEasterCount(){

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
