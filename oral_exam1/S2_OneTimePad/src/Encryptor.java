/**
 * This class will be used to encrypt a message. After creating an object of this class and giving it a nessage and an
 * offset, it will validate and convert the message into an index of an array containing letters of the alphabet.
 * When the getEncryptedMessage() method is called, the object will give each letter's index the given offset, and then
 * store the encrypted letters and return the character array to the user.
 *
 * @author Teagen Kiel
 * @since 2017-09-30
 */

public class Encryptor {

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int n; //the offset to be given by the user
    private int messageAsIndexes[]; //original message as alphabet array indexes
    private char encryptedMessage[]; //will be initialized in the constructor
    private static final int spaceFlag = -1;
    private static final char spaceCharacter = ' ';


    /**
     * The main constructor for class Encryptor. The constructor will validate the the message and convert the
     * characters to indexes in the static alphabet array. Then, checks if the offset, n, is greater then or less than
     * zero because we can't have a negative offset, or no offset. We then allocate memory for the array that will hold
     * the encrypted message because it will be the same length as the original message.
     * @param message the message to be encrypted
     * @param n the offset of the encryption to be used
     * @throws Exception if the value of n is negative or zero
     */
    public Encryptor(char message[], int n) throws Exception {

        messageAsIndexes = validateAndConvertMessage(message);
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
        encryptedMessage = new char[message.length];
    }

    /**
     * Overloaded constructor in case the user gives a string rather than a character array.
     * @param message the message to be encrypted as a string
     * @param n the offset of the encryption
     * @throws Exception if the value of n is negative or zero
     */
    public Encryptor(String message, int n) throws Exception {
        this(message.toCharArray(), n);
    }

    /**
     * @param message the new message to be encrypted
     * @throws Exception if the message has non-letters
     */
    public void setNewMessage(char message[]) throws Exception {

        this.messageAsIndexes = validateAndConvertMessage(message);
        encryptedMessage = new char[message.length];
    }

    /**
     * If a string wants to be given instead
     * @param message the message to be encrypted
     * @throws Exception if the message has non-letters
     */
    public void setNewMessage(String message) throws Exception{

        this.setNewMessage(message.toCharArray());
    }

    /**
     * @param n the offset of the letters desired
     * @throws Exception if n is less than or equal to zero
     */
    public void setN(int n) throws Exception {
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
    }



    /**
     * This method will be used to validate a message and convert it into an index of the alphabet array. This method
     * is static because it can be used without creating an object of the class, and can be used in the constructor.
     * It will traverse the character array given, and if the character is not a letter it will throw an exception.
     * Next, we make sure the letter is uppercase, and when the the letter is matched with the letter in the index,
     * it will set the value in the alphabetIndexArray (corresponding with the letter in the message character array)
     * to the current index. If the character is a space, it is flagged with the value of -1.
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
            /* if the character is a letter, make sure it is uppercase */
            else if(Character.isLetter(message[messageIterator])){

                message[messageIterator] = Character.toUpperCase(message[messageIterator]);
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


    /**
     * Will encrypt the message (so the user doesn't need to call it) and return the encrypted message to the user.
     * @return encryptedMessage
     */
    public char[] getEncryptedMessage() {

        this.encryptMessage();
        return encryptedMessage;
    }

    /**
     * This method will encrypt the message given to us. It iterates through the original message, and if it isn't
     * a space, it will add the offset to the alphabet index of the character, and then converts the encrypted
     * index back to a character and puts it in the corresponding spot of the encrypted message array.
     */
    private void encryptMessage(){

        int encryptedIndex; //this variable will hold the value of the encrypted index

        for (int messageIterator = 0; messageIterator < messageAsIndexes.length; messageIterator++){


            if(messageAsIndexes[messageIterator] == spaceFlag){ //if the index is equal to -1

                encryptedMessage[messageIterator] = spaceCharacter; //there will still be a space in the same spot
            }
            else {
                encryptedIndex = messageAsIndexes[messageIterator] + n; //offsets the index

                while (encryptedIndex >= alphabet.length) { //while the resulting index is bigger than the array

                    encryptedIndex = encryptedIndex - alphabet.length; //the offest goes back to the beginning of the alphabet
                }

                encryptedMessage[messageIterator] = alphabet[encryptedIndex]; //put the encrypted letter into the encrypted array
            }
        }
   }

}
