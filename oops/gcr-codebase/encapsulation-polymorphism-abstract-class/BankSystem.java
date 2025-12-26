// abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    //constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    //getters
    public String getAccountNumber() { 
        return accountNumber; 
    }
    public String getHolderName() { 
        return holderName; 
    }
    public double getBalance() { 
        return balance; 
    }

    // methods
    public void deposit(double amount) { 
        balance += amount; 
    }
    public void withdraw(double amount) { 
        if (balance >= amount) 
            balance -= amount; 
        }

    // abstract method
    public abstract double calculateInterest();
}

// interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// subclasses
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    // method implementations
    public double calculateInterest() { 
        return getBalance() * 0.04; 
    }
    public void applyForLoan(double amount) { 
        System.out.println("Savings Loan Applied: " + amount); 
    }
    public boolean calculateLoanEligibility() { 
        return getBalance() > 10000; 
    }
}
// another subclass
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // method implementations
    public double calculateInterest() { 
        return getBalance() * 0.02; 
    }
    public void applyForLoan(double amount) { 
        System.out.println("Current Loan Applied: " + amount); 
    }
    public boolean calculateLoanEligibility() { 
        return getBalance() > 20000;
    }
}

// utility class
class BankingSystem {
    public static void processAccounts(BankAccount[] accounts) {

        // polymorphism 
        for (BankAccount acc : accounts) {
            System.out.println(acc.getHolderName() + " Interest: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                System.out.println("Loan Eligible: " + ((Loanable)acc).calculateLoanEligibility());
            }
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        // create accounts
        BankAccount[] accounts = {
            new SavingsAccount("S111", "John", 15000),
            new CurrentAccount("C222", "Jane", 25000)
        };
        // process accounts
        System.out.println("Banking System:");
        BankingSystem.processAccounts(accounts);
    }
}
