package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    
    public static ObservableList<Part> getAllParts(){
      return allParts;  
    }
    
    public static void addProducts(Product newProduct){
        allProducts.add(newProduct);
    }
    
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    } 
}

