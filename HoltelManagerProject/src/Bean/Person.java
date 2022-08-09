/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

/**
 *
 * @author VIETTHI_PC
 */
public class Person {
    private String fullName, phoneNumber, CMTNumber, email, address;

    public Person(String fullName, String phoneNumber, String CMTNumber, String email, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.CMTNumber = CMTNumber;
        this.email = email;
        this.address = address;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCMTNumber() {
        return CMTNumber;
    }

    public void setCMTNumber(String CMTNumber) {
        this.CMTNumber = CMTNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
