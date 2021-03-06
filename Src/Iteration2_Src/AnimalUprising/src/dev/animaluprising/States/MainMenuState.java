package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;

/**
 * @author Ata Gun Ogun
 */
public class MainMenuState extends State {

	
	private UIManager uiManager;

	public MainMenuState( ) {
		super( );
		// TO DO Auto-generated constructor stub
		UIBackground bg=new UIBackground(ImageManager.mainMenuBackground);
		UIButton playButton = new UIButton(350, 250, 300, 90,ImageManager.playButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getGameMenuState());	
			}
		});
		UIButton shopButton = new UIButton(350, 350, 300, 90,ImageManager.shopButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getShopState());
			}
		});
		UIButton settingsButton = new UIButton(350,450 , 300, 90,ImageManager.settingsButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getSettingsState());
				
			}
		});
		UIButton howToButton = new UIButton(350, 550, 300, 90,ImageManager.howToButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getHowToPlayState());
			}
		});
		UIButton quitButton = new UIButton(350,650,300,90,ImageManager.quitButton,new ClickAction() {
			
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
		
		
		
		/*uiManager.addComponent(new UIButton(100, 100, 100, 50,new ClickAction() {	
			@Override
			public void onClick() {
				State.setState(game.getGameState());			
			}
		}));*/
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
