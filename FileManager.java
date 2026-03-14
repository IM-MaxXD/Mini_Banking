import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_NAME = "account.txt";

    // สร้างบัญชีใหม่
    public static void createAccount(String accountId, String pin) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(accountId + ",0.0," + pin);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // login
    public static Account loadAccount(String accountId, String pin) {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if(line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                String fileId = data[0];
                double balance = Double.parseDouble(data[1]);
                String filePin = data[2];

                if (fileId.equals(accountId) && filePin.equals(pin)) {

                    Account account = new Account(fileId, filePin);
                    account.setBalance(balance);

                    return account;

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // อัปเดต balance
    public static void updateAccount(Account account) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if(line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data[0].equals(account.getAccountId())) {

                    line = data[0] + "," + account.getBalance() + "," + data[2];

                }

                lines.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String l : lines) {

                writer.write(l);
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}