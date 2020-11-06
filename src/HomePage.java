import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage {
    public static boolean display(String username, String password) {
        Stage window = new Stage();
        Button button = new Button("Close");
        window.setMinWidth(300);
        window.setTitle("Bulletin");

        button.setOnAction(e -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return true;
    }
}
