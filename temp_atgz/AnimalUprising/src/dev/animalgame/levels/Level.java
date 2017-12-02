package dev.animalgame.levels;

import java.awt.Graphics;

import dev.animalgame.Game;
import dev.animalgame.entities.Entity;
import dev.animalgame.entities.EntityManager;
import dev.animalgame.entities.Spawner;
import dev.animalgame.entities.backgrounds.Floor;
import dev.animalgame.entities.creatures.allies.Bear;
import dev.animalgame.entities.creatures.allies.Player;
import dev.animalgame.entities.creatures.enemies.EnemyCastle;

public class Level {
	
	public static final int MAPWIDTH=2048;
	
	private Game game=Game.getGame();
	
	private int width, height; //this is as pixel.  TODO change this according to levelNo as well, //TODO 2) change the width of the Floor according to this. 
	private int allySpawnX=100,allySpawnY=game.getGameHeight()/2; //this is the spawning coordinate of player and spawner, change this according to the level no(?)(might skip this since I don't think it is necessary)
	private int enemySpawnX=game.getGameWidth()-100,enemySpawnY=game.getGameHeight()/2;//TODO TEMPORARY VALUES, DONT FORGET CHANGING!!!!!!!!!!!!!!      this is the real todo>>>>>//TODO loading the level means setting these properly, also rename these 2 to enemyCastleX,Y or castlePosX,Y etc
	
	//TODO add int coinWon, this amount will be added to the Players total coins(probably in ShopManager) if the level is won.
	
	/* YOU CAN NOW ACCESS THESE FROM THE ENTITY MANAGER(_you should be able to get entity manager from game manager_ UPDATE:entityManager is now a field and can be accessed directly)
	Entity floor;//TODO also add sky, maybe make these "background" or "environment" (aka make them extend another class, not entity)
	Player player;
	*/
	private EntityManager entityManager;
	
	
	Entity debugTest;
	
	public Level(int levelNo) { //TODO add the enemy castle according to the levelNo
		entityManager = new EntityManager();
		
		entityManager.addEntity(new Spawner(allySpawnX, allySpawnX));	//TODO CHECK THE COORDINATES OF THIS, GIVE INFO ABOUT THE COORDINATE STUFF IN THE COMMENTS HERE AND ON THE SPAWNER CLASS
		
		entityManager.addEntity(new Player(allySpawnX,allySpawnY-Player.DEFAULT_HEIGHT));	//TODO this is subject to change, //TODO UPDATE: instead of subtracting Player.DEFAULT_HEIGHT, just pass the allySpawnX. Make sure the Player constructor takes care of that stuff. IF YOU DO THIS: Explain that the lower left corner is written for indicating where a thing is spawned (check if this is correct)
		entityManager.addEntity(new EnemyCastle(enemySpawnX, enemySpawnX-EnemyCastle.DEFAULT_HEIGHT));//TODO OF THE FOLLOWING COMMENTED LINE ALSO APPLIES TO THIS AND THE PREVIOUS LINES
		
		entityManager.addEntity(new Floor());//TODO Floor constructor is subject to change. Be aware, maybe even add @deprecated to this method/constructor
		
		//THIS LINE IS COMMENTED SINCE IT IS DONE IN A DIFFERENT WAY BUT IT HAS AN UNFINISHED TODO COMMENT, THIS TODO IS ALSO NEEDED FOR THE PREVIOUS LINES    //player = new Player(allySpawnX,allySpawnY-Player.DEFAULT_HEIGHT);//TODO using default height doesnt seem right, see if you can use player.height instead(or make this player object differently)
		//this line is commented along with the previous line //floor = new Floor();
	
		//DEBUG CODE
		debugTest = new Bear(allySpawnX,allySpawnY-Bear.DEFAULT_HEIGHT);
		entityManager.addEntity(debugTest);
		//DEBUG CODE
		
		//enemycastle = new EnemyCastle(levelNo);  //TODO make this construct the enemycastle according to the level no, maybe pass a hashmap with time-enemyToSpawn
		//spawner = new Spawner(); //TODO spawner can listen to spawning inputs and do summon cooldown stuff and all
		//TODO note: it might be needed to pass entity manager to player and enemy castle (and maybe spawner too) UPDATE: Why not let them access it via GameManager?
	}
	
	
	public void tick(){
		//TODO make sure entityManager.tick() is implemented correctly
		
		entityManager.tick();
		
		//DEBUG CODE
		//NO LONGER REQUIRED AFTER THE ADDITION OF ENTITY MANAGER   //debugTest.tick();
		//DEBUG CODE
	}
	
	public void render(Graphics g){
		entityManager.render(g);
		
		//DEBUG CODE
		//NO LONGER REQUIRED AFTER THE ADDITION OF ENTITY MANAGER   //debugTest.render(g);
		//DEBUG CODE
		
		//TODO add an entity manager and render that, and make it render so that it only renders the entities on the screen. check out episode 20 if you cant do it yourself
	}
	
	

}
