package supermart.Employee;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

public class Employee_Salary_Status extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    //DataBase Conectio Variables
    private String dbName = "root";
    private String dbPass = "";
    private String dbConnection = "jdbc:mysql://localhost:3306/supermartdb";
    Connection con = null;
    ResultSet res = null;
    PreparedStatement pstm = null;

    // At start Show all Data in Table
    private void refTable() {

        try {
            String s = "select * from salary_status";
            pstm = con.prepareStatement(s);
            res = pstm.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(res));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public Employee_Salary_Status() {
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

        //table.setGridColor(Color.decode("#4fc482"));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

        //Database Connection
        try {
            con = DriverManager.getConnection(dbConnection, dbName, dbPass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Server Not Found");
        }

        //Get Data to show in Table When Starting
        refTable();

    }

    //For Date
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(s.format(d));
        dateTxt.setText(s.format(d));
    }

    //Salary + bouns In real time Method
//    private void doAdd(){
//        
//        if(bounsTxt.getText().equals("")){
//            bounsTxt.setText("");
//            totalTxt.setText("");
//        }else{
//            
//            int a = Integer.parseInt(salaryTxt.getText());
//            int b = Integer.parseInt(bounsTxt.getText());
//            int add = a+b;
//            totalTxt.setText(Integer.toString(add)+"$");
//        }
//    }
    public void clearFields() {
        sidTxt.setText("");
        nameTxt.setText("");
        salaryTxt.setText("");
        bounsTxt.setText("");
        totalTxt.setText("");
        sstatusCbox.setSelectedItem("Morning");
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
        salaryeditPanel = new javax.swing.JPanel();
        salarymangeLabel = new javax.swing.JLabel();
        searchidLabel = new javax.swing.JLabel();
        sidTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JPanel();
        searchIcon = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        salaryLabel = new javax.swing.JLabel();
        salaryTxt = new javax.swing.JTextField();
        bounsLabel = new javax.swing.JLabel();
        bounsTxt = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        datesLabel = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        salstatusLabel = new javax.swing.JLabel();
        sstatusCbox = new javax.swing.JComboBox();
        clearBtn = new javax.swing.JPanel();
        ClearIcon = new javax.swing.JLabel();
        addBtn = new javax.swing.JPanel();
        addIcon = new javax.swing.JLabel();
        updateBtn = new javax.swing.JPanel();
        updateIcon = new javax.swing.JLabel();
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
        toolbarEmp.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 30, 20));

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
        toolbarEmp.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 20));

        HeadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLabel.setText("EMPLOYEE DETAILS");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

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
        toolbarEmp.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 90, 20));

        jPanel1.add(toolbarEmp);
        toolbarEmp.setBounds(0, 0, 850, 70);

        mainheadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        mainheadingLabel.setForeground(new java.awt.Color(102, 102, 102));
        mainheadingLabel.setText("View Salary Chart");
        jPanel1.add(mainheadingLabel);
        mainheadingLabel.setBounds(500, 80, 150, 20);

        salaryeditPanel.setBackground(new java.awt.Color(255, 255, 255));
        salaryeditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        salaryeditPanel.setForeground(new java.awt.Color(79, 196, 130));
        salaryeditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salarymangeLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        salarymangeLabel.setForeground(new java.awt.Color(102, 102, 102));
        salarymangeLabel.setText("Salary Mangement");
        salaryeditPanel.add(salarymangeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        searchidLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchidLabel.setForeground(new java.awt.Color(102, 102, 102));
        searchidLabel.setText("Search ID");
        salaryeditPanel.add(searchidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 25));

        sidTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        sidTxt.setForeground(new java.awt.Color(102, 102, 102));
        sidTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        salaryeditPanel.add(sidTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, 25));

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
        searchBtn.add(searchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        salaryeditPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 80, 30));

        nameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setText("Name");
        salaryeditPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 25));

        nameTxt.setEditable(false);
        nameTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        nameTxt.setForeground(new java.awt.Color(102, 102, 102));
        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        salaryeditPanel.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, 25));

        salaryLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        salaryLabel.setForeground(new java.awt.Color(102, 102, 102));
        salaryLabel.setText("Salary");
        salaryeditPanel.add(salaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 25));

        salaryTxt.setEditable(false);
        salaryTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        salaryTxt.setForeground(new java.awt.Color(102, 102, 102));
        salaryTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        salaryeditPanel.add(salaryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, 25));

        bounsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        bounsLabel.setForeground(new java.awt.Color(102, 102, 102));
        bounsLabel.setText("Bouns");
        salaryeditPanel.add(bounsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 25));

        bounsTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bounsTxt.setForeground(new java.awt.Color(102, 102, 102));
        bounsTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        bounsTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                bounsTxtCaretUpdate(evt);
            }
        });
        salaryeditPanel.add(bounsTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 130, 25));

        totalLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(102, 102, 102));
        totalLabel.setText("Totoal Salary");
        salaryeditPanel.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 25));

        totalTxt.setEditable(false);
        totalTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(102, 102, 102));
        totalTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        salaryeditPanel.add(totalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 130, 25));

        datesLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        datesLabel.setForeground(new java.awt.Color(102, 102, 102));
        datesLabel.setText("Paid Date");
        salaryeditPanel.add(datesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 25));

        dateTxt.setEditable(false);
        dateTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        dateTxt.setForeground(new java.awt.Color(102, 102, 102));
        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        salaryeditPanel.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 130, 25));

        salstatusLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        salstatusLabel.setForeground(new java.awt.Color(102, 102, 102));
        salstatusLabel.setText("Salary Status");
        salaryeditPanel.add(salstatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 28));

        sstatusCbox.setBackground(new java.awt.Color(79, 196, 130));
        sstatusCbox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        sstatusCbox.setForeground(new java.awt.Color(102, 102, 102));
        sstatusCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paid", "UnPaid" }));
        sstatusCbox.setBorder(null);
        salaryeditPanel.add(sstatusCbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 90, 28));

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
        clearBtn.add(ClearIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 5, -1, -1));

        salaryeditPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 80, 30));

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
        addBtn.add(addIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        salaryeditPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 80, 30));

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
        updateBtn.add(updateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        salaryeditPanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 80, 30));

        jPanel1.add(salaryeditPanel);
        salaryeditPanel.setBounds(10, 80, 280, 440);

        tablePane.setBackground(new java.awt.Color(79, 196, 130));
        tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        tablePane.setForeground(new java.awt.Color(79, 196, 130));
        tablePane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        tablePane.setAutoscrolls(true);

        table.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(102, 102, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Salary", "Bouns", "Total Salary", "Paid Date", "Salary Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        tablePane.setBounds(300, 110, 540, 406);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 851, 533));

        setSize(new java.awt.Dimension(851, 533));
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
        Employee_Menu obj = new Employee_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

