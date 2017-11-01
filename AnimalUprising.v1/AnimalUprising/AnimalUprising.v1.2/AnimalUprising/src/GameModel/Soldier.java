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
	private int id;
	
	public Soldier(float posX, float posY, int width, int height, int health, GameManager gameManager) {
		super(posX, posY, width, height, health ,gameManager);
		// TODO Auto-generated constructor stub
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
		
	}
	
	public int getSpawnCooldown() {
		return spawnCooldown;
	}

	public void setSpawnCooldown(int spawnCooldown) {
		this.spawnCooldown = spawnCooldown;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isCooldown() {
		return cooldown;
	}

	public void setCooldown(boolean cooldown) {
		this.cooldown = cooldown;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean onSpawnCooldown()
	{
		return cooldown;
	}
	

}
