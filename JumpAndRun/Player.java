import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor{
    // gravity constant
    private int gravity = 2;
    // Jump Hight of the player
    private int jumpHeigt = -38;
    
    // overall Velocity
    private int dVel = 0;
    
    public void act(){
        gameOver();
        jump();
        // Sets position of the player
        setLocation(getX(), getY() + dVel);
        dVel = dVel + gravity;
    }
    // checks if player is touching an obstacle or fell in pit
    public void gameOver(){
        if(isTouching(Obstacle1.class) || isTouching(Obstacle2.class) || isTouching(Enemy.class) || isAtEdge()){
            GameOver gameOverScreen = new GameOver();
            getWorld().addObject(gameOverScreen, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    // checks if player is on the ground, jump action
    public void jump(){
       if(isTouching(Ground.class)){
            dVel = 0;
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("space")){
                dVel = jumpHeigt;
            }
        } 
    }
    // Code only used for debugging
    public void debug(){
        if(Greenfoot.isKeyDown("d")){
            move(5);
        }
    }
}
