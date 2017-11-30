package dev.animalgame.entities.creatures;

import java.awt.Graphics;

import dev.animalgame.entities.Entity;
import dev.animalgame.levels.Level;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_CREATURE_HP = 10;
	public static final float DEFAULT_CREATURE_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed=DEFAULT_CREATURE_SPEED;
	protected float xMove,yMove;
	
	/**
	 *@deprecated this usually results with a faulty collision box if the collision box is not manually edited after init. Try not to use.
	 */
	public Creature(float x, float y) {
		this(x,y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
		
	}
	
	public Creature(float x, float y, int width,int height) {
		super(x, y, width, height);
		this.health = DEFAULT_CREATURE_HP; //TODO this can change, do health=default in the field part if you want
		//this.speed = DEFAULT_CREATURE_SPEED; // not necessary since its set on field.
	}
	
	
	
	//TODO make this return a bool, true if move was made, false if not
	public void move(){
		
		
		if(xMove>0){//moving right
			float nextX= xMove+xpos+collisionBox.x+collisionBox.width;
			if(!(nextX>Level.MAPWIDTH))
					xpos += xMove;
		}else if(xMove<0){//moving left
			float nextX= xMove + xpos + collisionBox.x;
			if(!(nextX<0))
				xpos += xMove;
		}
		
		
		ypos += yMove;
	}
	
	//TODO edit the render method so that it displays a helathbar on top of the creature.
	
	
	
	//GETTERS AND SETTERS AFTER THIS
	

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
	
	

}
