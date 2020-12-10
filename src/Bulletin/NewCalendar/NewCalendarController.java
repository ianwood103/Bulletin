package Bulletin.NewCalendar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;

public class NewCalendarController {
    public TextField nameField;
    public Button submitButton;
    public AnchorPane ap;
    private File selectedFile;

    public void imageButtonClick() throws IOException {
        Stage window = (Stage) ap.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        selectedFile = fileChooser.showOpenDialog(window);
    }

    public void submitButtonClick() throws IOException, ParseException, InterruptedException {

        //Creates a new directory for the new calendar that the user wants to create
        File file = new File("DefaultUser/" + nameField.getText() + "/");
        file.mkdir();

        //Creates a new file name with logo as the name, but keeping the extension the same
        int index = selectedFile.getName().lastIndexOf(".");
        String ext = selectedFile.getName().substring(index);

        //Stored in newFileName
        String newFileName = "logo" + ext;

        File newFile = new File(file.getPath() + "/" + newFileName);

        //Copies the selected file into the project src folder, with newFileName as the new file name
        Files.copy(selectedFile.toPath(), newFile.toPath());

        if(newFile.exists() && !newFile.isDirectory()) {
            System.out.println("file exists");
        }

        //Parses existing list of calendars and stores that information in calendarList JSONArray
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("DefaultUser/calendar-list.json");
        JSONArray calendarList = (JSONArray) parser.parse(reader);

        //Creates a new JSONObject to hold the information for the new calendar
        JSONObject newCalendar = new JSONObject();
        newCalendar.put("name", nameField.getText());
        newCalendar.put("image", nameField.getText() + "/" + newFileName);

        //Adds new calendar JSONObject to JSONArray
        calendarList.add(newCalendar);

        //Updates the calendar-list.json file to hold information for new calendar
        FileWriter calendarFile = new FileWriter("DefaultUser/calendar-list.json");
        calendarFile.write(calendarList.toJSONString());

        //Closes the updated calendar-list.json file
        calendarFile.flush();
        calendarFile.close();

        //Loads layout from Home.fxml into root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Home/Home.fxml"));
        Parent root = loader.load();

        //Gets stage from the outside AnchorPane
        Stage window = (Stage) ap.getScene().getWindow();

        //Changes the scene back to the homepage with the newly created calendar showing
        window.setScene(new Scene(root));
    }
}
