/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TokoFarda;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ASUS
 */
public class menuDataBarang extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
   
    private final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
    Calendar hariIni;
    
    
    private DefaultTableModel model;
    private Timer timer;
    
    public menuDataBarang() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();
        
        //memberi penamaan pada judul kolom
        model = new DefaultTableModel();
        tb_barang.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal Exp");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stock");
        model.addColumn("Jenis Barang");
        model.addColumn("Supplier");
        
        //membuat timer dengan delay 1000ms (1 dt) dan AcctionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDayDateTime();
            }
        });
        
        timer.start();
        getData();
        refreshTanggal();
    }
    
    //menampilkan data ke table
    void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql =    "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                            "FROM barang b \n" +
                            "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                            "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                            "ORDER BY b.Kode_Barang ASC;";
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
            TableColumnModel columnModel = tb_barang.getColumnModel();
            columnModel.getColumn(2).setCellRenderer(renderer);
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[8];
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Harga_Beli");
                obj[4] = rs.getString("Harga_Jual");
                obj[5] = rs.getString("Stok");
                obj[6] = rs.getString("Jenis_Barang");
                obj[7] = rs.getString("Nama_Supplier");
                
                model.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void refreshPanel(DefaultTableModel model, PreparedStatement pst, Connection conn, ResultSet rs){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            //membuat statement pemanggilan data tabel barang dari database
            String sql =    "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                            "FROM barang b \n" +
                            "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                            "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                            "ORDER BY b.Kode_Barang ASC;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //penelusuran baris pada tabel barang dari database
            while(rs.next()) {
                Object[] obj = new Object[8];
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Harga_Beli");
                obj[4] = rs.getString("Harga_Jual");
                obj[5] = rs.getString("Stok");
                obj[6] = rs.getString("Jenis_Barang");
                obj[7] = rs.getString("Nama_Supplier");
                
                model.addRow(obj);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void PilihData(){
        int i = tb_barang.getSelectedRow();
        txt_KodeBarang.setText(model.getValueAt(i, 0).toString());
        txt_NamaBarang.setText(model.getValueAt(i, 1).toString());
        txt_TglExp.setDate(getTanggalFromTable(tb_barang, 2));
        txt_HargaBeli.setText(model.getValueAt(i, 3).toString());
        txt_HargaJual.setText(model.getValueAt(i, 4).toString());
        txt_Stock.setText(model.getValueAt(i, 5).toString());
        cmb_JenisBarang.setSelectedItem(model.getValueAt(i, 6).toString());
        cmb_NamaSupplier.setSelectedItem(model.getValueAt(i, 7).toString());
    }
    
    void Bersih(){
        txt_KodeBarang.setText("");
        txt_NamaBarang.setText("");
        txt_HargaBeli.setText("");
        txt_HargaJual.setText("");
        txt_Stock.setText("");
        txt_TglExp.setDate(refreshTanggal());
        txt_Cari.setText("Cari...");
        cmb_JenisBarang.setSelectedItem("--Select--");
        cmb_NamaSupplier.setSelectedItem("--Select--");
    }
    
    void jenisBarang(){
        cmb_JenisBarang.removeAllItems();
        cmb_JenisBarang.addItem("--Select--");
        
        try{
            String sql = "select * from jenis_barang";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                cmb_JenisBarang.addItem(rs.getString("Jenis_Barang"));
            }
        } catch (Exception e){
            
        }
    }
    
    void namaSupplier(){
        cmb_NamaSupplier.removeAllItems();
        cmb_NamaSupplier.addItem("--Select--");
        
        try{
            String sql = "select * from supplier";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                cmb_NamaSupplier.addItem(rs.getString("Nama_Supplier"));
            }
        } catch (Exception e){
            
        }
    }
    
    public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException ex){
            
        }
        return tanggal;
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

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_barang = new javax.swing.JTable();
        Kode_barang = new javax.swing.JLabel();
        txt_KodeBarang = new javax.swing.JTextField();
        Nama_barang = new javax.swing.JLabel();
        txt_NamaBarang = new javax.swing.JTextField();
        Tanggal_exp = new javax.swing.JLabel();
        txt_TglExp = new com.toedter.calendar.JDateChooser();
        HargaBeli = new javax.swing.JLabel();
        txt_HargaBeli = new javax.swing.JTextField();
        HargaJual = new javax.swing.JLabel();
        txt_HargaJual = new javax.swing.JTextField();
        Stock = new javax.swing.JLabel();
        txt_Stock = new javax.swing.JTextField();
        Jenis_Barang = new javax.swing.JLabel();
        cmb_JenisBarang = new javax.swing.JComboBox<>();
        Nama_Supplier = new javax.swing.JLabel();
        cmb_NamaSupplier = new javax.swing.JComboBox<>();
        btn_edit = new rojerusan.RSMaterialButtonRectangle();
        btn_hapus = new rojerusan.RSMaterialButtonRectangle();
        btn_refresh = new rojerusan.RSMaterialButtonRectangle();
        btn_tambah = new rojerusan.RSMaterialButtonRectangle();
        txt_Cari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(207, 212, 220));
        setPreferredSize(new java.awt.Dimension(1170, 750));

        header.setBackground(new java.awt.Color(237, 237, 237));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Menu Data Barang");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Tanggal, Jam");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 787, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addGap(39, 39, 39))
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

        jPanel1.setBackground(new java.awt.Color(207, 212, 220));

        tb_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_barang);

        Kode_barang.setText("Kode Barang");

        Nama_barang.setText("Nama Barang");

        Tanggal_exp.setText("Tanggal Expired");

        HargaBeli.setText("Harga Beli");

        HargaJual.setText("Harga Jual");

        Stock.setText("Stock");

        Jenis_Barang.setText("Jenis Barang");

        cmb_JenisBarang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmb_JenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--" }));

        Nama_Supplier.setText("Nama Supplier");

        cmb_NamaSupplier.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmb_NamaSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--" }));

        btn_edit.setBackground(new java.awt.Color(255, 255, 0));
        btn_edit.setForeground(new java.awt.Color(0, 0, 0));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(255, 0, 0));
        btn_hapus.setForeground(new java.awt.Color(0, 0, 0));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_refresh.setBackground(new java.awt.Color(102, 255, 102));
        btn_refresh.setForeground(new java.awt.Color(0, 0, 0));
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(51, 204, 255));
        btn_tambah.setForeground(new java.awt.Color(0, 0, 0));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_KodeBarang)
                    .addComponent(Kode_barang)
                    .addComponent(txt_NamaBarang)
                    .addComponent(Nama_barang)
                    .addComponent(Tanggal_exp)
                    .addComponent(txt_HargaBeli)
                    .addComponent(HargaBeli)
                    .addComponent(txt_Stock)
                    .addComponent(Stock)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_TglExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jenis_Barang)
                    .addComponent(Nama_Supplier)
                    .addComponent(cmb_JenisBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_NamaSupplier, 0, 423, Short.MAX_VALUE)
                    .addComponent(HargaJual)
                    .addComponent(txt_HargaJual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Kode_barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_KodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nama_barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tanggal_exp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TglExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HargaBeli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_HargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HargaJual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Stock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jenis_Barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_JenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nama_Supplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_NamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("card1");
    }// </editor-fold>//GEN-END:initComponents

    private void tb_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_barangMouseClicked
        PilihData();
        int i = tb_barang.getSelectedRow();
        session.setKodeBarang(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tb_barangMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if(txt_KodeBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan kode barang terlebih dahulu!!");
        }else if(txt_NamaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan nama barang!!");
        }else if(txt_TglExp.getDate() == null){
            JOptionPane.showMessageDialog(null, "Harap pilih tanggal expired barang!!");
        }else if(txt_HargaBeli.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan harga beli!!");
        }else if(txt_HargaJual.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan harga jual!!");
        }else if(txt_Stock.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan stok barang!!");
        }else if(cmb_JenisBarang.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Harap pilih jenis barang!!");
        }else if(cmb_NamaSupplier.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Harap pilih nama supplier barang!!");
        }else{
             try{
                Long.parseLong(txt_KodeBarang.getText());
                Long.parseLong(txt_HargaBeli.getText());
                Long.parseLong(txt_HargaJual.getText());
                Long.parseLong(txt_Stock.getText());
                
                //mengambil id jenis barang berdasarkan cmb jenis barang
                String sql = "select * from jenis_barang where Jenis_Barang='" + cmb_JenisBarang.getSelectedItem() + "'";
                int idJenisBarang = 0;
                try{
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();

                    if(rs.next()){
                        idJenisBarang =Integer.parseInt(rs.getString("id_JenisBarang")) ;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                //mengambil id supplier berdasarkan cmb nama supplier
                String sql1 = "select * from supplier where Nama_Supplier='" + cmb_NamaSupplier.getSelectedItem() + "'";
                int idSupplier = 0;
                try{
                    pst = conn.prepareStatement(sql1);
                    rs = pst.executeQuery();

                    if(rs.next()){
                        idSupplier =Integer.parseInt(rs.getString("id_Supplier")) ;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                //mengambil data tanggal
                String tampilan = "yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                String tanggal = String.valueOf(fm.format(txt_TglExp.getDate()));

                //fungsi edit
                try{
                    String KodeBarang = txt_KodeBarang.getText();
                    String NamaBarang = txt_NamaBarang.getText();
                    int HargaBeli =Integer.parseInt(txt_HargaBeli.getText());
                    int HargaJual =Integer.parseInt(txt_HargaJual.getText());
                    int Stock =Integer.parseInt(txt_Stock.getText());

                    String sql2 = "update barang set Kode_Barang='" + KodeBarang + "',Nama_Barang='" + NamaBarang + "',Tgl_Expired='" + tanggal + "',Harga_Beli='" + HargaBeli + "',Harga_Jual='" + HargaJual + "',Stok='" + Stock + "',id_JenisBarang='" + idJenisBarang + "',id_Supplier='" + idSupplier + "' where Kode_Barang='" + session.getKodeBarang() + "'";
                    pst = conn.prepareStatement(sql2);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                getData();
                Bersih();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Masukan Angka Dengan Benar");
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int p = JOptionPane.showConfirmDialog(null,
            "Apakah benar-benar akan dihapus permanen?",
            "Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (p == 0) {
            String sql = "delete from barang where Kode_Barang=?";
            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_KodeBarang.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        getData();
        Bersih();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        getData();
        Bersih();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        
        if(txt_KodeBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan kode barang terlebih dahulu!!");
        }else if(txt_NamaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan nama barang!!");
        }else if(txt_TglExp.getDate() == null){
            JOptionPane.showMessageDialog(null, "Harap pilih tanggal expired barang!!");
        }else if(txt_HargaBeli.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan harga beli!!");
        }else if(txt_HargaJual.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan harga jual!!");
        }else if(txt_Stock.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap masukan stok barang!!");
        }else if(cmb_JenisBarang.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Harap pilih jenis barang!!");
        }else if(cmb_NamaSupplier.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Harap pilih nama supplier barang!!");
        }else{
            String KodeBarang = txt_KodeBarang.getText();
            String HargaBeli = Integer.toString(Integer.parseInt(txt_HargaBeli.getText()));
            String HargaJual = Integer.toString(Integer.parseInt(txt_HargaJual.getText()));
            String Stock = Integer.toString(Integer.parseInt(txt_Stock.getText()));
             try{
                Long.parseLong(txt_KodeBarang.getText());
                Long.parseLong(txt_HargaBeli.getText());
                Long.parseLong(txt_HargaJual.getText());
                Long.parseLong(txt_Stock.getText());
                
                String sql = "select * from jenis_barang where Jenis_Barang='" + cmb_JenisBarang.getSelectedItem() + "'";
                String idJenisBarang = "";
                try{
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();

                    if(rs.next()){
                        idJenisBarang = rs.getString("id_JenisBarang");
                    }
                } catch (Exception e){
//                    JOptionPane.showMessageDialog(null, e);
                }

                String sql1 = "select * from supplier where Nama_Supplier='" + cmb_NamaSupplier.getSelectedItem() + "'";
                String idSupplier = "";
                try{
                    pst = conn.prepareStatement(sql1);
                    rs = pst.executeQuery();

                    if(rs.next()){
                        idSupplier = rs.getString("id_Supplier");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                String tampilan = "yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                String tanggal = String.valueOf(fm.format(txt_TglExp.getDate()));

                try{
                    String sql2 = "select * from barang where Nama_Barang=?";
                    pst = conn.prepareStatement(sql2);
                    rs = pst.executeQuery();

                    if(rs.next()){

                    }
                } catch(Exception e){
//                    JOptionPane.showMessageDialog(null, e);
                }

                try{
                    String sql2 = "insert into barang (Kode_Barang,Nama_Barang,Tgl_Expired,Harga_Beli,Harga_Jual,Stok,id_JenisBarang,id_Supplier)values(?,?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(sql2);
                    pst.setString(1, KodeBarang);
                    pst.setString(2, txt_NamaBarang.getText());
                    pst.setString(3, tanggal);
                    pst.setString(4, HargaBeli);
                    pst.setString(5, HargaJual);
                    pst.setString(6, Stock);
                    pst.setString(7, idJenisBarang);
                    pst.setString(8, idSupplier);

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                getData();
                Bersih();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Masukan Angka Dengan Benar");
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_CariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CariKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            String sql = "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                "FROM barang b \n" +
                "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                "where Kode_Barang like '%" + txt_Cari.getText() + "%' || Nama_Barang like '%" + txt_Cari.getText() + "%' order by Kode_Barang ASC" ; 

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()){
                Object[] obj = new Object[8];
                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Harga_Beli");
                obj[4] = rs.getString("Harga_Jual");
                obj[5] = rs.getString("Stok");
                obj[6] = rs.getString("Jenis_Barang");
                obj[7] = rs.getString("Nama_Supplier");

                model.addRow(obj);
            }
        } catch (Exception e){
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
        if(cari.equals("")||cari.equals("Cari...")){
            txt_Cari.setText("Cari...");
        }
    }//GEN-LAST:event_txt_CariFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HargaBeli;
    private javax.swing.JLabel HargaJual;
    private javax.swing.JLabel Jenis_Barang;
    private javax.swing.JLabel Kode_barang;
    private javax.swing.JLabel Nama_Supplier;
    private javax.swing.JLabel Nama_barang;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Tanggal_exp;
    private rojerusan.RSMaterialButtonRectangle btn_edit;
    private rojerusan.RSMaterialButtonRectangle btn_hapus;
    private rojerusan.RSMaterialButtonRectangle btn_refresh;
    private rojerusan.RSMaterialButtonRectangle btn_tambah;
    private javax.swing.JComboBox<String> cmb_JenisBarang;
    private javax.swing.JComboBox<String> cmb_NamaSupplier;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JTable tb_barang;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_HargaBeli;
    private javax.swing.JTextField txt_HargaJual;
    private javax.swing.JTextField txt_KodeBarang;
    private javax.swing.JTextField txt_NamaBarang;
    private javax.swing.JTextField txt_Stock;
    private com.toedter.calendar.JDateChooser txt_TglExp;
    // End of variables declaration//GEN-END:variables
}
