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
public class ProductInWarehouseReceipt {
    private int productCode;
    private int amount;
    private int price;

    public ProductInWarehouseReceipt() {
    }

    public ProductInWarehouseReceipt(int productCode, int amount, int price) {
        this.productCode = productCode;
        this.amount = amount;
        this.price = price;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    
}
