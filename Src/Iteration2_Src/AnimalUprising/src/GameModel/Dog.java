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


package GameModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import GameControl.CollisionManager;
import GameControl.GameManager;
import GameControl.ImageManager;

public class Dog extends Soldier implements Ally, Melee  
{
	private float range = 2f;
	private boolean stand = false;
	public int tickCount = 0;
	public int attackTickCount = 0;
	public Dog(float posX, float posY, int width, int height, int health, GameManager gameManager)
	{
		super(posX, posY, width, height, health, gameManager);
	}	
	
	//Update
		@Override
		public void update() {
			if(CollisionManager.collision(this, gameManager.getObjectManager().getEnemies()))
			{
				Ally.super.stand(this, gameManager);
				stand = true;
			}
			else
			{
				stand = false;
				Ally.super.setDirection();
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

		//Summon method
		public static void summon()
		{
		
				gameManager.getObjectManager().addObject(new Dog(0,0,50,50,600, gameManager));
			
		}

		public Rectangle getCollisionRectangle() 
		{
			return new Rectangle((int)posX, (int)posY, width, height);
		}
		
}
