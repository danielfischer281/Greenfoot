import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Obstacle1 implemented by MyWorld.
 * When an instance of Obstacle1 hits the player, the game is over.
 * 
 * @author Daniel Fischer 
 * @version 1.0
 */

public class Obstacle1 extends Actor {
    public void act(){
        // setLocation from static gameVel
        setLocation(getX() - MyWorld.gameVel, getY());
    }
}
