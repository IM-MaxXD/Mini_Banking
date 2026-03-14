import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MainMenu extends JFrame {

    private JPanel mainMenu;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transactionsButton;
    private JButton logOutButton;
    private JLabel backgrind;

    private JLabel balanceLabel;
    private JLabel balanceAmount;
    private JLabel accountLabel;

    private BankSystem bankSystem;

    public MainMenu(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(mainMenu);
        setTitle("Main Menu");
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);


        mainMenu.setLayout(null);

        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(135,100,200,30);
        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD,25));
        balanceLabel.setForeground(Color.WHITE);
        mainMenu.add(balanceLabel);

        balanceAmount = new JLabel("0.00");
        balanceAmount.setBounds(135,165,200,40);
        balanceAmount.setFont(new Font("Segoe UI", Font.BOLD,32));
        balanceAmount.setForeground(Color.WHITE);
        mainMenu.add(balanceAmount);

        accountLabel = new JLabel("******0000");
        accountLabel.setBounds(135,250,200,30);
        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD,20));
        accountLabel.setForeground(Color.WHITE);
        mainMenu.add(accountLabel);

        mainMenu.setComponentZOrder(balanceLabel, 0);
        mainMenu.setComponentZOrder(balanceAmount, 0);
        mainMenu.setComponentZOrder(accountLabel, 0);

        updateAccountInfo();

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deposit(bankSystem).setVisible(true);
                dispose();
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Withdraw(bankSystem).setVisible(true);
                dispose();
            }
        });
        transactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionLog(bankSystem).setVisible(true);
                dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logout().setVisible(true);
                dispose();
            }
        });
    }

    private void updateAccountInfo(){
        DecimalFormat df = new DecimalFormat("###,###,###,##0.00");

        Account account = bankSystem.getCurrentAccount();

        balanceAmount.setText(df.format(account.getBalance()));

        String id = account.getAccountId();
        String masked = "******" + id.substring(id.length()-4);

        accountLabel.setText(masked);
    }
}