import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        java.text.NumberFormat currencyFormat =
                java.text.NumberFormat.getNumberInstance(java.util.Locale.US);

        currencyFormat.setMinimumFractionDigits(2);
        currencyFormat.setMaximumFractionDigits(2);

        return type + " : " +
                currencyFormat.format(amount) +
                " at " +
                dateTime.format(formatter);
    }
}