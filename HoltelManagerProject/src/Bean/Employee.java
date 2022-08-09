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
public class Employee extends Person{
    private int employeeCode;
    private Date dateOfBirth;
    private String positionCode;
    private boolean sex, status;
    private int branchCode; 

    public Employee() {
    }

    public Employee(int employeeCode, String fullName, Date dateOfBirth, String address, String phoneNumber, String CMTNumber, String positionCode, String email, boolean sex, boolean status, int branchCode) {
        super(fullName, phoneNumber, CMTNumber, email, address);
        this.employeeCode = employeeCode;
        this.dateOfBirth = dateOfBirth;
        this.positionCode = positionCode;
        this.sex = sex;
        this.status = status;
        this.branchCode = branchCode;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeCode=" + employeeCode + ", fullName=" + getFullName()+ ", dateOfBirth=" + dateOfBirth + ", address=" + getAddress() + ", phoneNumber=" + getPhoneNumber() + ", CMTNumber=" + getCMTNumber() + ", positionCode=" + positionCode + ", email=" + getEmail() + ", sex=" + sex + ", status=" + status + ", branchCode=" + branchCode + '}';
    }
    
}
