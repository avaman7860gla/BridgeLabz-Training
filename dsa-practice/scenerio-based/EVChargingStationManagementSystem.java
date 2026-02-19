import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Vehicles{
    private int vehicleId;
    private String ownerName;

    public Vehicles(int vehicleId, String ownerName) {
        this.vehicleId = vehicleId;
        this.ownerName = ownerName;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getOwnerName() {
        return ownerName;
    }
}

class ChargingSlot{
    private int slotId;
    boolean isOccupied;
    double unitsConsumed;

    public ChargingSlot(int slotId) {
        this.slotId = slotId;
        this.unitsConsumed = 0;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void assignVehicle(Vehicles v){
        this.isOccupied=true;
        this.unitsConsumed=Math.random()*20+5;
    }

    public void releaseSlot(){
        isOccupied=false;
        unitsConsumed=0;
    }
}

interface PricingStrategy{
    public double calculateBill(double units);
}

class NormalPricing implements PricingStrategy{

    @Override
    public double calculateBill(double units) {
        return units*5;
    }
}

class PeakHourPricing implements PricingStrategy{

    @Override
    public double calculateBill(double units) {
        return units*10;
    }
}

class NoChargingSlotAvailableException extends Exception{
    NoChargingSlotAvailableException(String mssg){
        super(mssg);
    }
}

class StationManager{
    private Map<Integer, ChargingSlot> stations=new HashMap<>();
    private Queue<Vehicles> waitingQueue=new LinkedList<>();
    private PricingStrategy pricingStrategy;

    public void bookSlot(Vehicles vehicle) throws NoChargingSlotAvailableException{
        ChargingSlot freeSlot=null;
        for(ChargingSlot slot:stations.values()){
            if(!slot.isOccupied()){
                freeSlot=slot;
                break;
            }
        }
        if(freeSlot!=null){
            freeSlot.assignVehicle(vehicle);
            System.out.println(vehicle.getOwnerName() + " assigned to slot " + freeSlot.getSlotId());
        }
        else{
            waitingQueue.add(vehicle);
            throw new NoChargingSlotAvailableException("No slot available");
        }
    }

    public void releaseSlot(int slotId){
        ChargingSlot slot=stations.get(slotId);
        slot.releaseSlot();
        System.out.println("Slot " + slotId + " released");
        if(!waitingQueue.isEmpty()){
            Vehicles next=waitingQueue.poll();
            try{
                bookSlot(next);
            }
            catch (NoChargingSlotAvailableException e){
                System.out.println(next.getOwnerName()+" still waiting");
            }
        }
    }

    public double calculateBill(int slotId){
        ChargingSlot slot=stations.get(slotId);
        return pricingStrategy.calculateBill(slot.getUnitsConsumed());
    }

    public void setPricingStrategy(PricingStrategy strategy){
        this.pricingStrategy=strategy;
    }
    public Map<Integer, ChargingSlot> getStations() {
        return stations;
    }

}

public class EVChargingStationManagementSystem {
    public static void main(String[] args) {
        StationManager manager=new StationManager();

        manager.getStations().put(1, new ChargingSlot(1));
        manager.getStations().put(2, new ChargingSlot(2));

        manager.setPricingStrategy(new NormalPricing());

        Vehicles v1 = new Vehicles(101, "Aman");
        Vehicles v2 = new Vehicles(102, "Riya");
        Vehicles v3 = new Vehicles(103, "Karan");

        try{
            manager.bookSlot(v1);
            manager.bookSlot(v2);
            manager.bookSlot(v3);
        }
        catch (NoChargingSlotAvailableException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBill for normal pricing:");
        System.out.println("Bill for slot 1: "+manager.calculateBill(1));
        System.out.println("Bill for slot 2: "+manager.calculateBill(2));

        manager.setPricingStrategy(new PeakHourPricing());

        System.out.println("\nBill for normal pricing:");
        System.out.println("Bill for slot 1: "+manager.calculateBill(1));
        System.out.println("Bill for slot 2: "+manager.calculateBill(2));

        manager.releaseSlot(1);
    }
}
