package model.bank;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import model.account.Account;
import model.user.Gender;

public class AccountManager {
    private List<Account> accountList;

    public AccountManager(List<Account> accountList) {
        this.accountList = accountList;
    }

    public AccountManager() {
        this(new ArrayList<>());
    }
    
    // public void test1() {
    //     Account test1 = new Account(0, "aaa", 0);
    //     accountList.add(test1);
    // }

    public void createAccount(String name, String password, Gender userGender, LocalDate birthDate) {
        long newAccountNumber = generateUniqueId();
        Account newAccount = new Account(newAccountNumber, password, name, 10000.0);
        accountList.add(newAccount);
    }

    private long generateUniqueId() {
        long lastAccountNumber = 0;
        if (!accountList.isEmpty()) {
            Account lastAccount = accountList.get(accountList.size() - 1);
            lastAccountNumber = lastAccount.getAccountNumber();
        }
        return lastAccountNumber + 1; // Incrementing the last ID to generate a new unique ID
    }

    public long signIn(String name, String password) {
        long signedAccountNumber;
        for (Account account : accountList) {
            if (account.getOwnerName().equals(name) && account.getPassword().equals(password)) {
                signedAccountNumber = account.getAccountNumber();
                return signedAccountNumber;
            }
        }
        return -1;
    }

    public double checkBalance(long accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account.getBalance();
            }
        }
        return -1.0;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    
}
