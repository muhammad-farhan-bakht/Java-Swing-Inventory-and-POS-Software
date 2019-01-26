package supermart.Stock;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class Stock_Management extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    // Making Connection Variables
    private String dbName = "root";
    private String dbPass = "";
    private String dbConnection = "jdbc:mysql://localhost:3306/supermartdb";
    Connection con = null;
    ResultSet res = null;
    PreparedStatement pstm = null;
    ResultSet rest = null;
    Statement state = null;

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

    public void clearFields() {
        pidTxt.setText("");
        pnameTxt.setText("");
        pperpriceTxt.setText("");
        pquanityTxt.setText("");
        searchidTxt.setText("");

    }

    public Stock_Management() {
        initComponents();

        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        //For Date
        showDate();

        //by Default hide Update button
        deleteBtn.setVisible(false);

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
            state = con.createStatement();
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
        pdateTxt.setText(s.format(d));
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
        addPanel = new javax.swing.JPanel();
        headingLabel = new javax.swing.JLabel();
        pidLabel = new javax.swing.JLabel();
        pidTxt = new javax.swing.JTextField();
        pnameLabel = new javax.swing.JLabel();
        pnameTxt = new javax.swing.JTextField();
        pperpriceLabel = new javax.swing.JLabel();
        pperpriceTxt = new javax.swing.JTextField();
        pquantiyLabel = new javax.swing.JLabel();
        pquanityTxt = new javax.swing.JTextField();
        pdateLabel = new javax.swing.JLabel();
        pdateTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JPanel();
        ClearIcon = new javax.swing.JLabel();
        addBtn = new javax.swing.JPanel();
        addIcon = new javax.swing.JLabel();
        updateBtn = new javax.swing.JPanel();
        updateIcon = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        headingPanel = new javax.swing.JLabel();
        searchidLabel = new javax.swing.JLabel();
        searchidTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JPanel();
        searchIcon = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JPanel();
        deleteIcon = new javax.swing.JLabel();
        tablePane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        jPanel1.setForeground(new java.awt.Color(79, 196, 130));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        toolbarEmp.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 0, 30, 20));

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
        toolbarEmp.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("STOCK MANAGEMENT");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

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
        toolbarEmp.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, -1));

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");
        toolbarEmp.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 20));

        jPanel1.add(toolbarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 975, 60));

        addPanel.setBackground(new java.awt.Color(255, 255, 255));
        addPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        addPanel.setForeground(new java.awt.Color(255, 255, 255));
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(102, 102, 102));
        headingLabel.setText("Add & Update Stock");
        addPanel.add(headingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        pidLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pidLabel.setForeground(new java.awt.Color(102, 102, 102));
        pidLabel.setText("Product ID");
        addPanel.add(pidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        pidTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pidTxt.setForeground(new java.awt.Color(102, 102, 102));
        pidTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(pidTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 25));

        pnameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pnameLabel.setForeground(new java.awt.Color(102, 102, 102));
        pnameLabel.setText("Product Name");
        addPanel.add(pnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        pnameTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnameTxt.setForeground(new java.awt.Color(102, 102, 102));
        pnameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(pnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, 25));

        pperpriceLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pperpriceLabel.setForeground(new java.awt.Color(102, 102, 102));
        pperpriceLabel.setText("Product Price");
        addPanel.add(pperpriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        pperpriceTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pperpriceTxt.setForeground(new java.awt.Color(102, 102, 102));
        pperpriceTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(pperpriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 160, 25));

        pquantiyLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pquantiyLabel.setForeground(new java.awt.Color(102, 102, 102));
        pquantiyLabel.setText("Product Quantity");
        addPanel.add(pquantiyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        pquanityTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pquanityTxt.setForeground(new java.awt.Color(102, 102, 102));
        pquanityTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(pquanityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 160, 25));

        pdateLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pdateLabel.setForeground(new java.awt.Color(102, 102, 102));
        pdateLabel.setText("Date");
        addPanel.add(pdateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        pdateTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pdateTxt.setForeground(new java.awt.Color(102, 102, 102));
        pdateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(pdateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 160, 25));

        clearBtn.setBackground(new java.awt.Color(79, 196, 130));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clearBtnMouseReleased(evt);
            }
        });
        clearBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClearIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        ClearIcon.setForeground(new java.awt.Color(255, 255, 255));
        ClearIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clearBtn.png"))); // NOI18N
        ClearIcon.setText(" Clear");
        clearBtn.add(ClearIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 5, -1, -1));

        addPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 90, 30));

        addBtn.setBackground(new java.awt.Color(79, 196, 130));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addBtnMouseReleased(evt);
            }
        });
        addBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        addIcon.setForeground(new java.awt.Color(255, 255, 255));
        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addBtn.png"))); // NOI18N
        addIcon.setText(" Add");
        addIcon.setIconTextGap(5);
        addBtn.add(addIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 5, -1, -1));

        addPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 90, 30));

        updateBtn.setBackground(new java.awt.Color(79, 196, 130));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateBtnMouseReleased(evt);
            }
        });
        updateBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        updateIcon.setForeground(new java.awt.Color(255, 255, 255));
        updateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/updateBtn.png"))); // NOI18N
        updateIcon.setText("Update");
        updateIcon.setIconTextGap(5);
        updateBtn.add(updateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        addPanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 300, 90, 30));

        jPanel1.add(addPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 440, 360));

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headingPanel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        headingPanel.setForeground(new java.awt.Color(102, 102, 102));
        headingPanel.setText("Serach & Remove Stock");
        searchPanel.add(headingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 20, -1, -1));

        searchidLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchidLabel.setForeground(new java.awt.Color(102, 102, 102));
        searchidLabel.setText("Search ID");
        searchPanel.add(searchidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 25));

        searchidTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchidTxt.setForeground(new java.awt.Color(102, 102, 102));
        searchidTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        searchPanel.add(searchidTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, 25));

        searchBtn.setBackground(new java.awt.Color(79, 196, 130));
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchBtnMouseReleased(evt);
            }
        });
        searchBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchIcon.setForeground(new java.awt.Color(255, 255, 255));
        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchBtn.png"))); // NOI18N
        searchIcon.setText("Search");
        searchIcon.setIconTextGap(5);
        searchBtn.add(searchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        searchPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 80, 30));

        deleteBtn.setBackground(new java.awt.Color(79, 196, 130));
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteBtnMouseReleased(evt);
            }
        });
        deleteBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deleteIcon.setForeground(new java.awt.Color(255, 255, 255));
        deleteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/removeBtn.png"))); // NOI18N
        deleteIcon.setText("Remove");
        deleteBtn.add(deleteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

        searchPanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 30));

        jPanel1.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 310, 230));

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

        jPanel1.add(tablePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 462, 910, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 695));

        setSize(new java.awt.Dimension(976, 695));
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
        Stock_Menu obj = new Stock_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

