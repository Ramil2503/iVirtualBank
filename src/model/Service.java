package model;

import model.bank.AccountManager;
import model.file_handler.FileHandler;
import model.file_handler.SaveToFile;

public class Service {
    public Service() {
        AccountManager accountManager = new AccountManager();
        SaveToFile saveToFile = new FileHandler();
        accountManager.test1();
        saveToFile.saveToFile(accountManager.getAccountList());
    }
}
