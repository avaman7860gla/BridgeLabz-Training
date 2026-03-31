// interface
interface LightAction {
    void activate();
}

public class SmartHomeLightingApp {

    public static void main(String[] args) {

        // lambda for motion detection
        LightAction motionTrigger = () -> {
            System.out.println("Motion detected");
            System.out.println("Lights turned ON at medium brightness");
        };

        // lambda for night time
        LightAction nightTrigger = () -> {
            System.out.println("Its night time");
            System.out.println("Lights turned ON with warm and dim lighting");
        };

        // lambda for voice command
        LightAction voiceTrigger = () -> {
            System.out.println("Voice command received: Turn on lights");
            System.out.println("All lights turned ON at full brightness");
        };

        // simulating different triggers
        System.out.println("Smart Home Lighting System:");

        motionTrigger.activate();
        System.out.println();

        nightTrigger.activate();
        System.out.println();

        voiceTrigger.activate();
    }
}
