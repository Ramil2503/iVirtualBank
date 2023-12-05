package model.bank;

import java.util.List;
import java.util.ArrayList;

import model.account.Account;

public class AccountManager {
    private List<Account> accountList;

    public AccountManager(List<Account> accountList) {
        this.accountList = accountList;
    }

    public AccountManager() {
        this(new ArrayList<>());
    }
    
    public void test1() {
        accountList = new ArrayList<>();
        Account test1 = new Account(0, "aaa", 0);
        accountList.add(test1);

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    
}
