package dbTwitter;

import java.sql.*;


public class makeConection {
    private static String url = "jdbc:mysql://localhost:3306/twitter";
    private static String user = "root";
    private static String passWord = "Saman1382!";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,passWord);

        return  conn;
    }
}
