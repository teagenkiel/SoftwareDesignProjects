import java.util.Scanner;

public class OneTimePadTest {


    public static void main(String[] args){


        Scanner myScanner = new Scanner(System.in);
        boolean messageValidationFlag = true;


        while(messageValidationFlag) {
            try {
                System.out.println("Please enter a message to be encrypted");
                String messageToEncrypt = myScanner.nextLine();
                System.out.println("Please enter an offset, n:");
                int n = myScanner.nextInt();
                myScanner.nextLine(); //takes care of the given '\n' character
                Encryptor myEncryptor = new Encryptor(messageToEncrypt, n);
                System.out.println(myEncryptor.getEncryptedMessage());

                System.out.println("Please enter an encrypted message");
                String encryptedMessage = myScanner.nextLine();
                System.out.println("Please enter the offset used in the encrypted message");
                int nUsed = myScanner.nextInt();
                Decryptor myDecryptor = new Decryptor(encryptedMessage, nUsed);
                System.out.println(myDecryptor.getDecryptedMessage());
                messageValidationFlag = false;

            } catch (Exception messageException) {
                System.out.printf("Exception: %s%n", messageException.getMessage());
            }
        }




    }
}
