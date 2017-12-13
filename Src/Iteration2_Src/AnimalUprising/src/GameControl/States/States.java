package GameControl.States;

import java.awt.Graphics;

import GameControl.GameManager;

public abstract class States
{
	private static States currentState = null;
	protected GameManager gameManager;
	
	public States(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	public static void setState(States state)
	{
		currentState = state;
	}
	
	public static States getState()
	{
		return currentState;
	}
	
	public abstract void update();
	public abstract void render(Graphics graphics);
	
}
