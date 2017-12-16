package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.GameManager;

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
	
	protected GameManager game;
	
	public State() {
		game = GameManager.getGame();
	}
	
	

	
	//CLASS
	public abstract void tick();
	public abstract void render(Graphics g);

}
