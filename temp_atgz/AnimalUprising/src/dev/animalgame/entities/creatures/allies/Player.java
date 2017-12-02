package dev.animalgame.entities.creatures.allies;

import java.awt.Graphics;

import dev.animalgame.Game;
import dev.animalgame.entities.creatures.Creature;
import dev.animalgame.gfx.Assets;

//TODO rename/refactor this class as Hero or HeroCharacter of something, not all player actions(summons etc) are done in this. It might confuse people.
public class Player extends Creature implements Ally{	//TEMPORARY NOTE: the "implements Ally" is added after the first test of EntityManager, design says Player should be an Ally, make sure this "implements" does not break anything.
	
	public static final float zoomFactor = 1.5f;
	public static final int DEFAULT_WIDTH=(int)(128*zoomFactor);
	public static final int DEFAULT_HEIGHT=(int)(84*zoomFactor);


	//get max health attack etc values from another class that handles shop upgrades and loading etc(not written yet)
	public Player(float x, float y) {
		super(x, y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//TODO Add DEFAULT_PLAYER_WIDTH etc to make things more readable	
		texture = Assets.horse_right_still;
		
		collisionBox.x = (int)(37*zoomFactor);
		collisionBox.y = (int)(28*zoomFactor);
		collisionBox.width = (int)(64*zoomFactor);
		collisionBox.height = (int)(32*zoomFactor);
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		
		game.getGameCamera().centerOnEntity(this);
	}
	
	
	private void getInput(){ //TODO RENAME THIS AS PROCESS INPUT, ITS MORE FITTING AS OF NOW 
							//TODO note: maybe rename this as calculateMove() and add it to creature as an abstract method
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		
		if(game.getKeyManager().right){
			xMove = speed;
		}
		
	}



}
