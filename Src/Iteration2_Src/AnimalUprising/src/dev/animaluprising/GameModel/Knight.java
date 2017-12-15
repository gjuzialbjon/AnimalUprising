/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Knight Object.
 * Knight is a extending class of Soldier, and implements Enemy and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Knight object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */



package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class Knight extends Soldier implements Enemy  {


	private int damage;
	private int health;

	private boolean stand;
	private boolean dead;
	private int deathTick;
	private int attackTickCount, tickCount;
	public Knight(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);	
		health = LevelManager.getMaxKnightHealth();
		damage = LevelManager.getKnightDamage();
		stand = false;
		dead = false;
		attackTickCount = 0;
		tickCount = 0;
		deathTick = 0;
	
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
	public void update()
	{
		if(game.getCollisionManager().collision(this, game.getObjectManager().getAllies()))
		{
			Enemy.super.stand(this);
			stand = true;
		}
		else
		{
			Enemy.super.setDirection();
			super.update();
			stand = false;
		}
		if(this.getHealth() <= 0)
		{
			this.die();
			dead = true;
			System.out.println("Crusader died!");
		}
	}
	
	@Override
	public void render(Graphics g) {
		if(stand)
		{
			attackTickCount++;
			if(attackTickCount % 4 == 0)
			{
				g.drawImage(ImageManager.knightImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount % 4  == 1)
			{
				g.drawImage(ImageManager.knightImages[7], (int)posX+2, (int)posY, width,height, null);
			}
			
			else if(attackTickCount % 4 == 2)
			{
				g.drawImage(ImageManager.knightImages[8], (int)posX+4, (int)posY, width,height, null);
			}
			else if(attackTickCount % 4 == 3)
			{
				g.drawImage(ImageManager.knightImages[9], (int)posX+4, (int)posY, width,height, null);
			}
		}
		else
		{
			tickCount++;
			if(tickCount % 6 == 0)
			{
				g.drawImage(ImageManager.knightImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 1)
			{
				g.drawImage(ImageManager.knightImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 2)
			{
				g.drawImage(ImageManager.knightImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 3)
			{
				g.drawImage(ImageManager.knightImages[3], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 ==  4)
			{
				g.drawImage(ImageManager.knightImages[4], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 ==  5)
			{
				g.drawImage(ImageManager.knightImages[5], (int)posX, (int)posY, width,height, null);
			}

		}
	}

	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick % 4 == 0)
		{
			g.drawImage(ImageManager.knightImages[10], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick % 4 == 1)
		{
			g.drawImage(ImageManager.knightImages[11], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick % 4 == 2)
		{
			g.drawImage(ImageManager.knightImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick % 4 == 3)
		{
			g.drawImage(ImageManager.knightImages[13], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();

		}
		
	}
	public static void summon(int posX, int posY, int width, int height)
	{
	
		game.getObjectManager().addObject(new Knight(posX,posY,width,height));
		
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
	public void updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
	}
	public void setPosX(float x)
	{
		super.setPosX(x);
	}
	public void setPosY(float y)
	{
		super.setPosX(y);
	}
}
