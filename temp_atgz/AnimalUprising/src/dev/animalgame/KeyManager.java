package dev.animalgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	
	private boolean[] keys;
	public boolean left,right; //TODO BURAYA SPAWN SKILL ESC VB EKLE
	
	public KeyManager() {
		keys = new boolean[256];
		
	}
	
	
	public void tick(){
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}


	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
