/*
 * Author: Bora Ecer, Ata Gun Ogun
 * Date: 1 November 2017
 * Version: v1
 * InputManager is the class for getting the inputs from the user.
 */


package dev.animaluprising.GameControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean left, right, summon1, summon2, summon3, summon4, skill1,skill2,skill3,skill4,pause;
	
	public KeyManager() {	
		keys = new boolean[256];
	}
	
	public void tick()
	{
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		summon1 = keys[KeyEvent.VK_1];
		summon2 = keys[KeyEvent.VK_2];
		summon3 = keys[KeyEvent.VK_3];
		summon4 = keys[KeyEvent.VK_4];
		skill1  = keys[KeyEvent.VK_F1];
		skill2  = keys[KeyEvent.VK_F2];
		skill3  = keys[KeyEvent.VK_F3];
		skill4  = keys[KeyEvent.VK_F4];
		pause 	= keys[KeyEvent.VK_ESCAPE];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {

		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
