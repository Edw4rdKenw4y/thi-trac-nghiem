package classes.function;

import classes.repository.*;
import classes.user.*;

import classes.util.Constant;


import java.util.Scanner;

public class AdminMenu {
    public void admin(String filename){
        Scanner sc = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepository(filename);
        
        while (true) {
            System.out.println("[1]. Hien thi danh sach nguoi dung");
            System.out.println("[2]. Them nguoi dung");
            System.out.println("[3]. Sua thong tin nguoi dung");
            System.out.println("[4]. Xoa nguoi dung");
            System.out.println("[5]. Dang xuat");

            System.out.println("Nhap lua chon: ");
            int adminChoice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (adminChoice) {
                case 1:
                    // Hiển thị danh sách người dùng
                    System.out.println("Danh sach nguoi dung:");
                    for (Account acc : accountRepository.getAcclist().getArr()) {
                        System.out.println(acc);
                    }
                    break;

                case 2:
                    // Thêm người dùng
                    System.out.println("Nhập user name: ");
                    String username = sc.nextLine();
                    System.out.println("Nhập password: ");
                    String password = sc.nextLine();
                    System.out.println("Nhập role: ");
                    String role = sc.nextLine();
                    System.out.println("Nhập full name: ");
                    String fullName = sc.nextLine();
                    System.out.println("Nhập năm sinh: ");
                    int yearOfBirth = sc.nextInt();
                    sc.nextLine(); // consume the newline character
                    System.out.println("Nhập giới tính: ");
                    String gender = sc.nextLine();
                    System.out.println("Nhập số điện thoại: ");
                    String phoneNumber = sc.nextLine();

                    Account acc = null;
                    UserInfo info = new UserInfo(fullName, yearOfBirth, gender, phoneNumber);
                    if (role.equalsIgnoreCase("professor")) {
                        acc = new Professor() {}; 
                    } else if (role.equalsIgnoreCase("student")) {
                        acc = new Student() {}; 
                    } if (role.equalsIgnoreCase("admin")) {
                        acc = new Admin() {}; 
                    }

                    acc.setUsername(username); 
                    acc.setPassword(password); 
                    acc.setRole(role); 
                    acc.setInfo(info);

                    // System.out.println(acc);

                    if (accountRepository.addUser(acc)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. Username already exists.");
                    }
                        break;

                case 3:
                    // Sửa thông tin người dùng
                    System.out.println("Nhập user name của người dùng cần sửa: ");
                    String editUsername = sc.nextLine();
                    Account userToEdit = accountRepository.findUserByUserName(editUsername);

                    if (userToEdit != null) {
                        System.out.println("Nhập mật khẩu mới: ");
                        String newPassword = sc.nextLine();
                        System.out.println("Nhập tên mới: ");
                        String newFullName = sc.nextLine();
                        System.out.println("Nhập năm sinh mới: ");
                        int newYearOfBirth = sc.nextInt();
                        sc.nextLine(); // consume the newline character
                        System.out.println("Nhập giới tính mới: ");
                        String newGender = sc.nextLine();
                        System.out.println("Nhập số điện thoại mới: ");
                        String newPhoneNumber = sc.nextLine();

                        userToEdit.setPassword(newPassword);
                        userToEdit.getInfo().setFullName(newFullName);
                        userToEdit.getInfo().setYearOfBirth(newYearOfBirth);
                        userToEdit.getInfo().setGender(newGender);
                        userToEdit.getInfo().setPhoneNumber(newPhoneNumber);

                        accountRepository.saveList();
                        System.out.println("Thông tin người dùng đã được cập nhật.");
                    } else {
                        System.out.println("Không tìm thấy người dùng.");
                    }
                    break;

                case 4:
                    // Xóa người dùng
                    System.out.println("Nhập user name của người dùng cần xóa: ");
                    String deleteUsername = sc.nextLine();

                    if (accountRepository.removeUser(deleteUsername)) {
                        System.out.println("Người dùng đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy người dùng.");
                    }
                    break;

                case 5:
                    // Đăng xuất
                    System.out.println("Đăng xuất thành công.");
                    Login.loginScreen(null);;
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    sc.close();
                    break;
            }
        }
    }
}
