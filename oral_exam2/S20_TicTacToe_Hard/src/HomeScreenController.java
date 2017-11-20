import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class HomeScreenController {

    @FXML
    private Button HumanVsComputerButton;

    public void createHumanVsComputerGame() throws IOException {

        Stage stage = (Stage) HumanVsComputerButton.getScene().getWindow();
        Parent newGame = FXMLLoader.load(getClass().getResource("BoardScene.fxml"));

        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Human vs. Computer");
        stage.show();
    }

    @FXML
    private Button HumanVsHumanButton;

    public void createHumanVsHumanGame() throws IOException {

        Stage stage = (Stage) HumanVsHumanButton.getScene().getWindow();
        Parent newGame = FXMLLoader.load(getClass().getResource("BoardScene.fxml"));

        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Human vs. Human");
        stage.show();
    }

    @FXML
    private Button ComputerVsComputerButton;

    public void createComputerVsComputerGame() throws IOException {

        Stage stage = (Stage) ComputerVsComputerButton.getScene().getWindow();
        Parent newGame = FXMLLoader.load(getClass().getResource("BoardScene.fxml"));

        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Computer vs. Computer");
        stage.show();
    }


}