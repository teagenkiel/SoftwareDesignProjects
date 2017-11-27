import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to create the frame for which the converter application will be displayed and used by the user.
 * It will create a functional gui that will allow the user to type a numeral in either box and display the converted
 * GUI in the other box.
 *
 * @author Teagen Kiel
 */
public class NumeralConverterFrame extends JFrame{

    /**
     * The main constructor for the class NumeralConverterFrame. This constructor will initialize the numeral converter's
     * GUI and will register event handlers so that the user can type and react with the numeral converter.
     */
    public NumeralConverterFrame(){
        super("Arabic and Roman Numeral Converter");

        setLayout(new GridLayout(2,2));

        JLabel romanLabel = new JLabel("Roman numeral");
        add(romanLabel);

        JLabel arabicLabel = new JLabel("Arabic numeral");
        add(arabicLabel);

        JTextField romanTextField = new JTextField(15);
        add(romanTextField);

        JTextField arabicTextField = new JTextField(15);
        add(arabicTextField);

        romanTextField.addKeyListener(
                new KeyAdapter() {

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyTyped(e);
                        romanTextField.setText(NumeralConverter.validateRomanNumeral(romanTextField.getText()));
                        arabicTextField.setText(String.valueOf(NumeralConverter.romanToArabic(romanTextField.getText())));
                    }
                }
        );

        arabicTextField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyTyped(e);

                        if(!arabicTextField.getText().equals("")) { //parseInt cannot handle empty strings
                            int arabicNumeral = Integer.parseInt(arabicTextField.getText());
                            romanTextField.setText(NumeralConverter.arabicToRoman(arabicNumeral));
                        }

                    }
                }
        );

    }
}
