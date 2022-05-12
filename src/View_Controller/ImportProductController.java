package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ImportProductController implements Initializable {

    ObservableList<String> productCategory = FXCollections.observableArrayList("Food","Survival Kit");

    @FXML
    private AnchorPane Import;

    @FXML
    private Button importAddProductBTN;

    @FXML
    private Button importCancelBTN;

    @FXML
    private ComboBox<String> importCategoryBTN;

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
    private CheckBox importYesFlamBTN;

    @FXML
    private CheckBox importYesPeriBTN;

    @FXML
    void importAddProductBTNHandler(ActionEvent event) {

    }

    @FXML
    void importCancelBTNHandler(ActionEvent event) {

    }

    @FXML
    void importCategoryBTNHandler(ActionEvent event) {
        importCategoryBTN.setItems(productCategory);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {   
    }

}
