// Custom marker interface
interface SensitiveData {
}

// Bank account class
class BankAccount implements SensitiveData {
    String accountNumber;
    double balance;

    // contructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

public class SecurityCheckDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC12345", 500000);

        if (account instanceof SensitiveData) {
            System.out.println("Sensitive data detected");
            System.out.println("Applying encryption before storage");
        } 
        else {
            System.out.println("No encryption required");
        }
    }
}
