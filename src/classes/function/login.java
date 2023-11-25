package classes.function;

import classes.repository.*;
import classes.user.*;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepository("acclist.txt");

        while (true) {
            System.out.println("[1].DANG NHAP");
            System.out.println("[2].DANG KY");
            System.out.println("[3].EXIT");
            System.out.println("NHAP LUA CHON: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Nhap user name: ");
                    String loginUsername = sc.nextLine();
                    System.out.println("Nhap password: ");
                    String loginPassword = sc.nextLine();

                    Account loggedInAccount = accountRepository.findUserByUserName(loginUsername);

                    if (loggedInAccount != null && loggedInAccount.getPassword().equals(loginPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                    break;

                case 2:
                    System.out.println("Nhap user name: ");
                    String username = sc.nextLine();
                    System.out.println("Nhap password: ");
                    String password = sc.nextLine();
                    System.out.println("Nhap role: ");
                    String role = sc.nextLine();
                    System.out.println("Nhap full name: ");
                    String fullName = sc.nextLine();
                    System.out.println("Nhap nam sinh: ");
                    int yearOfBirth = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Nhap gioi tinh: ");
                    String gender = sc.nextLine();
                    System.out.println("Nhap sdt: ");
                    String phoneNumber = sc.nextLine();

                    UserInfo info = new UserInfo(fullName, yearOfBirth, gender, phoneNumber);
                    Account acc = new Account() {}; 

                    acc.setUsername(username); 
                    acc.setPassword(password); 
                    acc.setRole(role); 
                    acc.setInfo(info);

                    System.out.println(acc);

                    accountRepository.addUser(acc);
                    
                    if (accountRepository.addUser(acc)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. Username already exists.");
                    }
                    break;

                case 3:
                    accountRepository.saveList();
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
}
