// package model;

// import java.time.LocalDate;
// import java.util.ArrayList;

// import model.user.Gender;
// import model.bank.AccountManager;
// import model.file_handler.FileHandler;
// import model.file_handler.SaveToFile;

// public class Service {
//     SaveToFile fileHandler = new FileHandler();
//     AccountManager accountManager = new AccountManager(fileHandler.loadFromFile());
    
//     public Service() {
        
//     }
    
//     // public void start() {
//     //     accountManager.test1();
//     //     fileHandler.saveToFile(accountManager.getAccountList());
//     //     System.out.println(accountManager.getAccountList());
//     // }
//     public void createAccount(String name, Gender userGender, LocalDate birthDate) {
//         accountManager.createAccount(name, userGender, birthDate);
//         fileHandler.saveToFile(accountManager.getAccountList());
//         System.out.println(accountManager.getAccountList());
//     }
// }
