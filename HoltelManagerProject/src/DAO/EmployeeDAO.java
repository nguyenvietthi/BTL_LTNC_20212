/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Position;
import Bean.Employee;
import DB.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIETTHI_PC
 */
public class EmployeeDAO{

    public static List<Employee> getListEmployee() {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnection.createConnection();
        try {
            String SQL = "SELECT * FROM qlks.nhanvien;";
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                Employee tmp = new Employee(rs.getInt("EmployeeNumber"), rs.getString("Name"), rs.getDate("DateOfBirth"), rs.getString("Address"), rs.getString("NumberPhone"), rs.getString("CMTNumber"), rs.getString("PositionNumBer"), rs.getString("Email"), rs.getBoolean("Sex"), rs.getBoolean("Status"), rs.getInt("BranchCode"));
                list.add(tmp);
                System.out.println("ok");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean addEmpolyee(Employee nv) {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.nhanvien(Name, DateOfBirth, Address, NumberPhone, "
                + "CMTNumber, PositionNumBer, Email, Sex, Status, BranchCode) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, nv.getName());
            try {
                ps.setString(2, fm.format(nv.getDateOfBirth()));
            } catch (SQLException ex) {
                return false;
            }
            ps.setString(3, nv.getAddress());
            ps.setString(4, nv.getNumberPhone());
            ps.setString(5, nv.getCMTNumber());
            ps.setString(6, nv.getPositionNumBer());
            ps.setString(7, nv.getEmail());
            ps.setBoolean(8, nv.isSex());
            ps.setBoolean(9, nv.isStatus());
            ps.setInt(10, nv.getBranchCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static Employee getEmployee(int EmployeeNumber) {
        Employee nv = null;
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.nhanvien WHERE nhanvien.EmployeeNumber = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setInt(1, EmployeeNumber);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new Employee(rs.getInt("EmployeeNumber"), rs.getString("Name"), rs.getDate("DateOfBirth"),
                        rs.getString("Address"), rs.getString("NumberPhone"), rs.getString("CMTNumber"), rs.getString("PositionNumBer"),
                        rs.getString("Email"), rs.getBoolean("Sex"), rs.getBoolean("Status"), rs.getInt("BranchCode"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nv;
    }

    public static List<Employee> findEmployee(String keyWord) {
        List<Employee> list = new ArrayList<>();
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.nhanvien WHERE Name LIKE CONCAT('%', ?, '%');";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setString(1, keyWord);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee(rs.getInt("EmployeeNumber"), rs.getString("Name"),
                        rs.getDate("DateOfBirth"), rs.getString("Address"), rs.getString("NumberPhone"),
                        rs.getString("CMTNumber"), rs.getString("PositionNumBer"), rs.getString("Email"),
                        rs.getBoolean("Sex"), rs.getBoolean("Status"), rs.getInt("BranchCode"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static Position getPosition(String positionCode) {
        Position cv = null;
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.chucvu WHERE MaChucVu = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setString(1, positionCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                cv = new Position(rs.getString("MaChucVu"), rs.getString("MaChucVu"), rs.getInt("LuongCoBan"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cv;
    }

    public static List<Position> getListPosition() {
        List<Position> list = new ArrayList<>();
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.chucvu";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Position cv = new Position(rs.getString("MaChucVu"), rs.getString("ChucVu"), rs.getInt("LuongCoBan"));
                list.add(cv);
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean delEmployee(int employeeCode) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM qlks.nhanvien WHERE EmployeeNumber = ?";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, employeeCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean updateEmployee(Employee nv) {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String SQL = "UPDATE qlks.nhanvien SET DateOfBirth = ?, Address = ?, NumberPhone = ?, "
                + "CMTNumber = ?, PositionNumBer = ?, Email = ?, Sex = ?, Status = ?, BranchCode = ? WHERE EmployeeNumber = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, fm.format(nv.getDateOfBirth()));
            ps.setString(2, nv.getAddress());
            ps.setString(3, nv.getNumberPhone());
            ps.setString(4, nv.getCMTNumber());
            ps.setString(5, nv.getPositionNumBer());
            ps.setString(6, nv.getEmail());
            ps.setBoolean(7, nv.isSex());
            ps.setBoolean(8, nv.isStatus());
            ps.setInt(9, nv.getBranchCode());
            ps.setInt(10, nv.getEmployeeCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
