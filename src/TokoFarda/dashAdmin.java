package TokoFarda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class dashAdmin extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private Timer timer;
    
    public dashAdmin() {
        initComponents();
        conn = Koneksi.Koneksi.KoneksiDB();
        namaUser.setText(session.getU_Username());
        role.setText(session.getU_email());
        
        //memberi penamaan pada judul kolom
        model = new DefaultTableModel();
        tbExpired.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal Exp");
        model.addColumn("Harga Beli");
        model.addColumn("Supplier");
        
        //memberi penamaan pada judul kolom
        model1 = new DefaultTableModel();
        tbStok.setModel(model1);
        model1.addColumn("Kode Barang");
        model1.addColumn("Nama Barang");
        model1.addColumn("Harga Beli");
        model1.addColumn("Stok");
        model1.addColumn("Supplier");
        
        //membuat timer dengan delay 1000ms (1 dt) dan AcctionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDayDateTime();
            }
        });

        timer.start();
        getDataExpired();
        getDataStock();
        jumlahBarangExpired();
        jumlahHutang();
        jumlahTransaksi();
    }
    
    void getDataExpired(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Date currentDate = new Date();
            
            String sql = "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                            "FROM barang b \n" +
                            "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                            "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                            "WHERE Tgl_Expired < ? ORDER BY b.Kode_Barang ASC;";

            pst = conn.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(currentDate.getTime()));
            rs = pst.executeQuery();

            // Penelusuran baris pada tabel barang dari database
            while (rs.next()) {
                Object[] obj = new Object[5];

                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Tgl_Expired");
                obj[3] = rs.getString("Harga_Beli");
                obj[4] = rs.getString("Nama_Supplier");

                model.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    void getDataStock(){
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();

        try {

            String sql = "SELECT b.Kode_Barang, b.Nama_Barang, b.Tgl_Expired, b.Harga_Beli, b.Harga_Jual, b.Stok, jb.Jenis_Barang, s.Nama_Supplier\n" +
                        "FROM barang b\n" +
                        "JOIN jenis_barang jb ON jb.id_JenisBarang = b.id_JenisBarang\n" +
                        "JOIN supplier s ON s.id_Supplier = b.id_Supplier\n" +
                        "WHERE b.Stok <= 10\n" +
                        "ORDER BY b.Kode_Barang ASC;";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            // Penelusuran baris pada tabel barang dari database
            while (rs.next()) {
                Object[] obj = new Object[5];

                obj[0] = rs.getString("Kode_Barang");
                obj[1] = rs.getString("Nama_Barang");
                obj[2] = rs.getString("Harga_Beli");
                obj[3] = rs.getString("Stok");
                obj[4] = rs.getString("Nama_Supplier");

                model1.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void jumlahTransaksi(){
        try {
            String sql = "SELECT COUNT(Kode_TransaksiJual) from transaksi_jual";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                jumlah.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void jumlahBarangExpired(){
        try {
            String sql = "SELECT COUNT(Kode_Barang) from barang WHERE Tgl_Expired < CURRENT_DATE()";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                barang.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void jumlahHutang(){
        try {
            String sql = "SELECT COUNT(id_Hutang) from hutang";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                pelanggan.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaUser = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        panelCustom1 = new custom.PanelCustom();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jumlah = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelCustom2 = new custom.PanelCustom();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        barang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelCustom3 = new custom.PanelCustom();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pelanggan = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStok = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbExpired = new javax.swing.JTable();

        setBackground(new java.awt.Color(207, 212, 220));
        setPreferredSize(new java.awt.Dimension(1170, 750));

        header.setBackground(new java.awt.Color(237, 237, 237));

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setText("Dashboard");

        lb_tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_tanggal.setText("Hari, Tanggal, Jam");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 872, Short.MAX_VALUE)
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Selamat Datang di Toko Farda, Hallo :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Anda Login Sebagai :");

        namaUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        namaUser.setText("nama user");

        role.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        role.setText("role");

        panelCustom1.setBackground(new java.awt.Color(107, 186, 236));
        panelCustom1.setPreferredSize(new java.awt.Dimension(223, 135));
        panelCustom1.setRoundBottomLeft(50);
        panelCustom1.setRoundBottomRight(50);
        panelCustom1.setRoundTopLeft(50);
        panelCustom1.setRoundTopRight(50);
        panelCustom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Jumlah Transaksi");
        panelCustom1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelCustom1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, 211, 10));

        jumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jumlah.setText("jumlah");
        panelCustom1.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\TokoFardaBackupku\\src\\Mockup\\DashAdmin\\icons8-transaction-50.png")); // NOI18N
        panelCustom1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        panelCustom2.setBackground(new java.awt.Color(107, 186, 236));
        panelCustom2.setPreferredSize(new java.awt.Dimension(223, 135));
        panelCustom2.setRoundBottomLeft(50);
        panelCustom2.setRoundBottomRight(50);
        panelCustom2.setRoundTopLeft(50);
        panelCustom2.setRoundTopRight(50);
        panelCustom2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Barang Expired");
        panelCustom2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 6, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelCustom2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, 211, 10));

        barang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        barang.setText("barang");
        panelCustom2.add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/icons8-expired-50.png"))); // NOI18N
        panelCustom2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        panelCustom3.setBackground(new java.awt.Color(107, 186, 236));
        panelCustom3.setPreferredSize(new java.awt.Dimension(223, 135));
        panelCustom3.setRoundBottomLeft(50);
        panelCustom3.setRoundBottomRight(50);
        panelCustom3.setRoundTopLeft(50);
        panelCustom3.setRoundTopRight(50);
        panelCustom3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Pelanggan Hutang");
        panelCustom3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 6, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelCustom3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, 211, 10));

        pelanggan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pelanggan.setText("pelanggan");
        panelCustom3.add(pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 65, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/icons8-debt-50.png"))); // NOI18N
        panelCustom3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Stok Barang Sedikit");

        tbStok.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbStok);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Barang Expired");

        tbExpired.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbExpired);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(role))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(namaUser)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(panelCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namaUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(role))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barang;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jumlah;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel namaUser;
    private custom.PanelCustom panelCustom1;
    private custom.PanelCustom panelCustom2;
    private custom.PanelCustom panelCustom3;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel role;
    private javax.swing.JTable tbExpired;
    private javax.swing.JTable tbStok;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
