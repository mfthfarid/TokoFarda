
package TokoFarda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class tes1 {
    
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        System.out.println(currentYear);
    }
    
}
