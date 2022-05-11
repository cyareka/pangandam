package View_Controller;

import ProductModel.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainMenuController {

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
    private TableColumn<Product, Integer> inStockColumn;

    @FXML
    private Button modifyItemButton;

    @FXML
    private TableColumn<Product, String> productColumn;

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
    void deleteItemHandler(ActionEvent event) {

    }

    @FXML
    void exitProgramHandler(ActionEvent event) {

    }

    @FXML
    void exportItemHandler(ActionEvent event) {

    }

    @FXML
    void importItemHandler(ActionEvent event) {

    }

    @FXML
    void inputSearchHandler(ActionEvent event) {

    }

    @FXML
    void modifyItemHandler(ActionEvent event) {

    }

    @FXML
    void saveReceiptHandler(ActionEvent event) {

    }

    @FXML
    void saveUpdateHandler(ActionEvent event) {

    }

    @FXML
    void searchHandler(ActionEvent event) {

    }

}
