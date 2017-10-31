package GameModel;
import java.awt.Graphics;

import GameControl.GameManager;;

public abstract class GameObject
{
	protected float posX, posY;
	protected int height, width, health;
	protected GameManager gameManager;
	
	public GameObject(float posX, float posY, int width,int height, int health, GameManager gameManager)
	{
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.health = health;
		this.gameManager = gameManager;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
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
