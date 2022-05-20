package View_Controller.Export_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ProductModel.Foods;
import ProductModel.Inventory;
import ProductModel.Product;
import ProductModel.ProductExport;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExportProductController implements Initializable {

    ProductExport productExp;

    @FXML
    private BorderPane Export;

    @FXML
    private TextField exportDateInput;

    @FXML
    private Button exportAddProductBTN;

    @FXML
    private Button exportCancelBTN;

    @FXML
    private TextField exportInputProductName;
    
    @FXML
    private TextField exportSenderInput;

    @FXML
    private TextField exportInputReceiver;

    @FXML
    private TextField exportQuantityInput;

    @FXML
    private TextField exportStockQuantity;

    @FXML
    private Button exportRemoveBTN;

    @FXML
    private Button exportSaveInSystemBTN;

    @FXML
    private Button exportSaveBTN;

    @FXML
    TableView<Product> productTableView;

    @FXML
    private TableColumn<Product, String> orgNameColumn;

    @FXML
    private TableColumn<Product, String> productColumn;

    @FXML
    private TableColumn<Product, Integer> inStockColumn;

    @FXML
    private TableColumn<Foods, Boolean> foodsColumn;

    @FXML
    private TableColumn<SurvivalKit, Boolean> skColumn;

    @FXML
    private TableColumn<Foods, String> expiryDateColumn;
    
    @FXML
    private TableView<ProductExport> productExportList;

    @FXML
    private TableColumn<ProductExport, String> dateExpColumn;
    
    @FXML
    private TableColumn<ProductExport, String> senderExpColumn;
    
    @FXML
    private TableColumn<ProductExport, String> receiverExpColumn;
    
    @FXML
    private TableColumn<ProductExport, String> productExpColumn;

    @FXML
    private TableColumn<ProductExport, Integer> toExportColumn;

    @FXML
    private void exportAddProductBTNHandler(ActionEvent event) throws IOException {
        try {
            Alert alert = new Alert(AlertType.ERROR);
            String date = exportDateInput.getText();
            String nameOrg = exportSenderInput.getText();
            String receiver = exportInputReceiver.getText();
            String productName = exportInputProductName.getText();
            int quantity = Integer.parseInt(exportQuantityInput.getText());
            int stock = Integer.parseInt(exportStockQuantity.getText());
          
            if (quantity > 5000) {
                alert.setTitle("Invalid Values");
                alert.setContentText("Value must not exceed 5000.");
                alert.showAndWait();
            } else if (quantity <= 0) {
                alert.setTitle("Invalid Values");
                alert.setContentText("Value must not be less than or equal to 0.");
                alert.showAndWait();  
            } else if (quantity > stock) {
                alert.setTitle("Invalid Values");
                alert.setContentText("Value must not exceed the In Stock Quantity");
            } else {  
                Inventory.addProductExport(new ProductExport(nameOrg, productName, quantity, receiver, date));

                Stage stage;
                Parent root;
                stage = (Stage) exportAddProductBTN.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ExportProduct.fxml"));

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
    void exportCancelBTNHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel? No changes will be saved.");
        alert.setTitle("Cancel Confirmation");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){       
            Stage stage;
            Parent root;
            stage = (Stage) exportCancelBTN.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void exportRemoveBTNHandler(ActionEvent event) {
        if (productExportList.getSelectionModel().isEmpty() == true) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Select a product to remove.");
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Product Removal");
            alert.setContentText("Are you sure you want to delete this product from the Proof of Transaction?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                ProductExport selectedProductExp = productExportList.getSelectionModel().getSelectedItem();
                Inventory.allProductExport.remove(selectedProductExp);
            }
        }
    }

    @FXML
    void exportSaveBTNHandler(ActionEvent event) {

    }

    @FXML
    void exportSaveInSystemBTNHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Product List

        productTableView.setItems(Inventory.getAllProducts());
        orgNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("nameOrg"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("nameProduct"));
        inStockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        foodsColumn.setCellValueFactory(new PropertyValueFactory<Foods, Boolean>("perishable"));
        skColumn.setCellValueFactory(new PropertyValueFactory<SurvivalKit, Boolean>("flammable"));
        expiryDateColumn.setCellValueFactory(new PropertyValueFactory<Foods, String>("expiryDate"));

        // Product Export List
        productExportList.setItems(Inventory.getAllProductExport());
        dateExpColumn.setCellValueFactory(new PropertyValueFactory<ProductExport, String>("date"));
        senderExpColumn.setCellValueFactory(new PropertyValueFactory<ProductExport, String>("nameOrg"));
        receiverExpColumn.setCellValueFactory(new PropertyValueFactory<ProductExport, String>("receiver"));
        productExpColumn.setCellValueFactory(new PropertyValueFactory<ProductExport, String>("nameProduct"));
        toExportColumn.setCellValueFactory(new PropertyValueFactory<ProductExport, Integer>("quantity"));
    }
}
