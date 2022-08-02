/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.ProductInBill;
import Bean.Discount;
import Bean.Bill;
import Bean.Product;
import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.WarehouseDAO;
import DAO.ProductDAO;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIETTHI_PC
 */
public class ThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form ThanhToan
     */
    private DecimalFormat df;
    private int MaPhong, MaHoaDon;
    DefaultListModel<Product> ListModel;
    private DefaultTableModel model;
    private int soLuong = 0;
    private List<ProductInBill> sp;
    private Bill hoaDon;
    private EmployeeHomeView ep;
    private int branchCode;

    public ThanhToan() {
        initComponents();
        setUI();
        // hienThiGioVaoRa();
        HienThiTongTienSanPham();
    }

    public ThanhToan(int MaPhong, int MaHoaDon, int branchCode, EmployeeHomeView ep) {
        this.MaPhong = MaPhong;
        this.MaHoaDon = MaHoaDon;
        this.ep = ep;
        this.branchCode = branchCode;
        initComponents();
        setUI();
        hienThiGioVaoRa();
        HienThiTongTienSanPham();
    }

    private void setUI() {
        df = new DecimalFormat("#");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);// định dạng số
        model = (DefaultTableModel) TbSanPham.getModel();
        soLuongtxt.setText(Integer.toString(soLuong));
        txtBillCode.setText("Mã hóa đơn: " + MaHoaDon);
