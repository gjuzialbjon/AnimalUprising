package dev.animalgame.entities.creatures.allies;

import java.awt.Graphics;

import dev.animalgame.Game;
import dev.animalgame.entities.creatures.Creature;
import dev.animalgame.gfx.Assets;

public class Player extends Creature {
	
	public static final float zoomFactor = 1.5f;
	public static final int PLAYER_WIDTH=(int)(128*zoomFactor),PLAYER_HEIGHT=(int)(84*zoomFactor);

	//get max health attack etc values from another class that handles shop upgrades and loading etc(not written yet)
	public Player(float x, float y) {
		super(x, y,PLAYER_WIDTH,PLAYER_HEIGHT);
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
