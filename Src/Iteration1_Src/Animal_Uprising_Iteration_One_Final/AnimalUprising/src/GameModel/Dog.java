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

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Dog extends Soldier implements Ally, Melee  
{
	public static boolean isCDDog;
	public static int cdTimeDog;
	

	public Dog(float posX, float posY, int width, int height, int health, GameManager gameManager)
	{
		super(posX, posY, width, height, health, gameManager);
		isCDDog = false;
		cdTimeDog = 175;
	
	}	
	
	@Override
	public void update()
	{
		super.update();
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(ImageManager.dogImage, (int)posX, (int)posY, width,height, null);
	}
	

	public static void summon()
	{
		if(!isCDDog)
		{
			isCDDog = true;
			gameManager.getObjectManager().addObject(new Dog(0,0,50,50,50, gameManager));
			cdTimeDog = 175;
		}
	}	
	
	public int getSpawnCooldown() {
		return cdTimeDog;
	}

	public void decreaseSpawnCooldown() {
		cdTimeDog -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDDog;
	}
	
	public void setCooldown(boolean x)
	{
		isCDDog = x;
	}
	public void resetTimer()
	{
		cdTimeDog = 175;
	}
}
