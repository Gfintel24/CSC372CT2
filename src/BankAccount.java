/*
    This class holds the methods used to manage the bank account balance in the BankApp application.
*/

public class BankAccount {
    private double balance;

    public BankAccount(Double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdrawal(double amount){
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }
}
