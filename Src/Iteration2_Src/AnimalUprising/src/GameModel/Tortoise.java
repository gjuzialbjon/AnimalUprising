/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Tortoise Object.
 * Tortoise is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Tortoise object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */



package GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Tortoise extends Soldier implements Ally, Melee  {


	private float range = 2f;
	public Tortoise(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		
	} 

	//Update
		@Override
		public void update() {
			
				Ally.super.setDirection();
				super.update();
		}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ImageManager.catImage, (int)posX, (int)posY, width,height, null);
	}

	public static void summon()
	{
		gameManager.getObjectManager().addObject(new Tortoise(0,0,50,50,50, gameManager));
		
	}	
		
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
}
