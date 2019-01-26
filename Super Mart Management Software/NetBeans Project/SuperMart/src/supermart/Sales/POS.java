package supermart.Sales;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class POS extends javax.swing.JFrame {

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

    //Incetence Variables For Methods
    int tt = 0;
    String ttt = "";
    String p_quantity = "";
    String p_price = "";
    String p_id = "";
    String p_name = "";
    String entry_date = "";
    int doMinus = 0;
    String quantity_cart = "";
    String update_cartt = "";

    //For Date
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(s.format(d));
    }

    //Clear Button Clear Fields
    public void clear_Tabel_Cart() {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.setRowCount(0);
        txt_search.setText("");
        txt_cart_quantity.setText("");
        txt_product_id.setText("");
        txt_product_name.setText("");
        txt_quantity.setText("");
        txt_entry_date.setText("");
        txt_price.setText("");
        totalTxt.setText("");
        recivedTxt.setText("");
        changedueTxt.setText("");
        txt.setText("");
        try {
            String del2 = "TRUNCATE TABLE cart";
            state.executeUpdate(del2);
            String del3 = "TRUNCATE TABLE addition";
            state.executeUpdate(del3);
            String del4 = "TRUNCATE TABLE money";
            state.executeUpdate(del4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not Data Found");
        }
    }

    //summing all the data from cart table and adding to sub total textfeild
    public void multiply_and_sum() {
        try {
            String sql2 = "Select sum(Price) from cart";
            pst = con.prepareStatement(sql2);
            res = pst.executeQuery();
            if (res.next()) {
                int sum1 = res.getInt(1);
                totalTxt.setText(Integer.toString(sum1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Server Not Found");
        }
    }

    //this method is responsible for subtracting the quantity from item quantity to database
    public void math() {
        try {
            String sql = "select Quantity from stock where Product_ID='" + txt_search.getText() + "'";
            res = state.executeQuery(sql);
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            if (res.next()) {
                String instock = res.getString("Quantity");
                int nowstock = Integer.parseInt(instock);
                if (nowstock == 0 || nowstock <= 0) {
                    JOptionPane.showMessageDialog(null, "This Product is Out of Stock");
                } else {
                    int soldqty = Integer.parseInt(txt_cart_quantity.getText());
                    int newstock = nowstock - soldqty;
                    String sqlupdate = "update stock set Quantity='" + newstock + "' where Product_ID='" + txt_search.getText() + "'";
                    pst = con.prepareStatement(sqlupdate);
                    pst.execute();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Server Not Found");
        }
    }

    //inserts all the data from database/cart table to cart table
    public void fetch_cart() {
        try {
            String sqll = "select * from cart";
            ResultSet rest = state.executeQuery(sqll);
            table.setModel(DbUtils.resultSetToTableModel(rest));

        } catch (Exception e) {
        }
    }

    public void update() {
        quantity_cart = txt_cart_quantity.getText();
        update_cartt = txt_quantity.getText();
        if (Integer.parseInt(update_cartt) < Integer.parseInt(quantity_cart)) {

        }
    }

    public void check_money() {
        String paym = recivedTxt.getText();
        String total = totalTxt.getText();
        if (Integer.parseInt(paym) < Integer.parseInt(total)) {
            JOptionPane.showMessageDialog(null, "Not enough Money\nPlease insert " + totalTxt.getText());
        } else {
            String getM = recivedTxt.getText();
            String getM1 = totalTxt.getText();
            int totall = Integer.parseInt(getM) - Integer.parseInt(getM1);
            changedueTxt.setText(Integer.toString(totall));
        }
    }

    ////this the constructor of the frame
    public POS() {
        initComponents();

        //To Show Date
        showDate();

        //create connection to mysql database
        try {
            con = DriverManager.getConnection(host, username, password);
            state = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server Not Connected");

        }
        clear_Tabel_Cart();

        //Main frame Color
        getContentPane().setBackground(Color.decode("#ffffff"));

        // Table Header color and Font
        table.setBackground(Color.white);
        JTableHeader anHeader = table.getTableHeader();
        anHeader.setForeground(Color.decode("#36a265"));
        anHeader.setFont(new Font("Verdna", Font.BOLD, 15));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

        //Truncate Table Cart When Start
        try {
            String del2 = "TRUNCATE TABLE cart";
            state.executeUpdate(del2);
            String del3 = "TRUNCATE TABLE addition";
            state.executeUpdate(del3);
        } catch (Exception e) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        POSaddtocartPanel = new javax.swing.JPanel();
        toolbarEmp = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        minBtn = new javax.swing.JButton();
        HeadingLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        addtocartPanel = new javax.swing.JPanel();
        addheadingLabel = new javax.swing.JLabel();
        combo_search = new javax.swing.JComboBox();
        addcartBtn = new javax.swing.JPanel();
        addIcon = new javax.swing.JLabel();
        txt_cart_quantity = new javax.swing.JTextField();
        txt_search = new javax.swing.JTextField();
        deletepLabel6 = new javax.swing.JLabel();
        updateandremovePanel = new javax.swing.JPanel();
        updateheadingLabel = new javax.swing.JLabel();
        clearBtn = new javax.swing.JPanel();
        ClearIcon = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JPanel();
        deleteIcon = new javax.swing.JLabel();
        updateBtn = new javax.swing.JPanel();
        updateIcon = new javax.swing.JLabel();
        deletepLabel1 = new javax.swing.JLabel();
        txt_product_id = new javax.swing.JTextField();
        txt_product_name = new javax.swing.JTextField();
        deletepLabel3 = new javax.swing.JLabel();
        deletepLabel4 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        txt_entry_date = new javax.swing.JTextField();
        deletepLabel5 = new javax.swing.JLabel();
        deletepLabel2 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        tablePane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        billingPanel = new javax.swing.JPanel();
        billingheadingLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        recivedLabel = new javax.swing.JLabel();
        recivedTxt = new javax.swing.JTextField();
        changedueLabel = new javax.swing.JLabel();
        changedueTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txt = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        decimalBtn = new javax.swing.JButton();
        entBtn = new javax.swing.JButton();
        plusBtn = new javax.swing.JButton();
        backspaceBtn = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        PrintBtn = new javax.swing.JPanel();
        searchpIcon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        POSaddtocartPanel.setBackground(new java.awt.Color(255, 255, 255));
        POSaddtocartPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 3));
        POSaddtocartPanel.setForeground(new java.awt.Color(79, 196, 130));
        POSaddtocartPanel.setLayout(null);

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
        HeadingLabel.setText("Point Of Sale (POS)");
        toolbarEmp.add(HeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

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

        POSaddtocartPanel.add(toolbarEmp);
        toolbarEmp.setBounds(0, 0, 975, 60);

        addPanel.setBackground(new java.awt.Color(255, 255, 255));
        addPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        addPanel.setForeground(new java.awt.Color(255, 255, 255));
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addtocartPanel.setBackground(new java.awt.Color(255, 255, 255));
        addtocartPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        addtocartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addheadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        addheadingLabel.setForeground(new java.awt.Color(102, 102, 102));
        addheadingLabel.setText("Add To Cart");
        addtocartPanel.add(addheadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        combo_search.setBackground(new java.awt.Color(79, 196, 130));
        combo_search.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        combo_search.setForeground(new java.awt.Color(102, 102, 102));
        combo_search.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name" }));
        addtocartPanel.add(combo_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 25));

        addcartBtn.setBackground(new java.awt.Color(79, 196, 130));
        addcartBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addcartBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addcartBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addcartBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addcartBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addcartBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addcartBtnMouseReleased(evt);
            }
        });
        addcartBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addIcon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        addIcon.setForeground(new java.awt.Color(255, 255, 255));
        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addtocart.png"))); // NOI18N
        addIcon.setText(" Add");
        addIcon.setIconTextGap(5);
        addcartBtn.add(addIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        addtocartPanel.add(addcartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 90, 30));

        txt_cart_quantity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txt_cart_quantity.setForeground(new java.awt.Color(102, 102, 102));
        txt_cart_quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addtocartPanel.add(txt_cart_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, 25));

        txt_search.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txt_search.setForeground(new java.awt.Color(102, 102, 102));
        txt_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        addtocartPanel.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 25));

        deletepLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel6.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel6.setText("Quantity");
        addtocartPanel.add(deletepLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 25));

        addPanel.add(addtocartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 250));

        updateandremovePanel.setBackground(new java.awt.Color(255, 255, 255));
        updateandremovePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        updateandremovePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateheadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        updateheadingLabel.setForeground(new java.awt.Color(102, 102, 102));
        updateheadingLabel.setText("Update & Remove Cart");
        updateandremovePanel.add(updateheadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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
        clearBtn.add(ClearIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 5, -1, -1));

        updateandremovePanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 30));

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
        deleteBtn.add(deleteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        updateandremovePanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 290, 80, 30));

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
        updateBtn.add(updateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        updateandremovePanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 80, 30));

        deletepLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel1.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel1.setText("Product ID");
        updateandremovePanel.add(deletepLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 25));

        txt_product_id.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_product_id.setForeground(new java.awt.Color(102, 102, 102));
        txt_product_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        updateandremovePanel.add(txt_product_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 140, 25));

        txt_product_name.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_product_name.setForeground(new java.awt.Color(102, 102, 102));
        txt_product_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        updateandremovePanel.add(txt_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, 25));

        deletepLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel3.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel3.setText("Product Name");
        updateandremovePanel.add(deletepLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 25));

        deletepLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel4.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel4.setText("Quantity");
        updateandremovePanel.add(deletepLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 25));

        txt_quantity.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(102, 102, 102));
        txt_quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        updateandremovePanel.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, 25));

        txt_entry_date.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_entry_date.setForeground(new java.awt.Color(102, 102, 102));
        txt_entry_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        updateandremovePanel.add(txt_entry_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 140, 25));

        deletepLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel5.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel5.setText("Entry Date");
        updateandremovePanel.add(deletepLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 25));

        deletepLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        deletepLabel2.setForeground(new java.awt.Color(102, 102, 102));
        deletepLabel2.setText("Price");
        updateandremovePanel.add(deletepLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 40, 25));

        txt_price.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_price.setForeground(new java.awt.Color(102, 102, 102));
        txt_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        updateandremovePanel.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 140, 25));

        addPanel.add(updateandremovePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 290, 330));

        tablePane.setBackground(new java.awt.Color(79, 196, 130));
        tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        tablePane.setForeground(new java.awt.Color(79, 196, 130));
        tablePane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));

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
                "Product ID", "Product Name", "Quantity", "Entry Date", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(79, 196, 130));
        table.setPreferredSize(new java.awt.Dimension(675, 195));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(79, 196, 130));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        tablePane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        addPanel.add(tablePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 230));

        POSaddtocartPanel.add(addPanel);
        addPanel.setBounds(10, 70, 620, 600);

        billingPanel.setBackground(new java.awt.Color(255, 255, 255));
        billingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        billingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billingheadingLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        billingheadingLabel.setForeground(new java.awt.Color(102, 102, 102));
        billingheadingLabel.setText("Customer Payment");
        billingPanel.add(billingheadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        totalLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(102, 102, 102));
        totalLabel.setText("Sub Total");
        billingPanel.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 25));

        totalTxt.setEditable(false);
        totalTxt.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(102, 102, 102));
        totalTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        billingPanel.add(totalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 140, 25));

        recivedLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        recivedLabel.setForeground(new java.awt.Color(102, 102, 102));
        recivedLabel.setText("Recived Cash");
        billingPanel.add(recivedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 25));

        recivedTxt.setEditable(false);
        recivedTxt.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        recivedTxt.setForeground(new java.awt.Color(102, 102, 102));
        recivedTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        recivedTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recivedTxtMouseClicked(evt);
            }
        });
        billingPanel.add(recivedTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, 25));

        changedueLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        changedueLabel.setForeground(new java.awt.Color(102, 102, 102));
        changedueLabel.setText("Change Due");
        billingPanel.add(changedueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 25));

        changedueTxt.setEditable(false);
        changedueTxt.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        changedueTxt.setForeground(new java.awt.Color(102, 102, 102));
        changedueTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        billingPanel.add(changedueTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, 25));

        POSaddtocartPanel.add(billingPanel);
        billingPanel.setBounds(650, 80, 290, 210);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130), 2));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt.setEditable(false);
        txt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 196, 130)));
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMouseClicked(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });
        jPanel1.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        btn1.setBackground(new java.awt.Color(79, 196, 130));
        btn1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setBorder(null);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 40, 30));

        btn2.setBackground(new java.awt.Color(79, 196, 130));
        btn2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setBorder(null);
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 40, 30));

        btn3.setBackground(new java.awt.Color(79, 196, 130));
        btn3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setBorder(null);
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 30));

        btn4.setBackground(new java.awt.Color(79, 196, 130));
        btn4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setBorder(null);
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 40, 30));

        btn5.setBackground(new java.awt.Color(79, 196, 130));
        btn5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setBorder(null);
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 40, 30));

        btn6.setBackground(new java.awt.Color(79, 196, 130));
        btn6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setBorder(null);
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 40, 30));

        btn7.setBackground(new java.awt.Color(79, 196, 130));
        btn7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setBorder(null);
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 40, 30));

        btn8.setBackground(new java.awt.Color(79, 196, 130));
        btn8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setBorder(null);
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 40, 30));

        btn9.setBackground(new java.awt.Color(79, 196, 130));
        btn9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setBorder(null);
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        jPanel1.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 40, 30));

        btn0.setBackground(new java.awt.Color(79, 196, 130));
        btn0.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setBorder(null);
        btn0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn0MouseClicked(evt);
            }
        });
        jPanel1.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 30));

        decimalBtn.setBackground(new java.awt.Color(79, 196, 130));
        decimalBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        decimalBtn.setForeground(new java.awt.Color(255, 255, 255));
        decimalBtn.setText(".");
        decimalBtn.setBorder(null);
        decimalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decimalBtnMouseClicked(evt);
            }
        });
        jPanel1.add(decimalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 40, 30));

        entBtn.setBackground(new java.awt.Color(79, 196, 130));
        entBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        entBtn.setForeground(new java.awt.Color(255, 255, 255));
        entBtn.setText("Ent");
        entBtn.setBorder(null);
        entBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entBtnMouseClicked(evt);
            }
        });
        jPanel1.add(entBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 40, 70));

        plusBtn.setBackground(new java.awt.Color(79, 196, 130));
        plusBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        plusBtn.setForeground(new java.awt.Color(255, 255, 255));
        plusBtn.setText("+");
        plusBtn.setBorder(null);
        jPanel1.add(plusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 40, 70));

        backspaceBtn.setBackground(new java.awt.Color(79, 196, 130));
        backspaceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        backspaceBtn.setForeground(new java.awt.Color(255, 255, 255));
        backspaceBtn.setText("<-");
        backspaceBtn.setBorder(null);
        backspaceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backspaceBtnMouseClicked(evt);
            }
        });
        jPanel1.add(backspaceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 50, 30));

        clear.setBackground(new java.awt.Color(79, 196, 130));
        clear.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("C");
        clear.setBorder(null);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 50, 30));

        POSaddtocartPanel.add(jPanel1);
        jPanel1.setBounds(680, 320, 240, 280);

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
        searchpIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/purchaseprintBtn.png"))); // NOI18N
        searchpIcon1.setText("Receipt");
        searchpIcon1.setIconTextGap(10);
        PrintBtn.add(searchpIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 3, -1, -1));

        POSaddtocartPanel.add(PrintBtn);
        PrintBtn.setBounds(720, 620, 170, 40);

        getContentPane().add(POSaddtocartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 695));

        setSize(new java.awt.Dimension(976, 695));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
