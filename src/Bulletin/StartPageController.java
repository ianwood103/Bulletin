package Bulletin;

import javafx.scene.control.TextField;

public class StartPageController {
    public TextField nameInput;
    public TextField passInput;

    public void login() {
        System.out.println("Username: "  + nameInput.getText());
        System.out.println("Password: " + passInput.getText());
        HomePage.display(nameInput.getText(), passInput.getText());
    }
}
