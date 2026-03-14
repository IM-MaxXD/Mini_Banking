public interface Transactionable {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
}