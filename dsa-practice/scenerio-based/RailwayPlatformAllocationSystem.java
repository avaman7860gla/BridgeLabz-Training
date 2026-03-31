import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Custom exception
class PlatformUnavailableException extends Exception{
    PlatformUnavailableException(String mssg){
        super(mssg);
    }
}

class Train implements Comparable<Train>{
    private String trainId;
    private int arrivalTime;

    // Constructor
    public Train(String trainId, int arrivalTime){
        this.trainId=trainId;
        this.arrivalTime=arrivalTime;
    }

    // Getters
    public String getTrainId() {
        return trainId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    // Override compare to method
    @Override
    public int compareTo(Train o) {
        return Integer.compare(this.arrivalTime, o.arrivalTime);
    }
}

class Platform{
    private int platformId;
    private boolean isOccupied;

    // Constructor
    public Platform(int platformId){
        this.platformId=platformId;
        isOccupied=false;
    }

    // Getters
    public int getPlatformId() {
        return platformId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // Method to occupy and release platform
    public void occupy(){
        isOccupied=true;
    }

    public void release(){
        isOccupied=false;
    }
}

class RailwayStation{
    private Map<Integer, Platform> platforms=new HashMap<>();
    private PriorityQueue<Train> trainQueue=new PriorityQueue<>();

    // Method to add platform
    public void addPlatform(int id){
        platforms.put(id, new Platform(id));
    }

    // Method to add train
    public void addTrain(Train t){
        trainQueue.add(t);
    }

    // Method to allocate platform
    public void allocatePlatform() throws PlatformUnavailableException {
        if (trainQueue.isEmpty()){
            return;
        }
        Train nextTrain=trainQueue.poll();
        for(Platform p:platforms.values()){
            if(!p.isOccupied()){
                p.occupy();
                System.out.println("Train "+nextTrain.getTrainId()+" allocated to platform "+p.getPlatformId());
                return;
            }
        }
        throw new PlatformUnavailableException("No available platform for train "+nextTrain.getTrainId());
    }

    // Method to release platform
    public void releasePlatform(int id){
        if(platforms.containsKey(id)){
            platforms.get(id).release();
            System.out.println("Platform " + id + " released");
        }
    }

    // Getters
    public Map<Integer, Platform> getPlatforms() {
        return platforms;
    }

    public PriorityQueue<Train> getTrainQueue() {
        return trainQueue;
    }
}

public class RailwayPlatformAllocationSystem {
    public static void main(String[] args) {
        RailwayStation station = new RailwayStation();

        station.addPlatform(1);
        station.addPlatform(2);

        station.addTrain(new Train("A", 900));   // 9:00 AM
        station.addTrain(new Train("B", 930));   // 9:30 AM
        station.addTrain(new Train("C", 915));   // 9:15 AM
        station.addTrain(new Train("D", 940));   // 9:40 AM

        try {
            station.allocatePlatform();
            station.allocatePlatform();

            station.allocatePlatform();

        }
        catch (PlatformUnavailableException e) {
            System.out.println(e.getMessage());
        }

        station.releasePlatform(1);

        try {
            station.allocatePlatform();

            station.allocatePlatform();
        }
        catch (PlatformUnavailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFinal Platform Status:");
        for(Platform p:station.getPlatforms().values()){
            System.out.println("Platform "+p.getPlatformId()+" occupied: "+p.isOccupied());
        }
    }
}

