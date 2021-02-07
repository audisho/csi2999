/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import game.Handler;
import game.Id;
import java.awt.Color;
import java.awt.Graphics;
import tile.Tile;

/**
 *
 * @author i5-Sulit
 */
public class Player extends Entity {

    public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
        setVelX(0);
    }

    
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

  
    public void tick() {
        x+=velX;
        y+=velY;
        if(x<=0) x =0;
        if(x+width>=1080) x = 1080-width;
        if(y+height>=771) y = 771-height;
        for(Tile t:handler.tiles){
            if(!t.solid) break;
            if(t.getId()==Id.wall){
// Collision check.            
                if(getBoundsTop().intersects(t.getBounds())){
                    setVelY(0);
                    if(jumping){
                        jumping = false;
                        gravity = 0.0;
                        falling = true;
                    }
                    
                }
                if(getBoundsBottom().intersects(t.getBounds())){
                    setVelY(0);
                   if(falling) falling = false;
                }
                else if(!falling&&!jumping){
                           gravity = 0.8;
                           falling = true;
                       }
                   
                
                if(getBoundsLeft().intersects(t.getBounds())){
                    setVelX(0);
                    x = t.getX()+width;
                }
                if(getBoundsRight().intersects(t.getBounds())){
                    setVelX(0);
                    x = t.getX()-width;
                }
    
            }
        }
        if(jumping){
            gravity-=0.1;
            setVelY((int)-gravity);
            if(gravity<=0.0){
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            gravity+=0.1;
            setVelY((int)gravity);
        }
    }
    
}
