package loginsignup;
import javax.swing.*;
import java.sql.*;

class DatabaseConnection{
    public static void main(String[] args) throws Exception {
        Connection connect = null;
        connect = SqliteConnection.dbConnector();
        Statement statement = connect.createStatement();

        if (connect == null){
            JOptionPane.showMessageDialog(null, "Connection failed!");
        }

        String query = "SELECT * FROM bank where name=\"rafat\"";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getInt(1));
        }
    }
}
