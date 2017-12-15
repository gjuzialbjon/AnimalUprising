/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Soldier Object.
 * SoldierObject is an subclass of CharacterObject. 
 * SoldierObject is the parent class of Bear, Dog, Monkey, Tortoise, Crusader, Infantry and Knight classes 
 * NOTE: will be completed, in the future iteration.
 * It has update() method for only the the Allied objects: Bear, Dog, Monkey and Tortoise.
 * it is just added for making it easier to implement for this iteration, 
 * since the enemy soldier summoning does not really work properly. 
 * Once it is done update() method will be distributed to every subclass.
 */



package dev.animaluprising.GameModel;

import java.awt.Graphics;


public abstract class Soldier extends CharacterObject 
{
	private int spawnCooldown;
	private int cost;
	private boolean cooldown;
	private int id;
	
	public Soldier(float posX, float posY, int width, int height) 
	{
		super(posX, posY, width, height);
	}
	
	@Override
	public void update() {
		
		moveX += speed;
		move();
		
	}
	
	public float getPosX()
	{
		return super.getPosX();
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
	public void setSpeed(float x)
	{
		speed = x;
	}

}
