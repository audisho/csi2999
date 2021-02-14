/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformcsi2999;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * 
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener{

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();
    Timer gameTimer;
    
    public GamePanel(){
        
       player = new Player(400,300,this);
       makeWalls();
       
       gameTimer = new Timer();
       gameTimer.schedule(new TimerTask(){
           @Override
           public void run() {
               player.set();
               repaint();
           }
           
       }, 0, 17);
    }
    public void makeWalls(){
        for(int i = 50; i <800; i += 50){
           walls.add(new Wall(i, 600, 50, 50));
           walls.add(new Wall(i, 800, 50, 50));
        }
        walls.add(new Wall(50,550,50,50));
        walls.add(new Wall(50,500,50,50));
        walls.add(new Wall(50,450,50,50));
        walls.add(new Wall(850,700,50,50));
        walls.add(new Wall(900,600,50,50));
        walls.add(new Wall(600,450,50,50));
        walls.add(new Wall(450,550,50,50));
        walls.add(new Wall(550,500,50,50));
        walls.add(new Wall(800,800,50,50));
        walls.add(new Wall(850,800,50,50));
        walls.add(new Wall(900,800,50,50));
        walls.add(new Wall(800,750,50,50));
    }
    public void paint(Graphics g){
           
        super.paint(g);
        
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for(Wall wall: walls) wall.draw(gtd);
        
    }
        

  

    

    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = true;
        if(e.getKeyChar() == 's') player.keyDown = true;
        if(e.getKeyChar() == 'd') player.keyRight = true;
        if(e.getKeyChar() == ' ') player.keyUp = true;
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = false;
        if(e.getKeyChar() == 's') player.keyDown = false;
        if(e.getKeyChar() == 'd') player.keyRight = false;
        if(e.getKeyChar() == ' ') player.keyUp = false;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        }
    
    
}
