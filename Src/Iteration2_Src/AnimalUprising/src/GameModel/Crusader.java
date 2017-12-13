/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Crusader Object.
 * Crusader is a extending class of Soldier, and implements Enemy and Melee interfaces.
 * Its has its own update() and render() methods. Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Crusader object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */


package GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import GameControl.CollisionManager;
import GameControl.GameManager;
import GameControl.ImageManager;

public class Crusader extends Soldier implements Enemy, Melee  {


	//Constructor
	public int tickCount = 0;
	public int attackTickCount = 0;
	public boolean stand = false;
	public Crusader(float posX, float posY, int width, int height, int health, GameManager gameManager)
	{
		super(posX, posY, width, height, health, gameManager);
	} 

	@Override
	public void update()
	{
		if(CollisionManager.collision(this, gameManager.getObjectManager().getAllies()))
		{
			Enemy.super.stand(this, gameManager);
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
				g.drawImage(ImageManager.crusaderImages[6], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount % 4 == 1)
			{
				g.drawImage(ImageManager.crusaderImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if (attackTickCount % 4 == 2)
			{
				g.drawImage(ImageManager.crusaderImages[8], (int)posX-3, (int)posY, width,height, null);
			}
			else if (attackTickCount % 4 == 3)
			{
				g.drawImage(ImageManager.crusaderImages[9], (int)posX-4, (int)posY, width,height, null);
			}
		}
		else
		{
			tickCount++;
			if(tickCount % 6 == 0)
			{
				g.drawImage(ImageManager.crusaderImages[0], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 1)
			{
				g.drawImage(ImageManager.crusaderImages[1], (int)posX, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 2)
			{
				g.drawImage(ImageManager.crusaderImages[2], (int)posX-3, (int)posY, width,height, null);
			}
			else if (tickCount % 6 == 3)
			{
				g.drawImage(ImageManager.crusaderImages[3], (int)posX-4, (int)posY, width,height, null);
			}

			else if (tickCount % 6 == 4)
			{
				g.drawImage(ImageManager.crusaderImages[4], (int)posX-5, (int)posY, width,height, null);
			}
			
			else if (tickCount % 6 == 5)
			{
				g.drawImage(ImageManager.crusaderImages[5], (int)posX-6, (int)posY, width,height, null);
			}
		}
	}


	public static void summon()
	{
		gameManager.getObjectManager().addObject(new Crusader(500,0,50,50,500, gameManager));
	}
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	
}
