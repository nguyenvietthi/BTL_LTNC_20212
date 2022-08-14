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
        String SQL = "SELECT * FROM qlks.product INNER JOIN qlks.warehousedetail ON "
                + "warehousedetail.ProductCode = product.ProductCode WHERE warehousedetail.BranchCode = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Product tmp = new Product(rs.getInt("ProductCode"), rs.getString("Name"), rs.getInt("Price"), rs.getString("Description"));
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
        String SQL = "SELECT warehousedetail.BranchCode, warehousedetail.ProductCode, warehousedetail.Amount, product.Name,"
                + " product.Price, product.Description FROM qlks.warehousedetail INNER JOIN"
                + " qlks.product ON warehousedetail.ProductCode = product.ProductCode WHERE warehousedetail.BranchCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("ProductCode"), rs.getString("Name"), rs.getInt("Amount"), rs.getInt("Price"), rs.getString("Description")
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
        String SQL = "SELECT * FROM qlks.warehousereceipt";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                WarehouseReceipt tmp = new WarehouseReceipt(
                        rs.getInt("WarehouseReceiptCode"), rs.getInt("BranchCode"),
                        rs.getInt("EmployeeCode"), rs.getDate("CheckInTime"), rs.getString("DeliveryCompany"),
                        rs.getString("DeliveryEmployee")
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
        String sql = "INSERT INTO qlks.warehousereceipt(BranchCode,EmployeeCode, Time, DeliveryCompany, "
                + "DeliveryEmployee) VALUES(?,?,localtime(),?,?)";
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
        String sql = "INSERT INTO qlks.warehousedetail(BranchCode, ProductCode, Amount)  VALUES(?,?,?)";
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
        String SQL = "SELECT COUNT(*) AS ch FROM qlks.warehousedetail WHERE BranchCode =? AND ProductCode = ?";
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
        String SQL = "SELECT Amount FROM qlks.warehousedetail WHERE BranchCode =? AND ProductCode = ?";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setInt(1, branchCode);
            ps.setInt(2, productCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("Amount");
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
        String sql = "UPDATE qlks.warehousedetail SET Amount = Amount + ? WHERE ProductCode =? AND BranchCode = ?";
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
        String sql = "UPDATE qlks.warehousedetail SET Amount = Amount - ? WHERE ProductCode =? AND BranchCode = ?";
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
     
    public static boolean addProductInWarehouseReceipt(ProductInWarehouseReceipt spnk, int WarehouseReceiptCode) {
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO qlks.warehousereceiptdetail(WarehouseReceiptCode,ProductCode, Amount, Price) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, WarehouseReceiptCode);
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

    public static int getLatestWarehouseReceiptCode() {
        int MHD = 0;
        Connection conn = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT WarehouseReceiptCode FROM qlks.warehousereceipt ORDER BY WarehouseReceiptCode DESC LIMIT 1";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                MHD = rs.getInt("WarehouseReceiptCode");

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
        String SQL = "SELECT warehousedetail.BranchCode, warehousedetail.ProductCode, warehousedetail.Amount, product.Name,"
                + " product.Price, product.Description FROM qlks.warehousedetail INNER JOIN"
                + " qlks.product ON warehousedetail.ProductCode = "
                + "product.ProductCode WHERE product.Name LIKE CONCAT('%', ?, '%') AND warehousedetail.BranchCode = ?;";
        try {
            ps = (PreparedStatement) conn.prepareCall(SQL);
            ps.setString(1, str);
            ps.setInt(2, branchCode);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Object tmp = new Object[]{
                    rs.getInt("ProductCode"), rs.getString("Name"), rs.getInt("Amount"), rs.getInt("Price"), rs.getString("Description")
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
        String sql = "INSERT INTO qlks.product(Name, Price, Description) VALUES(?, ?, ?)";
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
        String SQL = "UPDATE qlks.product SET Price = ? WHERE ProductCode = ?";
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
