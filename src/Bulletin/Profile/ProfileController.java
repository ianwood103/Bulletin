package Bulletin.Profile;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProfileController {

    public AnchorPane ap;

    public void exit() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Home/Home.fxml"));
        Parent root = loader.load();

        Stage window = (Stage) ap.getScene().getWindow();

        window.setScene(new Scene(root, window.getWidth(), window.getHeight()));
    }
}
