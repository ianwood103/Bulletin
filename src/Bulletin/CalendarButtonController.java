package Bulletin;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CalendarButtonController {
    public Label label;
    public ImageView image;
    public Button button;

    public void fillData(String name, String imagePath) {
        label.setText(name);
        try {
            image.setImage(new Image("DefaultUser/" + imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setOnAction(e -> System.out.println(name));
    }
}
