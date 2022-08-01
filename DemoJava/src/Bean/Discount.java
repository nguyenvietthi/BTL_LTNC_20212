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
public class Discount {
    private String discountCode;
    private double percent;

    public Discount(String discountCode, double percent) {
        this.discountCode = discountCode;
        this.percent = percent;
    }

    public Discount() {
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public double getPercent() {
        return percent;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
    
}
