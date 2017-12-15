package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class HailStrike extends Soldier implements Ally{
	private int damage;
	private boolean hit;
	private int tickCount;
	public HailStrike(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		damage = ShopManager.getMonkeyDamage();
		hit = false;
		tickCount = 0;
	}

	//Update
		@Override
		public void update() {
			if(!hit)
			{				
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
		}
		@Override
		public void render(Graphics g) {
			tickCount++;
			if(tickCount/2 % 4 == 0)
			{				
				g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-300, width-50,height-50, null);
			}
			else if(tickCount/2 % 4 == 1)
			{				
				g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-200, width-50,height-50, null);
			}
			else if(tickCount/2 % 4 == 2)
			{				
				g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY-100, width-50,height-50, null);
			}
			else if(tickCount/2 % 4 == 3)
			{				
				g.drawImage(ImageManager.ravenImages[0], (int)posX, (int)posY, width-50,height-50, null);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean decreaseSpeed() {
		// TODO Auto-generated method stub
		return false;
	}

}
