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
public class Customer {
    private int customerCode;
    private String fullName, phoneNumber, customerType, CMTNumber, address, email;

    public Customer() {
    }

    public Customer(int customerCode, String fullName, String phoneNumber, String customerType, String CMTNumber, String address, String email) {
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.CMTNumber = CMTNumber;
        this.address = address;
        this.email = email;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getCMTNumber() {
        return CMTNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setCustomerCode (int customerCode) {
        this.customerCode = customerCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setCMTNumber(String CMTNumber) {
        this.CMTNumber = CMTNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
