import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Custom exception
class SensorFailureException extends Exception{
    SensorFailureException(String mssg){
        super(mssg);
    }
}

class TemperatureLog{
    private List<Double> readings=new ArrayList<>();

    // Method to add reading
    public void addReading(double temp){
        readings.add(temp);
    }

    // Getter
    public List<Double> getReadings(){
        return readings;
    }

    // Method to get daily average
    public double getDailyAverage(){
        return readings.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
}

class Room{
    private String roomId;
    private TemperatureLog log;

    // Constructor
    public Room(String roomId, TemperatureLog log){
        this.roomId=roomId;
        this.log=log;
    }

    // Getters
    public String getRoomId() {
        return roomId;
    }

    public TemperatureLog getLog() {
        return log;
    }
}

interface Altertable{
    void checkTemperature(double temp) throws SensorFailureException;
}

class WarehouseMonitor implements Altertable{
    private Map<String, TemperatureLog> rooms=new HashMap<>();
    private double safeMin;
    private double safeMax;

    // Constructor
    public WarehouseMonitor(double safeMin, double safeMax){
        this.safeMin=safeMin;
        this.safeMax=safeMax;
    }

    // Override method to check temperature
    @Override
    public void checkTemperature(double temp) throws SensorFailureException{
        if(temp<safeMin || temp>safeMax){
            throw new SensorFailureException("Temperature out of range "+temp);
        }
    }

    // Method to add room
    public void addRoom(String roomId){
        rooms.put(roomId, new TemperatureLog());
    }

    // Method to record temperature
    public void recordTemperature(String roomId, double t) throws SensorFailureException{
        if(!rooms.containsKey(roomId)){
            throw new SensorFailureException("Sensor fails in room "+roomId);
        }
        checkTemperature(t);
        rooms.get(roomId).addReading(t);
    }

    // Method to get daily average
    public double getDailyAverage(String roomId){
        return rooms.get(roomId).getDailyAverage();
    }

    // Method to get all rooms
    public Map<String ,TemperatureLog> getRooms(){
        return rooms;
    }
}

public class WarehouseColdStorageTemperatureMonitor {
    public static void main(String[] args) {
        WarehouseMonitor monitor=new WarehouseMonitor(20, 30);
        monitor.addRoom("A");
        monitor.addRoom("B");
        try{
            monitor.recordTemperature("A", 25);
            monitor.recordTemperature("A", 20);
            monitor.recordTemperature("A", 27);

            monitor.recordTemperature("B", 23);
            monitor.recordTemperature("B", 21);
            monitor.recordTemperature("B", 35);
        }
        catch (SensorFailureException e){
            System.out.println(e.getMessage());
        }

        try {
            double tempToCheck = 28;
            monitor.checkTemperature(tempToCheck);
            monitor.recordTemperature("A", tempToCheck);
            System.out.println("Temperature "+tempToCheck+" recorded safely in Room A.");
        }
        catch (SensorFailureException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nDaily Average of room A: "+monitor.getDailyAverage("A"));
        System.out.println("Daily Average of room B: "+monitor.getDailyAverage("B"));

        System.out.println("\nAll Readings:");
        for (String roomId:monitor.getRooms().keySet()) {
            System.out.println("Room "+roomId+" readings: "+monitor.getRooms().get(roomId).getReadings());
        }
    }
}

