import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

    private JTextField AccountID;
    private JTextField Password;
    private JButton loginButton;
    private JButton createNewAccountButton;
    private JLabel debug;
    private JPanel loginPage;
    private JLabel label1;

    private BankSystem bankSystem;

    public LoginForm(BankSystem bankSystem) {

        this.bankSystem = bankSystem;



        setContentPane(loginPage);
        setTitle("Login");
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

        loginButton.addActionListener(e -> {

            String id = AccountID.getText();
            String password = Password.getText();

            if(id.length() != 10){
                debug.setText("AccountID must be 10 digits");
                return;
            }

            if(password.length() < 4){
                debug.setText("Password must be at least 4 digits");
                return;
            }

            if(bankSystem.login(id,password)){

                new Successful(bankSystem).setVisible(true);
                dispose();

            }else{
                debug.setText("Invalid AccountID or Password");
            }

        });

        createNewAccountButton.addActionListener(e -> {
            new CreateForm(bankSystem).setVisible(true);
            dispose();
        });


    }
}