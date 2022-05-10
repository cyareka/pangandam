package ProductModel;

public class SurvivalKit extends Product {

   private boolean flammable;
   
   public SurvivalKit(final String nameOrg, final String nameProduct, final int quantity) {
      super(nameOrg, nameProduct, quantity);
      this.flammable = false;
   }

   public SurvivalKit(final String nameOrg, final String nameProduct, final int quantity, final boolean flammable) {
      super(nameOrg, nameProduct, quantity);
      this.flammable = flammable;
   }

   public boolean verifyFlammable(Boolean flammable) {
      return flammable = this.flammable;
   }
}
