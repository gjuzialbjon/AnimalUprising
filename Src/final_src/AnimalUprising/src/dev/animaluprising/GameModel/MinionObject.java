/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 12.10.2017
 * Class that contains the attributes of Minion Object.
 * MinionObject is an subclass of CharacterObject. 
 * MinionObject is the parent class of Bear, Dog, Monkey, Tortoise, Crusader, 
 * Infantry, Knight, RavenStrike, HailStrike, HealSkill, SpeedBuffSkill and MonkeyAttack classes 
 */



package dev.animaluprising.GameModel;

public abstract class MinionObject extends CharacterObject 
{
	
	public MinionObject(float posX, float posY, int width, int height) 
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
	
	public void setSpeed(float x)
	{
		speed = x;
	}

}
