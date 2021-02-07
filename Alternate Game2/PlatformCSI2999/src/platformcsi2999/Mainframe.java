/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformcsi2999;

import java.awt.Color;

/**
 *
 * @author i5-Sulit
 */
public class Mainframe extends javax.swing.JFrame{
    
    /**
     *
     */
    public Mainframe()
    {
    
    GamePanel panel = new GamePanel();
    panel.setLocation(0,0);
    panel.setSize(this.getSize());
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setVisible(true);
    this.add(panel);
    
    addKeyListener(new KeyChecker(panel));
    }
}
