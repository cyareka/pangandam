package ProductModel;

public class Foods extends Product {

   private Boolean perishable;
   private String expiryDate;

   public Foods(final String nameOrg, final String nameProduct, final int quantity) {
      super(nameOrg, nameProduct, quantity);
      this.perishable = false;
      this.expiryDate = "";
   }

   public Foods(final String nameOrg, final String nameProduct, final int quantity, final Boolean perishable, final String expiryDate) {
      super(nameOrg, nameProduct, quantity);
      this.perishable = perishable;
      this.expiryDate = expiryDate;
   }

   // Getters and Setters
   public Boolean getPerishable() {
      return perishable;
   }

   public void setPerishable(Boolean perishable) {
      this.perishable = perishable;
   }

   public String getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(String expiryDate) {
      this.expiryDate = expiryDate;
   }
}
