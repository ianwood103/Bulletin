package Bulletin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HomePageController {
    public VBox leftSide;
    public AnchorPane ap;

    public void initialize() throws Exception {
        CalendarButton defaultButton = new CalendarButton();
        CalendarButton button2 = new CalendarButton();

        ObservableList<Button> buttonList = FXCollections.observableArrayList();

        buttonList.add(defaultButton.getButton());
        buttonList.get(0).setOnAction(e -> System.out.println("success"));
        buttonList.add(button2.getButton());

        leftSide.getChildren().addAll(buttonList);

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("DefaultUser/calendar-list.json")) {

            //Read JSON file
            JSONArray calendarList = (JSONArray) jsonParser.parse(reader);
            System.out.println(calendarList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
