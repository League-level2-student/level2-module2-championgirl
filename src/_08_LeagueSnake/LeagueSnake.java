package _08_LeagueSnake;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    
 Segment snakeHead;
 int foodX;
 int foodY;
 int headX = 300;
 int headY = 60;
 int snakeDirection = UP;
 int piecesEaten = 0;
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
       snakeHead = new Segment(headX,headY);
       frameRate(20);
       dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*10);
    	foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0,0,0);
        drawFood();
        move();
        drawSnake();
        eat();
    }

    void drawFood() {
        // Draw the food
    	fill(0,225,0);
    	rect(foodX,foodY,10,10);
        
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(225,0,0);
    	rect(snakeHead.x,snakeHead.y,10,10);
    }

    void drawTail() {
        // Draw each segment of the tail
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        if(key==CODED) {
        	if(keyCode == UP) {
        		snakeDirection = UP;
        		
        	}
        	if(keyCode == DOWN) {
        		snakeDirection = DOWN;
        	}
        	if(keyCode == RIGHT) {
        		snakeDirection = RIGHT;
        	}
        	if(keyCode == LEFT) {
        		snakeDirection = LEFT;
        	}
        }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

     
           if (snakeDirection == UP) {
           
        	   snakeHead.y -=1;
        
            
        } else if (snakeDirection == DOWN) {
           
        	snakeHead.y +=1;
                
        } else if (snakeDirection == LEFT) {
            
        	snakeHead.x -=1;
        	
        } else if (snakeDirection == RIGHT) {
             snakeHead.x +=1;
        }
           checkBoundaries();
       
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(snakeHead.y <= 0) {
        	snakeHead.y = height -10;
        }
        else if(snakeHead.y >= 500) {
        	snakeHead.y = 10;
        }
        else if(snakeHead.x <= 0) {
        	snakeHead.x = width -10;
        }
        else if(snakeHead.x >= 500) {
        	snakeHead.x = 10;
        }
        
      
        
    }

    void eat() {
    	
    	if((headX == foodX) && (headY == foodY)) {
    		piecesEaten +=1;
    		drawFood();
    	}
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
