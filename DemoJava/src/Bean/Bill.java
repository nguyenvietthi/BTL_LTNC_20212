/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;

/**
 *
 * @author VIETTHI_PC
 */
public class Bill {
    private int billCode;
    private int roomCode;
    private Date checkOut, checkIn;
    private int price;
    private float VATTax;
    private int employeeNumber;
    private int customerNumber;
    private int branchCode;

    public Bill() {
    }

    public Bill(int billCode, int roomCode, Date checkIn, Date checkOut, int price, float VATTax, int employeeNumber, int customerNumber, int branchCode) {
        this.billCode = billCode;
        this.roomCode = roomCode;
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.price = price;
        this.VATTax = VATTax;
        this.employeeNumber = employeeNumber;
        this.customerNumber = customerNumber;
        this.branchCode = branchCode;
    }

    public int getBillCode() {
        return billCode;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public int getPrice() {
        return price;
    }

    public float getVATTax() {
        return VATTax;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBillCode(int billCode) {
        this.billCode = billCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setVATTax(float VATTax) {
        this.VATTax = VATTax;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }


}
