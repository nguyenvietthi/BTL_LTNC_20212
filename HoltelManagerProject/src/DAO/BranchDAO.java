/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Branch;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIETTHI_PC
 */
public class BranchDAO{

    public static Branch getBranch(int branchCode) {
        Branch cn = null;
        Connection conn = DBConnection.createConnection();
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.branch WHERE branch.BranchCode = ?;";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                cn = new Branch(rs.getInt("BranchCode"), rs.getString("BranchName"),
                        rs.getString("Address"), rs.getInt("PhoneNumber"), rs.getString("Email"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cn;
    }

    public static List<Branch> getListBranch() {
        List<Branch> cn = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.branch";
        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Branch tmp = new Branch(rs.getInt("BranchCode"), rs.getString("BranchName"),
                        rs.getString("Address"), rs.getInt("PhoneNumber"), rs.getString("Email"));
                cn.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cn;
    }
}
