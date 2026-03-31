// Base class
class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor
    SavingsAccount(String accNo, double bal, double rate) {
        super(accNo, bal); 
        this.interestRate = rate; 
    }

    // display account type
    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    // Constructor
    CheckingAccount(String accNo, double bal, double limit) {
        super(accNo, bal); 
        this.withdrawalLimit = limit;
    }

    // display account type
    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;

    FixedDepositAccount(String accNo, double bal, int period) {
        super(accNo, bal);
        this.maturityPeriod = period; // initialize maturityPeriod
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        // Create different types of accounts
        SavingsAccount savings = new SavingsAccount("SAC123", 5000.0, 4.5);
        CheckingAccount checking = new CheckingAccount("CAD456", 3000.0, 1000.0);
        FixedDepositAccount fd = new FixedDepositAccount("FDO789", 10000.0, 12);

        // Display account types
        savings.displayAccountType();
        checking.displayAccountType();
        fd.displayAccountType();

        // Print details of each account
        System.out.println("Account Number = " + savings.accountNumber + " Balance = " + savings.balance + " Interest Rate =  " + savings.interestRate);
        System.out.println("Account Number = " + checking.accountNumber + " Balance = " + checking.balance + " Withdrawal Limit = " + checking.withdrawalLimit);
        System.out.println("Account Number = " + fd.accountNumber + " Balance = " + fd.balance + " Maturity Period = " + fd.maturityPeriod);
    }
}
