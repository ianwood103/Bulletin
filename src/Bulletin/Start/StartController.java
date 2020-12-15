package Bulletin.Start;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Controller class for Start.fxml
public class StartController {

    //Declares variables for each text field and also the AnchorPane that contains the entire layout
    public VBox outerBox;
    public VBox middleBox;
    public VBox innerBox;
    public TextField nameInput;
    public PasswordField passInput;
    public AnchorPane ap;
    public BorderPane exitPane;
    public Button exitButton;
    public Label header;

    public void login() throws Exception {

        //Prints out the entered username and password for testing purposes
        //System.out.println("Username: "  + nameInput.getText());
        //System.out.println("Password: " + passInput.getText());

        //Loads the layout from Home.fxml into homePage
        Parent homePage = FXMLLoader.load(getClass().getResource("../Home/Home.fxml"));

        //Using the declared AnchorPane from above, this stores the current window in the window variable
        Stage window = (Stage) ap.getScene().getWindow();

        //Creates a new scene to have the layout from Home.fxml and keeps the window size the same
        Scene scene = new Scene(homePage, window.getWidth(), window.getHeight());

        //Changes the scene to this newly created scene
        window.setScene(scene);
    }

    public void loginClick() {
        outerBox.toBack();
        middleBox.toBack();
        outerBox.setStyle("-fx-opacity: 0");
        innerBox.setStyle("-fx-opacity: 1");
        exitPane.setStyle("-fx-opacity: 1");
        exitButton.setOnAction(e -> {
            try {
                this.exitClick();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exitButton.setStyle("-fx-cursor: hand");
        header.setStyle("-fx-opacity: 0");
    }

    public void createAccountClick() {
        outerBox.toBack();
        innerBox.toBack();
        middleBox.setStyle("-fx-opacity: 1");
        innerBox.setStyle("-fx-opacity: 0");
        outerBox.setStyle("-fx-opacity: 0");
        exitPane.setStyle("-fx-opacity: 1");
        exitButton.setOnAction(e -> {
            try {
                this.exitClick();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exitButton.setStyle("-fx-cursor: hand");
        header.setStyle("-fx-opacity: 0");
    }

    public void exitClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) ap.getScene().getWindow();
        window.setScene(new Scene(root, window.getWidth(), window.getHeight() - 28));
    }

    public void initialize() {
        passInput.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
            if (ev.getCode() == KeyCode.ENTER) {
                try {
                    this.login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
