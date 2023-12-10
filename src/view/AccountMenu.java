package view;

import java.util.ArrayList;
import java.util.List;

import view.account_commands.CheckBalance;
import view.account_commands.LogOut;
import view.account_commands.TransferFunds;
import view.account_commands.ViewInformation;
import view.account_commands.AccountCommand;

public class AccountMenu {
    private List<AccountCommand> list;

    public AccountMenu(ConsoleUI console) {
        list = new ArrayList<>();
        list.add(new ViewInformation(console));
        list.add(new CheckBalance(console));
        list.add(new TransferFunds(console));
        list.add(new LogOut(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice, long accountNumber){
        list.get(Integer.parseInt(choice) - 1).execute(accountNumber);
    }
}
