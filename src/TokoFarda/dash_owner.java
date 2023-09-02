/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TokoFarda;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dash_owner extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DefaultTableModel model;
    
    public dash_owner() {
        initComponents();
        setLocationRelativeTo(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        conn = Koneksi.Koneksi.KoneksiDB();
    }
  
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
        transaksiMenu = new javax.swing.JPanel();
        transaksiPanel = new javax.swing.JPanel();
        icons_data_transaksi1 = new javax.swing.JLabel();
        userMenu = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        icons_user = new javax.swing.JLabel();
        laporanMenu = new javax.swing.JPanel();
        laporanPanel = new javax.swing.JPanel();
        icons_laporan = new javax.swing.JLabel();
        logoutMenu = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        icons_logout1 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JPanel();
        dashAdmin1 = new TokoFarda.dashAdmin();
        menuDataTransaksi = new TokoFarda.menuDataTransaksi();
        menuDataUser = new TokoFarda.menuDataUser();
        menuLaporan = new TokoFarda.menuLaporan();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Toko Farda");

        sidebarPanel.setBackground(new java.awt.Color(80, 151, 210));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(205, 100));

        logoPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashOwner/icons_owner.png"))); // NOI18N

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
            .addGap(0, 167, Short.MAX_VALUE)
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

        userMenu.setBackground(new java.awt.Color(80, 151, 210));

        userPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_user.setForeground(new java.awt.Color(255, 255, 255));
        icons_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_user25.png"))); // NOI18N
        icons_user.setText("Data User");
        icons_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_userMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_userMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_userMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(icons_user, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userMenuLayout = new javax.swing.GroupLayout(userMenu);
        userMenu.setLayout(userMenuLayout);
        userMenuLayout.setHorizontalGroup(
            userMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userMenuLayout.setVerticalGroup(
            userMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userMenuLayout.createSequentialGroup()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        menuPanel.add(userMenu);

        laporanMenu.setBackground(new java.awt.Color(80, 151, 210));

        laporanPanel.setBackground(new java.awt.Color(80, 151, 210));

        icons_laporan.setForeground(new java.awt.Color(255, 255, 255));
        icons_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/DashAdmin/25/icons_laporan25.png"))); // NOI18N
        icons_laporan.setText("Data Laporan");
        icons_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icons_laporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icons_laporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icons_laporanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icons_laporanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icons_laporanMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout laporanPanelLayout = new javax.swing.GroupLayout(laporanPanel);
        laporanPanel.setLayout(laporanPanelLayout);
        laporanPanelLayout.setHorizontalGroup(
            laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporanPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(icons_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        laporanPanelLayout.setVerticalGroup(
            laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(icons_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout laporanMenuLayout = new javax.swing.GroupLayout(laporanMenu);
        laporanMenu.setLayout(laporanMenuLayout);
        laporanMenuLayout.setHorizontalGroup(
            laporanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(laporanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        laporanMenuLayout.setVerticalGroup(
            laporanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanMenuLayout.createSequentialGroup()
                .addComponent(laporanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        menuPanel.add(laporanMenu);

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
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainMenu.setBackground(new java.awt.Color(207, 212, 220));
        mainMenu.setLayout(new java.awt.CardLayout());
        mainMenu.add(dashAdmin1, "card1");
        mainMenu.add(menuDataTransaksi, "card2");
        mainMenu.add(menuDataUser, "card3");
        mainMenu.add(menuLaporan, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void icons_data_transaksi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_data_transaksi1MouseClicked
        // TODO add your handling code here:

        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card2");

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

    private void icons_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_userMouseClicked
        // TODO add your handling code here:

        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card3");
    }//GEN-LAST:event_icons_userMouseClicked

    private void icons_userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_userMouseEntered
        // TODO add your handling code here:
        userPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_userMouseEntered

    private void icons_userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_userMouseExited
        // TODO add your handling code here:
        userPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_userMouseExited

    private void icons_userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_userMousePressed
        // TODO add your handling code here:
        userPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_userMousePressed

    private void icons_userMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_userMouseReleased
        // TODO add your handling code here:
        userPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_userMouseReleased

    private void icons_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_laporanMouseClicked
        // TODO add your handling code here:

        CardLayout cl = (CardLayout) mainMenu.getLayout();
        cl.show(mainMenu, "card4");
    }//GEN-LAST:event_icons_laporanMouseClicked

    private void icons_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_laporanMouseEntered
        // TODO add your handling code here:
        laporanPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_laporanMouseEntered

    private void icons_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_laporanMouseExited
        // TODO add your handling code here:
        laporanPanel.setBackground(new Color(82, 153, 211));
    }//GEN-LAST:event_icons_laporanMouseExited

    private void icons_laporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_laporanMousePressed
        // TODO add your handling code here:
        laporanPanel.setBackground(new Color(143, 164, 195));
    }//GEN-LAST:event_icons_laporanMousePressed

    private void icons_laporanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icons_laporanMouseReleased
        // TODO add your handling code here:
        laporanPanel.setBackground(new Color(162, 188, 224));
    }//GEN-LAST:event_icons_laporanMouseReleased

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
            java.util.logging.Logger.getLogger(dash_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dash_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dash_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dash_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dash_owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private TokoFarda.dashAdmin dashAdmin1;
    private javax.swing.JPanel dashMenu;
    private javax.swing.JPanel dashPanel;
    private javax.swing.JLabel icons_admin;
    private javax.swing.JLabel icons_dashboard1;
    private javax.swing.JLabel icons_data_transaksi1;
    private javax.swing.JLabel icons_laporan;
    private javax.swing.JLabel icons_logout1;
    private javax.swing.JLabel icons_user;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel laporanMenu;
    private javax.swing.JPanel laporanPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoutMenu;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel mainMenu;
    private TokoFarda.menuDataTransaksi menuDataTransaksi;
    private TokoFarda.menuDataUser menuDataUser;
    private TokoFarda.menuLaporan menuLaporan;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel transaksiMenu;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JPanel userMenu;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
