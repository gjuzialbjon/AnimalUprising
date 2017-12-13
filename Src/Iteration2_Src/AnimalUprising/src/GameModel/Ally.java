/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Interface for representing the allied classes.
 * interface will be improved. It is a non-factor for now.
 */

package GameModel;

import java.awt.Rectangle;

import GameControl.CollisionManager;
import GameControl.GameManager;

public interface Ally 
{

	public default  void setDirection(){
		float x = 0;
		setPosX(x); 
		setSpeed(4.0f);
	}
	public default void stand(Ally ally, GameManager gameManager) {
			ally.setSpeed(0);
	}
	
	
	public void setPosX(float x);
	public void setSpeed(float x);
	public Rectangle getCollisionRectangle();
	public boolean isAlive();
	
}
