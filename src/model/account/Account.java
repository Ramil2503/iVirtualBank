package model.account;

public class Account {
    private long accountNumber;
    private String password;
    private String ownerName;
    private double balance;

    public Account(long accountNumber, String password, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account number = " + accountNumber + "\nPassword = *******" + "\nOwner name = " + ownerName
                + "\nBalance = " + balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
