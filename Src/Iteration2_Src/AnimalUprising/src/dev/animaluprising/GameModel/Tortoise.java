/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * Class that contains the attributes of Tortoise Object.
 * Tortoise is a extending class of MinionObject, and implements Ally interface.
 * Its has its own update() and render() methods.
 * Tortoise cannot attack, and its slow but it tanks the damage done from the enemies enabling other allied minions to attack longer.
 */



package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class Tortoise extends MinionObject implements Ally  {


	//Attributes
	private int health;
	private int damage;
	private int  tickCount;
	private boolean stand;
	private Timer speedTimer;

	//Constructor
	public Tortoise(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		health = ShopManager.getMaxTortoiseHealth();
		damage = ShopManager.getTortoiseDamage();
		stand = false;
		tickCount = 0;
		setSpeed(ShopManager.getTortoiseSpeed());
		speedTimer = new Timer();
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
	//Render
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
			if(tickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.tortoiseImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 4 == 1)
			{
				g.drawImage(ImageManager.tortoiseImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.tortoiseImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.tortoiseImages[3], (int)posX, (int)posY, width,height, null);
			}
		}
	}
	//render death
	@Override
	public void renderDead(Graphics g) {

		g.drawImage(ImageManager.tortoiseImages[4], (int)posX, (int)posY, width,height, null);
		this.removeFromDead();
	}
	//Summon
	public static void summon()
	{
		game.getObjectManager().addObject(new Tortoise(0,0,50,50));

	}	
	//returns collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	//is alive
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
	//updates,getters and setters
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		return true;
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
