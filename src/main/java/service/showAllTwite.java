package service;

import java.sql.SQLException;

public class showAllTwite {
    public static void show(int id) throws SQLException, ClassNotFoundException {
        repo.config.showTwites(id);
    }
}
