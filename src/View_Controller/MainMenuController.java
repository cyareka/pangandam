package View_Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenuController implements Initializable {

    @FXML private Label MainLabel;
    @FXML private Button deleteItemButton;
    @FXML private Button saveExitProgramButton;
    @FXML private Button exitProgramButton;
    @FXML private Button exportItemButton;
    @FXML private Button importItemButton;
    @FXML private Button importFoodsFileButton;
    @FXML private Button importSKFileButton;
    @FXML public TableView<Product> productTableView;
    @FXML private TableColumn<Product, String> orgNameColumn;
    @FXML private TableColumn<Product, String> productColumn;
    @FXML private TableColumn<Product, Integer> inStockColumn;
    @FXML private TableColumn<Foods, Boolean> foodsColumn;
    @FXML private TableColumn<SurvivalKit, Boolean> skColumn;
    @FXML private TableColumn<Foods, String> expiryDateColumn;

    // Delete Product
    @FXML
    void deleteItemBTNHandler(ActionEvent event) throws IOException {
        if (Inventory.allProducts.isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You must enter a product before you can delete it.");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        } else if (productTableView.getSelectionModel().isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setContentText("Select a product to delete it.");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?");
            alert.setTitle("Confirm Deletion");
            alert.initStyle(StageStyle.UTILITY);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Product selectedProduct = (Product)productTableView.getSelectionModel().getSelectedItem();
                Inventory.allProducts.remove(selectedProduct);
            }
        }
    }

    // Save & Exit Program
    @FXML
    void saveExitProgramBTNHandler(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to close the program?");
        
        alert.setTitle("Save & Exit");
        alert.initStyle(StageStyle.UTILITY);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage;
            Parent root;
            stage = (Stage) saveExitProgramButton.getScene().getWindow();
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/SaveExit.fxml"));
    
            root = loader.load();
    
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
    }

    @FXML
    void exitProgramBTNHandler(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to close the program? Current database will not be saved.");
        alert.setTitle("Exit Program");
        alert.initStyle(StageStyle.UTILITY);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
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

    // SK from File
    @FXML
    void importSKFileBTNHandler(ActionEvent event) throws IOException {
        File file = new File("Survival Kit - Product List.csv");
        Scanner inputStream = new Scanner(file);
        while ((inputStream.hasNext())) {
            String data = inputStream.next();
            String[] lineValue = data.split(",");

            Inventory.addProduct(new SurvivalKit(String.valueOf(lineValue[0].toString()), String.valueOf(lineValue[1].toString()), Integer.valueOf(lineValue[2].toString()), Boolean.valueOf(lineValue[4])));

            productTableView.setItems(Inventory.getAllProducts());
        }
        inputStream.close();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Import Survival Kit Success");
        alert.setContentText("Import file is successful.");
        alert.initStyle(StageStyle.UTILITY);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            importFoodsFileButton.setDisable(true);
        }

        Stage stage;
        Parent root;
        stage = (Stage) importSKFileButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));

        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Foods from File
    @FXML
    void importFoodsFileBTNHandler(ActionEvent event) throws IOException {
        File file = new File("Foods - Product List.csv");
        Scanner inputStream = new Scanner(file);
        while ((inputStream.hasNext())) {
            String data = inputStream.next();
            String[] lineValue = data.split(",");

            Inventory.addProduct(new Foods(String.valueOf(lineValue[0].toString()), String.valueOf(lineValue[1].toString()), Integer.valueOf(lineValue[2].toString()), Boolean.valueOf(lineValue[3].toString()), String.valueOf(lineValue[5].toString())));
        }
        inputStream.close();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Import Foods Success");
        alert.setContentText("Import file is successful.");
        alert.initStyle(StageStyle.UTILITY);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage;
            Parent root;
            stage = (Stage) importFoodsFileButton.getScene().getWindow();
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));
    
            root = loader.load();
    
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
