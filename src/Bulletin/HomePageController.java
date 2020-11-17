package Bulletin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    }
}
