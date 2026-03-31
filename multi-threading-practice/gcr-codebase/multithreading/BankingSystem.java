import java.time.LocalTime;

class BankAccount {
    int balance = 10000;

    // method to withdraw
    void withdraw(String customer, int amount) {
        System.out.println(customer + " Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Transaction successful: " + customer +", Amount: " + amount +", Balance: " + balance +
                    ", Time: " + LocalTime.now());
        } 
        else {
            System.out.println("Transaction failed: " + customer +", Insufficient balance, Time: " + LocalTime.now());
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    // constructor
    public Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    // override run method
    @Override
    public void run() {
        System.out.println(customer + " Thread State: " + Thread.currentThread().getState());
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        int[] amounts = {3000, 4000, 2000, 5000, 1500};
        for (int i = 0; i < amounts.length; i++) {
            Thread t = new Thread(new Transaction(account, "Customer-" + (i + 1), amounts[i]),"Customer-" + (i + 1));
            t.start();
        }
    }
}
