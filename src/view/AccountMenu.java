package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.CheckBalance;
import view.commands.Command;
import view.commands.LogOut;

public class AccountMenu {
    private List<Command> list;

    public AccountMenu(ConsoleUI console) {
        list = new ArrayList<>();
        list.add(new CheckBalance(console));
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

    public void execute(String choice){
        list.get(Integer.parseInt(choice) - 1).execute();
    }
}
