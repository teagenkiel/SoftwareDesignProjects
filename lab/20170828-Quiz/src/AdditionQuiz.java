// Fig. 2.7: Addition.java
// Addition program that displays the sum of two numbers.

import java.util.Scanner;

public class AdditionQuiz {
    // main method begins execution of Java application
    public static void main(String[] args) {
        // create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);

        //int number1;  first number to ad
        // int number2;  second number to add
        //int sum;  sum of number1 and number2

        System.out.print("Enter first integer: "); // prompt
        int number1 = input.nextInt(); // read first number from user

        System.out.print("Enter second integer: "); // prompt
        int number2 = input.nextInt(); // read second number from user

        System.out.print("Enter third integer: ");
        int number3 = input.nextInt();

        int sum = number1 + number2 + number3; // add numbers, then store total in sum

        System.out.printf("Sum is %d%n", sum); // display sum
    } // end method main
} // end class Addition

/* *************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
