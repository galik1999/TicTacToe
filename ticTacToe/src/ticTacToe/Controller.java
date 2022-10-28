package ticTacToe;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.text.Text;

public class Controller implements Initializable {

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Button b3;

	@FXML
	private Button b4;

	@FXML
	private Button b5;

	@FXML
	private Button b6;

	@FXML
	private Button b7;

	@FXML
	private Button b8;

	@FXML
	private Button b9;

	@FXML
	private Text winnerText;

	private int playerTurn = 0;
	ArrayList<Button> buttons;

	@FXML
	void restartGame(ActionEvent event) {
		playerTurn = 0;
		for (Button b : buttons) {
			resetButton(b);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttons = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9));
		for (Button b : buttons) {
			setUpButton(b);
			b.setFocusTraversable(false);
		}
	}

	private void setUpButton(Button button) {
		button.setOnMouseClicked(mouseEvent -> {
			setPlayerSymbol(button);
			button.setDisable(true);
			checkIfGameIsOver();
		});
	}

	private void setPlayerSymbol(Button button) {
		if (playerTurn % 2 == 0) {
			button.setText("X");
			playerTurn = 1;
		} else {
			button.setText("O");
			playerTurn = 0;
		}

	}

	public void checkIfGameIsOver() {
		boolean isOver = false;
		if ((b1.getText() + b2.getText() + b3.getText()).equals("XXX")
				|| (b1.getText() + b2.getText() + b3.getText()).equals("OOO"))
			isOver = true;
		if ((b4.getText() + b5.getText() + b6.getText()).equals("XXX")
				|| (b4.getText() + b5.getText() + b6.getText()).equals("OOO"))
			isOver = true;
		if ((b7.getText() + b8.getText() + b9.getText()).equals("XXX")
				|| (b7.getText() + b8.getText() + b9.getText()).equals("OOO"))
			isOver = true;
		if ((b1.getText() + b4.getText() + b7.getText()).equals("XXX")
				|| (b1.getText() + b4.getText() + b7.getText()).equals("OOO"))
			isOver = true;
		if ((b2.getText() + b5.getText() + b8.getText()).equals("XXX")
				|| (b2.getText() + b5.getText() + b8.getText()).equals("OOO"))
			isOver = true;
		if ((b3.getText() + b6.getText() + b9.getText()).equals("XXX")
				|| (b3.getText() + b6.getText() + b9.getText()).equals("OOO"))
			isOver = true;
		if ((b1.getText() + b5.getText() + b9.getText()).equals("XXX")
				|| (b1.getText() + b5.getText() + b9.getText()).equals("OOO"))
			isOver = true;
		if ((b3.getText() + b5.getText() + b7.getText()).equals("XXX")
				|| (b3.getText() + b5.getText() + b7.getText()).equals("OOO"))
			isOver = true;

		if (isOver) {
			if (playerTurn == 1) {
				winnerText.setText("THE WINNER IS X");
				for (Button b : buttons) {
					b.setDisable(true);
				}
			} else {
				winnerText.setText("THE WINNER IS O");
				for (Button b : buttons) {
					b.setDisable(true);
				}
			}
		}
	}

	private void resetButton(Button button) {
		button.setDisable(false);
		button.setText("");
		winnerText.setText("TIC-TAC-TOE");
	}

}