// Close button
    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        //Truncate Table Cart When Closeing
        try {
            String del2 = "TRUNCATE TABLE cart";
            state.executeUpdate(del2);
            String del3 = "TRUNCATE TABLE addition";
            state.executeUpdate(del3);
        } catch (Exception e) {

        }
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
        Sales_Menu obj = new Sales_Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

/// Start Clear Button ////
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
        clear_Tabel_Cart();
    }//GEN-LAST:event_clearBtnMouseClicked
/// End Clear Button ////

// ADD Btn Enter Color Change
    private void addcartBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcartBtnMouseEntered
        addcartBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_addcartBtnMouseEntered
    // ADD Btn Exited Color Change
    private void addcartBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcartBtnMouseExited
        addcartBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addcartBtnMouseExited
// ADD Btn Pressed Color Change
    private void addcartBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcartBtnMousePressed
        addcartBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_addcartBtnMousePressed
    // ADD Btn Released Color Change
    private void addcartBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcartBtnMouseReleased
        addcartBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_addcartBtnMouseReleased
    // ADD Btn Action performed
    private void addcartBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcartBtnMouseClicked

        String tttt = txt_cart_quantity.getText();
        String sql = "";
        if (txt_search.getText().equals("") && txt_cart_quantity.getText().equals("")) {
        } else {
            try {
                String sqlq = "select Quantity from stock where Product_ID='" + txt_search.getText() + "'";
                res = state.executeQuery(sqlq);
                pst = con.prepareStatement(sqlq);
                res = pst.executeQuery();
                if (res.next()) {
                    String instock = res.getString("Quantity");
                    int nowstock = Integer.parseInt(instock);
                    if (nowstock == 0) {
                        JOptionPane.showMessageDialog(null, "This Product is Out of Stock");
                    } else {
                        int soldqty = Integer.parseInt(txt_cart_quantity.getText());
                        int newstock = nowstock - soldqty;
                        String sqlupdate = "update stock set Quantity='" + newstock + "' where Product_ID='" + txt_search.getText() + "'";
                        pst = con.prepareStatement(sqlupdate);
                        pst.execute();
                    }
                }

                if (combo_search.getSelectedItem() == "Name") {
                    sql = "SELECT Product_ID,Product_Name,Quantity,Entry_Date,Price FROM stock WHERE Product_Name LIKE ?";
                } else if (combo_search.getSelectedItem() == "ID") {
                    sql = "SELECT Product_ID,Product_Name,Quantity,Entry_Date,Price FROM stock WHERE Product_ID LIKE ?";
                }
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_search.getText());
                res = pst.executeQuery();
                if (!res.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Record Not found");
                } else if (res.next()) {
                    String p_id = res.getString("Product_ID");
                    String p_name = res.getString("Product_Name");
                    p_quantity = res.getString("Quantity");
                    String p_entry_date = res.getString("Entry_Date");
                    p_price = res.getString("Price");
                    tt = Integer.parseInt(tttt) * Integer.parseInt(p_price);
                    int i = state.executeUpdate("INSERT INTO cart VALUES('" + p_id + "','" + p_name + "','" + tttt + "','" + p_entry_date + "','" + tt + "')");
                    int ii = state.executeUpdate("INSERT INTO addition VALUES('" + p_id + "','" + p_name + "','" + tttt + "','" + p_entry_date + "','" + tt + "')");
                    int iii = state.executeUpdate("insert into history select * from addition");
                    multiply_and_sum();
                    fetch_cart();
                    txt_search.setText("");
                    txt_cart_quantity.setText("");
                }

            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "This Item is Already in your cart");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        }
    }//GEN-LAST:event_addcartBtnMouseClicked
