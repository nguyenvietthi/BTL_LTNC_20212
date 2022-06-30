/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;

/**
 *
 * @author VIETTHI_PC
 */
public class HoaDon {
    private int MaHoaDon;
    private int MaPhong;
    private Date GioVao, GioRa;
    private int GiaThue;
    private float ThueVAT;
    private int MaNhanVien;
    private int MaKhachHang;
    private int MaChiNhanh;

    public HoaDon() {
    }

    public HoaDon(int MaHoaDon, int MaPhong, Date GioVao, Date GioRa, int GiaThue, float ThueVAT, int MaNhanVien, int MaKhachHang, int MaChiNhanh) {
        this.MaHoaDon = MaHoaDon;
        this.MaPhong = MaPhong;
        this.GioVao = GioVao;
        this.GioRa = GioRa;
        this.GiaThue = GiaThue;
        this.ThueVAT = ThueVAT;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.MaChiNhanh = MaChiNhanh;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int MaPhong) {
        this.MaPhong = MaPhong;
    }

    public Date getGioVao() {
        return GioVao;
    }

    public void setGioVao(Date GioVao) {
        this.GioVao = GioVao;
    }

    public Date getGioRa() {
        return GioRa;
    }

    public void setGioRa(Date GioRa) {
        this.GioRa = GioRa;
    }

    public int getGiaThue() {
        return GiaThue;
    }

    public void setGiaThue(int GiaThue) {
        this.GiaThue = GiaThue;
    }

    public float getThueVAT() {
        return ThueVAT;
    }

    public void setThueVAT(float ThueVAT) {
        this.ThueVAT = ThueVAT;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(int MaChiNhanh) {
        this.MaChiNhanh = MaChiNhanh;
    }
    
}
