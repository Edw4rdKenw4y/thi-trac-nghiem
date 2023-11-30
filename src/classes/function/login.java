package classes.function;

import classes.repository.*;
import classes.user.*;

import java.util.Scanner;

public class Login {
    private static Scanner sc = new Scanner(System.in);


    public static void login( AccountRepository accountRepository) {
        System.out.println("Enter username: ");
        String loginUsername = sc.nextLine();
        System.out.println("Enter password: ");
        String loginPassword = sc.nextLine();

        Account loggedInAccount = accountRepository.findUserByUserName(loginUsername);

        if (loggedInAccount != null && loggedInAccount.getPassword().equals(loginPassword)) {
            System.out.println("Login successful!");
            handleRole(loggedInAccount.getRole());
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    public static void register(AccountRepository accountRepository) {
        System.out.println("Enter username: ");
        String username = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        System.out.println("Enter role: ");
        String role = sc.nextLine();

        System.out.println("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.println("Enter year of birth: ");
        int yearOfBirth = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter gender: ");
        String gender = sc.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        Account acc = createAccount(username, password, role, fullName, yearOfBirth, gender, phoneNumber);

        accountRepository.saveList();

        System.out.println(acc);

        if (accountRepository.addUser(acc)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Username already exists.");
        }
    }

    public static Account createAccount(String username, String password, String role, String fullName, int yearOfBirth, String gender, String phoneNumber) {
        UserInfo info = new UserInfo(fullName, yearOfBirth, gender, phoneNumber);
        if (role.equalsIgnoreCase("professor")) {
            return new Professor(username, password, role, info);
        } else if (role.equalsIgnoreCase("student")) {
            return new Student(username, password, role, info);
        } else if (role.equalsIgnoreCase("admin")) {
            return new Admin(username, password, role, info);
        } else {
            return null;
        }
    }

    public static void handleRole(String role) {
        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Login successful with admin account!");
            // Add admin menu handling here
        } else if (role.equalsIgnoreCase("professor")) {
            System.out.println("Login successful with professor account!");
            // Add professor menu handling here
        } else if (role.equalsIgnoreCase("student")) {
            System.out.println("Login successful with student account!");
            // Add student menu handling here
        }
    }

	public static void exit(AccountRepository accountRepository)
	{
		accountRepository.saveList();
		System.out.println("Exiting program.");
		System.exit(0);
	}
}
