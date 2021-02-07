/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import game.Handler;
import game.Id;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author i5-Sulit
 */
public abstract class Tile {
        
    public int x, y;
    public int width, height;
    
    public boolean solid;
    
    public int velX, velY;
    
    public Id id;
    
    public Handler handler;
    
    public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        this.handler = handler;
    }
    
    public abstract void render(Graphics g);
    public abstract void tick();

    public void die(){
        handler.removeTile(this);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Id getId(){
        return id;
    }
    
    public boolean isSolid() {
        return solid;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),width,height);
    }
    
}
