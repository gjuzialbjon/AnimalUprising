/*
 * Author: Bora Ecer
 * Date: 12.12.2017
 * Version: 14.12.2017
 * Class for monkey's projectile attack.
 * Monkey is a extending class of MinionObject, and implements Ally interface.
 * Its has its own update() and render() methods.
 */
package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class MonkeyAttack extends MinionObject implements Ally
{
	//attribute
	private boolean hit;
	//constructor
	public MonkeyAttack(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
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

			setSpeed(2.0f);
			setHeight(100);
			setWidth(100);
			super.update();

		}	

	}
	//renders projectile image, after its hit, removes it from the ally list.
	@Override
	public void render(Graphics g) {
		g.drawImage(ImageManager.monkeyAttackImage, (int)posX, (int)posY, width-50,height-50, null);
		if(hit)
		{
			this.remove();
		}
	}
	//collision rectangle
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	//non functional methods
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
