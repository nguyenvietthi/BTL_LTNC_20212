/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.HotelRoom;
import DB.DBConnection;
import com.mysql.jdbc.PreparedStatement;
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
public class HotelRoomDAO {

    /* public static List<HotelRoom> getListPhongKhachSan(int MaChiNhanh){
         List<HotelRoom> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBConnection.createConnection();
        try {
            String SQL = "SELECT * FROM qlks.phongkhachsan;";
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                HotelRoom tmp = new HotelRoom(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"), rs.getBoolean("TrangThai"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }*/
    public static List<HotelRoom> getListHotelRoom(int branchCode) {
        List<HotelRoom> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.phongkhachsan WHERE MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                HotelRoom tmp = new HotelRoom(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"),
                        rs.getBoolean("TrangThai"), rs.getInt("GiaThue"), rs.getString("MoTa"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static int getPrice(int branchCode, int roomCode) {
        int price = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT GiaThue FROM qlks.phongkhachsan WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, roomCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getInt("GiaThue");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return price;
    }

    public static HotelRoom getRoom(int branchCode, int roomCode) {
        HotelRoom a = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.phongkhachsan WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, roomCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new HotelRoom(rs.getInt("MaChiNhanh"), rs.getInt("MaPhong"),
                        rs.getBoolean("TrangThai"), rs.getInt("GiaThue"), rs.getString("MoTa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return a;
    }

    public static boolean editRoom(HotelRoom pks) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.phongkhachsan SET GiaThue = ?, MoTa = ? WHERE MaChiNhanh = ? AND MaPhong = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, pks.getPrice());
            ps.setString(2, pks.getDescription());
            ps.setInt(3, pks.getBranchCode());
            ps.setInt(4, pks.getRoomCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean setRoomStatus(HotelRoom phong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String SQL = "UPDATE qlks.phongkhachsan SET TrangThai = ? WHERE MaChiNhanh = ? AND MaPhong = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setBoolean(1, phong.isStatus());
            ps.setInt(2, phong.getBranchCode());
            ps.setInt(3, phong.getRoomCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int getRoomNumber(int branchCode) {
        int roomNumber = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS 'SoPhong' FROM qlks.phongkhachsan WHERE MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                roomNumber = rs.getInt("SoPhong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return roomNumber;
    }
}
