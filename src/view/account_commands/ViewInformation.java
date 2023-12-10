package view.account_commands;

import view.ConsoleUI;

public class ViewInformation implements AccountCommand{
    private ConsoleUI console;

    public ViewInformation(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "View information";
    }

    public void execute(long accountNumber){
        console.viewInformation(accountNumber);
    }
}