/// End Enter Button ////

/// Start Update Button ////
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

        try {
            String sqlq = "select Quantity from stock where Product_ID='" + txt_product_id.getText() + "'";
            res = state.executeQuery(sqlq);
            pst = con.prepareStatement(sqlq);
            res = pst.executeQuery();
            if (res.next()) {
                String instock = res.getString("Quantity");
                int nowstock = Integer.parseInt(instock);
                if (nowstock <= 0) {
                    JOptionPane.showMessageDialog(null, "This Product is Out of Stock");
                } else {
                    int soldqty = Integer.parseInt(txt_quantity.getText());
                    int newstock = nowstock - soldqty;
                    String sqlupdate = "update stock set Quantity='" + newstock + "' where Product_ID='" + txt_product_id.getText() + "'";
                    pst = con.prepareStatement(sqlupdate);
                    pst.execute();
                }
            }

            // int i = state.executeUpdate("INSERT INTO addition VALUES('" + txt_product_id.getText() + "','" + txt_product_name.getText() + "','" + txt_quantity.getText() + "','" + txt_entry_date.getText() + "','" + p_price + "')");
            int sum1 = 0;
            String ss = "select Price from stock where Product_ID= '" + txt_product_id.getText() + "'";
            pst = con.prepareStatement(ss);
            res = pst.executeQuery();
            if (res.next()) {
                int sum3 = res.getInt(1);
                tt = sum3 * Integer.parseInt(txt_quantity.getText());
            }
            String sql = "Update cart set Quantity =?,Price =? where Product_ID= '" + txt_product_id.getText() + "' ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txt_quantity.getText()));
            pst.setInt(2, tt);
            pst.executeUpdate();
            String sql1 = "Update addition set Quantity ='" + txt_quantity.getText() + "' where Product_ID= '" + txt_product_id.getText() + "' ";
            pst = con.prepareStatement(sql1);
            pst.executeUpdate();
            fetch_cart();
            String sqlc = "select sum(Quantity * Price ) from cart";
            pst = con.prepareStatement(sqlc);
            res = pst.executeQuery();
            if (res.next()) {
                sum1 = res.getInt(1);
                totalTxt.setText(Integer.toString(sum1));
            }
            fetch_cart();
    ////////this if condition is applied because when recieve cash texbox and change dues textbox are empty 
            ////////the program gives error because the both textboxes are empty and normally accept strings but the values are Integer.
            if (recivedTxt.getText().equals("") && changedueTxt.getText().equals("")) {

            } else {
                int doMinuss = Integer.parseInt(recivedTxt.getText()) - Integer.parseInt(totalTxt.getText());
                changedueTxt.setText(Integer.toString(doMinuss));
            }
            txt_product_id.setText("");
            txt_product_name.setText("");
            txt_quantity.setText("");
            txt_entry_date.setText("");
            txt_price.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_updateBtnMouseClicked
/// End Update Button //// 

/// Start Delete Button ////    
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
        //delete btn code here
        try {
            String sql = "delete from cart where Product_ID = '" + txt_product_id.getText() + "'";
            state.executeUpdate(sql);
            fetch_cart();
        } catch (Exception e) {
        }
        txt_product_id.setText("");
        txt_product_name.setText("");
        txt_quantity.setText("");
        txt_entry_date.setText("");
        txt_price.setText("");

    }//GEN-LAST:event_deleteBtnMouseClicked
