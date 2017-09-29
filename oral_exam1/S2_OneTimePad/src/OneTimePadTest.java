import java.util.Scanner;

public class OneTimePadTest {


    public static void main(String[] args){


        Scanner myScanner = new Scanner(System.in);
        String messageToEncrypt;
        boolean messageValidationFlag = true;

        System.out.println("Please enter a message to be encrypted");


        while(messageValidationFlag) {
            try {
                messageToEncrypt = myScanner.nextLine();
                Encryptor myEncryptor = new Encryptor(messageToEncrypt, 15);
                System.out.println(myEncryptor.getEncryptedMessage());
                messageValidationFlag = false;

            } catch (Exception messageException) {
                System.out.printf("Exception: %s%n", messageException.getMessage());
            }
        }




    }
}
