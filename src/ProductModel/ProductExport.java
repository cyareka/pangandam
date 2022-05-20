package ProductModel;

public class ProductExport extends Product {
   
   private String date;
   private String receiver;
   
   public ProductExport(final String nameOrg, final String nameProduct, final int quantity) {
      super(nameOrg, nameProduct, quantity);
      this.date = "";
      this.receiver = "";
   }

   public ProductExport(final String nameOrg, final String nameProduct, final int quantity, final String receiver, final String date) {
      super(nameOrg, nameProduct, quantity);
      this.date = date;
      this.receiver = receiver;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getReceiver() {
      return receiver;
   }

   public void setReceiver(String receiver) {
      this.receiver = receiver;
   }
}