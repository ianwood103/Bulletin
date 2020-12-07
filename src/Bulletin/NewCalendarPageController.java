package Bulletin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class NewCalendarPageController {
    public TextField nameField;
    public Button submitButton;
    public AnchorPane ap;

    public void submitButtonClick() throws IOException, ParseException {

        //Creates a new directory for the new calendar that the user wants to create
        File file = new File("src/DefaultUser/" + nameField.getText() + "/");
        file.mkdir();

        //Parses existing list of calendars and stores that information in calendarList JSONArray
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/DefaultUser/calendar-list.json");
        JSONArray calendarList = (JSONArray) parser.parse(reader);

        //Creates a new JSONObject to hold the information for the new calendar
        JSONObject newCalendar = new JSONObject();
        newCalendar.put("name", nameField.getText());
        newCalendar.put("image", "School/logo.png");

        //Adds new calendar JSONObject to JSONArray
        calendarList.add(newCalendar);

        //Updates the calendar-list.json file to hold information for new calendar
        FileWriter calendarFile = new FileWriter("src/DefaultUser/calendar-list.json");
        calendarFile.write(calendarList.toJSONString());

        //Closes the updated calendar-list.json file
        calendarFile.flush();
        calendarFile.close();

        //Loads layout from HomePage.fxml into root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();

        //Gets stage from the outside AnchorPane
        Stage window = (Stage) ap.getScene().getWindow();

        //Changes the scene back to the homepage with the newly created calendar showing
        window.setScene(new Scene(root));
    }
}
