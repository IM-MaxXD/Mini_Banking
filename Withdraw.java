import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Withdraw extends JFrame {

    private JTextField amout;
    private JButton withdrawButton;
    private JLabel debug;
    private JButton back;
    private JPanel wtihDraw;

    private BankSystem bankSystem;

    public Withdraw(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(wtihDraw);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);

        amout.setText("0.00");

        withdrawButton.addActionListener(e -> {

            try{

                double amount = Double.parseDouble(amout.getText());

                if(amount <= 0){
                    debug.setText("Amount must be greater than 0");
                    return;
                }

                Account account = bankSystem.getCurrentAccount();

                if(account.withdraw(amount)){

                    FileManager.updateAccount(account);

                    new BackToHome(bankSystem).setVisible(true);
                    dispose();

                }else{
                    debug.setText("Insufficient balance");
                }

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