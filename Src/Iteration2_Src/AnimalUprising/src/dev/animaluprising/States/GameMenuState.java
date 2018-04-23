package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.LevelManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;
/**
 * @author Ata Gun Ogun
 */
public class GameMenuState extends State {

	private UIManager uiManager;
	
	public GameMenuState() {
		super();

		UIBackground bg=new UIBackground(ImageManager.gameMenuBackground);
		UIButton backButton = new UIButton(800, 650, 200, 100,ImageManager.backButton, new ClickAction() {			
			@Override
			public void onClick() {

				State.setState(game.getMainMenuState());	
			}
		});
		UIButton level1 = new UIButton(28, 297, 160, 160,ImageManager.levelButton1, new ClickAction() {			
			@Override
			public void onClick() {
				//TODO burada gameState.setLevel/loadLevel(1) tarzi bir sey yapmak lazim!
				if(LevelManager.unlockedLevels>=1){
					LevelManager.setCurrentLevel(1);
					State.setState(game.getGameState());
				}
			}
		});
		UIButton level2 = new UIButton(237, 297, 160, 160,ImageManager.levelButton2, new ClickAction() {			
			@Override
			public void onClick() {
				//TODO burada gameState.setLevel/loadLevel(1) tarzi bir sey yapmak lazim!
				
				if(LevelManager.unlockedLevels>=2){
					LevelManager.setCurrentLevel(2);
					State.setState(game.getGameState());
				}	
			}
		});
		UIButton level3 = new UIButton(435, 297, 160, 160,ImageManager.levelButton3, new ClickAction() {			
			@Override
			public void onClick() {
				//TODO burada gameState.setLevel/loadLevel(1) tarzi bir sey yapmak lazim!

				if(LevelManager.unlockedLevels>=3){
					LevelManager.setCurrentLevel(3);
					State.setState(game.getGameState());
				}	
			}
		});
		UIButton level4 = new UIButton(641, 297, 160, 160,ImageManager.levelButton4, new ClickAction() {			
			@Override
			public void onClick() {
				//TODO burada gameState.setLevel/loadLevel(1) tarzi bir sey yapmak lazim!

				if(LevelManager.unlockedLevels>=4){
					LevelManager.setCurrentLevel(4);
					State.setState(game.getGameState());
				}	
			}
		});
		UIButton level5 = new UIButton(842, 297, 160, 160,ImageManager.levelButton5, new ClickAction() {			
			@Override
			public void onClick() {
				
				if(LevelManager.unlockedLevels>=5){
					LevelManager.setCurrentLevel(5);
					State.setState(game.getGameState());
				}
			}
		});
		
		
		
		
		
		uiManager = new UIManager();
		uiManager.addComponent(bg);
		uiManager.addComponent(backButton);
		uiManager.addComponent(level1);
		uiManager.addComponent(level2);
		uiManager.addComponent(level3);
		uiManager.addComponent(level4);
		uiManager.addComponent(level5);
		
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
