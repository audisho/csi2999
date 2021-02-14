/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interFace;

/**
 *
 * 
 */
import javax.swing.JFrame;



public class gameFrame extends JFrame {
	
	private int width = 1000;
	private int height = 600;
	
	public gameFrame()
	{   //game title
		this.setTitle("Phoenicia");
		
		gamePanel panel = new gamePanel(width,height);
		getContentPane().add(panel, "Center");
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}