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

import GameControl.GameManager;
import GameControl.ImageManager;

public class Crusader extends Soldier implements Enemy, Melee  {

	//Static variables
	public static boolean isCDCrusader = false;
	public static int cdTimeCrusader = 175;
	
	//Constructor
	public Crusader(float posX, float posY, int width, int height, int health, GameManager gameManager)
	{
		super(posX, posY, width, height, health, gameManager);
		isCDCrusader = false;
		cdTimeCrusader = 175;
	} 

	@Override
	public void update()
	{
		super.update();
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ImageManager.enemyImage, (int)posX, (int)posY, width,height, null);
	}


	public static void summon()
	{
		if(!isCDCrusader)
		{
			gameManager.getObjectManager().addObject(new Crusader(0,0,50,50,50, gameManager));
			isCDCrusader = true;
			cdTimeCrusader = 175;
		}
	}	

	
	public int getSpawnCooldown()
	{
		return cdTimeCrusader;
	}

	public void decreaseSpawnCooldown()
	{
		cdTimeCrusader -= 1; 
	}
	
	public boolean isCooldown()
	{
		return isCDCrusader;
	}
	
	public void setCooldown(boolean x)
	{
		isCDCrusader = x;
	}
	
	public void resetTimer()
	{
		cdTimeCrusader = 175;
	}
	
}
