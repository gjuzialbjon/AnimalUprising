package dev.animalgame.levels;

import java.awt.Graphics;

import dev.animalgame.Game;
import dev.animalgame.entities.Entity;
import dev.animalgame.entities.backgrounds.Floor;
import dev.animalgame.entities.creatures.allies.Player;

public class Level {
	
	public static final int MAPWIDTH=2048;
	
	private Game game=Game.getGame();
	
	private int width, height; //this is as pixel.
	private int allySpawnX=100,allySpawnY=game.getGameHeight()/2; //this is the spawning coordinate of player and spawner
	private int enemySpawnX,enemySpawnY;
	
	Entity floor;//TODO also add sky, maybe make these "background" or "environment" (aka make them extend another class, not entity)
	Player player;
	
	public Level(int levelNo) { //TODO add the enemy castle according to the levelNo
		
		
		player = new Player(allySpawnX,allySpawnY-Player.PLAYER_HEIGHT);//MAKE THE 200 Player.DEFAULT_HEIGHT instead, (make sure its static)
		floor = new Floor();
		
		//enemycastle = new EnemyCastle(levelNo);  //TODO make this construct the enemycastle according to the level no, maybe pass a hashmap with time-enemyToSpawn
		//spawner = new Spawner(); //TODO spawner can listen to spawning inputs and do summon cooldown stuff and all
		//TODO note: it might be needed to pass entity manager to player and enemy castle (and maybe spawner too)
	}
	
	
	public void tick(){
		//TODO enemyCastle.tick();
		//TODO spawner.tick();
		player.tick();
		floor.tick();
	}
	
	public void render(Graphics g){
		floor.render(g);
		player.render(g);
		
		//TODO add an entity manager and render that, and make it render so that it only renders the entities on the screen. check out episode 20 if you cant do it yourself
	}
	
	

}
