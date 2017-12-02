package dev.animalgame.entities.creatures.enemies;

import java.awt.Graphics;

public interface Enemy {

	public default  void tick(){
		setxMove(-getSpeed());
		move();
	}
	
	
	public void render(Graphics g);//THIS WAS ADDED WHILE WRITING THE RENDER IN EntityManager, CHECK THIS AND MAKE SURE THIS IS PROPER
	
	
	public void setxMove(float x);
	public float getSpeed();
	public void move();
}
