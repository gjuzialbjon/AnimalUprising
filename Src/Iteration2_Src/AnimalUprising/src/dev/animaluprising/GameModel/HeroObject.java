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




package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class HeroObject extends CharacterObject implements Ally {

	private int food;
	private int mana;
	private boolean cantMoveForward;
	private int health;
	private int tickCount;
	private int castingTickCount, deathTick;
	private boolean stand, casting;
	private Timer speedTimer;

	
	public HeroObject(float posX, float posY, int width,int height) {
		super(posX, posY,  CharacterObject.DEFAULT_WIDTH, CharacterObject.DEFAULT_HEIGHT);
		mana = 0;
		food = 0;
		health = ShopManager.getMaxHeroHealth();
		cantMoveForward = false;
		stand = false;
		castingTickCount = 0;
		casting = false;
		deathTick++;
		setSpeed(ShopManager.getHeroSpeed());
		speedTimer = new Timer();
	}

	
	//Update
	@Override
	public void update() {
		
		if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
		{
			
			cantMoveForward = true;
			getInput();
			move();
		}
		else
		{
			cantMoveForward = false;
			getInput();
			move();
			
		}	
		if(this.getHealth() <= 0)
		{
			this.die();
			System.out.println("Hero died!");
		}
		else 
		{
			if(mana < ShopManager.getMaxLHeroMana())
			{
				setMana(getMana()+5); 
			}
			if(food < ShopManager.getMaxHeroFood())
			{
				setFood(getFood()+1);
			}
		}
	}
	
	

	@Override
	public void render(Graphics g)
	{
		if(!casting)
		{
			if(stand)
			{
				g.drawImage(ImageManager.heroImages[11], (int)posX, (int)posY, width,height, null);
				
			}
			else
			{
				tickCount++;
				if(tickCount % 7 == 0)
				{
					g.drawImage(ImageManager.heroImages[0], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 7 == 1)
				{
					g.drawImage(ImageManager.heroImages[1], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 7 == 2)
				{
					g.drawImage(ImageManager.heroImages[2], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount % 7 == 3)
				{
					g.drawImage(ImageManager.heroImages[3], (int)posX, (int)posY, width,height, null);
				}
	
				else if (tickCount % 7 == 4)
				{
					g.drawImage(ImageManager.heroImages[4], (int)posX, (int)posY, width,height, null);
				}
	
				else if (tickCount % 7 == 5)
				{
					g.drawImage(ImageManager.heroImages[5], (int)posX, (int)posY, width,height, null);
				}
	
				else if (tickCount % 7 == 6)
				{
					g.drawImage(ImageManager.heroImages[6], (int)posX, (int)posY, width,height, null);
				}
				stand = true;
			}
		}
		else {
			castingTickCount++;
			if(castingTickCount % 4 == 0)
			{
				g.drawImage(ImageManager.heroImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount % 4 == 1)
			{
				g.drawImage(ImageManager.heroImages[8], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount % 4 == 2)
			{
				g.drawImage(ImageManager.heroImages[9], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount % 4 == 3)
			{
				g.drawImage(ImageManager.heroImages[10], (int)posX, (int)posY, width,height, null);
				casting = false;
			}
		}
		g.drawString("Food: " + this.getFood(), 50, 850);
		g.drawString("Mana: " + this.getMana(), 50, 875);
	}
	
	private void getInput()
	{
		moveX = 0;
		if(game.getKeyManager().left)
		{
			moveX -= speed;
			stand = false;
		}
		if(cantMoveForward == false)
		{
			if(game.getKeyManager().right)
			{
				moveX += speed;
				stand = false;
			}
		}
		if(game.getKeyManager().summon1)
		{
			summonAlly(1);
		}
		if(game.getKeyManager().summon2)
		{
			//TODO
			summonAlly(2);

		}
		if(game.getKeyManager().summon3)
		{
			//TODO
			summonAlly(3);
		}
		if(game.getKeyManager().summon4)
		{
			summonAlly(4);
		}
		if(game.getKeyManager().skill1)
		{
			castSkill(1);
		}
		if(game.getKeyManager().skill2)
		{
			castSkill(2);
		}
		if(game.getKeyManager().skill3)
		{
			castSkill(3);
		}
		if(game.getKeyManager().skill4)
		{
			castSkill(4);
		}
	}
	
	public void castSkill(int type)
	{
		if(type == 1 && !game.getObjectManager().getHealCD() && this.getMana() >= ShopManager.getHealRequiredMana())
		{
			setMana(getMana()-ShopManager.getHealRequiredMana());
			game.getObjectManager().addObject(new HealSkill(posX-5, posY, width+10, height+30));
			casting = true;
		}
		else if(type == 2 && !game.getObjectManager().isSpeedCD() && this.getMana() >= ShopManager.getSpeedRequiredMana())
		{

			setMana(getMana()-ShopManager.getSpeedRequiredMana());
			game.getObjectManager().addObject(new SpeedBuffSkill(posX-5, posY, width, height));
			casting = true;
		}
		else if(type == 3 && !game.getObjectManager().isHailCD() && this.getMana() >= ShopManager.getHailRequiredMana() )
		{

			setMana(getMana()-ShopManager.getHailRequiredMana());
			game.getObjectManager().addObject(new HailStrike(posX+100, posY, width, height));
			casting = true;
		}
		else if(type == 4 && !game.getObjectManager().isRavenCD() && this.getMana() >= ShopManager.getRavenRequiredMana())
		{

			setMana(getMana()-ShopManager.getRavenRequiredMana());
			game.getObjectManager().addObject(new RavenStrike(posX, posY, 10, 10));
			casting = true;
		}
	}
	public void summonAlly(int type)
	{
		if(type == 1 && this.getFood() >= ShopManager.getBearRequiredFood() && !game.getObjectManager().isBearCD())
		{

			setFood(getFood()-ShopManager.getBearRequiredFood());
			Bear.summon();
			//TODO: summon cat
		}
		else if(type == 2 && this.getFood() >= ShopManager.getDogRequiredFood() && !game.getObjectManager().isDogCD())
		{
			setFood(getFood()-ShopManager.getDogRequiredFood());
			Dog.summon();
		}
		else if(type == 3 && this.getFood() >= ShopManager.getMonkeyRequiredFood() && !game.getObjectManager().isMonkeyCD())
		{
			setFood(getFood()-ShopManager.getMonkeyRequiredFood());
			Monkey.summon();
		}	
		else if(type == 4 && this.getFood() >= ShopManager.getTortoiseRequiredFood() && !game.getObjectManager().isTortoiseCD())
		{
			setFood(getFood()-ShopManager.getTortoiseRequiredFood());
			Tortoise.summon();
		}
	}


	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	@Override
	public void setSpeed(float x) {
		speed = x;
	}
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}

	@Override
	public boolean isAlive() {
		if(this.getHealth() <= 0)
		{

			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		return true;
	}
	@Override
	public void renderDead(Graphics g)
	{
		deathTick++;
		if(deathTick % 4 == 0)
		{
			g.drawImage(ImageManager.heroImages[12], (int)posX, (int)posY, width,height, null);
			
		}
		else if(deathTick % 4 == 1)
		{
			g.drawImage(ImageManager.heroImages[13], (int)posX, (int)posY, width,height, null);
	
		}
		else if(deathTick % 4 == 2)
		{
			g.drawImage(ImageManager.heroImages[14], (int)posX, (int)posY, width,height, null);

		}
		else if(deathTick % 4 == 3)
		{
			g.drawImage(ImageManager.heroImages[15], (int)posX, (int)posY, width,height, null);
			this.removeFromDead();
		}
		
	}
	@Override
	public boolean updateSpeed(float amount) {

		this.setSpeed(ShopManager.getHeroSpeed()+amount);
		speedTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				decreaseSpeed();
			}
		}, 400);
		return true;
		
	}
	@Override
	public boolean decreaseSpeed()
	{
		this.setSpeed(ShopManager.getHeroSpeed());
		speedTimer.cancel();
		return true;
	}
		
	
}
