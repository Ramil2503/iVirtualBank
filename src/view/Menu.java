package view;

import view.commands.Command;
import view.commands.CreateAccount;
import view.commands.ExitCommand;
import view.commands.SignIn;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(ConsoleUI console) {
        list = new ArrayList<>();
        list.add(new CreateAccount(console));
        list.add(new SignIn(console));
        list.add(new ExitCommand(console));
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
