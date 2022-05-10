package Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
           Scene scene = new Scene(root);
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
=