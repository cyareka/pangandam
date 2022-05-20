package ProductModel;

public class SurvivalKit extends Product {

   private Boolean flammable;

   public SurvivalKit(final String nameOrg, final String nameProduct, final int quantity) {
      super(nameOrg, nameProduct, quantity);
      this.flammable = false;
   }

   public SurvivalKit(final String nameOrg, final String nameProduct, final int quantity, final boolean flammable) {
      super(nameOrg, nameProduct, quantity);
      this.flammable = flammable;
   }

   public Boolean getFlammable() {
      return flammable;
   }

   public void setFlammable(Boolean flammable) {
      this.flammable = flammable;
   }
}
