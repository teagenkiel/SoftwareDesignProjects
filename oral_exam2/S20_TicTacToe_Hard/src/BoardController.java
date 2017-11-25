/**
 *
 *
 *
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController{

    private BoardModel model;

    @FXML
    public GridPane gameGrid;

    @FXML
    public Label gameLabel;


    public void setPlayers (Player player1, Player player2){

        this.model = new BoardModel(player1, player2);
        gameLabel.setText(model.getCurrentPlayer().getName() + "'s turn");
        this.model.setGameRunning(true);

    }


    @FXML
    public void gridClicked(MouseEvent e) throws InterruptedException {

        if(model.isGameRunning()) {
            int[] selectedGrid;
            int[] gridClick = {0, 0};

            Label clickedLabel = (Label) e.getSource();
            Pane clickedPane = (Pane) clickedLabel.getParent();
            Integer rowIndex = GridPane.getRowIndex(clickedPane);
            Integer columnIndex = GridPane.getColumnIndex(clickedPane);

            if (rowIndex == null && columnIndex == null) {
                gridClick[0] = 0;
                gridClick[1] = 0;
            } else if (rowIndex == null) {
                gridClick[0] = 0;
                gridClick[1] = columnIndex;
            } else if (columnIndex == null) {
                gridClick[0] = rowIndex;
                gridClick[1] = 0;
            } else {
                gridClick[0] = rowIndex;
                gridClick[1] = columnIndex;
            }

            model.getCurrentPlayer().setLastGridClick(gridClick);

            selectedGrid = model.getCurrentPlayer().move(model.getOtherPlayer());
            System.out.println(selectedGrid[0] + ", " + selectedGrid[1]);

            Pane selectedPane = (Pane) (gameGrid.getChildren().get(selectedGrid[0] * 3 + selectedGrid[1]));
            Label selectedLabel = (Label) selectedPane.getChildren().get(0);
            selectedLabel.setText(model.getCurrentPlayer().getMoveLetter());

            model.changePlayers();
            gameLabel.setText(model.getCurrentPlayer().getName() + "'s turn");

        }

        if (model.getOtherPlayer().checkWin()) {

            gameLabel.setText(model.getOtherPlayer().getName() + " wins!");

            model.setGameRunning(false);
        }

        if(model.getGameCount() == 8 && model.isGameRunning()){

            gameLabel.setText("Cat's game!");
            model.setGameRunning(false);
        }


        model.setGameCount(model.getGameCount() + 1);


    }


    @FXML
    public void playGame() throws InterruptedException {

        /*
        //make sure board is cleared

        for (Node node : gameGrid.getChildren()) {

            Pane tempPane = (Pane) node;
            Label selectedLabel = (Label) tempPane.getChildren().get(0);
            selectedLabel.setText("");
        }*/

        System.out.println("Playing game");

        boolean gameOver = false;
        int[] selectedGrid;
        int moveCount = 0;


        gameLabel.setText(model.getCurrentPlayer().getName() + "'s turn");
        System.out.println("inside while");

        selectedGrid = model.getCurrentPlayer().move(model.getOtherPlayer());
        System.out.println(selectedGrid[0] + ", " + selectedGrid[1]);

        Pane selectedPane = (Pane) (gameGrid.getChildren().get(selectedGrid[0] * 3 + selectedGrid[1]));
        Label selectedLabel = (Label) selectedPane.getChildren().get(0);
        selectedLabel.setText(model.getCurrentPlayer().getMoveLetter());

        if(model.getCurrentPlayer().checkWin()){

            gameLabel.setText(model.getCurrentPlayer().getName() + " wins!");
            gameOver = true;
            model.setGameRunning(false);
        }

        if(moveCount == 9){

            System.out.println("here");
            gameLabel.setText("Cat's game!");
            gameOver = true;
            model.setGameRunning(false);
        }

        model.changePlayers();
        moveCount++;



    }

}
