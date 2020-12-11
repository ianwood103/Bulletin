package Bulletin.Home;

import Bulletin.CalendarButton.CalendarButtonController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

//Controller class for Home.fxml
public class HomeController {

    //Declares variables for the outer AnchorPane
    // Also declares the right and left sides of scrollview that contains the calendar buttons
    public VBox leftSide;
    public VBox middleSide;
    public VBox rightSide;
    public AnchorPane ap;
    public Button newButton;
    public AnchorPane menuPane;

    //This function is automatically called when Home.fxml gets loaded
    public void initialize() throws Exception {
        menuPane.toBack();

        //Creates a new JSONParser to parse json data
        JSONParser jsonParser = new JSONParser();

        //Creates a new FXMLLoader to load fxml files
        FXMLLoader loader;

        //Creates temporary variables for Button and CalendarButtonController variables
        Button tempButton;
        CalendarButtonController tempController;

        //Reads calendar-list.json into reader variable, while accounting for possible errors
        try (FileReader reader = new FileReader("DefaultUser/calendar-list.json")) {

            //Parses data from calendar-list.json into a JSONArray
            JSONArray calendarList = (JSONArray) jsonParser.parse(reader);

            //Creates count variable, used to keep track of which side the button should be loaded to
            int count = 0;

            //Iterates through the list of calendars
            for (Object calendarButton : calendarList) {

                //Casts the object from the JSONArray into a JSONObject
                JSONObject buttonObj = (JSONObject) calendarButton;

                //Re-initializes the FXMLLoader
                loader = new FXMLLoader();

                //A temporary button is loaded into tempButton variable from the CalendarButton.fxml file
                tempButton = (Button) loader.load(getClass().getResource("../CalendarButton/CalendarButton.fxml").openStream());

                //Stores the controller for this specific button in the tempController
                tempController = loader.getController();

                //The current button is filled with data from the json file
                tempController.fillData((String) buttonObj.get("name"), (String) buttonObj.get("image"));

                //Determines if the button should be added to the left or right side of the window
                if (count % 3 == 0) {
                    leftSide.getChildren().add(tempButton);
                } else if (count % 3 == 1) {
                    middleSide.getChildren().add(tempButton);
                } else {
                    rightSide.getChildren().add(tempButton);
                }
                count++;
            }
        } catch (Exception e) {

            //Prints out any errors, but the program will still continue running if errors are thrown
            e.printStackTrace();
        }
    }

    public void newButtonClick() throws Exception {
        Stage window  = (Stage) ap.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../NewCalendar/NewCalendar.fxml"));
        Parent root = loader.load();

        window.setScene(new Scene(root, window.getWidth(), window.getHeight()));
    }

    public void openMenu() {
        menuPane.toFront();
        menuPane.setStyle("-fx-opacity: 1");
    }

    public void closeMenu() {
        menuPane.toBack();
        menuPane.setStyle("-fx-opacity: 0");
    }
}
