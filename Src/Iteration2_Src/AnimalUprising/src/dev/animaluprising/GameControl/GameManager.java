package dev.animaluprising.GameControl;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.animalgame.display.Display;
import dev.animaluprising.States.GameMenuState;
import dev.animaluprising.States.GameState;
import dev.animaluprising.States.HowToPlayState;
import dev.animaluprising.States.MainMenuState;
import dev.animaluprising.States.PauseState;
import dev.animaluprising.States.SettingsState;
import dev.animaluprising.States.ShopState;
import dev.animaluprising.States.State;
import dev.animaluprising.States.VictoryState;

public class GameManager implements Runnable{
	
	private int gameWidth=1024,gameHeight=768; // make these final maybe?
	private String gameTitle="Animal Uprising"; // make this final maybe?
	
	private Display display;
	
	private Thread thread;
	private boolean isRunning;
	
	private BufferStrategy bufferStrategy;
	private Graphics g;
	
	//States
	private State gameState;	//Update: make getter in game manager TODO might wanna add a getter for this
	private State mainMenuState;
	private State shopState;
	private State gameMenuState;
	private State howToPlayState;	//note: public?
	private State pauseState;	
	private State  settingsState;
	private VictoryState victoryState;
	
	//input
	private KeyManager keyManager;//TODO move to gamemanager
	private MouseManager mouseManager;//TODO move to gamemanager
	
	
	//camera
	//private GameCamera gameCamera;
	
	private ObjectManager objectManager;
	private CollisionManager collisionManager;

	
	private GameManager() {
		//all the field values of the game are the default values given above ie gameTitle gameWidth etc
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
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
		this.display = new Display(gameTitle,gameWidth,gameHeight);
		display.getFrame().addKeyListener(keyManager);	// TODO check if we need to add this to canvas too
		
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);//TODO check if needed
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		
		setCollisionManager(new CollisionManager());
		
		ImageManager.init();
		
		//gameCamera = new GameCamera(0,0); //UPDATE: move to game manager TODO might wanna move this to GameState since I think its only useful there.
		
		//TODO we can do the loading of a saved game here I guess
		
		//initialize all the states
		gameState = new GameState( );
		gameMenuState = new GameMenuState( );
		howToPlayState = new HowToPlayState( );
		pauseState = new PauseState( );
		settingsState = new SettingsState( );
		mainMenuState = new MainMenuState( );
		shopState = new ShopState( );
		victoryState = new VictoryState();
		//add more states
		
		
		State.setState(mainMenuState); //THIS CAN CHANGE, YOU CAN MAKE THIS MENU STATE
	
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
		
		int fps = 15;
		
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer=0;//for fps counter, rename maybe?
		int ticks=0;//for fps counter, rename maybe?
		
		/*
		 * Game loop:
		 * 	update all variables, positions of objects etc
		 * 	render(draw) everything to screen
		 */
		while(isRunning){
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
	
	

	
	public KeyManager getKeyManager() {//TODO move to gamemanager
		return keyManager;
	}
	
	
	public MouseManager getMouseManager() {//TODO move to gamemanager
		return mouseManager;
	}
	
	
	
	/**
	 *	UPDATE: move to game manager TODO might wanna move this to gamestate since I think it's only used there 
	 */
	/*public GameCamera getGameCamera(){
		return gameCamera;
	}*/



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



	

}
