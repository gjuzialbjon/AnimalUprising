/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Interface for representing the enemy classes.
 * interface will be improved. It is a non-factor for now.
 */

package dev.animaluprising.GameModel;

import java.awt.Rectangle;

import dev.animaluprising.GameControl.CollisionManager;

public interface Enemy
{
		public default  void setDirection(){
			float x = 800;
			setPosX(x); 
			setSpeed(-3.0f);
			float y = 800;
			setPosY(y);
			setHeight(100);
			setWidth(100);
		}
	
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
