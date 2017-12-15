/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Interface for representing the allied classes.
 * interface will be improved. It is a non-factor for now.
 */

package dev.animaluprising.GameModel;

import java.awt.Rectangle;

import dev.animaluprising.GameControl.CollisionManager;

public interface Ally 
{

	public default  void setDirection(){
		float x = 0;
		setPosX(x);
		float y = 400;
		setPosY(y);
		setHeight(100);
		setWidth(100);
	}
	public default void stand(Ally ally) {
			ally.setSpeed(0);
	}
	
	
	
	public void setPosX(float x);
	public void setSpeed(float x);
	public Rectangle getCollisionRectangle();
	public boolean isAlive();
	public void setPosY(float y);
	public void setHeight(int h);
	public void setWidth(int w);
	public boolean updateHealth(int amount);
	public boolean updateSpeed(float amount);
	public boolean decreaseSpeed();
}
