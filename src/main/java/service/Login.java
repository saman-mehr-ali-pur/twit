package service;
import repo.config;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    private static Scanner input = new Scanner(System.in);
    public  static int getLogin() throws SQLException, ClassNotFoundException {

        System.out.print("Username: ");
        String userName = input.nextLine();
        System.out.print("Password: ");
        String passWord = input.nextLine();

        return config.login(userName,passWord);
    }
}
