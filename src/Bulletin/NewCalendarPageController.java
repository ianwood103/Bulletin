package Bulletin;

import javafx.fxml.FXML;
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
        File file = new File("src/DefaultUser/" + nameField.getText() + "/");
        file.mkdir();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/DefaultUser/calendar-list.json");
        JSONArray calendarList = (JSONArray) parser.parse(reader);
        JSONObject newCalendar = new JSONObject();
        newCalendar.put("name", nameField.getText());
        newCalendar.put("image", "School/logo.png");
        calendarList.add(newCalendar);
        FileWriter calendarFile = new FileWriter("src/DefaultUser/calendar-list.json");
        calendarFile.write(calendarList.toJSONString());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();

        Stage window = (Stage) ap.getScene().getWindow();

        window.setScene(new Scene(root));
    }
}
