import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dVel = 0;
    private int gravity = 2;
    private int jumpHeigt = -10;
    
    public void act(){
        // Add your action code here.
        setLocation(getX(), getY() + dVel);
        if(Greenfoot.isKeyDown("w")){
            dVel = jumpHeigt;
        }
        dVel = dVel + gravity;
        if(isTouching(Obstacle1.class) || isTouching(Obstacle2.class) || isTouching(Enemy.class)){
            GameOver gameOverScreen = new GameOver();
            getWorld().addObject(gameOverScreen, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
