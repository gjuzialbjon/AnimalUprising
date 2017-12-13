/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Infantry Object.
 * Infantry is a extending class of Soldier, and implements Enemy and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Infantry object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */


package GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Infantry extends Soldier implements Enemy, Melee  {


	private float range = 2f;
	//Constructor
	public Infantry(float posX, float posY, int width, int height, int health, GameManager gameManager) 
	{
		super(posX, posY, width, height, health, gameManager);
	
	} 

	//Update
	@Override
	public void update()
	{
		
			Enemy.super.setDirection();
			super.update();
		
	
	}
	
	//Render
	@Override
	public void render(Graphics g) 
	{
		//TODO Image will be replaced with animations
		g.drawImage(ImageManager.enemyImage, (int)posX, (int)posY, width,height, null);
	}
	
	//Summon
	public static void summon()
	{
		
			gameManager.getObjectManager().addObject(new Infantry(200,0,50,50,50, gameManager));
	
	
	}

	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	
}
