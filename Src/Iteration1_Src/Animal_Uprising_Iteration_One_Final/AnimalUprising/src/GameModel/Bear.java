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

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Bear extends Soldier implements Ally, Melee {
	
	//Static variables
	public static boolean isCDBear;
	public static int cdTimeBear;
	
	//Constructor
	public Bear(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDBear = false;
		cdTimeBear = 175;
	}

	//Update
	@Override
	public void update() {
		super.update();
	}
	
	//Render
	@Override
	public void render(Graphics g) {
		// TODO image will be replaced with animation
		g.drawImage(ImageManager.catImage, (int)posX, (int)posY, width,height, null);
	}

	//Summon method
	public static void summon()
	{
		if(!isCDBear)
		{
			gameManager.getObjectManager().addObject(new Bear(0,0,50,50,50, gameManager));
			isCDBear = true;
			cdTimeBear = 175;
		}
	}
	
	//Methods for cooldown
	public int getSpawnCooldown() {
		return cdTimeBear;
	}

	public void decreaseSpawnCooldown() {
		cdTimeBear -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDBear;
	}

	public void setCooldown(boolean x)
	{
		isCDBear = x;
	}
	
	public void resetTimer()
	{
		cdTimeBear = 175;
	}

}
