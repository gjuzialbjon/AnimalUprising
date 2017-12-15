package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class MonkeyAttack extends Soldier implements Ally
{
	
	private int damage;
	private boolean hit;
	public MonkeyAttack(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		damage = ShopManager.getMonkeyDamage();
		hit = false;
	}

	//Update
		@Override
		public void update() {
			if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
			{
				hit = true;
				Ally.super.stand(this);
			}
			else
			{

				setSpeed(4.0f);
				setHeight(100);
				setWidth(100);
				super.update();
				
			}	
			
		}
		@Override
		public void render(Graphics g) {
			g.drawImage(ImageManager.monkeyAttackImage, (int)posX, (int)posY, width-50,height-50, null);
			if(hit)
			{
				this.remove();
			}
		}
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public boolean updateHealth(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderDead(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean updateSpeed(float amount) {

		return true;
	}
	@Override
	public boolean decreaseSpeed()
	{
		return true;
	}

	
}
