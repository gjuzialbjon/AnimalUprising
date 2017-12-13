/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Castle Object.
 * CastleObject is a extending class of GameObject.
 * It has its own update() and render() methods, update() method is not functional for now, 
 * because of the cooldowns of summoning soldiers are not working properly. But, once its complete, 
 * the update() method will request summoning enemy soldier, which then each enemy object's 
 * cooldown will be checked in the summoning process, and if there is a soldier without a active cooldown, the enemy soldier will be summoned. 
 * NOTE: will be completed, in the future iteration.
 */




package GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import GameControl.GameManager;
import GameControl.ImageManager;

public class CastleObject extends GameObject implements Enemy
{

	public CastleObject(float posX, float posY, int width,int height, int health,GameManager gameManager) {
		super(posX, posY, width, height, health,gameManager);
		
	}
	
	@Override
	public void update()
	{
		//TODO: cooldown systems will be completed
		summonEnemy();
	}

	@Override
	public void render(Graphics g)
	{
		//TODO:Animations will be added
		g.drawImage(ImageManager.castleImage, (int)posX, (int)posY, width,height, null);		
	}
	
	public void summonEnemy()
	{
			//TODO: Other types of enemy soldier will be added.
			Crusader.summon();
	}

	@Override
	public void setSpeed(float x) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

}
