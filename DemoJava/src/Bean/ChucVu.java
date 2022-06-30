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
public class ChucVu {
    private String MaChucVu, Ten;
    private int LuongCoBan;

    public ChucVu() {
    }

    @Override
    public String toString() {
        return this.Ten;
    }

    public ChucVu(String MaChucVu, String Ten, int LuongCoBan) {
        this.MaChucVu = MaChucVu;
        this.Ten = Ten;
        this.LuongCoBan = LuongCoBan;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(int LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    
}
