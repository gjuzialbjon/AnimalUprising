/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that contains the attributes of Character Object. 
 * CharacterObject is an abstract class, which is a subclass of GameObject, which has move() method in it.
 * Basicly move() method, increases the position of the object in X axis which is only used by Ally soldier objects.
 * For HeroObject and Enemy Soldier object, this method is overriden. 
 * Since every 
 * NOTE: will be completed, in the future iteration.
 */


package GameModel;
import GameControl.GameManager;


public abstract class CharacterObject extends GameObject
{

	public static float movementSpeed = 1.0f;
	public static int maxHealth;
	public static int attackDamage;
	public static final int DEFAULT_WIDTH = 64;
	public static final int DEFAULT_HEIGHT = 64;

	protected float moveX;
	protected float moveY;
	protected float speed;
	
	public CharacterObject(float posX, float posY, int width,int height, int health ,GameManager gameManager)
	{
		super(posX, posY, width, height, health ,gameManager);
		moveX = 0;
		moveY = 0;
		speed = movementSpeed;
	}
	
	public void move()
	{
		posX += moveX;
		//posY += moveY;
	}

	public static float getMovementSpeed() 
	{
		return movementSpeed;
	}

	public static void setMovementSpeed(float movementSpeed) 
	{
		CharacterObject.movementSpeed = movementSpeed;
	}

	public static int getMaxHealth()
	{
		return maxHealth;
	}

	public static void setMaxHealth(int maxHealth)
	{
		CharacterObject.maxHealth = maxHealth;
	}

	public static int getAttackDamage() 
	{
		return attackDamage;
	}

	public static void setAttackDamage(int attackDamage)
	{
		CharacterObject.attackDamage = attackDamage;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}


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
}
