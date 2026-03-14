import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToHome extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private BankSystem bankSystem;

    public BackToHome(BankSystem bankSystem) {

            this.bankSystem = bankSystem;

            setContentPane(panel1);
            setTitle("Back to Home");
            setSize(800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(bankSystem).setVisible(true);
                dispose();
            }
        });
    }
}
