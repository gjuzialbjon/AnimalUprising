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
	public void setCooldown()
	{
		isCDKnight = false;
	}
	public void resetTimer()
	{
		cdTimeKnight = 175;
	}
	
}
