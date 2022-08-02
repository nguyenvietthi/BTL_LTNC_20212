/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.WarehouseReceipt;
import Bean.Employee;
import Bean.Product;
import Bean.ProductInWarehouseReceipt;
import DAO.WarehouseDAO;
import DAO.EmployeeDAO;
import DAO.ProductDAO;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIETTHI_PC
 */
public class ImportWarehouseView extends javax.swing.JFrame {

    /**
     * Creates new form ImportWarehouseView
     */
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private Employee employee;
    private List<ProductInWarehouseReceipt> productInWarehouseReceiptList;
    private WarehouseView kho;

    public ImportWarehouseView() {
        employee = EmployeeDAO.getEmployee(5);
        initComponents();
        setUI();
        showList();
    }

    public ImportWarehouseView(Employee employee, WarehouseView kho) {
        this.employee = employee;
        this.kho = kho;
        initComponents();
        setUI();
        showList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCongTyGiao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNhanVienGiao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSanPham = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbNhapKho = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhập kho");
        setLocation(new java.awt.Point(450, 215));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1010, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCongTyGiao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCongTyGiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCongTyGiaoActionPerformed(evt);
            }
        });
        txtCongTyGiao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCongTyGiaoKeyPressed(evt);
            }
        });
        jPanel1.add(txtCongTyGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 240, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Công ty giao");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        txtNhanVienGiao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNhanVienGiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienGiaoActionPerformed(evt);
            }
        });
        txtNhanVienGiao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNhanVienGiaoKeyPressed(evt);
            }
        });
        jPanel1.add(txtNhanVienGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 240, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Nhân viên giao");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        btnThemSP.setBackground(new java.awt.Color(46, 204, 113));
        btnThemSP.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.setBorder(null);
        btnThemSP.setBorderPainted(false);
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        jPanel1.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 130, 30));

        btnOK.setBackground(new java.awt.Color(46, 204, 113));
        btnOK.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnOK.setText("XONG");
        btnOK.setBorder(null);
        btnOK.setBorderPainted(false);
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 120, 40));

        btnXoa.setBackground(new java.awt.Color(46, 204, 113));
        btnXoa.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnXoa.setText("Nhập");
        btnXoa.setBorder(null);
        btnXoa.setBorderPainted(false);
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_24px.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.setText("Tìm kiếm sản phẩm");
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
        jPanel3.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 300, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 40));

        TbSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ));
        TbSanPham.setRowHeight(30);
        jScrollPane1.setViewportView(TbSanPham);
        if (TbSanPham.getColumnModel().getColumnCount() > 0) {
            TbSanPham.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 340, 460));

        TbNhapKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TbNhapKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá"
            }
        ));
        TbNhapKho.setRowHeight(30);
        jScrollPane2.setViewportView(TbNhapKho);
        if (TbNhapKho.getColumnModel().getColumnCount() > 0) {
            TbNhapKho.getColumnModel().getColumn(1).setResizable(false);
            TbNhapKho.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 490, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -50, 1000, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showList() {
        List<Product> list = ProductDAO.getListProduct();
        model1.setRowCount(0);
        for (Product a : list) {
            model1.addRow(new Object[]{a.getProductCode(), a.getName()});
        }
        model1.setRowCount(list.size() + 15);
    }

    private void showProductInWarehouseReceiptList() {
        model2.setRowCount(0);
        for (ProductInWarehouseReceipt a : productInWarehouseReceiptList) {
            model2.addRow(new Object[]{a.getProductCode(),
                ProductDAO.getProduct(a.getProductCode()).getName(),
                a.getAmount(),
                a.getPrice()});
        }
        model2.setRowCount(productInWarehouseReceiptList.size() + 15);
    }

    private void setUI() {
        productInWarehouseReceiptList = new ArrayList<>();
        model1 = (DefaultTableModel) TbSanPham.getModel();
        model2 = (DefaultTableModel) TbNhapKho.getModel();
        TbSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) TbSanPham.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        //   jTable1.getTableHeader().setOpaque(false);
        TbSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TbSanPham.getColumnModel().getColumn(0).setPreferredWidth(120);
        TbSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
        ////
        TbNhapKho.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) TbNhapKho.getTableHeader().getDefaultRenderer();
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        //   jTable1.getTableHeader().setOpaque(false);
        TbNhapKho.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TbNhapKho.getColumnModel().getColumn(0).setPreferredWidth(120);
        TbNhapKho.getColumnModel().getColumn(1).setPreferredWidth(150);
        TbNhapKho.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbNhapKho.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    private void txtCongTyGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCongTyGiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCongTyGiaoActionPerformed

    private void txtCongTyGiaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCongTyGiaoKeyPressed
        // TODO add your handling code here:
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kh = KhachHangDAO.getKhachHang(txtSoDienThoai.getText());
            System.out.println(kh);
            if (kh != null) {
                txtHoTen.setText(kh.getHoVaTen());
                txtCMT.setText(kh.getSoCMT());
                txtEmail.setText(kh.getEmail());
                txtaDiaChi.setText(kh.getDiaChi());
            }
        }*/
    }//GEN-LAST:event_txtCongTyGiaoKeyPressed

    private void txtNhanVienGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienGiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienGiaoActionPerformed

    private void txtNhanVienGiaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNhanVienGiaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienGiaoKeyPressed

    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        // TODO add your handling code here:
        if (txtTim.getText().equals("Tìm kiếm sản phẩm")) {
            txtTim.setText("");
        }
    }//GEN-LAST:event_txtTimMouseClicked

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (!"".equals(txtTim.getText())) {
            List<Product> list = ProductDAO.findProduct(txtTim.getText());
            model1.setRowCount(0);
            for (Product a : list) {
                model1.addRow(new Object[]{
                    a.getProductCode(), a.getName()
                });
                System.out.println(a.toString());
            }
            model1.setRowCount(15);
        } else {
            showList();
        }
    }//GEN-LAST:event_txtTimKeyPressed

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        int x = TbSanPham.getSelectedRow();
        try {
            int MaSanPham = (int) TbSanPham.getValueAt(x, 0);
            new AddProductView(this, MaSanPham).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm trước khi nhập", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        // TODO add your handling code here:
        Date now = new Date();
        try {
            WarehouseReceipt hd = new WarehouseReceipt(0, employee.getBranchCode(), employee.getEmployeeCode(), now, txtCongTyGiao.getText(), txtNhanVienGiao.getText());
            System.out.println(hd);
            if (WarehouseDAO.addWarehouseReceipt(hd)) {
                int MHD = WarehouseDAO.getLatestBillCode();
                System.out.println(MHD);
                boolean check = false;
                for (ProductInWarehouseReceipt a : productInWarehouseReceiptList) {
                    if (WarehouseDAO.addProductInWarehouseReceipt(a, MHD)) {
                        check = true;
                        if (WarehouseDAO.checkAvailableProduct(employee.getBranchCode(), a.getProductCode()) == 1) {
                            WarehouseDAO.addProduct(employee.getBranchCode(), a.getProductCode(), a.getAmount());
                        } else {
                            WarehouseDAO.addNotAvailableProductToWarehouseReceipt(employee.getBranchCode(), a.getProductCode(), a.getAmount());
                        }
                    }
                }
                if (check) {
                    JOptionPane.showMessageDialog(this, "Đã nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                productInWarehouseReceiptList = new ArrayList<>();
                txtCongTyGiao.setText("");
                txtNhanVienGiao.setText("");
                showProductInWarehouseReceiptList();
                if (kho != null) {
                    kho.showList();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnOKMouseClicked

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked
        // TODO add your handling code here:
        new AddNewProduct(this).setVisible(true);


    }//GEN-LAST:event_btnThemSPMouseClicked
    public void setProductInWarehouseReceiptList(ProductInWarehouseReceipt spnk) {
        productInWarehouseReceiptList.add(spnk);
        showProductInWarehouseReceiptList();
    }

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
            java.util.logging.Logger.getLogger(ImportWarehouseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportWarehouseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportWarehouseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportWarehouseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportWarehouseView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbNhapKho;
    private javax.swing.JTable TbSanPham;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCongTyGiao;
    private javax.swing.JTextField txtNhanVienGiao;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
