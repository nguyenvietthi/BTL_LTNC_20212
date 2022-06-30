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
public class SanPhamNhapKho {
    private int MaSanPham;
    private int SoLuong;
    private int Gia;

    public SanPhamNhapKho() {
    }

    public SanPhamNhapKho(int MaSanPham, int SoLuong, int Gia) {
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
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
    
}
