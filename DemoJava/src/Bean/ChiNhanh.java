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
public class ChiNhanh {
    private int MaChiNhanh;
    private String  tenChiNhanh, diaChi;
    private int soDienThoai;
    private String email;

    public ChiNhanh() {
    }

    public ChiNhanh(int MaChiNhanh, String tenChiNhanh, String diaChi, int soDienThoai, String email) {
        this.MaChiNhanh = MaChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public int getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(int MaChiNhanh) {
        this.MaChiNhanh = MaChiNhanh;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Chi nhánh " + tenChiNhanh;
    }

  
   
    
}
