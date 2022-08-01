/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GiamDocHome;

/**
 *
 * @author VIETTHI_PC
 */
public class TrangThaiPhong extends Thread {

    private GiamDocHome gd;

    public TrangThaiPhong(GiamDocHome gd) {
        this.gd = gd;
    }

    @Override
    public void run() {
        while (true) {
            gd.setList();
            gd.ShowRoom();
            gd.setUI();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrangThaiPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void start() {
        super.start();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // ở đây cũng không được
    }
}
