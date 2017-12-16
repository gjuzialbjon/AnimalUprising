/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Crusader Object.
 * Crusader is a extending class of Soldier, and implements Enemy and Melee interfaces.
 * Its has its own update() and render() methods. Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Crusader object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */


package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class Crusader extends MinionObject implements Enemy  {


	//Attributes
	private int tickCount;
	private int attackTickCount;
	private boolean stand;
	private int damage;
	private int health;
	private int deathTick;
	//Constructor
	public Crusader(float posX, float posY, int width, int height)
	{
		super(posX, posY, width, height);
		health = LevelManager.getMaxCrusaderHealth();
		damage = LevelManager.getCrusaderDamage();
		attackTickCount = 0;
		tickCount = 0;
		deathTick = 0;
		stand = false;
	} 

	//Update method
	@Override
	public void update()
	{
		//Checks the collision
		if(game.getCollisionManager().collision(this, game.getObjectManager().getAllies()))
		{
			//Calls the default stand method of Enemy interface
			Enemy.super.stand(this);
			stand = true;
		}
		else
		{
			stand = false;
			//Calls the default direction method of Enemy interface
			Enemy.super.setDirection();
			super.update();
		}
		//Checks health, if <= 0 calls die method
		if(this.getHealth() <= 0)
		{
			this.die();
		}
	}
	
	//Render method for the animations
	@Override
	public void render(Graphics g) {
		//If standing, then object is attacking
		if(stand)
		{
			//Attack animations
			attackTickCount++;
			if(attackTickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.crusaderImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 1)
			{
				g.drawImage(ImageManager.crusaderImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.crusaderImages[8], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.crusaderImages[9], (int)posX, (int)posY, width,height, null);
			}
		}
		//If not standing, then it must be moving.
		else
		{
			//Move animations
			tickCount++;
			if(tickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.crusaderImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 1)
			{
				g.drawImage(ImageManager.crusaderImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.crusaderImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.crusaderImages[3], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 4)
			{
				g.drawImage(ImageManager.crusaderImages[4], (int)posX, (int)posY, width,height, null);
			}
			
			else if (tickCount/2 % 6 == 5)
			{
				g.drawImage(ImageManager.crusaderImages[5], (int)posX, (int)posY, width,height, null);
			}
		}
	}

	//Method for rendering death animation
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick/2 % 4 == 0)
		{
			g.drawImage(ImageManager.crusaderImages[10], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick/2 % 4 == 1)
		{
			g.drawImage(ImageManager.crusaderImages[11], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick/2 % 4 == 2)
		{
			g.drawImage(ImageManager.crusaderImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 3)
		{
			g.drawImage(ImageManager.crusaderImages[13], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();

		}
		
	}
	//Summon method
	public static void summon(int posX, int posY, int width, int height)
	{
		game.getObjectManager().addObject(new Crusader(posX,posY,width,height));
	}
	//Method which returns the collison rectangle.
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
	//update health method, called in CollisionManager
	@Override
	public void updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
	}
	//Getters and Setters
	public void setPosX(float x)
	{
		super.setPosX(x);
	}
	public void setPosY(float y)
	{
		super.setPosY(y);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}


}
