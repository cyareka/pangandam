package View_Controller.Import_Controller;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ImportProductController {

    @FXML
    private AnchorPane Import;

    @FXML
    private Button importAddProductBTN;

    @FXML
    private Button importCancelBTN;

    @FXML
    private CheckBox importFoodsBTN;

    @FXML
    private CheckBox importNoFlamBTN;

    @FXML
    private CheckBox importNoPeriBTN;

    @FXML
    private TextField importOrgNameInput;

    @FXML
    private TextField importProductNameInput;

    @FXML
    private TextField importQuantityInput;

    @FXML
    private CheckBox importSKBTN;

    @FXML
    private CheckBox importYesFlamBTN;

    @FXML
    private CheckBox importYesPeriBTN;

    @FXML
    void importAddProductBTNHandler(ActionEvent event) {

    }

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
}
