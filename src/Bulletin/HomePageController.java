package Bulletin;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HomePageController {
    public VBox leftSide;
    public AnchorPane ap;

    public void initialize() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Button button1 = (Button) loader.load(getClass().getResource("CalendarButton.fxml").openStream());
        CalendarButtonController controller1 = loader.getController();
        controller1.fillData("hello");
        leftSide.getChildren().add(button1);
    }
}
