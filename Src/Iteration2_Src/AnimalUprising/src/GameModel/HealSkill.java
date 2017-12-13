package GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import GameControl.CollisionManager;
import GameControl.GameManager;
import GameControl.ImageManager;

public class HealSkill extends HeroObject implements Skills 
{

	public HealSkill(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health, gameManager);

	}

	@Override
	public void update() 
	{
		CollisionManager.helpfullSkillCollision(this, gameManager.getObjectManager().getAllies());
		super.update();
	}

	@Override
	public void render(Graphics g) {
		g.fillRect((int)super.getPosX(), (int)super.getPosY(), super.getWidth()+5, super.getHeight()+5);
	}

	public static void cast() 
	{
		//gameManager.getObjectManager().addObject(new HealSkill(50, 50, 55, 55,55,gameManager));
	}



	@Override
	public Rectangle getCollisionRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
