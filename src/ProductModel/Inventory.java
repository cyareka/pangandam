package ProductModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

   public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

   public static ObservableList<ProductExport> allProductExport = FXCollections.observableArrayList();

   public static void addProduct(Product newProduct) {
      allProducts.add(newProduct);
   }

   public static ObservableList<Product> getAllProducts() {
      return allProducts;
   }

   public static void addProductExport (ProductExport newProductExport) {
      allProductExport.add(newProductExport);
   }

   public static ObservableList<ProductExport> getAllProductExport() {
      return allProductExport;
   }
}
