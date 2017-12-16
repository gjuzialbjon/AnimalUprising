/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 14.12.2017
 * Class that contains the attributes of Monkey Object.
 * Monkey is a extending class of MinionObject, and implements Ally and Ranged interfaces.
 * Its has its own update() and render() methods.
 */



package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class Monkey extends MinionObject implements Ally, Ranged  {


	//Attributes
	private int damage;
	private int health;
	private boolean stand, throwed;
	private int attackTickCount, tickCount, deathTick;
	private Timer speedTimer;

	//constructor
	public Monkey(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		health = ShopManager.getMaxMonkeyHealth();
		attackTickCount = 0;
		tickCount =0;
		stand = false;
		throwed = false;
		deathTick = 0;
		setSpeed(ShopManager.getMonkeySpeed());
		speedTimer = new Timer();
	} 

	//Update method
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
		}
	}

	//Render
	@Override
	public void render(Graphics g) {
		if(stand)
		{
			//Used to prevent throwing animation getting into a loop, while it is not throwing anything.
			if(throwed)
			{
				g.drawImage(ImageManager.monkeyImages[0], (int)posX, (int)posY, width,height, null);
			}
			else
			{
				//throwing animation
				attackTickCount++;
				if(attackTickCount/3 % 3 == 0)
				{
					g.drawImage(ImageManager.monkeyImages[5], (int)posX, (int)posY, width,height, null);
				}
				else if(attackTickCount/3 % 3  == 1)
				{
					g.drawImage(ImageManager.monkeyImages[6], (int)posX+2, (int)posY, width,height, null);
				}

				else if(attackTickCount/3 % 3 == 2)
				{
					g.drawImage(ImageManager.monkeyImages[7], (int)posX+4, (int)posY, width,height, null);
					throwed = true;
				}
			}
		}
		else
		{
			//movement animation
			tickCount++;
			if(tickCount/2 % 5 == 0)
			{
				g.drawImage(ImageManager.monkeyImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 5 == 1)
			{
				g.drawImage(ImageManager.monkeyImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 5 == 2)
			{
				g.drawImage(ImageManager.monkeyImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 5 == 3)
			{
				g.drawImage(ImageManager.monkeyImages[3], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 5 ==  4)
			{
				g.drawImage(ImageManager.monkeyImages[4], (int)posX, (int)posY, width,height, null);
			}

		}
	}

	//method for rendering death animation
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick/2 % 4 == 0)
		{
			g.drawImage(ImageManager.monkeyImages[8], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 1)
		{
			g.drawImage(ImageManager.monkeyImages[9], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 2)
		{
			g.drawImage(ImageManager.monkeyImages[10], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 3)
		{
			g.drawImage(ImageManager.monkeyImages[11], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();
		}
	}
	//summon
	public static void summon()
	{
		game.getObjectManager().addObject(new Monkey(500,0,50,50));
	}	
	//retusn collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	//retuns ranged collision rectangle, used to determine the range of the monkey
	@Override
	public Rectangle getRangedCollisionRectangle() {
		return new Rectangle((int)posX, (int)posY, width+150, height);
	}
	//monkey attack
	public void throwProjectile()
	{
		//if monkey attack is not in cooldown, creates a monkeyAttack isntace
		if(!game.getObjectManager().isMonkeyAttackCD())
		{
			game.getObjectManager().addObject(new MonkeyAttack(posX, posY, 20, 20));
			throwed = false;
		}
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
	//update health, called from collision manager
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		return true;
	}
	//update speed, called from collision manager
	
	@Override
	public boolean updateSpeed(float amount) {
		//after the timer of the buff is expired, sets movement speed back to the default one.
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
	//decrease speed, sets speed to default monkey speed
	@Override
	public boolean decreaseSpeed()
	{
		this.setSpeed(ShopManager.getMonkeySpeed());
		return true;
	}


	//Getters and setters
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
