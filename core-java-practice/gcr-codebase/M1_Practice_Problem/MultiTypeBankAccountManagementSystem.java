package M1_Practice_Problem;

import java.util.*;

class Account {
    String accountNumber;
    String holderName;
    double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }

    public void deposit(int amount) {
        balance+=amount;
    }

    public boolean withdraw(int amount) {
        return false;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(int amount) {
        double total=amount+2;
        if(balance-total<0){
            return false;
        }
        balance-=total;
        return true;
    }
}

class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(int amount) {
        double total=amount+5;
        if(balance-total<-10000){
            return false;
        }
        balance-=total;
        return true;
    }
}

class BusinessAccount extends Account {

    public BusinessAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(int amount) {
        double total=amount+(0.01*amount);
        if(balance-total<-50000){
            return false;
        }
        balance-=total;
        return true;
    }
}

class BankManager {

    List<Account> accountList = new ArrayList<>();

    // CREATE ACCOUNT
    public void createAccount(String accNo, String name, String type, int balance) {
        if(type.equals("SavingsAccount")){
            Account acc=new SavingsAccount(accNo, name, balance);
            accountList.add(acc);
            System.out.println("Account Created: "+accNo);
            return;
        }
        if(type.equals("CurrentAccount")){
            Account acc=new CurrentAccount(accNo, name, balance);
            accountList.add(acc);
            System.out.println("Account Created: "+accNo);
            return;
        }
        if(type.equals("BusinessAccount")){
            Account acc=new BusinessAccount(accNo, name, balance);
            accountList.add(acc);
            System.out.println("Account Created: "+accNo);
        }
    }

    // DEPOSIT
    public void deposit(String accNo, int amount) {
        for(Account acc:accountList){
            if(acc.accountNumber.equals(accNo)){
                acc.deposit(amount);
                System.out.println("Deposited Successfully");
                return;
            }
        }
        System.out.println("Account Not Found");
    }

    // WITHDRAW
    public void withdraw(String accNo, int amount) {
        for(Account acc:accountList){
            if(acc.accountNumber.equals(accNo)){
                boolean success=acc.withdraw(amount);
                if(success){
                    System.out.println("Withdrawal Successful");
                }
                else{
                    System.out.println("Insufficient Funds");
                }
                return;
            }
        }
        System.out.println("Account Not Found");
    }
}

public class MultiTypeBankAccountManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager manager = new BankManager();

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            switch (command) {

                case "Create": {
                    manager.createAccount(parts[1], parts[2], parts[3], Integer.parseInt((parts[4])));
                    break;
                }

                case "Deposit": {
                    manager.deposit(parts[1], Integer.parseInt(parts[2]));
                    break;
                }

                case "Withdraw": {
                    manager.withdraw(parts[1], Integer.parseInt(parts[2]));
                    break;
                }
            }
        }
    }
}
