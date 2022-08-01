/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.WarehouseReceipt;
import Bean.Product;
import Bean.ProductInWarehouseReceipt;
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
public class WarehouseDAO{
    
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
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    public static List<Object> listProduct(int branchCode) {
        List<Object> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT chitietkho.MaChiNhanh, chitietkho.MaSanPham, chitietkho.SoLuong, sanpham.Ten,"
                + " sanpham.Gia, sanpham.MoTa FROM qlks.chitietkho INNER JOIN"
                + " qlks.sanpham ON chitietkho.MaSanPham = sanpham.MaSanPham WHERE chitietkho.MaChiNhanh = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("Gia"), rs.getString("MoTa")
                };
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static List<WarehouseReceipt> getListWarehouseReceipt() {
        List<WarehouseReceipt> list = new ArrayList<>();
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.nhapkho";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                WarehouseReceipt tmp = new WarehouseReceipt(
                        rs.getInt("MaHoaDon"), rs.getInt("MaChiNhanh"),
                        rs.getInt("MaNhanVien"), rs.getDate("NgayGio"), rs.getString("CongTyGiao"),
                        rs.getString("TenNhanVienGiao")
                );
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean addWarehouseReceipt(WarehouseReceipt hd) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.nhapkho(MaChiNhanh,MaNhanVien, NgayGio, CongTyGiao, "
                + "TenNhanVienGiao) VALUES(?,?,localtime(),?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, hd.getBranchCode());
            ps.setInt(2, hd.getEmployeeCode());
            ps.setString(3, hd.getDeliveryCompany());
            ps.setString(4, hd.getDeliveryEmployee());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean addNotAvailableProductToWarehouseReceipt(int branchCode, int productCode, int amount) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.chitietkho(MaChiNhanh, MaSanPham, SoLuong)  VALUES(?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);

            ps.setInt(1, branchCode);
            ps.setInt(2, productCode);
            ps.setInt(3, amount);

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int checkAvailableProduct(int branchCode, int productCode) {
        int check = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS ch FROM qlks.chitietkho WHERE MaChiNhanh =? AND MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, productCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                check = rs.getInt("ch");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }

     public static int getProductAmount(int branchCode, int productCode) {
        int amount = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT SoLuong FROM qlks.chitietkho WHERE MaChiNhanh =? AND MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, productCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("SoLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return amount;
    }
    public static boolean addProduct(int branchCode, int productCode, int amount) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE qlks.chitietkho SET SoLuong = SoLuong + ? WHERE MaSanPham =? AND MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, productCode);
            ps.setInt(3, branchCode);

            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

     public static boolean delProductAmount(int branchCode, int productCode, int amount) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE qlks.chitietkho SET SoLuong = SoLuong - ? WHERE MaSanPham =? AND MaChiNhanh = ?";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, productCode);
            ps.setInt(3, branchCode);

            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
     
    public static boolean addProductInWarehouseReceipt(ProductInWarehouseReceipt spnk, int billCode) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.chitietnhapkho(MaHoaDon,MaSanPham, SoLuong, GiaSanPham) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, billCode);
            ps.setInt(2, spnk.getProductCode());
            ps.setInt(3, spnk.getAmount());
            ps.setInt(4, spnk.getPrice());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int getLatestBillCode() {
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
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return MHD;
    }

    public static List<Object> findProduct(int branchCode, String str) {
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
            ps.setInt(2, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("MaSanPham"), rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("Gia"), rs.getString("MoTa")
                };
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    public static boolean addProduct(Product sp) {

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
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public static boolean adjustPrice(int productCode, int price) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String SQL = "UPDATE qlks.sanpham SET gia = ? WHERE MaSanPham = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(2, productCode);
            ps.setInt(1, price);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
