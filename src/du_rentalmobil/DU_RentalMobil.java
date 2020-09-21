/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package du_rentalmobil;

import java.sql.SQLException;
import javax.swing.UIManager;
/**
 *
 * @author SuryanaMcCarley
 */
public class DU_RentalMobil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
             UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");   
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DU_RentalMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(DU_RentalMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(DU_RentalMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(DU_RentalMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            du_rentalmobil.form.halamanUtama Tampil = new du_rentalmobil.form.halamanUtama();
            Tampil.setVisible(true);
          
                
    }
}
