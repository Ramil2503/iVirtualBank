package view.commands;

import view.ConsoleUI;

public class LogOut implements Command {
        private ConsoleUI console;

    public LogOut(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription() {
        return "Log out";
    }

    public void execute() {
        console.logOut();
    }
}
