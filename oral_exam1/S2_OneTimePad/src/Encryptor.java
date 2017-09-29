/**
 * This class will
 */

public class Encryptor {

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int n;
    private int messageAsAlphabetIndexes[];
    private char cipheredMessage[];

    public Encryptor(String message, int n) throws Exception {

        message = message.toUpperCase();
        messageAsAlphabetIndexes = validateAndConvertMessage(message.toCharArray());
        this.n = n;
    }

    /**
     * This method will throw an exception if a character in the given character array is not a letter. This method
     * is static because it can be used without creating an object of the class, and can be used in the constructor.
     * It will traverse the character array given, and if the character is not a letter it will throw an exception.
     * Next, when the the letter is matched with the letter in the index, it will set the value in the
     * alphabetIndexArray (corresponding with the letter in the message character array) to the current index.
     * If the character is a space, it is flagged with the value of -1.
     * @param message the message given to us as a character array
     * @return alphabetIndexArray, an array containing the letters of the message array converted to the corresponding
     * index of the static alphabet array instance variable. This will have the same length as the message array.
     */
    private static int[] validateAndConvertMessage(char message[]) throws Exception {

        final char spaceCharacter = ' ';
        int alphabetIndexArray[] = new int[message.length];

        for (int messageIterator = 0; messageIterator < message.length; messageIterator++){

            /* if the character in the given character array is not in the static alphabet array, and is not a
            * space */
            if((!Character.isLetter(message[messageIterator])) && (message[messageIterator] != spaceCharacter)){

                throw new Exception("Message contains a non-alphabetic character");
            }

            for (int alphabetIterator = 0; alphabetIterator < alphabet.length; alphabetIterator++){


                /* If the character is in the alphabet array, convert the character to the current alphabet array index. */
                if(message[messageIterator] == alphabet[alphabetIterator]){

                    alphabetIndexArray[messageIterator] = alphabetIterator;

                }
                /* else if the character is a space, flag with the -1 integer */
                else if(message[messageIterator] == spaceCharacter){

                    alphabetIndexArray[messageIterator] = -1;
                }

            }

        }

        return alphabetIndexArray;
    }

   private void encryptMessage(){

        for (int indexIterator = 0; indexIterator < messageAsAlphabetIndexes.length; indexIterator++){

            messageAsAlphabetIndexes[indexIterator] = messageAsAlphabetIndexes[indexIterator] + n
        }
   }







}
