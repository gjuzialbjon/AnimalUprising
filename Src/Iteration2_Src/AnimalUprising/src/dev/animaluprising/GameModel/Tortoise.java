/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Tortoise Object.
 * Tortoise is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Tortoise object to ObjectList in 
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

public class Tortoise extends Soldier implements Ally  {



	private int health;
	private int damage;
	private int attackTickCount, tickCount;
	private boolean stand;
	private Timer speedTimer;

	
	public Tortoise(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		health = ShopManager.getMaxTortoiseHealth();
		damage = ShopManager.getTortoiseDamage();
		stand = false;
		attackTickCount = 0;
		tickCount = 0;
		setSpeed(ShopManager.getTortoiseSpeed());
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
			setSpeed(ShopManager.getTortoiseSpeed());
			super.update();
			stand = false;
			
		}	
		if(this.getHealth() <= 0)
		{
			this.die();
			System.out.println("Bear died!");
		}
	}
	
	@Override
	public void render(Graphics g)
	{
		if(stand)
		{
			g.drawImage(ImageManager.tortoiseImages[4], (int)posX, (int)posY, width,height, null);
		}
		else
		{
			tickCount++;
			if(tickCount % 4 == 0)
			{
				g.drawImage(ImageManager.tortoiseImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 4 == 1)
			{
				g.drawImage(ImageManager.tortoiseImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 4 == 2)
			{
				g.drawImage(ImageManager.tortoiseImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 4 == 3)
			{
				g.drawImage(ImageManager.tortoiseImages[3], (int)posX, (int)posY, width,height, null);
			}
		}
	}
	public static void summon()
	{
		game.getObjectManager().addObject(new Tortoise(0,0,50,50));
		
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
	public void renderDead(Graphics g) {

		g.drawImage(ImageManager.tortoiseImages[4], (int)posX, (int)posY, width,height, null);
		this.removeFromDead();
	}
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getTortoiseSpeed()+amount);
		speedTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				decreaseSpeed();
			}
		}, 400);
		speedTimer.cancel();
		return true;
		
	}
	@Override
	public boolean decreaseSpeed()
	{
		this.setSpeed(ShopManager.getTortoiseSpeed());
		return true;
	}
		
	
}
