/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import entity.Entity;
import java.awt.Graphics;
import java.util.LinkedList;
import tile.Tile;
import tile.Wall;

/**
 *
 * @author i5-Sulit
 */
public class Handler {
    
    public LinkedList<Entity> entities = new LinkedList<Entity>();
    public LinkedList<Tile> tiles = new LinkedList<Tile>();
    
    public Handler(){
        createLevel();
    }
    
    public void render(Graphics g){
        for(Entity en: entities){
            en.render(g);
        }
        for(Tile ti:tiles){
            ti.render(g);
        }
    }
    public void tick(){
        for(Entity en: entities){
            en.tick();
        }
        for(Tile ti:tiles){
            ti.tick();
        }
    }
    public void addEntity(Entity en){
        entities.add(en);
        
    }
    public void removeEntity(Entity en){
        entities.remove(en);
    }
    public void addTile(Tile ti){
        tiles.add(ti);
        
    }
    public void removeTile(Tile ti){
        tiles.remove(ti);
    }
    public void createLevel(){
        for(int i=0; i<Game.WIDTH*Game.SCALE/64+1;i++){
            addTile(new Wall(i*64,Game.HEIGHT*Game.SCALE-64,64,64,true,Id.wall,this));
            if(i!=0&&i!=1&&i!=15&&i!=16&&i!=17) addTile(new Wall(i*64,300,64,64,true,Id.wall,this));
        }
    }

}
