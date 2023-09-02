package TokoFarda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class menuDataHutang extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
    Calendar hariIni;
    
    private DefaultTableModel model;
    private Timer timer;

    public menuDataHutang() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();
        
        model = new DefaultTableModel();
        tbHutang.setModel(model);
        model.addColumn("Kode Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("No Telp");
        model.addColumn("Alamat");
        model.addColumn("Jumlah Hutang");
        
        //membuat timer dengan delay 1000ms (1 dt) dan AcctionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDayDateTime();
            }
        });
        
        timer.start();
        getData();
    }
    
    void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql = "SELECT `Nama_Pelanggan`, `No_Telp`, `Alamat`, `Jumlah_Hutang`, `Kode_TransaksiJual` FROM `hutang` ORDER BY id_Hutang ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString("Kode_TransaksiJual");
                obj[1] = rs.getString("Nama_Pelanggan");
                obj[2] = rs.getString("No_Telp");
                obj[3] = rs.getString("Alamat");
                obj[4] = rs.getString("Jumlah_Hutang");
                
                model.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void pilihData(){
        int i = tbHutang.getSelectedRow();
        
        //mengambil id user berdasarkan data yang dipilih
        String sql1 = "select * from hutang where Kode_TransaksiJual='" + model.getValueAt(i, 0).toString() + "'";
        String idHutang = "";
        try{
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();

            if(rs.next()){
                session.setIdHutang(rs.getString("id_Hutang")) ;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        txtKodeTransaksi.setText(model.getValueAt(i, 0).toString());
        txtNamaPelanggan.setText(model.getValueAt(i, 1).toString());
        txtTelp.setText(model.getValueAt(i, 2).toString());
        txtAlamat.setText(model.getValueAt(i, 3).toString());
        txtHutang.setText(model.getValueAt(i, 4).toString());
    }
    
    void bersih(){
        txtKodeTransaksi.setText("");
        txtNamaPelanggan.setText("");
        txtTelp.setText("");
        txtAlamat.setText("");
        txtHutang.setText("");
        txtBayar.setText("");
        txtSisaBayar.setText("");
        txtKembalian.setText("");
    }
    
    private void showDayDateTime(){
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in", "ID"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hari = formatHari.format(calendar.getTime());
        String dateTime = dateFormat.format(now);
        lb_tanggal.setText(hari+ ", " +dateTime);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHutang = new javax.swing.JTable();
        kodeTransaksi = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        namaPelanggan = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        No_telepon = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        Alamat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        Jumlah_hutang = new javax.swing.JLabel();
        txtHutang = new javax.swing.JTextField();
        bayar = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        sisa = new javax.swing.JLabel();
        txtSisaBayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        btnSimpan = new rojerusan.RSMaterialButtonRectangle();
        btnBatal = new rojerusan.RSMaterialButtonRectangle();
        txtCari = new javax.swing.JTextField();

        background.setBackground(new java.awt.Color(207, 212, 220));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(237, 237, 237));
        header.setPreferredSize(new java.awt.Dimension(1270, 68));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Tabel Data Hutang");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Jam Tanggal");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 805, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addGap(126, 126, 126))
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

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        tbHutang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHutang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHutangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHutang);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 482, -1));

        kodeTransaksi.setText("Kode Transaksi");
        background.add(kodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 118, -1, -1));

        txtKodeTransaksi.setEditable(false);
        txtKodeTransaksi.setFocusable(false);
        background.add(txtKodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 140, 423, 30));

        namaPelanggan.setText("Nama Pelanggan");
        background.add(namaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 182, -1, -1));

        txtNamaPelanggan.setEditable(false);
        txtNamaPelanggan.setFocusable(false);
        background.add(txtNamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 204, 423, 30));

        No_telepon.setText("No Telepon");
        background.add(No_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 246, -1, -1));

        txtTelp.setEditable(false);
        txtTelp.setFocusable(false);
        background.add(txtTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 268, 423, 30));

        Alamat.setText("Alamat");
        background.add(Alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 310, -1, -1));

        txtAlamat.setEditable(false);
        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        txtAlamat.setFocusable(false);
        jScrollPane2.setViewportView(txtAlamat);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 332, 423, -1));

        Jumlah_hutang.setText("Jumlah Hutang");
        background.add(Jumlah_hutang, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 430, -1, -1));

        txtHutang.setEditable(false);
        txtHutang.setFocusable(false);
        txtHutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHutangActionPerformed(evt);
            }
        });
        background.add(txtHutang, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 452, 423, 30));

        bayar.setText("Bayar");
        background.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 500, -1, -1));

        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBayarKeyReleased(evt);
            }
        });
        background.add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 522, 423, 30));

        sisa.setText("Sisa Bayar");
        background.add(sisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 570, -1, -1));

        txtSisaBayar.setEditable(false);
        txtSisaBayar.setFocusable(false);
        background.add(txtSisaBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 592, 423, 30));

        kembalian.setText("Kembalian");
        background.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 640, -1, -1));

        txtKembalian.setEditable(false);
        txtKembalian.setFocusable(false);
        background.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 662, 423, 30));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        background.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 190, 50));

        btnBatal.setBackground(new java.awt.Color(255, 0, 0));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        background.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 600, 190, 50));

        txtCari.setText("Cari...");
        txtCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCariFocusLost(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });
        background.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 250, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHutangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHutangActionPerformed

    private void tbHutangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHutangMouseClicked
        // TODO add your handling code here:
        pilihData();
    }//GEN-LAST:event_tbHutangMouseClicked

    private void txtBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyReleased
        // TODO add your handling code here:
        int bayar = Integer.parseInt(txtBayar.getText());
        int hutang = Integer.parseInt(txtHutang.getText());
        int fungsi = hutang - bayar;
        int lain = bayar - hutang;
        
        if(fungsi == 0) {
                txtSisaBayar.setText(""+fungsi);
                txtKembalian.setText(""+fungsi);
            } else if (bayar > hutang){
                txtSisaBayar.setText("" + 0);
                txtKembalian.setText("" + lain);
            } else if (fungsi < hutang) {
                txtSisaBayar.setText("" + fungsi);
                txtKembalian.setText("" + 0);
            }
    }//GEN-LAST:event_txtBayarKeyReleased

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih();
        getData();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(txtBayar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan nominal bayar terlebih dahulu");
        }else{
            try{
                Long.parseLong(txtBayar.getText());
                
                if(txtSisaBayar.getText().equals("0")){
                String sql = "delete from hutang where id_Hutang='" + session.getIdHutang() + "'";

                try{
                    pst = conn.prepareStatement(sql);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan, Hutang Lunas");
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                    getData();
                    bersih();
                }else{
                    String sql1 = "update hutang set Jumlah_Hutang='" + txtSisaBayar.getText() + "' where id_Hutang='" + session.getIdHutang() + "'";

                    try{
                        pst = conn.prepareStatement(sql1);
                        pst.execute();

                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan, Mohon segera melunasi hutang");
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                    getData();
                    bersih();
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Masukan angka dengan benar");
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            String sql = "SELECT `Nama_Pelanggan`, `No_Telp`, `Alamat`, `Jumlah_Hutang`, `Kode_TransaksiJual` FROM `hutang` where Kode_TransaksiJual like '%" + txtCari.getText() + "%' ORDER BY id_Hutang ASC" ; 

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString("Kode_TransaksiJual");
                obj[1] = rs.getString("Nama_Pelanggan");
                obj[2] = rs.getString("No_Telp");
                obj[3] = rs.getString("Alamat");
                obj[4] = rs.getString("Jumlah_Hutang");
                
                model.addRow(obj);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusGained
        // TODO add your handling code here:
        String cari = txtCari.getText();
        if(cari.equals("Cari...")){
            txtCari.setText("");
        }
    }//GEN-LAST:event_txtCariFocusGained

    private void txtCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusLost
        // TODO add your handling code here:
        String cari = txtCari.getText();
        if(cari.equals("")||cari.equals("Cari...")){
            txtCari.setText("Cari...");
        }
    }//GEN-LAST:event_txtCariFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Jumlah_hutang;
    private javax.swing.JLabel No_telepon;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bayar;
    private rojerusan.RSMaterialButtonRectangle btnBatal;
    private rojerusan.RSMaterialButtonRectangle btnSimpan;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel kodeTransaksi;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel namaPelanggan;
    private javax.swing.JLabel sisa;
    private javax.swing.JTable tbHutang;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHutang;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtSisaBayar;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
