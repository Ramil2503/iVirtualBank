package view.commands;

import view.ConsoleUI;

public class CreateAccount implements Command{
    private ConsoleUI console;

    public CreateAccount(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Create account";
    }

    public void execute(){
        console.createAccount();
    }
}
