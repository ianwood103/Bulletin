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

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Loads StartPage.fxml layout into root
        Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        window = primaryStage;

        //Sets title of application window to be Bulletin
        window.setTitle("Bulletin");

        //Creates new scene with root layout and width of 600 and height of 400
        Scene scene =  new Scene(root, 600, 400);

        //Sets the scene of the window to the scene declared above and displays the window
        window.setScene(scene);
        window.show();
    }
}
