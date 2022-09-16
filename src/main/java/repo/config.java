package repo;

import modle.Account;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class config {
    private static String loginQuery = "select * from account where user_name = ? and password=?";
    private static String signUpQuery = "insert into account (user_name,password,nick_name) values (?,?,?)";
    private static  String savingTwiteQuery = "insert into messages (twite,account_id,data_and_time) values(?,?,?)";
    private static String displayQuery = "select twite from messages where account_id = ?";
    public static int login(String userName, String passWord) throws SQLException, ClassNotFoundException {
        Connection conn = dbTwitter.makeConection.getConnection();
        PreparedStatement stm = conn.prepareStatement(loginQuery);
        stm.setString(1,userName);
        stm.setString(2, passWord);


        ResultSet rs = stm.executeQuery();
        int id=0 ;
        if (rs.next()) {
            id= rs.getInt("id");
            if (rs.wasNull()) {
                conn.close();
                stm.close();
                return 0;
            }
        }

        conn.close();
        stm.close();
        return id;
    }


   public static int SingUp(Account account) throws SQLException, ClassNotFoundException {
       Connection conn = dbTwitter.makeConection.getConnection();
       PreparedStatement stm = conn.prepareStatement(signUpQuery);
       stm.setString(1,account.userName);
       stm.setString(2, account.password);
       stm.setString(3,account.nickName);
       stm.executeUpdate();

       stm.close();

       Statement stmt = conn.createStatement();
       ResultSet rs =stmt.executeQuery("select count(id) count from account ");
       conn.close();
       stmt.close();
       rs.next();

        return rs.getInt("count");
    }


    public static void saveTwite(String txt,int id) throws SQLException, ClassNotFoundException {
        Connection conn = dbTwitter.makeConection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(savingTwiteQuery);
        stmt.setString(1,txt);
        stmt.setInt(2,id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        stmt.setTimestamp(3,timestamp);
        stmt.executeUpdate();
        conn.close();
        stmt.close();

    }


    public static void showTwites(int id) throws SQLException, ClassNotFoundException {
        Connection conn  = dbTwitter.makeConection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(displayQuery);
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("twite"));
            System.out.println("=================================== \n\n");
        }
    }


}
