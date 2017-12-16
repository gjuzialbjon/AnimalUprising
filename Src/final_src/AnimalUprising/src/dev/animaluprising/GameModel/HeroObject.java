/*
 * @ author: Bora Ecer
 * @ date: 1 November 2017
 * @ version: 13.12.2017 
 * Class that contains the attributes of Hero Object.
 * HeroObject is an extention of CharacterObject and
 * it is the object which the user will be able to control.
 * HeroObject has render() and update() methods like the other subclasses of GameObject class, 
 * Also, the HeroObject has a method called getInput() which essentially, gets the input from 
 */

package dev.animaluprising.GameModel;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;

public class HeroObject extends CharacterObject implements Ally {

	//Attributes
	private int food;
	private int mana;
	private boolean cantMoveForward;
	private int health;
	private int tickCount;
	private int castingTickCount, deathTick, currencyTick;
	private boolean stand, casting;

	//Constructor
	public HeroObject(float posX, float posY, int width,int height) {
		super(posX, posY,  CharacterObject.DEFAULT_WIDTH, CharacterObject.DEFAULT_HEIGHT);
		mana = 0;
		food = 0;
		currencyTick = 0;
		castingTickCount = 0;
		deathTick = 0;
		cantMoveForward = false;
		stand = false;
		casting = false;
		health = ShopManager.getMaxHeroHealth();
		setSpeed(ShopManager.getHeroSpeed());
	}


	//Update
	@Override
	public void update() 
	{
		//Checks the enemy collision
		if(game.getCollisionManager().collision(this, game.getObjectManager().getEnemies()))
		{
			//If the hero collides with an enemy, then the Hero cannot move forward
			//But it can move backward
			cantMoveForward = true;
		}
		else
		{
			//There is no collision between the hero and an enemy object, so the hero can keep moving forward
			cantMoveForward = false;
		}	
		//gets the input from the KeyManager which is taken from the user and stored in the KeyManager,
		getInput();
		//Changes the position if there are such an input.
		move();
		//Checks the current health of the Hero, and if it is less than or equal to 0, then starts the death animation of the hero and ends the game.
		if(this.getHealth() <= 0)
		{
			this.die();
		}
		//Else it increases the current mana and the food if they are less then the maximum values.
		else 
		{
			currencyTick++;
			//The divisions are done to slow the process.
			if(currencyTick/5 % 2 == 0 )
			{
				if(mana < ShopManager.getMaxHeroMana())
				{
					setMana(getMana()+1); 
				}
				if(food < ShopManager.getMaxHeroFood())
				{
					setFood(getFood()+1);
				}
			}
		}
	}


