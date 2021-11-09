
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    
    private Ground groundObj;
    
    // Velocity of the game, use for all Actors
    public static int gameVel = 7;
    // def. of how fast the velocity increases
    private int incVel = 200;
    // def. length of Pit, creation of ground objects are skipped
    private int lengthOfPit = 30;
    // def. how likely it is that a pit is created (higher number = higher chance)
    private int chanceOfPit = 150;
    // def. how likely it is that a obstacle is created (higher number = lower chance)
    private int chanceOfObstacle = 200;
    
    // Counter skips ground for creating pits
    private int counterSkip = 0;
    // Counter Points
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        super(1200, 700, 1, false); 
        createGround();
        createPlayer();
    }
    // Creates initial ground
    public void createGround(){
        for(int i = 0; i<1200; i+=50){
            Ground ground = new Ground();
            addObject(ground, i, 649); 
            groundObj = ground;
        } 
    }
    // Creates Player
    public void createPlayer(){
        Player player = new Player();
        addObject(player, 100, 300);
    }
    // Act method 
    public void act(){
        if(counter%incVel == 0){
            // Increase velocity
            gameVel++;
            // Decrease Length of pits
            lengthOfPit--;
        }
        buildMap();
        counter++;
    }
    // Builds the dynamic ground, Obstacle, Enemy
    public void buildMap(){
        if(!(Greenfoot.getRandomNumber(chanceOfPit) == 1) && counterSkip == 0){
            // Create ground Object
            if(groundObj.getX() < 1150){
                Ground ground = new Ground();
                addObject(ground, 1200, 649); 
                groundObj = ground;
            }
            // Create obstacle Object
            if(Greenfoot.getRandomNumber(chanceOfObstacle) == 1) {
                if(Greenfoot.getRandomNumber(3) == 1){
                    Obstacle1 obstacle1 = new Obstacle1();
                    addObject(obstacle1, 1200, 200);
                }else{
                    Obstacle2 obstacle2 = new Obstacle2();
                    addObject(obstacle2, 1200, 530);
                }
            }
        }else{
            // Skipp ground, pits are created
            counterSkip++; 
            if(counterSkip == lengthOfPit){
                counterSkip = 0;
            }
        }
    }
}