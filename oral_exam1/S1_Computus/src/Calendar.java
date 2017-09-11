/**
 * Created by teagenkiel on 9/11/17.
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
    private final int daysInMonth;

    Calendar(String monthName, int monthNumber, String monthAbbreviation, int daysInMonth){

        this.monthName = monthName;
        this.monthNumber = monthNumber;
        this.monthAbbreviation = monthAbbreviation;
        this.daysInMonth = daysInMonth;

    }

    public static String getMonthName(double monthNumber){

        for( Calendar myCalendar : Calendar.values()){

            if(monthNumber == myCalendar.getMonthNumber()){

                return myCalendar.getMonthName();
            }

        }

        throw new IllegalArgumentException("Month number was outside of desired range");

    }

    public String getMonthName() {
        return monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthAbbreviation() {
        return monthAbbreviation;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }
}
