import javax.swing.*;

public class Successful extends JFrame{

    private JPanel successful;
    private JButton startButton;
    private BankSystem bankSystem;

    public Successful(BankSystem bankSystem){

        this.bankSystem = bankSystem;

        setContentPane(successful);
        setTitle("Successful");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        startButton.addActionListener(e -> {
            new MainMenu(bankSystem).setVisible(true);
            dispose();
        });
    }
}