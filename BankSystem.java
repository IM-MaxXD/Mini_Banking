public class BankSystem {

    private Account currentAccount;

    public boolean createAccount(String accountId, String pin) {

        currentAccount = new Account(accountId, pin);

        FileManager.createAccount(accountId, pin);

        return true;
    }

    public boolean login(String accountId, String pin) {

        Account account = FileManager.loadAccount(accountId, pin);

        if(account != null){
            currentAccount = account;
            return true;
        }

        return false;
    }

    public void logout() {
        currentAccount = null;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
}