import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is used as the main driver function for the TicTacToe application. Upon running this class's main, it will
 * load the home screen scene from the fxml file given in this project which will show the beginning options for
 * the program.
 *
 * @author Teagen Kiel
 */
public class TicTacToeApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Overrides the "start" function in the superclass wich will allow us to start our application with the constraints
     * we give.
     * @param primaryStage The stage we will be using to set our scenes on.
     * @throws IOException if there is an error loading the stage or any of the scenes.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeScreenScene.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
