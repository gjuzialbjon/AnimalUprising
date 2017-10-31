package GameControl;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import GameControl.States.GameState;
import GameControl.States.MenuState;
import GameControl.States.PauseState;
import GameControl.States.States;
import UIManagement.GameEngine;

public class GameManager implements Runnable {
	
	private InputManager inputManager;
	private GameEngine gameEngine;
	private Thread thread;
	private BufferStrategy strategy;
	private Graphics graphics;
	public int width, height;
	public String title;
	
	private boolean running = false;
	
	//States 
	private States gameState;
	private States menuState;
	private States pauseState;

	
	public GameManager(String title, int width, int height, InputManager inputManager) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.inputManager = inputManager;
	}
	private void init()
	{
		gameEngine = new GameEngine(title, width, height);
		gameEngine.getFrame().addKeyListener(inputManager);
		ImageManager.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		pauseState = new PauseState(this);
		States.setState(gameState);

	}
	@Override
	public void run() 
	{
		init();
		
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double timeDifference = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		

		//Game Loop
		while(running)
		{
			currentTime = System.nanoTime();
			timeDifference += (currentTime - lastTime) / timePerUpdate; 
			lastTime = currentTime;
			if(timeDifference >= 1) 
			{
				update();
				render();
				timeDifference--;
			}
		}
		
		stop();
		
	}
	private void update()
	{
		inputManager.update();
		if(States.getState() != null)
		{
			States.getState().update();
		}
	}
	
	private void render()
	{
		strategy = gameEngine.getCanvas().getBufferStrategy();
		if(strategy == null)
		{
			gameEngine.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = strategy.getDrawGraphics();
		
		graphics.clearRect(0, 0, width, height);
		//Draw
		if(States.getState() != null)
		{
			States.getState().render(graphics);
		}
		
		//end draw
		strategy.show();
		graphics.dispose();
	}
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try 
		{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public InputManager getInputManager() {
		return inputManager;
	}
}
