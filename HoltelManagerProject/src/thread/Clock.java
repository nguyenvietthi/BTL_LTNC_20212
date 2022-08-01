/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author VIETTHI_PC
 */
public class Clock extends Thread{
    private  JLabel lable;

    public Clock(JLabel lable) {
        this.lable = lable;
    }
    @Override
    public void run()
    {
        Date now;
        SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss aa");
        while (true){
            now = new Date();
            lable.setText(date.format(now));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {  }
        }
    }
    @Override
    public void start(){
        super.start();
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList <>(); // ở đây cũng không được
    }
}
