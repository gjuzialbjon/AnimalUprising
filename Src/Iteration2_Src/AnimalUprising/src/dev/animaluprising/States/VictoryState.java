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
public class VictoryState extends State {

	private UIManager uiManager;
	
	public VictoryState( ) {
		super( );
		UIBackground bg = new UIBackground(ImageManager.victoryScreen);
		UIButton menuButton = new UIButton(800, 650, 200, 100,ImageManager.mainMenuButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getMainMenuState());	
			}
		});
		
		uiManager=new UIManager();
		uiManager.addComponent(bg);
		uiManager.addComponent(menuButton);
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
