/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Account;
import DB.DBConnection;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIETTHI_PC
 */
public class AccountDAO{
    public static Account findAccount(String UserName) {
        Account acc = new Account();
        Connection conn = (Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.account WHERE UserName = ?";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, UserName);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getInt("EmployeeCode"), rs.getString("UserName"), rs.getString("PassWord"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return acc;
    }
    public static Account findAccount(int EmployeeCode) {
        Account acc = new Account();
        Connection conn = (Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.account WHERE EmployeeCode = ?";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, EmployeeCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getInt("EmployeeCode"), rs.getString("UserName"), rs.getString("PassWord"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return acc;
    }
    public static String getPosition(String UserName) {
        String Position = null;
        Connection conn = (Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT employee.PositionNumBer FROM qlks.employee INNER JOIN qlks.account ON employee.EmployeeCode = account.EmployeeCode WHERE account.UserName = ?;";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, UserName);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Position = rs.getString("PositionNumBer");
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Position;
    }
    public static int getEmployeeNumBer(String UserName) {
        int EN = -1;
        Connection conn = (Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT employee.EmployeeCode FROM qlks.employee INNER JOIN qlks.account ON employee.EmployeeCode = account.EmployeeCode WHERE account.UserName = ?;";
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, UserName);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                EN = rs.getInt("EmployeeCode");
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(ps != null) try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("finally");
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return EN;
    }
    public static boolean changePass(int employeeCode, String Pass) {
        java.sql.Connection conn = DBConnection.createConnection();
        com.mysql.jdbc.PreparedStatement ps = null;
        String SQL = "UPDATE qlks.account SET PassWord = ? WHERE EmployeeCode = ?";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, Pass);
            ps.setInt(2, employeeCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
     public static boolean addUserName(String userName, int branchCode) {
        java.sql.Connection conn = DBConnection.createConnection();
        com.mysql.jdbc.PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.account(EmployeeCode, UserName) VALUES(?,?)";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, branchCode);
            ps.setString(2, userName);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
     public static boolean delAccount(int branchCode) {
        java.sql.Connection conn = DBConnection.createConnection();
        com.mysql.jdbc.PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM qlks.account WHERE EmployeeCode = ?";
            ps = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, branchCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
