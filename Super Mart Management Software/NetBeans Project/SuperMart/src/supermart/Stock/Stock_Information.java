package supermart.Stock;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class Stock_Information extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    // Making Connection Variables
    private String dbName = "root";
    private String dbPass = "";
    private String dbConnection = "jdbc:mysql://localhost:3306/supermartdb";
    Connection con = null;
    ResultSet res = null;
    PreparedStatement pstm = null;

    // At start Show all Data in Table
    private void refTable() {
        try {
            String s = "select * from stock";
            pstm = con.prepareStatement(s);
            res = pstm.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(res));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There Is No Data In Server");
        }
    }

    //Print Out Button
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
            tablePane.print(g2);
            return Printable.PAGE_EXISTS;
        });
        if (pj.printDialog() == false) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException xcp) {
            JOptionPane.showMessageDialog(null, "Error: " + xcp.getMessage());;;;
        }
    }

    public Stock_Information() {
        initComponents();
        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //For Date
        showDate();

        // Table Header color and Font
        table.setBackground(Color.white);
        JTableHeader anHeader = table.getTableHeader();
        anHeader.setForeground(Color.decode("#36a265"));
        anHeader.setFont(new Font("Verdna", Font.BOLD, 15));

        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

        //Checking whether connected to server or not
        try {
            con = DriverManager.getConnection(dbConnection, dbName, dbPass);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Server Not Connected");
        }

        //Get Data in Table When Starting
        refTable();

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
        mainheadingLabel = new javax.swing.JLabel();
        searchstockLabel = new javax.swing.JLabel();
        searchidTxt = new javax.swing.JTextField();
        PrintstockBtn = new javax.swing.JPanel();
        printstockIcon = new javax.swing.JLabel();
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
        HeadingLabel.setText("Stock Information");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

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
        mainheadingLabel.setText("View All Stock Details");
        jPanel1.add(mainheadingLabel);
        mainheadingLabel.setBounds(270, 110, 180, 20);

        searchstockLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchstockLabel.setForeground(new java.awt.Color(102, 102, 102));
        searchstockLabel.setText("Search ID");
        jPanel1.add(searchstockLabel);
        searchstockLabel.setBounds(20, 125, 60, 25);

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

        PrintstockBtn.setBackground(new java.awt.Color(79, 196, 130));
        PrintstockBtn.setAutoscrolls(true);
        PrintstockBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintstockBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintstockBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrintstockBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrintstockBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrintstockBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrintstockBtnMouseReleased(evt);
            }
        });
        PrintstockBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printstockIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        printstockIcon.setForeground(new java.awt.Color(255, 255, 255));
        printstockIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printerout.png"))); // NOI18N
        printstockIcon.setText("Print Stock");
        printstockIcon.setIconTextGap(8);
        PrintstockBtn.add(printstockIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 3, -1, -1));

        jPanel1.add(PrintstockBtn);
        PrintstockBtn.setBounds(550, 120, 123, 30);

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
                "Product ID", "Product Name", "Product Price", "Product Quantity", "Date"
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
        tablePane.setBounds(16, 160, 660, 360);

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
        Stock_Menu obj = new Stock_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

////Print Button Start ////    
    // Print Button Mouse Released Action
    private void PrintstockBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintstockBtnMouseReleased
        PrintstockBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintstockBtnMouseReleased

    // Print Button Mouse Pressed Action
    private void PrintstockBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintstockBtnMousePressed
        PrintstockBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_PrintstockBtnMousePressed

    // Print Button Mouse Exited Action
    private void PrintstockBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintstockBtnMouseExited
        PrintstockBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintstockBtnMouseExited

    // Print Button Mouse Entered Action
    private void PrintstockBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintstockBtnMouseEntered
        PrintstockBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_PrintstockBtnMouseEntered

    // Print Button Mouse Clicked Action
    private void PrintstockBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintstockBtnMouseClicked
        this.printWork();
    }//GEN-LAST:event_PrintstockBtnMouseClicked
////Print Button End ////

    //Real Time Searching
    private void searchidTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchidTxtCaretUpdate

        try {
            String sql = "Select Product_ID,Product_Name,Price,Quantity,Entry_Date from `stock` where Product_ID=?";
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
            java.util.logging.Logger.getLogger(Stock_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_Information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel PrintstockBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mainheadingLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel printstockIcon;
    private javax.swing.JTextField searchidTxt;
    private javax.swing.JLabel searchstockLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    // End of variables declaration//GEN-END:variables
}
