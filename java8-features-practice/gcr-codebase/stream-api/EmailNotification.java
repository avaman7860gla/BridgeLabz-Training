import java.util.*;

public class EmailNotification {

    // method to send email notification
    public static void sendEmailNotification(String email) {
        System.out.println("Email sent: " + email);
    }

    public static void main(String[] args) {
        // list of emails
        List<String> emails = List.of("user1@gmail.com", "user2@gmail.com", "user3@gmail.com");

        emails.forEach(email -> sendEmailNotification(email));
    }
}
