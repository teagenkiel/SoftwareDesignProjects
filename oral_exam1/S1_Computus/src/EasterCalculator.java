/**
 * Created by teagenkiel on 9/8/17.
 *
 * The purpose of this class is to calculate the date of easter using the Meeus/Jones/Butcher algorithm.
 * When an object of this class is created, a year must be specified, and then the date of easter will be computed
 *  and stored automatically. To print off the date, just use the toString method which is specified.
 *
 * @author Teagen Kiel
 * @version 1.0
 * @since 2017-09-25
 * @see Calendar
 * @see EasterCalculatorTest
 * @see EasterCycleCounter
 */

public class EasterCalculator {

    //instance variables of class EasterCalculator

    private int year;
    private int monthAsInteger;
    private String monthAsString;
    private int day;


    /**
     * This default constructor invokes the main constructor just in case the user doesn't specify
     * a year. It initializes the instance variable "year" to zero.
     */
    public EasterCalculator(){

        this(0);

    }

    /**
     * This is the main constructor for class EasterCalculator. It validates the year given(makes sure it's not less
     * than zero) and if it is a valid year, then it sets the instance variable year to the year given.
     * @param year year to calculate the easter date of
     */
    public EasterCalculator(int year){

        validateYear(year);
        this.year = year;
        this.computus();

    }

    //setters and getters

    /**
     * Validates the year, sets the year to the specified value, and then computes the easter date.
     * @param year year to calculate the easter date of
     */
    public void setYear(int year) {

        validateYear(year);
        this.year = year;
        this.computus();
    }

    /**
     * getter for monthAsInteger
     * @return monthAsInteger the calculated Easter month as an integer
     */
    public int getMonthAsInteger() {
        return monthAsInteger;
    }

    /**
     * getter for monthAsString
     * @return monthAsString the calculated Easter month as a String
     */
    public String getMonthAsString() {
        return monthAsString;
    }

    /**
     * getter for day
     * @return day, the calculated Easter day as an integer
     */
    public int getDay() {
        return day;
    }

    /**
     * getter for year
     * @return the year to compute Easter for
     */
    public int getYear() { return year; }

    /**
     * toString method for class EasterCalculator. Use this method if you want to print the calculated easter date.
     * @return "The date of Easter is <month> <day>, <year>"
     */
    @Override
    public String toString() {
        return "The date of Easter is: " +
                monthAsString + " " +
                day + ", " +
                year;
    }

    /**
     * This method will validate a year to make sure that it is not negative. This class will not deal with
     * negative years. It is static that
     * @param yearToCheck
     * @throws IllegalArgumentException if the year is less than zero
     */
    private static void validateYear(int yearToCheck){

        if(yearToCheck < 0 ){

            throw new IllegalArgumentException("Invalid year. Must be greater than or equal to zero.");
        }
    }


    /**
     * This method will complete the computus algorithm by calling the calculateMonth and calculateDay
     * functions and storing the value they compute in the monthAsInteger and day instance variables.
     * Then uses the Calendar enumeration to convert the month from an integer to a string.
     * @throws Exception if the month value is bigger than 12
     */
    private void computus() {

        this.monthAsInteger = (int)this.calculateMonth();
        this.day = (int)calculateDay();

        try {
            this.monthAsString = Calendar.getMonthName(this.monthAsInteger);
        }
        catch (Exception monthOutOfRange){
            System.out.printf("Exception: %s%n", monthOutOfRange.getMessage());
        } //catches exception if month# is not b/t 1 and 12



    }


    /**
     * @return a, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateA(){

        final int aConstant1 = 19;

        return this.year % aConstant1; //% is the modulo operator
    }

    /**
     * @return b, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateB() {

        final int bConstant1 = 100;

        return Math.floor(this.year/bConstant1);
    }

    /**
     * @return c, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateC() {

        final int cConstant1 = 100;

        return this.year % cConstant1;

    }

    /**
     * @return d, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateD() {

        final int dConstant1 = 4;

        return Math.floor(this.calculateB()/dConstant1);

    }

    /**
     * @return e, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateE() {

        final int eConstant1 = 4;

        return this.calculateB() % eConstant1;

    }

    /**
     * @return f, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateF() {

        final int fConstant1 = 8;
        final int fConstant2 = 25;

        return Math.floor( (this.calculateB() + fConstant1) / fConstant2);
    }

    /**
     * @return g, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateG() {

        final int gConstant1 = 1;
        final int gConstant2 = 3;

        return Math.floor((this.calculateB() - this.calculateF() + gConstant1) / gConstant2);
    }

    /**
     * @return h, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateH() {

        final int hConstant1 = 19;
        final int hConstant2 = 15;
        final int hConstant3 = 30;

        return ((hConstant1 * this.calculateA()) + this.calculateB() - this.calculateD() -
        this.calculateG() + hConstant2) % hConstant3;

    }

    /**
     * @return i, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateI() {

        final int iConstant1 = 4;

        return Math.floor(this.calculateC() / iConstant1);
    }

    /**
     * @return k, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateK() {

        final int kConstant1 = 4;

        return this.calculateC() % kConstant1;
    }

    /**
     * @return l, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateL() {

        final int lConstant1 = 32;
        final int lConstant2 = 2;
        final int lConstant3 = 7;

        return (lConstant1 + (lConstant2 * this.calculateE()) + (lConstant2 * this.calculateI())
        - this.calculateH() - this.calculateK()) % lConstant3;
    }

    /**
     * @return m, a constant for use in the Meeus/Jones/Butcher algorithm for computus.
     */
    private double calculateM() {

        final int mConstant1 = 11;
        final int mConstant2 = 22;
        final int mConstant3 = 451;

        return Math.floor((this.calculateA() + (mConstant1 * this.calculateH()) +
                (mConstant2 * this.calculateL())) / mConstant3);
    }

    /**
     * Uses the letter constants to compute the month of easter.
     * @return month, an integer that represents the month number.
     */
    private double calculateMonth() {

        final int monthConstant1 = 7;
        final int monthConstant2 = 114;
        final int monthConstant3 = 31;

        return Math.floor((this.calculateH() + this.calculateL() - (monthConstant1 * this.calculateM())
        + monthConstant2) / monthConstant3);
    }

    /**
     * Uses the letter constants to compute the day of Easter.
     * @return day, an integer that represents which day of the month Easter falls on.
     */
    private double calculateDay() {

        final int dayConstant1 = 7;
        final int dayConstant2 = 114;
        final int dayConstant3 = 31;
        final int dayConstant4 = 1;

        return ((this.calculateH() + this.calculateL() - (dayConstant1 * this.calculateM())
        + dayConstant2) % dayConstant3) + dayConstant4;
    }
}
