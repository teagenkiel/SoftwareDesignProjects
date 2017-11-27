import javax.swing.*;

/**
 * This class is the main driver class for the numeral conversion application. It will initialize the GUI frame which
 * will allow the user to interact with the numeral converter and deal with the main running of the program.
 *
 * @author Teagen Kiel
 *
 */

public class NumeralConverterTest {

    public static void main(String args[]){

        NumeralConverterFrame myFrame = new NumeralConverterFrame();
        myFrame.setSize(200,200);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
