package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Infantry extends Soldier implements Enemy, Melee  {

	public static boolean isCDInfantry;
	public static int cdTimeInfantry;
	
	public Infantry(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDInfantry = false;
		cdTimeInfantry = 175;
	
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
		if(!isCDInfantry)
		{
			gameManager.getObjectManager().addObject(new Infantry(0,0,50,50,50, gameManager));
			isCDInfantry = true;
			cdTimeInfantry = 175;
		}
	}	
	
	public int getSpawnCooldown() {
		return cdTimeInfantry;
	}

	public void decreaseSpawnCooldown() {
		cdTimeInfantry -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDInfantry;
	}

	public void setCooldown()
	{
		isCDInfantry = false;
	}
	
	public void resetTimer()
	{
		cdTimeInfantry = 175;
	}
	
	
}
