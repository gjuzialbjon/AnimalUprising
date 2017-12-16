/*
 * 
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Dog Object.
 * Dog is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Dog object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */


package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class Dog extends MinionObject implements Ally  
{
	private boolean stand = false;
	public int tickCount = 0;
	public int attackTickCount = 0;
	private int health;
	private int damage;
	private int deathTick;
	private Timer speedTimer;
	public Dog(float posX, float posY, int width, int height)
	{
		super(posX, posY, width, height);
		health = ShopManager.getMaxDogHealth();
		damage = ShopManager.getDogDamage();
		setSpeed(ShopManager.getDogSpeed());
		deathTick = 0;
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
			setSpeed(ShopManager.getDogSpeed());
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
		//If standing, then object is attacking
		if(stand)
		{
			//Attack animation
			attackTickCount++;
			if(attackTickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.dogImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 4 == 1)
			{
				g.drawImage(ImageManager.dogImages[8], (int)posX, (int)posY, width,height, null);
			}

			else if(attackTickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.dogImages[9], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.dogImages[10], (int)posX, (int)posY, width,height, null);
			}

		}
		//If not standing, then object is moving
		else
		{
			//movement animation
			tickCount++;
			if(tickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.dogImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 1)
			{
				g.drawImage(ImageManager.dogImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.dogImages[3], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.dogImages[4], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 4)
			{
				g.drawImage(ImageManager.dogImages[5], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 5)
			{
				g.drawImage(ImageManager.dogImages[6], (int)posX, (int)posY, width,height, null);
			}
		}
	}
	//Method for death animation
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if((deathTick/2) % 7 == 0)
		{
			g.drawImage(ImageManager.dogImages[11], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 7 == 1)
		{
			g.drawImage(ImageManager.dogImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 7 == 2)
		{
			g.drawImage(ImageManager.dogImages[13], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 7 == 3)
		{
			g.drawImage(ImageManager.dogImages[14], (int)posX, (int)posY, width,height, null);
		}

		else if(deathTick/2 % 7 == 4)
		{
			g.drawImage(ImageManager.dogImages[15], (int)posX, (int)posY, width,height, null);
		}

		else if(deathTick/2 % 7 == 5)
		{
			g.drawImage(ImageManager.dogImages[16], (int)posX, (int)posY, width,height, null);
		}

		else if(deathTick/2 % 7 == 6)
		{
			g.drawImage(ImageManager.dogImages[17], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();
		}
	}
	//Summon method
	public static void summon()
	{
		game.getObjectManager().addObject(new Dog(0,0,0,0));
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
		return true;
	}
	//update speed method, called by the collision manager
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getDogSpeed()+amount);
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
		this.setSpeed(ShopManager.getDogSpeed());
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
