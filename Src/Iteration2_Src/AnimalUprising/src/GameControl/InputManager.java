/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * InputManager is the class for getting the inputs from the user.
 * NOTE: the MouseListener will be added in the future iteration
 */


package GameControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

	private boolean[] controlButtons;
	public boolean left, right, summon1, summon2, summon3, summon4, skill1,skill2,skill3,skill4;
	
	public InputManager() {	
		controlButtons = new boolean[256];
	}
	
	public void update()
	{
		left = controlButtons[KeyEvent.VK_A];
		right = controlButtons[KeyEvent.VK_D];
		summon1 = controlButtons[KeyEvent.VK_1];
		summon2 = controlButtons[KeyEvent.VK_2];
		summon3 = controlButtons[KeyEvent.VK_3];
		summon4 = controlButtons[KeyEvent.VK_4];
		skill1  = controlButtons[KeyEvent.VK_F1];
		skill2  = controlButtons[KeyEvent.VK_F2];
		skill3  = controlButtons[KeyEvent.VK_F3];
		skill4  = controlButtons[KeyEvent.VK_F4];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		controlButtons[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {

		controlButtons[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
