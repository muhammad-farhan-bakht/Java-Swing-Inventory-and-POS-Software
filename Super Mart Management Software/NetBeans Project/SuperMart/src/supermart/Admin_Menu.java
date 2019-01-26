/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermart;

import supermart.Stock.Stock_Menu;
import supermart.Sales.Sales_Menu;
import supermart.Employee.Employee_Menu;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

public class Admin_Menu extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    public Admin_Menu() {
        initComponents();

        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //For Date
        showDate();
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(s.format(d));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ToolbarAdmin = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        minBtn = new javax.swing.JButton();
        headingLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        seprator = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        stockBtn = new javax.swing.JPanel();
        stockIcon = new javax.swing.JLabel();
        stockSep = new javax.swing.JSeparator();
        stockLabel = new javax.swing.JLabel();
        employeeBtn = new javax.swing.JPanel();
        employeeIcon = new javax.swing.JLabel();
        employeeSep = new javax.swing.JSeparator();
        employeeLabel = new javax.swing.JLabel();
        salesBtn = new javax.swing.JPanel();
        salesIcon = new javax.swing.JLabel();
        saleSep = new javax.swing.JSeparator();
        saleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        jPanel1.setForeground(new java.awt.Color(79, 196, 130));
        jPanel1.setLayout(null);

