package service;
import repo.config;

import java.sql.SQLException;

public class SaveTwite {
    public static void saveTxt(String txt,int id) throws SQLException, ClassNotFoundException {
        config.saveTwite(txt,id);
    }
}
