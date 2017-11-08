/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Hero Object.
 * HeroObject is an extention of CharacterObject.
 * HeroObject is the object for the Hero, which the user will be able to control
 * For the time being, the hero can move forward and backward, and summon two soldier.
 * HeroObject has render() and update() methods like the other subclasses of GameObject class, 
 * Also, the HeroObject has a method called getInput() which essentially, gets the input from 
 * the InputManager object within the GameManager object. With the given input, the HeroObject can forward and backward
 * and summon soldiers. Summoning soldier part is working for now, it will be improved with the addition of food requirement factor.
 * Also the skills of the object will be added in the future iterations.  
 * NOTE: will be completed, in the future iteration.
 */




package GameModel;

import java.awt.Graphics;
import GameControl.GameManager;
import GameControl.ImageManager;

public class HeroObject extends CharacterObject {

	private static int maxFood;
	private static int maxMana;
	private static int coins;
	private int food;
	private int mana;
	//TODO: ItemSet: ArrayList 
	
	public HeroObject(float posX, float posY, int width,int height, int health,GameManager gameManager) {
		super(posX, posY,  CharacterObject.DEFAULT_WIDTH, CharacterObject.DEFAULT_HEIGHT,health,gameManager);
		mana = 0;
		food = 0;
	}

	@Override
	public void update()
	{
		getInput();
		move();
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(ImageManager.heroImage, (int)posX, (int)posY, width,height, null);
	}
	
	private void getInput()
	{
		moveX = 0;
		//moveY = 0;
		if(gameManager.getInputManager().left)
		{
			moveX -= speed;
		}
		if(gameManager.getInputManager().right)
		{
			moveX += speed;
		}
		if(gameManager.getInputManager().summon1)
		{
			summonAlly(1);
		}
		if(gameManager.getInputManager().summon2)
		{
			//TODO
			summonAlly(2);

		}
		if(gameManager.getInputManager().summon3)
		{
			//TODO
			summonAlly(3);

		}
	}
	
	public void ravenStrike()
	{
		//TODO
	}
	
	public void hail()
	{
		//TODO
	}
	
	public void healNearbyAlly()
	{
		//TODO
	}
	
	public void speedBuff()
	{
		//TODO
	}
	
	public void die()
	{
		
	}
	
	public void summonAlly(int type)
	{
		if(type == 1)
		{
			Bear.summon();
			//TODO: summon cat
		}
		else if(type == 2)
		{
			Dog.summon();
		}
		else if(type == 3)
		{
			//Monkey.summon();
		}		
	}
	
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxFood() {
		return maxFood;
	}

	public void setMaxFood(int maxFood) {
		this.maxFood = maxFood;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	
}
