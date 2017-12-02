package dev.animalgame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.animalgame.Game;
import dev.animalgame.entities.creatures.allies.Ally;
import dev.animalgame.entities.creatures.allies.Player;
import dev.animalgame.entities.creatures.enemies.Enemy;
import dev.animalgame.entities.creatures.enemies.EnemyCastle;

// LOW PRIORITY TODO: look up entity pooling/object pooling. 
public class EntityManager {
	
	
	//TODO make all fields private
	Spawner spawner;//we keep this separately since we don't actually render this(right?) it only needs to update
	
	
	ArrayList<Ally> allies;
	Player player; //TODO might not need this, maybe only needed for render order.((re?)render last)
	
	
	ArrayList<Enemy> enemies;
	EnemyCastle enemyCastle; //TODO might not need this, maybe only needed for render order ((re?)render before player) 

	
	ArrayList<Entity> environment;//floor and sky and stuff
	
	Game game = Game.getGame();
	
	public EntityManager() {
		
		//might wanna add all these to the fields.
		allies = new ArrayList<Ally>();
		enemies = new ArrayList<Enemy>();
		environment = new ArrayList<Entity>(); //TODO might wanna add a class below Entity called Background or Environment	
		
	
	}
	
	
	
	public void tick(){//TODO tick spawner, tick allies, tick enemies, check/remove dead allies, check/remove dead enemies(It is possible to check if player/castle is null to switch to the winning or losing screen), 
						//note for this TODO: check/remove inactive entities, not dead ones. Death animation might be going on so they still need to be there/be rendered
	
		if(spawner != null){
			spawner.tick();
		}else{
			System.err.println("PANIC PANIC PANIC PANIC: The entity manager does NOT have a Spawner object!!! There is something wrong if you are seeing this message!");
			System.err.println("EntityManager.tick()");
		}
		
		//
		
		
		
		for(Ally cycler:allies){
			cycler.tick();
		}
		
		for(Enemy cycler:enemies){
			cycler.tick();
		}
		
		//TODO  IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!
		//TODO	REMOVE INACTIVE ENTITIES HERE!!!!
		//TODO  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	
	//This should /*error:missed step 0)render environment(check if this is the right way)*/  1)render all allies 2)render all enemies 3)render the enemy castle(again) 4)Render the player(aka hero) 
	public void render(Graphics g){ 
		
		for(Entity cycler:environment)	//TODO (not exactly about this line)(relocate this comment if possible) make sure environment doesn't require tick()s
			cycler.render(g);
			
		for(Ally cycler:allies){
			cycler.render(g);
		}
		
		for(Enemy cycler:enemies){
			cycler.render(g);
		}
		
		
		
		if(enemyCastle!=null){
			enemyCastle.render(g);
		}else{
			System.err.println("PANIC PANIC PANIC PANIC: The entity manager does NOT have an enemyCastle object!!! There is something wrong if you are seeing this message!");
			System.out.println("EntityManager.render()");
		}
		
		
		if(player!=null){
			player.render(g);
		}else{
			System.err.println("PANIC PANIC PANIC PANIC: The entity manager does NOT have a player object!!! There is something wrong if you are seeing this message!");
			System.out.println("EntityManager.render()");
		}
			
		
	}
	
	
	
	
	public void addEntity(Entity entity){
		if (entity instanceof Player) 
			addPlayer((Player)entity);
		else if (entity instanceof Ally) 
			addAlly((Ally) entity);
		else if (entity instanceof EnemyCastle) 
			addEnemyCastle((EnemyCastle)entity);
		else if (entity instanceof Enemy)
			addEnemy((Enemy) entity);
		else if (entity instanceof Spawner) 
			addSpawner((Spawner) entity);
		else
			addEnvironment(entity);
		
		//TODO might wanna add an else if for environment after writing a Background/Environment class, if all the "if else" fail, print error and exit program.(or throw exception, but who am I to judge)		
		
	}
	
	
	

	
	
	private void addSpawner(Spawner spawner){//TODO might wanna make this setSpawner, or add an arraylist for spawners and support multiple spawners.
		this.spawner=spawner;
	}
	
	private void addPlayer(Player player){
		this.player=player;
		addAlly((Ally) player);
	}
	
	private void addEnemyCastle(EnemyCastle castle){
		this.enemyCastle=castle;
		addEnemy((Enemy)castle);
	}
	
	
	private void addAlly(Ally ally){
		allies.add(ally);
	}
	
	
	private void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}
	
	
	private void addEnvironment(Entity environment){
		this.environment.add(environment);
	}
	

	

	

	
	

}
