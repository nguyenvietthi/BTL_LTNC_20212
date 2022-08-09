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
public class Customer extends Person{
    private int customerCode;
    private String customerType;

    public Customer() {
    }

    public Customer(int customerCode, String fullName, String phoneNumber, String customerType, String CMTNumber, String address, String email) {
        super(fullName, phoneNumber, CMTNumber, email, address);
        this.customerCode = customerCode;
        this.customerType = customerType;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    
}
