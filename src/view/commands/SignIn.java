package view.commands;

import view.ConsoleUI;

public class SignIn implements Command {
    private ConsoleUI console;

    public SignIn(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Sign in";
    }

    public void execute(){
        console.signIn();
    }
}
