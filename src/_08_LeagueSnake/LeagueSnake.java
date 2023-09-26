package _08_LeagueSnake;

import java.util.ArrayList;

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
 int snakeDirection = UP;
 int piecesEaten = 0;
 ArrayList<Segment> tail = new ArrayList<Segment>();

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
       snakeHead = new Segment(300,60);
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
    	manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
    
    		
    	if (snakeDirection == UP) {
    		int segmentSpacing = 5;
    		for(Segment t: tail ) {
    	    t.y += segmentSpacing;
    	    
            t.y  =-3;
    		}
    	}
    
    	//if (snakeDirection == DOWN) {
    	//	rect(t.x,t.y -5 ,10,10);
    	//}
    	
    	
    	//if (snakeDirection == LEFT) {
    //		rect(t.x +5,t.y  ,10,10);
    	//}
    	//if (snakeDirection == RIGHT) {
    	//	rect(t.x  -5,t.y ,10,10);
    	//}
    	
    		
    		//add 5 to x
    		
    	
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
    	checkTailCollision();
    	drawTail();
    	tail.add(new Segment(snakeHead.x,snakeHead.y));
        // remove the one at the "end"
    	tail.remove(0);
    	
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
    	for(Segment t: tail) {
    	if ((snakeHead.x == t.x) && (snakeHead.y == t.y)){
    	tail = new ArrayList<Segment>();
    	tail.add(new Segment(snakeHead.x,snakeHead.y));
    	piecesEaten = 1;
    	}
    	}
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
           
        	   snakeHead.y -=3;
        
            
        } else if (snakeDirection == DOWN) {
           
        	snakeHead.y +=3;
                
        } else if (snakeDirection == LEFT) {
            
        	snakeHead.x -=3;
        	
        } else if (snakeDirection == RIGHT) {
             snakeHead.x +=3;
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
    	
    	if((snakeHead.x >= foodX - 5 ) && (snakeHead.x <= foodX+5) && (snakeHead.y >= foodY - 5) && (snakeHead.y <= foodY + 5)) {
    		piecesEaten +=1;
    		dropFood();
    		tail.add(new Segment(snakeHead.x +5,snakeHead.y));
    	}
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
