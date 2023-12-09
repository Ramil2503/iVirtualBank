package view.commands;

import view.ConsoleUI;

public class CheckBalance implements Command {
    private ConsoleUI console;

    public CheckBalance(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Check Balance";
    }

    public void execute(){
        console.checkBalance();
    }
}
