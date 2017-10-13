/**
 *
 *
 *
 */

public class NumeralConverter {

    /**
     * Converts an arabic numeral to a roman numeral
     * @param arabicNumeral the numeral in arabic form
     * @return a string containing the corresponding roman numeral
     */
    public static String arabicToRoman(int arabicNumeral){

        final RomanNumeral romanNumerals[] = RomanNumeral.values();
        String convertedRomanNumeral = "";
        //start at highest roman numeral value and go down by each numeral one by one
        for(int currentNumeralIndex = (romanNumerals.length - 1); currentNumeralIndex >= 0; currentNumeralIndex--){

            //while the arabic numeral given is larger then the current roman numeral value
            while(arabicNumeral >= romanNumerals[currentNumeralIndex].getNumeralInArabic()){

                //add the current roman numeral to the end of the string containing the converted numeral
                convertedRomanNumeral = convertedRomanNumeral + romanNumerals[currentNumeralIndex].getNumeralInRoman();
                //subtract the value of the current roman numeral from the given arabic numeral
                arabicNumeral = arabicNumeral - romanNumerals[currentNumeralIndex].getNumeralInArabic();
            }
        }

        return convertedRomanNumeral;
    }

    /**
     *
     * @param romanNumeral a correct and valid modern roman numeral
     * @return
     */
    public static int romanToArabic(String romanNumeral){

        final char romanNumeralArray[] = romanNumeral.toCharArray();
        int convertedArabicNumeral = 0; //always starts at zero, will be added to with each iteration later

        for(int romanNumeralIter = (romanNumeralArray.length - 1); romanNumeralIter > 0; romanNumeralIter-- ){

            String thisAndNextRomanLetter = "" + romanNumeralArray[romanNumeralIter] + romanNumeralArray[romanNumeralIter - 1];

            System.out.println(convertedArabicNumeral);

            if(RomanNumeral.isSubtractive(thisAndNextRomanLetter)){

                convertedArabicNumeral = convertedArabicNumeral + RomanNumeral.getRomanNumeralValue(thisAndNextRomanLetter);
                romanNumeralIter--; //skip over the second letter of the subtractive numeral
            }
            else{
                convertedArabicNumeral = convertedArabicNumeral +
                        RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[romanNumeralIter]);
            }
        }

        convertedArabicNumeral = convertedArabicNumeral + RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[0]);

        return convertedArabicNumeral;
    }

    /*
    public static String validateRomanNumeral(String romanNumeral){


    }
    */
}
