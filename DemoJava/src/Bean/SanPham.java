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
public class SanPham {
    private int MaSanPham;
    private String Ten;
    private int Gia;
    private String MoTa;

    public SanPham(int MaSanPham, String Ten, int Gia, String MoTa) {
        this.MaSanPham = MaSanPham;
        this.Ten = Ten;
        this.Gia = Gia;
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return this.Ten;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public SanPham() {
    }
}
