/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformcsi2999;

import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * 
 */
public class PlatformCSI2999 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mainframe frame = new Mainframe();
        
        frame.setSize(700, 700);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
    
        frame.setResizable(false);
        frame.setTitle("Platformer Game");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }
    
}
