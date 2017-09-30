/**
 * This class will
 */

public class Encryptor {

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int n;
    private int messageAsIndexes[];
    private char encryptedMessage[];
    private static final int spaceFlag = -1;
    private static final char spaceCharacter = ' ';

    public Encryptor(String message, int n) throws Exception {

        message = message.toUpperCase();
        messageAsIndexes = validateAndConvertMessage(message.toCharArray());
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
        encryptedMessage = new char[message.length()];
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
    protected static int[] validateAndConvertMessage(char message[]) throws Exception {

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

                    alphabetIndexArray[messageIterator] = spaceFlag;
                }

            }

        }

        return alphabetIndexArray;
    }


    public char[] getEncryptedMessage() {

        this.encryptMessage();
        return encryptedMessage;
    }

    private void encryptMessage(){

        int newIndex;

        for (int messageIterator = 0; messageIterator < messageAsIndexes.length; messageIterator++){


            if(messageAsIndexes[messageIterator] == spaceFlag){

                encryptedMessage[messageIterator] = spaceCharacter;
            }
            else {
                newIndex = messageAsIndexes[messageIterator] + n;

                while (newIndex >= alphabet.length) {

                    newIndex = newIndex - alphabet.length;
                }

                encryptedMessage[messageIterator] = alphabet[newIndex];
            }
        }
   }







}
