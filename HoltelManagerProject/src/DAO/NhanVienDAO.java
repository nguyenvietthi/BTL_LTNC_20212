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
public class NhanVienDAO {

    public static List<Employee> getList() {
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean addNhanVien(Employee nv) {
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nv;
    }

    public static List<Employee> timGanDung(String keyWord) {
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static Position getChucVu(String MaChucVu) {
        Position cv = null;
        Connection conn = (com.mysql.jdbc.Connection) DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.chucvu WHERE MaChucVu = ?;";
        try {
            ps = (PreparedStatement) conn.prepareStatement(SQL);
            ps.setString(1, MaChucVu);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                cv = new Position(rs.getString("MaChucVu"), rs.getString("MaChucVu"), rs.getInt("LuongCoBan"));
            }
        } catch (SQLException ex) {
            System.out.println("catch");
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cv;
    }

    public static List<Position> getListChucVu() {
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("finally");
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean delNhanVien(int MaNhanVien) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM qlks.nhanvien WHERE EmployeeNumber = ?";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, MaNhanVien);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean updateStudent(Employee nv) {
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
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    /*public static SinhVien getSinhVien(int MSSV) {
        SinhVien sv = new SinhVien();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM sinhvien WHERE MSSV = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MSSV);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                sv = new SinhVien(rs.getInt("MSSV"), rs.getString("Name"), rs.getInt("Age"), rs.getString("NameClass"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return sv;
    }*/
    
    public static void main(String[] args) throws ParseException {
        //if(addSinhVien(new SinhVien(20182798, "Nguyễn Việt Thi", 20, "Điện Tử 10"))) System.out.println("OK");
        List<Employee> list = getList();
        for (Employee tmp : list) {
            System.out.println(tmp.toString());
        }
        /* SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date da = fm.parse("20/03/1999");
        System.out.println(da);
        Employee nv = new Employee(9, "a", da , "a", 123, 456, "PGD", "adasda" );*/

        // System.out.println(addSinhVien(nv));
    }

}
