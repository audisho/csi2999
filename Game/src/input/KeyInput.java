/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;



import entity.Entity;
import game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * 
 */
public class KeyInput implements KeyListener {

  
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(Entity en: Game.handler.entities){
            switch(key){
            case KeyEvent.VK_SPACE:
                if(!en.jumping){
                    en.jumping = true;
// Set game gravity here. Increase for higher jumps
                    en.gravity = 10.0;
                }
                break;
            case KeyEvent.VK_A:
                en.setVelX(-5);
                break;
            case KeyEvent.VK_D:
                en.setVelX(5);
                break;    
            }
        
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(Entity en: Game.handler.entities){
            switch(key){
            case KeyEvent.VK_SPACE:
                en.setVelY(0);
                break;
            case KeyEvent.VK_A:
                en.setVelX(0);
                break;
            case KeyEvent.VK_D:
                en.setVelX(0);
                break;    
            }
        
        }
    }
    
    public void keyTyped(KeyEvent e) {
        //not using
    }
}