///// Search Button Start /////
    //Search Btn Entered Color Change
    private void searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseEntered
        searchBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_searchBtnMouseEntered

    //Search Btn Exited Color Change
    private void searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseExited
        searchBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_searchBtnMouseExited

    //Search Btn Pressed Color Change
    private void searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMousePressed
        searchBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_searchBtnMousePressed

    //Search Btn Released Color Change
    private void searchBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseReleased
        searchBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_searchBtnMouseReleased

    //Search Btn Mouse Click Action Performed
    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked

        String id = sidTxt.getText().toString();

        String Query = "SELECT Name,Salary from employee_management where ID=?";
        try {
            pstm = con.prepareStatement(Query);

            pstm.setInt(1, Integer.parseInt(id));

            res = pstm.executeQuery();

            if (res.next()) {
                nameTxt.setText(res.getString(1));
                salaryTxt.setText(res.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Data Not Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No Data Found In Server");
        }
    }//GEN-LAST:event_searchBtnMouseClicked
///// Search Button End ///// 

///// Clear Button Start /////    
    //Clear Btn Mouse Enter Color Change
    private void clearBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseEntered
        clearBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_clearBtnMouseEntered

    //Clear Btn Mouse Exited Color Change
    private void clearBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseExited
        clearBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_clearBtnMouseExited

    //Clear Btn Mouse Pressed Color Change
    private void clearBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMousePressed
        clearBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_clearBtnMousePressed

    //Clear Btn Mouse Released Color Change
    private void clearBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseReleased
        clearBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_clearBtnMouseReleased

    //Clear Btn Mouse Click Action Performed
    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clearFields();
    }//GEN-LAST:event_clearBtnMouseClicked
