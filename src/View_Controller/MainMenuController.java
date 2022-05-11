package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import ProductModel.Inventory;
import ProductModel.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TableColumn<?, ?> inStockColumn;

    @FXML
    private Button modifyItemButton;

    @FXML
    private TableColumn<?, ?> productColumn;

    @FXML
    private TableView<?> productTableView;

    @FXML
    private TextArea proofOfTransaction;

    @FXML
    private Button saveReceiptButton;

    @FXML
    private Button saveUpdateReceipt;

    @FXML
    private Button searchProductButton;

    @FXML
    private TextField searchProductInput;

    @FXML
    void deleteItemBTNHandler(ActionEvent event) {

    }

    @FXML
    void exitProgramBTNHandler(ActionEvent event) {

    }

    @FXML
    void exportItemBTNHandler(ActionEvent event) {

    }

    @FXML
    void importItemBTNHandler(ActionEvent event) {

    }

    @FXML
    void inputSearchHandler(ActionEvent event) {

    }

    @FXML
    void modifyItemBTNHandler(ActionEvent event) {

    }

    @FXML
    void saveReceiptBTNHandler(ActionEvent event) {

    }

    @FXML
    void saveUpdateBTNHandler(ActionEvent event) {

    }

    @FXML
    void searchProductBTNHandler(ActionEvent event) {
        String searchProduct = searchProductInput.getText();
        
        for (Product productSearched : Inventory.getAllProducts()) {
            if (productSearched.getNameProduct().equals(searchProduct));

            Product prod = new Product();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
    }
}