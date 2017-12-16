package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.SoundManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;
import dev.animaluprising.UIManagement.UITextButton;

/**
 *	@author Ata Gun Ogun
 *
 * this class defines the settings screen
 * 
 */
public class SettingsState extends State {

	private UIManager uiManager;
	
	public SettingsState( ) {
		super( );
		UIBackground bg = new UIBackground(ImageManager.settingsBackground);
		UIButton backButton = new UIButton(800, 650, 200, 100,ImageManager.backButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getMainMenuState());	
			}
		});
		UIButton toggleMusic = new UITextButton(388,299,250,100,"toggle music",new ClickAction() {
			
			@Override
			public void onClick() {

			}
		});
		
		uiManager=new UIManager();
		uiManager.addComponent(bg);
		uiManager.addComponent(backButton);
		uiManager.addComponent(toggleMusic);
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
