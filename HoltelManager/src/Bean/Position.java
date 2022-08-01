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
public class Position {
    private String positionCode, name;
    private int basicSalary;

    public Position() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Position(String positionCode, String name, int basicSalary) {
        this.positionCode = positionCode;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getName() {
        return name;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

}
