package org.example;
import service.Login;
import service.SaveTwite;
import service.Signup;
import service.showAllTwite;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    private static   Scanner input = new Scanner(System.in);
    private static int id;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        do {
            System.out.println("Login: 1");
            System.out.println("Signup: 2");
            stepOne();
        } while (id == 0);
        System.out.println(id);

        System.out.println("Welcom:)");

        int command;
       while (true){

           System.out.print("new twit :1 \n show all twites :2 \n quit: 3 \n");
           System.out.print("command >>");
           command = input.nextInt();
           input.nextLine();
           switch (command) {
               case 1 -> newTwit();
               case 2 -> showAllTwites();
               case 3 -> System.exit(0);
           }
       }
    }


    public static void stepOne() throws SQLException, ClassNotFoundException {



        int inputNum = input.nextInt();
        input.nextLine();
        switch (inputNum){
            case 1:
                id =Login.getLogin();

                break;
            case 2:
                id =Signup.getSignUp();
                break;
            default:
                System.out.println("Your input number should be 1 or 2");

        }
    }

    public static void newTwit() throws SQLException, ClassNotFoundException {
        System.out.print("Write your twite > ");
        String inputStr = input.nextLine();
        SaveTwite.saveTxt(inputStr,id);
    }

    public static void showAllTwites() throws SQLException, ClassNotFoundException {
        showAllTwite.show(id);
    }


}

