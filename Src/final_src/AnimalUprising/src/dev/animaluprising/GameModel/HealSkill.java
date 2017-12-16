/*
 * Author: Bora Ecer
 * Version: 14.12.2016
 * HealSkill class
 */

package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;

public class HealSkill extends MinionObject implements Ally 
{
	//Attribute
	private int numOfTicks;
	//Constructor
	public HealSkill(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		numOfTicks = 0;
	}

	//Update
	@Override
	public void update() {
		//Checks collision
		if(game.getCollisionManager().helpfullSkillCollision(this, game.getObjectManager().getAllies()))
		{
			Ally.super.stand(this);
			numOfTicks++;
		}
		else
		{
			numOfTicks++;
			setSpeed(0f);
			setHeight(100);
			setWidth(300);
			super.update();

		}	
		//Removes after a point.
		if(numOfTicks == 50)
		{
			this.remove();
		}
	}
	//Render method for animation.
	@Override
	public void render(Graphics g) {
		if(numOfTicks < 5 )
		{
			g.drawImage(ImageManager.healSkillImages[0], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 5 && numOfTicks < 10 )
		{
			g.drawImage(ImageManager.healSkillImages[1], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 10 && numOfTicks < 15 )
		{
			g.drawImage(ImageManager.healSkillImages[2], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 15 && numOfTicks < 20 )
		{
			g.drawImage(ImageManager.healSkillImages[3], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 20 && numOfTicks < 30 )
		{
			g.drawImage(ImageManager.healSkillImages[4], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 30 && numOfTicks < 35 )
		{
			g.drawImage(ImageManager.healSkillImages[3], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 35 && numOfTicks < 40 )
		{
			g.drawImage(ImageManager.healSkillImages[2], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 40 && numOfTicks < 45 )
		{
			g.drawImage(ImageManager.healSkillImages[1], (int)posX, (int)posY-50, width,height+50, null);

		}
		else if(numOfTicks > 45 && numOfTicks < 50 )
		{
			g.drawImage(ImageManager.healSkillImages[0], (int)posX, (int)posY-50, width,height+50, null);

		}


	}

	//Collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX-20, (int)posY, width+40, height);
	}

	//Non-functional methods
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHealth(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderDead(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updateSpeed(float amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean decreaseSpeed() {
		// TODO Auto-generated method stub
		return false;
	}


}
