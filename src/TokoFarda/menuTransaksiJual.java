/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TokoFarda;

import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;


public class menuTransaksiJual extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private Timer timer;

    
    public int thotal;
    public int tot_brg;
    ArrayList<String> idList = new ArrayList<String>();
    
    public menuTransaksiJual() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();
        
        //memberi penamaan pada judul kolom
        model = new DefaultTableModel();
        tbBarang.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal Expired");
        model.addColumn("Stok");
        model.addColumn("Harga");
        
         //membuat timer dengan delay 1000ms (1 dt) dan AcctionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDayDateTime();
            }
        });

        timer.start();
        getData();
        tampilkanBarangBeli();
        kodeTransaksiJual();
    }
    
    void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            // Mendapatkan tanggal saat ini
            Date currentDate = new Date();
            
            //membuat statement pemanggilan data tabel barang dari database
            String sql = "SELECT * FROM barang WHERE Tgl_Expired >= ? ORDER BY Kode_Barang ASC";
            
            pst = conn.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(currentDate.getTime()));
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[5];
                
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Stok");
                obj[4] = rs.getString("Harga_Jual");
                
                model.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void Bersih(){
        txtHargaBarang.setText("");
        txtJumlah.setText("");
        txtSubTotal.setText("");
        txtCari.setText("Cari...");
        txtBayar.setText("");
        lbTotal.setText("0");
        txtStatusPembayaran.setText("");
        txtSisaBayar.setText("");
        txtKembalian.setText("");
    }
    
    void resetKeranjang(){
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
    }
    
    public void tampilkanBarangBeli(){
        String[] judul = {"Kode Barang","Nama Barang", "Harga", "Jumlah", "Subtotal"};
        model1 = new DefaultTableModel(judul,0);
        tbKeranjang.setModel(model1);
    }
    
    private void setTotalHarga(){
        int totalBarang = 0;
        int row = tbKeranjang.getRowCount();
        int total = 0;
        for(int i = 0; i < row; i++) {
            int sb = Integer.parseInt(tbKeranjang.getValueAt(i, 4).toString());
            int tot = Integer.parseInt(tbKeranjang.getValueAt(i, 3).toString());
            total = total + (sb);
            totalBarang = totalBarang+tot;
        }
        this.tot_brg = totalBarang;
        
        this.thotal = total;
        lbTotal.setText(String.valueOf(this.thotal));
    }
    
    public void kodeTransaksiJual(){
        try{
            String sql = "SELECT Kode_TransaksiJual FROM `transaksi_jual` ORDER BY Kode_TransaksiJual DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            if(rs.next()){
                String noJual = rs.getString("Kode_TransaksiJual").substring(2);
                String AN = "" + (Integer.parseInt(noJual)+1);
                String nol = "";

                if(AN.length()==1){
                    nol = "000";
                }else if(AN.length()==2){
                    nol = "00";
                }else if(AN.length()==3){
                    nol = "0";
                }else if(AN.length()==4){
                    nol = "";
                }
                txtKodeTransaksi.setText("TR" + nol + AN);
            } else {
                txtKodeTransaksi.setText("TR0001");
            }
            rs.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBarang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKeranjang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        haragaBarang = new javax.swing.JLabel();
        txtHargaBarang = new javax.swing.JTextField();
        jumlahBarang = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        subTotalBarang = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        btnRefresh = new rojerusan.RSMaterialButtonRectangle();
        btnHapus = new rojerusan.RSMaterialButtonRectangle();
        btnTambahKeranjang = new rojerusan.RSMaterialButtonRectangle();
        totalHarga = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        statusPembayaran = new javax.swing.JLabel();
        txtStatusPembayaran = new javax.swing.JTextField();
        Kembalian = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        sisaBayar = new javax.swing.JLabel();
        txtSisaBayar = new javax.swing.JTextField();
        btnSimpan = new rojerusan.RSMaterialButtonRectangle();
        kodeTransaksi = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        btnCetak = new rojerusan.RSMaterialButtonRectangle();
        lbRp = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(210, 215, 223));
        setPreferredSize(new java.awt.Dimension(1170, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(238, 238, 238));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Menu Transaksi Jual");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Tanggal, Jam");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 741, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addGap(125, 125, 125))
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

        add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, -1));

        tbBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBarang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 488, 300));

        tbKeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbKeranjang);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 495, 287));

        jPanel1.setBackground(new java.awt.Color(210, 215, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        haragaBarang.setText("Harga Barang :");
        jPanel1.add(haragaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, -1, -1));

        txtHargaBarang.setEditable(false);
        txtHargaBarang.setFocusable(false);
        jPanel1.add(txtHargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 34, 130, -1));

        jumlahBarang.setText("Jumlah Barang :");
        jPanel1.add(jumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 77, -1, -1));

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 74, 130, -1));

        subTotalBarang.setText("SubTotal Barang :");
        jPanel1.add(subTotalBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 117, -1, -1));

        txtSubTotal.setEditable(false);
        txtSubTotal.setFocusable(false);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 114, 128, -1));

        btnRefresh.setBackground(new java.awt.Color(102, 255, 0));
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 164, 78, 34));

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setForeground(new java.awt.Color(0, 0, 0));
        btnHapus.setText("hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 164, 80, 34));

        btnTambahKeranjang.setBackground(new java.awt.Color(255, 255, 0));
        btnTambahKeranjang.setForeground(new java.awt.Color(0, 0, 0));
        btnTambahKeranjang.setText("tambah keranjang");
        btnTambahKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKeranjangActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambahKeranjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 210, 254, 54));

        totalHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalHarga.setText("Total Belanja");
        jPanel1.add(totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        bayar.setText("Bayar :");
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 77, -1, -1));

        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBayarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 74, 143, -1));

        statusPembayaran.setText("Status Pembayaran :");
        jPanel1.add(statusPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 117, -1, -1));

        txtStatusPembayaran.setEditable(false);
        txtStatusPembayaran.setFocusable(false);
        jPanel1.add(txtStatusPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 114, 145, -1));

        Kembalian.setText("Kembalian :");
        jPanel1.add(Kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 183, -1, -1));

        txtKembalian.setEditable(false);
        txtKembalian.setFocusable(false);
        jPanel1.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 180, 143, -1));

        sisaBayar.setText("Sisa Bayar :");
        jPanel1.add(sisaBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 151, -1, -1));

        txtSisaBayar.setEditable(false);
        txtSisaBayar.setFocusable(false);
        jPanel1.add(txtSisaBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 148, 143, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 171, 98, 40));

        kodeTransaksi.setText("Kode Transaksi :");
        jPanel1.add(kodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 37, -1, -1));

        txtKodeTransaksi.setEditable(false);
        txtKodeTransaksi.setFocusable(false);
        jPanel1.add(txtKodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 34, 143, -1));

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        jPanel1.add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 171, 98, 40));

        lbRp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbRp.setText("RP.");
        jPanel1.add(lbRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 220, 70));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTotal.setText("0");
        jPanel1.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 200, 70));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 1090, 270));

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
        add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 272, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tbBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBarangMouseClicked
        // TODO add your handling code here:
        int baris = tbBarang.rowAtPoint(evt.getPoint());
        tbBarang.rowAtPoint(evt.getPoint());
        
        tbBarang.getValueAt(baris,0).toString();
        tbBarang.getValueAt(baris, 1).toString();
        tbBarang.getValueAt(baris, 2).toString();
        session.setStok(Integer.parseInt(tbBarang.getValueAt(baris, 3).toString()));
        String harga = tbBarang.getValueAt(baris, 4).toString();
        txtHargaBarang.setText(harga);
        
    }//GEN-LAST:event_tbBarangMouseClicked

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        getData();
        Bersih();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKeranjangActionPerformed
        // TODO add your handling code here:
        if(txtHargaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap pilih barang terlebih dahulu!!");
        } else {
            if(txtJumlah.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Harap masukan jumlah barang!!");
            } else {
                int jumlah = Integer.parseInt(txtJumlah.getText());

                try{
                    int row = tbBarang.getSelectedRow();
                    if((jumlah==0)&&(txtJumlah.getText().equals(""))){
                        JOptionPane.showMessageDialog(null, "Harap masukan jumlah barang dengan benar!");
                    } else {
                        boolean result = idList.contains(tbBarang.getValueAt(row, 0).toString());

                        if(result==false){
                            idList.add(tbBarang.getValueAt(row, 0).toString());
                            String data[] = {tbBarang.getValueAt(row, 0).toString(),
                                tbBarang.getValueAt(row, 1).toString(),
                                tbBarang.getValueAt(row, 4).toString(),
                                txtJumlah.getText(),txtSubTotal.getText()
                            };
                            model1.addRow(data);
                            Bersih();
                            setTotalHarga();
                        }
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnTambahKeranjangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = tbKeranjang.getSelectedRow();
        idList.remove(row);
        model1.removeRow(row);
        setTotalHarga();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyReleased
        // TODO add your handling code here:
        try{
//            Integer.parseInt(txtBayar.getText());
            int bayar = Integer.parseInt(txtBayar.getText());
            int total = Integer.parseInt(lbTotal.getText());
            int fungsi = total - bayar;
            int lain = bayar - total;
            
            if(fungsi == 0) {
                txtStatusPembayaran.setText("Lunas");
                txtSisaBayar.setText(""+fungsi);
                txtKembalian.setText(""+fungsi);
            } else if (bayar > total){
                txtStatusPembayaran.setText("Lunas");
                txtSisaBayar.setText("" + 0);
                txtKembalian.setText("" + lain);
            } else if (fungsi < total) {
                txtStatusPembayaran.setText("Hutang");
                txtSisaBayar.setText("" + fungsi);
                txtKembalian.setText("" + 0);
            }
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_txtBayarKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(lbTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Harap pilih barang yang dibeli!!");
        } else {
            try{
                Long.parseLong(txtBayar.getText());
                int rows = tbKeranjang.getRowCount();
                String statusBayar = txtStatusPembayaran.getText();
                int totalHarga = Integer.parseInt(lbTotal.getText());
                int bayar = Integer.parseInt(txtBayar.getText());
                String KodeTransaksi = txtKodeTransaksi.getText();
                session.setKodeTransaksi(KodeTransaksi);
                session.setSisaBayar(txtSisaBayar.getText());
                session.setKembalian(txtKembalian.getText());
                session.setKurang(txtSisaBayar.getText());

                try{

                    String sql = "INSERT INTO transaksi_jual values ('" + KodeTransaksi + "','" + statusBayar + "',now(),'" + totalHarga + "','" + bayar + "','" + session.getU_Id() + "')";

                    pst = conn.prepareStatement(sql);
                    pst.execute();

                    for(int i = 0; i < rows; i++){
                        String sql1 = "insert into detail_transaksi_jual values ('" + KodeTransaksi + "','" + tbKeranjang.getValueAt(i, 0) + "','" + tbKeranjang.getValueAt(i, 3) + "','" + tbKeranjang.getValueAt(i, 4) + "')";
                        pst = conn.prepareStatement(sql1);
                        pst.execute();
                        
                        Bersih();
                        getData();
                    }
                    JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
                    resetKeranjang();

                    if (statusBayar.equals("Hutang")) {
                        formHutang htg = new formHutang();
                        htg.setVisible(true);
                        htg.setLocationRelativeTo(null);
                    }else{ 
                        try {
                            String file = "/Struk/StrukBelanja.jasper";

                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            HashMap param = new HashMap();

                            param.put("kode", txtKodeTransaksi.getText());
                            param.put("kembalian", session.getKembalian());
                            param.put("kurang", session.getKurang());

                            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file), param, Koneksi.Koneksi.KoneksiDB());
                            JasperPrintManager.printReport(print, false);
//JasperViewer.viewReport(print, false);

                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                            System.out.println(e);
                        } catch (JRException ex) {
                            Logger.getLogger(menuTransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        session.setKodeTransaksi("");

                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                kodeTransaksiJual();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Harap masukan nominal bayar dengan benar!!");
            }
        }   
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped

       model.getDataVector().removeAllElements();
       model.fireTableDataChanged();
       
       try {
           Date currentDate = new Date();
           String sql = "SELECT barang.Kode_Barang, barang.Nama_Barang, barang.Tgl_Expired, barang.Harga_Jual, barang.Stok, jenis_barang.Jenis_Barang, supplier.Nama_Supplier\n" +
                "FROM barang \n" +
                "JOIN jenis_barang ON jenis_barang.id_JenisBarang = barang.id_JenisBarang\n" +
                "JOIN supplier ON supplier.id_Supplier = barang.id_Supplier\n" +
                "where Kode_Barang like '%" + txtCari.getText() + "%' || Nama_Barang like '%" + txtCari.getText() + "%' order by Kode_Barang ASC" ; 
           
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()) {
                Object[] obj = new Object[5];
                
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Stok");
                obj[4] = rs.getString("Harga_Jual");
                
                model.addRow(obj);
            }
       } catch (Exception e){
           
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

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
//        try{
//            String file = "/Struk/StrukBelanja.jasper";
//            
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            HashMap param = new HashMap();
//            
//             param.put("kode",txtKodeTransaksi.getText());
////                    param.put("total",lbTotal.getText());
////                    param.put("uang",txtBayar.getText());
//                    param.put("kembalian",session.getKembalian());
//           
//            
//            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,Koneksi.Koneksi.KoneksiDB());
////            JasperViewer.viewReport(print, false);
//            JasperPrintManager.printReport(print, false);
//            
//        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException  e){
//            System.out.println(e);
//        } catch (JRException ex) {
//            Logger.getLogger(menuTransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
        // TODO add your handling code here:
        try{
            int jumll=Integer.parseInt(txtJumlah.getText());
            if (jumll>session.getStok()) {
                JOptionPane.showMessageDialog(null, "Stok e kurang masee");
            } else {
                int jumlah = Integer.parseInt(txtJumlah.getText());
                int harga = Integer.parseInt(txtHargaBarang.getText());
                int subTotal = 0;
                subTotal = jumlah*harga; 
                txtSubTotal.setText(""+subTotal);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Harap masukan jumlah dengan angka");
            txtJumlah.setText(""+1);
        }
    }//GEN-LAST:event_txtJumlahKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kembalian;
    private javax.swing.JLabel bayar;
    private rojerusan.RSMaterialButtonRectangle btnCetak;
    private rojerusan.RSMaterialButtonRectangle btnHapus;
    private rojerusan.RSMaterialButtonRectangle btnRefresh;
    private rojerusan.RSMaterialButtonRectangle btnSimpan;
    private rojerusan.RSMaterialButtonRectangle btnTambahKeranjang;
    private javax.swing.JLabel haragaBarang;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlahBarang;
    private javax.swing.JLabel kodeTransaksi;
    private javax.swing.JLabel lbRp;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel sisaBayar;
    private javax.swing.JLabel statusPembayaran;
    private javax.swing.JLabel subTotalBarang;
    private javax.swing.JTable tbBarang;
    private javax.swing.JTable tbKeranjang;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalHarga;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtSisaBayar;
    private javax.swing.JTextField txtStatusPembayaran;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
