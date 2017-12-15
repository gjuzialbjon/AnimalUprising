package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;
// placeholder class, this should heavily use ShopManager(not written yet at the time of adding this comment)
public class ShopState extends State{

	private UIManager uiManager;
	
	public ShopState( ) {
		super( );
		UIButton backButton = new UIButton(800, 650, 200, 100,ImageManager.backButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getMainMenuState());	
			}
		});
		
		uiManager=new UIManager();
		uiManager.addComponent(backButton);
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
