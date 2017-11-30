package dev.animalgame.states;

import java.awt.Graphics;


import dev.animalgame.levels.Level;

//TODO gamestate'e child classlar ekleyip farkli levellari o sekilde halledebiliriz
//TODO ya da enemyCastle objesini iyi yazar ve ordan yururuz.

public class GameState extends State {
	private Level level;

	public GameState() {
		super();
		level = new Level(1); //TODO change the "1" appropriately to the level choosen
		//TODO remove level stuff from here, add initLevel(int i) and getLevel() to this class if needed
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick() {
		level.tick();
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
		
		//TODO render the GUI here probably, similar to paladog
	}

}
