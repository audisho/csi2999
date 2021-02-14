/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformcsi2999;

//import com.sun.prism.paint.Color;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * 
 */
public class Player {
    
    GamePanel panel;
    int x;
    int y;
    int width;
    int height;
    
    double xspeed;
    double yspeed;
    
    Rectangle hitBox;
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    
    public Player(int x, int y, GamePanel panel){
        
        this.panel = panel;
        this.x = x;
        this.y = y;
        
        width = 50;
        height = 50;
        hitBox = new Rectangle(x, y, width, height);
    }
    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *=0.8;
        else if (keyLeft && !keyRight) xspeed --;
        else if (keyRight && !keyLeft) xspeed ++; 
        
        if(xspeed > 0 && xspeed < 0.75) xspeed =0;
        if(xspeed < 0 && xspeed >-0.75) xspeed =0;
        
        if(xspeed > 7) xspeed =7;
        if(xspeed < -7) xspeed =-7;
        
        if(keyUp){
            hitBox.y ++;
            for(Wall wall: panel.walls){
                if(wall.hitBox.intersects(hitBox)) yspeed =-6;
            }
            hitBox.y --;
        }
        
        yspeed += 0.3;
        // Horizontal Collision
        hitBox.x += xspeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
                hitBox.x -= Math.signum(xspeed);
                xspeed =0;
                x = hitBox.x;
            }
        }
        // Vertical Collision
        hitBox.y += yspeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }
        
        
        x += xspeed;
        y += yspeed;
        
        hitBox.x = x;
        hitBox.y = y;
    }
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.white);
        gtd.fillRect(x, y, width, height);
    }


}
