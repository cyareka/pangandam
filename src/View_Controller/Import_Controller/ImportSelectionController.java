package View_Controller.Import_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ImportSelectionController implements Initializable {

    @FXML
    private AnchorPane ImportSelect;

    @FXML
    private Button impSelectFileBTN;

    @FXML
    private Button impSelectProductBTN;

    @FXML
    void impSelectFileBTNHandler(ActionEvent event) {
        

    }

    @FXML
    void impSelectProductBTNHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) impSelectProductBTN.getScene().getWindow();
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("ImportProduct.fxml"));
      
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
