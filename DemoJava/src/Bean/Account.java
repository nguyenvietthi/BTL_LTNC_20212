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
public class Account {
    private int EmployeeNumber;
    private String UserName;
    private String PassWord;

    public Account() {
    }

    public Account(int EmployeeNumber, String UserName, String PassWord) {
        this.EmployeeNumber = EmployeeNumber;
        this.UserName = UserName;
        this.PassWord = PassWord;
    }

    public int getEmployeeNumber() {
        return EmployeeNumber;
    }

    public void setEmployeeNumber(int EmployeeNumber) {
        this.EmployeeNumber = EmployeeNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

  
   
}
