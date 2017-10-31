package GameModel;

import java.awt.Color;
import java.awt.Graphics;

import GameControl.GameManager;
import GameControl.ImageManager;

public class Soldier extends CharacterObject
{
	private int spawnCooldown;
	private int cost;
	private boolean cooldown;

	public Soldier(float posX, float posY, int width, int height, GameManager gameManager) {
		super(posX, posY, width, height, gameManager);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onSpawnCooldown()
	{
		return cooldown;
	}

	@Override
	public void update() {
		moveX = 0;
		moveX += speed;
		move();
		
	}

	@Override
	public void render(Graphics g) 
	{

		g.drawImage(ImageManager.catImage, (int)posX, (int)posY, width,height, null);
		
	}
	
	
	
}
