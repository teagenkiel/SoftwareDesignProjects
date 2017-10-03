/**
 * The purpose of this class is to test both the EasterCalculator and EasterCycleCounter classes. The main will print
 * a menu to which the user will respond to which action will be taken. It will either be to calculate the date
 * of Easter for the year of the user's choice using EasterCalculator, or to print the amount of times Easter occurs
 * on each date over a cycle using EasterCycleCounter.
 *
 * @author Teagen Kiel
 * @since 2017-09-25
 * @see EasterCalculator
 * @see EasterCycleCounter
 */

import java.util.Scanner;

public class EasterCalculatorTest {

    public static void main(String[] args){


        Scanner myScanner = new Scanner(System.in);

        boolean yearFlag = true;
        boolean cycleCreationFlag = false;
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
                            myEasterCalculator.computus();
                            System.out.println(myEasterCalculator); //invokes the toString method
                            yearFlag = false;


                        } catch (Exception yearException) { //catches exception if year is not valid
                            System.out.printf("Exception: %s%n", yearException.getMessage());
                        }
                    }
                    break;

                case (2):

                    EasterCycleCounter.printEasterCount();
                    break;

                default:
                    System.out.println("Wrong value. See menu above for valid entries.");
            }
        }
    }
}
