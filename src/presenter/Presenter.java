package presenter;

// import java.nio.channels.AcceptPendingException;
import java.time.LocalDate;

import view.View;
import model.user.Gender;
// import model.Service;
import model.bank.AccountManager;
import model.file_handler.FileHandler;
import model.file_handler.SaveToFile;

public class Presenter {
    private View view;
    // private Service service;
    private AccountManager accountManager;
    private SaveToFile fileHandler;

    public Presenter(View view) {
        this.view = view;
        fileHandler = new FileHandler();
        accountManager = new AccountManager(fileHandler.loadFromFile());
    }

    public void createAccount(String name, String password, Gender userGender, LocalDate birthDate) {
        accountManager.createAccount(name, password, userGender, birthDate);
        fileHandler.saveToFile(accountManager.getAccountList());
    }

    public long logIn(String name, String password) {
        return accountManager.signIn(name, password);
    }

    public double checkBalance(long accountNumber) {
        return accountManager.checkBalance(accountNumber);
    }

    public int transferFunds(long accountNumber, double amount, long accountNumberTransfer) {
        int transferResult = accountManager.tranferFunds(accountNumber, amount, accountNumberTransfer);
        if (transferResult == 1) {
            fileHandler.saveToFile(accountManager.getAccountList()); // Save updated balances
        }
        return transferResult;
    }
}
