import java.util.ArrayList;
import java.util.List;

public class Account implements Transactionable {

    private String accountId;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, String pin) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean checkPin(String inputPin) {
        return pin.equals(inputPin);
    }

    public String getPin() {
        return pin;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}