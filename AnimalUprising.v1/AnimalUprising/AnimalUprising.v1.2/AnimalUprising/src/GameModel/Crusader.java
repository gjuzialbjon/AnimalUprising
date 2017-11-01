package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Crusader extends Soldier implements Enemy, Melee  {

	public static boolean isCDCrusader = false;
	public static int cdTimeCrusader = 175;
	
	public Crusader(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
	
	
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

	
	public int getSpawnCooldown() {
		return cdTimeCrusader;
	}

	public void decreaseSpawnCooldown() {
		cdTimeCrusader -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDCrusader;
	}
	
	public void setCooldown()
	{
		isCDCrusader = false;
	}
	public void resetTimer()
	{
		cdTimeCrusader = 175;
	}
	
}
