/* Author: Ata Gün Öðün & Bora Ecer  
 * Date: 1 November 2017
 * Version: 1.12.2017
 * GameManager is the main Control class of the game. It has every other Manager classes as attributes, 
 * and has GameEngine, which enables it to connect with the UIManagement subsystem. Also, it has States objects,
 * which are for representing and rendering different stages of the game: GameState, MenuState..
 * It applies Singleton Design Pattern to provide only one GameManager object is passed through the other subsystems.
 * The game is started with the call of start() method, which initially calls the inititilize() method which is only going to be called once
 * the initilize() method initilizes the gameEngine, ImageManager and States objects. 
 * Also it adds the KeyManager as KeyListener to the GameEngine's frame & MouseManager as MouseListener.
 * GameManager is the class which has the game loop in it, which is the loop continues until the end of the game. 
 * In each iteraiton of the game loop, it calls for tick() and render() method of the current game state. 
 * Which then calls the needed render() and tick() methods, i.e if the current state is GameState, 
 * then the GameState will call the tick() and render() methods of each GameObject created.   
 */
package dev.animaluprising.GameControl;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.animaluprising.States.GameMenuState;
import dev.animaluprising.States.GameOverState;
import dev.animaluprising.States.GameState;
import dev.animaluprising.States.HowToPlayState;
import dev.animaluprising.States.MainMenuState;
import dev.animaluprising.States.PauseState;
import dev.animaluprising.States.SettingsState;
import dev.animaluprising.States.ShopState;
import dev.animaluprising.States.State;
import dev.animaluprising.States.VictoryState;
import dev.animaluprising.UIManagement.GameEngine;

public class GameManager implements Runnable{
	
	private int gameWidth=1024,gameHeight=768;
	private String gameTitle="Animal Uprising"; 
	private int coin = 0;
	private GameEngine display;
	private Thread thread;
	private boolean isRunning;
	private BufferStrategy bufferStrategy;
	private Graphics g;
	private SoundManager soundManager;
	//States
	private State gameState;	
	private State mainMenuState;
	private State shopState;
	private State gameMenuState;
	private State howToPlayState;	
	private State pauseState;	
	private State  settingsState;
	private VictoryState victoryState;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	
	private ObjectManager objectManager;
	private CollisionManager collisionManager;
	private State gameOverState;

	
	private GameManager() {
		//all the field values of the game are the default values given above i.e gameTitle gameWidth etc
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		soundManager = new SoundManager();
	}

	
	//THIS MAKES THE GAME CLASS A SINGLETON
	private static GameManager game=null;
	public static GameManager getGame(){
		if(game == null)
			game = new GameManager();
		return game;
	}
	//END OF WHAT MAKES THE GAME CLASS A SINGLETON
	

 
	private void initialize(){
		this.display = new GameEngine(gameTitle,gameWidth,gameHeight);
		soundManager.play();
		display.getFrame().addKeyListener(keyManager);	
		
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		
		setCollisionManager(new CollisionManager());
		
		ImageManager.init();
		
		//initialize all the states
		gameState = new GameState( );
		gameMenuState = new GameMenuState( );
		howToPlayState = new HowToPlayState( );
		pauseState = new PauseState( );
		settingsState = new SettingsState( );
		mainMenuState = new MainMenuState( );
		shopState = new ShopState( );
		victoryState = new VictoryState();
		gameOverState = new GameOverState();
		
		
		State.setState(mainMenuState); 
	
	}
	
	public void setGameState(State gameState) {
		this.gameState = gameState;
	}



	private void gameUpdate(){
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	private void gameRender(){
		bufferStrategy = display.getCanvas().getBufferStrategy();//using buffers since we don't want flickering
		if(bufferStrategy==null){
			display.getCanvas().createBufferStrategy(3);//no idea why 3, can try other numbers
			return;
		}
		
		g=bufferStrategy.getDrawGraphics();
		
		//clear the screen
		g.clearRect(0, 0, gameWidth, gameHeight);
		
		//start drawing{
		if(State.getState() != null)
			State.getState().render(g); 
		//end drawing }
		
		bufferStrategy.show();
		g.dispose();    
	}
	
	@Override
	public void run() {
		initialize();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer=0;
		int ticks=0;
		
		/*
		 * Game loop:
		 * 	update all variables, positions of objects etc
		 * 	render(draw) everything to screen
		 */
		while(isRunning){
			
			if(State.getState() instanceof GameState)
			{
				timePerTick = 1000000000/15;
			}
			
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now-lastTime;
			lastTime=now;
			
			if(delta>=1){
				gameUpdate();
				gameRender();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("ticks and frames: " +ticks);
				ticks=0;
				timer=0;
			}
			
			
		}
		
		stop();
		
	}

	public synchronized void start(){
		if(isRunning)//check if it is running, if it is, don't do anything
			return;
		
		isRunning = true;
		thread=new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!isRunning)//check if it is running, if it is not, don't try stopping it
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TO DO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	

	public SoundManager getSoundManager() {
		return soundManager;
	}



	/**
	 * @return the gameWidth
	 */
	public int getGameWidth() {
		return gameWidth;
	}


	/**
	 * @return the gameHeight
	 */
	public int getGameHeight() {
		return gameHeight;
	}
	
	
	/**
	 * @return the gameState
	 */
	public State getGameState() {
		return gameState;
	}



	/**
	 * @return the mainMenuState
	 */
	public State getMainMenuState() {
		return mainMenuState;
	}



	/**
	 * @return the shopState
	 */
	public State getShopState() {
		return shopState;
	}



	/**
	 * @return the gameMenuState
	 */
	public State getGameMenuState() {
		return gameMenuState;
	}



	/**
	 * @return the howToPlayState
	 */
	public State getHowToPlayState() {
		return howToPlayState;
	}



	/**
	 * @return the pauseState
	 */
	public State getPauseState() {
		return pauseState;
	}



	/**
	 * @return the settingsState
	 */
	public State getSettingsState() {
		return settingsState;
	}



	public static void main(String[] args) {
		GameManager.getGame().start();
		
	}



	public ObjectManager getObjectManager() {

		return objectManager;
	}



	public void setObjectManager(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}



	public CollisionManager getCollisionManager() {
		return collisionManager;
	}



	public void setCollisionManager(CollisionManager collisionManager) {
		this.collisionManager = collisionManager;
	}



	public VictoryState getVictoryState() {
		return victoryState;
	}
	
	public State getGameOverState() {
		return gameOverState;
	}
	
	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}







	

}
