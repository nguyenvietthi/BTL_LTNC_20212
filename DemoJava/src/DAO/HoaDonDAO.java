/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ProductInBill;
import Bean.Discount;
import Bean.Bill;
import Bean.Employee;
import Bean.Product;
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
public class HoaDonDAO {

    public static boolean themHoaDon(Employee nv, int MaPhong, int MaKhachHang, double VAT) {
        int GiaThue = PhongKhachSanDAO.getGiaThue(nv.getBranchCode(), MaPhong);
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.hoadon(MaPhong, GioVao, GiaThue, ThueVAT, MaNhanVien, "
                + "MaKhachHang, MaChiNhanh) VALUES(?,localtime(), ?, ?, ?, ?, ?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, MaPhong);
            ps.setInt(2, GiaThue);
            ps.setDouble(3, VAT);
            ps.setInt(4, nv.getEmployeeCode());
            ps.setInt(5, MaKhachHang);
            ps.setInt(6, nv.getBranchCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static Bill getHoaDon(int MaPhong, int MaChiNhanh) {
        Bill hd = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.hoadon WHERE MaChiNhanh = ? AND MaPhong = ? ORDER BY MaHoaDon DESC LIMIT 1;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.setInt(2, MaPhong);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                hd = new Bill(rs.getInt("MaHoaDon"), rs.getInt("MaPhong"), rs.getTimestamp("GioVao"),
                        rs.getTimestamp("GioRa"), rs.getInt("GiaThue"), rs.getFloat("ThueVAT"),
                        rs.getInt("MaNhanVien"), rs.getInt("MaKhachHang"), rs.getInt("MaChiNhanh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hd;
    }

    public static Bill getHoaDon(int MaHoaDon) {
        Bill hd = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.hoadon WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                hd = new Bill(rs.getInt("MaHoaDon"), rs.getInt("MaPhong"), rs.getTimestamp("GioVao"),
                        rs.getTimestamp("GioRa"), rs.getInt("GiaThue"), rs.getFloat("ThueVAT"),
                        rs.getInt("MaNhanVien"), rs.getInt("MaKhachHang"), rs.getInt("MaChiNhanh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hd;
    }

    public static int TongTienSanPham(int MaHoaDon) {
        int Tong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT SUM(SoLuong * GiaSanPham) AS TongTienSanPham FROM qlks.chitiethoadon WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = rs.getInt("TongTienSanPham");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Tong;
    }

    public static int TongTienPhong(int MaHoaDon) {
        int Tong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT (hour(timediff(GioRa, GioVao)) +  minute(timediff(GioRa, GioVao))/60) "
                + "* GiaThue AS TongTienPhong FROM qlks.hoadon WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = rs.getInt("TongTienPhong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Tong;
    }

    public static int TienGiam(int MaHoaDon) {
        double Tong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT SoPhanTram  FROM giamgia "
                + "WHERE giamgia.MaGiamGia = (SELECT MaGiamGia FROM chitietgiamgia "
                + "	WHERE chitietgiamgia.MaLoaiKhach = (SELECT LoaiKhach FROM khachhang "
                + "		WHERE khachhang.MaKhachHang = ("
                + "			SELECT MaKhachHang FROM hoadon WHERE hoadon.MaHoaDon = ?"
                + "			))) AND TinhTrang = 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = rs.getDouble("SoPhanTram") * (TongCong(MaHoaDon) - TienVAT(MaHoaDon));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (int) Tong;
    }

    public static int TongThanhToan(int MaHoaDon) {
        int Tong = TongCong(MaHoaDon) + TienVAT(MaHoaDon) - TienGiam(MaHoaDon);
        return Tong;
    }

    public static Discount giamGia(int MaHoaDon) {
        Discount Tong = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT MaGiamGia,SoPhanTram  FROM giamgia "
                + "WHERE giamgia.MaGiamGia = (SELECT MaGiamGia FROM chitietgiamgia "
                + "	WHERE chitietgiamgia.MaLoaiKhach = (SELECT LoaiKhach FROM khachhang "
                + "		WHERE khachhang.MaKhachHang = ("
                + "			SELECT MaKhachHang FROM hoadon WHERE hoadon.MaHoaDon = ?"
                + "			))) AND TinhTrang = 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = new Discount(rs.getString("MaGiamGia"), rs.getDouble("SoPhanTram"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Tong;
    }

    public static int TongCong(int MaHoaDon) {
        int Tong = TongTienSanPham(MaHoaDon) + TongTienPhong(MaHoaDon);
        return Tong;
    }

    public static double SoGio(int MaHoaDon) {
        double Tong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT (hour(timediff(GioRa, GioVao)) +  minute(timediff(GioRa, GioVao))/60) "
                + " AS SoGio FROM qlks.hoadon WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = rs.getDouble("SoGio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Tong;
    }

    public static int TienVAT(int MaHoaDon) {
        double Tong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT ThueVAT FROM qlks.hoadon WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Tong = rs.getDouble("ThueVAT") * TongCong(MaHoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (int) Tong;
    }

    public static boolean kiemTraSanPhamDaCoTrongHoaDon(int MaHoaDon, int MaSanPham) {
        boolean check = false;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS kiemTra FROM qlks.chitiethoadon WHERE MaHoaDon = ? AND MaSanPham = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.setInt(2, MaSanPham);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("kiemTra") == 1) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }

    public static boolean themSanPhamVaoHoaDon(Product sp, int MaHoaDon, int SoLuong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "INSERT INTO qlks.chitiethoadon VALUES(?, ?, ?, ?)";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, sp.getProductCode());
            ps.setInt(2, MaHoaDon);
            ps.setInt(3, SoLuong);
            ps.setInt(4, sp.getPrice());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean CapNhatGioRa(int MaHoaDon) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.hoadon SET GioRa = localtime() WHERE MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean themSoLuongSanPham(Product sp, int MaHoaDon, int SoLuong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.chitiethoadon SET SoLuong = SoLuong + ? WHERE MaSanPham =? AND MaHoaDon = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, SoLuong);
            ps.setInt(2, sp.getProductCode());
            ps.setInt(3, MaHoaDon);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static List<ProductInBill> listProductsInBill(int billCode) {
        List<ProductInBill> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT sanpham.MaSanPham, sanpham.Ten, chitiethoadon.SoLuong, chitiethoadon.GiaSanPham,"
                + " chitiethoadon.SoLuong * chitiethoadon.GiaSanPham AS TongTien FROM "
                + "qlks.chitiethoadon INNER JOIN qlks.sanpham ON chitiethoadon.MaSanPham = "
                + "sanpham.MaSanPham WHERE chitiethoadon.MaHoaDon = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductInBill tmp = new ProductInBill(rs.getInt("MaSanPham"),
                        rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("GiaSanPham"), rs.getInt("TongTien"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean XoaSanPhamTrongHoaDon(int MaHoaDon, int MaSanPham) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "DELETE FROM qlks.chitiethoadon WHERE MaHoaDon = ? AND MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaHoaDon);
            ps.setInt(2, MaSanPham);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