/// End Delete Button //// 

/// Start Print Button ////     
// Print Btn Enter Color Change
    private void PrintBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseEntered
        PrintBtn.setBackground(Color.decode("#339966"));
    }//GEN-LAST:event_PrintBtnMouseEntered
    // Print Btn Exited Color Change
    private void PrintBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseExited
        PrintBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintBtnMouseExited
    // Print Btn Pressed Color Change
    private void PrintBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMousePressed
        PrintBtn.setBackground(Color.decode("#1e5837"));
    }//GEN-LAST:event_PrintBtnMousePressed
    // Print Btn Enter Released Change
    private void PrintBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseReleased
        PrintBtn.setBackground(Color.decode("#4fc482"));
    }//GEN-LAST:event_PrintBtnMouseReleased
    // Print Btn Click Action Performed
    private void PrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseClicked
        String total = totalTxt.getText();
        String recieved = recivedTxt.getText();
        String change = changedueTxt.getText();
        try {
            int i = state.executeUpdate("insert into money values('" + total + "','" + recieved + "','" + change + "')");
        } catch (Exception e) {
        }
        Sales_Receipt receipt = new Sales_Receipt();
        receipt.setVisible(true);
    }//GEN-LAST:event_PrintBtnMouseClicked
/// End Print Button ////   

    // Click On Table Row To Get Data Into Fields    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            txt_product_id.setText(model.getValueAt(i, 0).toString());
            txt_product_name.setText(model.getValueAt(i, 1).toString());
            txt_quantity.setText(model.getValueAt(i, 2).toString());
            txt_entry_date.setText(model.getValueAt(i, 3).toString());
            txt_price.setText(model.getValueAt(i, 4).toString());
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_tableMouseClicked

    //// Calculaot STart ////
    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed

        if (evt.getKeyCode() == evt.VK_NUMPAD1 || evt.getKeyCode() == evt.VK_1) {
            String input = txt.getText() + btn1.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD2 || evt.getKeyCode() == evt.VK_2) {
            String input = txt.getText() + btn2.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD3 || evt.getKeyCode() == evt.VK_3) {
            String input = txt.getText() + btn3.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD4 || evt.getKeyCode() == evt.VK_4) {
            String input = txt.getText() + btn4.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD5 || evt.getKeyCode() == evt.VK_5) {
            String input = txt.getText() + btn5.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD6 || evt.getKeyCode() == evt.VK_6) {
            String input = txt.getText() + btn6.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD7 || evt.getKeyCode() == evt.VK_7) {
            String input = txt.getText() + btn7.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD8 || evt.getKeyCode() == evt.VK_8) {
            String input = txt.getText() + btn8.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD9 || evt.getKeyCode() == evt.VK_9) {
            String input = txt.getText() + btn9.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_NUMPAD0 || evt.getKeyCode() == evt.VK_0) {
            String input = txt.getText() + btn0.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_DECIMAL) {
            String input = txt.getText() + decimalBtn.getText();
            txt.setText(input);
        } else if (evt.getKeyCode() == evt.VK_BACK_SPACE) {
            String input = txt.getText();
            if (input.length() >= 1) {
                input = input.substring(0, input.length() - 1);
                txt.setText(input);
            }
        } else if (evt.getKeyCode() == evt.VK_ENTER) {

            String input = txt.getText();

            recivedTxt.setText(input);
            if (recivedTxt.getText().equals("") && totalTxt.getText().equals("")) {

            } else {
                int txtTotal = Integer.parseInt(totalTxt.getText());
                int txtRecived = Integer.parseInt(recivedTxt.getText());
                if (txtRecived < txtTotal) {
                    JOptionPane.showMessageDialog(null, "Not enough Money\nPlease insert " + totalTxt.getText());
                    changedueTxt.equals("0");
                } else {
                    doMinus = txtRecived - txtTotal;
                    changedueTxt.setText(Integer.toString(doMinus));
                }
            }
        }
    }//GEN-LAST:event_txtKeyPressed

    // When Click Focus On Calculator Screen
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        txt.requestFocusInWindow();
    }//GEN-LAST:event_jPanel1MouseClicked

    // When Click Focus On Calculator Screen
    private void recivedTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recivedTxtMouseClicked
        txt.requestFocusInWindow();
    }//GEN-LAST:event_recivedTxtMouseClicked

    // When Click Focus On Calculator Screen
    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        txt.requestFocusInWindow();
    }//GEN-LAST:event_txtMouseClicked

    // Calculator Enter button Action
    private void entBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entBtnMouseClicked
        String input = txt.getText();

        recivedTxt.setText(input);
        if (totalTxt.getText().equals("")) {
            recivedTxt.setText(input);
        } else if (!totalTxt.getText().equals("")) {
            int txtTotal = Integer.parseInt(totalTxt.getText());
            int txtRecived = Integer.parseInt(recivedTxt.getText());
            if (txtRecived < txtTotal) {
                JOptionPane.showMessageDialog(null, "Not enough Money\nPlease insert " + totalTxt.getText());
                changedueTxt.equals("0");
            } else {
                doMinus = txtRecived - txtTotal;
                changedueTxt.setText(Integer.toString(doMinus));
            }
        }
    }//GEN-LAST:event_entBtnMouseClicked

    // Calculator 1 button Action
    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        String input = txt.getText() + btn1.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn1MouseClicked

    // Calculator 2 button Action
    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        String input = txt.getText() + btn2.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn2MouseClicked

    // Calculator 3 button Action
    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        String input = txt.getText() + btn3.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn3MouseClicked

    // Calculator 4 button Action
    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        String input = txt.getText() + btn4.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn4MouseClicked

    // Calculator 5 button Action
    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        String input = txt.getText() + btn5.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn5MouseClicked

    // Calculator 6 button Action
    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
        String input = txt.getText() + btn6.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn6MouseClicked

    // Calculator 7 button Action
    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        String input = txt.getText() + btn7.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn7MouseClicked

    // Calculator 8 button Action
    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        String input = txt.getText() + btn8.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn8MouseClicked

    // Calculator 9 button Action
    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        String input = txt.getText() + btn9.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn9MouseClicked

    // Calculator 0 button Action
    private void btn0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn0MouseClicked
        String input = txt.getText() + btn0.getText();
        txt.setText(input);
    }//GEN-LAST:event_btn0MouseClicked

    // Calculator Decimal button Action
    private void decimalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decimalBtnMouseClicked
        String input = txt.getText() + decimalBtn.getText();
        txt.setText(input);
    }//GEN-LAST:event_decimalBtnMouseClicked

    // Calculator Back button Action
    private void backspaceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backspaceBtnMouseClicked
        // TODO add your handling code here:
        String input = txt.getText();
        if (input.length() >= 1) {
            input = input.substring(0, input.length() - 1);
            txt.setText(input);
        }
    }//GEN-LAST:event_backspaceBtnMouseClicked

    // Calculator C button Aciton
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        txt.setText("");
    }//GEN-LAST:event_clearActionPerformed
