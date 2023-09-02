/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TokoFarda;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class menuTransaksiSupplay extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private Timer timer;

    
    public int thotal;
    public int tot_brg;
    ArrayList<String> idList = new ArrayList<String>();
    
    public menuTransaksiSupplay() {
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
        kodeTransaksiSupplay();
        refreshTanggal();
    }
    
    void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql = "select Kode_Barang, Nama_Barang, Tgl_Expired, Harga_Beli, Stok from barang order by Kode_Barang ASC";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            // Membuat objek DefaultTableCellRenderer untuk mengubah warna baris
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Mendapatkan tanggal expired dari kolom 2 (indeks 1)
                    String tanggalExpired = table.getValueAt(row, 2).toString();

                    // Mendapatkan tanggal hari ini
                    LocalDate today = LocalDate.now();

                    // Mengubah warna baris menjadi merah jika tanggal expired sudah lewat
                    if (LocalDate.parse(tanggalExpired).isBefore(today)) {
                        c.setBackground(Color.RED);
                    } else {
                        c.setBackground(table.getBackground());
                    }

                    return c;
                }
            };

            // Menambahkan renderer ke kolom tanggal expired pada tabel
            TableColumnModel columnModel = tbBarang.getColumnModel();
            columnModel.getColumn(2).setCellRenderer(renderer);
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[5];
                
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Stok");
                obj[4] = rs.getString("Harga_Beli");
                
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
        txtKembalian.setText("");
        txtTanggal.setDate(refreshTanggal());
    }
    
    void resetKeranjang(){
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
    }
    
    public void tampilkanBarangBeli(){
        String[] judul = {"Kode Barang","Nama Barang", "Tanggal Expired", "Harga", "Jumlah", "Subtotal"};
        model1 = new DefaultTableModel(judul,0);
        tbKeranjang.setModel(model1);
    }
    
    private void setTotalHarga(){
        int totalBarang = 0;
        int row = tbKeranjang.getRowCount();
        int total = 0;
        for(int i = 0; i < row; i++) {
            int sb = Integer.parseInt(tbKeranjang.getValueAt(i, 5).toString());
            int tot = Integer.parseInt(tbKeranjang.getValueAt(i, 3).toString());
            total = total + (sb);
            totalBarang = totalBarang+tot;
        }
        this.tot_brg = totalBarang;
        
        this.thotal = total;
        lbTotal.setText(String.valueOf(this.thotal));
    }
    
    public void kodeTransaksiSupplay(){
        try{
            String sql = "SELECT Kode_TransaksiBeli FROM `transaksi_beli` ORDER BY Kode_TransaksiBeli DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            if(rs.next()){
                String noJual = rs.getString("Kode_TransaksiBeli").substring(2);
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
                txtKodeTransaksi.setText("TB" + nol + AN);
            } else {
                txtKodeTransaksi.setText("TB0001");
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
    
    public static Date refreshTanggal(){
        String str_tgl = "";
        Date Tanggal = null;
        try{
            Tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException ex){
            
        }
        return Tanggal;
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
        expired = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        btnRefresh = new rojerusan.RSMaterialButtonRectangle();
        btnHapus = new rojerusan.RSMaterialButtonRectangle();
        btnTambahKeranjang = new rojerusan.RSMaterialButtonRectangle();
        totalHarga = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        Kembalian = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        btnSimpan = new rojerusan.RSMaterialButtonRectangle();
        kodeTransaksi = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        lbRp = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(210, 215, 223));
        setPreferredSize(new java.awt.Dimension(1170, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(238, 238, 238));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Menu Transaksi Supplay");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Tanggal, Jam");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 729, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addGap(98, 98, 98))
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
        jPanel1.add(haragaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtHargaBarang.setEditable(false);
        txtHargaBarang.setFocusable(false);
        jPanel1.add(txtHargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 130, -1));

        jumlahBarang.setText("Jumlah Barang :");
        jPanel1.add(jumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, -1));

        subTotalBarang.setText("SubTotal Barang :");
        jPanel1.add(subTotalBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtSubTotal.setEditable(false);
        txtSubTotal.setFocusable(false);
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 128, -1));

        expired.setText("Tanggal Expired :");
        jPanel1.add(expired, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        jPanel1.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, -1));

        btnRefresh.setBackground(new java.awt.Color(102, 255, 0));
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 178, 78, 34));

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setForeground(new java.awt.Color(0, 0, 0));
        btnHapus.setText("hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 178, 80, 34));

        btnTambahKeranjang.setBackground(new java.awt.Color(255, 255, 0));
        btnTambahKeranjang.setForeground(new java.awt.Color(0, 0, 0));
        btnTambahKeranjang.setText("tambah keranjang");
        btnTambahKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKeranjangActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambahKeranjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 218, 254, 54));

        totalHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalHarga.setText("Total Belanja:");
        jPanel1.add(totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        bayar.setText("Bayar :");
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBayarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 143, -1));

        Kembalian.setText("Kembalian :");
        jPanel1.add(Kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        txtKembalian.setEditable(false);
        txtKembalian.setFocusable(false);
        jPanel1.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 143, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 235, 57));

        kodeTransaksi.setText("Kode Transaksi :");
        jPanel1.add(kodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        txtKodeTransaksi.setEditable(false);
        txtKodeTransaksi.setFocusable(false);
        jPanel1.add(txtKodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 23, 140, -1));

        lbRp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbRp.setText("Rp.");
        jPanel1.add(lbRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 180, 70));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTotal.setText("0");
        jPanel1.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 160, 70));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 990, 320));

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 360, -1));
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

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        getData();
        Bersih();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKeranjangActionPerformed
        // TODO add your handling code here:
        if(txtHargaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap pilih barang terlebih dahulu!!");
        } else if(txtTanggal.getDate() == null){
            JOptionPane.showMessageDialog(null, "Harap masukan tanggal expired barang!!");
        }else {
           String tampilan = "yyyy-MM-dd";
           SimpleDateFormat fm = new SimpleDateFormat(tampilan);
           String tanggal = String.valueOf(fm.format(txtTanggal.getDate()));
           
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
                                tanggal,
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
//        // TODO add your handling code here:
        try{
            int bayar = Integer.parseInt(txtBayar.getText());
            int total = Integer.parseInt(lbTotal.getText());
            int fungsi = total - bayar;
            int lain = bayar - total;
            
            txtKembalian.setText("" + lain);

        } catch (Exception e){
            
        }
    }//GEN-LAST:event_txtBayarKeyReleased

    private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
        // TODO add your handling code here:
        try{
        int jumlah = Integer.parseInt(txtJumlah.getText());
        int harga = Integer.parseInt(txtHargaBarang.getText());
        int subTotal = 0;
        subTotal = jumlah*harga; 
           txtSubTotal.setText(""+subTotal);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Harap masukan jumlah dengan angka");
            txtJumlah.setText(""+1);
        }
    }//GEN-LAST:event_txtJumlahKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(lbTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Harap pilih barang yang dibeli!!");
        }else {
            try{
                Long.parseLong(txtBayar.getText());
                int rows = tbKeranjang.getRowCount();
                int totalHarga = Integer.parseInt(lbTotal.getText());
                int bayar = Integer.parseInt(txtBayar.getText());
                String KodeTransaksi = txtKodeTransaksi.getText();
                session.setKodeTransaksi(KodeTransaksi);

                try{

                    String sql = "INSERT INTO transaksi_beli values ('" + KodeTransaksi + "',now(),'" + totalHarga + "','" + bayar + "','" + session.getU_Id() + "')";

                    pst = conn.prepareStatement(sql);
                    pst.execute();

                    for(int i = 0; i < rows; i++){
                        String kodeBarang = tbKeranjang.getValueAt(i, 0).toString();
                        String tglExpired = tbKeranjang.getValueAt(i, 2).toString();
                        
                        String sql2 = "update barang set Tgl_Expired='" + tglExpired + "'where Kode_Barang='" + kodeBarang + "'";
                        pst = conn.prepareStatement(sql2);
                        pst.executeUpdate();
                        
                        String sql1 = "insert into detail_transaksi_beli values ('" + KodeTransaksi + "','" + kodeBarang + "','" + tbKeranjang.getValueAt(i, 4) + "','" + tbKeranjang.getValueAt(i, 5) + "')";
                        pst = conn.prepareStatement(sql1);
                        pst.execute();
                        
                    Bersih();
                    getData();
                    kodeTransaksiSupplay();
                    }
                    JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
                    resetKeranjang();


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Harap masukan nominal dengan benar!!");
            }
        }
            
    }//GEN-LAST:event_btnSimpanActionPerformed

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

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
       model.fireTableDataChanged();
       
       try {
           String sql = "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                "FROM barang b \n" +
                "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                "where Kode_Barang like '%" + txtCari.getText() + "%' || Nama_Barang like '%" + txtCari.getText() + "%' order by Kode_Barang ASC" ; 
           
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()) {
                Object[] obj = new Object[5];
                
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Stok");
                obj[4] = rs.getString("Harga_Beli");
                
                model.addRow(obj);
            }
       } catch (Exception e){
           
       }
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kembalian;
    private javax.swing.JLabel bayar;
    private rojerusan.RSMaterialButtonRectangle btnHapus;
    private rojerusan.RSMaterialButtonRectangle btnRefresh;
    private rojerusan.RSMaterialButtonRectangle btnSimpan;
    private rojerusan.RSMaterialButtonRectangle btnTambahKeranjang;
    private javax.swing.JLabel expired;
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
    private javax.swing.JTextField txtSubTotal;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
