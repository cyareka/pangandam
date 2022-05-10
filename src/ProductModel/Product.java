package ProductModel;

public abstract class Product {

   private String nameOrg;
   private String nameProduct;
   private int quantity;
   
   public Product(final String nameOrg, final String nameProduct, final int quantity) {
      this.nameOrg = nameOrg;
      this.nameProduct = nameProduct;
      this.quantity = quantity;
   }

   // Getters and Setters
   public String getNameOrg() {
      return nameOrg;
   }

   public void setNameOrg(String nameOrg) {
      this.nameOrg = nameOrg;
   }

   public String getNameProduct() {
      return nameProduct;
   }

   public void setNameProduct(String nameProduct) {
      this.nameProduct = nameProduct;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }  
}