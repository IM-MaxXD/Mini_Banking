import javax.swing.*;

public class TransactionLog extends JFrame {

    private JTextArea LogArea;
    private JButton back;
    private JPanel transactionLog;

    private BankSystem bankSystem;

    public TransactionLog(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(transactionLog);
        setTitle("Transaction Log");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loadTransactions(bankSystem.getCurrentAccount());

        back.addActionListener(e -> {

            new MainMenu(bankSystem).setVisible(true);
            dispose();

        });
    }

    public void loadTransactions(Account account){

        if(account == null){
            LogArea.setText("No account loaded");
            return;
        }

        StringBuilder log = new StringBuilder();

        for(Transaction t : account.getTransactions()){
            log.append(t.toString()).append("\n");
        }

        LogArea.setText(log.toString());
    }
}