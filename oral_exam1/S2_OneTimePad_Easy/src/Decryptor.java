/**
 * This class will be used to decrypt a message that is encrypted with one offset, n. To be used in conjunction
 * with the Encryptor class, an object of this class will take in a encrypted message, validate and convert
 * it to indexes of the alphabet array, and then decrypt the message using the same technique as the encryptor
 * but in reverse when the getDecryptedMessage is called.
 * @author Teagen Kiel
 * @since 2017-10-01
 * @see Encryptor
 */

public class Decryptor {

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int encryptedMessageAsIndexes[];
    private char decryptedMessage[];
    private int n;
    private final static char spaceCharacter = ' ';
    private final static int spaceFlag = -1;


    /**
     * The main constructor for class Decryptor. Will take in an encrypted message, use the validate and convert method
     * to make sure it is usable and convert it to alphabet indexes, validate n to make sure it is not equal to or less
     * than zero, and allocate memory for the array to hold the decrypted message.
     * @param encryptedMessage the encrypted message given by the user
     * @param n the offset that will be given to each letter
     * @throws Exception if n is equal to or less than zero or there are non-letters in the encrypted message
     */
    public Decryptor(char encryptedMessage[], int n) throws Exception {

        this.encryptedMessageAsIndexes = Encryptor.validateAndConvertMessage(encryptedMessage);
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
        decryptedMessage = new char[encryptedMessage.length];

    }

    /**
     * Overloaded constructor if a string is given instead of a character array
     * @param encryptedMessage the encrypted message as a string
     * @param n the offset of the encrypted message
     * @throws Exception if n is less than or equal to 0, or there are non-letters in the encrypted message
     */
    public Decryptor(String encryptedMessage, int n) throws Exception {

        this(encryptedMessage.toCharArray(), n);
    }

    /**
     * To set a new ecrypted message with a new offset
     * @param encryptedMessage the message that will be decrypted
     * @param n the new offset, n
     * @throws Exception if n is less than or equal to 0 or the message has non-letters
     */
    public void setNewEncryptedMessage(char encryptedMessage[], int n) throws Exception{
        this.encryptedMessageAsIndexes = Encryptor.validateAndConvertMessage(encryptedMessage);
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
        decryptedMessage = new char[encryptedMessage.length];
    }

    /**
     * Will decrypt the message and return the decrypted message back to the user
     * @return the decrypted message
     */
    public char[] getDecryptedMessage() {

        this.decryptMessage();
        return decryptedMessage;
    }


    /**
     * This method will decrypt the message given to us. It iterates through the encrypted message, and if it isn't
     * a space, it will subtract the offset of the alphabet index of the character, and then converts the decrypted
     * index back to a character and puts it in the corresponding spot of the decrypted message array.
     */
    private void decryptMessage(){

        int originalIndex;

        for(int messageIterator = 0; messageIterator < encryptedMessageAsIndexes.length; messageIterator++){

            if(encryptedMessageAsIndexes[messageIterator] == spaceFlag) {

                decryptedMessage[messageIterator] = spaceCharacter;
            }
            else{

                originalIndex = encryptedMessageAsIndexes[messageIterator] - n;

                while (originalIndex < 0){
                    originalIndex = originalIndex + alphabet.length;
                }

                decryptedMessage[messageIterator] = alphabet[originalIndex];

            }
        }
    }


}
