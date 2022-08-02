/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.ManagerHomeView;

/**
 *
 * @author VIETTHI_PC
 */
public class RoomStatus extends Thread {

    private ManagerHomeView gd;

    public RoomStatus(ManagerHomeView gd) {
        this.gd = gd;
    }

    @Override
    public void run() {
        while (true) {
            gd.setList();
            gd.showRoom();
            gd.setUI();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(RoomStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void start() {
        super.start();
    }
}
