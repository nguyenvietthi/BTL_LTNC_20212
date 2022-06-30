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
public class PhongKhachSan {
    private int maChiNhanh;
    private int maPhong;
    private boolean trangThai;
    private int GiaThue;
    private String MoTa;

    public PhongKhachSan(int maChiNhanh, int maPhong, boolean trangThai, int GiaThue, String MoTa) {
        this.maChiNhanh = maChiNhanh;
        this.maPhong = maPhong;
        this.trangThai = trangThai;
        this.GiaThue = GiaThue;
        this.MoTa = MoTa;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    public PhongKhachSan() {
    }

    public PhongKhachSan(int maChiNhanh, int maPhong, boolean trangThai, int GiaThue) {
        this.maChiNhanh = maChiNhanh;
        this.maPhong = maPhong;
        this.trangThai = trangThai;
        this.GiaThue = GiaThue;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getGiaThue() {
        return GiaThue;
    }

    public void setGiaThue(int GiaThue) {
        this.GiaThue = GiaThue;
    }
    

}
