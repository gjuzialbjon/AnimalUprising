/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Knight Object.
 * Knight is a extending class of Soldier, and implements Enemy and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Knight object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */



package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Knight extends Soldier implements Enemy, Melee  {

	public static boolean isCDKnight;
	public static int cdTimeKnight;
	
	public Knight(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDKnight = false;
		cdTimeKnight = 175;
	
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
		if(!isCDKnight)
		{
			gameManager.getObjectManager().addObject(new Knight(0,0,50,50,50, gameManager));
			isCDKnight = true;
			cdTimeKnight = 175;
		}
	}	
	
	public int getSpawnCooldown() {
		return cdTimeKnight;
	}

	public void decreaseSpawnCooldown() {
		cdTimeKnight -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDKnight;
	}

	public void resetcdTimeKnight()
	{
		cdTimeKnight = 175;
	}
	public void setCooldown(boolean x)
	{
		isCDKnight = x;
	}
	
	public void resetTimer()
	{
		cdTimeKnight = 175;
	}
	
}
