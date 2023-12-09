package view.account_commands;

import view.ConsoleUI;

public class LogOut implements AccountCommand {
        private ConsoleUI console;

    public LogOut(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription() {
        return "Log out";
    }

    public void execute(long accountNumber) {
        console.logOut();
    }
}
