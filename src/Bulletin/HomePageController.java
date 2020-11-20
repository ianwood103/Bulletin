package Bulletin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class HomePageController {
    public VBox leftSide;
    public VBox rightSide;
    public AnchorPane ap;

    public void initialize() throws Exception {

        JSONParser jsonParser = new JSONParser();
        FXMLLoader loader;
        ObservableList<CalendarButtonController> controllerList = FXCollections.observableArrayList();
        ObservableList<Button> buttonList = FXCollections.observableArrayList();
        Button tempButton;
        CalendarButtonController tempController;

        try (FileReader reader = new FileReader("src/DefaultUser/calendar-list.json")) {
            JSONArray calendarList = (JSONArray) jsonParser.parse(reader);
            int count = 0;

            for (Object calendarButton : calendarList) {
                JSONObject buttonObj = (JSONObject) calendarButton;
                loader = new FXMLLoader();
                tempButton = (Button) loader.load(getClass().getResource("CalendarButton.fxml").openStream());
                tempController = loader.getController();
                tempController.fillData((String) buttonObj.get("name"), (String) buttonObj.get("image"));

                if (count % 2 == 0) {
                    rightSide.getChildren().add(tempButton);
                } else {
                    leftSide.getChildren().add(tempButton);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
