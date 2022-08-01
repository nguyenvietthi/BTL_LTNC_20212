/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Product;
import DB.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIETTHI_PC
 */
public class ProductDAO {
    public static List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnection.createConnection();
        try {
            String SQL = "SELECT * FROM qlks.sanpham;";
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                Product tmp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
     public static List<Product> findProduct(String keyWord) {
        List<Product> list = new ArrayList<>();
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.sanpham WHERE Ten LIKE CONCAT('%', ?, '%');";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setString(1, keyWord);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Product tmp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public static List<Product> findProductInBranch(String keyWord, int branchCode) {
        List<Product> list = new ArrayList<>();
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT chitietkho.MaChiNhanh, chitietkho.MaSanPham, chitietkho.SoLuong, sanpham.Ten,"
                + " sanpham.Gia, sanpham.MoTa FROM qlks.chitietkho INNER JOIN"
                + " qlks.sanpham ON chitietkho.MaSanPham = "
                + "sanpham.MaSanPham WHERE sanpham.Ten LIKE CONCAT('%', ?, '%') AND chitietkho.MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setString(1, keyWord);
            ps.setInt(2, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Product tmp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public static Product getProduct(int productCode) {
        Product sp = null;
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.sanpham WHERE MaSanPham = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setInt(1, productCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                sp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
         
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sp;
    }
}
