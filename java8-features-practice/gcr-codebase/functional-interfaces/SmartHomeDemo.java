// Interface
interface SmartDevice {
    void turnOn();
    void turnOff();
}

// Light class
class Light implements SmartDevice {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// AC class
class AC implements SmartDevice {
    public void turnOn() {
        System.out.println("AC is turned ON");
    }

    public void turnOff() {
        System.out.println("AC is turned OFF");
    }
}

// TV class
class TV implements SmartDevice {
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AC();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}
