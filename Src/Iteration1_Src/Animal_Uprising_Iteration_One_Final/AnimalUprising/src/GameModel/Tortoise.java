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

import GameControl.GameManager;
import GameControl.ImageManager;

public class Tortoise extends Soldier implements Enemy, Melee  {

	public static boolean isCDTortoise;
	public static int cdTimeTortoise;
	public Tortoise(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDTortoise = false;
		cdTimeTortoise = 175;
		// TODO Auto-generated constructor stub
	} 

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ImageManager.catImage, (int)posX, (int)posY, width,height, null);
	}

	public static void summon()
	{
		if(!isCDTortoise)
		{
			gameManager.getObjectManager().addObject(new Tortoise(0,0,50,50,50, gameManager));
			isCDTortoise = true;
			cdTimeTortoise = 175;
		}
	}	
	public int getSpawnCooldown() {
		return cdTimeTortoise;
	}

	public void decreaseSpawnCooldown() {
		cdTimeTortoise -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDTortoise;
	}
	
	public void setCooldown(boolean x)
	{
		isCDTortoise = x;
	}
	
	
	public void resetTimer()
	{
		cdTimeTortoise = 175;
	}
	
}
