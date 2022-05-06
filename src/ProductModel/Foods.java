package ProductModel;

public class Foods {

   private String expiryDate;

   public boolean isPerishable (String expiryDate) {
   }

   public String getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(String expiryDate) {
      this.expiryDate = expiryDate;
   }

   @Override
   public String toString() {
      String str = "hotdog";
      return str;
   }
}
