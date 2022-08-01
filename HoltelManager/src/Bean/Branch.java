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
public class Branch {
    private int branchCode;
    private String  branchName, address;
    private int phoneNumber;
    private String email;

    public Branch() {
    }

    public Branch(int branchCode, String branchName, String address, int phoneNumber, String email) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Chi nhánh " + branchName;
    }

  
   
    
}