//        System.out.println(CustomerDAO.getCustomer(MaHoaDon).getFullName());
        txtCustomerName.setText("Tên khách hàng: " + CustomerDAO.getCustomer(MaHoaDon).getFullName());
        txtPhong.setText("Phòng: " + MaPhong);
        TbSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) TbSanPham.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        //   jTable1.getTableHeader().setOpaque(false);
        TbSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TbSanPham.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbSanPham.getColumnModel().getColumn(1).setPreferredWidth(80);
        TbSanPham.getColumnModel().getColumn(2).setPreferredWidth(130);
        TbSanPham.getColumnModel().getColumn(3).setPreferredWidth(168);
        showListSanPham();
        showList();
    }

    private void hienThiGioVaoRa() {
        hoaDon = BillDAO.getBill(MaHoaDon);
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        txtVao.setText(sf.format(hoaDon.getCheckIn()));
        if (hoaDon.getCheckOut()!= null) {
            txtRa.setText(sf.format(hoaDon.getCheckOut()));
        } else {
            txtRa.setText("chưa thanh toán");
            txtSoGio.setText("chưa thanh toán");
            txtTongTienPhong.setText("NULL");
            txtTongCong.setText("NULL");
            txtThue.setText("NULL");
            txtTongThanhToan.setText("NULL");
            txtGiamGia.setText("NULL");
        }

    }

    private void HienThiTongTienSanPham() {
        txtTongTienSanPham.setText(String.valueOf(df.format(BillDAO.getTotalProductPrice(MaHoaDon))) + " VND");
    }

    private double TienVAT(double phantram) {
        return phantram * (BillDAO.getTotal(MaHoaDon) - BillDAO.getVATTax(MaHoaDon));
    }

    private void HienThiTienGiam() {
        Discount gg = BillDAO.giamGia(MaHoaDon);
        txtGiamGia.setText("(" + gg.getDiscountCode()+ ":" + String.valueOf(gg.getPercent()) + "%) "
                + String.valueOf(df.format(gg.getPercent() * (BillDAO.getTotal(MaHoaDon)
                        - BillDAO.getVATTax(MaHoaDon)))) + " VND");
    }

    private void HienThiThanhToan() {
        txtTongThanhToan.setText(String.valueOf(df.format(BillDAO.getTotalPrice(MaHoaDon))) + " VND");
    }

    private void HienThiTongTienTongCong() {
        txtTongCong.setText(String.valueOf(df.format(BillDAO.getTotalPrice(MaHoaDon))) + " VND");

    }

    private void HienThiVAT() {
        txtThue.setText(String.valueOf(df.format(BillDAO.getVATTax(MaHoaDon))) + " VND");
    }

    private void HienThiTongTienPhong() {
        txtTongTienPhong.setText(String.valueOf(df.format(BillDAO.getTotalRoomPrice(MaHoaDon))) + " VND");
        txtSoGio.setText(String.valueOf(BillDAO.getTimes(MaHoaDon)) + " giờ");
    }

    private void showListSanPham() {
        ListModel = new DefaultListModel();
        List<Product> list = WarehouseDAO.listProductInBranch(branchCode);
        for (Product a : list) {
            ListModel.addElement(a);
            System.out.println(a.toString());
        }
        ListSP.setModel(ListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPhong = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        txtCustomerName = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListSP = new javax.swing.JList<>();
        soLuongtxt = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lbnTru = new javax.swing.JLabel();
        lbnCong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGioRa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sadsa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSoGio = new javax.swing.JLabel();
        txtVao = new javax.swing.JLabel();
        txtTongTienPhong = new javax.swing.JLabel();
        txtGioRa1 = new javax.swing.JLabel();
        txtRa = new javax.swing.JLabel();
        txtTongTienSanPham = new javax.swing.JLabel();
        txtTongThanhToan = new javax.swing.JLabel();
        txtTongCong = new javax.swing.JLabel();
        txtThue = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JLabel();
        txtBillCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(385, 103));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(179, 205, 224));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delete_52px.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, -1, -1));

        txtPhong.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 27)); // NOI18N
        txtPhong.setForeground(new java.awt.Color(153, 0, 0));
        txtPhong.setText("Phòng: 01 ");
        jPanel2.add(txtPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        btnXoa.setBackground(new java.awt.Color(46, 204, 113));
        btnXoa.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.setBorderPainted(false);
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 580, 80, 30));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtCustomerName.setText("Tên khách hàng: Nguyen Viet Thi");
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, -1));

        btnThanhToan.setBackground(new java.awt.Color(46, 204, 113));
        btnThanhToan.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(null);
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        jPanel2.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 820, 130, 40));

        btnOK.setBackground(new java.awt.Color(46, 204, 113));
        btnOK.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnOK.setText("Xong");
        btnOK.setBorder(null);
        btnOK.setBorderPainted(false);
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });
        jPanel2.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 820, 130, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TbSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TbSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"Mỳ tôm", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá", "Tổng tiền"
            }
        ));
        TbSanPham.setFocusable(false);
        TbSanPham.setGridColor(new java.awt.Color(54, 54, 54));
        TbSanPham.setName(""); // NOI18N
        TbSanPham.setRowHeight(35);
        TbSanPham.getTableHeader().setReorderingAllowed(false);
        TbSanPham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TbSanPhamFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TbSanPhamFocusLost(evt);
            }
        });
        TbSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TbSanPhamKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TbSanPhamKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TbSanPham);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 600, 480));

        jPanel1.setBackground(new java.awt.Color(139, 157, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_24px.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.setText("Tìm kiếm món");
        txtTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimMouseClicked(evt);
            }
        });
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });
        jPanel3.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 360, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 410, 40));

        ListSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane2.setViewportView(ListSP);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 530, 670));

        soLuongtxt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        soLuongtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        soLuongtxt.setText("0");
        soLuongtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuongtxtActionPerformed(evt);
            }
        });
        jPanel1.add(soLuongtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 790, 60, 30));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 790, 70, 30));

        lbnTru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_back_to_48px.png"))); // NOI18N
        lbnTru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbnTruMouseClicked(evt);
            }
        });
        jPanel1.add(lbnTru, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 780, -1, -1));

        lbnCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_next_page_48px_2.png"))); // NOI18N
        lbnCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbnCongMouseClicked(evt);
            }
        });
        jPanel1.add(lbnCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 780, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 860));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Giảm giá:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 740, -1, -1));

        txtGioRa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtGioRa.setText("Số giờ:");
        jPanel2.add(txtGioRa, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 690, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Thuế VAT:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 700, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 690, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Tổng tiền thanh toán:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 780, -1, -1));

        sadsa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sadsa.setText("Giờ vào:");
        jPanel2.add(sadsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Tổng tiền phòng: ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 730, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Tổng cộng:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 660, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Tổng tiền sản phẩm: ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, -1, -1));

        txtSoGio.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtSoGio.setText("12:00:23 26/12/2020");
        jPanel2.add(txtSoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, 170, 20));

        txtVao.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtVao.setText("12:00:23 26/12/2020");
        jPanel2.add(txtVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 170, 20));

        txtTongTienPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTongTienPhong.setText("13000 VND");
        jPanel2.add(txtTongTienPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 730, 130, 20));

        txtGioRa1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtGioRa1.setText("Giờ ra:");
        jPanel2.add(txtGioRa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, -1, -1));

        txtRa.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtRa.setText("12:00:23 26/12/2020");
        jPanel2.add(txtRa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 650, 170, 20));

        txtTongTienSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTongTienSanPham.setText("13000 VND");
        jPanel2.add(txtTongTienSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 620, 130, 20));

        txtTongThanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTongThanhToan.setText("13000 VND");
        jPanel2.add(txtTongThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 780, 130, 20));

        txtTongCong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTongCong.setText("13000 VND");
        jPanel2.add(txtTongCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 130, 20));

        txtThue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThue.setText("13000 VND");
        jPanel2.add(txtThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 700, 130, 20));

        txtGiamGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGiamGia.setText("13000 VND");
        jPanel2.add(txtGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 740, 190, 20));

        txtBillCode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtBillCode.setText("Mã hóa đơn: 12");
        jPanel2.add(txtBillCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void soLuongtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soLuongtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongtxtActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        List<Product> sanPham = ListSP.getSelectedValuesList();
        if (Integer.parseInt(soLuongtxt.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int MaChiNhanh = BillDAO.getBill(MaHoaDon).getBranchCode();
            if (WarehouseDAO.getProductAmount(MaChiNhanh, sanPham.get(0).getProductCode())
                    >= Integer.parseInt(soLuongtxt.getText())) {
                if (!BillDAO.checkProductAlreadyInBill(MaHoaDon, sanPham.get(0).getProductCode())) {
                    if (BillDAO.addProductToBill(sanPham.get(0), MaHoaDon, Integer.parseInt(soLuongtxt.getText()))) {
                        WarehouseDAO.delProductAmount(MaChiNhanh, sanPham.get(0).getProductCode(), Integer.parseInt(soLuongtxt.getText()));
                        soLuong = 0;
                        soLuongtxt.setText(Integer.toString(soLuong));
                        showListSanPham();
                        txtTim.setText("Tìm sản phẩm");
                    }
                } else {
                    if (BillDAO.addProductAmount(sanPham.get(0), MaHoaDon, Integer.parseInt(soLuongtxt.getText()))) {
                        WarehouseDAO.delProductAmount(MaChiNhanh, sanPham.get(0).getProductCode(), Integer.parseInt(soLuongtxt.getText()));
                        soLuong = 0;
                        soLuongtxt.setText(Integer.toString(soLuong));
                        showListSanPham();
                        txtTim.setText("Tìm sản phẩm");
                    }
                }
            }else{
                String ThongBao = "Trong kho đã hết hàng! Hiện trong kho có " + WarehouseDAO.getProductAmount(MaChiNhanh, sanPham.get(0).getProductCode()) + " tồn kho!"; 
                JOptionPane.showMessageDialog(this, ThongBao, 
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            HienThiTongTienSanPham();
            showList();
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void lbnCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbnCongMouseClicked
        // TODO add your handling code here:
        soLuongtxt.setText(Integer.toString(soLuong++));
    }//GEN-LAST:event_lbnCongMouseClicked

    private void lbnTruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbnTruMouseClicked
        // TODO add your handling code here:
        soLuongtxt.setText(Integer.toString(soLuong--));
    }//GEN-LAST:event_lbnTruMouseClicked

    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        // TODO add your handling code here:
        if (txtTim.getText().equals("Tìm kiếm món")) {
            txtTim.setText("");
        }
    }//GEN-LAST:event_txtTimMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        int click = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán!", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == 0) {
            hoaDon = BillDAO.getBill(MaHoaDon);
            if (BillDAO.checkOut(MaHoaDon)) {
                hienThiGioVaoRa();
                HienThiTongTienPhong();
                HienThiTongTienTongCong();
                HienThiVAT();
                HienThiTienGiam();
                HienThiThanhToan();
                btnAdd.setEnabled(false);
                btnXoa.setEnabled(false);
                btnThanhToan.hide();
                ep.checkOut(MaPhong);
            }
        }

    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        BillDAO.deleteProductInBill(MaHoaDon, getMaSanPhamSelected());
        int row = TbSanPham.getSelectedRow();
        ProductInBill msp = sp.get(row);
        int MaChiNhanh = BillDAO.getBill(MaHoaDon).getBranchCode();
        WarehouseDAO.addProduct(MaChiNhanh, msp.getProductCode(), msp.getAmount());
        showList();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void TbSanPhamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TbSanPhamFocusLost
        // TODO add your handling code here:
        int x = TbSanPham.getSelectedColumn();
        int y = TbSanPham.getSelectedRow();
        System.out.println(TbSanPham.getValueAt(x, y));
    }//GEN-LAST:event_TbSanPhamFocusLost

    private void TbSanPhamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TbSanPhamFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_TbSanPhamFocusGained

    private void TbSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbSanPhamKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("ngu");
        }
    }//GEN-LAST:event_TbSanPhamKeyPressed

    private void TbSanPhamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbSanPhamKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("ngu");
        }
    }//GEN-LAST:event_TbSanPhamKeyTyped

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (txtTim.getText() != "") {
            ListModel = new DefaultListModel();
            List<Product> list = ProductDAO.findProductInBranch(txtTim.getText(), branchCode);
            System.out.println(txtTim.getText());
            for (Product a : list) {
                ListModel.addElement(a);
                System.out.println(a.toString());
            }
            ListSP.setModel(ListModel);
        } else {
            showList();
        }
    }//GEN-LAST:event_txtTimKeyPressed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOKMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Product> ListSP;
    private javax.swing.JTable TbSanPham;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbnCong;
    private javax.swing.JLabel lbnTru;
    private javax.swing.JLabel sadsa;
    private javax.swing.JTextField soLuongtxt;
    private javax.swing.JLabel txtBillCode;
    private javax.swing.JLabel txtCustomerName;
    private javax.swing.JLabel txtGiamGia;
    private javax.swing.JLabel txtGioRa;
    private javax.swing.JLabel txtGioRa1;
    private javax.swing.JLabel txtPhong;
    private javax.swing.JLabel txtRa;
    private javax.swing.JLabel txtSoGio;
    private javax.swing.JLabel txtThue;
    private javax.swing.JTextField txtTim;
    private javax.swing.JLabel txtTongCong;
    private javax.swing.JLabel txtTongThanhToan;
    private javax.swing.JLabel txtTongTienPhong;
    private javax.swing.JLabel txtTongTienSanPham;
    private javax.swing.JLabel txtVao;
    // End of variables declaration//GEN-END:variables

    private void showList() {
        sp = BillDAO.listProductsInBill(MaHoaDon);
        model.setRowCount(0);
        for (ProductInBill sv : sp) {
            model.addRow(new Object[]{sv.getProductName(), sv.getAmount(), sv.getPrice(), sv.getTotalPrice()});
        }
        model.setRowCount(sp.size() + 13);
    }

    private int getMaSanPhamSelected() {
        int row = TbSanPham.getSelectedRow();
        int msp = sp.get(row).getProductCode();
        //a();
        return msp;
    }

    private void a() {
        int x = TbSanPham.getSelectedColumn();
        int y = TbSanPham.getSelectedRow();
        System.out.println(x);
        System.out.println(y);
    }
}
