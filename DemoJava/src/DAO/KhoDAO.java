/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.HoaDonNhapKho;
import Bean.Product;
import Bean.SanPhamNhapKho;
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
public class KhoDAO {
    
    public static List<Product> listProductInBranch(int branchCode) {
        List<Product> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.sanpham INNER JOIN qlks.chitietkho ON "
                + "chitietkho.MaSanPham = sanpham.MaSanPham WHERE chitietkho.MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Product tmp = new Product(rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("Gia"), rs.getString("MoTa"));
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
    public static List<Object> listProduct(int MaChiNhanh) {
        List<Object> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT chitietkho.MaChiNhanh, chitietkho.MaSanPham, chitietkho.SoLuong, sanpham.Ten,"
                + " sanpham.Gia, sanpham.MoTa FROM qlks.chitietkho INNER JOIN"
                + " qlks.sanpham ON chitietkho.MaSanPham = sanpham.MaSanPham WHERE chitietkho.MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("Gia"), rs.getString("MoTa")
                };
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

    public static List<HoaDonNhapKho> ListHDNhapKho() {
        List<HoaDonNhapKho> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.nhapkho";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhapKho tmp = new HoaDonNhapKho(
                        rs.getInt("MaHoaDon"), rs.getInt("MaChiNhanh"),
                        rs.getInt("MaNhanVien"), rs.getDate("NgayGio"), rs.getString("CongTyGiao"),
                        rs.getString("TenNhanVienGiao")
                );
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean themHoaDonNhap(HoaDonNhapKho hd) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.nhapkho(MaChiNhanh,MaNhanVien, NgayGio, CongTyGiao, "
                + "TenNhanVienGiao) VALUES(?,?,localtime(),?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, hd.getMaChiNhanh());
            ps.setInt(2, hd.getMaNhanVien());
            ps.setString(3, hd.getCongTyGiao());
            ps.setString(4, hd.getTenNhanVienGiao());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean themSanPhamVaoKhoKhiChuaCo(int MaChiNhanh, int MaSanPham, int SoLuong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.chitietkho(MaChiNhanh, MaSanPham, SoLuong)  VALUES(?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);

            ps.setInt(1, MaChiNhanh);

            ps.setInt(2, MaSanPham);
            ps.setInt(3, SoLuong);

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int KiemTraSanPhamDaCo(int MaChiNhanh, int MaSanPham) {
        int check = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS ch FROM qlks.chitietkho WHERE MaChiNhanh =? AND MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.setInt(2, MaSanPham);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                check = rs.getInt("ch");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }

     public static int SoLuongSanPhamTrongKho(int MaChiNhanh, int MaSanPham) {
        int soLuong = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT SoLuong FROM qlks.chitietkho WHERE MaChiNhanh =? AND MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, MaChiNhanh);
            ps.setInt(2, MaSanPham);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return soLuong;
    }
    public static boolean themSanPhamVaoKho(int MaChiNhanh, int MaSanPham, int SoLuong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE qlks.chitietkho SET SoLuong = SoLuong + ? WHERE MaSanPham =? AND MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, SoLuong);
            ps.setInt(2, MaSanPham);
            ps.setInt(3, MaChiNhanh);

            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

     public static boolean TruSanPhamTrongKho(int MaChiNhanh, int MaSanPham, int SoLuong) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE qlks.chitietkho SET SoLuong = SoLuong - ? WHERE MaSanPham =? AND MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, SoLuong);
            ps.setInt(2, MaSanPham);
            ps.setInt(3, MaChiNhanh);

            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
     
    public static boolean themSanPhamHoaDonNhap(SanPhamNhapKho spnk, int MaHoaDon) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.chitietnhapkho(MaHoaDon,MaSanPham, SoLuong, GiaSanPham) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, MaHoaDon);
            ps.setInt(2, spnk.getMaSanPham());
            ps.setInt(3, spnk.getSoLuong());
            ps.setInt(4, spnk.getGia());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int MaHoaDonMoiThem() {
        int MHD = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT MaHoaDon FROM qlks.nhapkho ORDER BY MaHoaDon DESC LIMIT 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                MHD = rs.getInt("MaHoaDon");

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return MHD;
    }

    public static List<Object> TimGanDung(int MaChiNhanh, String str) {
        List<Object> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT chitietkho.MaChiNhanh, chitietkho.MaSanPham, chitietkho.SoLuong, sanpham.Ten,"
                + " sanpham.Gia, sanpham.MoTa FROM qlks.chitietkho INNER JOIN"
                + " qlks.sanpham ON chitietkho.MaSanPham = "
                + "sanpham.MaSanPham WHERE sanpham.Ten LIKE CONCAT('%', ?, '%') AND chitietkho.MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, str);
            ps.setInt(2, MaChiNhanh);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("Gia"), rs.getString("MoTa")
                };
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    public static boolean ThemSapPham(Product sp) {

        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.sanpham(Ten, Gia, MoTa) VALUES(?, ?, ?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, sp.getName());
            ps.setInt(2, sp.getPrice());
            
        
            ps.setString(3, sp.getDescription());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public static boolean DieuChinhGia(int MaSanPham, int Gia) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String SQL = "UPDATE qlks.sanpham SET gia = ? WHERE MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(2, MaSanPham);
            ps.setInt(1, Gia);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
