import javax.swing.plaf.FontUIResource;

/**
 *
 *
 */
public enum RomanNumeral {

    ONE("I", 1, false, ""),
    FOUR("IV", 4, true, "IIII"),
    FIVE("V", 5, false, ""),
    NINE("IX", 9, true, "VIV"),
    TEN("X", 10, false, "VV"),
    FORTY("XL", 40, true, "XXXX"),
    FIFTY("L", 50, false, ""),
    NINETY("XC", 90, true, "LXL"),
    ONE_HUNDRED("C", 100, false, "LL"),
    FOUR_HUNDRED("CD", 400, true, "CCCC"),
    FIVE_HUNDRED("D", 500, false, ""),
    NINE_HUNDRED("CM", 900, true, "DCD"),
    ONE_THOUSAND("M", 1000, false, "DD");

    private final String numeralInRoman;
    private final int numeralInArabic;
    /**
     * Signifies that the numeral is represented in subtractive notation (ex: IX for 4)
     */
    private final boolean isSubtractive;
    /**
     * The incorrect representation of the roman numeral
     */
    private final String incorrectRepresentation;

    /**
     * Constructor for RomanNumeral enumeration.
     * @param numeralInRoman
     * @param numeralInArabic
     * @param isSubtractive
     */
    RomanNumeral(String numeralInRoman, int numeralInArabic, boolean isSubtractive, String incorrectRepresentation){

        this.numeralInRoman = numeralInRoman;
        this.numeralInArabic = numeralInArabic;
        this.isSubtractive = isSubtractive;
        this.incorrectRepresentation = incorrectRepresentation;
    }


    /**
     * Sees if the string given is a roman numeral in subtractive notation
     * @param romanNumeral
     * @return
     */
    public static boolean isSubtractive(String romanNumeral){

        for(RomanNumeral romanNumeralIter : RomanNumeral.values()){

            //if the given string is a roman numeral in this enum, and the romanNumeral is subtractive
            if(romanNumeralIter.getNumeralInRoman().equals(romanNumeral) && romanNumeralIter.isSubtractive){

                return true;
            }
        }

        return false; //if the numeral is not in subtractive notation
    }

    /**
     * Sees if the first romanNumeral1 is larger than romanNumeral2
     * @param romanNumeral1
     * @param romanNumeral2
     * @return
     */
    public static boolean isLarger(String romanNumeral1, String romanNumeral2){

        for(RomanNumeral romanNumeralIter1 : RomanNumeral.values()){

            //if the first roman numeral iterator is equal to the first roman numeral given
            if(romanNumeralIter1.getNumeralInRoman().equals(romanNumeral1)){

                for(RomanNumeral romanNumeralIter2 : RomanNumeral.values()){

                    //if the second roman numeral iterator is equal to the second roman numeral given
                    if(romanNumeralIter2.getNumeralInRoman().equals(romanNumeral2)){

                        //at this point, both iterators are equal to the respective numerals given. We check if the
                        //value of the first iterator is equal to the second. If so, return true.
                        if(romanNumeralIter1.getNumeralInArabic() > romanNumeralIter2.getNumeralInArabic()){

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Returns the value of the roman numeral as an arabic numeral. Returns -1 if not a roman numeral.
     * @param romanNumeral the roman numeral to get the value of
     * @return the value of the given roman numeral
     */
    public static int getRomanNumeralValue(String romanNumeral){

        for (RomanNumeral romanNumeralIter : RomanNumeral.values()){

            if(romanNumeralIter.getNumeralInRoman().equals(romanNumeral)){

                return romanNumeralIter.getNumeralInArabic();
            }
        }

        return -1;
    }


    /**
     * @return the numeral in Roman notation
     */
    public String getNumeralInRoman() {
        return numeralInRoman;
    }

    /**
     * @return The numeral in Arabic notation
     */
    public int getNumeralInArabic() {
        return numeralInArabic;
    }

    /**
     * @return true if the numeral is in subtractive notation, false if the numeral is not
     */
    public boolean isSubtractive() {
        return isSubtractive;
    }

    public String getIncorrectRepresentation() {
        return incorrectRepresentation;
    }
}
