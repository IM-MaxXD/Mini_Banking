import javax.swing.*;
import java.awt.event.*;

public class CreateForm extends JFrame{

    private JTextField AccountID;
    private JTextField Password;
    private JButton signInButton;
    private JButton back;
    private JLabel debug;
    private JPanel signInPage;

    private BankSystem bankSystem;

    public CreateForm(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(signInPage);
        setTitle("SignUp");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        AccountID.setText("Enter Account ID");
        Password.setText("Enter Password");

        Password.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (Password.getText().equals("Enter Password")) {
                    Password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Password.getText().isEmpty()) {
                    Password.setText("Enter Password");
                }
            }

        });
        AccountID.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (AccountID.getText().equals("Enter Account ID")) {
                    AccountID.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (AccountID.getText().isEmpty()) {
                    AccountID.setText("Enter Account ID");
                }
            }

        });

        signInButton.addActionListener(e -> {

            String accountID = AccountID.getText();
            String password = Password.getText();

            if(accountID.length() != 10){
                debug.setText("AccountID must be 10 digits");
                return;
            }

            if(password.length() < 4){
                debug.setText("Password must be at least 4 digits");
                return;
            }

            bankSystem.createAccount(accountID,password);

            new Successful(bankSystem).setVisible(true);
            dispose();
        });

        back.addActionListener(e -> {
            new LoginForm(bankSystem).setVisible(true);
            dispose();
        });


    }
}