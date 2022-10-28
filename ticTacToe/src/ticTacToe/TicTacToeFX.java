package ticTacToe;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("ticTacToe.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setWidth(600);
				primaryStage.setHeight(600);
				primaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
	}
	public static void main(String[] args) {
		launch(args);
	}

}
