package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ImportProductController implements Initializable {

    @FXML
    private AnchorPane Import;

    @FXML
    private Button importAddProductBTN;

    @FXML
    private Button importCancelBTN;

    @FXML
    private CheckBox importNoBTN;

    @FXML
    private TextField importOrgNameInput;

    @FXML
    private TextField importProductNameInput;

    @FXML
    private TextField importQuantityInput;

    @FXML
    private CheckBox importYesBTN;

    @FXML
    void importAddProductBTNHandler(ActionEvent event) {

    }

    @FXML
    void importCancelBTNHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
