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

public class Dog extends Soldier implements Ally  
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
					stand = false;
					Ally.super.setDirection();
					setSpeed(ShopManager.getDogSpeed());
					super.update();
					
				}	
				if(this.getHealth() <= 0)
				{
					this.die();

					System.out.println("Dog died!");
				}
			}
			//Render
			@Override
			public void render(Graphics g) {
				if(stand)
				{
					attackTickCount++;
					if(attackTickCount % 4 == 0)
					{
						g.drawImage(ImageManager.dogImages[7], (int)posX, (int)posY, width,height, null);
					}
					else if(attackTickCount % 4 == 1)
					{
						g.drawImage(ImageManager.dogImages[8], (int)posX+2, (int)posY, width,height, null);
					}
					
					else if(attackTickCount % 4 == 2)
					{
						g.drawImage(ImageManager.dogImages[9], (int)posX+4, (int)posY, width,height, null);
					}
					else if(attackTickCount % 4 == 3)
					{
						g.drawImage(ImageManager.dogImages[10], (int)posX, (int)posY, width,height, null);
					}
					
				}
				else
				{
					tickCount++;
					if(tickCount % 6 == 0)
					{
						g.drawImage(ImageManager.dogImages[1], (int)posX, (int)posY, width,height, null);
					}
					else if (tickCount % 6 == 1)
					{
						g.drawImage(ImageManager.dogImages[2], (int)posX, (int)posY, width,height, null);
					}
					else if (tickCount % 6 == 2)
					{
						g.drawImage(ImageManager.dogImages[3], (int)posX, (int)posY, width,height, null);
					}
					else if (tickCount % 6 == 3)
					{
						g.drawImage(ImageManager.dogImages[4], (int)posX, (int)posY, width,height, null);
					}

					else if (tickCount % 6 == 4)
					{
						g.drawImage(ImageManager.dogImages[5], (int)posX, (int)posY, width,height, null);
					}

					else if (tickCount % 6 == 5)
					{
						g.drawImage(ImageManager.dogImages[6], (int)posX, (int)posY, width,height, null);
					}
				}
			}
		
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

		public Rectangle getCollisionRectangle() 
		{
			return new Rectangle((int)posX, (int)posY, width, height);
		}
		
		@Override
		public boolean isAlive() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean updateHealth(int amount) {

			this.setHealth(this.getHealth()-amount);
			return true;
		}
		@Override
		public boolean updateSpeed(float amount) {

			this.setSpeed(ShopManager.getDogSpeed()+amount);
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
			this.setSpeed(ShopManager.getDogSpeed());
			return true;
		}
			
}
