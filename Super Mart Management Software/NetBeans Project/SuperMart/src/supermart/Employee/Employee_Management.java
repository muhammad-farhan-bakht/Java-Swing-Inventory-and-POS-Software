package supermart.Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

public class Employee_Management extends javax.swing.JFrame {

    //For Pannel Dragging
    int lastX, lastY;

    //DataBase Conectio Variables
    private String dbName = "root";
    private String dbPass = "";
    private String dbConnection = "jdbc:mysql://localhost:3306/supermartdb";
    Connection con = null;
    ResultSet res = null;
    PreparedStatement pstm = null;
    ResultSet rest = null;
    Statement state = null;
    int ids = 0;

    //Browse File and get Paths
    JFileChooser file = new JFileChooser();
    String imgPath = null;

    // At start Show all Data in Table
    private void refTable() {

        try {
            String s = "select ID,Name,Contact,Age,Gender,Qualification,Job,Salary,Shift from employee_management";
            pstm = con.prepareStatement(s);
            res = pstm.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(res));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    // Image Resizing in label
    public ImageIcon ResizeImage(String ImagePath, byte[] pic) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imgBox.getWidth(), imgBox.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // To Clear all Fields
    public void clearFields() {
        idTxt.setText("");
        nameTxt.setText("");
        contactTxt.setText("");
        ageTxt.setText("");
        qualiTxt.setText("");
        jobTxt.setText("");
        salaryTxt.setText("");
        genderCbox.setSelectedItem("Male");
        shiftCbox.setSelectedItem("Morning");
        imgBox.setIcon(null);
        searchidTxt.setText("");

    }

    public Employee_Management() {
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

        //by Default hide Update button
        updateBtn.setVisible(false);

        //by Default hide Update button
        deleteBtn.setVisible(false);

        //Database Connection
        try {
            con = DriverManager.getConnection(dbConnection, dbName, dbPass);
            state = con.createStatement();
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
        idLabel = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        contactLabl = new javax.swing.JLabel();
        contactTxt = new javax.swing.JTextField();
        ageLabel1 = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderCbox = new javax.swing.JComboBox();
        qualLabel = new javax.swing.JLabel();
        qualiTxt = new javax.swing.JTextField();
        jobLabel = new javax.swing.JLabel();
        jobTxt = new javax.swing.JTextField();
        salaryLabel = new javax.swing.JLabel();
        salaryTxt = new javax.swing.JTextField();
        shiftLabel = new javax.swing.JLabel();
        shiftCbox = new javax.swing.JComboBox();
        imgBox = new javax.swing.JLabel();
        browseBtn = new javax.swing.JPanel();
        browseIcon = new javax.swing.JLabel();
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
        HeadingLabel.setText("EMPLOYEE MANAGEMENT");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

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

        jPanel1.add(toolbarEmp);
        toolbarEmp.setBounds(0, 0, 975, 60);

        addPanel.setBackground(new java.awt.Color(255, 255, 255));
        addPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        addPanel.setForeground(new java.awt.Color(255, 255, 255));
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(102, 102, 102));
        headingLabel.setText("Add & Update Employee");
        addPanel.add(headingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        idLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(102, 102, 102));
        idLabel.setText("ID");
        addPanel.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        idTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        idTxt.setForeground(new java.awt.Color(102, 102, 102));
        idTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(idTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, 25));

        nameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setText("Name");
        addPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        nameTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        nameTxt.setForeground(new java.awt.Color(102, 102, 102));
        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, 25));

        contactLabl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        contactLabl.setForeground(new java.awt.Color(102, 102, 102));
        contactLabl.setText("Contact");
        addPanel.add(contactLabl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        contactTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        contactTxt.setForeground(new java.awt.Color(102, 102, 102));
        contactTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(contactTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, 25));

        ageLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        ageLabel1.setForeground(new java.awt.Color(102, 102, 102));
        ageLabel1.setText("Age");
        addPanel.add(ageLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, -1, -1));

        ageTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ageTxt.setForeground(new java.awt.Color(102, 102, 102));
        ageTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(ageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 160, 25));

        genderLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(102, 102, 102));
        genderLabel.setText("Gender");
        addPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 230, -1, 28));

        genderCbox.setBackground(new java.awt.Color(79, 196, 130));
        genderCbox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        genderCbox.setForeground(new java.awt.Color(102, 102, 102));
        genderCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        genderCbox.setBorder(null);
        addPanel.add(genderCbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 90, 28));

        qualLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        qualLabel.setForeground(new java.awt.Color(102, 102, 102));
        qualLabel.setText("Qualification");
        addPanel.add(qualLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        qualiTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        qualiTxt.setForeground(new java.awt.Color(102, 102, 102));
        qualiTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(qualiTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 160, 25));

        jobLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jobLabel.setForeground(new java.awt.Color(102, 102, 102));
        jobLabel.setText("Job");
        addPanel.add(jobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 310, -1, -1));

        jobTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jobTxt.setForeground(new java.awt.Color(102, 102, 102));
        jobTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(jobTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, 25));

        salaryLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        salaryLabel.setForeground(new java.awt.Color(102, 102, 102));
        salaryLabel.setText("Salary");
        addPanel.add(salaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        salaryTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        salaryTxt.setForeground(new java.awt.Color(102, 102, 102));
        salaryTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(salaryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 160, 25));

        shiftLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        shiftLabel.setForeground(new java.awt.Color(102, 102, 102));
        shiftLabel.setText("Shift");
        addPanel.add(shiftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, 28));

        shiftCbox.setBackground(new java.awt.Color(79, 196, 130));
        shiftCbox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        shiftCbox.setForeground(new java.awt.Color(102, 102, 102));
        shiftCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening", "Night" }));
        shiftCbox.setBorder(null);
        addPanel.add(shiftCbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 90, 28));

        imgBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        imgBox.setForeground(new java.awt.Color(102, 102, 102));
        imgBox.setText("   Employee Image");
        imgBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addPanel.add(imgBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 110, 130));

        browseBtn.setBackground(new java.awt.Color(79, 196, 130));
        browseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        browseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                browseBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                browseBtnMouseReleased(evt);
            }
        });
        browseBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        browseIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        browseIcon.setForeground(new java.awt.Color(255, 255, 255));
        browseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browseBtn.png"))); // NOI18N
        browseIcon.setText(" Browse");
        browseBtn.add(browseIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 5, -1, -1));

        addPanel.add(browseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 90, 30));

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

        addPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 90, 30));

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

        addPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 90, 30));

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

        addPanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 90, 30));

        jPanel1.add(addPanel);
        addPanel.setBounds(50, 90, 530, 430);

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headingPanel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        headingPanel.setForeground(new java.awt.Color(102, 102, 102));
        headingPanel.setText("Serach & Remove Employee");
        searchPanel.add(headingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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
        searchBtn.add(searchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 70, -1));

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
        deleteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deleteBtn.png"))); // NOI18N
        deleteIcon.setText("Delete");
        deleteBtn.add(deleteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, -1, -1));

        searchPanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 30));

        jPanel1.add(searchPanel);
        searchPanel.setBounds(620, 170, 310, 230);

        tablePane.setBackground(new java.awt.Color(79, 196, 130));
        tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        tablePane.setForeground(new java.awt.Color(79, 196, 130));
        tablePane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        tablePane.setAutoscrolls(true);

        table.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(102, 102, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Contact", "Age", "Gender", "Qualification", "Job", "Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
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
        tablePane.setBounds(20, 540, 940, 200);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 748));

        setSize(new java.awt.Dimension(976, 748));
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
        Employee_Menu obj = new Employee_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

