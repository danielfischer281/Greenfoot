import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CounterScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CounterScore extends Actor{
    /**
     * Act - do whatever the CounterScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        setImage(new GreenfootImage("Score : " + MyWorld.points, 24, Color.GREEN, Color.BLACK));
    }
}