///// Clear Button End ///// 

///// Add Button Start /////
    //Add Btn Mouse Enter Color Change
    private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
        addBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_addBtnMouseEntered

    //Add Btn Mouse Exited Color Change
    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        addBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addBtnMouseExited

    //Add Btn Mouse Pressed Color Change
    private void addBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMousePressed
        addBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_addBtnMousePressed

    //Add Btn Mouse Released Color Change
    private void addBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseReleased
        addBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addBtnMouseReleased

    //Add Btn Mouse Click Action Performed
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        String Query = "INSERT INTO `salary_status` (`ID`, `Name`, `Salary`, `Bouns`, `Total_Salary`, `Paid_Date`, `Salary_Status`) VALUES (?,?,?,?,?,?,?)";

        try {

            pstm = con.prepareStatement(Query);

            pstm.setInt(1, Integer.parseInt(sidTxt.getText()));
            pstm.setString(2, nameTxt.getText().toString());
            pstm.setDouble(3, Double.parseDouble(salaryTxt.getText()));
            pstm.setDouble(4, Double.parseDouble(bounsTxt.getText()));
            pstm.setString(5, totalTxt.getText().toString());
            pstm.setString(6, dateTxt.getText().toString());
            String sStauts = String.valueOf(sstatusCbox.getSelectedItem());
            pstm.setString(7, sStauts);

            pstm.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Insertation Failed");
        }
        clearFields();
        refTable();


    }//GEN-LAST:event_addBtnMouseClicked
 ///// Add Button End ///// 

    //Bouns + Salary Real Time
    private void bounsTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_bounsTxtCaretUpdate
        try {
            // doAdd
            String salary = salaryTxt.getText().toString();
            String bonus = bounsTxt.getText().toString();

            Double total = Double.parseDouble(salary) + Double.parseDouble(bonus);

            totalTxt.setText(total.toString());

        } catch (Exception ex) {
        }
    }//GEN-LAST:event_bounsTxtCaretUpdate

///// Update Button Start ////
    //Update Btn Mouse Enter Event
    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        updateBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_updateBtnMouseEntered

    //Update Btn Mouse Exited Event
    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        updateBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_updateBtnMouseExited

    //Update Btn Mouse Pressed Event
    private void updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMousePressed
        updateBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_updateBtnMousePressed

    //Update Btn Mouse Released Event
    private void updateBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseReleased
        updateBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_updateBtnMouseReleased

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        String Query = "update salary_status set  Name=?, Salary=?, Bouns=?, Total_Salary=?, Paid_Date=?, Salary_Status=? where ID ='" + sidTxt.getText() + "'";

        try {

            pstm = con.prepareStatement(Query);

            pstm.setString(1, nameTxt.getText().toString());
            pstm.setDouble(2, Double.parseDouble(salaryTxt.getText()));
            pstm.setDouble(3, Double.parseDouble(bounsTxt.getText()));
            pstm.setString(4, totalTxt.getText().toString());
            pstm.setString(5, dateTxt.getText().toString());
            String sStauts = String.valueOf(sstatusCbox.getSelectedItem());

            pstm.setString(6, sStauts);

            pstm.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Failed" + ex.getMessage());
        }
        clearFields();
        refTable();
    }//GEN-LAST:event_updateBtnMouseClicked
///// Update Button End /////  

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
            java.util.logging.Logger.getLogger(Employee_Salary_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Salary_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClearIcon;
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel addBtn;
    private javax.swing.JLabel addIcon;
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel bounsLabel;
    private javax.swing.JTextField bounsTxt;
    private javax.swing.JPanel clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel datesLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mainheadingLabel;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JPanel salaryeditPanel;
    private javax.swing.JLabel salarymangeLabel;
    private javax.swing.JLabel salstatusLabel;
    private javax.swing.JPanel searchBtn;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JLabel searchidLabel;
    private javax.swing.JTextField sidTxt;
    private javax.swing.JComboBox sstatusCbox;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JPanel updateBtn;
    private javax.swing.JLabel updateIcon;
    // End of variables declaration//GEN-END:variables
}
