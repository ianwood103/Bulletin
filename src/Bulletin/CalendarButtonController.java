package Bulletin;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CalendarButtonController {
    public Label label;
    public ImageView image;

    public void fillData(String index) {
        label.setText(index);
        try {
            image.setImage(new Image("DefaultUser/Family/logo.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
