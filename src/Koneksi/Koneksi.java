package Koneksi;
import java.sql.*;
import javax.swing.*;

public class Koneksi {
    public static Connection KoneksiDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Memanggil driver JDBC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/toko_farda_new", "root", "");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
