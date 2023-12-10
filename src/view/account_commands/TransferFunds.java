package view.account_commands;

import view.ConsoleUI;

public class TransferFunds implements AccountCommand {
    private ConsoleUI console;

    public TransferFunds(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Transfer Funds";
    }

    public void execute(long accountNumber){
        console.transferFunds(accountNumber);
    }
}
