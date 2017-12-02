package dev.animalgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.animalgame.display.Display;
import dev.animalgame.gfx.Assets;
import dev.animalgame.gfx.GameCamera;
import dev.animalgame.states.GameMenuState;
import dev.animalgame.states.GameState;
import dev.animalgame.states.HowToPlayState;
import dev.animalgame.states.MainMenuState;
import dev.animalgame.states.PauseState;
import dev.animalgame.states.SettingsState;
import dev.animalgame.states.ShopState;
import dev.animalgame.states.State;

public class Game implements Runnable{
	
	private int gameWidth=1024,gameHeight=768; //TODO make these final maybe?
	private String gameTitle="Animal Uprising"; //TODO make this final maybe?
	
	private Display display;
	
	private Thread thread;
	private boolean isRunning;
	
	private BufferStrategy bufferStrategy;
	private Graphics g;
	
	//States
	private State gameState;	//TODO might wanna add a getter for this
	private State mainMenuState;
	private State shopState;
	private State gameMenuState;
	private State howToPlayState;
	private State pauseState;
	private State  settingsState;
	
	//input
	private KeyManager keyManager;
	
	
	//camera
	private GameCamera gameCamera;
	
	private Game() {
		//all the field values of the game are the default values given above ie gameTitle gameWidth etc
		keyManager = new KeyManager();
	}

	
	//THIS MAKES THE GAME CLASS A SINGLETON
	private static Game game=null;
	public static Game getGame(){
		if(game == null)
			game = new Game();
		return game;
	}
	//END OF WHAT MAKES THE GAME CLASS A SINGLETON
	

 
	private void initialize(){
		this.display = new Display(gameTitle,gameWidth,gameHeight);
		display.getFrame().addKeyListener(keyManager);
		Assets.initialize();
		
		
		gameCamera = new GameCamera(0,0); //TODO might wanna move this to GameState since I think its only useful there.
		
		//TODO we can do the loading of a saved game here I guess
		
		//initialize all the states
		gameState = new GameState( );
		gameMenuState = new GameMenuState( );
		howToPlayState = new HowToPlayState( );
		pauseState = new PauseState( );
		settingsState = new SettingsState( );
		mainMenuState = new MainMenuState( );
		shopState = new ShopState( );
		//add more states
		
		State.setState(gameState); //THIS CAN CHANE, YOU CAN MAKE THIS MENU STATE
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	/**
	 *	TODO might wanna move this to gamestate since I think it's only used there 
	 */
	public GameCamera getGameCamera(){
		return gameCamera;
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
	
	
	public static void main(String[] args) {
		Game.getGame().start();
		
	}	
	

}
