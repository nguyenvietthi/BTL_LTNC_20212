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
public class WarehouseReceipt {
    private int receiptCode, branchCode, employeeCode;
    private Date date  ;
    private String deliveryCompany, deliveryEmployee;

    public WarehouseReceipt() {
    }

    public WarehouseReceipt(int receiptCode, int branchCode, int employeeCode, Date date, String deliveryCompany, String deliveryEmployee) {
        this.receiptCode = receiptCode;
        this.branchCode = branchCode;
        this.employeeCode = employeeCode;
        this.date = date;
        this.deliveryCompany = deliveryCompany;
        this.deliveryEmployee = deliveryEmployee;
    }

    public void setReceiptCode(int receiptCode) {
        this.receiptCode = receiptCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public void setDeliveryEmployee(String deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }

    public int getReceiptCode() {
        return receiptCode;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public Date getDate() {
        return date;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public String getDeliveryEmployee() {
        return deliveryEmployee;
    }


    
}
