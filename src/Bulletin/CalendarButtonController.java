package Bulletin;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Controller class for CalendarButton.fxml
public class CalendarButtonController {

    //Declares variable for each of the nodes in the default button from CalendarButton.fxml
    public Label label;
    public ImageView image;
    public Button button;

    //Fills the button with data, taking in a name for the calendar and a class path for a picture for the button
    public void fillData(String name, String imagePath) {
        //Sets the text of the calendar button to the entered string
        label.setText(name);

        //Safely attempts to set the image to the specified class path
        try {
            Image loadedImage = new Image("file:DefaultUser/" + imagePath);
            image.setImage(loadedImage);
        } catch (Exception e) {
            //Prints any errors, but the program continues to run
            e.printStackTrace();
        }

        //Sets the button to print out its name when clicked for testing purposes
        button.setOnAction(e -> System.out.println(name));
    }
}
