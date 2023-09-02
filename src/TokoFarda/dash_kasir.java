/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TokoFarda;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class dash_kasir extends javax.swing.JFrame {

    /**
     * Creates new form dash_kasir
     */
    public dash_kasir() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        icons_admin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        menuPanel = new javax.swing.JPanel();
        dashMenu = new javax.swing.JPanel();
        dashPanel = new javax.swing.JPanel();
        icons_dashboard1 = new javax.swing.JLabel();
        barangMenu = new javax.swing.JPanel();
        barangPanel = new javax.swing.JPanel();
        icons_barang2 = new javax.swing.JLabel();
        jualMenu = new javax.swing.JPanel();
        jualPanel = new javax.swing.JPanel();
        icons_transaksi = new javax.swing.JLabel();
        transaksiMenu = new javax.swing.JPanel();
        transaksiPanel = new javax.swing.JPanel();
        icons_data_transaksi1 = new javax.swing.JLabel();
        logoutMenu = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        icons_logout1 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JPanel();
        dashAdmin1 = new TokoFarda.dashAdmin();
        menuBarang1 = new TokoFarda.menuDataBarang();
        menuTransaksiJual1 = new TokoFarda.menuTransaksiJual();
        menuDataTransaksi1 = new TokoFarda.menuDataTransaksi();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(80, 151, 210));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(205, 100));

        logoPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashKasir/icons_kasir.png"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logoPanelLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(icons_admin)))
                    .addGap(10, 10, 10)))
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
            .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icons_admin)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        menuPanel.setBackground(new java.awt.Color(80, 151, 210));
        menuPanel.setLayout(new java.awt.GridLayout(11, 1));

        dashMenu.setBackground(new java.awt.Color(80, 151, 210));

        dashPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_dashboard1.setForeground(new java.awt.Color(255, 255, 255));
        icons_dashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_dashboard25.png"))); // NOI18N
        icons_dashboard1.setText("Dashboard");
        icons_dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_dashboard1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_dashboard1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_dashboard1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_dashboard1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_dashboard1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout dashPanelLayout = new javax.swing.GroupLayout(dashPanel);
        dashPanel.setLayout(dashPanelLayout);
        dashPanelLayout.setHorizontalGroup(
            dashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(icons_dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashPanelLayout.setVerticalGroup(
            dashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashMenuLayout = new javax.swing.GroupLayout(dashMenu);
        dashMenu.setLayout(dashMenuLayout);
        dashMenuLayout.setHorizontalGroup(
            dashMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dashMenuLayout.setVerticalGroup(
            dashMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashMenuLayout.createSequentialGroup()
                .addComponent(dashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuPanel.add(dashMenu);

        barangMenu.setBackground(new java.awt.Color(80, 151, 210));

        barangPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_barang2.setForeground(new java.awt.Color(255, 255, 255));
        icons_barang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_barang.png"))); // NOI18N
        icons_barang2.setText("Data Barang");
        icons_barang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_barang2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_barang2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_barang2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_barang2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_barang2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout barangPanelLayout = new javax.swing.GroupLayout(barangPanel);
        barangPanel.setLayout(barangPanelLayout);
        barangPanelLayout.setHorizontalGroup(
            barangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barangPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(icons_barang2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        barangPanelLayout.setVerticalGroup(
            barangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icons_barang2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout barangMenuLayout = new javax.swing.GroupLayout(barangMenu);
        barangMenu.setLayout(barangMenuLayout);
        barangMenuLayout.setHorizontalGroup(
            barangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        barangMenuLayout.setVerticalGroup(
            barangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barangMenuLayout.createSequentialGroup()
                .addComponent(barangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuPanel.add(barangMenu);

        jualMenu.setBackground(new java.awt.Color(80, 151, 210));

        jualPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        icons_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_transaksi25.png"))); // NOI18N
        icons_transaksi.setText("Transaksi Jual");
        icons_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_transaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_transaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_transaksiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_transaksiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_transaksiMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jualPanelLayout = new javax.swing.GroupLayout(jualPanel);
        jualPanel.setLayout(jualPanelLayout);
        jualPanelLayout.setHorizontalGroup(
            jualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jualPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(icons_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jualPanelLayout.setVerticalGroup(
            jualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jualPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jualMenuLayout = new javax.swing.GroupLayout(jualMenu);
        jualMenu.setLayout(jualMenuLayout);
        jualMenuLayout.setHorizontalGroup(
            jualMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jualMenuLayout.setVerticalGroup(
            jualMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jualMenuLayout.createSequentialGroup()
                .addComponent(jualPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuPanel.add(jualMenu);

        transaksiMenu.setBackground(new java.awt.Color(80, 151, 210));

        transaksiPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_data_transaksi1.setForeground(new java.awt.Color(255, 255, 255));
        icons_data_transaksi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_book25.png"))); // NOI18N
        icons_data_transaksi1.setText("Data Transaksi");
        icons_data_transaksi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_data_transaksi1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_data_transaksi1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_data_transaksi1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_data_transaksi1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_data_transaksi1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(icons_data_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_data_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout transaksiMenuLayout = new javax.swing.GroupLayout(transaksiMenu);
        transaksiMenu.setLayout(transaksiMenuLayout);
        transaksiMenuLayout.setHorizontalGroup(
            transaksiMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaksiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transaksiMenuLayout.setVerticalGroup(
            transaksiMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiMenuLayout.createSequentialGroup()
                .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuPanel.add(transaksiMenu);

        logoutMenu.setBackground(new java.awt.Color(80, 151, 210));

        logoutPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_logout1.setForeground(new java.awt.Color(255, 255, 255));
        icons_logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_logout.png"))); // NOI18N
        icons_logout1.setText("Logout");
        icons_logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_logout1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_logout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_logout1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_logout1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_logout1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout logoutPanelLayout = new javax.swing.GroupLayout(logoutPanel);
        logoutPanel.setLayout(logoutPanelLayout);
        logoutPanelLayout.setHorizontalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(icons_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        logoutPanelLayout.setVerticalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout logoutMenuLayout = new javax.swing.GroupLayout(logoutMenu);
        logoutMenu.setLayout(logoutMenuLayout);
        logoutMenuLayout.setHorizontalGroup(
            logoutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoutMenuLayout.setVerticalGroup(
            logoutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutMenuLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(logoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logoutMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 746));

        mainMenu.setBackground(new java.awt.Color(207, 212, 220));
        mainMenu.setLayout(new java.awt.CardLayout());
        mainMenu.add(dashAdmin1, "card1");
        mainMenu.add(menuBarang1, "card2");
        mainMenu.add(menuTransaksiJual1, "card6");
        mainMenu.add(menuDataTransaksi1, "card8");

        getContentPane().add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1170, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void icons_dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_dashboard1MouseClicked
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu,"card1");
    }//GEN-LAST:event_icons_dashboard1MouseClicked

    private void icons_dashboard1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_dashboard1MouseEntered
        // TODO add your handling code here:
        dashPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_dashboard1MouseEntered

    private void icons_dashboard1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_dashboard1MouseExited
        // TODO add your handling code here:
        dashPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_dashboard1MouseExited

    private void icons_dashboard1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_dashboard1MousePressed
        // TODO add your handling code here:
        dashPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_dashboard1MousePressed

    private void icons_dashboard1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_dashboard1MouseReleased
        // TODO add your handling code here:
        dashPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_dashboard1MouseReleased

    private void icons_barang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_barang2MouseClicked
        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card2");

        menuDataBarang card2 = (menuDataBarang) mainMenu.getComponent(1);
        card2.getData();
        card2.namaSupplier();
        card2.jenisBarang();
    }//GEN-LAST:event_icons_barang2MouseClicked

    private void icons_barang2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_barang2MouseEntered
        // TODO add your handling code here:
        barangPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_barang2MouseEntered

    private void icons_barang2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_barang2MouseExited
        // TODO add your handling code here:
        barangPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_barang2MouseExited

    private void icons_barang2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_barang2MousePressed
        // TODO add your handling code here:
        barangPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_barang2MousePressed

    private void icons_barang2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_barang2MouseReleased
        // TODO add your handling code here:
        barangPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_barang2MouseReleased

    private void icons_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_transaksiMouseClicked
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card6");

        menuTransaksiJual card6 = (menuTransaksiJual) mainMenu.getComponent(2);
        card6.getData();
    }//GEN-LAST:event_icons_transaksiMouseClicked

    private void icons_transaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_transaksiMouseEntered
        // TODO add your handling code here:
        jualPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_transaksiMouseEntered

    private void icons_transaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_transaksiMouseExited
        // TODO add your handling code here:
        jualPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_transaksiMouseExited

    private void icons_transaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_transaksiMousePressed
        // TODO add your handling code here:
        jualPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_transaksiMousePressed

    private void icons_transaksiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_transaksiMouseReleased
        // TODO add your handling code here:
        jualPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_transaksiMouseReleased

    private void icons_data_transaksi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MouseClicked
        // TODO add your handling code here:

        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card8");

        menuDataTransaksi card8 = (menuDataTransaksi) mainMenu.getComponent(3);
        card8.getDataJual();
        card8.getDataBeli();
    }//GEN-LAST:event_icons_data_transaksi1MouseClicked

    private void icons_data_transaksi1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MouseEntered
        // TODO add your handling code here:
        transaksiPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_data_transaksi1MouseEntered

    private void icons_data_transaksi1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MouseExited
        // TODO add your handling code here:
        transaksiPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_data_transaksi1MouseExited

    private void icons_data_transaksi1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MousePressed
        // TODO add your handling code here:
        transaksiPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_data_transaksi1MousePressed

    private void icons_data_transaksi1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MouseReleased
        // TODO add your handling code here:
        transaksiPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_data_transaksi1MouseReleased

    private void icons_logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_logout1MouseClicked
        // TODO add your handling code here:

        if(JOptionPane.showConfirmDialog(this, "Apakah Anda Mau Logout ?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            form_login lgn = new form_login();
            lgn.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_icons_logout1MouseClicked

    private void icons_logout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_logout1MouseEntered
        // TODO add your handling code here:
        logoutPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_logout1MouseEntered

    private void icons_logout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_logout1MouseExited
        // TODO add your handling code here:
        logoutPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_logout1MouseExited

    private void icons_logout1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_logout1MousePressed
        // TODO add your handling code here:
        logoutPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_logout1MousePressed

    private void icons_logout1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_logout1MouseReleased
        // TODO add your handling code here:
        logoutPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_logout1MouseReleased

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
            java.util.logging.Logger.getLogger(dash_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dash_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dash_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dash_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dash_kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barangMenu;
    private javax.swing.JPanel barangPanel;
    private TokoFarda.dashAdmin dashAdmin1;
    private javax.swing.JPanel dashMenu;
    private javax.swing.JPanel dashPanel;
    private javax.swing.JLabel icons_admin;
    private javax.swing.JLabel icons_barang2;
    private javax.swing.JLabel icons_dashboard1;
    private javax.swing.JLabel icons_data_transaksi1;
    private javax.swing.JLabel icons_logout1;
    private javax.swing.JLabel icons_transaksi;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jualMenu;
    private javax.swing.JPanel jualPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoutMenu;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel mainMenu;
    private TokoFarda.menuDataBarang menuBarang1;
    private TokoFarda.menuDataTransaksi menuDataTransaksi1;
    private javax.swing.JPanel menuPanel;
    private TokoFarda.menuTransaksiJual menuTransaksiJual1;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel transaksiMenu;
    private javax.swing.JPanel transaksiPanel;
    // End of variables declaration//GEN-END:variables
}