///// Browse Button Strat /////
    // Browse Btn Enter Color Change
    private void browseBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseBtnMouseEntered
        browseBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_browseBtnMouseEntered

    // Browse Btn Exited Color Change 
    private void browseBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseBtnMouseExited
        browseBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_browseBtnMouseExited

    // Browse Btn Pressed Color Change
    private void browseBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseBtnMousePressed
        browseBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_browseBtnMousePressed

    // Browse Btn Released Color Change
    private void browseBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseBtnMouseReleased
        browseBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_browseBtnMouseReleased

    //Browse Btn Action Performed
    private void browseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseBtnMouseClicked
        file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imgBox.setIcon(ResizeImage(path, null));
            imgPath = path;
        }

    }//GEN-LAST:event_browseBtnMouseClicked
//// Browse Button End /////

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
        // Clear All Fields
        clearFields();

        //by Default hide Update button
        deleteBtn.setVisible(false);

        // Realtion of add and update Button
        addBtn.setVisible(true);
        updateBtn.setVisible(false);

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
        String Query = "INSERT INTO `employee_management` (`ID`, `Name`, `Contact`, `Age`, `Gender`, `Qualification`, `Job`, `Salary`, `Shift`, `Image`) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {

            pstm = con.prepareStatement(Query);

            pstm.setInt(1, Integer.parseInt(idTxt.getText()));
            pstm.setString(2, nameTxt.getText().toString());
            pstm.setInt(3, Integer.parseInt(contactTxt.getText()));
            pstm.setInt(4, Integer.parseInt(ageTxt.getText()));

            String gender = String.valueOf(genderCbox.getSelectedItem());
            pstm.setString(5, gender);

            pstm.setString(6, qualiTxt.getText().toString());
            pstm.setString(7, jobTxt.getText());
            pstm.setInt(8, Integer.parseInt(salaryTxt.getText()));

            String shift = String.valueOf(shiftCbox.getSelectedItem());
            pstm.setString(9, shift);

            InputStream img = new FileInputStream(new File(imgPath));
            pstm.setBlob(10, img);

            pstm.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: Fields Are Empty");
        }
        if (pstm == null) {

        } else {

            refTable();
        }

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
        //Checking all fields must Have Values
        if (idTxt.getText().equals("") && nameTxt.getText().equals("") && contactTxt.getText().equals("") && ageTxt.getText().equals("") && qualiTxt.getText().equals("") && jobTxt.getText().equals("") && salaryTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Input All Fields Correctly");
        } else {
            // Realtion of add and update Button
            addBtn.setVisible(true);
            updateBtn.setVisible(false);

            String id = idTxt.getText().toString();

            String name = nameTxt.getText().toString();
            String Contact = contactTxt.getText().toString();
            String age = ageTxt.getText().toString();
            String gender = String.valueOf(genderCbox.getSelectedItem());
            String Qualification = qualiTxt.getText().toString();
            String job = jobTxt.getText().toString();
            String salary = salaryTxt.getText().toString();
            String shift = String.valueOf(shiftCbox.getSelectedItem());

            String Query = "UPDATE `employee_management` SET `Name`=?,`Contact`=?,`Age`=?,`Gender`=?, `Qualification`=? ,`Job`=?,`Salary`=?,`Shift`=? Where `ID`=?";

            try {
                pstm = con.prepareStatement(Query);

                pstm.setString(1, name);
                pstm.setInt(2, Integer.parseInt(Contact));
                pstm.setInt(3, Integer.parseInt(age));
                pstm.setString(4, gender);
                pstm.setString(5, Qualification);
                pstm.setString(6, job);
                pstm.setInt(7, Integer.parseInt(salary));
                pstm.setString(8, shift);
                pstm.setInt(9, Integer.parseInt(id));

                pstm.executeUpdate();

                searchidTxt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data Is Not Updated Error: " + ex);
            }

            //Refersh Table
            refTable();

        }
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
        //Check if Id text Field is not Empty

        if (searchidTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter ID");

        } else {

            PreparedStatement pstm = null;

            String id = searchidTxt.getText().toString();

            String Query = "SELECT * from employee_management where ID=?";
            try {
                pstm = con.prepareStatement(Query);

                pstm.setInt(1, Integer.parseInt(id));

                res = pstm.executeQuery();

                if (res.next()) {
                    nameTxt.setText(res.getString(2));
                    contactTxt.setText(res.getString(3));
                    ageTxt.setText(res.getString(4));

                    String gender = res.getString(5);
                    genderCbox.setSelectedItem(gender);

                    qualiTxt.setText(res.getString(6));
                    jobTxt.setText(res.getString(7));
                    salaryTxt.setText(res.getString(8));

                    String shift = res.getString(9);
                    shiftCbox.setSelectedItem(shift);

                    imgBox.setIcon(ResizeImage(null, res.getBytes("Image")));

                } else {
                    JOptionPane.showMessageDialog(null, "Please input Correct ID");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Server Error");
            }
            String a = searchidTxt.getText();
            String b = nameTxt.getText();
            if (b.equals("")) {

            } else {
                idTxt.setText(a);

                // Realtion of Search and update Button
                addBtn.setVisible(false);
                updateBtn.setVisible(true);

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
            String str = "Select ID from employee_management";

            String Query = "DELETE FROM employee_management WHERE ID=?";
            pstm = con.prepareStatement(Query);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Insert ID");
        }

        //Refresh Table
        refTable();

        //by Default hide Update button
        deleteBtn.setVisible(false);

        //Clear All Fields
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
            java.util.logging.Logger.getLogger(Employee_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClearIcon;
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel addBtn;
    private javax.swing.JLabel addIcon;
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel ageLabel1;
    private javax.swing.JTextField ageTxt;
    private javax.swing.JLabel backBtn;
    private javax.swing.JPanel browseBtn;
    private javax.swing.JLabel browseIcon;
    private javax.swing.JPanel clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel contactLabl;
    private javax.swing.JTextField contactTxt;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel deleteBtn;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JComboBox genderCbox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel headingPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel imgBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JTextField jobTxt;
    private javax.swing.JButton minBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel qualLabel;
    private javax.swing.JTextField qualiTxt;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JPanel searchBtn;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel searchidLabel;
    private javax.swing.JTextField searchidTxt;
    private javax.swing.JComboBox shiftCbox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    private javax.swing.JPanel updateBtn;
    private javax.swing.JLabel updateIcon;
    // End of variables declaration//GEN-END:variables
}
