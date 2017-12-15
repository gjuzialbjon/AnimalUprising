package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;


//placeholder class
public class MainMenuState extends State {

	
	private UIManager uiManager;

	public MainMenuState( ) {
		super( );
		// TO DO Auto-generated constructor stub
		UIBackground bg=new UIBackground(ImageManager.mainMenuBackground);
		UIButton playButton = new UIButton(350, 100, 300, 100,ImageManager.playButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getGameMenuState());	
			}
		});
		UIButton shopButton = new UIButton(350, 200, 300, 100,ImageManager.shopButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getShopState());
			}
		});
		UIButton settingsButton = new UIButton(350,300 , 300, 100,ImageManager.settingsButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getSettingsState());
				
			}
		});
		UIButton howToButton = new UIButton(350, 400, 300, 100,ImageManager.howToButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getHowToPlayState());
			}
		});
		UIButton quitButton = new UIButton(350,500,300,100,ImageManager.quitButton,new ClickAction() {
			
			@Override
			public void onClick() {
				System.exit(0);
				
			}
		});
		
		uiManager = new UIManager();
		uiManager.addComponent(bg);
		uiManager.addComponent(playButton);
		uiManager.addComponent(shopButton);
		uiManager.addComponent(settingsButton);
		uiManager.addComponent(howToButton);
		uiManager.addComponent(quitButton);
		
		//debug
		
		
		
		uiManager.addComponent(new UIButton(100, 100, 100, 50,new ClickAction() {	
			@Override
			public void onClick() {
				State.setState(game.getGameState());			
			}
		}));
	}

	@Override
	public void tick() {
		// TO DO Auto-generated method stub
		
		
		//DEBUG CODE
		//System.out.println("mousepos:"+game.getMouseManager().getMouseX()+" "+game.getMouseManager().getMouseY());
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		// TO DO Auto-generated method stub
		
		
		//debug
		uiManager.render(g);
	}

}
