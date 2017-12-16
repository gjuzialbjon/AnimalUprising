/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class that holds the view elements of the game.
 * 
 */

package dev.animaluprising.UIManagement;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameEngine {
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width,height;
	public GameEngine(String title, int width, int height) {
		this.title=title;
		this.width= width;
		this.height=height;
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null); //opens the display in the center of the screen
		frame.setVisible(true);
		frame.setVisible(true);
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
}
