/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TokoFarda;

/**
 *
 * @author user
 */
public class laporan extends javax.swing.JFrame {

    /**
     * Creates new form laporan
     */
    public laporan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        icons_admin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        icons_dashboard = new javax.swing.JLabel();
        icons_barang = new javax.swing.JLabel();
        icons_supplier = new javax.swing.JLabel();
        icons_hutang = new javax.swing.JLabel();
        icons_transkasi_supplay = new javax.swing.JLabel();
        icons_transaksi = new javax.swing.JLabel();
        icons_data_transaksi = new javax.swing.JLabel();
        icons_user = new javax.swing.JLabel();
        icons_laporan = new javax.swing.JLabel();
        icons_logout = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        menu1 = new custom.PanelCustom();
        Total_pengeluaran = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        menu2 = new custom.PanelCustom();
        Data_Supplier = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        menu3 = new custom.PanelCustom();
        Data_Hutang = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        menu4 = new custom.PanelCustom();
        Transaksi_Supplay = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        menu8 = new custom.PanelCustom();
        Data_Laporan = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(80, 151, 210));

        icons_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/icons_admin.png"))); // NOI18N

        icons_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        icons_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_dashboard25.png"))); // NOI18N
        icons_dashboard.setText("Dashboard");

        icons_barang.setForeground(new java.awt.Color(255, 255, 255));
        icons_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_barang.png"))); // NOI18N
        icons_barang.setText("Data Barang");

        icons_supplier.setForeground(new java.awt.Color(255, 255, 255));
        icons_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_supplier.png"))); // NOI18N
        icons_supplier.setText("Data Supplier");

        icons_hutang.setForeground(new java.awt.Color(255, 255, 255));
        icons_hutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_hutang25.png"))); // NOI18N
        icons_hutang.setText("Data Hutang");

        icons_transkasi_supplay.setForeground(new java.awt.Color(255, 255, 255));
        icons_transkasi_supplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_transaksi_supplay25.png"))); // NOI18N
        icons_transkasi_supplay.setText("Transaksi Supplay");

        icons_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        icons_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_transaksi25.png"))); // NOI18N
        icons_transaksi.setText("Transaksi Jual");

        icons_data_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        icons_data_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_book25.png"))); // NOI18N
        icons_data_transaksi.setText("Data Transaksi");

        icons_user.setForeground(new java.awt.Color(255, 255, 255));
        icons_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_user25.png"))); // NOI18N
        icons_user.setText("Data User");

        icons_laporan.setForeground(new java.awt.Color(255, 255, 255));
        icons_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_laporan25.png"))); // NOI18N
        icons_laporan.setText("Data Laporan");

        icons_logout.setForeground(new java.awt.Color(255, 255, 255));
        icons_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_logout.png"))); // NOI18N
        icons_logout.setText("Logout");

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(icons_admin))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(icons_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(icons_hutang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_transkasi_supplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_data_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icons_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(icons_admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icons_dashboard)
                .addGap(18, 18, 18)
                .addComponent(icons_barang)
                .addGap(18, 18, 18)
                .addComponent(icons_supplier)
                .addGap(18, 18, 18)
                .addComponent(icons_hutang)
                .addGap(18, 18, 18)
                .addComponent(icons_transkasi_supplay)
                .addGap(18, 18, 18)
                .addComponent(icons_transaksi)
                .addGap(18, 18, 18)
                .addComponent(icons_data_transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(icons_user)
                .addGap(18, 18, 18)
                .addComponent(icons_laporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(icons_logout)
                .addGap(22, 22, 22))
        );

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 750));

        background.setBackground(new java.awt.Color(207, 212, 220));
        background.setPreferredSize(new java.awt.Dimension(1429, 750));

        menu1.setBackground(new java.awt.Color(106, 185, 235));
        menu1.setRoundBottomLeft(50);
        menu1.setRoundBottomRight(50);
        menu1.setRoundTopLeft(50);
        menu1.setRoundTopRight(50);

        Total_pengeluaran.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Total_pengeluaran.setText("Total Pengeluaran");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(Total_pengeluaran)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Total_pengeluaran)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menu1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(127, Short.MAX_VALUE)))
        );

        menu2.setBackground(new java.awt.Color(106, 185, 235));
        menu2.setRoundBottomLeft(50);
        menu2.setRoundBottomRight(50);
        menu2.setRoundTopLeft(50);
        menu2.setRoundTopRight(50);

        Data_Supplier.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Data_Supplier.setText("Total Pemasukan");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setToolTipText("");
        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(Data_Supplier)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Data_Supplier)
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        menu3.setBackground(new java.awt.Color(106, 185, 235));
        menu3.setRoundBottomLeft(50);
        menu3.setRoundBottomRight(50);
        menu3.setRoundTopLeft(50);
        menu3.setRoundTopRight(50);

        Data_Hutang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Data_Hutang.setText("Barang Terlaris");

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setToolTipText("");
        jSeparator7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jSeparator7.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Data_Hutang)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Data_Hutang)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menu3Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        menu4.setBackground(new java.awt.Color(106, 185, 235));
        menu4.setRoundBottomLeft(50);
        menu4.setRoundBottomRight(50);
        menu4.setRoundTopLeft(50);
        menu4.setRoundTopRight(50);

        Transaksi_Supplay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Transaksi_Supplay.setText("Laba");

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setToolTipText("");
        jSeparator8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jSeparator8.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout menu4Layout = new javax.swing.GroupLayout(menu4);
        menu4.setLayout(menu4Layout);
        menu4Layout.setHorizontalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu4Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(Transaksi_Supplay)
                .addGap(127, 127, 127))
            .addGroup(menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
        menu4Layout.setVerticalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Transaksi_Supplay)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menu4Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(155, Short.MAX_VALUE)))
        );

        menu8.setBackground(new java.awt.Color(106, 185, 235));
        menu8.setRoundBottomLeft(50);
        menu8.setRoundBottomRight(50);
        menu8.setRoundTopLeft(50);
        menu8.setRoundTopRight(50);

        Data_Laporan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Data_Laporan.setText("Kerugian");

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setToolTipText("");
        jSeparator9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jSeparator9.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout menu8Layout = new javax.swing.GroupLayout(menu8);
        menu8.setLayout(menu8Layout);
        menu8Layout.setHorizontalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(Data_Laporan)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
        menu8Layout.setVerticalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Data_Laporan)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menu8Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1260, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data_Hutang;
    private javax.swing.JLabel Data_Laporan;
    private javax.swing.JLabel Data_Supplier;
    private javax.swing.JLabel Total_pengeluaran;
    private javax.swing.JLabel Transaksi_Supplay;
    private javax.swing.JPanel background;
    private javax.swing.JLabel icons_admin;
    private javax.swing.JLabel icons_barang;
    private javax.swing.JLabel icons_dashboard;
    private javax.swing.JLabel icons_data_transaksi;
    private javax.swing.JLabel icons_hutang;
    private javax.swing.JLabel icons_laporan;
    private javax.swing.JLabel icons_logout;
    private javax.swing.JLabel icons_supplier;
    private javax.swing.JLabel icons_transaksi;
    private javax.swing.JLabel icons_transkasi_supplay;
    private javax.swing.JLabel icons_user;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private custom.PanelCustom menu1;
    private custom.PanelCustom menu2;
    private custom.PanelCustom menu3;
    private custom.PanelCustom menu4;
    private custom.PanelCustom menu8;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}