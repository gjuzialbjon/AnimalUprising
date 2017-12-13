/* Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * GameManager is the main Control class of the game. It has every other Manager classes as attributes, 
 * and has GameEngine, which enables it to connect with the UIManagement subsystem. Also, it has States objects,
 * which are for representing and rendering different stages of the game: GameState, MenuState..
 * The game is started with the call of start() method, which initially calls the init() method which is only going to be called once
 * the init() method initilizes the gameEngine, ImageManager and States objects. Also it adds the inputManager as KeyListener to the GameEngine's frame.
 * GameManager is the class which has the game loop in it, which is the loop continues until the end of the game. 
 * In each iteraiton of the game loop, it calls for update() and render() method of the current game state. 
 * Which then calls the needed render() and update() methods, i.e if the current state is GameState, 
 * then the GameState will call the update() and render() methods of each GameObject created.   
 * NOTE: will be completed, in the future iteration.
 * The SoundManager will be added to gameMAnager as an attribute once it is done.
 */



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
	private ObjectManager objectManager;
	private Thread thread;
	private BufferStrategy strategy;
	private Graphics graphics;
	public int width, height, updateAmount;
	public String title;
	
	
	private boolean running = false;
	private boolean gameStarted;
	
	//States 
	private States gameState;
	private States menuState;
	private States pauseState;

	
	public GameManager(String title, int width, int height, InputManager inputManager, ObjectManager objectManager) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.inputManager = inputManager;
		this.objectManager = objectManager;
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
		
		int fps = 15;
		double timePerUpdate = 1000000000 / fps;
		double timeDifference = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		

		//Game Loop
		while(running)
		{
			currentTime = System.nanoTime();
			timeDifference += ((currentTime - lastTime) / timePerUpdate); 
			lastTime = currentTime;
			System.out.println(timeDifference);
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
	public void changeMenuState()
	{
		States.setState(menuState);
	}
	
	public InputManager getInputManager() {
		return inputManager;
	}
	
	public ObjectManager getObjectManager()
	{
		return objectManager;
	}
	public GameEngine getGameEngine()
	{
		return gameEngine;
	}
	public boolean isRunning()
	{
		return running;
	}
}
