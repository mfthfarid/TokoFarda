/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TokoFarda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class menuJenisBarang extends javax.swing.JPanel {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;    
    
    public menuJenisBarang() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();
        
        //memberi penamaan pada judul kolom
        model = new DefaultTableModel();
        tb_JenisBarang.setModel(model);
        model.addColumn("Jenis Barang");
        
        getData();
    }
    
    void getData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            //membuat statement pemanggilan data tabel barang dari database
            String sql = "SELECT * FROM `jenis_barang` ORDER BY id_JenisBarang ASC";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[1];
                obj[0] = rs.getString("Jenis_Barang");
                
                model.addRow(obj);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);            
        }
    }
    
    void Bersih(){
        txt_JenisBarang.setText("");
    }

    void PilihData() {
        int i = tb_JenisBarang.getSelectedRow();
        
        //mengambil id jenis barang berdasarkan data yang dipilih
        String sql1 = "select * from jenis_barang where Jenis_Barang='" + model.getValueAt(i, 0).toString() + "'";
        String id_JenisBarang = "";
        try{
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();

            if(rs.next()){
                session.setId_JenisBarang(rs.getString("id_JenisBarang")) ;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        txt_JenisBarang.setText(model.getValueAt(i, 0).toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txt_Cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_JenisBarang = new javax.swing.JTable();
        JenisBarang = new javax.swing.JLabel();
        txt_JenisBarang = new javax.swing.JTextField();
        btn_tambah = new rojerusan.RSMaterialButtonRectangle();
        btn_refresh = new rojerusan.RSMaterialButtonRectangle();
        btn_hapus = new rojerusan.RSMaterialButtonRectangle();
        btn_edit = new rojerusan.RSMaterialButtonRectangle();

        setPreferredSize(new java.awt.Dimension(1170, 750));

        header.setBackground(new java.awt.Color(237, 237, 237));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Tabel Jenis Barang");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addContainerGap(951, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(title)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        txt_Cari.setText("Cari...");
        txt_Cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_CariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CariFocusLost(evt);
            }
        });
        txt_Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CariKeyTyped(evt);
            }
        });

        tb_JenisBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_JenisBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_JenisBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_JenisBarang);

        JenisBarang.setText("Jenis Barang");

        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JenisBarang)
                    .addComponent(txt_JenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(JenisBarang)
                        .addGap(6, 6, 6)
                        .addComponent(txt_JenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_JenisBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_JenisBarangMouseClicked
        // TODO add your handling code here:
        PilihData();
    }//GEN-LAST:event_tb_JenisBarangMouseClicked

    private void txt_CariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CariKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            String sql = "select * from jenis_barang where Jenis_Barang like '%" +txt_Cari.getText()+ "%'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

             while(rs.next()) {
                Object[] obj = new Object[1];
                obj[0] = rs.getString("Jenis_Barang");
                
                model.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_CariKeyTyped

    private void txt_CariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CariFocusGained
        // TODO add your handling code here:
        String cari = txt_Cari.getText();
        if(cari.equals("Cari...")){
            txt_Cari.setText("");
        }
    }//GEN-LAST:event_txt_CariFocusGained

    private void txt_CariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CariFocusLost
        // TODO add your handling code here:
        String cari = txt_Cari.getText();
        if(cari.equals("")){
            txt_Cari.setText("Cari...");
        }
    }//GEN-LAST:event_txt_CariFocusLost

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into jenis_barang (Jenis_Barang)values(?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_JenisBarang.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                    
            getData();
            Bersih();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);            
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        Bersih();
        getData();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null,
            "Apakah benar-benar akan dihapus permanen?",
            "Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (p == 0) {
            String sql = "delete from jenis_barang where id_JenisBarang='" + session.getId_JenisBarang() + "'" ;
            try{
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        getData();
        Bersih();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        try{
            String JenisBarang = txt_JenisBarang.getText();

            String sql = "update jenis_barang set Jenis_Barang='" +JenisBarang+ "'where id_JenisBarang='" +session.getId_JenisBarang()+ "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            getData();
            Bersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JenisBarang;
    private rojerusan.RSMaterialButtonRectangle btn_edit;
    private rojerusan.RSMaterialButtonRectangle btn_hapus;
    private rojerusan.RSMaterialButtonRectangle btn_refresh;
    private rojerusan.RSMaterialButtonRectangle btn_tambah;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_JenisBarang;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_JenisBarang;
    // End of variables declaration//GEN-END:variables
}
