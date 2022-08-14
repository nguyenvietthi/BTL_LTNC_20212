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
public class BillDAO{
    public static boolean addBill(Employee nv, int roomCode, int customerCode, double VAT) {
        int Price = HotelRoomDAO.getPrice(nv.getBranchCode(), roomCode);
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.bill(RoomCode, CheckIn, Price, VATTax, EmployeeCode, "
                + "CustomerCode, BranchCode) VALUES(?,localtime(), ?, ?, ?, ?, ?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, roomCode);
            ps.setInt(2, Price);
            ps.setDouble(3, VAT);
            ps.setInt(4, nv.getEmployeeCode());
            ps.setInt(5, customerCode);
            ps.setInt(6, nv.getBranchCode());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static Bill getBill(int roomCode, int branchCode) {
        Bill hd = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.bill WHERE BranchCode = ? AND RoomCode = ? ORDER BY BillCode DESC LIMIT 1;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, roomCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                hd = new Bill(rs.getInt("BillCode"), rs.getInt("RoomCode"), rs.getTimestamp("CheckIn"),
                        rs.getTimestamp("CheckOut"), rs.getInt("Price"), rs.getFloat("VATTax"),
                        rs.getInt("EmployeeCode"), rs.getInt("CustomerCode"), rs.getInt("BranchCode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hd;
    }

    public static Bill getBill(int billCode) {
        Bill hd = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM qlks.bill WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                hd = new Bill(rs.getInt("BillCode"), rs.getInt("RoomCode"), rs.getTimestamp("CheckIn"),
                        rs.getTimestamp("CheckOut"), rs.getInt("Price"), rs.getFloat("VATTax"),
                        rs.getInt("EmployeeCode"), rs.getInt("CustomerCode"), rs.getInt("BranchCode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hd;
    }

    public static int getTotalProductPrice(int billCode) {
        int total = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT SUM(Amount * Price) AS TongTienSanPham FROM qlks.billdetail WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("TongTienSanPham");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return total;
    }

    public static int getTotalRoomPrice(int billCode) {
        int total = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT (hour(timediff(CheckOut, CheckIn)) +  minute(timediff(CheckOut, CheckIn))/60) "
                + "* Price AS TongTienPhong FROM qlks.bill WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("TongTienPhong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return total;
    }

    public static int  reducedPrice(int billCode) {
        double total = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT Percent  FROM discount "
                + "WHERE discount.DiscountCode = (SELECT DiscountCode FROM discountdetail "
                + "	WHERE discountdetail.CustomerType = (SELECT CustomerType FROM customer "
                + "		WHERE customer.CustomerCode = ("
                + "			SELECT CustomerCode FROM bill WHERE bill.BillCode = ?"
                + "			))) AND Status = 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getDouble("Percent") * (getTotal(billCode) - getVATTax(billCode));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (int) total;
    }

    public static int getTotalPrice(int billCode) {
        int total = getTotal(billCode) + getVATTax(billCode) - reducedPrice(billCode);
        return total;
    }

    public static Discount giamGia(int BillCode) {
        Discount total = null;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT DiscountCode,Percent  FROM discount "
                + "WHERE discount.DiscountCode = (SELECT DiscountCode FROM discountdetail "
                + "	WHERE discountdetail.CustomerType = (SELECT CustomerType FROM customer "
                + "		WHERE customer.CustomerCode = ("
                + "			SELECT CustomerCode FROM bill WHERE bill.BillCode = ?"
                + "			))) AND Status = 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, BillCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = new Discount(rs.getString("DiscountCode"), rs.getDouble("Percent"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return total;
    }

    public static int getTotal(int billCode) {
        int total = getTotalRoomPrice(billCode) + getTotalProductPrice(billCode);
        return total;
    }

    public static double getTimes(int billCode) {
        double total = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT (hour(timediff(CheckOut, CheckIn)) +  minute(timediff(CheckOut, CheckIn))/60) "
                + " AS SoGio FROM qlks.bill WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getDouble("SoGio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return total;
    }

    public static int getVATTax(int billCode) {
        double total = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT VATTax FROM qlks.bill WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getDouble("VATTax") * getTotal(billCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (int) total;
    }

    public static boolean checkProductAlreadyInBill(int billCode, int productCode) {
        boolean check = false;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT COUNT(*) AS kiemTra FROM qlks.billdetail WHERE BillCode = ? AND ProductCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.setInt(2, productCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("kiemTra") == 1) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }

    public static boolean addProductToBill(Product sp, int billCode, int amount) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "INSERT INTO qlks.billdetail VALUES(?, ?, ?, ?)";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, sp.getProductCode());
            ps.setInt(2, billCode);
            ps.setInt(3, amount);
            ps.setInt(4, sp.getPrice());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean checkOut(int billCode) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.bill SET CheckOut = localtime() WHERE BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean addProductAmount(Product sp, int billCode, int amount) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "UPDATE qlks.billdetail SET Amount = Amount + ? WHERE ProductCode =? AND BillCode = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, amount);
            ps.setInt(2, sp.getProductCode());
            ps.setInt(3, billCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String SQL = "SELECT product.ProductCode, product.Name, billdetail.Amount, billdetail.Price,"
                + " billdetail.Amount * billdetail.Price AS TongTien FROM "
                + "qlks.billdetail INNER JOIN qlks.product ON billdetail.ProductCode = "
                + "product.ProductCode WHERE billdetail.BillCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductInBill tmp = new ProductInBill(rs.getInt("ProductCode"),
                        rs.getString("Name"), rs.getInt("Amount"), rs.getInt("Price"), rs.getInt("TongTien"));
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean deleteProductInBill(int billCode, int productCode) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "DELETE FROM qlks.billdetail WHERE BillCode = ? AND ProductCode = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, billCode);
            ps.setInt(2, productCode);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
