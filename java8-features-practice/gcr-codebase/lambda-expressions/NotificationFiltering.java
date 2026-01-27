import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {

    public static void main(String[] args) {

        // arraylist
        List<String> alerts = new ArrayList<>();
        alerts.add("Emergency: Patient heart rate high");
        alerts.add("Reminder: Take medicine");
        alerts.add("Info: Visiting hours updated");
        alerts.add("Emergency: Blood pressure critical");
        alerts.add("General: Hospital event");

        // user wants only emergency alerts
        Predicate<String> emergencyOnly = alert -> alert.startsWith("Emergency");

        System.out.println("Showing only emergency alerts:");

        // display
        for (String alert : alerts) {
            if (emergencyOnly.test(alert)) {
                System.out.println(alert);
            }
        }
    }
}
