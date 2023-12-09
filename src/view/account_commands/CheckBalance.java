package view.account_commands;

import view.ConsoleUI;

public class CheckBalance implements AccountCommand {
    private ConsoleUI console;

    public CheckBalance(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Check Balance";
    }

    public void execute(long accountNumber){
        console.checkBalance(accountNumber);
    }
}
