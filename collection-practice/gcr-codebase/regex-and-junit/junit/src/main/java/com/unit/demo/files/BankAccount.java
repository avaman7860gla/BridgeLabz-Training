package com.unit.demo.files;

public class BankAccount {

    private double balance;

    // constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // withdraw method
    public boolean withdraw(double amount) {
        if (amount > balance || amount <= 0) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // method to get balance
    public double getBalance() {
        return balance;
    }
}
