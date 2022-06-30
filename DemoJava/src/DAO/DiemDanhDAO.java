/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.NhanVien;
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
public class DiemDanhDAO {
    
      public static boolean DiemDanh(NhanVien nv) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.chamcong(MaChiNhanh, MaNhanVien, NgayGio) VALUES(?,?,localtime())";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, nv.getBranchCode());
            ps.setInt(2, nv.getEmployeeNumber());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
      
      public static boolean Check(int EmployeeNumber) {
        boolean check = false;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT CASE WHEN timediff(localtime(), NgayGio) > '24:00:00' THEN 0 ELSE 1 "
                + "END AS CheckDiemDanh FROM qlks.chamcong WHERE chamcong.MaNhanVien = ? ORDER BY NgayGio DESC LIMIT 1;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setInt(1, EmployeeNumber);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                check = rs.getBoolean("CheckDiemDanh");
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiemDanhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }
}
