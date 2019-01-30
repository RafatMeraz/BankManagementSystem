package loginsignup;
import java.sql.*;
import javax.swing.JOptionPane;
public class JavaConnect {

    Connection conn= null;
    public static Connection ConnecrDb(){

        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/rafat_meraz/Codes/Database/zadbank.db");
            return conn;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;


    }
}