/// Browse Button End /////
///// Clear Button Start /////
    // Clear Btn Enter Color Change
    private void clearBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseEntered
        clearBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_clearBtnMouseEntered

    // Clear Btn EXited Color Change
    private void clearBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseExited
        clearBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_clearBtnMouseExited

    // Clear Btn Pressed Color Change
    private void clearBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMousePressed
        clearBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_clearBtnMousePressed

    // Clear Btn Released Color Change
    private void clearBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseReleased
        clearBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_clearBtnMouseReleased

    // Clear Btn Action Performed
    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clearFields();
        //by Default hide Update button
        deleteBtn.setVisible(false);

    }//GEN-LAST:event_clearBtnMouseClicked
//// Clear Button End /////

//// Add Button Start /////
    // ADD Btn Enter Color Change
    private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
        addBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_addBtnMouseEntered

    // ADD Btn Exited Color Change
    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        addBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addBtnMouseExited

    // ADD Btn Pressed Color Change
    private void addBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMousePressed
        addBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_addBtnMousePressed

    // ADD Btn Released Color Change
    private void addBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseReleased
        addBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addBtnMouseReleased

    // ADD Btn Action performed
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked

        String id = pidTxt.getText().toString();
        String name = pnameTxt.getText().toString();
        String price = pperpriceTxt.getText().toString();
        String quantity = pquanityTxt.getText().toString();
        String date = pdateTxt.getText().toString();

        try {
            String Query = "INSERT INTO `stock` (`Product_ID`, `Product_Name`,`Quantity`, `Entry_Date`,`Price`) VALUES (?, ?, ?, ?, ?)";

            pstm = con.prepareStatement(Query);

            pstm.setInt(1, Integer.parseInt(id));
            pstm.setString(2, name);
            pstm.setInt(3, Integer.parseInt(quantity));
            pstm.setString(4, date);
            pstm.setInt(5, Integer.parseInt(price));
            pstm.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Insertion Failed ");
        }
        refTable();


    }//GEN-LAST:event_addBtnMouseClicked
//// Add Button End /////

