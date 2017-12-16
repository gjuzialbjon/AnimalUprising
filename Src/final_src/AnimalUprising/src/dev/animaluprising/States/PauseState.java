package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;
/**
 * @author Ata Gun Ogun
 * 
 * Pause screen and its elements are defined here
 * */
public class PauseState extends State {
	private UIManager uiManager;

	public PauseState( ) {
		super( );
		uiManager = new UIManager();
		
		UIBackground bg = new UIBackground(ImageManager.pauseBackground);

		
		UIButton resumeButton = new UIButton(392, 200, 240, 80,ImageManager.resumeButton, new ClickAction() {
			
			@Override
			public void onClick() {
				State.setState(game.getGameState());
			}
		});
		
		UIButton resetLevelButton = new UIButton(392,400,240,80,ImageManager.resetLevelButton,new ClickAction() {
			
			@Override
			public void onClick() {
				
				game.setGameState(new GameState());
				State.setState(game.getGameState());
			}
		});
		
		UIButton quitToMainButton = new UIButton(392, 600, 240, 80, ImageManager.quitToMain, new ClickAction() {
			
			@Override
			public void onClick() {
				game.setGameState(new GameState());
				State.setState(game.getMainMenuState());
			}
		});
		
		
		uiManager.addComponent(bg);
		uiManager.addComponent(resumeButton);
		uiManager.addComponent(resetLevelButton);
		uiManager.addComponent(quitToMainButton);
		
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
