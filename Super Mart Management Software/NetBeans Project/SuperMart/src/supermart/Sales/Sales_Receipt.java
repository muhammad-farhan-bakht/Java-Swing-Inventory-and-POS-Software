package supermart.Sales;

import java.awt.Color;
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
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Sales_Receipt extends javax.swing.JFrame {

    //DataBase Connection Variables
    String host = "jdbc:mysql://localhost:3306/supermartdb";
    String username = "root";
    String password = "";
    Statement state = null;
    PreparedStatement pst = null;
    ResultSet res = null;
    Connection con = null;

    //For Pannel Dragging
    int lastX, lastY;
    int totalPrice = 0;

    //Varible Used In To Show Data In Receipt
    int cashrecieved = 0;
    int changedue = 0;

    public Sales_Receipt() {
        initComponents();

        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //DataBase Connection
        try {

            con = DriverManager.getConnection(host, username, password);
            state = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server Not Connected");
        }

        //To Get Data And Show in Receipt 
        try {
            String sql1 = "select * from money";
            ResultSet res = state.executeQuery(sql1);
            while (res.next()) {
                totalPrice = res.getInt("Sub_Total");
                cashrecieved = res.getInt("Cash_Received");
                changedue = res.getInt("Due_Change");
            }

            String sql = "select * from addition";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String quantity = rs.getString(3);
                java.sql.Date date = rs.getDate(4);
                int price = rs.getInt(5);
                if (receiptTxtArea.getText().equals("")) {
                    receiptTxtArea.append("============================================================\n"
                            + "\t            Mart Management System \n\n"
                            + "ProductID       "
                            + "ProductName      "
                            + "Quantity                  "
                            + "Entry Date        "
                            + " Price\n"
                            + "     " + id
                            + "\t" + name
                            + "\t" + quantity
                            + "\t" + date
                            + "\t" + price
                            + "\n"
                    );
                } else if (!receiptTxtArea.getText().equals("")) {
                    receiptTxtArea.append("     " + id
                            + "\t" + name
                            + "\t" + quantity
                            + "\t" + date
                            + "\t" + price
                            + "\n"
                    );

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cart Is Empty");
        } finally {
            receiptTxtArea.append("============================================================\n"
                    + "\nTotal Price:\t\t\t\t" + totalPrice
                    + "\nCash Recieved:\t\t\t\t" + cashrecieved
                    + "\nDue Change:\t\t\t\t" + changedue
                    + "\n\n\n\n\n\n\n\n\n"
                    + "                FOR ANY COMPLAINT & SUGGESTION PLEASE EMAIL US\n"
                    + "\t                        MFA@gmail.com\n\n"
                    + "\t         WE ARE PLEASED TO SERVE YOU"
            );

        }

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
            receiptTxtArea.print(g2);
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
        toolbarSales = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        HeadingLabel = new javax.swing.JLabel();
        PrintBtn = new javax.swing.JPanel();
        searchpIcon1 = new javax.swing.JLabel();
        printPanel = new javax.swing.JPanel();
        mainLabel = new javax.swing.JLabel();
        receiptPanel = new javax.swing.JScrollPane();
        receiptTxtArea = new javax.swing.JTextArea();

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
        toolbarSales.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("SALES RECEIPT");
        toolbarSales.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jPanel1.add(toolbarSales);
        toolbarSales.setBounds(0, 0, 470, 60);

        PrintBtn.setBackground(new java.awt.Color(79, 196, 130));
        PrintBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrintBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrintBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrintBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrintBtnMouseReleased(evt);
            }
        });
        PrintBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchpIcon1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        searchpIcon1.setForeground(new java.awt.Color(255, 255, 255));
        searchpIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printout-28.png"))); // NOI18N
        searchpIcon1.setText("Print Receipt");
        searchpIcon1.setIconTextGap(10);
        PrintBtn.add(searchpIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jPanel1.add(PrintBtn);
        PrintBtn.setBounds(270, 540, 180, 40);

        printPanel.setBackground(new java.awt.Color(255, 255, 255));
        printPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(102, 102, 102));
        mainLabel.setText("SUPER MART");
        printPanel.add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));

        receiptTxtArea.setEditable(false);
        receiptTxtArea.setColumns(20);
        receiptTxtArea.setForeground(new java.awt.Color(102, 102, 102));
        receiptTxtArea.setRows(5);
        receiptTxtArea.setBorder(null);
        receiptPanel.setViewportView(receiptTxtArea);

        printPanel.add(receiptPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 55, 440, 400));

        jPanel1.add(printPanel);
        printPanel.setBounds(10, 70, 450, 460);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 601));

        setSize(new java.awt.Dimension(470, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Close button
    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        try {
            String del2 = "TRUNCATE TABLE money";
            state.executeUpdate(del2);

        } catch (Exception e) {

        }
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

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

    private void PrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseClicked
        this.printWork();
    }//GEN-LAST:event_PrintBtnMouseClicked

    private void PrintBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseEntered
        PrintBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_PrintBtnMouseEntered

    private void PrintBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseExited
        PrintBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintBtnMouseExited

    private void PrintBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMousePressed
        PrintBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_PrintBtnMousePressed

    private void PrintBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseReleased
        PrintBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintBtnMouseReleased

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
            java.util.logging.Logger.getLogger(Sales_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel PrintBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel printPanel;
    private javax.swing.JScrollPane receiptPanel;
    private javax.swing.JTextArea receiptTxtArea;
    private javax.swing.JLabel searchpIcon1;
    private javax.swing.JPanel toolbarSales;
    // End of variables declaration//GEN-END:variables
}
