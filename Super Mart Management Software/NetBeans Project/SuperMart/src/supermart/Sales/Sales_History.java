package supermart.Sales;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class Sales_History extends javax.swing.JFrame {

    //DataBase Connection Variables
    String host = "jdbc:mysql://localhost:3306/supermartdb";
    String username = "root";
    String password = "";
    Statement state = null;
    PreparedStatement pstm = null;
    ResultSet res = null;
    Connection con = null;

    //For Pannel Dragging
    int lastX, lastY;

    //For Date
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(s.format(d));
    }

    //To Get Data From DataBase and Show in Table When Start
    private void refTable() {

        try {
            String s = "select * from history";
            pstm = con.prepareStatement(s);
            res = pstm.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(res));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Data Found");
        }
    }

    public Sales_History() {
        initComponents();

        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //To Show Date
        showDate();

        //DataBase Connection
        try {

            con = DriverManager.getConnection(host, username, password);
            state = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server Not Connected");
        }

        //To Get Data From DataBase and Show in Table When Start
        refTable();

        // Table Header color and Font
        table.setBackground(Color.white);
        JTableHeader anHeader = table.getTableHeader();
        anHeader.setForeground(Color.decode("#36a265"));
        anHeader.setFont(new Font("Verdna", Font.BOLD, 15));

        //table.setGridColor(Color.decode("#4fc482"));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

    }

    //To Print Out
    public void printWork() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Total Receipt");

        pj.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            //print jpanel1 which i want to print out
            table.print(g2);
            return Printable.PAGE_EXISTS;
        });
        if (pj.printDialog() == false) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException xcp) {
            JOptionPane.showMessageDialog(null, "Error: No Page Found");
        }
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
        mainheadingLabel = new javax.swing.JLabel();
        searchidLabel = new javax.swing.JLabel();
        searchidTxt = new javax.swing.JTextField();
        PrinthistoryBtn = new javax.swing.JPanel();
        searchhistroyIcon = new javax.swing.JLabel();
        tablePane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

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
        toolbarEmp.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, -1, 30, 20));

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
        toolbarEmp.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, -1, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("Sales History");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

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
        toolbarEmp.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 90, 20));

        jPanel1.add(toolbarEmp);
        toolbarEmp.setBounds(0, 0, 693, 70);

        mainheadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        mainheadingLabel.setForeground(new java.awt.Color(102, 102, 102));
        mainheadingLabel.setText("View All Sales History");
        jPanel1.add(mainheadingLabel);
        mainheadingLabel.setBounds(270, 110, 190, 20);

        searchidLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchidLabel.setForeground(new java.awt.Color(102, 102, 102));
        searchidLabel.setText("Search ID");
        jPanel1.add(searchidLabel);
        searchidLabel.setBounds(20, 125, 60, 25);

        searchidTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchidTxt.setForeground(new java.awt.Color(102, 102, 102));
        searchidTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        searchidTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchidTxtCaretUpdate(evt);
            }
        });
        jPanel1.add(searchidTxt);
        searchidTxt.setBounds(90, 125, 100, 25);

        PrinthistoryBtn.setBackground(new java.awt.Color(79, 196, 130));
        PrinthistoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrinthistoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrinthistoryBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrinthistoryBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrinthistoryBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrinthistoryBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrinthistoryBtnMouseReleased(evt);
            }
        });
        PrinthistoryBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchhistroyIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchhistroyIcon.setForeground(new java.awt.Color(255, 255, 255));
        searchhistroyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printerout.png"))); // NOI18N
        searchhistroyIcon.setText("Print History");
        searchhistroyIcon.setIconTextGap(8);
        PrinthistoryBtn.add(searchhistroyIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, -1, -1));

        jPanel1.add(PrinthistoryBtn);
        PrinthistoryBtn.setBounds(550, 120, 123, 30);

        tablePane.setBackground(new java.awt.Color(79, 196, 130));
        tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        tablePane.setForeground(new java.awt.Color(79, 196, 130));
        tablePane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        tablePane.setAutoscrolls(true);

        table.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(102, 102, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Entry Date", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(79, 196, 130));
        table.setMinimumSize(new java.awt.Dimension(75, 150));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(79, 196, 130));
        table.getTableHeader().setReorderingAllowed(false);
        tablePane.setViewportView(table);

        jPanel1.add(tablePane);
        tablePane.setBounds(20, 160, 650, 360);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 694, 545));

        setSize(new java.awt.Dimension(694, 545));
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
        Sales_Menu obj = new Sales_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

//// Print Histroy Button Start /////
    // Print History Btn Enter Color Change
    private void PrinthistoryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrinthistoryBtnMouseEntered
        PrinthistoryBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_PrinthistoryBtnMouseEntered

    // Print History Btn Exited Color Change
    private void PrinthistoryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrinthistoryBtnMouseExited
        PrinthistoryBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrinthistoryBtnMouseExited

    // Print History Btn Pressed Color Change
    private void PrinthistoryBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrinthistoryBtnMousePressed
        PrinthistoryBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_PrinthistoryBtnMousePressed

    // Print History Btn Released Color Change
    private void PrinthistoryBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrinthistoryBtnMouseReleased
        PrinthistoryBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrinthistoryBtnMouseReleased

    // Print History Btn Click Action performed
    private void PrinthistoryBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrinthistoryBtnMouseClicked
        this.printWork();
    }//GEN-LAST:event_PrinthistoryBtnMouseClicked
//// Print Histroy Button End /////

    //Run Time Searching
    private void searchidTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchidTxtCaretUpdate

        try {
            String sql = "Select Product_ID,Product_Name,Quantity,Entry_Date,Price from history where Product_ID=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(searchidTxt.getText()));
            res = pstm.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(res));
        } catch (SQLException | NumberFormatException e) {

        } finally {
            try {
                res.close();
                pstm.close();
            } catch (Exception e) {
            }
        }
        if (searchidTxt.getText().equals("")) {
            refTable();
        }
    }//GEN-LAST:event_searchidTxtCaretUpdate

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
            java.util.logging.Logger.getLogger(Sales_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel PrinthistoryBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mainheadingLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel searchhistroyIcon;
    private javax.swing.JLabel searchidLabel;
    private javax.swing.JTextField searchidTxt;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    // End of variables declaration//GEN-END:variables
}
