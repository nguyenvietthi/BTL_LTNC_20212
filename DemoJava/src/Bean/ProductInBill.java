/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author VIETTHI_PC
 */
public class ProductInBill {
    private int productCode;
    private String productName;
    private int amount;
    private int price, totalPrice;

    public ProductInBill(int productCode, String productName, int amount, int price, int totalPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public ProductInBill() {
    }

    public int getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
