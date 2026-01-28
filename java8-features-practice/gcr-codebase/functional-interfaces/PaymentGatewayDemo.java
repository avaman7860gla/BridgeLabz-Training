interface PaymentProcessor {

    public void processPayment(double amount);

    // New feature added safely
    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed using standard policy");
    }
}

// Paytm
class Paytm implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via Paytm");
    }
}

// Phonepe
class PhonePe implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via PhonePe");
    }
}

public class PaymentGatewayDemo {
    public static void main(String[] args) {

        PaymentProcessor paytm = new Paytm();
        PaymentProcessor phonePe = new PhonePe();

        paytm.processPayment(2000);
        paytm.refund(1000);

        phonePe.processPayment(500);
        phonePe.refund(100);
    }
}
