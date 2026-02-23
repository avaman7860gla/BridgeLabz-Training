import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Custom exception
class PaymentDeclinedException extends Exception{
    PaymentDeclinedException(String mssg){
        super(mssg);
    }
}

// Discount strategy interface
interface DiscountStrategy{
    public double apply(double amount);
}

class PercentageDiscount implements DiscountStrategy{
    private double percent;

    public PercentageDiscount(double percent){
        this.percent=percent;
    }

    @Override
    public double apply(double amount) {
        return amount-((percent/100)*amount);
    }
}

class FixedAmountDiscount implements DiscountStrategy{
    private double discount;

    public FixedAmountDiscount(double discount){
        this.discount=discount;
    }

    @Override
    public double apply(double amount) {
        return amount-discount;
    }
}

class Subscription{
    private LocalDate expiryDate;
    private boolean isActive;
    private DiscountStrategy discountStrategy;

    // Constructor
    public Subscription(LocalDate expiryDate, DiscountStrategy discountStrategy) {
        this.expiryDate = expiryDate;
        this.isActive = true;
        this.discountStrategy = discountStrategy;
    }

    // Getters
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isActive() {
        return isActive;
    }

    // Method to renew subscription
    public void renew() throws PaymentDeclinedException{
        if(Math.random()<0.2){
            throw new PaymentDeclinedException("Payment declined while renewal");
        }
        expiryDate=expiryDate.plusMonths(1);
        isActive=true;
    }

    // Method to apply discount
    public double applyDiscount(double amount){
        return discountStrategy.apply(amount);
    }
}

class User{
    private String userId;
    private String name;
    private Subscription subscription;

    // Constructor
    public User(String userId, String name, Subscription subscription) {
        this.userId = userId;
        this.name = name;
        this.subscription = subscription;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    // Method to renew subscription
    public void renewSubscription() throws PaymentDeclinedException {
        subscription.renew();
    }
}

class SubscriptionManager{
    private List<User> users=new ArrayList<>();

    // Method to add user
    public void addUser(User u){
        users.add(u);
    }

    // Method to auto renewal
    public void autoRenewAll() throws PaymentDeclinedException {
        for(User u:users){
            try{
                u.renewSubscription();
                System.out.println("Renewed subscription for " + u.getName());
            }
            catch (PaymentDeclinedException e){
                System.out.println(u.getName()+" - "+e.getMessage());
            }
        }
    }

    // Method to find expired accounts
    public List<User> findExpiredAccounts(){
        return users.stream().filter(u->u.getSubscription().getExpiryDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
}

public class DigitalSubscriptionRenewalSystem {
    public static void main(String[] args) throws PaymentDeclinedException {
        SubscriptionManager manager = new SubscriptionManager();

        Subscription sub1 = new Subscription(LocalDate.now().minusDays(1), new PercentageDiscount(10));
        Subscription sub2 = new Subscription(LocalDate.now().plusDays(10), new FixedAmountDiscount(50));
        Subscription sub3 = new Subscription(LocalDate.now().plusDays(5), new PercentageDiscount(20));
        User user1 = new User("U001", "Aman", sub1);
        User user2 = new User("U002", "Amit", sub2);
        User user3 = new User("U003", "Rahul", sub3);

        manager.addUser(user1);
        manager.addUser(user2);
        manager.addUser(user3);

        System.out.println("Expired Accounts Before Renewal:");
        List<User> expiredBefore = manager.findExpiredAccounts();
        for (User u : expiredBefore) {
            System.out.println(u.getName() + " (Expiry: " + u.getSubscription().getExpiryDate() + ")");
        }

        System.out.println("\nAuto renewing subscriptions");
        manager.autoRenewAll();

        System.out.println("\nExpired Accounts After Renewal");
        List<User> expiredAfter = manager.findExpiredAccounts();
        if (expiredAfter.isEmpty()) {
            System.out.println("No expired accounts");
        }
        else{
            for (User u : expiredAfter) {
                System.out.println(u.getName() + " (Expiry: " + u.getSubscription().getExpiryDate() + ")");
            }
        }

        double basePrice = 500.0;
        System.out.println("\nApplying Discounts:");
        System.out.println(user1.getName() + " pays: " + user1.getSubscription().applyDiscount(basePrice));
        System.out.println(user2.getName() + " pays: " + user2.getSubscription().applyDiscount(basePrice));
        System.out.println(user3.getName() + " pays: " + user3.getSubscription().applyDiscount(basePrice));
    }
}


