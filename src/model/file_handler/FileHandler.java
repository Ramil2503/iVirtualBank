package model.file_handler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.account.Account;

public class FileHandler implements SaveToFile {
    private static String filePath = "accounts_data.csv";
    private static final String CSV_HEADER = "AccountNumber,OwnerName,Balance";

    public boolean saveToFile(List<Account> accountList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(CSV_HEADER);
            writer.newLine();

            for (Account account : accountList) {
                writer.write(account.getAccountNumber() + "," + account.getOwnerName() + "," + account.getBalance());
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> loadFromFile() {
        List<Account> accountList = new ArrayList<>();

        try {
            createFileIfNotExists();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;
            
            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    int accountNumber = Integer.parseInt(data[0]);
                    String ownerName = data[1];
                    double balance = Double.parseDouble(data[2]);

                    Account account = new Account(accountNumber, ownerName, balance);
                    accountList.add(account);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    private void createFileIfNotExists() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
