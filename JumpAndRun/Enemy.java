import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy implemented by MyWorld.
 * When an instance of Enemy hits the player, the game is over.
 * 
 * @author Daniel Fischer
 * @version 1.0
 */

public class Enemy extends Actor {
    public void act(){   
        // setLocation from static gameVel
        setLocation(getX() - MyWorld.gameVel, getY());
    }
}
