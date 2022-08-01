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
public class Product {
    private int productCode;
    private String name;
    private int price;
    private String description;

    public Product(int productCode, String name, int price, String description) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Product() {
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
