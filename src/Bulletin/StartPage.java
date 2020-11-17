package Bulletin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartPage extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        window = primaryStage;
        window.setTitle("Login Page");

        Scene scene =  new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
