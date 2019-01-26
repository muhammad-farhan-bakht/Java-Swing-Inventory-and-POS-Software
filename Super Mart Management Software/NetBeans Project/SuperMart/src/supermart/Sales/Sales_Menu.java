package supermart.Sales;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import supermart.Admin_Menu;
import supermart.Login_Form;

public class Sales_Menu extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    public Sales_Menu() {
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
        toolbarSales = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        minBtn = new javax.swing.JButton();
        HeadingLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        saleposBtn = new javax.swing.JPanel();
        saleposIcon = new javax.swing.JLabel();
        saleposSep = new javax.swing.JSeparator();
        saleposLabel = new javax.swing.JLabel();
        saleviewBtn = new javax.swing.JPanel();
        saleviewIcon = new javax.swing.JLabel();
        saleviewSep = new javax.swing.JSeparator();
        saleviewLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        jPanel1.setForeground(new java.awt.Color(79, 196, 130));
        jPanel1.setLayout(null);

        toolbarSales.setBackground(new java.awt.Color(79, 196, 130));
        toolbarSales.setForeground(new java.awt.Color(79, 196, 130));
        toolbarSales.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolbarSalesMouseDragged(evt);
            }
        });
        toolbarSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolbarSalesMousePressed(evt);
            }
        });
        toolbarSales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        toolbarSales.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 0, 30, 20));

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
        toolbarSales.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("SALES MENU");
        toolbarSales.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

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
        toolbarSales.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");
        toolbarSales.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 90, 20));

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
        toolbarSales.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        jPanel1.add(toolbarSales);
        toolbarSales.setBounds(0, 0, 600, 70);

        saleposBtn.setBackground(new java.awt.Color(255, 255, 255));
        saleposBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        saleposBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saleposBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleposBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saleposBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saleposBtnMouseExited(evt);
            }
        });
        saleposBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleposIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/posGreen.png"))); // NOI18N
        saleposBtn.add(saleposIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, -1, -1));
        saleposBtn.add(saleposSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        saleposLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        saleposLabel.setForeground(new java.awt.Color(102, 102, 102));
        saleposLabel.setText("POS");
        saleposBtn.add(saleposLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 160, -1, -1));

        jPanel1.add(saleposBtn);
        saleposBtn.setBounds(90, 120, 160, 200);

        saleviewBtn.setBackground(new java.awt.Color(255, 255, 255));
        saleviewBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        saleviewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saleviewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleviewBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saleviewBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saleviewBtnMouseExited(evt);
            }
        });
        saleviewBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleviewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/salehistroyGreen.png"))); // NOI18N
        saleviewBtn.add(saleviewIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 20, -1, -1));
        saleviewBtn.add(saleviewSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        saleviewLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        saleviewLabel.setForeground(new java.awt.Color(102, 102, 102));
        saleviewLabel.setText("View History");
        saleviewBtn.add(saleviewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 160, -1, -1));

        jPanel1.add(saleviewBtn);
        saleviewBtn.setBounds(350, 120, 160, 200);

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
    private void toolbarSalesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarSalesMousePressed
        lastX = evt.getXOnScreen();
        lastY = evt.getYOnScreen();
    }//GEN-LAST:event_toolbarSalesMousePressed

    // For Pannel Dragging get
    private void toolbarSalesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarSalesMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        // Move frame by the mouse delta
        setLocation(getLocationOnScreen().x + x - lastX,
                getLocationOnScreen().y + y - lastY);
        lastX = x;
        lastY = y;
    }//GEN-LAST:event_toolbarSalesMouseDragged

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

    //SalesPOS Button Mouse Hoover Enter
    private void saleposBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleposBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/posWhite.png"));
        saleposIcon.setIcon(ii);
        saleposLabel.setForeground(Color.white);
        saleposSep.setForeground(Color.white);
        saleposBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_saleposBtnMouseEntered

    //SalesPOS Button Mouse Hoover Out
    private void saleposBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleposBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/posGreen.png"));
        saleposIcon.setIcon(ii);
        saleposLabel.setForeground(Color.decode("#333333"));
        saleposSep.setForeground(Color.decode("#a0a0a0"));
        saleposBtn.setBackground(Color.white);
    }//GEN-LAST:event_saleposBtnMouseExited

    //SalesPOS Button Mouse Clicked Action
    private void saleposBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleposBtnMouseClicked
        POS obj = new POS();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_saleposBtnMouseClicked

    //SalesView Button Mouse Hoover Enter
    private void saleviewBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleviewBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/salehistroyWhite.png"));
        saleviewIcon.setIcon(ii);
        saleviewLabel.setForeground(Color.white);
        saleviewSep.setForeground(Color.white);
        saleviewBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_saleviewBtnMouseEntered

    //SalesView Button Mouse Hoover Out
    private void saleviewBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleviewBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/salehistroyGreen.png"));
        saleviewIcon.setIcon(ii);
        saleviewLabel.setForeground(Color.decode("#333333"));
        saleviewSep.setForeground(Color.decode("#a0a0a0"));
        saleviewBtn.setBackground(Color.white);
    }//GEN-LAST:event_saleviewBtnMouseExited

    //SalesView Button Mouse Clicked Action
    private void saleviewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleviewBtnMouseClicked
        Sales_History obj = new Sales_History();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_saleviewBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Sales_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_Menu().setVisible(true);
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
    private javax.swing.JPanel saleposBtn;
    private javax.swing.JLabel saleposIcon;
    private javax.swing.JLabel saleposLabel;
    private javax.swing.JSeparator saleposSep;
    private javax.swing.JPanel saleviewBtn;
    private javax.swing.JLabel saleviewIcon;
    private javax.swing.JLabel saleviewLabel;
    private javax.swing.JSeparator saleviewSep;
    private javax.swing.JPanel toolbarSales;
    // End of variables declaration//GEN-END:variables
}
