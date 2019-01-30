package loginsignup;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
    Connection conn = null;

    public static Connection dbConnector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/rafat_meraz/Codes/Database/zadbank.db");
//            JOptionPane.showMessageDialog(null, "Connection successful.");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

}