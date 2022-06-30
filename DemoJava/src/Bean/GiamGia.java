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
public class GiamGia {
    private String MaGiamGia;
    private double SoPhanTram;

    public String getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(String MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    public double getSoPhanTram() {
        return SoPhanTram;
    }

    public void setSoPhanTram(double SoPhanTram) {
        this.SoPhanTram = SoPhanTram;
    }

    public GiamGia(String MaGiamGia, double SoPhanTram) {
        this.MaGiamGia = MaGiamGia;
        this.SoPhanTram = SoPhanTram;
    }

    public GiamGia() {
    }
}
