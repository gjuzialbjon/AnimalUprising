/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Bear Object.
 * Bear is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Bear object to ObjectList in 
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

public class Bear extends Soldier implements Ally {
	

	private float range = 2f;
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
		stand = false;
		attackTickCount = 0;
		tickCount = 0;
		deathTick = 0;
		speedTimer = new Timer();
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
	//Update
	@Override
	public void update() {
		if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
		{
			Ally.super.stand(this);
			stand = true;
		}
		else
		{
			Ally.super.setDirection();
			setSpeed(ShopManager.getBearSpeed());
			super.update();
			stand = false;
			
		}	
		if(this.getHealth() <= 0)
		{
			this.die();
			System.out.println("Bear died!");
		}
	}
	//Render
	@Override
	public void render(Graphics g) {
		if(stand)
		{
			attackTickCount++;
			if(attackTickCount % 6 == 0)
			{
				g.drawImage(ImageManager.bearImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount % 6== 1)
			{
				g.drawImage(ImageManager.bearImages[7], (int)posX+2, (int)posY, width,height, null);
			}
			
			else if(attackTickCount % 6 == 2)
			{
				g.drawImage(ImageManager.bearImages[8], (int)posX+4, (int)posY, width,height, null);
			}
			else if(attackTickCount % 6 == 3)
			{
				g.drawImage(ImageManager.bearImages[9], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount % 6 == 4)
			{
				g.drawImage(ImageManager.bearImages[10], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount % 6 == 5)
			{
				g.drawImage(ImageManager.bearImages[11], (int)posX, (int)posY, width,height, null);
			}
			
		}
		else
		{
			tickCount++;
			if(tickCount % 6 == 0)
			{
				g.drawImage(ImageManager.bearImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 1)
			{
				g.drawImage(ImageManager.bearImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 2)
			{
				g.drawImage(ImageManager.bearImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 3)
			{
				g.drawImage(ImageManager.bearImages[3], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount % 6 == 4)
			{
				g.drawImage(ImageManager.bearImages[4], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount % 6 == 5)
			{
				g.drawImage(ImageManager.bearImages[5], (int)posX, (int)posY, width,height, null);
			}
		}
	}
	
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick % 4 == 0)
		{
			g.drawImage(ImageManager.bearImages[12], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick % 4 == 1)
		{
			g.drawImage(ImageManager.bearImages[13], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick % 4 == 2)
		{
			g.drawImage(ImageManager.bearImages[14], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick % 4 == 3)
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
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

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
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		return true;
	}
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getBearSpeed()+amount);
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
		
	
}
