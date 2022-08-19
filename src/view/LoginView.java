package view;

import config.Config;
import controller.AccountController;
import model.Account;
import model.Role;
import plugin.Menu;
import view.admin.AdminView;

import java.util.List;


public class LoginView {

    AccountController accountController = new AccountController();
    List<Account> accountList = accountController.getAccountList();

    public void menu() {
        Menu loginMenu = new Menu();
        loginMenu.addHeader("LOGIN");
        loginMenu.addChoice("1. Login");
        loginMenu.addChoice("2. Register");
        loginMenu.addChoice("3. Exit");
        loginMenu.addPaddingLeft(4);
        loginMenu.print();

        int choice = Config.getIntegerInput();

        switch (choice) {
            case 1:
                this.formLogin();
                break;
            case 2:
                this.formRegister();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        menu();
    }

    private void formRegister() {
        boolean checkUsername;
        String username;

        do {
            checkUsername = false;
            System.out.println("Enter username: ");
            username = Config.getStringInput();

            for (Account account : accountList) {
                if (account.getUsername().equals(username)) {
                    checkUsername = true;
                    break;
                }
            }

            if (checkUsername) {
                System.out.println("Username exists");
            }

        } while (checkUsername);


        System.out.println("Enter password: ");
        String password = Config.getStringInput();

        int lastId = accountList.get(accountList.size() - 1).getId();

        accountController.saveAccount(new Account(lastId + 1, username, password, Role.USER));

        System.out.println("Register successfully");

    }

    private void formLogin() {
        System.out.println("Enter username: ");
        String username = Config.getStringInput();

        boolean check = false;
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Username not found");
            return;
        }

        System.out.println("Enter password: ");
        String password = Config.getStringInput();

        Account loginAccount = getAccount(username, password);
        if (loginAccount != null) {
            if (loginAccount.getRole() == Role.ADMIN) {
                new AdminView().menu();
            } else {
                System.out.println("USER LOGGED IN");
            }
        } else {
            System.out.println("Wrong password");
        }
    }

    private Account getAccount(String username, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

}
