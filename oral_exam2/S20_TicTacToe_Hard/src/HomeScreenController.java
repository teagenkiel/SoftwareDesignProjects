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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardScene.fxml"));
        Parent newGame = loader.load();

        BoardController controller = loader.getController();

        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Human vs. Computer");
        stage.show();

        controller.setPlayers(new HumanPlayer("Player 1"), new ComputerPlayer("Computer 1"));
    }

    @FXML
    private Button HumanVsHumanButton;

    public void createHumanVsHumanGame() throws IOException {

        Stage stage = (Stage) HumanVsHumanButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardScene.fxml"));
        Parent newGame = loader.load();

        BoardController controller = loader.getController();

        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Human vs. Human");
        stage.show();

        controller.setPlayers(new HumanPlayer("Player 1"), new HumanPlayer("Player 2"));
    }

    @FXML
    private Button ComputerVsComputerButton;

    public void createComputerVsComputerGame() throws IOException, InterruptedException {

        Stage stage = (Stage) ComputerVsComputerButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardScene.fxml"));
        Parent newGame = loader.load();

        BoardController controller = loader.getController();


        Scene scene = new Scene(newGame);
        stage.setScene(scene);
        stage.setTitle("Computer vs. Computer");
        stage.show();


        controller.setPlayers(new ComputerPlayer("Computer 1"), new ComputerPlayer("Computer 2"));
    }


}