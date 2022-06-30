/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.KhachHang;
import DB.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIETTHI_PC
 */
public class KhachHangDAO {
    public static boolean themKhachHang(KhachHang kh) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.khachhang (HoVaTen, SoDienThoai, LoaiKhach, SoCMT, DiaChi, Email) VALUES (?,?,?,?,?,?);";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, kh.getHoVaTen());
            ps.setString(2, kh.getSoDienThoi());
            ps.setString(3, kh.getLoaiKhach());
            ps.setString(4, kh.getSoCMT());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public static KhachHang getKhachHang(String SDT) {
        KhachHang kh = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.khachhang WHERE SoDienThoai = ? ORDER BY MaKhachHang DESC LIMIT 1;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, SDT);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt("MaKhachHang"), rs.getString("HoVaTen"), 
                        rs.getString("SoDienThoai"), rs.getString("LoaiKhach"), rs.getString("SoCMT"),
                        rs.getString("DiaChi"),rs.getString("Email") );
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kh;
    }
}
