import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * My World creates all objects.
 * 
 * @author Daniel Fischer
 * @version 1.0
 */

public class MyWorld extends World {    
    // Velocity of the game, use for all Actors
    public static int gameVel = 12;
    // def. of how fast the velocity increases
    private int incVel = 200;
    // def. length of Pit, creation of ground objects are skipped
    private int lengthOfPit = 30;
    // def. how likely it is that a pit is created (higher number = lower chance)
    private int chanceOfPit = 200;
    // def. how likely it is that a obstacle is created (higher number = lower chance)
    private int chanceOfObstacle = 60;
    // def. length of Pause after a obstacle was built
    private int lengthOfPause = 40;
    
    private Ground groundObj;
    // Pause
    private boolean mBreak = false;
    // Counter skips ground for creating pits
    private int counterSkip;
    // Counter pauses when obstacle was built
    private int counterPause;
    // Counter Time
    private int counter;
    // Counts number of generated obstacle
    private int countObstacle;
    // Points
    public static int points;
    
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
    // Creates player
    public void createPlayer(){
        Player player = new Player();
        addObject(player, 100, 300);
    }
    // Act method 
    public void act(){
        if(counter%incVel == 0){
            // Increase velocity
            gameVel++;
            // Decrease length of pits
            lengthOfPit--;
        }
        buildMap();
        addScore();
        makeABreak();
        counter++;
        points = counter + countObstacle*100;
    }
    // Builds the dynamic ground, obstacle, enemy
    public void buildMap(){
        if(!(Greenfoot.getRandomNumber(chanceOfPit) == 1) && counterSkip == 0 || mBreak){
            // Create ground object
            if(groundObj.getX() < 1150){
                Ground ground = new Ground();
                addObject(ground, 1200, 649); 
                groundObj = ground;
            }
            // Create obstacle object
            if(Greenfoot.getRandomNumber(chanceOfObstacle) == 1  && !(mBreak)) {
                if(Greenfoot.getRandomNumber(2) == 1){
                    Obstacle1 obstacle1 = new Obstacle1();
                    addObject(obstacle1, 1200, 200);
                }else if(Greenfoot.getRandomNumber(2) == 1){
                    Obstacle2 obstacle2 = new Obstacle2();
                    addObject(obstacle2, 1200, 532);
                }else{
                    Enemy enemy = new Enemy();
                    addObject(enemy, 1200, 490);
                }
                countObstacle++;
                mBreak = true;
                counterPause = 0;
            }
        }else{
            // Skip ground, pits are created
            counterSkip++; 
            if(counterSkip == lengthOfPit){
                counterSkip = 0;
                mBreak = true;
                counterPause = 0;
            }
        }
    }
    // Creates score
    public void addScore(){
        CounterScore score = new CounterScore();
        addObject(score, 1100, 50);
    }
    // Add pause after an obstacle was built to prevent collision
    public void makeABreak(){
        if(mBreak) {
           if(counterPause == lengthOfPause){
               mBreak = false;
               counterPause = 0;
           }
           counterPause++;
        }
    }
}