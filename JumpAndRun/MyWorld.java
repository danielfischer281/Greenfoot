
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        
        Player player = new Player();
        addObject(player, 100, 800);
        
        Ground ground = new Ground();
        addObject(ground, 0, 1500);
    }
    public void act(){
        counter++;
    }
}
https://www.youtube.com/watch?v=q4HBdz7JYag