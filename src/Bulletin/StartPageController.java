package Bulletin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Controller class for StartPage.fxml
public class StartPageController {

    //Declares variables for each text field and also the anchorpane that contains the entire layout
    public TextField nameInput;
    public TextField passInput;
    public AnchorPane ap;

    public void login() throws Exception {

        //Prints out the entered username and password for testing purposes
        System.out.println("Username: "  + nameInput.getText());
        System.out.println("Password: " + passInput.getText());

        //Loads the layout from HomePage.fxml into homePage
        Parent homePage = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        //Using the declared anchorpane from above, this stores the current window in the window variable
        Stage window = (Stage) ap.getScene().getWindow();

        //Creates a new scene to have the layout from HomePage.fxml and keeps the window size the same
        Scene scene = new Scene(homePage, window.getWidth(), window.getHeight());

        //Changes the scene to this newly created scene
        window.setScene(scene);
    }
}
