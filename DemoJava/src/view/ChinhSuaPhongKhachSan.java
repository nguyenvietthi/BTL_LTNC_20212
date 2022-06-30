/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.PhongKhachSan;
import DAO.ChiNhanhDAO;
import DAO.PhongKhachSanDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author VIETTHI_PC
 */
public class ChinhSuaPhongKhachSan extends javax.swing.JFrame {

    /**
     * Creates new form ThongTin
     */
    private PhongKhachSan pks;
    private QuanLyPhongKhachSan ql;

    public ChinhSuaPhongKhachSan(PhongKhachSan pks, QuanLyPhongKhachSan ql) {
        this.pks = pks;
        this.ql = ql;
        initComponents();
        setUI();


    }

    /*  public ThemNhanVien(NhanVien nv, String ChucVu) {
        this.nv = nv;
        this.ChucVu = ChucVu;
        initComponents();
        setInfo();
        setListChiNhanh();
    }
     */
    private void setUI() {
        txtChiNhanh.setText(ChiNhanhDAO.getChiNhanh(pks.getMaChiNhanh()).getTenChiNhanh());
        txtMaPhong.setText(String.valueOf(pks.getMaPhong()));
        txtChiNhanh.setEnabled(false);
        txtMaPhong.setEnabled(false);
        txtGiaThue.setText(String.valueOf(pks.getGiaThue()));
        txtMoTa.setText(pks.getMoTa());
        

    }

    /*private void setInfo() {
        nv = NhanVienDAO.getEmployee(nv.getEmployeeNumber());
        txtHoTen.setText(nv.getName());
       // txtChiNhanh.setText(ChiNhanhDAO.getChiNhanh(nv.getBranchCode()).getTenChiNhanh());
        txtMaNhanVien.setText(String.valueOf(nv.getEmployeeNumber()));

        dcNgaySinh.setDate(nv.getDateOfBirth());
        txtCMT.setText(String.valueOf(nv.getCMTNumber()));
        txtEmail.setText(nv.getEmail());
        txtSoDienThoai.setText(nv.getNumberPhone());
        txtaDiaChi.setText(nv.getAddress());
        if (nv.isSex()) {
            rdbGioiTinh_Nam.setSelected(true);
            rdbGioiTinh_Nu.setSelected(false);
        } else {
            rdbGioiTinh_Nam.setSelected(false);
            rdbGioiTinh_Nu.setSelected(true);
        }

        if (nv.isStatus()) {
            chkTrangThai.setSelected(true);
        } else {
            chkTrangThai.setSelected(false);
        }
        txtMaNhanVien.setEnabled(false);
        if (ChucVu.equals("NV")) {
            chkTrangThai.setEnabled(false);
            txtHoTen.setEnabled(false);
            cbbChiNhanh.setEnabled(false);
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLuu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtChiNhanh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtGiaThue = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chỉnh sửa");
        setLocation(new java.awt.Point(572, 334));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        txtLuu.setBackground(new java.awt.Color(46, 204, 113));
        txtLuu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtLuu.setText("Lưu");
        txtLuu.setBorder(null);
        txtLuu.setBorderPainted(false);
        txtLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLuuMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Phòng");

        txtMaPhong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        txtChiNhanh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChiNhanhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Chi nhánh");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        txtGiaThue.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtGiaThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaThueActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Giá thuê");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");
        jPanel2.getAccessibleContext().setAccessibleParent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLuuMouseClicked
        // TODO add your handling code here:
        pks.setGiaThue(Integer.parseInt(txtGiaThue.getText()));
        pks.setMoTa(txtMoTa.getText());
        if(PhongKhachSanDAO.ChinhSua(pks)){
            JOptionPane.showMessageDialog(this, "Đã lưu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            ql.showList();
        } else{
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        /*ChiNhanh CN = (ChiNhanh) cbbChiNhanh.getSelectedItem();
        ChucVu CV = (ChucVu) cbbChucVu.getSelectedItem();
        System.out.println(dcNgaySinh.getDate());
        nv = new NhanVien(0, txtChiNhanh.getText(),
                dcNgaySinh.getDate(), txtMoTa.getText(), txtSoDienThoai.getText(),
                txtCMT.getText(), CV.getMaChucVu(), txtEmail.getText(),
                rdbGioiTinh_Nam.isSelected(), chkTrangThai.isSelected(), CN.getMaChiNhanh());
        System.out.println(nv);
        if (NhanVienDAO.addNhanVien(nv)) {
            List<NhanVien> tmp = NhanVienDAO.getList();
            int size = tmp.size();
            nv.setEmployeeNumber(tmp.get(size - 1).getEmployeeNumber());
            if (AccountDAO.addUserName(txtMaPhong.getText(), nv.getEmployeeNumber())) {
                JOptionPane.showMessageDialog(this, "Đã thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                NhanVienDAO.delNhanVien(nv.getEmployeeNumber());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        qlnv.setEnabled(true);
        qlnv.showList();*/
    }//GEN-LAST:event_txtLuuMouseClicked

    private void txtChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChiNhanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChiNhanhActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ql.setVisible(true);
       ql.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void txtGiaThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaThueActionPerformed

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
            java.util.logging.Logger.getLogger(ChinhSuaPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChinhSuaPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChinhSuaPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChinhSuaPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new ThemNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtChiNhanh;
    private javax.swing.JTextField txtGiaThue;
    private javax.swing.JButton txtLuu;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextArea txtMoTa;
    // End of variables declaration//GEN-END:variables
}
