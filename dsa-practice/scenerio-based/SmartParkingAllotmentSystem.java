import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Custom Exception
class NoParkingSlotAvailableException extends Exception{
    NoParkingSlotAvailableException(String mssg){
        super(mssg);
    }
}

abstract class Vehicle{
    private String vehicleId;

    // Constructor
    public Vehicle(String vehicleId){
        this.vehicleId=vehicleId;
    }

    // Getter
    public String getVehicleId(){
        return vehicleId;
    }

    // Abstract method
    public abstract String getType();
}

class Car extends Vehicle{

    // Constructor
    public Car(String vehicleId) {
        super(vehicleId);
    }

    // Override method
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike extends Vehicle{
    // Constructor
    public Bike(String vehicleId) {
        super(vehicleId);
    }

    // Override method
    @Override
    public String getType() {
        return "Bike";
    }
}

class ParkingSlot{
    private int slotId;
    private boolean isOccupied;
    private String allowedType;

    // Constructor
    public ParkingSlot(int slotId, String allowedType){
        this.slotId=slotId;
        this.allowedType=allowedType;
        this.isOccupied=false;
    }

    // Getters
    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getAllowedType() {
        return allowedType;
    }

    // Method to occupy slot 
    public void occupySlot(Vehicle v){
        this.isOccupied=true;
        allowedType=v.getType();
        System.out.println("Slot " +slotId +" occupy by "+v.getType()+" with id "+v.getVehicleId());
    }

    // Method to free slot
    public void freeSlot(){
        this.isOccupied=false;
        System.out.println("Slot "+slotId+" is free");
    }
}

class ParkingManager{
    private Map<Integer, ParkingSlot> slots=new HashMap<>();
    private Queue<Vehicle> waitingQueue=new LinkedList<>();

    // Method to add slot
    public void addSlot(ParkingSlot slot){
        slots.put(slot.getSlotId(), slot);
    }

    // Method to add vehicle in waiting queue
    public void addToWaitingQueue(Vehicle v){
        waitingQueue.offer(v);
    }

    // Method to process waiting queue
    public void processWaitingQueue(){
        if(!waitingQueue.isEmpty()){
            Vehicle v= waitingQueue.poll();
            try{
                allocateSlot(v);
            }
            catch (NoParkingSlotAvailableException e){
                System.out.println("Still no slot for " +v.getType()+ " and vehicle id " +v.getVehicleId());
                waitingQueue.add(v);
            }
        }
    }

    // Method to allocate slot
    public void allocateSlot(Vehicle v) throws NoParkingSlotAvailableException{
        for(ParkingSlot slot:slots.values()){
            if(!slot.isOccupied() && slot.getAllowedType().equals(v.getType())){
                slot.occupySlot(v);
                return;
            }
        }
        throw new NoParkingSlotAvailableException("No slot available for "+v.getType());
    }

    // Method to release slot
    public void releaseSlot(int slotId){
        ParkingSlot slot=slots.get(slotId);
        if(slot!=null && slot.isOccupied()){
            slot.freeSlot();
            processWaitingQueue();
        }
    }
}

public class SmartParkingAllotmentSystem {
    public static void main(String[] args) {
        ParkingManager manger=new ParkingManager();

        manger.addSlot(new ParkingSlot(1, "Car"));
        manger.addSlot(new ParkingSlot(2, "Car"));
        manger.addSlot(new ParkingSlot(3, "Bike"));

        Vehicle car1=new Car("C101");
        Vehicle car2=new Car("C102");
        Vehicle car3=new Car("C103");
        Vehicle bike1=new Bike("B201");
        Vehicle bike2=new Bike("B202");

        try{
            manger.allocateSlot(car1);
            manger.allocateSlot(car2);
            manger.allocateSlot(bike1);

            try{
                manger.allocateSlot(car3);
            }
            catch (NoParkingSlotAvailableException e){
                System.out.println("Car3 waiting: "+e.getMessage());
                manger.addToWaitingQueue(car3);
            }

            try{
                manger.allocateSlot(bike2);
            }
            catch (NoParkingSlotAvailableException e){
                System.out.println("Bike2 waiting: "+e.getMessage());
                manger.addToWaitingQueue(bike2);
            }

            manger.releaseSlot(2);
            manger.releaseSlot(3);
        }
        catch (NoParkingSlotAvailableException e){
            System.out.println(e.getMessage());
        }
    }
}

