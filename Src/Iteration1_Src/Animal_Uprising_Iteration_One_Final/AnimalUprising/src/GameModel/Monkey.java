/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Monkey Object.
 * Monkey is a extending class of Soldier, and implements Ally and Melee interfaces.
 * Its has its own update() and render() methods, Update method calls for the Soldier's update() method and Render() only draws the image for now 
 * Also, it has its own summon() method, which adds creates and adds a Monkey object to ObjectList in 
 * ObjectManager object.
 * NOTE: will be completed, in the future iteration.
 */



package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Monkey extends Soldier implements Ally, Ranged  {

	public static boolean isCDMonkey;
	public static int cdTimeMonkey;
	
	public Monkey(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDMonkey = false;
		cdTimeMonkey = 175;
	
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
		if(!isCDMonkey)
		{
			gameManager.getObjectManager().addObject(new Monkey(0,0,50,50,50, gameManager));
			isCDMonkey = true;
			cdTimeMonkey = 175;
		}
	}	

	public int getSpawnCooldown() {
		return cdTimeMonkey;
	}

	public void decreaseSpawnCooldown() {
		cdTimeMonkey -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDMonkey;
	}
	public void setCooldown(boolean x)
	{
		isCDMonkey = x;
	}
	
	public void resetTimer()
	{
		cdTimeMonkey = 175;
	}

}
