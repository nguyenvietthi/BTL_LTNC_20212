/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Customer;
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
public class CustomerDAO{
    public static boolean addCustomer(Customer kh) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.customer (FullName, PhoneNumber, CustomerType, CMTNumber, Address, Email) VALUES (?,?,?,?,?,?);";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, kh.getFullName());
            ps.setString(2, kh.getPhoneNumber());
            ps.setString(3, kh.getCustomerType());
            ps.setString(4, kh.getPhoneNumber());
            ps.setString(5, kh.getAddress());
            ps.setString(6, kh.getEmail());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public static Customer getCustomer(String phoneNumber) {
        Customer kh = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.customer WHERE PhoneNumber = ? ORDER BY CustomerCode DESC LIMIT 1;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, phoneNumber);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new Customer(rs.getInt("CustomerCode"), rs.getString("FullName"), 
                        rs.getString("PhoneNumber"), rs.getString("CustomerType"), rs.getString("CMTNumber"),
                        rs.getString("Address"),rs.getString("Email") );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kh;
    }
    public static Customer getCustomer(int billCode) {
        Customer kh = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.customer INNER JOIN qlks.bill ON bill.CustomerCode = customer.CustomerCode WHERE bill.BillCode = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new Customer(rs.getInt("CustomerCode"), rs.getString("FullName"), 
                        rs.getString("PhoneNumber"), rs.getString("CustomerType"), rs.getString("CMTNumber"),
                        rs.getString("Address"),rs.getString("Email") );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kh;
    }
    
}
