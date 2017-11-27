/**
 * This class is the main logic class for the numeral conversion application. It's main goal is to use methods to
 * take a numeral of one type and convert it to another. It will also contain methods which will support these main
 * conversion methods, for example validation.
 *
 * @author teagen kiel
 *
 */

public class NumeralConverter {

    /**
     * Converts an arabic numeral to a roman numeral
     *
     * @param arabicNumeral the numeral in arabic form
     * @return a string containing the corresponding roman numeral
     */
    public static String arabicToRoman(int arabicNumeral) {

        final RomanNumeral romanNumerals[] = RomanNumeral.values();
        String convertedRomanNumeral = "";
        //start at highest roman numeral value and go down by each numeral one by one
        for (int currentNumeralIndex = (romanNumerals.length - 1); currentNumeralIndex >= 0; currentNumeralIndex--) {

            //while the arabic numeral given is larger then the current roman numeral value
            while (arabicNumeral >= romanNumerals[currentNumeralIndex].getNumeralInArabic()) {

                //add the current roman numeral to the end of the string containing the converted numeral
                convertedRomanNumeral = convertedRomanNumeral + romanNumerals[currentNumeralIndex].getNumeralInRoman();
                //subtract the value of the current roman numeral from the given arabic numeral
                arabicNumeral = arabicNumeral - romanNumerals[currentNumeralIndex].getNumeralInArabic();
            }
        }

        return convertedRomanNumeral;
    }

    /**
     * Converts a roman numeral given as a string to its corresponding arabic representation
     *
     * @param romanNumeral a combination in any order of roman numerals as a string
     * @return
     */
    public static int romanToArabic(String romanNumeral) {

        final char romanNumeralArray[] = romanNumeral.toCharArray();
        final int lastPossibleIndex = romanNumeralArray.length - 1;
        int convertedArabicNumeral = 0; //always starts at zero, will be added to with each iteration later

        for (int currentIndex = 0; currentIndex < romanNumeralArray.length; currentIndex++) {

            int nextIndex = currentIndex + 1;

            if (currentIndex != lastPossibleIndex) {
                //string representing the current and next numeral together
                String thisAndNextRomanLetter = "" + romanNumeralArray[currentIndex] + romanNumeralArray[nextIndex];

                if (RomanNumeral.isSubtractive(thisAndNextRomanLetter)) {

                    convertedArabicNumeral = convertedArabicNumeral +
                            RomanNumeral.getRomanNumeralValue(thisAndNextRomanLetter);
                    currentIndex++; //skip over the second letter of the subtractive numeral
                } else {
                    convertedArabicNumeral = convertedArabicNumeral +
                            RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[currentIndex]);
                }
            } else { //currentIndex == lastPossibleIndex, only one letter left, subtractive not possible here

                convertedArabicNumeral = convertedArabicNumeral +
                        RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[currentIndex]);
            }
        }


        return convertedArabicNumeral;
    }


    /**
     * Since the romanToArabic conversion takes in a combination of roman numerals in any order and computes the arabic
     * number by adding up the numerals, and the arabic to roman conversion takes in an arabic numeral and outputs a
     * correct and valid modern roman numeral, we can combine the two methods to validate a roman numeral.
     * @param romanNumeral the roman numeral to be validated
     * @return a validly ordered roman numeral that corresponds with the roman numeral entered
     */
    public static String validateRomanNumeral(String romanNumeral) {

        return arabicToRoman(romanToArabic(romanNumeral));

    }

}
