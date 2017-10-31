package GameModel;
import GameControl.GameManager;


public abstract class CharacterObject extends GameObject
{

	public static float movementSpeed = 3.0f;
	public static int maxHealth;
	public static int attackDamage;
	public static final int DEFAULT_WIDTH = 64;
	public static final int DEFAULT_HEIGHT = 64;

	private int health;
	protected float moveX;
	protected float moveY;
	protected float speed;
	
	public CharacterObject(float posX, float posY, int width,int height, GameManager gameManager) {
		super(posX, posY, width, height, gameManager);
		health = maxHealth;
		moveX = 0;
		moveY = 0;
		speed = movementSpeed;
	}
	
	public void move()
	{
		posX += moveX;
		//posY += moveY;
	}
	

	public static float getMovementSpeed() {
		return movementSpeed;
	}

	public static void setMovementSpeed(float movementSpeed) {
		CharacterObject.movementSpeed = movementSpeed;
	}

	public static int getMaxHealth() {
		return maxHealth;
	}

	public static void setMaxHealth(int maxHealth) {
		CharacterObject.maxHealth = maxHealth;
	}

	public static int getAttackDamage() {
		return attackDamage;
	}

	public static void setAttackDamage(int attackDamage) {
		CharacterObject.attackDamage = attackDamage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
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
