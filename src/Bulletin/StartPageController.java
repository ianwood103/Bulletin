package Bulletin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartPageController {
    public TextField nameInput;
    public TextField passInput;
    public AnchorPane ap;

    public void login() throws Exception {
        System.out.println("Username: "  + nameInput.getText());
        System.out.println("Password: " + passInput.getText());

        Parent homePage = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage window = (Stage) ap.getScene().getWindow();
        window.setScene(new Scene(homePage, window.getWidth(), window.getHeight()));
    }
}
