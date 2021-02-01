package interFace;

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
	
	public static void main(String[] args) 
	{
		gameFrame frame = new gameFrame();
	}
	
	

}
