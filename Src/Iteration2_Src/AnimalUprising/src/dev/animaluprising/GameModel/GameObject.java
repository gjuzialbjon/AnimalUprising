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




package dev.animaluprising.GameModel;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.GameManager;;

public abstract class GameObject
{
	protected float posX, posY;
	protected int height, width;
	protected static GameManager game=GameManager.getGame();

	public GameObject(float posX, float posY, int width,int height)
	{
		
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
	//Abstract methods
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void renderDead(Graphics g);
	
	
	//die method, which will include the death animation
	public void die()
	{
		//removes this object from ObjectList item of ObjectManager, which is in the gameObject.
		if(this instanceof Ally)
		{
			game.getObjectManager().getDeadObjects().add(this);
			game.getObjectManager().increaseDeadObjectCount();
			game.getObjectManager().getAllies().remove(this);
			//Decreases the count of GameObjects in ObjectList 
			game.getObjectManager().decreaseAllyCount();
		}
		else
		{

			game.getObjectManager().getDeadObjects().add(this);
			game.getObjectManager().increaseDeadObjectCount();
			game.getObjectManager().getEnemies().remove(this);
			game.getObjectManager().decreaseEnemyCount();
		}
	}
	//remove the object from the array lists, this will be used for the objects which are 
	//outside of the screen boundries.
	public void remove()
	{
		if(this instanceof Ally)
		{
			game.getObjectManager().getAllies().remove(this);
			//Decreases the count of GameObjects in ObjectList 
			game.getObjectManager().decreaseAllyCount();
		}
		else
		{
			game.getObjectManager().getEnemies().remove(this);
			game.getObjectManager().decreaseEnemyCount();
		}
	}
	public void removeFromDead()
	{
			game.getObjectManager().getDeadObjects().remove(this);
			//Decreases the count of GameObjects in ObjectList 
			game.getObjectManager().decreaseDeadObjectCount();
		
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

}
