package ProductModel;

public class SurvivalKit extends Product {

   private String bandage,
                 alcohol,
                 povidoneIodineSol,
                 battery,
                 flashlight,
                 whistle;
   private Boolean flammable;
   
   public String getBandage() {
      return bandage;
   }
   public void setBandage(String bandage) {
      this.bandage = bandage;
   }
   public String getAlcohol() {
      return alcohol;
   }
   public void setAlcohol(String alcohol) {
      this.alcohol = alcohol;
   }
   public String getPovidoneIodineSol() {
      return povidoneIodineSol;
   }
   public void setPovidoneIodineSol(String povidoneIodineSol) {
      this.povidoneIodineSol = povidoneIodineSol;
   }
   public String getBattery() {
      return battery;
   }
   public void setBattery(String battery) {
      this.battery = battery;
   }
   public String getFlashlight() {
      return flashlight;
   }
   public void setFlashlight(String flashlight) {
      this.flashlight = flashlight;
   }
   public String getWhistle() {
      return whistle;
   }
   public void setWhistle(String whistle) {
      this.whistle = whistle;
   }
   public Boolean getFlammable() {
      return flammable;
   }
   public void setFlammable(Boolean flammable) {
      this.flammable = flammable;
   }

}