	//Render method, which for arranging and drawing images of the Hero
	@Override
	public void render(Graphics g)
	{
		//If Hero is not casting a skill, then it is either moving or standing.
		if(!casting)
		{
			if(stand)
			{
				g.drawImage(ImageManager.heroImages[11], (int)posX, (int)posY, width,height, null);

			}
			/*
			 * If Hero is not standing, then it must be moving.
			 * So, the images are changed using tickCount, in order to make it an animation.
			 */
			else
			{
				tickCount++;
				if(tickCount/3 % 7 == 0)
				{
					g.drawImage(ImageManager.heroImages[0], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount/3 % 7 == 1)
				{
					g.drawImage(ImageManager.heroImages[1], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount/3 % 7 == 2)
				{
					g.drawImage(ImageManager.heroImages[2], (int)posX, (int)posY, width,height, null);
				}
				else if (tickCount/3 % 7 == 3)
				{
					g.drawImage(ImageManager.heroImages[3], (int)posX, (int)posY, width,height, null);
				}

				else if (tickCount/3 % 7 == 4)
				{
					g.drawImage(ImageManager.heroImages[4], (int)posX, (int)posY, width,height, null);
				}

				else if (tickCount/3 % 7 == 5)
				{
					g.drawImage(ImageManager.heroImages[5], (int)posX, (int)posY, width,height, null);
				}

				else if (tickCount/3 % 7 == 6)
				{
					g.drawImage(ImageManager.heroImages[6], (int)posX, (int)posY, width,height, null);
				}
				//At the end of the movement animation, the stand is set to true. In order to prevent move animation get into a loop.
				stand = true;
			}
		}
		//If the hero is casting, then the following animation will occur
		else {
			castingTickCount++;
			if(castingTickCount/2 % 4 == 0)
			{
				g.drawImage(ImageManager.heroImages[7], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount/2 % 4 == 1)
			{
				g.drawImage(ImageManager.heroImages[8], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount/2 % 4 == 2)
			{
				g.drawImage(ImageManager.heroImages[9], (int)posX, (int)posY, width,height, null);
			}
			else if (castingTickCount/2 % 4 == 3)
			{
				g.drawImage(ImageManager.heroImages[10], (int)posX, (int)posY, width,height, null);
				//Set to false in order to stop the casting animation get into a loop.
				casting = false;
			}
		}
	}
	//Method for rendering death animation.
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
			//Removes the object from the deadObjects list.
			this.removeFromDead();
		}

	}
	//Function that gets the input from the user.
	private void getInput()
	{
		
		moveX = 0;
		//if input from the user is A then move to left
		if(game.getKeyManager().left)
		{
			moveX -= speed;
			stand = false;
		}
		//If an enemy object is not blocking the Hero's movement to right
		if(cantMoveForward == false)
		{
			//if input from the user is D then move to right
			if(game.getKeyManager().right)
			{
				moveX += speed;
				stand = false;
			}
		}
		//Summon Bear --> pressed button 1
		if(game.getKeyManager().summon1)
		{
			summonAlly(1);
		}
		//Summon Dog --> pressed button 2
		if(game.getKeyManager().summon2)
		{
			summonAlly(2);
		}
		//Summon Monkey --> pressed button 3
		if(game.getKeyManager().summon3)
		{
			summonAlly(3);
		}
		//Summon Tortoise --> pressed button 4
		if(game.getKeyManager().summon4)
		{
			summonAlly(4);
		}
		//Cast Heal --> pressed button F1
		if(game.getKeyManager().skill1)
		{
			castSkill(1);
		}
		//Cast Speed Buff --> pressed button F2
		if(game.getKeyManager().skill2)
		{
			castSkill(2);
		}
		//Cast Hail Strike --> pressed button F3
		if(game.getKeyManager().skill3)
		{
			castSkill(3);
		}
		//Cast Raven Strike --> pressed button F4
		if(game.getKeyManager().skill4)
		{
			castSkill(4);
		}
	}

	//Casts a skill with respect to the given type
	public void castSkill(int type)
	{
		//checks the type, whether the heal skill is in cooldown and the Hero does have required mana to cast the skill
		if(type == 1 && !game.getObjectManager().getHealCD() && this.getMana() >= ShopManager.getHealRequiredMana())
		{
			//Decreases the current mana.
			setMana(getMana()-ShopManager.getHealRequiredMana());
			//Adds a new HealSkill object to alliesList in ObjectManager
			game.getObjectManager().addObject(new HealSkill(posX-20, posY-100, width+40, height+200));
			//Sets casting true, so that the casting animation can be rendered.
			casting = true;
		}

		//checks the type, whether the speed buff skill is in cooldown and the Hero does have required mana to cast the skill
		else if(type == 2 && !game.getObjectManager().isSpeedCD() && this.getMana() >= ShopManager.getSpeedRequiredMana())
		{
			//Decreases the current mana.
			setMana(getMana()-ShopManager.getSpeedRequiredMana());
			//Adds a new SpeedBuffSkill object to alliesList in ObjectManager
			game.getObjectManager().addObject(new SpeedBuffSkill(posX-10, posY, width+20, height+50));
			//Sets casting true, so that the casting animation can be rendered.
			casting = true;
		}

		//checks the type, whether the hail strike skill is in cooldown and the Hero does have required mana to cast the skill
		else if(type == 3 && !game.getObjectManager().isHailCD() && this.getMana() >= ShopManager.getHailRequiredMana() )
		{
			//Decreases the current mana.
			setMana(getMana()-ShopManager.getHailRequiredMana());
			//Adds a new HailStrike object to alliesList in ObjectManager
			game.getObjectManager().addObject(new HailStrike(posX+100, posY, width, height));
			//Sets casting true, so that the casting animation can be rendered.
			casting = true;
		}

		//checks the type, whether the raven strike skill is in cooldown and the Hero does have required mana to cast the skill
		else if(type == 4 && !game.getObjectManager().isRavenCD() && this.getMana() >= ShopManager.getRavenRequiredMana())
		{
			//Decreases the current mana.
			setMana(getMana()-ShopManager.getRavenRequiredMana());
			//Adds a new RavenStrike object to alliesList in ObjectManager
			game.getObjectManager().addObject(new RavenStrike(posX, posY, 10, 10));
			//Sets casting true, so that the casting animation can be rendered.
			casting = true;
		}
	}
	//Summones an Ally Minion object with respect to the type.
	public void summonAlly(int type)
	{
		//Checks the type, whether the bear is in cooldown, and the Hero does have required food to summon.
		if(type == 1 && this.getFood() >= ShopManager.getBearRequiredFood() && !game.getObjectManager().isBearCD())
		{
			//Decreases the food.
			setFood(getFood()-ShopManager.getBearRequiredFood());
			//Summons the Minion
			Bear.summon();
		}

		//Checks the type, whether the Dog is in cooldown, and the Hero does have required food to summon.
		else if(type == 2 && this.getFood() >= ShopManager.getDogRequiredFood() && !game.getObjectManager().isDogCD())
		{
			//Decreases the food.
			setFood(getFood()-ShopManager.getDogRequiredFood());
			//Summons the Minion
			Dog.summon();
		}

		//Checks the type, whether the Monkey is in cooldown, and the Hero does have required food to summon.
		else if(type == 3 && this.getFood() >= ShopManager.getMonkeyRequiredFood() && !game.getObjectManager().isMonkeyCD())
		{

			//Decreases the food.
			setFood(getFood()-ShopManager.getMonkeyRequiredFood());
			//Summons the Minion
			Monkey.summon();
		}	
		//Checks the type, whether the Tortoise is in cooldown, and the Hero does have required food to summon.
		else if(type == 4 && this.getFood() >= ShopManager.getTortoiseRequiredFood() && !game.getObjectManager().isTortoiseCD())
		{

			//Decreases the food.
			setFood(getFood()-ShopManager.getTortoiseRequiredFood());
			//Summons the Minion
			Tortoise.summon();
		}
	}

	//Updates health, called in the CollisionManager
	@Override
	public boolean updateHealth(int amount) {

		this.setHealth(this.getHealth()-amount);
		return true;
	}
	//Creates the collision rectangle of the hero.
	public Rectangle getCollisionRectangle() 
	{
		return new Rectangle((int)posX, (int)posY, width, height);
	}
	
	//Getters and Setters
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
	}	@Override
	public boolean updateSpeed(float amount) {

		return true;

	}
	@Override
	public boolean decreaseSpeed()
	{
		return true;
	}


}
