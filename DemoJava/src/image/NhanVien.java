/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author VIETTHI_PC
 */
public class NhanVien {
    public int EmployeeNumber;
    public  String Name;
    public Date DateOfBirth;
    public String Address;
    public int NumberPhone;
    public int CMTNumber;
    public String PositionNumBer, Email;

    public NhanVien() {
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

    public int getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(int NumberPhone) {
        this.NumberPhone = NumberPhone;
    }

    public int getCMTNumber() {
        return CMTNumber;
    }

    public void setCMTNumber(int CMTNumber) {
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

    public NhanVien(int EmployeeNumber, String Name, Date DateOfBirth, String Address, int NumberPhone, int CMTNumber, String PositionNumBer, String Email) {
        this.EmployeeNumber = EmployeeNumber;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.NumberPhone = NumberPhone;
        this.CMTNumber = CMTNumber;
        this.PositionNumBer = PositionNumBer;
        this.Email = Email;
    }

    @Override
    public String toString() {
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        String date = fm.format(this.DateOfBirth);
        return "NhanVien{" + "EmployeeNumber=" + EmployeeNumber + ", Name=" + Name + ", DateOfBirth=" + date + ", Address=" + Address + ", NumberPhone=" + NumberPhone + ", CMTNumber=" + CMTNumber + ", PositionNumBer=" + PositionNumBer + ", Email=" + Email + '}';
    }
    
}
