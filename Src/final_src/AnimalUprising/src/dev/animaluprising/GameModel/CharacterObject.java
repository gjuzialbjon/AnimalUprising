/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * Class that contains the attributes of Character Object. 
 * CharacterObject is an abstract class, which is a subclass of GameObject, which has move() method in it.
 * CharacterObject is for the objects which can move. Since castle is not a moveable object, this class is necessary.
 */


package dev.animaluprising.GameModel;

public abstract class CharacterObject extends GameObject
{
	//Attributes
	public static final int DEFAULT_WIDTH = 80;
	public static final int DEFAULT_HEIGHT = 80;
	protected float moveX;
	protected float moveY;
	protected float speed;

	//Constructor
	public CharacterObject(float posX, float posY, int width,int height)
	{
		super(posX, posY, width, height);

	}

	//increases or decreases the posX of objects.
	public void move()
	{
		posX += moveX;
	}

	//Getters and Setters
	public float getMoveX() {
		return moveX;
	}

	public void setMoveX(float moveX) {
		this.moveX = moveX;
	}


	public float getMoveY() {
		return moveY;
	}


	public void setMoveY(float moveY) {
		this.moveY = moveY;
	}
	public void setSpeed(float x)
	{
		speed = x;
	}
	public void setPosX(float x)
	{
		super.setPosX(x);
	}
	public void setPosY(float y)
	{
		super.setPosY(y);
	}
}
