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
public class NhanVien {
    private int EmployeeNumber;
    private String Name;
    private Date DateOfBirth;
    private String Address;
    private String NumberPhone;
    private String CMTNumber;
    private String PositionNumBer, Email;
    private boolean Sex, Status;
    private int BranchCode; 

    public NhanVien() {
    }

    public NhanVien(int EmployeeNumber, String Name, Date DateOfBirth, String Address, String NumberPhone, String CMTNumber, String PositionNumBer, String Email, boolean Sex, boolean Status, int BranchCode) {
        this.EmployeeNumber = EmployeeNumber;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.NumberPhone = NumberPhone;
        this.CMTNumber = CMTNumber;
        this.PositionNumBer = PositionNumBer;
        this.Email = Email;
        this.Sex = Sex;
        this.Status = Status;
        this.BranchCode = BranchCode;
    }

    public int getEmployeeNumber() {
        return EmployeeNumber;
    }

    public void setEmployeeNumber(int EmployeeNumber) {
        this.EmployeeNumber = EmployeeNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String NumberPhone) {
        this.NumberPhone = NumberPhone;
    }

    public String getCMTNumber() {
        return CMTNumber;
    }

    public void setCMTNumber(String CMTNumber) {
        this.CMTNumber = CMTNumber;
    }

    public String getPositionNumBer() {
        return PositionNumBer;
    }

    public void setPositionNumBer(String PositionNumBer) {
        this.PositionNumBer = PositionNumBer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(int BranchCode) {
        this.BranchCode = BranchCode;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "EmployeeNumber=" + EmployeeNumber + ", Name=" + Name + ", DateOfBirth=" + DateOfBirth + ", Address=" + Address + ", NumberPhone=" + NumberPhone + ", CMTNumber=" + CMTNumber + ", PositionNumBer=" + PositionNumBer + ", Email=" + Email + ", Sex=" + Sex + ", Status=" + Status + ", BranchCode=" + BranchCode + '}';
    }
    
}
