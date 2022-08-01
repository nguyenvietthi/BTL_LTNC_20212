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
    private int employeeCode;
    private String userName;
    private String passWord;

    public Account() {
    }

    public Account(int employeeCode, String userName, String passWord) {
        this.employeeCode = employeeCode;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
