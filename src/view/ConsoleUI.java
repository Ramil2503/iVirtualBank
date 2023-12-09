package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import presenter.Presenter;
import model.user.Gender;

public class ConsoleUI implements View {
    private Scanner scanner = new Scanner(System.in);
    private Presenter presenter;
    private AuthenticationMenu authenticationMenu;
    private AccountMenu accountMenu;
    private boolean authenticationWork;
    private boolean accountMenuWork;

    public ConsoleUI() {
        presenter = new Presenter(this);
        authenticationMenu = new AuthenticationMenu(this);
        authenticationWork = true;
        accountMenu = new AccountMenu(this);
        accountMenuWork = false;
    }

    @Override
    public void start() {
        while (authenticationWork) {
            print(authenticationMenu.print());
            String choice = scanner.nextLine();
            authenticationMenu.execute(choice);
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void createAccount() {
        String name;
        String password;
        Gender userGender;
        LocalDate birthDate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        print("Enter the name: ");
        name = scanner.nextLine();

        print("Enter the password: ");
        password = scanner.nextLine();
        
        while (true) {
            print("Please select the gender:");
            Gender[] genders = Gender.values();
            for (int i = 0; i < genders.length; i++) {
                print((i + 1) + ". " + genders[i]);
            }
        
            System.out.print("Enter the number corresponding to your choice: ");
            int choice;
        
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
        
                if (choice >= 1 && choice <= genders.length) {
                    userGender = genders[choice - 1];
                    break;
                } else {
                    print("Invalid choice. Please enter a valid number.");
                }
            } else {
                print("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }        

        while (birthDate == null) {
            print("Please enter the birth date (YYYY-MM-DD): ");
            String inputDate = scanner.nextLine();

            try {
                birthDate = LocalDate.parse(inputDate, dateFormatter);
            } catch (Exception e) {
                print("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
        presenter.createAccount(name, password, userGender, birthDate);
        print("");
        scanner.nextLine();
    }
    
    public void signIn() {
        String name;
        String password;
        print("Enter your name: ");
        name = scanner.nextLine();
        print("Enter the password: ");
        password = scanner.nextLine();
        while (presenter.logIn(name, password) == -1) {
            System.out.println("Info you entered have some mistakes: ");
            System.out.println("Enter your name: ");
            name = scanner.nextLine();
            print("Enter the password: ");
            password = scanner.nextLine();
        }
        System.out.println("Log in successful");
        accountMenuWork = true;
        accountMenuStart();
    }

    public void accountMenuStart() {
        while (accountMenuWork) {
            print(accountMenu.print());
            String choice = scanner.nextLine();
            accountMenu.execute(choice);
        }
    }

    public void checkBalance() {
        
    }

    public void logOut() {
        accountMenuWork = false;
        print("Log out...");
    }

    public void exit() {
        authenticationWork = false;
        print("Exiting the program...");
    }
}
