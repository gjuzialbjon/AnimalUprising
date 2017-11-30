package dev.animalgame.states;

import java.awt.Graphics;

import dev.animalgame.Game;

public abstract class State {
	
	
	//State manager start
	private static State currentState =null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	//state manager end
	
	protected Game game;
	
	public State() {
		game = Game.getGame();
	}
	
	

	
	//CLASS
	public abstract void tick();
	public abstract void render(Graphics g);

}