//// Update Button Start ///// 
    // Update Btn Enter Color Change
    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        updateBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_updateBtnMouseEntered

    // Update Btn Exited Color Change
    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        updateBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_updateBtnMouseExited

    // Update Btn Pressed Color Change
    private void updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMousePressed
        updateBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_updateBtnMousePressed

    // Update Btn Released Color Change
    private void updateBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseReleased
        updateBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_updateBtnMouseReleased

    // Update Btn Action Performed
    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        String id = pidTxt.getText().toString();
        String name = pnameTxt.getText().toString();
        String price = pperpriceTxt.getText().toString();
        String quantity = pquanityTxt.getText().toString();
        String date = pdateTxt.getText().toString();

        try {
            String Query = "UPDATE `stock` SET `Product_Name`=?,`Quantity`=?,`Entry_Date`=?,`Price`=? Where `Product_ID`=?";

            pstm = con.prepareStatement(Query);

            pstm.setString(1, name);

            pstm.setInt(2, Integer.parseInt(quantity));
            pstm.setString(3, date);
            pstm.setInt(4, Integer.parseInt(price));
            pstm.setInt(5, Integer.parseInt(id));
            pstm.executeUpdate();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Data Not Found To be Updated");
        }

        //Refersh Table
        refTable();

    }//GEN-LAST:event_updateBtnMouseClicked
//// Update Button End /////    

//// Search Button Start /////
    // Search Btn Enter Color Change
    private void searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseEntered
        searchBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_searchBtnMouseEntered

    // Search Btn Exited Color Change
    private void searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseExited
        searchBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_searchBtnMouseExited

    // Search Btn Pressed Color Change
    private void searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMousePressed
        searchBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_searchBtnMousePressed

    // Search Btn Released Color Change
    private void searchBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseReleased
        searchBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_searchBtnMouseReleased

    // Search Btn Action Performed
    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        if (searchidTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter ID");

        } else {

            try {
                String id = searchidTxt.getText().toString();

                String Query = "SELECT * from stock where `Product_ID`=?";

                pstm = con.prepareStatement(Query);

                pstm.setInt(1, Integer.parseInt(id));

                res = pstm.executeQuery();

                if (res.next()) {

                    pidTxt.setText(res.getString(1));
                    pnameTxt.setText(res.getString(2));

                    pquanityTxt.setText(res.getString(3));
                    pdateTxt.setText(res.getString(4));
                    pperpriceTxt.setText(res.getString(5));
                } else {
                    JOptionPane.showMessageDialog(null, "Please input Correct ID");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Server Error");
            }

            String a = searchidTxt.getText();
            String b = pnameTxt.getText();
            if (b.equals("")) {

            } else {
                pidTxt.setText(a);

                //Relation of Serach and Update Button
                deleteBtn.setVisible(true);
            }

        }
    }//GEN-LAST:event_searchBtnMouseClicked
//// Search Button End /////

//// Delete Button Start /////
    // Delete Btn Enter Color Change
    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        deleteBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_deleteBtnMouseEntered

    // Delete Btn Exited Color Change
    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        deleteBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_deleteBtnMouseExited

    // Delete Btn Pressed Color Change
    private void deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMousePressed
        deleteBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_deleteBtnMousePressed

    // Delete Btn Relesed Color Change
    private void deleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseReleased
        deleteBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_deleteBtnMouseReleased

    // Delete Btn Action Performed
    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked

        String id = searchidTxt.getText();
        try {

            String Query = "DELETE from stock where Product_ID =?";

            pstm = con.prepareStatement(Query);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ID Not Found ");
        }
        //Refresh Table
        refTable();

        //by Default hide Update button
        deleteBtn.setVisible(false);

        //Clear all Fields
        clearFields();
    }//GEN-LAST:event_deleteBtnMouseClicked
//// Delete Button End /////

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
            java.util.logging.Logger.getLogger(Stock_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClearIcon;
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel addBtn;
    private javax.swing.JLabel addIcon;
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel backBtn;
    private javax.swing.JPanel clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel deleteBtn;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel headingPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel pdateLabel;
    private javax.swing.JTextField pdateTxt;
    private javax.swing.JLabel pidLabel;
    private javax.swing.JTextField pidTxt;
    private javax.swing.JLabel pnameLabel;
    private javax.swing.JTextField pnameTxt;
    private javax.swing.JLabel pperpriceLabel;
    private javax.swing.JTextField pperpriceTxt;
    private javax.swing.JTextField pquanityTxt;
    private javax.swing.JLabel pquantiyLabel;
    private javax.swing.JPanel searchBtn;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel searchidLabel;
    private javax.swing.JTextField searchidTxt;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    private javax.swing.JPanel updateBtn;
    private javax.swing.JLabel updateIcon;
    // End of variables declaration//GEN-END:variables
}
