// Base class
class Device {
    String deviceId;
    String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}


class Thermostat extends Device {
    int temperatureSetting;

    // Constructor 
    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status); 
        this.temperatureSetting = temperatureSetting; 
    }

    // display thermostat details
    void displayStatus() {
        System.out.println("Device ID: " + deviceId + " Status: " + status + " Temp: " + temperatureSetting);
    }
}


public class SmartHomeDevices {
    public static void main(String[] args) {
        // Create a thermostat device
        Thermostat thermostat = new Thermostat("T1001", "Active", 24);

        // Display
        thermostat.displayStatus();
    }
}
