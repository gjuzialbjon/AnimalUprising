package dev.animaluprising.GameControl;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftMouse,rightMouse;
	private int mouseX,mouseY;
	private Point mousePoint=new Point();	//making sure this is never null 
	
	private MouseEvent lastRelease;
	
	/*COMMENT THIS PROPERLY*/
	public MouseEvent popLastRelease(){
		MouseEvent ret = lastRelease;
		lastRelease=null;
		
		return ret;
	}
	
	
	public MouseManager() {
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			leftMouse=true;
		else if(e.getButton()==MouseEvent.BUTTON3)	//3= right 2=middle
			rightMouse=true;
		
		//System.out.println("mousePressed");
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			leftMouse=false;
		else if(e.getButton()==MouseEvent.BUTTON3)
			rightMouse=false;
		
		lastRelease=e;	//TODO check if this is okay, comment properly
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//TODO check if useful, write if so
		//System.out.println("mouse dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePoint=e.getPoint();
		mouseX = e.getX();
		mouseY = e.getY();
		
		//System.out.println("moved");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	

	/**
	 * @return the leftMouse
	 */
	public boolean isLeftPressed() {
		return leftMouse;
	}

	/**
	 * @return the rightMouse
	 */
	public boolean isRightPressed() {
		return rightMouse;
	}


	public Point getMousePoint() {
		return mousePoint;
	}


	/**
	 * @return the mouseX
	 */
	public int getMouseX() {
		return mouseX;
	}


	/**
	 * @return the mouseY
	 */
	public int getMouseY() {
		return mouseY;
	}
	

}
