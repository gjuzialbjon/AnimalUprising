/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * Class that contains the attributes of Infantry Object.
 * Infantry is a extending class of MinionObject, and implements Enemy and interface.
 * Its has its own update() and render() methods.
 * Also, it has its own summon() method, which adds creates and adds a Infantry object to enemiesList in 
 * ObjectManager object.
 */


package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class Infantry extends MinionObject implements Enemy  {

	//Attributes
	private int damage;
	private int health;
	private boolean stand;
	private int tickCount;
	private int deathTick;
	private int attackTickCount;

	//Constructor
	public Infantry(float posX, float posY, int width, int height) 
	{
		super(posX, posY, width, height);
		health = LevelManager.getMaxInfantryHealth();
		damage = LevelManager.getInfantryDamage();
		tickCount = 0;
		deathTick = 0;
		attackTickCount = 0;
		stand = false;

	} 
	//Update
	@Override
	public void update()
	{
		//Checks collision
		if(game.getCollisionManager().collision(this, game.getObjectManager().getAllies()))
		{
			//Sets movement speed to 0
			Enemy.super.stand(this);
			stand = true;
		}
		else
		{
			Enemy.super.setDirection();
			super.update();
			stand = false;
		}
		//Checks health, if <= 0, calls die() for death animation
		if(this.getHealth() <= 0)
		{
			this.die();
		}
	}

	//Render
	@Override
	public void render(Graphics g) {
		//If stand then object is attacking
		if(stand)
		{
			//Attack animation
			attackTickCount++;
			if(attackTickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.infantryImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 1)
			{
				g.drawImage(ImageManager.infantryImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.infantryImages[8], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.infantryImages[9], (int)posX, (int)posY, width,height, null);
			}
		}
		//If not standing then, object is moving
		else
		{
			//movement animation
			tickCount++;
			if(tickCount/2 % 6 == 0)
			{
				g.drawImage(ImageManager.infantryImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 1)
			{
				g.drawImage(ImageManager.infantryImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 2)
			{
				g.drawImage(ImageManager.infantryImages[2], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount/2 % 6 == 3)
			{
				g.drawImage(ImageManager.infantryImages[3], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 4)
			{
				g.drawImage(ImageManager.infantryImages[4], (int)posX, (int)posY, width,height, null);
			}

			else if (tickCount/2 % 6 == 5)
			{
				g.drawImage(ImageManager.infantryImages[5], (int)posX, (int)posY, width,height, null);
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
			g.drawImage(ImageManager.infantryImages[10], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 1)
		{
			g.drawImage(ImageManager.infantryImages[11], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 2)
		{
			g.drawImage(ImageManager.infantryImages[12], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick/2 % 4 == 3)
		{
			g.drawImage(ImageManager.infantryImages[13], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();
		}

	}
	//Summon
	public static void summon(int posX, int posY, int width, int height)
	{
		game.getObjectManager().addObject(new Infantry(posX,posY,width,height));
	}

	//Returns collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	//is Alive method
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
	//Update health method called by CollisionManager
	@Override
	public void updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
	}
	//Getters and setters
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
