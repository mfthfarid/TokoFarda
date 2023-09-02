/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TokoFarda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class menuDataTransaksi extends javax.swing.JPanel {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private Timer timer;


    public menuDataTransaksi() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();

        //memberi penamaan pada judul kolom
        model = new DefaultTableModel();
        tbTransakasiJual.setModel(model);
        model.addColumn("Kode Transaksi");
        model.addColumn("Status Pembayaran");
        model.addColumn("Tanggal");
        model.addColumn("Total");
        model.addColumn("Bayar");
        model.addColumn("Nama User");
        
        //memberi penamaan pada judul kolom
        model1 = new DefaultTableModel();
        tbTransaksiBeli.setModel(model1);
        model1.addColumn("Kode Transaksi");
        model1.addColumn("Tanggal");
        model1.addColumn("Total");
        model1.addColumn("Bayar");
        model1.addColumn("Nama User");
        
        //membuat timer dengan delay 1000ms (1 dt) dan AcctionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDayDateTime();
            }
        });

        timer.start();
        getDataJual();
        getDataBeli();
    }
    
    private void showDayDateTime() {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in", "ID"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hari = formatHari.format(calendar.getTime());
        String dateTime = dateFormat.format(now);
        lb_tanggal.setText(hari + ", " + dateTime);

    }
    
    void getDataJual(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql =    "SELECT tj.Kode_TransaksiJual, tj.Status_Pembayaran, tj.Tanggal, tj.Total, tj.Bayar, u.Nama_User\n" +
                            "FROM transaksi_jual tj JOIN user u ON u.Id_User = tj.id_user\n" +
                            "ORDER BY tj.Kode_TransaksiJual ASC;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[6];
                obj[0] = rs.getString("Kode_TransaksiJual");
                obj[1] = rs.getString("Status_Pembayaran");
                obj[2] = rs.getString("Tanggal");
                obj[3] = rs.getString("Total");
                obj[4] = rs.getString("Bayar");
                obj[5] = rs.getString("Nama_User");
                
                model.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void getDataBeli(){
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql =    "SELECT tb.Kode_TransaksiBeli, tb.Tanggal, tb.Total, tb.Bayar, u.Nama_User\n" +
                            "FROM transaksi_beli tb JOIN user u ON u.Id_User = tb.id_user\n" +
                            "ORDER BY tb.Kode_TransaksiBeli ASC;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString("Kode_TransaksiBeli");
                obj[1] = rs.getString("Tanggal");
                obj[2] = rs.getString("Total");
                obj[3] = rs.getString("Bayar");
                obj[4] = rs.getString("Nama_User");
                
                model1.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        lb_tanggal = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransakasiJual = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTransaksiBeli = new javax.swing.JTable();
        cariJual = new javax.swing.JTextField();
        cariBeli = new javax.swing.JTextField();
        btnDetailJual = new rojerusan.RSMaterialButtonRectangle();
        btnDetailBeli = new rojerusan.RSMaterialButtonRectangle();
        title2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(210, 215, 223));
        setPreferredSize(new java.awt.Dimension(1170, 750));

        header.setBackground(new java.awt.Color(238, 238, 238));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Menu Data Transaksi");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Tanggal, Jam");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 684, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addGap(177, 177, 177))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addContainerGap())
        );

        title1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title1.setText("Transaksi Jual");

        tbTransakasiJual.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTransakasiJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransakasiJualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTransakasiJual);

        tbTransaksiBeli.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTransaksiBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransaksiBeliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbTransaksiBeli);

        cariJual.setText("Cari...");
        cariJual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cariJualFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cariJualFocusLost(evt);
            }
        });
        cariJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariJualKeyTyped(evt);
            }
        });

        cariBeli.setText("Cari...");
        cariBeli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cariBeliFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cariBeliFocusLost(evt);
            }
        });
        cariBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariBeliKeyTyped(evt);
            }
        });

        btnDetailJual.setText("Detail");
        btnDetailJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailJualActionPerformed(evt);
            }
        });

        btnDetailBeli.setText("Detail");
        btnDetailBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailBeliActionPerformed(evt);
            }
        });

        title2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title2.setText("Transaksi Beli");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariJual, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetailJual, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title1))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2)
                    .addComponent(btnDetailBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title1)
                    .addComponent(title2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetailJual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetailBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariJualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cariJualFocusGained
        // TODO add your handling code here:
        String cari = cariJual.getText();
        if(cari.equals("Cari...")){
            cariJual.setText("");
        }
    }//GEN-LAST:event_cariJualFocusGained

    private void cariJualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cariJualFocusLost
        // TODO add your handling code here:
        String cari = cariJual.getText();
        if(cari.equals("")||cari.equals("Cari...")){
            cariJual.setText("Cari...");
        }
    }//GEN-LAST:event_cariJualFocusLost

    private void cariBeliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cariBeliFocusGained
        // TODO add your handling code here:
        String cari = cariBeli.getText();
        if(cari.equals("Cari...")){
            cariBeli.setText("");
        }
    }//GEN-LAST:event_cariBeliFocusGained

    private void cariBeliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cariBeliFocusLost
        // TODO add your handling code here:
        String cari = cariBeli.getText();
        if(cari.equals("")||cari.equals("Cari...")){
            cariBeli.setText("Cari...");
        }
    }//GEN-LAST:event_cariBeliFocusLost

    private void cariJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariJualKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            String sql = "SELECT tj.Kode_TransaksiJual, tj.Status_Pembayaran, tj.Tanggal, tj.Total, tj.Bayar, u.Nama_User\n" +
                        "FROM transaksi_jual tj\n" +
                        "JOIN user u ON u.Id_User = tj.id_user\n" +
                        "WHERE tj.Kode_TransaksiJual like '%" + cariJual.getText() + "%'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                Object[] obj = new Object[6];
                obj[0] = rs.getString("Kode_TransaksiJual");
                obj[1] = rs.getString("Status_Pembayaran");
                obj[2] = rs.getString("Tanggal");
                obj[3] = rs.getString("Total");
                obj[4] = rs.getString("Bayar");
                obj[5] = rs.getString("Nama_User");
                
                model.addRow(obj);
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cariJualKeyTyped

    private void cariBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBeliKeyTyped
        // TODO add your handling code here:
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        try{
            String sql = "SELECT tb.Kode_TransaksiBeli, tb.Tanggal, tb.Total, tb.Bayar, u.Nama_User\n" +
                        "FROM transaksi_beli tb\n" +
                        "JOIN user u ON u.Id_User = tb.id_user\n" +
                        "WHERE tb.Kode_TransaksiBeli like '%" + cariBeli.getText() + "%'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString("Kode_TransaksiBeli");
                obj[1] = rs.getString("Tanggal");
                obj[2] = rs.getString("Total");
                obj[3] = rs.getString("Bayar");
                obj[4] = rs.getString("Nama_User");
                
                model1.addRow(obj);
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cariBeliKeyTyped

    private void btnDetailJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailJualActionPerformed
        // TODO add your handling code here:
        detailTransaksiJual tj = new detailTransaksiJual();
        tj.setVisible(true);
        tj.setLocationRelativeTo(null);
        tj.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnDetailJualActionPerformed

    private void tbTransakasiJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransakasiJualMouseClicked
        // TODO add your handling code here:
        int i = tbTransakasiJual.getSelectedRow();
        session.setKodeTransaksi(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tbTransakasiJualMouseClicked

    private void tbTransaksiBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransaksiBeliMouseClicked
        // TODO add your handling code here:
        int i = tbTransaksiBeli.getSelectedRow();
        session.setKodeTransaksiBeli(model1.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tbTransaksiBeliMouseClicked

    private void btnDetailBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailBeliActionPerformed
        // TODO add your handling code here:
        detailTransaksiBeli tb = new detailTransaksiBeli();
        tb.setVisible(true);
        tb.setLocationRelativeTo(null);
        tb.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnDetailBeliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnDetailBeli;
    private rojerusan.RSMaterialButtonRectangle btnDetailJual;
    private javax.swing.JTextField cariBeli;
    private javax.swing.JTextField cariJual;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JTable tbTransakasiJual;
    private javax.swing.JTable tbTransaksiBeli;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
