package model.file_handler;

import model.account.Account;

import java.util.List;

public interface SaveToFile {
    public boolean saveToFile(List<Account> accountList);
    public List<Account> loadFromFile();
}
