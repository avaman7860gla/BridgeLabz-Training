import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class WaterTank{
    private int tankId;
    private double tankCapacity;
    private double currentLevel;

    // Constructor
    public WaterTank(int tankId, double tankCapacity, double currentLevel) throws InvalidWaterLevelException{
        this.tankId=tankId;
        this.tankCapacity=tankCapacity;
        setCurrentLevel(currentLevel);
    }

    // Getters
    public int getTankId() {
        return tankId;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    // Override toString method
    @Override
    public String toString() {
        return "WaterTank{" +
                "tankId=" + tankId +
                ", tankCapacity=" + tankCapacity +
                ", currentLevel=" + currentLevel +
                '}';
    }

    // Method to set current level
    public void setCurrentLevel(double currentLevel) throws InvalidWaterLevelException{
        if(currentLevel>tankCapacity){
            throw new InvalidWaterLevelException("current level exceed from tank capacity for tank id: "+tankId);
        }
        this.currentLevel=currentLevel;
    }

    // Method to get usage percentage
    public double getUsagePercentage(){
        return (currentLevel/tankCapacity)*100;
    }

    // Method to check alert triggered or not
    public boolean isAlertTriggered(){
        return getUsagePercentage()<20;
    }
}

// Custom exception
class InvalidWaterLevelException extends Exception{
    InvalidWaterLevelException(String mssg){
        super(mssg);
    }
}

class Utility{
    private List<WaterTank> tanks=new ArrayList<>();

    // Method to add tanks
    public void addTank(WaterTank tank){
        tanks.add(tank);
    }

    // Method to sort tanks by lowest level
    public List<WaterTank> sortTanksByLowestLevel(){
        return tanks.stream().sorted(Comparator.comparing(WaterTank::getCurrentLevel)).collect(Collectors.toList());
    }

    // Method to check alerts
    public void checkAlerts(){
        for(WaterTank tank:tanks){
            if(tank.isAlertTriggered()){
                System.out.println("Alert: Tank "+tank.getTankId()+" is below 20% capacity");
            }
            else{
                System.out.println("No alert in tank "+tank.getTankId());
            }
        }
    }

    // Method to display tanks
    public void displayTanks(){
        for(WaterTank tank:tanks){
            System.out.println(tank);
        }
    }
}

public class SmartWaterTankMonitoringSystem {
    public static void main(String[] args) throws InvalidWaterLevelException {

        Utility util=new Utility();
        try{
            WaterTank t1=new WaterTank(1,1000,500);
            WaterTank t2=new WaterTank(2,500,90);
            WaterTank t3=new WaterTank(3,750,500);

            util.addTank(t1);
            util.addTank(t2);
            util.addTank(t3);

            System.out.println("Display all tanks: ");
            util.displayTanks();

            System.out.println("\nDisplay alerts: ");
            util.checkAlerts();

            System.out.println("\nSorted tanks by lowest level: ");
            List<WaterTank> list=util.sortTanksByLowestLevel();
            for(WaterTank tank:list){
                System.out.println(tank);
            }
        }
        catch (InvalidWaterLevelException e){
            System.out.println(e.getMessage());
        }
    }
}
