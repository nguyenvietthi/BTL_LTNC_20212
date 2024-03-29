/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.Employee;
import DAO.AccountDAO;
import DAO.BranchDAO;
import DAO.EmployeeDAO;
import java.awt.Font;
import java.awt.event.KeyEvent;
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
public class EmployeeManagerView extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeManagerView
     */
    private List<Employee> employee;
    private DefaultTableModel model;

    public EmployeeManagerView() {
        initComponents();
        setUI();
        showList();
    }

    private void setUI() {
        model = (DefaultTableModel) tblNhanVien.getModel();
        tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        //   jTable1.getTableHeader().setOpaque(false);
        tblNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(58);
        tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(160);
        tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(130);
        tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(130);
        tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(130);
        tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(150);
        tblNhanVien.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblNhanVien.getColumnModel().getColumn(8).setPreferredWidth(250);
        tblNhanVien.getColumnModel().getColumn(9).setPreferredWidth(400);
        tblNhanVien.getColumnModel().getColumn(10).setPreferredWidth(90);

    }

    private String status(boolean bl) {
        if (bl) {
            return "Đang làm";
        } else {
            return "Nghỉ";
        }
    }

    private String sex(boolean bl) {
        if (bl) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public void showList() {
        employee = EmployeeDAO.getListEmployee();
        model.setRowCount(0);
        for (Employee a : employee) {
            model.addRow(new Object[]{a.getEmployeeCode(), a.getFullName(), a.getDateOfBirth(), a.getPhoneNumber(), a.getCMTNumber(), EmployeeDAO.getPosition(a.getPositionCode()).getName(),
                BranchDAO.getBranch(a.getBranchCode()).getBranchCode(), status(a.isStatus()), a.getEmail(),
                a.getAddress(), sex(a.isSex())});
        }
        model.setRowCount(employee.size() + 13);
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
        btbThem = new javax.swing.JButton();
        txtChinhSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin nhân viên");
        setLocation(new java.awt.Point(100, 210));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btbThem.setBackground(new java.awt.Color(46, 204, 113));
        btbThem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btbThem.setText("Thêm");
        btbThem.setBorder(null);
        btbThem.setBorderPainted(false);
        btbThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbThemMouseClicked(evt);
            }
        });
        jPanel1.add(btbThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 450, 130, 40));

        txtChinhSua.setBackground(new java.awt.Color(46, 204, 113));
        txtChinhSua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtChinhSua.setText("Chỉnh sửa");
        txtChinhSua.setBorder(null);
        txtChinhSua.setBorderPainted(false);
        txtChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtChinhSuaMouseClicked(evt);
            }
        });
        jPanel1.add(txtChinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 450, 130, 40));

        tblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Nguyễn Việt Thi", null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ và tên", "Ngày sinh", "Số điện thoại", "Số CMT/CCCD", "Chức vụ", "Chi nhánh", "Trạng thái", "Email", "Địa chỉ", "Giới tính"
            }
        ));
        tblNhanVien.setRowHeight(35);
        jScrollPane1.setViewportView(tblNhanVien);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1720, 340));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_24px.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.setText("Tìm kiếm");
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimFocusLost(evt);
            }
        });
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 410, 40));

        btnXoa.setBackground(new java.awt.Color(46, 204, 113));
        btnXoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.setBorderPainted(false);
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 450, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        // TODO add your handling code here:
        if (txtTim.getText().equals("Tìm kiếm")) {
            txtTim.setText("");
        }
    }//GEN-LAST:event_txtTimMouseClicked

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (!"".equals(txtTim.getText())) {
            employee = EmployeeDAO.findEmployee(txtTim.getText());
            model.setRowCount(0);
            for (Employee a : employee) {
                model.addRow(new Object[]{a.getEmployeeCode(), a.getFullName(), a.getDateOfBirth(), a.getPhoneNumber(), a.getCMTNumber(), EmployeeDAO.getPosition(a.getPositionCode()).getName(),
                    BranchDAO.getBranch(a.getBranchCode()).getBranchName(), status(a.isStatus()), a.getEmail(),
                    a.getAddress(), sex(a.isSex())});
            }
            model.setRowCount(employee.size() + 13);
        } else {
            showList();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            txtTim.setText("Tìm kiếm");
            showList();
        }
    }//GEN-LAST:event_txtTimKeyPressed

    private void txtTimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusLost
   
    }//GEN-LAST:event_txtTimFocusLost

    private void txtChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChinhSuaMouseClicked
        // TODO add your handling code here:
        int y = tblNhanVien.getSelectedRow();
        new InfoView(this, employee.get(y), "GD").setVisible(true);
       // this.dispose();
    }//GEN-LAST:event_txtChinhSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        int y = tblNhanVien.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(this, "Xác nhận xóa!", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == 0) {
            if(EmployeeDAO.delEmployee(employee.get(y).getEmployeeCode()) && AccountDAO.delAccount(employee.get(y).getEmployeeCode())){
                employee = EmployeeDAO.getListEmployee();
                showList();
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btbThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbThemMouseClicked
        // TODO add your handling code here:
        new AddEmployeeView(this).setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_btbThemMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JButton txtChinhSua;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
