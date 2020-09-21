/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package du_rentalmobil.koneksi;
import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author SuryanaMcCarley
 */
public class koneksiRental {
    private static Connection SettingPanel() {
        String konString = "jdbc:mysql://localhost:3306/du_rentalmobil";
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(koneksiRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(koneksiRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }
    
    
    public Properties mypanel, myLanguage;
    private String srtNamePanel;
    
    public String SettingPanel(String nmPanel)
    {
    
        try
        {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/database.ini"));
            srtNamePanel = mypanel.getProperty(nmPanel);
        }
        
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage(),"Koneksi Ke DataBase Gagal", JOptionPane.INFORMATION_MESSAGE);
        
        System.err.println(e.getMessage());
        System.exit(0);
        }
    return srtNamePanel;
    }
    
    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = SettingPanel();
        try {
            Statement st = (Statement) koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(koneksiRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
     public Connection getConnection() throws SQLException {
        Connection cn;
        try {
            String server = "jdbc:mysql://localhost:3306/du_rentalmobil";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            cn = DriverManager.getConnection (server, "root","");
            return cn;
        } catch (SQLException se) {
            System.out.println(se.toString());
            return null;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
