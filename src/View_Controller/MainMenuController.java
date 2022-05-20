package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ProductModel.Foods;
import ProductModel.Inventory;
import ProductModel.Product;
import ProductModel.SurvivalKit;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

    @FXML
    private Label MainLabel;

    @FXML
    private Button deleteItemButton;

    @FXML
    private Button exitProgramButton;

    @FXML
    private Button exportItemButton;

    @FXML
    private Button importItemButton;
    
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
    private Button searchProductButton;

    @FXML
    private TextField searchProductInput;

    // Delete Product
    @FXML
    void deleteItemBTNHandler(ActionEvent event) throws IOException {
        if (Inventory.allProducts.isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You must enter a product before you can delete it.");
            alert.showAndWait();
        } else if (productTableView.getSelectionModel().isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setContentText("Select a product to delete it.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?");
            alert.setTitle("Confirm Deletion");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                Product selectedProduct = (Product)productTableView.getSelectionModel().getSelectedItem();
                Inventory.allProducts.remove(selectedProduct);
            }
        }
    }

    // Exit Program
    @FXML
    void exitProgramBTNHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to close the program?");
        alert.setTitle("Exit Program");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    // Open Export Window
    @FXML
    void exportItemBTNHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) exportItemButton.getScene().getWindow();
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/View_Controller/Export_Controller/ExportProduct.fxml"));
      
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Open Import Window
    @FXML
    void importItemBTNHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) importItemButton.getScene().getWindow();
      
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/Import_Controller/ImportProduct.fxml"));
        
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void inputSearchHandler(ActionEvent event) {
        if (Inventory.allProducts.isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setContentText("Input cannot be empty! Please try again.");
        }
    }

    @FXML
    void searchProductBTNHandler(ActionEvent event) {
        String searchProduct = searchProductInput.getText();
        
        for (Product productSearched : Inventory.getAllProducts()) {
            if (productSearched.getNameProduct().equals(searchProduct) || productSearched.getNameOrg().equals(searchProduct)) {
                productTableView.getSelectionModel().select(productSearched);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productTableView.setItems(Inventory.getAllProducts());

        orgNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("nameOrg"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("nameProduct"));
        inStockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        foodsColumn.setCellValueFactory(new PropertyValueFactory<Foods, Boolean>("perishable"));
        skColumn.setCellValueFactory(new PropertyValueFactory<SurvivalKit, Boolean>("flammable"));
        expiryDateColumn.setCellValueFactory(new PropertyValueFactory<Foods, String>("expiryDate"));
    }
}
