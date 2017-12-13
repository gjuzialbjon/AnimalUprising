/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Interface for representing the enemy classes.
 * interface will be improved. It is a non-factor for now.
 */

package GameModel;

import java.awt.Rectangle;

import GameControl.CollisionManager;
import GameControl.GameManager;

public interface Enemy
{
		public default  void setDirection(){
			float x = 500;
			setPosX(x); 
			setSpeed(-3.0f);
		}
	
		public default void stand(Enemy enemy, GameManager gameManager) {
			enemy.setSpeed(0);
		}
		public void setPosX(float x);
		public void setSpeed(float x);
		public Rectangle getCollisionRectangle();	
		public boolean isAlive();
	
	
}
