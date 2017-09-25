/**
 * Created by teagenkiel on 9/8/17.
 */

import java.util.Scanner;

public class EasterCalculatorTest {

    public static void main(String[] args){


        Scanner myScanner = new Scanner(System.in);

        boolean yearFlag = true;
        boolean cycleCreationFlag = true;
        int scannedInteger = 0;

        System.out.println("Welcome to the Easter calculation program");

        while(scannedInteger != 3) {
            System.out.println("1. Get an Easter date \n " +
                    "2. Show number of Easter dates per cycle of 5,700,000 years \n " +
                    "3. Exit program " +
                    "\n Please enter an integer");

            scannedInteger = myScanner.nextInt();

            switch (scannedInteger) {


                case (1):
                    while (yearFlag) {
                        try {
                            System.out.println("Please enter a year");
                            int yearForEaster = myScanner.nextInt();
                            EasterCalculator myEasterCalculator = new EasterCalculator(yearForEaster);
                            System.out.println(myEasterCalculator); //invokes the toString method
                            yearFlag = false;


                        } catch (Exception yearException) {
                            System.out.printf("Exception: %s%n", yearException.getMessage());
                        }
                    }
                    break;

                case (2):


                    EasterCalculator calculatorForCycle = new EasterCalculator(0);
                    cycleCreationFlag = false;
                    EasterCycleCounter myCycleCounter = new EasterCycleCounter(calculatorForCycle);
                    myCycleCounter.printEasterCount();
                    break;

                default:
                    System.out.println("Wrong value. See menu above for valid entries.");
            }
        }
    }
}
