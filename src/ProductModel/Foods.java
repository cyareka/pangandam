package ProductModel;

public class Foods extends Product {

   // Instantiated variables
   private Boolean perishable;
   private String expiryDate;

   // Default constructor
   public Foods(final String nameOrg, final String nameProduct, final int quantity) {
      super(nameOrg, nameProduct, quantity);
      this.perishable = false;
      this.expiryDate = "";
   }

   public Foods(final String nameOrg, final String nameProduct, final int quantity, final boolean perishable, final String expiryDate) {
      super(nameOrg, nameProduct, quantity);
      this.perishable = perishable;
      this.expiryDate = expiryDate;
   }

   // Generate Getters & Setters
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
