/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ChiNhanh;
import DB.DBConnection;
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
public class ChiNhanhDAO {

    public static ChiNhanh getChiNhanh(int maChiNhanh) {
        ChiNhanh cn = null;
        com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.chinhanh WHERE chinhanh.BranchCode = ?;";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, maChiNhanh);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                cn = new ChiNhanh(rs.getInt("BranchCode"), rs.getString("BranchName"),
                        rs.getString("Address"), rs.getInt("PhoneNumber"), rs.getString("Email"));;
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cn;
    }

    public static List<ChiNhanh> getChiNhanh() {
        List<ChiNhanh> cn = new ArrayList<ChiNhanh>();
        com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.chinhanh";
        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiNhanh tmp = new ChiNhanh(rs.getInt("BranchCode"), rs.getString("BranchName"),
                        rs.getString("Address"), rs.getInt("PhoneNumber"), rs.getString("Email"));;
                cn.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cn;
    }

    public static List<ChiNhanh> getList() {
        List<ChiNhanh> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnection.createConnection();
        try {
            String SQL = "SELECT * FROM qlks.chinhanh;";
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                ChiNhanh cn = new ChiNhanh(rs.getInt("BranchCode"), rs.getString("BranchName"),
                        rs.getString("Address"), rs.getInt("PhoneNumber"), rs.getString("Email"));
                list.add(cn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
}
