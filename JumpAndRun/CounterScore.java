import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates display for game score
 * 
 * @author Daniel Fischer
 * @version 1.0
 */

public class CounterScore extends Actor {
    public void act(){
        // Show points
        setImage(new GreenfootImage("Score : " + MyWorld.points, 24, Color.GREEN, Color.BLACK));
    }
}
