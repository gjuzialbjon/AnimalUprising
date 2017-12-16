package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ShopManager;
import dev.animaluprising.UIManagement.ClickAction;
import dev.animaluprising.UIManagement.UIBackground;
import dev.animaluprising.UIManagement.UIButton;
import dev.animaluprising.UIManagement.UIManager;
import dev.animaluprising.UIManagement.UITextButton;
// placeholder class, this should heavily use ShopManager(not written yet at the time of adding this comment)
public class ShopState extends State{

	private UIManager uiManager;
	
	UITextButton dogHealth;
	UITextButton bearHealth;
	UITextButton monkeyHealth;
	UITextButton turtleHealth;
	
	UITextButton dogDamage;
	UITextButton bearDamage;
	UITextButton monkeyDamage;
	
	UITextButton healMana;
	UITextButton speedMana;
	UITextButton ravenMana;
	UITextButton hailMana;
	
	UITextButton ravenDamage;
	UITextButton hailDamage;
	
	UITextButton goldDisplay;
	
	ShopManager shop;
	
	public ShopState( ) {
		super( );
		shop = new ShopManager();
		
		UIBackground bg = new UIBackground(ImageManager.shopBackground);
		
		UIButton backButton = new UIButton(800, 650, 200, 100,ImageManager.backButton, new ClickAction() {			
			@Override
			public void onClick() {
				State.setState(game.getMainMenuState());	
			}
		});


		dogHealth = new UITextButton(279, 229, 80, 40, shop.dogGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.upgradeMaxHealth("dev.animaluprising.GameModel.Dog");
				
			}
		});
		bearHealth = new UITextButton(279, 328, 80, 40, shop.bearGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.upgradeMaxHealth("dev.animaluprising.GameModel.Bear");
				
			}
		});
		monkeyHealth = new UITextButton(279, 432, 80, 40, shop.monkeyGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.upgradeMaxHealth("dev.animaluprising.GameModel.Monkey");
				
			}
		});
		turtleHealth = new UITextButton(279, 532, 80, 40, shop.tortoiseGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.upgradeMaxHealth("dev.animaluprising.GameModel.Tortoise");
				
			}
		});
		
		dogDamage = new UITextButton(408, 229, 80, 40, shop.dogGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.updateDamage("dev.animaluprising.GameModel.Dog");
				
			}
		});
		bearDamage = new UITextButton(408, 328, 80, 40, shop.bearGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.updateDamage("dev.animaluprising.GameModel.Bear");
				
			}
		});
		monkeyDamage = new UITextButton(408, 432, 80, 40, shop.monkeyGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.updateDamage("dev.animaluprising.GameModel.Monkey");
				
			}
		});
		
		
		healMana = new UITextButton(765, 239, 80, 48, shop.healGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.decreaseMana("dev.animaluprising.GameModel.HealSkill");
				
			}
		});
		ravenMana = new UITextButton(765, 336, 80, 48, shop.ravenGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.decreaseMana("dev.animaluprising.GameModel.RavenStrike");
				
			}
		});
		hailMana = new UITextButton(765, 420, 80, 48, shop.hailGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.decreaseMana("dev.animaluprising.GameModel.HailStrike");
				
			}
		});
		speedMana = new UITextButton(765, 533, 80, 48, shop.speedGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.decreaseMana("dev.animaluprising.GameModel.SpeedBuffSkill");
				
			}
		});
		
		

		ravenDamage = new UITextButton(888, 336, 80, 48, shop.ravenGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.updateDamage("dev.animaluprising.GameModel.RavenStrike");
				
			}
		});
		hailDamage = new UITextButton(888, 420, 80, 48, shop.hailGold+"", new ClickAction() {
			
			@Override
			public void onClick() {
				shop.updateDamage("dev.animaluprising.GameModel.HailStrike");
				
			}
		});
		
		goldDisplay = new UITextButton(650, 715, 0, 0, game.getCoin()+"",null, new ClickAction() {
			
			@Override
			public void onClick() {
				System.out.println("OUCH! don't do that!!!");
				
			}
		});
		
		
		

		
		uiManager=new UIManager();
		uiManager.addComponent(bg);
		uiManager.addComponent(backButton);
		uiManager.addComponent(dogHealth);
		uiManager.addComponent(bearHealth);
		uiManager.addComponent(monkeyHealth);
		uiManager.addComponent(turtleHealth);
		uiManager.addComponent(dogDamage);
		uiManager.addComponent(bearDamage);
		uiManager.addComponent(monkeyDamage);
		uiManager.addComponent(healMana);
		uiManager.addComponent(ravenMana);
		uiManager.addComponent(hailMana);
		uiManager.addComponent(speedMana);
		uiManager.addComponent(ravenDamage);
		uiManager.addComponent(hailDamage);
		uiManager.addComponent(goldDisplay);
		
		
		
		
	}

	@Override
	public void tick() {
		
		dogHealth.setText(shop.dogGold+"");
		bearHealth.setText(shop.bearGold+"");
		monkeyHealth.setText(shop.monkeyGold+"");
		turtleHealth.setText(shop.tortoiseGold+"");
		dogDamage.setText(shop.dogGold+"");
		bearDamage.setText(shop.bearGold+"");
		monkeyDamage.setText(shop.monkeyGold+"");
		healMana.setText(shop.healGold+"");
		speedMana.setText(shop.speedGold+"");
		ravenMana.setText(shop.ravenGold+"");
		hailMana.setText(shop.hailGold+"");
		ravenDamage.setText(shop.ravenGold+"");
		hailDamage.setText(shop.hailGold+"");
		goldDisplay.setText(game.getCoin()+"");
		
		
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
	}

}
