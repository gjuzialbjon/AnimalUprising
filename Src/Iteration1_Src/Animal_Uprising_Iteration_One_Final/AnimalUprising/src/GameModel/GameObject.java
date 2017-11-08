/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Game Object.
 * Game Object is the main object in the GameModel, everything else is either inheriting from it directly,
 * or is an extention of one of GameObject's child classes. GameObject is an Abstract class 
 * which has update() and render() methods as abstract methods. it has several variables like x, y coordiantes of the object 
 * and height, width of the object image. GameObject, has a GameManager object and passes it through its child classes
 * which enables the GameModel package connecting to the GameControl package, thus enabling communication between two of the main subclasses.
 * Also, GameObject has a die() method which basicly removes the object from ObjectList arraylist which is in the ObjectManager object of GameManager.
 * NOTE: will be completed, in the future iteration.
 */




package GameModel;
import java.awt.Graphics;

import GameControl.GameManager;;

public abstract class GameObject
{
	protected float posX, posY;
	protected int height, width, health;
	protected static GameManager gameManager;

	public GameObject(float posX, float posY, int width,int height, int health, GameManager gameManager)
	{
		
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.health = health;
		this.gameManager = gameManager;
	}
	//Abstract methods
	public abstract void update();
	public abstract void render(Graphics g);
	
	//die method
	public void die()
	{
		//removes this object from ObjectList item of ObjectManager, which is in the gameObject.
		gameManager.getObjectManager().getObjects().remove(this);
		//Decreases the count of GameObjects in ObjectList 
		gameManager.getObjectManager().decreaseObjectCount();
	}
	
	//Getters and Setters
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
