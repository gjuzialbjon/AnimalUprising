/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * Class that contains the attributes of Bear Object.
 * Bear is a extending class of Minion Object, and implements Ally interface.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() 
 * Also, it has its own summon() method, which adds creates and adds a Bear object to alliesList in 
 * ObjectManager object.
 */


package dev.animaluprising.GameModel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class Bear extends MinionObject implements Ally {


	//Attributes
	private int damage;
	private int health;
	private boolean stand;
	private int attackTickCount, tickCount, deathTick;
	private Timer speedTimer;

	//Constructor
	public Bear(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		health = ShopManager.getMaxBearHealth();
		damage = ShopManager.getBearDamage();
		setSpeed(ShopManager.getBearSpeed());
		attackTickCount = 0;
		tickCount = 0;
		deathTick = 0;
		stand = false;
		speedTimer = new Timer();
	}


	//Update
	@Override
	public void update() 
	{
		//Checks the collision
		if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
		{
			//Calls the default method in Ally interface, which sets the movement speed to 0
			Ally.super.stand(this);
			stand = true;
		}
		else
		{
			//Sets the location of the object
			Ally.super.setDirection();
			//Sets the speed of the object back to it's default.
			setSpeed(ShopManager.getBearSpeed());
			super.update();
			stand = false;


		}	
		//Checks the health, if its less then or equal to zero, calls die method
		if(this.getHealth() <= 0)
		{
			this.die();
		}
	}
	//Render
	@Override
	public void render(Graphics g) {
		//If the object stands, then it is attacking to an enemy object, so it renders the attack animation.
		if(stand)
		{
			attackTickCount++;
			if(attackTickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.bearImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount /2 % 6== 1)
			{
				g.drawImage(ImageManager.bearImages[7], (int)posX+2, (int)posY, width,height, null);
			}

			else if(attackTickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.bearImages[8], (int)posX+4, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.bearImages[9], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 6 == 4)
			{
				g.drawImage(ImageManager.bearImages[10], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 6 == 5)
			{
				g.drawImage(ImageManager.bearImages[11], (int)posX, (int)posY, width,height, null);
			}

		}
		//If the object is not standing, then its moving, render the movement animation.
		else
		{
			tickCount++;
			if(tickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.bearImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 1)
			{
				g.drawImage(ImageManager.bearImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.bearImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.bearImages[3], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 4)
			{
				g.drawImage(ImageManager.bearImages[4], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 5)
			{
				g.drawImage(ImageManager.bearImages[5], (int)posX, (int)posY, width,height, null);
			}

		}
	}
	
	//Renders the death animation of the object
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick/2 % 4 == 0)
		{
			g.drawImage(ImageManager.bearImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 1)
		{
			g.drawImage(ImageManager.bearImages[13], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 2)
		{
			g.drawImage(ImageManager.bearImages[14], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 3)
		{
			g.drawImage(ImageManager.bearImages[15], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();
		}

	}
	//Summon method
	public static void summon()
	{
		game.getObjectManager().addObject(new Bear(0,0,50,50));	
	}
	//collision rectangle method.
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	//is alive method
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
	//updates health, called by the collision manager.
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		System.out.println("health:" + this.getHealth());
		return true;
	}
	//update speed method, called by the collision manager
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getBearSpeed()+amount);
		//timer object for decreasing the movement speed after a while, back to its default
		speedTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				decreaseSpeed();
			}
		}, 600);
		speedTimer.cancel();
		return true;
	}
	@Override
	public boolean decreaseSpeed()
	{
		this.setSpeed(ShopManager.getBearSpeed());
		return true;
	}
	//getters and setters
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