        ToolbarAdmin.setBackground(new java.awt.Color(79, 196, 130));
        ToolbarAdmin.setForeground(new java.awt.Color(79, 196, 130));
        ToolbarAdmin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ToolbarAdminMouseDragged(evt);
            }
        });
        ToolbarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ToolbarAdminMousePressed(evt);
            }
        });
        ToolbarAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeBtn.setBackground(new java.awt.Color(79, 196, 130));
        closeBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(249, 0, 48));
        closeBtn.setText("X");
        closeBtn.setBorder(null);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        ToolbarAdmin.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 30, 20));

        minBtn.setBackground(new java.awt.Color(79, 196, 130));
        minBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        minBtn.setText("__");
        minBtn.setBorder(null);
        minBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        minBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        minBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minBtnActionPerformed(evt);
            }
        });
        ToolbarAdmin.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 0, 30, 20));

        headingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setText("ADMIN");
        headingLabel.setToolTipText("");
        ToolbarAdmin.add(headingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        logoutLabel.setBackground(new java.awt.Color(79, 196, 130));
        logoutLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setText("Logout");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutLabelMouseExited(evt);
            }
        });
        ToolbarAdmin.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 25, -1, -1));

        seprator.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout sepratorLayout = new javax.swing.GroupLayout(seprator);
        seprator.setLayout(sepratorLayout);
        sepratorLayout.setHorizontalGroup(
            sepratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );
        sepratorLayout.setVerticalGroup(
            sepratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ToolbarAdmin.add(seprator, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 50, 52, 2));

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");
        ToolbarAdmin.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 40, 90, 20));

        jPanel1.add(ToolbarAdmin);
        ToolbarAdmin.setBounds(0, 0, 740, 70);

        stockBtn.setBackground(new java.awt.Color(255, 255, 255));
        stockBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        stockBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stockBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stockBtnMouseExited(evt);
            }
        });
        stockBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_StockIcon_Green.png"))); // NOI18N
        stockBtn.add(stockIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 20, -1, -1));
        stockBtn.add(stockSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        stockLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(102, 102, 102));
        stockLabel.setText("Stock Details");
        stockBtn.add(stockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 160, -1, -1));

        jPanel1.add(stockBtn);
        stockBtn.setBounds(70, 150, 160, 200);

        employeeBtn.setBackground(new java.awt.Color(255, 255, 255));
        employeeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        employeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeeBtnMouseExited(evt);
            }
        });
        employeeBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employeeGreen.png"))); // NOI18N
        employeeBtn.add(employeeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 20, -1, -1));
        employeeBtn.add(employeeSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        employeeLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        employeeLabel.setForeground(new java.awt.Color(102, 102, 102));
        employeeLabel.setText("Employee Details");
        employeeBtn.add(employeeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 160, -1, -1));

        jPanel1.add(employeeBtn);
        employeeBtn.setBounds(290, 150, 160, 200);

        salesBtn.setBackground(new java.awt.Color(255, 255, 255));
        salesBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        salesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesBtnMouseExited(evt);
            }
        });
        salesBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salesIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_SalesIcon_Green.png"))); // NOI18N
        salesBtn.add(salesIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 20, -1, -1));
        salesBtn.add(saleSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        saleLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        saleLabel.setForeground(new java.awt.Color(102, 102, 102));
        saleLabel.setText("Sale Details");
        salesBtn.add(saleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jPanel1.add(salesBtn);
        salesBtn.setBounds(510, 150, 160, 200);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 430));

        setSize(new java.awt.Dimension(740, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Close button
    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeBtnActionPerformed

    // Minimize Button
    private void minBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minBtnActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minBtnActionPerformed

    // For Pannel Dragging Set
    private void ToolbarAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolbarAdminMousePressed
        lastX = evt.getXOnScreen();
        lastY = evt.getYOnScreen();
    }//GEN-LAST:event_ToolbarAdminMousePressed

    // For Pannel Dragging get
    private void ToolbarAdminMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolbarAdminMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        // Move frame by the mouse delta
        setLocation(getLocationOnScreen().x + x - lastX,
                getLocationOnScreen().y + y - lastY);
        lastX = x;
        lastY = y;
    }//GEN-LAST:event_ToolbarAdminMouseDragged

    //Logout Hover = color change on mouse in
    private void logoutLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseEntered
        logoutLabel.setForeground((Color.decode("#236741")));
        seprator.setBackground((Color.decode("#236741")));
    }//GEN-LAST:event_logoutLabelMouseEntered

    //Logout Hover = color change on mouse out
    private void logoutLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseExited
        logoutLabel.setForeground((Color.decode("#FFFFFF")));
        seprator.setBackground((Color.decode("#FFFFFF")));
    }//GEN-LAST:event_logoutLabelMouseExited

    //Stock Button Mouse Hoover Enter
    private void stockBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/Admin_StockIcon_White.png"));
        stockIcon.setIcon(ii);
        stockLabel.setForeground(Color.white);
        stockSep.setForeground(Color.white);
        stockBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_stockBtnMouseEntered

    //Stock Button Mouse Hoover Out
    private void stockBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/Admin_StockIcon_Green.png"));
        stockIcon.setIcon(ii);
        stockLabel.setForeground(Color.decode("#333333"));
        stockSep.setForeground(Color.decode("#a0a0a0"));
        stockBtn.setBackground(Color.white);
    }//GEN-LAST:event_stockBtnMouseExited

    //Stock Button Mouse Clicked Action
    private void stockBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockBtnMouseClicked
        Stock_Menu obj = new Stock_Menu();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_stockBtnMouseClicked

    //Employee Button Mouse Hoover Enter
    private void employeeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/employeeWhite.png"));
        employeeIcon.setIcon(ii);
        employeeLabel.setForeground(Color.white);
        employeeSep.setForeground(Color.white);
        employeeBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_employeeBtnMouseEntered

    //Employee Button Mouse Hoover Out
    private void employeeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/employeeGreen.png"));
        employeeIcon.setIcon(ii);
        employeeLabel.setForeground(Color.decode("#333333"));
        employeeSep.setForeground(Color.decode("#a0a0a0"));
        employeeBtn.setBackground(Color.white);
    }//GEN-LAST:event_employeeBtnMouseExited

    //Employee Button Mouse Clicked Action
    private void employeeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeBtnMouseClicked
        Employee_Menu obj = new Employee_Menu();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_employeeBtnMouseClicked

    //Sales Button Mouse Hoover Enter
    private void salesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/Admin_SalesIcon_White.png"));
        salesIcon.setIcon(ii);
        saleLabel.setForeground(Color.white);
        saleSep.setForeground(Color.white);
        salesBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_salesBtnMouseEntered

    //Sales Button Mouse Hoover Out
    private void salesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/Admin_SalesIcon_Green.png"));
        salesIcon.setIcon(ii);
        saleLabel.setForeground(Color.decode("#333333"));
        saleSep.setForeground(Color.decode("#a0a0a0"));
        salesBtn.setBackground(Color.white);
    }//GEN-LAST:event_salesBtnMouseExited

    //Sales Button Mouse Clicked Action
    private void salesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesBtnMouseClicked
        Sales_Menu obj = new Sales_Menu();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salesBtnMouseClicked

    // Logout button click
    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        Login_Form obj = new Login_Form();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutLabelMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ToolbarAdmin;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel employeeBtn;
    private javax.swing.JLabel employeeIcon;
    private javax.swing.JLabel employeeLabel;
    private javax.swing.JSeparator employeeSep;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel saleLabel;
    private javax.swing.JSeparator saleSep;
    private javax.swing.JPanel salesBtn;
    private javax.swing.JLabel salesIcon;
    private javax.swing.JPanel seprator;
    private javax.swing.JPanel stockBtn;
    private javax.swing.JLabel stockIcon;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JSeparator stockSep;
    // End of variables declaration//GEN-END:variables
}
