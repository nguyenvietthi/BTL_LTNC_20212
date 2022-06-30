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
public class KhachHang {
    private int MaKhachHang;
    private String HoVaTen, SoDienThoi, LoaiKhach, SoCMT, DiaChi, Email;

    public KhachHang() {
    }

    public KhachHang(int MaKhachHang, String HoVaTen, String SoDienThoi, String LoaiKhach, String SoCMT, String DiaChi, String Email) {
        this.MaKhachHang = MaKhachHang;
        this.HoVaTen = HoVaTen;
        this.SoDienThoi = SoDienThoi;
        this.LoaiKhach = LoaiKhach;
        this.SoCMT = SoCMT;
        this.DiaChi = DiaChi;
        this.Email = Email;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getSoDienThoi() {
        return SoDienThoi;
    }

    public void setSoDienThoi(String SoDienThoi) {
        this.SoDienThoi = SoDienThoi;
    }

    public String getLoaiKhach() {
        return LoaiKhach;
    }

    public void setLoaiKhach(String LoaiKhach) {
        this.LoaiKhach = LoaiKhach;
    }

    public String getSoCMT() {
        return SoCMT;
    }

    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
