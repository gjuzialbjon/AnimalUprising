/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Monkey Object.
 * Monkey is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Monkey object to ObjectList in 
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

public class Monkey extends Soldier implements Ally, Ranged  {



	private int damage;
	private int health;
	private boolean stand;
	private int attackTickCount, tickCount, deathTick;
	private Timer speedTimer;
	public Monkey(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		health = ShopManager.getMaxMonkeyHealth();
		System.out.println("lololol");
		attackTickCount = 0;
		tickCount =0;
		stand = false;
		deathTick = 0;
		setSpeed(ShopManager.getMonkeySpeed());
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

			setSpeed(ShopManager.getMonkeySpeed());
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
				if(attackTickCount % 3 == 0)
				{
					g.drawImage(ImageManager.monkeyImages[5], (int)posX, (int)posY, width,height, null);
				}
				else if(attackTickCount % 3  == 1)
				{
					g.drawImage(ImageManager.monkeyImages[6], (int)posX+2, (int)posY, width,height, null);
				}
				
				else if(attackTickCount % 3 == 2)
				{
					g.drawImage(ImageManager.monkeyImages[7], (int)posX+4, (int)posY, width,height, null);
				}
				/*
				else 
				{
					g.drawImage(ImageManager.monkeyImages[0], (int)posX+4, (int)posY, width,height, null);
				}
				*/
			}
			else
			{
				tickCount++;
				if(tickCount % 5 == 0)
				{
					g.drawImage(ImageManager.monkeyImages[0], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 5 == 1)
				{
					g.drawImage(ImageManager.monkeyImages[1], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 5 == 2)
				{
					g.drawImage(ImageManager.monkeyImages[2], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 5 == 3)
				{
					g.drawImage(ImageManager.monkeyImages[3], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 5 ==  4)
				{
					g.drawImage(ImageManager.monkeyImages[4], (int)posX, (int)posY, width,height, null);
				}

			}
		}



	public static void summon()
	{
		game.getObjectManager().addObject(new Monkey(500,0,50,50));
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
	public Rectangle getRangedCollisionRectangle() {
		return new Rectangle((int)posX, (int)posY, width+100, height);
	}
	public void throwProjectile()
	{
		if(!game.getObjectManager().isMonkeyAttackCD())
			game.getObjectManager().addObject(new MonkeyAttack(posX, posY, 20, 20));
	}
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick % 4 == 0)
		{
			g.drawImage(ImageManager.monkeyImages[8], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick % 4 == 1)
		{
			g.drawImage(ImageManager.monkeyImages[9], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick % 4 == 2)
		{
			g.drawImage(ImageManager.monkeyImages[10], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick % 4 == 3)
		{
			g.drawImage(ImageManager.monkeyImages[11], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();

		}
		
	}
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getMonkeySpeed()+amount);
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
		this.setSpeed(ShopManager.getMonkeySpeed());
		return true;
	}
		
}
