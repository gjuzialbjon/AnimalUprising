package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Dog extends Soldier implements Ally, Melee  
{
	public static boolean isCDDog;
	public static int cdTimeDog;
	

	public Dog(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDDog = false;
		cdTimeDog = 175;
	
	}	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
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
	public void setCooldown()
	{
		isCDDog = false;
	}
	public void resetTimer()
	{
		cdTimeDog = 175;
	}
}
