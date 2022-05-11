package ProductModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

   public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

   public static void addProduct (Product newProduct) {
      allProducts.add(newProduct);
   }

   public static ObservableList<Product> getAllProducts() {
      return allProducts;
   }
}
