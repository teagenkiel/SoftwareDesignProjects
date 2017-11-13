import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class CalculatorController {

    @FXML
    private TextField output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
    private String prevValue = "";

    private CalculatorModel model = new CalculatorModel();

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String newValue = ((Button)event.getSource()).getText();

        if (!"=".equals(newValue)) {


            operator = newValue;
            number1 = Long.parseLong(newValue);
            output.setText(newValue + prevValue);

        }
        else {
            if (operator.isEmpty()) {
                output.setText(newValue);
                return;
            }

            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

}
