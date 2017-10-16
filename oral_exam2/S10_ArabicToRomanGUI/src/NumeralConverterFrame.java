import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 *
 *
 */
public class NumeralConverterFrame extends JFrame{

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