//// Calculaot End ////

    // When Form Load Focus on Search ID Field
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_search.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClearIcon;
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JPanel POSaddtocartPanel;
    private javax.swing.JPanel PrintBtn;
    private javax.swing.JLabel addIcon;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel addcartBtn;
    private javax.swing.JLabel addheadingLabel;
    private javax.swing.JPanel addtocartPanel;
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton backspaceBtn;
    private javax.swing.JPanel billingPanel;
    private javax.swing.JLabel billingheadingLabel;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JLabel changedueLabel;
    private javax.swing.JTextField changedueTxt;
    private javax.swing.JButton clear;
    private javax.swing.JPanel clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JComboBox combo_search;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton decimalBtn;
    private javax.swing.JPanel deleteBtn;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JLabel deletepLabel1;
    private javax.swing.JLabel deletepLabel2;
    private javax.swing.JLabel deletepLabel3;
    private javax.swing.JLabel deletepLabel4;
    private javax.swing.JLabel deletepLabel5;
    private javax.swing.JLabel deletepLabel6;
    private javax.swing.JButton entBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minBtn;
    private javax.swing.JButton plusBtn;
    private javax.swing.JLabel recivedLabel;
    private javax.swing.JTextField recivedTxt;
    private javax.swing.JLabel searchpIcon1;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel toolbarEmp;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txt_cart_quantity;
    private javax.swing.JTextField txt_entry_date;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_product_id;
    private javax.swing.JTextField txt_product_name;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_search;
    private javax.swing.JPanel updateBtn;
    private javax.swing.JLabel updateIcon;
    private javax.swing.JPanel updateandremovePanel;
    private javax.swing.JLabel updateheadingLabel;
    // End of variables declaration//GEN-END:variables
}
