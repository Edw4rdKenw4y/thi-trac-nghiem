package classes.menu;

import java.util.Scanner;

import classes.function.Login;
import classes.repository.AccountRepository;
import classes.util.Constant;

public class Menu {
    public static void main(String[] args) {
        loginMenu();
    }

    private static void loginMenu() {
        while (true) {
            AccountRepository AccountRepository = new AccountRepository(Constant.dataPath.accounts_File);

            Scanner sc = new Scanner(System.in);
            System.out.println("[1].LOGIN");
            System.out.println("[2].REGISTER");
            System.out.println("[3].EXIT");
            System.out.println("ENTER YOUR CHOICE: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Login.login(AccountRepository);;
                    break;
                case 2:
                    Login.register(AccountRepository);
                    break;
                case 3:
                   Login.exit(AccountRepository);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
}