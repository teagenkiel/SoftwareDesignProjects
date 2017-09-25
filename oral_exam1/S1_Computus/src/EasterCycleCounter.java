/**
 * Created by teagenkiel on 9/12/17.
 */
public class EasterCycleCounter {


    private final int monthIndexMax = 2;
    private final int dayIndexMax = 31;
    private final int monthIndexOffset = 3;
    private final int dayIndexOffset = 1;

    private int[][] dateCounterArray = new int[monthIndexMax][dayIndexMax];
    private EasterCalculator calculatorForCycle;

    public EasterCycleCounter(EasterCalculator calculatorForCycle){

        this.calculatorForCycle = calculatorForCycle;

        this.countEasters();

    }

    private void countEasters() {

        final int easterCycleMax = 5700000;
        final int easterCycleMin = 0;

        System.out.println("Calculating...");

        for (int yearCounter = easterCycleMin; yearCounter < easterCycleMax; yearCounter++) {

            this.calculatorForCycle.setYear(yearCounter);
            dateCounterArray[(this.calculatorForCycle.getMonthAsInteger()) - monthIndexOffset]
                    [(this.calculatorForCycle.getDay()) - dayIndexOffset]++;

        }
    }

    public void printEasterCount(){

        final int indexMin = 0;
        final int emptyArrayValue = 0;

        for (int monthIndexCounter = indexMin; monthIndexCounter < monthIndexMax; monthIndexCounter++) {

            for (int dayIndexCounter = indexMin; dayIndexCounter < dayIndexMax; dayIndexCounter++){

                if(dateCounterArray[monthIndexCounter][dayIndexCounter] != emptyArrayValue){

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
