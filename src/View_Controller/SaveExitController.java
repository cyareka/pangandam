package View_Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

import ProductModel.Foods;
import ProductModel.Inventory;
import ProductModel.Product;
import ProductModel.SurvivalKit;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class SaveExitController {

    @FXML private AnchorPane ImportSelect;
    @FXML private Button foodsBTN;
    @FXML private Button survivalKitBTN;

    @FXML
    void foodsBTNHandler(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Save as Foods - Product List?", ButtonType.OK);
        a.setTitle("Save & Exit");
        a.initStyle(StageStyle.UTILITY);
        Optional<ButtonType> result = a.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Writer writer = null;
            Foods food = new Foods("","", 0, false, "");

            try {
                File file = new File ("Foods - Product List.csv");
                writer = new BufferedWriter(new FileWriter(file));
                for (Product product : Inventory.getAllProducts()) {
                    String mainText = product.getNameOrg() + ","
                                    + product.getNameProduct() + ","
                                    + product.getQuantity() + ","
                                    + food.getPerishable() + ","
                                    + food.getExpiryDate() + "\n";
                    writer.write(mainText);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.flush();
                writer.close();
            }
            Platform.exit();
        }
    }

    @FXML
    void survivalKitBTNHandler(ActionEvent event) throws IOException {
        Alert b = new Alert(Alert.AlertType.CONFIRMATION, "Save as Survival Kit - Product List?");
        b.setTitle("Save & Exit");
        b.initStyle(StageStyle.UTILITY);
        Optional<ButtonType> result = b.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {

            Writer writer = null;
            SurvivalKit sk = new SurvivalKit("", "", 0, false);

            try {
                File file = new File ("Survival Kit - Product List.csv");
                writer = new BufferedWriter(new FileWriter(file));
                for (Product product : Inventory.getAllProducts()) {
                    String mainText = product.getNameOrg() + ","
                                    + product.getNameProduct() + ","
                                    + product.getQuantity() + ","
                                    + sk.getFlammable() + "\n";
                    writer.write(mainText);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.flush();
                writer.close();
            }
            Platform.exit();
        }
    }
}