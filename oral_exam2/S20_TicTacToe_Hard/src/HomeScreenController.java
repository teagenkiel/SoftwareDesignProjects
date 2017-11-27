import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

/**
 * This class will be used as the controller for the starting home screen of the application. It will be used to declare
 * the event handlers for each button used for each game option.
 *
 * @author Teagen Kiel
 */
public class HomeScreenController {

    /**
     * This variable defines the button used to start a game b/t a human and a computer.
     */
    @FXML
    private Button HumanVsComputerButton;

    /**
     * This method will create a new game of a human versus a computer by loading the scene, creating the controller
     * and setting the appropriate player types for the game.
     * @throws IOException
     */
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

    /**
     * This variable defines the button used to start a game b/t a human and a human.
     */
    @FXML
    private Button HumanVsHumanButton;

    /**
     * This method will create a new game of a human versus a human by loading the scene, creating the controller
     * and setting the appropriate player types for the game.
     * @throws IOException
     */
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

    /**
     * This variable defines the button used to start a game b/t a computer and a computer.
     */
    @FXML
    private Button ComputerVsComputerButton;

    /**
     * This method will create a new game of a computer versus a computer by loading the scene, creating the controller
     * and setting the appropriate player types for the game.
     * @throws IOException
     */
    public void createComputerVsComputerGame() throws IOException {

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