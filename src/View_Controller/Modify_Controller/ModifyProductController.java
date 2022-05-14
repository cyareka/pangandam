package View_Controller.Modify_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ModifyProductController implements Initializable {

    @FXML
    private AnchorPane Import;

    @FXML
    private Button importCancelBTN;

    @FXML
    private TextField importProductNameInput;

    @FXML
    private CheckBox modifyFoodsBTN;

    @FXML
    private CheckBox modifyNoFlamBTN;

    @FXML
    private CheckBox modifyNoPeriBTN;

    @FXML
    private TextField modifyOrgNameInput;

    @FXML
    private Button modifyProductBTN;

    @FXML
    private TextField modifyQuantityInput;

    @FXML
    private CheckBox modifySKBTN;

    @FXML
    private CheckBox modifyYesFlamBTN;

    @FXML
    private CheckBox modifyYesPeriBTN;

    @FXML
    void importCancelBTNHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel? No changes will be saved.");
        alert.setTitle("Exit Alert!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){       
            Stage stage;
            Parent root;
            stage = (Stage) importCancelBTN.getScene().getWindow();

            FXMLLoader loader= new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void modifyProductBTNHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
