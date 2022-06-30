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
public class ChiTietSanPhamTrongHoaDon {
    private int MaSanPham;
    private String Ten;
    private int SoLuong;
    private int Gia, TongTien;

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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public ChiTietSanPhamTrongHoaDon(int MaSanPham, String Ten, int SoLuong, int Gia, int TongTien) {
        this.MaSanPham = MaSanPham;
        this.Ten = Ten;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.TongTien = TongTien;
    }

    public ChiTietSanPhamTrongHoaDon() {
    }
}
