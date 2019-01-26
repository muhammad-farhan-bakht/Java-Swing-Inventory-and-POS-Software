package supermart.Stock;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import supermart.Admin_Menu;
import supermart.Login_Form;

public class Stock_Menu extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    public Stock_Menu() {
        initComponents();
        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //Login Btn And Sep Hidden
        logoutLabel.setVisible(false);

        //For Date
        showDate();
    }

    //For Date
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(s.format(d));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        toolbarStock = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        minBtn = new javax.swing.JButton();
        HeadingLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        stockmanBtn = new javax.swing.JPanel();
        stockmanIcon = new javax.swing.JLabel();
        stockmanSep = new javax.swing.JSeparator();
        stockmanLabel = new javax.swing.JLabel();
        stockViewBtn = new javax.swing.JPanel();
        stockviewIcon = new javax.swing.JLabel();
        stockviewSep = new javax.swing.JSeparator();
        stockviewLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        jPanel1.setForeground(new java.awt.Color(79, 196, 130));
        jPanel1.setLayout(null);

        toolbarStock.setBackground(new java.awt.Color(79, 196, 130));
        toolbarStock.setForeground(new java.awt.Color(79, 196, 130));
        toolbarStock.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolbarStockMouseDragged(evt);
            }
        });
        toolbarStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolbarStockMousePressed(evt);
            }
        });
        toolbarStock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        toolbarStock.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 0, 30, 20));

        minBtn.setBackground(new java.awt.Color(79, 196, 130));
        minBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        minBtn.setText("__");
        minBtn.setBorder(null);
        minBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        minBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minBtnActionPerformed(evt);
            }
        });
        toolbarStock.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("STOCK MENU");
        toolbarStock.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        backBtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backWhite.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        toolbarStock.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");
        toolbarStock.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 90, 20));

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
        toolbarStock.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        jPanel1.add(toolbarStock);
        toolbarStock.setBounds(0, 0, 600, 70);

        stockmanBtn.setBackground(new java.awt.Color(255, 255, 255));
        stockmanBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        stockmanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockmanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockmanBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stockmanBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stockmanBtnMouseExited(evt);
            }
        });
        stockmanBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockmanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stockmanGreen.png"))); // NOI18N
        stockmanBtn.add(stockmanIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 20, -1, -1));
        stockmanBtn.add(stockmanSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        stockmanLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        stockmanLabel.setForeground(new java.awt.Color(102, 102, 102));
        stockmanLabel.setText("Stock Management");
        stockmanBtn.add(stockmanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jPanel1.add(stockmanBtn);
        stockmanBtn.setBounds(90, 120, 160, 200);

        stockViewBtn.setBackground(new java.awt.Color(255, 255, 255));
        stockViewBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        stockViewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockViewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockViewBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stockViewBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stockViewBtnMouseExited(evt);
            }
        });
        stockViewBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockviewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/viewstockGreen.png"))); // NOI18N
        stockViewBtn.add(stockviewIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 20, -1, -1));
        stockViewBtn.add(stockviewSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        stockviewLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        stockviewLabel.setForeground(new java.awt.Color(102, 102, 102));
        stockviewLabel.setText("View Stock");
        stockViewBtn.add(stockviewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jPanel1.add(stockViewBtn);
        stockViewBtn.setBounds(350, 120, 160, 200);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 602, 401));

        setSize(new java.awt.Dimension(602, 401));
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
    private void toolbarStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarStockMousePressed
        lastX = evt.getXOnScreen();
        lastY = evt.getYOnScreen();
    }//GEN-LAST:event_toolbarStockMousePressed

    // For Pannel Dragging get
    private void toolbarStockMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarStockMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        // Move frame by the mouse delta
        setLocation(getLocationOnScreen().x + x - lastX,
                getLocationOnScreen().y + y - lastY);
        lastX = x;
        lastY = y;
    }//GEN-LAST:event_toolbarStockMouseDragged

    //Back button Hover = image change on mouse in
    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/backGreen.png"));
        backBtn.setIcon(ii);
    }//GEN-LAST:event_backBtnMouseEntered

    //Back button Hover = image change on mouse out
    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/backWhite.png"));
        backBtn.setIcon(ii);
    }//GEN-LAST:event_backBtnMouseExited

    //Back button Hover = clicked Action 
    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        Admin_Menu obj = new Admin_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    //StockManagement Button Mouse Hoover Enter
    private void stockmanBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockmanBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/stockmanWhite.png"));
        stockmanIcon.setIcon(ii);
        stockmanLabel.setForeground(Color.white);
        stockmanSep.setForeground(Color.white);
        stockmanBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_stockmanBtnMouseEntered

    //StockManagement Button Mouse Hoover Out
    private void stockmanBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockmanBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/stockmanGreen.png"));
        stockmanIcon.setIcon(ii);
        stockmanLabel.setForeground(Color.decode("#333333"));
        stockmanSep.setForeground(Color.decode("#a0a0a0"));
        stockmanBtn.setBackground(Color.white);
    }//GEN-LAST:event_stockmanBtnMouseExited

    //StockManagement Button Mouse Clicked Action
    private void stockmanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockmanBtnMouseClicked
        Stock_Management obj = new Stock_Management();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_stockmanBtnMouseClicked

    //StockView Button Mouse Hoover Enter
    private void stockViewBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockViewBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/viewstockWhite.png"));
        stockviewIcon.setIcon(ii);
        stockviewLabel.setForeground(Color.white);
        stockviewSep.setForeground(Color.white);
        stockViewBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_stockViewBtnMouseEntered

    //StockView Button Mouse Hoover Out
    private void stockViewBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockViewBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/viewstockGreen.png"));
        stockviewIcon.setIcon(ii);
        stockviewLabel.setForeground(Color.decode("#333333"));
        stockviewSep.setForeground(Color.decode("#a0a0a0"));
        stockViewBtn.setBackground(Color.white);
    }//GEN-LAST:event_stockViewBtnMouseExited

    //StockView Button Mouse Clicked Action
    private void stockViewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockViewBtnMouseClicked
        Stock_Information obj = new Stock_Information();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_stockViewBtnMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        Login_Form obj = new Login_Form();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void logoutLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseEntered
        logoutLabel.setForeground((Color.decode("#236741")));

    }//GEN-LAST:event_logoutLabelMouseEntered

    private void logoutLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseExited
        logoutLabel.setForeground((Color.decode("#FFFFFF")));

    }//GEN-LAST:event_logoutLabelMouseExited

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
            java.util.logging.Logger.getLogger(Stock_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingLabel;
    public static javax.swing.JLabel backBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel logoutLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JPanel stockViewBtn;
    private javax.swing.JPanel stockmanBtn;
    private javax.swing.JLabel stockmanIcon;
    private javax.swing.JLabel stockmanLabel;
    private javax.swing.JSeparator stockmanSep;
    private javax.swing.JLabel stockviewIcon;
    private javax.swing.JLabel stockviewLabel;
    private javax.swing.JSeparator stockviewSep;
    private javax.swing.JPanel toolbarStock;
    // End of variables declaration//GEN-END:variables
}
