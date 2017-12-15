/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Castle Object.
 * CastleObject is a extending class of GameObject.
 * It has its own update() and render() methods, update() method is not functional for now, 
 * because of the cooldowns of summoning soldiers are not working properly. But, once its complete, 
 * the update() method will request summoning enemy soldier, which then each enemy object's 
 * cooldown will be checked in the summoning process, and if there is a soldier without a active cooldown, the enemy soldier will be summoned. 
 * NOTE: will be completed, in the future iteration.
 */




package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;

public class CastleObject extends GameObject implements Enemy
{
	private int health;
	private int tickCountInfantry = 0;
	private int tickCountKnight = 0;
	private int tickCountCrusader = 0;
	public CastleObject(float posX, float posY, int width,int height) {
		super(posX, posY, width, height);
		health = LevelManager.getMaxCastleHealth();
	
		
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
				//TODO: cooldown systems will be completed
		if(this.getHealth() > 0)
		{
			game.getCollisionManager().collision(this, game.getObjectManager().getAllies());
			tickCountCrusader++;
			tickCountKnight++;
			tickCountInfantry++;
			if(tickCountInfantry % 110 == 0)
			{
				summonEnemy(1);
			}
		    if(tickCountKnight % 290 == 0)
			{
				summonEnemy(2);
			}
			if(tickCountCrusader % 470 == 0)
			{
				summonEnemy(3);
			}

		}
		else if (this.getHealth() <= 0)
		{
			this.die();
		}
	}

	@Override
	public void render(Graphics g)
	{
		//TODO:Animations will be added
		g.drawImage(ImageManager.castleImage, (int)posX, (int)posY, width,height, null);		
	}
	
	public void summonEnemy(int type)
	{
		if(type == 1 && !game.getObjectManager().isInfantryCD())
		{
			Infantry.summon((int)posX, (int)posY, width,height);
		}
		else if(type == 2 && !game.getObjectManager().isKnightCD())
		{
			Knight.summon((int)posX, (int)posY, width,height);
		}
		else if(type == 3 && !game.getObjectManager().isCrusaderCD())
		{
			Crusader.summon((int)posX, (int)posY, width,height);
		}
	}

	@Override
	public void setSpeed(float x) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void renderDead(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
