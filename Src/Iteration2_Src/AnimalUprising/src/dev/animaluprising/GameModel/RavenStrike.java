/*
 * Author: Bora Ecer
 * Date: 12.12.2017
 * Version: 14.12.2017
 * Class for RavenStrike's projectile attack.
 * Monkey is a extending class of MinionObject, and implements Ally interface.
 * Its has its own update() and render() methods.
 */
package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class RavenStrike extends MinionObject implements Ally
{
	private boolean hit;
	private int tickCount;
	public RavenStrike(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		hit = false;
		tickCount = 0;
	}

	//Update
	@Override
	public void update() {
		if(!hit)
		{				
			if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
			{
				hit = true;
				Ally.super.stand(this);
			}
			else
			{
				setSpeed(4.0f);
				setHeight(100);
				setWidth(100);
				super.update();
			}	
		}
	}
	//Render for raven animation
	@Override
	public void render(Graphics g) {
		tickCount++;
		if(tickCount / 2 % 4 == 0)
		{
			g.drawImage(ImageManager.ravenImages[4], (int)posX, (int)posY, width-50,height-50, null);
		}
		else if(tickCount/2 % 4 == 1)
		{
			g.drawImage(ImageManager.ravenImages[5], (int)posX, (int)posY, width-50,height-50, null);
		}
		else if(tickCount/2 % 4 == 2)
		{
			g.drawImage(ImageManager.ravenImages[6], (int)posX, (int)posY, width-50,height-50, null);
		}
		else if(tickCount/2 % 4 == 3)
		{
			g.drawImage(ImageManager.ravenImages[7], (int)posX, (int)posY, width-50,height-50, null);
		}
		//if hits, removes from ally list
		if(hit)
		{
			this.remove();
		}
	}
	//collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	//Nonfunctional methods.
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
