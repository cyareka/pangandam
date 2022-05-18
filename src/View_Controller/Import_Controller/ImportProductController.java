package View_Controller.Import_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ProductModel.Foods;
import ProductModel.Inventory;
import ProductModel.SurvivalKit;
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

public class ImportProductController implements Initializable {

    @FXML
    private AnchorPane Import;

    @FXML
    private TextField importExpiryDateInput;

    @FXML
    private Button importAddProductBTN;

    @FXML
    private Button importCancelBTN;

    @FXML
    private CheckBox importFoodsBTN;

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
    void importAddProductBTNHandler(ActionEvent event) throws IOException {
        try {
            String nameOrg = importOrgNameInput.getText();
            String nameProduct = importProductNameInput.getText();
            int quantity = Integer.parseInt(importQuantityInput.getText());
            int max = 5000;
            Boolean yesPeri = importYesPeriBTN.isSelected();
            String expDate = importExpiryDateInput.getText();
            Boolean yesFlam = importYesFlamBTN.isSelected();


            if (quantity > max) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Values");
                alert.setContentText("Quantity must not exceed 5000 items.");
                alert.showAndWait();
            } else {
                if (yesPeri) {
                    Inventory.addProduct(new Foods(nameOrg, nameProduct, quantity, yesPeri, expDate));
                } else if (yesFlam) {
                    Inventory.addProduct(new SurvivalKit(nameOrg, nameProduct, quantity, yesFlam));
                }

                Stage stage;
                Parent root;
                stage = (Stage) importAddProductBTN.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));

                root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please enter the correct value for each field.");
            alert.showAndWait();
        }
    }


    @FXML
    void importCancelBTNHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel? No changes will be saved.");
        alert.setTitle("Cancel Confirmation");
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        importFoodsBTN.disableProperty().bind(importSKBTN.selectedProperty().or(importYesFlamBTN.selectedProperty()));
        importYesPeriBTN.disableProperty().bind(importSKBTN.selectedProperty().or(importYesFlamBTN.selectedProperty()));
        importExpiryDateInput.disableProperty().bind(importSKBTN.selectedProperty().or(importYesFlamBTN.selectedProperty()));

        importSKBTN.disableProperty().bind(importFoodsBTN.selectedProperty().or(importYesPeriBTN.selectedProperty()));
        importYesFlamBTN.disableProperty().bind(importFoodsBTN.selectedProperty().or(importYesPeriBTN.selectedProperty()));
    }
}
