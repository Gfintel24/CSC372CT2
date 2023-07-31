/* All attributes are private and each have getters and setters.
 *  There is also an accountSummary method which prints out each of the attributes in a formatted manner.*/

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
