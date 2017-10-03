/**
 * This enumeration defines each month in the Gregorian calendar. It gives info about each month including but not
 * limited to, month name, month number, month abbreviation, and how many days are in the month.
 *
 * @author Teagen Kiel
 * @since 2017-09-25
 */
public enum Calendar {

    JANUARY("January", 1, "Jan.", 31),
    FEBRUARY("February", 2, "Feb.", 28),
    MARCH("March", 3, "Mar.", 31),
    APRIL("April", 4, "Apr.", 30),
    MAY("May", 5, "May", 31),
    JUNE("June", 6, "Jun.", 30),
    JULY("July", 7, "Jul.", 31),
    AUGUST("August", 8, "Aug.", 31),
    SEPTEMBER("September", 9, "Sept.", 30),
    OCTOBER("October", 10, "Oct.", 31),
    NOVEMBER("November", 11, "Nov.", 30),
    DECEMBER("December", 12, "Dec.", 31);

    private final String monthName;
    private final int monthNumber;
    private final String monthAbbreviation;
    private final int daysInMonth; //how many days are in the month


    /**
     * The main constructor for the enum.
     * @param monthName name of the month
     * @param monthNumber number of the month
     * @param monthAbbreviation abbreviation of the month
     * @param daysInMonth number of days in the month
     */
    Calendar(String monthName, int monthNumber, String monthAbbreviation, int daysInMonth){

        this.monthName = monthName;
        this.monthNumber = monthNumber;
        this.monthAbbreviation = monthAbbreviation;
        this.daysInMonth = daysInMonth;

    }


    /**
     * This method returns the month name if the given month number and month number int the enum match.
     * @param monthNumber user gives the month number
     * @return monthName enum returns the month name as a String
     * @throws IllegalArgumentException if the month number is not in the enum (invalid month num)
     */
    public static String getMonthName(double monthNumber){

        for( Calendar myCalendar : Calendar.values()){

            if(monthNumber == myCalendar.getMonthNumber()){

                return myCalendar.getMonthName();
            }

        }

        throw new IllegalArgumentException("Month number was outside of desired range");

    }

    /**
     * @return the month name
     */
    public String getMonthName() {
        return monthName;
    }

    /**
     * @return the month number
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     * @return the month abbreviation
     */
    public String getMonthAbbreviation() {
        return monthAbbreviation;
    }

    /**
     * @return the number of days in the month
     */
    public int getDaysInMonth() {
        return daysInMonth;
    }
}
