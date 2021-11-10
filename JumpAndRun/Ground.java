import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground implemented by MyWorld.
 * Brick ground.
 * 
 * @author Daniel Fischer 
 * @version 1.0
 */
public class Ground extends Actor {
    public void act() {
        // setLocation from static gameVel
        setLocation(getX() - MyWorld.gameVel, getY());
    }
}
