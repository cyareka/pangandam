package ProductModel;

public class Foods extends Product {

   // Instantiated variables
   private String noodles,
                 rice,
                 cannedGoods,
                 water;
   private Boolean perishable;
   private String expiryDate;

   // Default constructor
   public Foods(String noodles, String rice, String cannedGoods, String water, Boolean perishable, String expiryDate) {
      this.noodles = noodles;
      this.rice = rice;
      this.cannedGoods = cannedGoods;
      this.water = water;
      this.perishable = perishable;
      this.expiryDate = expiryDate;
   }

   // Generate Getters & Setters
   public String getNoodles() {
      return noodles;
   }

   public void setNoodles(String noodles) {
      this.noodles = noodles;
   }

   public String getRice() {
      return rice;
   }

   public void setRice(String rice) {
      this.rice = rice;
   }

   public String getCannedGoods() {
      return cannedGoods;
   }

   public void setCannedGoods(String cannedGoods) {
      this.cannedGoods = cannedGoods;
   }

   public String getWater() {
      return water;
   }

   public void setWater(String water) {
      this.water = water;
   }

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
