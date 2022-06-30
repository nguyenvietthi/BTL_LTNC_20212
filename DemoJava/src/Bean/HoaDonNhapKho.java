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
public class HoaDonNhapKho {
    private int MaHoaDon, MaChiNhanh, MaNhanVien;
    private Date NgayGiao  ;
    private String CongTyGiao, TenNhanVienGiao;

    public HoaDonNhapKho() {
    }

    public HoaDonNhapKho(int MaHoaDon, int MaChiNhanh, int MaNhanVien, Date NgayGiao, String CongTyGiao, String TenNhanVienGiao) {
        this.MaHoaDon = MaHoaDon;
        this.MaChiNhanh = MaChiNhanh;
        this.MaNhanVien = MaNhanVien;
        this.NgayGiao = NgayGiao;
        this.CongTyGiao = CongTyGiao;
        this.TenNhanVienGiao = TenNhanVienGiao;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(int MaChiNhanh) {
        this.MaChiNhanh = MaChiNhanh;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(Date NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public String getCongTyGiao() {
        return CongTyGiao;
    }

    public void setCongTyGiao(String CongTyGiao) {
        this.CongTyGiao = CongTyGiao;
    }

    public String getTenNhanVienGiao() {
        return TenNhanVienGiao;
    }

    public void setTenNhanVienGiao(String TenNhanVienGiao) {
        this.TenNhanVienGiao = TenNhanVienGiao;
    }
    
}
