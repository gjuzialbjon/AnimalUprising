/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Bear Object.
 * Bear is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Bear object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */


package GameModel;
import GameControl.CollisionManager;
import java.awt.Graphics;
import java.awt.Rectangle;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Bear extends Soldier implements Ally, Melee {
	

	private float range = 2f;
	//Constructor
	public Bear(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
	}

	//Update
	@Override
	public void update() {
		if(CollisionManager.collision(this, gameManager.getObjectManager().getEnemies()))
		{
			Ally.super.stand(this, gameManager);
		}
		else
		{
			Ally.super.setDirection();
			super.update();
			
		}	
		if(this.getHealth() <= 0)
		{
			this.die();
			System.out.println("Bear died!");
		}
	}
	
	//Render
	@Override
	public void render(Graphics g) {
		g.drawImage(ImageManager.catImage, (int)posX, (int)posY, width,height, null);
	}

	//Summon method
	public static void summon()
	{
	
			gameManager.getObjectManager().addObject(new Bear(0,0,50,50,600, gameManager));
		
	}
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	
	
	
}
