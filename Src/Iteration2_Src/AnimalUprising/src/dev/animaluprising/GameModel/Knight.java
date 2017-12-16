/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2016
 * Class that contains the attributes of Knight Object.
 * Knight is a extending class of MinionObject, and implements Enemy  interface.
 * Its has its own update() and render() methods.
 */



package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class Knight extends MinionObject implements Enemy  {


	private int damage;
	private int health;
	private boolean stand;
	private int deathTick;
	private int attackTickCount, tickCount;
	
	public Knight(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);	
		health = LevelManager.getMaxKnightHealth();
		damage = LevelManager.getKnightDamage();
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
	
	//Render
	@Override
	public void render(Graphics g) {
		//If standing, then object is attacking.
		if(stand)
		{
			//attack animation
			attackTickCount++;
			if(attackTickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.knightImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 4  == 1)
			{
				g.drawImage(ImageManager.knightImages[7], (int)posX+2, (int)posY, width,height, null);
			}
			
			else if(attackTickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.knightImages[8], (int)posX+4, (int)posY, width,height, null);
			}
			else if(attackTickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.knightImages[9], (int)posX+4, (int)posY, width,height, null);
			}
		}
		//else if object is not standing, then i must move
		else
		{
			//moveoment animation
			tickCount++;
			if(tickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.knightImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 1)
			{
				g.drawImage(ImageManager.knightImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.knightImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.knightImages[3], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 ==  4)
			{
				g.drawImage(ImageManager.knightImages[4], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 ==  5)
			{
				g.drawImage(ImageManager.knightImages[5], (int)posX, (int)posY, width,height, null);
			}

		}
	}
	//method for death animation
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick/2 % 4 == 0)
		{
			g.drawImage(ImageManager.knightImages[10], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick/2 % 4 == 1)
		{
			g.drawImage(ImageManager.knightImages[11], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick/2 % 4 == 2)
		{
			g.drawImage(ImageManager.knightImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 3)
		{
			g.drawImage(ImageManager.knightImages[13], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();

		}
		
	}
	//Summon method, which is a static method that is called by CastleObject, which adds one of this class's instances to the list.
	public static void summon(int posX, int posY, int width, int height)
	{
		game.getObjectManager().addObject(new Knight(posX,posY,width,height));	
	}

	//gets the collision rectangle
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
	//update health
	@Override
	public void updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
	}
	//getters and setters
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
