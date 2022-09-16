package service;
import modle.Account;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
    private static Scanner input = new Scanner(System.in);
    public static int getSignUp() throws SQLException, ClassNotFoundException {
        System.out.print("Username: ");

        String userName = input.nextLine();
        System.out.print("Password: ");
        String passWord = input.nextLine();

        System.out.print("Nickname: ");
        String nickName = input.nextLine();

        return  repo.config.SingUp(new Account(userName,passWord,nickName));

        //System.out.println("Your account is being created...");
    }

}
