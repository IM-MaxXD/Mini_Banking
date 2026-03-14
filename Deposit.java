import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Deposit extends JFrame {

    private JPanel deposit;
    private JTextField amout;
    private JButton depositButton;
    private JLabel debug;
    private JButton back;

    private BankSystem bankSystem;

    public Deposit(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(deposit);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);

        amout.setText("0.00");

        depositButton.addActionListener(e -> {

            try{

                double amount = Double.parseDouble(amout.getText());

                if(amount <= 0){
                    debug.setText("Amount must be greater than 0");
                    return;
                }

                Account account = bankSystem.getCurrentAccount();

                account.deposit(amount);

                FileManager.updateAccount(account);

                new BackToHome(bankSystem).setVisible(true);
                dispose();

            }catch(Exception ex){
                debug.setText("Invalid amount");
            }

        });
        amout.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (amout.getText().equals("0.00")) {
                    amout.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (amout.getText().isEmpty()) {
                    amout.setText("0.00");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(bankSystem).setVisible(true);
                dispose();
            }
        });
    }
}