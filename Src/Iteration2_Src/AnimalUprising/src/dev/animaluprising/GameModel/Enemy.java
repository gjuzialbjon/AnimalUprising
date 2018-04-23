/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 13.12.2017
 * Sets starting point, the direction and the default speed of the enemies
 * Also sets the height and width.
 */

package dev.animaluprising.GameModel;

import java.awt.Rectangle;

import dev.animaluprising.GameControl.CollisionManager;

public interface Enemy
{
		public default  void setDirection(){
			float x = 700;
			setPosX(x); 
			setSpeed(-3.0f);
			float y = 400;
			setPosY(y);
			setHeight(100);
			setWidth(100);
		}
	
		//Sets the movement speed to 0
		public default void stand(Enemy enemy) {
			enemy.setSpeed(0);
			System.out.println(enemy.getClass().getName());
		}
		public void setPosX(float x);
		public void setSpeed(float x);
		public Rectangle getCollisionRectangle();	
		public boolean isAlive();
		public void setPosY(float y);
		public void setHeight(int h);
		public void setWidth(int w);
		public void updateHealth(int amount);
		
	
}
