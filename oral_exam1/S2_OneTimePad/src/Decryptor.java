/**
 *
 *
 *
 *
 */

public class Decryptor {

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int encryptedMessageAsIndexes[];
    private char decryptedMessage[];
    private int n;
    private final static char spaceCharacter = ' ';
    private final static int spaceFlag = -1;

    public Decryptor(String encryptedMessage, int n) throws Exception {

        this.encryptedMessageAsIndexes = Encryptor.validateAndConvertMessage(encryptedMessage.toCharArray());
        if(n <= 0){
            throw new Exception("The offset must be larger than zero");
        }
        this.n = n;
        decryptedMessage = new char[encryptedMessage.length()];

    }



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

    public char[] getDecryptedMessage() {

        this.decryptMessage();
        return decryptedMessage;
    }
}
