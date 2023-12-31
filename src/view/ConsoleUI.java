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
        String userName;
        String ownerName;
        String password;
        Gender userGender;
        LocalDate birthDate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        print("Username: ");
        userName = scanner.nextLine();
        while (!presenter.nameChecker(userName)) {
            print("The account with this username already exists.\nPlease choose another username: ");
            userName = scanner.nextLine();
        }

        print("Password: ");
        password = scanner.nextLine();

        print("Your name: ");
        ownerName = scanner.nextLine();

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
        presenter.createAccount(userName, ownerName, password, userGender, birthDate);
        print("");
        scanner.nextLine();
    }
    public void signIn() {
        String name;
        String password;
        print("Enter your username: ");
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
        accountMenuStart(presenter.logIn(name, password));
    }

    public void accountMenuStart(long accountNumber) {
        while (accountMenuWork) {
            print(accountMenu.print());
            String choice = scanner.nextLine();
            accountMenu.execute(choice, accountNumber);
        }
    }

    public void viewInformation(long accountNumber) {
        print(presenter.viewInformation(accountNumber));
    }

    public void checkBalance(long accountNumber) {
        print("Your balance: ");
        print(String.valueOf(presenter.checkBalance(accountNumber)));
    }

    public void transferFunds(long accountNumber) {
        double amountToTransfer;
        long accountNumberTransfer;
        
        print("Enter the amount you want to transfer: ");
        amountToTransfer = scanner.nextDouble();
        print("Enter the account number where to transfer: ");
        accountNumberTransfer = scanner.nextLong();
        scanner.nextLine(); // Consume newline character after reading the long
    
        int transferResult = presenter.transferFunds(accountNumber, amountToTransfer, accountNumberTransfer);
    
        while (transferResult != 1) {
            if (transferResult == -1) {
                print("Insufficient amount of money");
            } else if (transferResult == -2) {
                print("The account with the entered account number does not exist");
            }
            
            print("Enter the amount you want to transfer: ");
            amountToTransfer = scanner.nextDouble();
            print("Enter the account number where to transfer: ");
            accountNumberTransfer = scanner.nextLong();
            scanner.nextLine(); // Consume newline character after reading the long
            
            transferResult = presenter.transferFunds(accountNumber, amountToTransfer, accountNumberTransfer);
        }
    
        print("Successful transaction!");
        checkBalance(accountNumber);
        print("");
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
