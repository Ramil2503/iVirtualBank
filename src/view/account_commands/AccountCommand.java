package view.account_commands;

public interface AccountCommand {
    String getDescription();
    void execute(long accountNumber);
}
