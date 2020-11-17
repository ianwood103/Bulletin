package Bulletin;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class CalendarButton {

    private String calendarName;
    private String imagePath;
    private Button calendarButton;

    //Constructors
    public CalendarButton(String calendarName, String imagePath) {
        this.calendarName = calendarName;
        this.imagePath = imagePath;
    }

    public CalendarButton() {
        this.calendarName = "";
        this.imagePath = "";
    }

    public Button getButton() throws Exception{
        calendarButton = (Button) FXMLLoader.load(getClass().getResource("CalendarButton.fxml"));;
        return calendarButton;
    }

    //Getters and setters
    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
