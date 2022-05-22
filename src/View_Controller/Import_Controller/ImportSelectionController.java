package View_Controller.Import_Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import ProductModel.Foods;
import ProductModel.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ImportSelectionController {

    public static ObservableList<Product> importHolder = FXCollections.observableArrayList();
    
    @FXML private AnchorPane ImportSelect;
    @FXML private Button impSelectFileBTN;
    @FXML private Button impSelectProductBTN;

    @FXML
    void impSelectFileBTNHandler(ActionEvent event) throws IOException {
        File impFile = new File("Product List.csv");
        Scanner inputStream = new Scanner(impFile);
        while ((inputStream.hasNext())) {
            String data = inputStream.next();
            String[] lineValue = data.split(",");
            importHolder.add(new Foods(String.valueOf(lineValue[0].toString()), String.valueOf(lineValue[1].toString()), Integer.valueOf(lineValue[2].toString())));
        }
        inputStream.close();

        Stage stage;
            Parent root;
            stage = (Stage) impSelectFileBTN.getScene().getWindow();
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainMenu.fxml"));
    
            root = loader.load();
    
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void impSelectProductBTNHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) impSelectProductBTN.getScene().getWindow();
      
        FXMLLoader loader= new FXMLLoader(getClass().getResource("ImportProduct.fxml"));
      
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
