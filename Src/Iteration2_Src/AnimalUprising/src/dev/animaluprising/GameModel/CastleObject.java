/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * Class that contains the attributes of Castle Object.
 * CastleObject is a extending class of GameObject.
 * It has its own update() and render() methods.
 * the update() method requests summoning enemy soldier, which then each enemy object's 
 * cooldown will be checked in the summoning process, and if there is a Minion  without a active cooldown, then that enemy soldier will be summoned. 
 */




package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class CastleObject extends GameObject implements Enemy
{
	//Attributes
	private int health;
	private long lastTime, timer;
	private int speed, index;
	private boolean summoned = false;
	//Constructor
	public CastleObject(float posX, float posY, int width,int height) {
		super(posX, posY, width, height);
		health = LevelManager.getMaxCastleHealth();
		lastTime = System.currentTimeMillis();
		index = 0;
		timer = 0;
		speed = 5000;
	}

	//update method
	@Override
	public void update()
	{
		//If the castle is not destroyed yet.
		if(this.getHealth() > 0)
		{
			//Checks the collision to update its health.
			game.getCollisionManager().collision(this, game.getObjectManager().getAllies());
			//increment tick counters
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			if(timer>speed)
			{
				index++;
				summoned = true;
				timer = 0;
				
				if(index > 3)
					index = 0;
			}
			if(summoned)
			{
				summonEnemy(index);
				summoned = false;
			}
		
		}
		//checks the health, if it is less then zero, calls the die method.
		else if (this.getHealth() <= 0)
		{
			this.die();
		}

	}
	//Render method, which draws the 
	@Override
	public void render(Graphics g)
	{
		g.drawImage(ImageManager.castleImage, (int)posX, (int)posY, width,height, null);		
	}
	
	@Override
	public void renderDead(Graphics g) {
		// TODO Auto-generated method stub

	}

	//Summones the enemy instances, by checking the cooldowns
	public void summonEnemy(int type)
	{
		if(type == 1 && !game.getObjectManager().isInfantryCD())
		{
			Infantry.summon((int)posX, (int)posY, width,height);
		}
		else if(type == 2 && !game.getObjectManager().isKnightCD())
		{
			Knight.summon((int)posX, (int)posY, width,height);
		}
		else if(type == 3 && !game.getObjectManager().isCrusaderCD())
		{
			Crusader.summon((int)posX, (int)posY, width,height);
		}
	}
	//Returns the collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	//isAlive method
	@Override
	public boolean isAlive() {
		if(this.getHealth() <= 0)
		{

			return false;
		}
		else
		{
			return true;
		}
	}

	//Update health method
	@Override
	public void updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
	}
	//getters and setters
	public void setPosX(float x)
	{
		super.setPosX(x);
	}
	public void setPosY(float y)
	{
		super.setPosY(y);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	//A non functional setSpeed function, which comes from the Enemy interface.
	@Override
	public void setSpeed(float x) {
		
	}


}
