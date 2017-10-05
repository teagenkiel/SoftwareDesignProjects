/**
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleDimensionsPanel extends JPanel{

    CircleDimensionsPanel(Circle myCircle){

        JTextArea dimensionsTextArea = new JTextArea(5, 15);

        dimensionsTextArea.setText(myCircle.toString());

        dimensionsTextArea.setEditable(false);

        add(dimensionsTextArea);
        add(new JScrollPane(dimensionsTextArea));
    }



}

