package GameModel;

import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class CastleObject extends GameObject 
{

	public CastleObject(float posX, float posY, int width,int height, int health,GameManager gameManager) {
		super(posX, posY, width, height, health,gameManager);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(ImageManager.castleImage, (int)posX, (int)posY, width,height, null);		
	}

}
