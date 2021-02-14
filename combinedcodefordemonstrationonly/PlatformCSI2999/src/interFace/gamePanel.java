/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interFace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


import javax.swing.JPanel;
import platformcsi2999.Mainframe;

public class gamePanel extends JPanel implements KeyListener {
	private int width,height;
	
	public gamePanel(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.setSize(width,height);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		
		
		
	}
	
	private String[] option = new String[] {"ONE PLAYER","TWO PLAYER","SETTING","ABOUT","QUIT"};
	//where is keyboard stop
	int index;
	int[] optionY = new int[]{200,230,260,290,320};
	int optionX = 400;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillRect(0,0,width,height);
		//button color change when use
		for (int i =0;i<option.length;i++)
		{
			int x = optionX;
			int y = optionY[i];
			
			if(i==index)
			{
				g.setColor(Color.red);
			}
			else
			{
				g.setColor(Color.yellow);
				
			}
			
			g.drawString(option[i], x, y);
			
			
		}//for loop end
		
		
	}//paint end
	
	public void keyPressed(KeyEvent e)
	{
		int keyLocaltion= e.getKeyCode();
	
		switch(keyLocaltion)
		{
		case KeyEvent.VK_UP: index = (index + option.length - 1) % option.length;
		this.repaint();
		break;
		
		case KeyEvent.VK_W: index = (index + option.length - 1) % option.length;
		this.repaint();
		break;
		
		case KeyEvent.VK_DOWN: index = (index + 1) % option.length;
		this.repaint();
		break;
		
		case KeyEvent.VK_S: index = (index + 1) % option.length;
		this.repaint();
		break;
		
		case KeyEvent.VK_ENTER:
			if(index == 4)
			{
				                        
                                System.exit(0);
			}
                        else if(index ==0)
			{
			                                        
                        Mainframe frame = new Mainframe();
                        frame.setSize(1000, 1000);
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
    
                        frame.setResizable(false);
                        frame.setTitle("Phoenicia");
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        }
                        else{
                        System.out.println(index + " "+ option[index]);
                        }
		break;
		
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
		break;	
		}
		
		
		
	}
	
	
	
	public void keyReleased(KeyEvent e) {
	}
 
	
	public void keyTyped(KeyEvent e) {
	}
}