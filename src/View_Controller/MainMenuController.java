package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ProductModel.Inventory;
import ProductModel.Product;
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
    private TableColumn<Product, String> inStockColumn;

    @FXML
    private Button modifyItemButton;

    @FXML
    private TableColumn<Product, String> productColumn;

    @FXML
    private TableColumn<Product, String> productExpColumn;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private TableView<Product> proofOfTransaction;

    @FXML
    private Button searchProductButton;

    @FXML
    private TextField searchProductInput;

    @FXML
    private TableColumn<Product, String> toExportColumn;

    // Delete Product
    @FXML
    void deleteItemBTNHandler(ActionEvent event) {
        if (Inventory.allProducts.isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning!");
            alert.setContentText("Input cannot be empty! Please try again.");
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
        Stage stage = (Stage) importItemButton.getScene().getWindow();
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/View_Controller/Export_Controller/ExportProducts.fxml"));
      
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
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/View_Controller/Import_Controller/ImportSelection.fxml"));
      
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void inputSearchHandler(ActionEvent event) {}

    @FXML
    void modifyItemBTNHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) importItemButton.getScene().getWindow();
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/View_Controller/Modify_Controller/ModifyProduct.fxml"));
      
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchProductBTNHandler(ActionEvent event) {
        String searchProduct = searchProductInput.getText();
        
        for (Product productSearched : Inventory.getAllProducts()) {
            if (productSearched.getNameProduct().equals(searchProduct));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productTableView.setItems(Inventory.getAllProducts());

        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        inStockColumn.setCellValueFactory(new PropertyValueFactory<>("in stock"));

        proofOfTransaction.setItems(Inventory.getAllProducts());

        productExpColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        toExportColumn.setCellValueFactory(new PropertyValueFactory<>("to export"));
    }
}
