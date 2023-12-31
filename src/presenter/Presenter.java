package presenter;

import java.time.LocalDate;

import view.View;
import model.user.Gender;
import model.bank.AccountManager;
import model.file_handler.FileHandler;
import model.file_handler.SaveToFile;

public class Presenter {
    private View view;
    private AccountManager accountManager;
    private SaveToFile fileHandler;

    public Presenter(View view) {
        this.view = view;
        fileHandler = new FileHandler();
        accountManager = new AccountManager(fileHandler.loadFromFile());
    }

    public void createAccount(String userName, String ownerName, String password, Gender userGender, LocalDate birthDate) {
        accountManager.createAccount(userName, ownerName, password, userGender, birthDate);
        fileHandler.saveToFile(accountManager.getAccountList());
    }
    public boolean nameChecker(String name) {
        return accountManager.nameChecker(name);
    }

    public long logIn(String name, String password) {
        return accountManager.signIn(name, password);
    }

    public String viewInformation(long accountNumber) {
        return accountManager.viewInformation(accountNumber);
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
