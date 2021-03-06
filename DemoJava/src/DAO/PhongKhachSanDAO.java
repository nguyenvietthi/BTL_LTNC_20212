/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.PhongKhachSan;
import DB.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.accessibility.internal.resources.accessibility;
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
public class PhongKhachSanDAO {

    /* public static List<PhongKhachSan> getListPhongKhachSan(int MaChiNhanh){
         List<PhongKhachSan> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBConnection.createConnection();
        try {
            String SQL = "SELECT * FROM qlks.phongkhachsan;";
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                PhongKhachSan tmp = new PhongKhachSan(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"), rs.getBoolean("TrangThai"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }*/
    public static List<PhongKhachSan> getListPhongKhachSan(int MaChiNhanh) {
        List<PhongKhachSan> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.phongkhachsan WHERE MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                PhongKhachSan tmp = new PhongKhachSan(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"),
                        rs.getBoolean("TrangThai"), rs.getInt("GiaThue"), rs.getString("MoTa"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static int getGiaThue(int MaChiNhanh, int MaPhong) {
        int giaThue = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT GiaThue FROM qlks.phongkhachsan WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.setInt(2, MaPhong);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                giaThue = rs.getInt("GiaThue");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return giaThue;
    }

    public static PhongKhachSan Phong(int MaChiNhanh, int MaPhong) {
        PhongKhachSan a = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.phongkhachsan WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.setInt(2, MaPhong);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new PhongKhachSan(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"),
                        rs.getBoolean("TrangThai"), rs.getInt("GiaThue"), rs.getString("MoTa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return a;
    }

    public static boolean ChinhSua(PhongKhachSan pks) {
        int giaThue = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.phongkhachsan SET GiaThue = ?, MoTa = ? WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, pks.getGiaThue());
            ps.setString(2, pks.getMoTa());
            ps.setInt(3, pks.getMaChiNhanh());
            ps.setInt(4, pks.getMaPhong());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean setPhong(PhongKhachSan phong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String SQL = "UPDATE qlks.phongkhachsan SET TrangThai = ? WHERE MaChiNhanh = ? AND MaPhong = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setBoolean(1, phong.isTrangThai());
            ps.setInt(2, phong.getMaChiNhanh());
            ps.setInt(3, phong.getMaPhong());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int SoPhongChiNhanh(int MaChiNhanh) {
        int soPhong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS 'SoPhong' FROM qlks.PhongKhachSan WHERE MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                soPhong = rs.getInt("SoPhong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return soPhong;
    }

    public static void main(String[] args) {
        System.out.println(SoPhongChiNhanh(1));
    }
}
