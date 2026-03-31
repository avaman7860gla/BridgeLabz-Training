// Interface
interface Payment {
    void pay(double amount);
}

// UPI payment
class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid: " + amount + " using UPI");
    }
}

// Credit Card payment
class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid: " + amount + " using Credit Card");
    }
}

// Wallet payment
class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid: " + amount + " using Wallet");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(1000);
        card.pay(2000);
        wallet.pay(1500);
    }
}
