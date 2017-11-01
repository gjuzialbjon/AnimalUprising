package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Bear extends Soldier implements Ally, Melee {

	public static boolean isCDBear;
	public static int cdTimeBear;
	public Bear(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);
		isCDBear = false;
		cdTimeBear = 175;
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
		if(!isCDBear)
		{
			gameManager.getObjectManager().addObject(new Bear(0,0,50,50,50, gameManager));
			isCDBear = true;
			cdTimeBear = 175;
		}
	}
	public int getSpawnCooldown() {
		return cdTimeBear;
	}

	public void decreaseSpawnCooldown() {
		cdTimeBear -= 1; 
	}
	
	public boolean isCooldown() {
		return isCDBear;
	}

	public void setCooldown()
	{
		isCDBear = false;
	}
	
	public void resetTimer()
	{
		cdTimeBear = 175;
	}

}
