package view.commands;

import view.ConsoleUI;

public class ExitCommand implements Command {
    private ConsoleUI console;

    public ExitCommand(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription() {
        return "Exit";
    }

    public void execute() {
        console.exit();
    }
}