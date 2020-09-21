/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frm_penyewaan.java
 *
 * Created on Jan 13, 2017, 6:32:35 AM
 */
package du_rentalmobil.form;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SuryanaMcCarley
 */
public final class frm_penyewaan extends javax.swing.JInternalFrame {
    du_rentalmobil.koneksi.koneksiRental dbsetting;
    String driver,database,user,pass;
    Object tabel;

    String dataPassing;
        public frm_penyewaan(String data) throws SQLException{
        initComponents();
        this.dataPassing = data;
        Id_petugas.setText(data);
        dbsetting = new du_rentalmobil.koneksi.koneksiRental();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
                
        tbl_penyewaan.setModel(tableModel);
        settableload();
        auto_idpelanggan();
        comboDriver(); 
        comboNoPol();
        comboPelanggan();
        rad_drivY.setSelected(true);
        metd_byrTn.setSelected(true);
        metodeTn();
        comboNoRek();
        }
    /** Creates new form frm_penyewaan */
    public frm_penyewaan() throws SQLException {
        initComponents();
        dbsetting = new du_rentalmobil.koneksi.koneksiRental();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
                
        tbl_penyewaan.setModel(tableModel);
        settableload();
        auto_idpelanggan();
        comboDriver(); 
        comboNoPol();
        comboPelanggan();
        rad_drivY.setSelected(true);
        metd_byrTn.setSelected(true);
        metodeTn();
        comboNoRek();
    }

 
     public void auto_idpelanggan() {
        try {
            Class.forName(driver);
            Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
            Statement stt = (Statement) kon.createStatement();
            String sql = "SELECT * FROM tabel_faktur ORDER BY ID_rental DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idrental = rs.getString("ID_rental").substring(1);
                String AN = "" + (Integer.parseInt(idrental) + 1);
                String Nol = "";
                if(AN.length()==1)
                     {Nol = "000";}
                else if(AN.length()==2)
                     {Nol = "00";}
                else if(AN.length()==3)
                     {Nol = "0";}
                else if(AN.length()==4)
                     {Nol = "";}
                ID_rental.setText("R" + Nol + AN);
                } else {
                ID_rental.setText("R0001");
            } 
                rs.close();
                kon.close();
            } catch (Exception ex) {
                 System.err.println(ex.getMessage());
            }
    }
    public void membersihkan_teks() {
        nm_pelanggan.setText("");
        rad_drivT.setSelected(false);
        rad_drivY.setSelected(false);
        combo_driver.setSelectedItem("-"); 
        nm_driver.setText("");
        combo_idPelanggan.setSelectedItem("-"); 
        nm_pelanggan.setText("");
        no_telpPelanggan.setText("");
        combo_noPolis.setSelectedItem("-"); 
        merk_mobil.setText("");
        type_mbl.setText("");
        metd_byrTn.setSelected(false);
        metd_byrTr.setSelected(false);
        No_rekRental.setSelectedItem("-"); 
        Nm_Bank.setText("-");
        ats_nama.setText("");
        Biaya_Pakt.setText("0");
        Biaya_driver.setText("0");
        Ttl_Biaya.setText("0");
        Ttl_Bayar.setText("");
        Sisa.setText("0");
    }
    
    public void nonaktif_teks() {
        nm_pelanggan.setEnabled(false);
        rad_drivT.setEnabled(false);
        rad_drivY.setEnabled(false);
        combo_driver.setEnabled(false); 
        nm_driver.setEnabled(false);
        combo_idPelanggan.setEnabled(false); 
        nm_pelanggan.setEnabled(false);
        no_telpPelanggan.setEnabled(false);
        combo_noPolis.setEnabled(false); 
        merk_mobil.setEnabled(false);
        metd_byrTn.setEnabled(false);
        metd_byrTr.setEnabled(false);
        No_rekRental.setEnabled(false); 
        Nm_Bank.setEnabled(false);
        ats_nama.setEnabled(false);
        Biaya_Pakt.setEnabled(false);
        Biaya_driver.setEnabled(false);
        Ttl_Biaya.setEnabled(false);
        Ttl_Bayar.setEnabled(false);
        Sisa.setEnabled(false);
    }
    
    public void aktif_teks() {
        nm_pelanggan.setEnabled(true);
        rad_drivT.setEnabled(true);
        rad_drivY.setEnabled(true);
        combo_driver.setEnabled(true); 
        nm_driver.setEnabled(true);
        combo_idPelanggan.setEnabled(true); 
        nm_pelanggan.setEnabled(true);
        no_telpPelanggan.setEnabled(true);
        combo_noPolis.setEnabled(true); 
        merk_mobil.setEnabled(true);
        metd_byrTn.setEnabled(true);
        metd_byrTr.setEnabled(true);
        No_rekRental.setEnabled(true); 
        Nm_Bank.setEnabled(true);
        ats_nama.setEnabled(true);
        Biaya_Pakt.setEnabled(true);
        Biaya_driver.setEnabled(true);
        Ttl_Biaya.setEnabled(true);
        Ttl_Bayar.setEnabled(true);
        Sisa.setEnabled(true);
    }
    
  
    private javax.swing.table.DefaultTableModel tableModel= getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()        
    {
        return new javax.swing.table.DefaultTableModel
                (
                    new Object[][] {},
                    new String[] {"ID Rental", "Lama Pinjam", "ID Driver", "Nama Driver", "ID Pelanggan", "Nama Pelanggan"
                    , "No Telp", "No Polisi", "Merk Mobil", "Type Mobil", "ID Petugas", "Metode Bayar", "No rek Rental", "Bank"
                    , "Atas Nama", "Biaya Paket", "Biaya Driver", "Total Biaya", "Total Bayar", "Sisa"}
                )
    {
        boolean[] canEdit = new boolean[] {
            false, false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, false
        };
        
       @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
       return canEdit[columnIndex];
        }
     };
   }
    
     String data[]= new String[22];
     private void settableload() {
           String stat = "";
           try {
               Class.forName(driver);
                       Connection kon = (Connection) DriverManager.getConnection(database,user,pass);      
                       
                       Statement stt=(Statement) kon.createStatement();
                       String SQL = "select * from tabel_faktur";
                       ResultSet res = stt.executeQuery(SQL);
                       while(res.next()) {
                        data[0] = res.getString(1); 
                        data[1] = res.getString(2); 
                        data[2] = res.getString(3);
                        data[3] = res.getString(4); 
                        data[4] = res.getString(5); 
                        data[5] = res.getString(6); 
                        data[6] = res.getString(7); 
                        data[7] = res.getString(8); 
                        data[8] = res.getString(9); 
                        data[9] = res.getString(10); 
                        data[10] = res.getString(11); 
                        data[11] = res.getString(12); 
                        data[12] = res.getString(13); 
                        data[13] = res.getString(14); 
                        data[14] = res.getString(15); 
                        data[15] = res.getString(16); 
                        data[16] = res.getString(17); 
                        data[17] = res.getString(18); 
                        data[18] = res.getString(19); 
                        data[19] = res.getString(20); 
                        
                        tableModel.addRow(data);
                       }
                       res.close();
                       stt.close();
                       kon.close();
           } catch(Exception ex) {
                           System.err.println(ex.getMessage());
                           JOptionPane.showMessageDialog(null,ex.getMessage(),"Gagal Terhubung Ke Database",JOptionPane.INFORMATION_MESSAGE);
                       }
    }
     
     public void DriverY(){
        combo_driver.setSelectedItem("-");
        nm_driver.setText("");
        Biaya_driver.setText("0");
        
        combo_driver.setEnabled(true);
        nm_driver.setEnabled(true);
       }
     
      public void DriverT(){
        combo_driver.setSelectedItem("-");
        nm_driver.setText("-");
        Biaya_driver.setText("0");
        
        combo_driver.setEnabled(false);
        nm_driver.setEnabled(false);
       }
      
      public void metodeTn(){
        No_rekRental.setSelectedItem("-");
        Nm_Bank.setText("-");
        ats_nama.setText("-");
        
        No_rekRental.setEnabled(false);
        Nm_Bank.setEnabled(false);
        ats_nama.setEnabled(false);
       }
      
      public void metodeTr(){
        No_rekRental.setSelectedItem("-");
        Nm_Bank.setText("");
        ats_nama.setText("");
        
        No_rekRental.setEnabled(true);
        Nm_Bank.setEnabled(true);
        ats_nama.setEnabled(true);
       }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ID_rental = new javax.swing.JLabel();
        combo_driver = new javax.swing.JComboBox();
        rad_drivY = new javax.swing.JRadioButton();
        rad_drivT = new javax.swing.JRadioButton();
        nm_driver = new javax.swing.JTextField();
        combo_idPelanggan = new javax.swing.JComboBox();
        nm_pelanggan = new javax.swing.JTextField();
        no_telpPelanggan = new javax.swing.JTextField();
        combo_noPolis = new javax.swing.JComboBox();
        merk_mobil = new javax.swing.JTextField();
        type_mbl = new javax.swing.JTextField();
        metd_byrTn = new javax.swing.JRadioButton();
        metd_byrTr = new javax.swing.JRadioButton();
        No_rekRental = new javax.swing.JComboBox();
        ats_nama = new javax.swing.JTextField();
        Biaya_Pakt = new javax.swing.JTextField();
        Ttl_Bayar = new javax.swing.JTextField();
        lama_pinjam = new javax.swing.JTextField();
        hitungDriver = new javax.swing.JButton();
        hitungDriver1 = new javax.swing.JButton();
        Biaya_driver = new javax.swing.JTextField();
        Id_petugas = new javax.swing.JTextField();
        Ttl_Biaya = new javax.swing.JTextField();
        Sisa = new javax.swing.JTextField();
        Nm_Bank = new javax.swing.JTextField();
        hitungKembali = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        Btn_Ubah = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_penyewaan = new javax.swing.JTable();
        Btn_Batal = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Penyewaan"));

        jLabel1.setText("ID Rental");

        jLabel2.setText("Lama Pinjam");

        jLabel3.setText("Driver");

        jLabel4.setText("ID Driver");

        jLabel5.setText("Nama Driver");

        jLabel6.setText("ID Pelanggan");

        jLabel7.setText("Nama Pelanggan");

        jLabel8.setText("No Telp");

        jLabel9.setText("No Polisi");

        jLabel10.setText("Merk Mobil");

        jLabel11.setText("Type Mobil");

        jLabel12.setText("ID Petugas");

        jLabel13.setText("Metode Bayar");

        jLabel14.setText("No Rek Rental");

        jLabel15.setText("Atas Nama");

        jLabel16.setText("Bank");

        jLabel17.setText("Biaya Paket");

        jLabel18.setText("Biaya Driver");

        jLabel19.setText("Total Biaya");

        jLabel20.setText("Total Bayar");

        jLabel21.setText("Sisa");

        ID_rental.setText("0");

        combo_driver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_driverActionPerformed(evt);
            }
        });

        buttonGroup1.add(rad_drivY);
        rad_drivY.setText("Ya");
        rad_drivY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_drivYActionPerformed(evt);
            }
        });

        buttonGroup1.add(rad_drivT);
        rad_drivT.setText("Tidak");
        rad_drivT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_drivTActionPerformed(evt);
            }
        });

        combo_idPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        combo_idPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_idPelangganActionPerformed(evt);
            }
        });

        combo_noPolis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        combo_noPolis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_noPolisActionPerformed(evt);
            }
        });

        buttonGroup2.add(metd_byrTn);
        metd_byrTn.setText("Tunai");
        metd_byrTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metd_byrTnActionPerformed(evt);
            }
        });

        buttonGroup2.add(metd_byrTr);
        metd_byrTr.setText("Transfer");
        metd_byrTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metd_byrTrActionPerformed(evt);
            }
        });

        No_rekRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_rekRentalActionPerformed(evt);
            }
        });

        hitungDriver.setText("=");
        hitungDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungDriverActionPerformed(evt);
            }
        });

        hitungDriver1.setText("=");
        hitungDriver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungDriver1ActionPerformed(evt);
            }
        });

        Biaya_driver.setText("0");

        Ttl_Biaya.setText("0");

        Sisa.setText("0");

        hitungKembali.setText("=");
        hitungKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel20)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Ttl_Biaya, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(ID_rental, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rad_drivY)
                                .addGap(18, 18, 18)
                                .addComponent(rad_drivT))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lama_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hitungDriver))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(metd_byrTn)
                                .addGap(18, 18, 18)
                                .addComponent(metd_byrTr))
                            .addComponent(No_rekRental, 0, 208, Short.MAX_VALUE)
                            .addComponent(Id_petugas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(type_mbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(merk_mobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(combo_noPolis, javax.swing.GroupLayout.Alignment.LEADING, 0, 208, Short.MAX_VALUE)
                            .addComponent(no_telpPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(nm_pelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(combo_idPelanggan, javax.swing.GroupLayout.Alignment.LEADING, 0, 208, Short.MAX_VALUE)
                            .addComponent(nm_driver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(combo_driver, javax.swing.GroupLayout.Alignment.LEADING, 0, 208, Short.MAX_VALUE)
                            .addComponent(Sisa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Ttl_Bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitungKembali))
                            .addComponent(Nm_Bank, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(Biaya_driver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(ats_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Biaya_Pakt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitungDriver1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ID_rental))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lama_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hitungDriver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rad_drivY)
                    .addComponent(rad_drivT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nm_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_idPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nm_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(no_telpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_noPolis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(merk_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(type_mbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Id_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(metd_byrTn)
                    .addComponent(metd_byrTr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(No_rekRental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Nm_Bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ats_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Biaya_Pakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hitungDriver1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Biaya_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Ttl_Biaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(Ttl_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hitungKembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(Sisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Btn_Ubah.setText("Ubah");
        Btn_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UbahActionPerformed(evt);
            }
        });

        jButton3.setText("Selesai");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbl_penyewaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_penyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_penyewaanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_penyewaan);

        Btn_Batal.setText("Batal");
        Btn_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31470, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Btn_Ubah, Simpan, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Batal)
                        .addGap(21, 21, 21)
                        .addComponent(jButton3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rad_drivYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_drivYActionPerformed
        DriverY();
        hitungDriver.setEnabled(true);
    }//GEN-LAST:event_rad_drivYActionPerformed

    private void rad_drivTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_drivTActionPerformed
        DriverT();
        hitungDriver.setEnabled(false);
        combo_driver.setSelectedItem("0");
        nm_driver.setText("-");
    }//GEN-LAST:event_rad_drivTActionPerformed

    private void metd_byrTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metd_byrTnActionPerformed
     metodeTn();
     No_rekRental.setSelectedItem("0");
     Nm_Bank.setText("-");
     ats_nama.setText("-");
    }//GEN-LAST:event_metd_byrTnActionPerformed

    private void metd_byrTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metd_byrTrActionPerformed
      metodeTr();
    }//GEN-LAST:event_metd_byrTrActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
       String data[]=new String[20];
            
        if ((lama_pinjam.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan dilengkapi");
            lama_pinjam.requestFocus();
        } else {
            try {
                String Metode = "";
                if (metd_byrTn.isSelected()) {
                    Metode = "Tunai";
                } else {
                    Metode = "Transfer";
                }
                
                Class.forName(driver);
                Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
                Statement stt = (Statement) kon.createStatement();
                String SQL = "INSERT INTO tabel_faktur (ID_Rental,"
                                                       + "Lama_Pinjam,"
                                                       + "ID_Driver,"
                                                       + "Nama_Driver,"
                                                       + "ID_Pelanggan,"
                                                       + "Nama_Pelanggan,"
                                                       + "No_telp,"
                                                       + "No_Polisi,"
                                                       + "Merk_Mobil,"
                                                       + "Type_Mobil,"
                                                       + "ID_Petugas,"
                                                       + "Metode_Bayar,"
                                                       + "No_Rek_Rental,"
                                                       + "Bank,"
                                                       + "Atas_Nama_Rek,"
                                                       + "Biaya_Paket,"
                                                       + "Biaya_Driver,"
                                                       + "Total_Biaya,"
                                                       + "Total_Bayar,"
                                                       + "Sisa)" 
                                                       + "VALUES" 
                                                       + "('"+ID_rental.getText()+"',"
                                                       + "'"+lama_pinjam.getText()+"',"
                                                       + "'"+combo_driver.getSelectedItem().toString()+"',"
                                                       + "'"+nm_driver.getText()+"',"
                                                       + "'"+combo_idPelanggan.getSelectedItem().toString()+"',"
                                                       + "'"+nm_pelanggan.getText()+"',"
                                                       + "'"+no_telpPelanggan.getText()+"',"
                                                       + "'"+combo_noPolis.getSelectedItem().toString()+"',"
                                                       + "'"+merk_mobil.getText()+"',"
                                                       + "'"+type_mbl.getText()+"',"
                                                       + "'"+Id_petugas.getText()+"',"
                                                       + "'"+Metode+"',"
                                                       + "'"+No_rekRental.getSelectedItem().toString()+"',"
                                                       + "'"+Nm_Bank.getText()+"',"
                                                       + "'"+ats_nama.getText()+"',"
                                                       + "'"+Biaya_Pakt.getText()+"',"                               
                                                       + "'"+Biaya_driver.getText()+"',"                               
                                                       + "'"+Ttl_Biaya.getText()+"',"                               
                                                       + "'"+Ttl_Bayar.getText()+"',"                               
                                                       + "'"+Sisa.getText()+"')";
                      stt.executeUpdate(SQL);
                      data[0]  = ID_rental.getText();
                      data[1]  = lama_pinjam.getText();
                      data[2]  = combo_driver.getSelectedItem().toString();
                      data[3]  = nm_driver.getText();
                      data[4]  = combo_idPelanggan.getSelectedItem().toString();
                      data[5]  = nm_pelanggan.getText();
                      data[6]  = no_telpPelanggan.getText();
                      data[7]  = combo_noPolis.getSelectedItem().toString();
                      data[8]  = merk_mobil.getText();
                      data[9]  = type_mbl.getText();
                      data[10]  = Id_petugas.getText();
                      data[11]  = Metode;
                      data[12]  = No_rekRental.getSelectedItem().toString();
                      data[13]  = Nm_Bank.getText();
                      data[14]  = ats_nama.getText();
                      data[15]  = Biaya_Pakt.getText();
                      data[16]  = Biaya_driver.getText();
                      data[17]  = Ttl_Biaya.getText();
                      data[18]  = Ttl_Bayar.getText();
                      data[19]  = Sisa.getText();
                      
                      stt.close();
                      kon.close();
                      tableModel.insertRow(0, data);
                      
                      membersihkan_teks();
                      auto_idpelanggan();
                      tbl_penyewaan.clearSelection();
        
                      tableModel.setRowCount(0);
                      settableload();
                      aktif_teks();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Gagal Terhubung Ke Database", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_SimpanActionPerformed

     private void comboDriver() throws SQLException {
            Connection kon = (Connection) DriverManager.getConnection(database,user,pass);  
            java.sql.Statement stmt;
            stmt = kon.createStatement();
            String sql = "Select * From tabel_driver order by ID_Driver asc";
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String ID_Drv = rslt.getString("ID_Driver");
                combo_driver.addItem(ID_Drv);
            }
        } 
    
    private void combo_driverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_driverActionPerformed
           try {Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
              Statement stt = (Statement) kon.createStatement();
              String sql = "Select Nama_Driver From tabel_driver WHERE ID_Driver='"+combo_driver.getSelectedItem()+"'";
              ResultSet res = stt.executeQuery(sql);
              
              while(res.next()){
                  Object[] ob = new Object[4];
                  ob[0] = res.getString(1);

                  nm_driver.setText((String) ob[0]);

              }
              res.close();
              stt.close();
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }

    }//GEN-LAST:event_combo_driverActionPerformed

    private void comboNoPol() throws SQLException {
            Connection kon = (Connection) DriverManager.getConnection(database,user,pass);  
            java.sql.Statement stmt;
            stmt = kon.createStatement();
            String sql = "Select * From tabel_mobil order by No_Polisi asc";
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String ID_nopol = rslt.getString("No_polisi");
                combo_noPolis.addItem(ID_nopol);
            }
        } 
    
    private void combo_noPolisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_noPolisActionPerformed
       try {Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
              Statement stt = (Statement) kon.createStatement();
              String sql = "Select Merk_Mobil,Type_Mobil From tabel_mobil WHERE No_Polisi='"+combo_noPolis.getSelectedItem()+"'";
              ResultSet res = stt.executeQuery(sql);
              
              while(res.next()){
                  Object[] ob = new Object[4];
                  ob[0] = res.getString(1);
                  ob[1] = res.getString(2);

                  merk_mobil.setText((String) ob[0]);
                  type_mbl.setText((String) ob[1]);

              }
              res.close();
              stt.close();
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }
    }//GEN-LAST:event_combo_noPolisActionPerformed

    private void comboNoRek() throws SQLException {
            Connection kon = (Connection) DriverManager.getConnection(database,user,pass);  
            java.sql.Statement stmt;
            stmt = kon.createStatement();
            String sql = "Select * From tabel_Bank order by No_Rek_Rental asc";
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String NoRekRen = rslt.getString("No_Rek_Rental");
                No_rekRental.addItem(NoRekRen);
            }
        } 
    
    private void No_rekRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_rekRentalActionPerformed
        try {Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
              Statement stt = (Statement) kon.createStatement();
              String sql = "Select Bank From tabel_Bank WHERE No_Rek_Rental='"+No_rekRental.getSelectedItem()+"'";
              ResultSet res = stt.executeQuery(sql);
              
              while(res.next()){
                  Object[] ob = new Object[4];
                  ob[0] = res.getString(1);

                  Nm_Bank.setText((String) ob[0]);

              }
              res.close();
              stt.close();
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }
    }//GEN-LAST:event_No_rekRentalActionPerformed
    private void comboPelanggan() throws SQLException {
            Connection kon = (Connection) DriverManager.getConnection(database,user,pass);  
            java.sql.Statement stmt;
            stmt = kon.createStatement();
            String sql = "Select * From tabel_Pelanggan order by ID_Pelanggan asc";
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String ID_Pelang = rslt.getString("Id_Pelanggan");
                combo_idPelanggan.addItem(ID_Pelang);
            }
        } 
    private void combo_idPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_idPelangganActionPerformed
       try {Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
              Statement stt = (Statement) kon.createStatement();
              String sql = "Select Nama_Pelanggan, No_Telp From tabel_Pelanggan WHERE ID_Pelanggan='"+combo_idPelanggan.getSelectedItem()+"'";
              ResultSet res = stt.executeQuery(sql);
              
              while(res.next()){
                  Object[] ob = new Object[4];
                  ob[0] = res.getString(1);
                  ob[1] = res.getString(2);

                  nm_pelanggan.setText((String) ob[0]);
                  no_telpPelanggan.setText((String) ob[1]);

              }
              res.close();
              stt.close();
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }
    }//GEN-LAST:event_combo_idPelangganActionPerformed

    private void hitungDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungDriverActionPerformed
       int lamaPinjam;
       int DriverHrg;
       int HargMobil = 0;
       int jmlDri;
       int jmlPkt;
       String HasilDri;
       String HasilPkt;
        
       lamaPinjam = Integer.valueOf(lama_pinjam.getText());
       
       try {Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
              Statement stt = (Statement) kon.createStatement();
              String sql = "Select Harga From tabel_mobil WHERE No_Polisi='"+combo_noPolis.getSelectedItem()+"'";
              ResultSet res = stt.executeQuery(sql);
              
              while(res.next()){
                  Object[] ob = new Object[1];
                  ob[0] = res.getString(1);

                 HargMobil = Integer.valueOf((String) ob[0]);
              }
              res.close();
              stt.close();
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }
       
       DriverHrg = 200000;
       jmlDri = lamaPinjam*DriverHrg;
        
       jmlPkt = lamaPinjam*HargMobil;
       HasilPkt=String.valueOf(jmlPkt);
       Biaya_Pakt.setText(HasilPkt);
       
       HasilDri=String.valueOf(jmlDri);
       Biaya_driver.setText(HasilDri);
    }//GEN-LAST:event_hitungDriverActionPerformed

    private void hitungDriver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungDriver1ActionPerformed
       int BiayaPaket;
       int BiayaDriver;
       int jmlB;
       String HasilB;
        
       BiayaPaket = Integer.valueOf(Biaya_Pakt.getText());
       BiayaDriver = Integer.valueOf(Biaya_Pakt.getText());
       
       
       jmlB = BiayaDriver+BiayaPaket;
      
       HasilB=String.valueOf(jmlB);
       Ttl_Biaya.setText(HasilB);
    }//GEN-LAST:event_hitungDriver1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Btn_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UbahActionPerformed
        int  ubah= JOptionPane.showConfirmDialog(null,"Apakah anda ingin Mengubah data ini?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        int row = 0;
        
        if(ubah==JOptionPane.YES_OPTION) {
             String Metode = "";
                if (metd_byrTn.isSelected()) {
                    Metode = "Tunai";
                } else {
                    Metode = "Transfer";
                }
                
                String lmPnj = lama_pinjam.getText();
                String idDri = combo_driver.getSelectedItem().toString();
                String nmDri = nm_driver.getText();
                String idPel = combo_idPelanggan.getSelectedItem().toString();
                String nmPel = nm_pelanggan.getText();
                String noPel = no_telpPelanggan.getText();
                String noPol = combo_noPolis.getSelectedItem().toString();
                String mrMbl = merk_mobil.getText();
                String tyMbl = type_mbl.getText();
                String idPtg = Id_petugas.getText();
                String MtdPm = Metode;
                String noRek = No_rekRental.getSelectedItem().toString();
                String nmBnk = Nm_Bank.getText();
                String atNma = ats_nama.getText();
                String ByPkt = Biaya_Pakt.getText();
                String byDri = Biaya_driver.getText();
                String ttBia = Ttl_Biaya.getText();
                String ttBay = Ttl_Bayar.getText();
                String Sisaa = Sisa.getText();
            
          
        if ((lmPnj.isEmpty())){
            JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong, Slilahkan Dilengkapi");
            lama_pinjam.requestFocus();
        } else {
            try {
                    Class.forName(driver);
                    Connection kon = (Connection) DriverManager.getConnection(database,user, pass);
                    Statement stt = (Statement) kon.createStatement();

                    String SQL = "UPDATE `tabel_faktur` "
                                    + "SET `Lama_Pinjam`= '"+lmPnj+"',"
                                    + "`ID_Driver`= '"+idDri+"',"
                                    + "`Nama_Driver`= '"+nmDri+"',"
                                    + "`ID_Pelanggan`= '"+idPel+"',"
                                    + "`Nama_Pelanggan`= '"+nmPel+"',"
                                    + "`No_telp`= '"+noPel+"',"
                                    + "`No_Polisi`= '"+noPol+"',"
                                    + "`Merk_Mobil`= '"+mrMbl+"',"
                                    + "`Type_Mobil`= '"+tyMbl+"',"
                                    + "`ID_Petugas`= '"+idPtg+"',"
                                    + "`Metode_Bayar`= '"+MtdPm+"',"
                                    + "`No_Rek_Rental`= '"+noRek+"',"
                                    + "`Bank`= '"+nmBnk+"',"
                                    + "`Atas_Nama_Rek`= '"+atNma+"',"
                                    + "`Biaya_Paket`= '"+ByPkt+"',"
                                    + "`Biaya_Driver`= '"+byDri+"',"
                                    + "`Total_Biaya`= '"+ttBia+"',"
                                    + "`Total_Bayar`= '"+ttBay+"',"
                                    + "`Sisa`= '"+Sisaa+"'"
                            + "WHERE "
                            + "`ID_Rental`='"+tableModel.getValueAt(row, 0).toString()+"';";
                    stt.executeUpdate(SQL);
                    
                    data[1] = lmPnj;
                    data[2] = idDri;
                    data[3] = nmDri;
                    data[4] = idPel;
                    data[5] = nmPel;
                    data[6] = noPel;
                    data[7] = noPol;
                    data[8] = mrMbl;
                    data[9] = tyMbl;
                    data[10] = idPtg;
                    data[11] = MtdPm;
                    data[12] = noRek;
                    data[13] = nmBnk;
                    data[14] = atNma;
                    data[15] = ByPkt;
                    data[16] = byDri;
                    data[17] = ttBia;
                    data[18] = ttBay;
                    data[19] = Sisaa;
                    
                    stt.close();
                    kon.close();
                    tableModel.insertRow(0, data);
                      
                    membersihkan_teks();
                    auto_idpelanggan();
                    tbl_penyewaan.clearSelection();
        
                    tableModel.setRowCount(0);
                    settableload();
                    aktif_teks();
                } catch (Exception ex) {
                  System.err.println(ex.getMessage());
            }
        }
            } else if(ubah==JOptionPane.NO_OPTION) {
            Btn_BatalActionPerformed(evt);
        }
        
    
    }//GEN-LAST:event_Btn_UbahActionPerformed

    private void Btn_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BatalActionPerformed
       membersihkan_teks();
       Simpan.setEnabled(true);
    }//GEN-LAST:event_Btn_BatalActionPerformed

    public void MetodeByr(){
        if ("Tunai".equals(tbl_penyewaan.getValueAt(row, 11).toString())) {
                metd_byrTn.setSelected(true);
            } else {
                metd_byrTr.setSelected(true);
            }
    }
    
    int row = 0;
      public void tampil_field() {
        row = tbl_penyewaan.getSelectedRow();
        
        ID_rental.setText(tableModel.getValueAt(row, 0).toString());
        lama_pinjam.setText(tableModel.getValueAt(row, 1).toString());
        combo_driver.setSelectedItem(tableModel.getValueAt(row, 2).toString());
        nm_driver.setText(tableModel.getValueAt(row, 3).toString());
        combo_idPelanggan.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        nm_pelanggan.setText(tableModel.getValueAt(row, 5).toString());
        no_telpPelanggan.setText(tableModel.getValueAt(row, 6).toString());
        combo_noPolis.setSelectedItem(tableModel.getValueAt(row, 7).toString());
        merk_mobil.setText(tableModel.getValueAt(row, 8).toString());
        type_mbl.setText(tableModel.getValueAt(row, 9).toString());
        Id_petugas.setText(tableModel.getValueAt(row, 10).toString());
        MetodeByr();
        No_rekRental.setSelectedItem(tableModel.getValueAt(row, 12).toString());
        Nm_Bank.setText(tableModel.getValueAt(row, 13).toString());
        ats_nama.setText(tableModel.getValueAt(row, 14).toString());
        Biaya_Pakt.setText(tableModel.getValueAt(row, 15).toString());
        Biaya_driver.setText(tableModel.getValueAt(row, 16).toString());
        Ttl_Biaya.setText(tableModel.getValueAt(row, 17).toString());
        Ttl_Bayar.setText(tableModel.getValueAt(row, 18).toString());
        Sisa.setText(tableModel.getValueAt(row, 19).toString());
          
          Simpan.setEnabled(false);
          aktif_teks();
      }
    
    
    private void tbl_penyewaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_penyewaanMouseClicked
     if(evt.getClickCount() == 1) {
            tampil_field();
        }
    }//GEN-LAST:event_tbl_penyewaanMouseClicked

    private void hitungKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungKembaliActionPerformed
       int TotalBiaya;
       int TotalBayar;
       int sisaJml;
       String HasilSisa;
        
       TotalBayar = Integer.valueOf(Ttl_Bayar.getText());
       TotalBiaya = Integer.valueOf(Ttl_Biaya.getText());
       sisaJml = TotalBayar - TotalBiaya;
        
       HasilSisa=String.valueOf(sisaJml);
       Sisa.setText(HasilSisa);
    }//GEN-LAST:event_hitungKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Biaya_Pakt;
    private javax.swing.JTextField Biaya_driver;
    private javax.swing.JButton Btn_Batal;
    private javax.swing.JButton Btn_Ubah;
    private javax.swing.JLabel ID_rental;
    private javax.swing.JTextField Id_petugas;
    private javax.swing.JTextField Nm_Bank;
    private javax.swing.JComboBox No_rekRental;
    private javax.swing.JButton Simpan;
    private javax.swing.JTextField Sisa;
    private javax.swing.JTextField Ttl_Bayar;
    private javax.swing.JTextField Ttl_Biaya;
    private javax.swing.JTextField ats_nama;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox combo_driver;
    private javax.swing.JComboBox combo_idPelanggan;
    private javax.swing.JComboBox combo_noPolis;
    private javax.swing.JButton hitungDriver;
    private javax.swing.JButton hitungDriver1;
    private javax.swing.JButton hitungKembali;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lama_pinjam;
    private javax.swing.JTextField merk_mobil;
    private javax.swing.JRadioButton metd_byrTn;
    private javax.swing.JRadioButton metd_byrTr;
    private javax.swing.JTextField nm_driver;
    private javax.swing.JTextField nm_pelanggan;
    private javax.swing.JTextField no_telpPelanggan;
    private javax.swing.JRadioButton rad_drivT;
    private javax.swing.JRadioButton rad_drivY;
    private javax.swing.JTable tbl_penyewaan;
    private javax.swing.JTextField type_mbl;
    // End of variables declaration//GEN-END:variables

}
