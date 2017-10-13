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
     * Converts a roman numeral given as a string to its corresponding arabic representation
     * @param romanNumeral a correct and valid modern roman numeral
     * @return
     */
    public static int romanToArabic(String romanNumeral){

        final char romanNumeralArray[] = romanNumeral.toCharArray();
        final int lastPossibleIndex = romanNumeralArray.length - 1;
        int convertedArabicNumeral = 0; //always starts at zero, will be added to with each iteration later

        for(int currentIndex = 0; currentIndex < romanNumeralArray.length; currentIndex++){

            int nextIndex = currentIndex + 1;

            if(currentIndex != lastPossibleIndex) {
                //string representing the current and next numeral together
                String thisAndNextRomanLetter = "" + romanNumeralArray[currentIndex] + romanNumeralArray[nextIndex];

                if (RomanNumeral.isSubtractive(thisAndNextRomanLetter)) {

                    convertedArabicNumeral = convertedArabicNumeral +
                            RomanNumeral.getRomanNumeralValue(thisAndNextRomanLetter);
                    currentIndex++; //skip over the second letter of the subtractive numeral
                }
                else {
                    convertedArabicNumeral = convertedArabicNumeral +
                            RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[currentIndex]);
                }
            }
            else{ //currentIndex == lastPossibleIndex, only one letter left, subtractive not possible here

                convertedArabicNumeral = convertedArabicNumeral +
                        RomanNumeral.getRomanNumeralValue("" + romanNumeralArray[currentIndex]);
            }
        }


        return convertedArabicNumeral;
    }



    public static String validateRomanNumeral(String romanNumeral){

        char romanNumeralArray[] = romanNumeral.toCharArray();
        String validatedNumerals[] = new String[romanNumeralArray.length]; //max possible length of the array is length of given string
        int lastPossibleIndex = romanNumeralArray.length -1;

        if (romanNumeralArray.length >= 2){

            String thisAndPrevNumeral = ""  + romanNumeralArray[lastPossibleIndex - 1] + romanNumeralArray[lastPossibleIndex];

            if(RomanNumeral.isSubtractive(thisAndPrevNumeral)){//if last two numerals entered are subtractive


            }
        }


    }

}
