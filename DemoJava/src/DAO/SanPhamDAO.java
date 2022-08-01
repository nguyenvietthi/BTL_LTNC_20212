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
public class SanPhamDAO {
    public static List<Product> getList() {
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
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
     public static List<Product> timGanDung(String keyWord) {
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
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
     public static Product getSanPham(int MaSanPham) {
        Product sp = null;
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.sanpham WHERE MaSanPham = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setInt(1, MaSanPham);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                sp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
         
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sp;
    }
}
