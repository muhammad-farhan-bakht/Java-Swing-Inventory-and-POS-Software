package supermart.Employee;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import supermart.Admin_Menu;
import supermart.Login_Form;

public class Employee_Menu extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    public Employee_Menu() {
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
        toolbarEmp = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        minBtn = new javax.swing.JButton();
        HeadingLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        empmanBtn = new javax.swing.JPanel();
        empmanIcon = new javax.swing.JLabel();
        empmanSep = new javax.swing.JSeparator();
        empmanLabel = new javax.swing.JLabel();
        empviewBtn = new javax.swing.JPanel();
        empviewIcon = new javax.swing.JLabel();
        empviewSep = new javax.swing.JSeparator();
        empviewLabel = new javax.swing.JLabel();
        empsalstatusBtn = new javax.swing.JPanel();
        empsalstatusIcon = new javax.swing.JLabel();
        empsalstatusSep = new javax.swing.JSeparator();
        empsalstatusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        jPanel1.setForeground(new java.awt.Color(79, 196, 130));
        jPanel1.setLayout(null);

        toolbarEmp.setBackground(new java.awt.Color(79, 196, 130));
        toolbarEmp.setForeground(new java.awt.Color(79, 196, 130));
        toolbarEmp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolbarEmpMouseDragged(evt);
            }
        });
        toolbarEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolbarEmpMousePressed(evt);
            }
        });
        toolbarEmp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        toolbarEmp.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 0, 30, 20));

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
        toolbarEmp.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("EMPLOYEE MENU");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

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
        toolbarEmp.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");
        toolbarEmp.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 90, 20));

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
        toolbarEmp.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        jPanel1.add(toolbarEmp);
        toolbarEmp.setBounds(0, 0, 600, 70);

        empmanBtn.setBackground(new java.awt.Color(255, 255, 255));
        empmanBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        empmanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empmanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empmanBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                empmanBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                empmanBtnMouseExited(evt);
            }
        });
        empmanBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empmanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employeemanGreen.png"))); // NOI18N
        empmanBtn.add(empmanIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 20, -1, -1));
        empmanBtn.add(empmanSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        empmanLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        empmanLabel.setForeground(new java.awt.Color(102, 102, 102));
        empmanLabel.setText("Employee Management");
        empmanBtn.add(empmanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 160, -1, -1));

        jPanel1.add(empmanBtn);
        empmanBtn.setBounds(30, 120, 160, 200);

        empviewBtn.setBackground(new java.awt.Color(255, 255, 255));
        empviewBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        empviewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empviewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empviewBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                empviewBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                empviewBtnMouseExited(evt);
            }
        });
        empviewBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empviewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/viewemployeGreen.png"))); // NOI18N
        empviewBtn.add(empviewIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 20, -1, -1));
        empviewBtn.add(empviewSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        empviewLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        empviewLabel.setForeground(new java.awt.Color(102, 102, 102));
        empviewLabel.setText("View Employee");
        empviewBtn.add(empviewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 160, -1, -1));

        jPanel1.add(empviewBtn);
        empviewBtn.setBounds(220, 120, 160, 200);

        empsalstatusBtn.setBackground(new java.awt.Color(255, 255, 255));
        empsalstatusBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        empsalstatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empsalstatusBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empsalstatusBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                empsalstatusBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                empsalstatusBtnMouseExited(evt);
            }
        });
        empsalstatusBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empsalstatusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/salary_status_green.png"))); // NOI18N
        empsalstatusBtn.add(empsalstatusIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 20, -1, -1));
        empsalstatusBtn.add(empsalstatusSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 10));

        empsalstatusLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        empsalstatusLabel.setForeground(new java.awt.Color(102, 102, 102));
        empsalstatusLabel.setText("Salary Status");
        empsalstatusBtn.add(empsalstatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 160, -1, -1));

        jPanel1.add(empsalstatusBtn);
        empsalstatusBtn.setBounds(410, 120, 160, 200);

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
    private void toolbarEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarEmpMousePressed
        lastX = evt.getXOnScreen();
        lastY = evt.getYOnScreen();
    }//GEN-LAST:event_toolbarEmpMousePressed

    // For Pannel Dragging get
    private void toolbarEmpMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarEmpMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        // Move frame by the mouse delta
        setLocation(getLocationOnScreen().x + x - lastX,
                getLocationOnScreen().y + y - lastY);
        lastX = x;
        lastY = y;
    }//GEN-LAST:event_toolbarEmpMouseDragged

    //Back button Hover = image change on mouse in
    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        //backBtn.setIcon(new ImageIcon("C:\\Users\\Farhan\\Documents\\NetBeansProjects\\SuperMart\\Resources\\Images/backGreen.png"));
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/backGreen.png"));
        backBtn.setIcon(ii);
    }//GEN-LAST:event_backBtnMouseEntered

    //Back button Hover = image change on mouse out
    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        //backBtn.setIcon(new ImageIcon("C:\\Users\\Farhan\\Documents\\NetBeansProjects\\SuperMart\\Resources\\Images/backWhite.png"));  
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/backWhite.png"));
        backBtn.setIcon(ii);
    }//GEN-LAST:event_backBtnMouseExited

    //Back button Hover = clicked Action 
    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        Admin_Menu obj = new Admin_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    //EmployeeMan Button Mouse Hoover Enter
    private void empmanBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empmanBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/employeemanWhite.png"));
        empmanIcon.setIcon(ii);
        empmanLabel.setForeground(Color.white);
        empmanSep.setForeground(Color.white);
        empmanBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_empmanBtnMouseEntered

    //EmployeeMan Button Mouse Hoover Out
    private void empmanBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empmanBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/employeemanGreen.png"));
        empmanIcon.setIcon(ii);
        empmanLabel.setForeground(Color.decode("#333333"));
        empmanSep.setForeground(Color.decode("#a0a0a0"));
        empmanBtn.setBackground(Color.white);
    }//GEN-LAST:event_empmanBtnMouseExited

    //EmployeeMan Button Mouse Clicked Action
    private void empmanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empmanBtnMouseClicked
        Employee_Management obj = new Employee_Management();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empmanBtnMouseClicked

    //EmployeeView Button Mouse Hoover Enter
    private void empviewBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empviewBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/viewemployeWhite.png"));
        empviewIcon.setIcon(ii);
        empviewLabel.setForeground(Color.white);
        empviewSep.setForeground(Color.white);
        empviewBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_empviewBtnMouseEntered

    //EmployeeView Button Mouse Hoover Out
    private void empviewBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empviewBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/viewemployeGreen.png"));
        empviewIcon.setIcon(ii);
        empviewLabel.setForeground(Color.decode("#333333"));
        empviewSep.setForeground(Color.decode("#a0a0a0"));
        empviewBtn.setBackground(Color.white);
    }//GEN-LAST:event_empviewBtnMouseExited

    //EmployeeView Button Mouse Clicked Action
    private void empviewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empviewBtnMouseClicked
        Employee_Details obj = new Employee_Details();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empviewBtnMouseClicked

    //EmployeeSalaryStatus Button Mouse Hover Enter
    private void empsalstatusBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empsalstatusBtnMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/salary_status_white.png"));
        empsalstatusIcon.setIcon(ii);
        empsalstatusLabel.setForeground(Color.white);
        empsalstatusSep.setForeground(Color.white);
        empsalstatusBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_empsalstatusBtnMouseEntered

    //EmployeeSalaryStatus Button Mouse Hover Out
    private void empsalstatusBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empsalstatusBtnMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/salary_status_green.png"));
        empsalstatusIcon.setIcon(ii);
        empsalstatusLabel.setForeground(Color.decode("#333333"));
        empsalstatusSep.setForeground(Color.decode("#a0a0a0"));
        empsalstatusBtn.setBackground(Color.white);
    }//GEN-LAST:event_empsalstatusBtnMouseExited

    //EmployeeSalaryStatus Button Mouse Clicked Action
    private void empsalstatusBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empsalstatusBtnMouseClicked
        Employee_Salary_Status obj = new Employee_Salary_Status();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empsalstatusBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Employee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingLabel;
    public static javax.swing.JLabel backBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel empmanBtn;
    private javax.swing.JLabel empmanIcon;
    private javax.swing.JLabel empmanLabel;
    private javax.swing.JSeparator empmanSep;
    private javax.swing.JPanel empsalstatusBtn;
    private javax.swing.JLabel empsalstatusIcon;
    private javax.swing.JLabel empsalstatusLabel;
    private javax.swing.JSeparator empsalstatusSep;
    private javax.swing.JPanel empviewBtn;
    private javax.swing.JLabel empviewIcon;
    private javax.swing.JLabel empviewLabel;
    private javax.swing.JSeparator empviewSep;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel logoutLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JPanel toolbarEmp;
    // End of variables declaration//GEN-END:variables
}
