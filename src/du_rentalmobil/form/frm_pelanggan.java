/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frm_pelanggan.java
 *
 * Created on Jan 12, 2017, 8:59:54 PM
 */
package du_rentalmobil.form;
//Import Javax
import javax.swing.*;
//Import Koneksi Database
import java.sql.*;
/**
 *
 * @author SuryanaMcCarley
 */
public final class frm_pelanggan extends javax.swing.JInternalFrame {
    du_rentalmobil.koneksi.koneksiRental dbsetting;
    String driver,database,user,pass;
    Object tabel;
    /** Creates new form frm_pelanggan */
    public frm_pelanggan() {
        initComponents();
        dbsetting = new du_rentalmobil.koneksi.koneksiRental();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        
        tbl_pelanggan.setModel(tableModel);
        settableload();
        auto_idpelanggan();
    }
   
    public void auto_idpelanggan() {
        try {
            Class.forName(driver);
            Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
            Statement stt = (Statement) kon.createStatement();
            String sql = "SELECT * FROM tabel_pelanggan ORDER BY ID_Pelanggan DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idpelanggan = rs.getString("ID_Pelanggan").substring(1);
                String AN = "" + (Integer.parseInt(idpelanggan) + 1);
                String Nol = "";
                if(AN.length()==1)
                     {Nol = "000";}
                else if(AN.length()==2)
                     {Nol = "00";}
                else if(AN.length()==3)
                     {Nol = "0";}
                else if(AN.length()==4)
                     {Nol = "";}
                id_pelanggan.setText("P" + Nol + AN);
                } else {
                id_pelanggan.setText("P0001");
            } 
                rs.close();
                kon.close();
            } catch (Exception ex) {
                 System.err.println(ex.getMessage());
            }
    }
    public void membersihkan_teks() {
        nm_pelanggan.setText("");
        alamat_pelanggan.setText(""); 
        no_telp.setText("");
    }
    
    public void nonaktif_teks() {
        id_pelanggan.setEnabled(false);
        nm_pelanggan.setEnabled(false);
        alamat_pelanggan.setEnabled(false);
        no_telp.setEnabled(false);
    }
    
    public void aktif_teks() {
        id_pelanggan.setEnabled(true);
        nm_pelanggan.setEnabled(true);
        alamat_pelanggan.setEnabled(true);
        no_telp.setEnabled(true);
    }
    
  
    private javax.swing.table.DefaultTableModel tableModel= getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()        
    {
        return new javax.swing.table.DefaultTableModel
                (
                    new Object[][] {},
                    new String[] {"ID Pelanggan", "Nama Pelanggan", "Alamat", "Nomor Telepon"}
                )
    {
        boolean[] canEdit = new boolean[] {
            false, false, false, false
        };
        
       @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
       return canEdit[columnIndex];
        }
     };
   }
    
     String data[]= new String[4];
     private void settableload() {
           String stat = "";
           try {
               Class.forName(driver);
                       Connection kon = (Connection) DriverManager.getConnection(database,user,pass);      
                       
                       Statement stt=(Statement) kon.createStatement();
                       String SQL = "select * from tabel_pelanggan";
                       ResultSet res = stt.executeQuery(SQL);
                       while(res.next()) {
                        data[0] = res.getString(1); 
                        data[1] = res.getString(2); 
                        data[2] = res.getString(3);
                        data[3] = res.getString(4); 
                        
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nm_pelanggan = new javax.swing.JTextField();
        alamat_pelanggan = new javax.swing.JTextField();
        no_telp = new javax.swing.JTextField();
        id_pelanggan = new javax.swing.JLabel();
        simpan_pelanggan = new javax.swing.JButton();
        ubah_pelanggan = new javax.swing.JButton();
        hapus_pelanggan = new javax.swing.JButton();
        batal_pelanggan = new javax.swing.JButton();
        selesai_pelanggan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pelanggan = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        jLabel1.setText("ID Pelanggan");

        jLabel2.setText("Nama Pelanggan");

        jLabel3.setText("Alamat");

        jLabel4.setText("Nomor Telepon");

        nm_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nm_pelangganActionPerformed(evt);
            }
        });

        alamat_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_pelangganActionPerformed(evt);
            }
        });

        no_telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_telpActionPerformed(evt);
            }
        });

        id_pelanggan.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_pelanggan)
                    .addComponent(nm_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {alamat_pelanggan, nm_pelanggan, no_telp});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_pelanggan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nm_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(alamat_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        simpan_pelanggan.setText("SIMPAN");
        simpan_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_pelangganActionPerformed(evt);
            }
        });

        ubah_pelanggan.setText("UBAH");
        ubah_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_pelangganActionPerformed(evt);
            }
        });

        hapus_pelanggan.setText("HAPUS");
        hapus_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_pelangganActionPerformed(evt);
            }
        });

        batal_pelanggan.setText("BATAL");
        batal_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_pelangganActionPerformed(evt);
            }
        });

        selesai_pelanggan.setText("SELESAI");
        selesai_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesai_pelangganActionPerformed(evt);
            }
        });

        tbl_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(simpan_pelanggan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ubah_pelanggan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(hapus_pelanggan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(batal_pelanggan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                            .addComponent(selesai_pelanggan))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {batal_pelanggan, hapus_pelanggan, selesai_pelanggan, simpan_pelanggan, ubah_pelanggan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan_pelanggan)
                    .addComponent(ubah_pelanggan)
                    .addComponent(hapus_pelanggan)
                    .addComponent(batal_pelanggan)
                    .addComponent(selesai_pelanggan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nm_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nm_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nm_pelangganActionPerformed

    private void alamat_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_pelangganActionPerformed

    private void no_telpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_telpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_telpActionPerformed

    private void simpan_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_pelangganActionPerformed
        String data[]=new String[4];

        
        if (nm_pelanggan.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan dilengkapi");
            nm_pelanggan.requestFocus();
        } else {
        try {
         Class.forName(driver);
         Connection kon = (Connection) DriverManager.getConnection(database, user, pass);
         Statement stt = (Statement) kon.createStatement();
         String SQL = "INSERT INTO tabel_pelanggan (ID_Pelanggan,"
                                                       + "Nama_Pelanggan,"
                                                       + "Alamat,"
                                                       + "No_Telp)"
                                                       + "VALUES" 
                                                       + "('"+id_pelanggan.getText()+"',"                
                                                       + "'"+nm_pelanggan.getText()+"',"
                                                       + "'"+alamat_pelanggan.getText()+"',"
                                                       + "'"+no_telp.getText()+"')";
                      stt.executeUpdate(SQL);
                      data[0]  = id_pelanggan.getText();                     
                      data[1]  = nm_pelanggan.getText();
                      data[2]  = alamat_pelanggan.getText();
                      data[3]  = no_telp.getText();
                      auto_idpelanggan();
                      
                      tableModel.setRowCount(0);
                      settableload();
                      stt.close();
                      kon.close();
                      membersihkan_teks();
                      simpan_pelanggan.setEnabled(true);
                      ubah_pelanggan.setEnabled(true);
                      hapus_pelanggan.setEnabled(true);
                      batal_pelanggan.setEnabled(true);
                      
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Gagal Terhubung Ke Database", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    int row = 0;
    public void tampil_pelanggan() {
        row = tbl_pelanggan.getSelectedRow();
        
        id_pelanggan.setText(tableModel.getValueAt(row, 0).toString());
        nm_pelanggan.setText(tableModel.getValueAt(row, 1).toString());
        alamat_pelanggan.setText(tableModel.getValueAt(row, 2).toString());
        no_telp.setText(tableModel.getValueAt(row, 3).toString());
      
      ubah_pelanggan.setEnabled(true);  
      hapus_pelanggan.setEnabled(true);
      simpan_pelanggan.setEnabled(true);
    }//GEN-LAST:event_simpan_pelangganActionPerformed

    private void ubah_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_pelangganActionPerformed
        int  ubah= JOptionPane.showConfirmDialog(null,"Apakah anda ingin Mengubah data ini?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        
        if(ubah==JOptionPane.YES_OPTION) {
                
            String IDPel  = id_pelanggan.getText();
            String NamPel  = nm_pelanggan.getText();
            String AlaPel = alamat_pelanggan.getText();
            String NomTel = no_telp.getText();
          
        if ((NamPel.isEmpty()) || (NamPel.isEmpty())){
            JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong, Slilahkan Dilengkapi");
            nm_pelanggan.requestFocus();
        } else {
            try {
                    Class.forName(driver);
                    Connection kon = (Connection) DriverManager.getConnection(database,user, pass);
                    Statement stt = (Statement) kon.createStatement();
                    String SQL = "UPDATE `tabel_pelanggan` "
                                    + "SET `ID_Pelanggan`= '"+IDPel+"',"
                                    + "`Nama_Pelanggan`= '"+NamPel+"',"
                                    + "`Alamat`= '"+AlaPel+"',"
                                    + "`No_Telp`= '"+NomTel+"'"
                            + "WHERE "
                            + "`ID_Pelanggan`='"+tableModel.getValueAt(row, 0).toString()+"';";
                    stt.executeUpdate(SQL);
                    data[0] = IDPel;
                    data[1] = NamPel;
                    data[2] = AlaPel;
                    data[3] = NomTel;
                    
                    tableModel.removeRow(row);
                    tableModel.insertRow(row, data);
                    stt.close();
                    kon.close();
                    tbl_pelanggan.clearSelection();

                    tableModel.setRowCount(0);
                    settableload();
                    auto_idpelanggan();
                                        
                    membersihkan_teks();
                    simpan_pelanggan.setEnabled(true);
                    hapus_pelanggan.setEnabled(true);
                } catch (Exception ex) {
                            System.err.println(ex.getMessage());
            }
        }
            } else if(ubah==JOptionPane.NO_OPTION) {
            batal_pelangganActionPerformed(evt);
        }
    }//GEN-LAST:event_ubah_pelangganActionPerformed

    private void batal_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_pelangganActionPerformed
         membersihkan_teks();
         auto_idpelanggan();
        simpan_pelanggan.setVisible(true);
    }//GEN-LAST:event_batal_pelangganActionPerformed

    private void hapus_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_pelangganActionPerformed
        int  hapus= JOptionPane.showConfirmDialog(null,"Apakah anda ingin Menghapus data ini?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        
        if(hapus==JOptionPane.YES_OPTION) {
        int baris = tbl_pelanggan.getSelectedRow();
            if (baris != -1) {
                String idpelanggan = tbl_pelanggan.getValueAt(baris, 0).toString();
                String SQL = "DELETE FROM tabel_pelanggan WHERE ID_Pelanggan='"+idpelanggan+"'";
                tableModel.removeRow(row);
                membersihkan_teks();
                int status = du_rentalmobil.koneksi.koneksiRental.execute(SQL);
                if (status==1) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    auto_idpelanggan();
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih dahulu", "Error !!", JOptionPane.WARNING_MESSAGE);
            }
        } else if(hapus==JOptionPane.NO_OPTION) {
            batal_pelangganActionPerformed(evt);        }
            aktif_teks();
    }//GEN-LAST:event_hapus_pelangganActionPerformed

    private void selesai_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesai_pelangganActionPerformed
        this.dispose();
    }//GEN-LAST:event_selesai_pelangganActionPerformed

    private void tbl_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pelangganMouseClicked
           if(evt.getClickCount() == 1) {
            tampil_pelanggan();
           }
    }//GEN-LAST:event_tbl_pelangganMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_pelanggan;
    private javax.swing.JButton batal_pelanggan;
    private javax.swing.JButton hapus_pelanggan;
    private javax.swing.JLabel id_pelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nm_pelanggan;
    private javax.swing.JTextField no_telp;
    private javax.swing.JButton selesai_pelanggan;
    private javax.swing.JButton simpan_pelanggan;
    private javax.swing.JTable tbl_pelanggan;
    private javax.swing.JButton ubah_pelanggan;
    // End of variables declaration//GEN-END:variables
}
