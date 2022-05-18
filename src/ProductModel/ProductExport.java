package ProductModel;

public class ProductExport extends Product {

   private String date;
   private String receiver;

   public ProductExport(final String sender, final String nameProduct, final int quantity) {
      super(sender, nameProduct, quantity);
      this.date = "";
      this.receiver = "";
   }

   public ProductExport(final String sender, final String nameProduct, final int quantity, final String receiver, final String date) {
      super(sender, nameProduct, quantity);
      this.date = date;
      this.receiver = receiver;
   }
}
