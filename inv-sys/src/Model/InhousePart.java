package Model;

public class InhousePart extends Part {
   private int machineId;
   
    //InHousePart constructor
 
   public InhousePart(int id, String name, double price, int stock, int min, int max, int machineId) {
             
       super(id, name, price, stock, min, max);
       this.machineId = machineId;
   }

   //MachineID Getter/Setter
   public int getMachineId() {
       return machineId;
   }

   public void setMachineId(int machineId) {
       this.machineId = machineId;
   }
       
}
