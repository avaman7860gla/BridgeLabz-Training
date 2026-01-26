// SmartHomeLighting.java
// Demonstrates lambda expressions for smart home lighting automation

interface LightAction {
    void activate();
}

public class SmartHomeLightingApp {

    public static void main(String[] args) {

        // Lambda for motion detection
        LightAction motionTrigger = () -> {
            System.out.println("Motion detected!");
            System.out.println("Lights turned ON at medium brightness.");
        };

        // Lambda for night time
        LightAction nightTrigger = () -> {
            System.out.println("It's night time.");
            System.out.println("Lights turned ON with warm and dim lighting.");
        };

        // Lambda for voice command
        LightAction voiceTrigger = () -> {
            System.out.println("Voice command received: 'Turn on lights'");
            System.out.println("All lights turned ON at full brightness.");
        };

        // Simulating different triggers
        System.out.println("---- Smart Home Lighting System ----\n");

        motionTrigger.activate();
        System.out.println();

        nightTrigger.activate();
        System.out.println();

        voiceTrigger.activate();
    }
}
