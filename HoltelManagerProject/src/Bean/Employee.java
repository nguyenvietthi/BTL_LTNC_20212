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
public class Employee {
    private int employeeCode;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String numberPhone;
    private String CMTNumber;
    private String positionNumBer, email;
    private boolean sex, status;
    private int branchCode; 

    public Employee() {
    }

    public Employee(int employeeCode, String name, Date dateOfBirth, String address, String numberPhone, String CMTNumber, String positionNumBer, String email, boolean sex, boolean status, int branchCode) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.numberPhone = numberPhone;
        this.CMTNumber = CMTNumber;
        this.positionNumBer = positionNumBer;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getCMTNumber() {
        return CMTNumber;
    }

    public void setCMTNumber(String CMTNumber) {
        this.CMTNumber = CMTNumber;
    }

    public String getPositionNumBer() {
        return positionNumBer;
    }

    public void setPositionNumBer(String positionNumBer) {
        this.positionNumBer = positionNumBer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Employee{" + "employeeCode=" + employeeCode + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", numberPhone=" + numberPhone + ", CMTNumber=" + CMTNumber + ", positionNumBer=" + positionNumBer + ", email=" + email + ", sex=" + sex + ", status=" + status + ", branchCode=" + branchCode + '}';
    }
    
}
