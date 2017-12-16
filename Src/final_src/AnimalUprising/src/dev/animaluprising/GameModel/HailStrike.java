/*
 * @Author: Bora Ecer
 * @Class Name: HailStrike Class
 * @Version: 15.12.2016
 */
package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class HailStrike extends MinionObject implements Ally
{
	//Attributes
	private boolean hit;
	private int tickCount;

	//Constructor
	public HailStrike(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		hit = false;
		tickCount = 0;
	}

	//Update
	@Override
	public void update() {
		//If the skill did not hit an enemy
		if(!hit)
		{				
			//Checks the collision
			if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
			{
				//Sets hit true, which eventually stops rendering the image.
				hit = true;
				Ally.super.stand(this);
			}
			else
			{
				setSpeed(0f);
				setHeight(100);
				setWidth(100);
				super.update();

			}	
		}
	}
	//Render method for animation
	@Override
	public void render(Graphics g) {
		tickCount++;
		if(tickCount/4 % 4 == 0)
		{				
			g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-300, width-50,height-50, null);
		}
		else if(tickCount/4 % 4 == 1)
		{				
			g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-200, width-50,height-50, null);
		}
		else if(tickCount/4 % 4 == 2)
		{				
			g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-100, width-50,height-50, null);
		}
		else if(tickCount/4 % 4 == 3)
		{				
			g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY, width-50,height-50, null);
			this.remove();
		}

	}
	//gets collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	//non-functional methods
	@Override
	public boolean isAlive() {
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
