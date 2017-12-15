package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ObjectManager;
import dev.animaluprising.GameModel.CastleObject;
import dev.animaluprising.GameModel.GameObject;
import dev.animaluprising.GameModel.HeroObject;

public class GameState extends State
{

	private GameObject hero;
	private GameObject castle;
	private boolean gameOver;
	private boolean victory;
	public GameState()
	{
		super();
		game.setObjectManager(new ObjectManager());
		hero = new HeroObject(0,400,30,40);
		castle = new CastleObject(800, 400, 100, 100);
		gameOver = false;
		victory = false;
		game.getObjectManager().addObject(hero);
		game.getObjectManager().addObject(castle);

	}
	
	
	@Override
	public void tick()
	{
		if(((HeroObject)hero).getHealth() <= 0)
		{
			gameOver = true;
		}
		
		if(((CastleObject)castle).getHealth() <= 0)
		{
			victory = true;
		}
		
		if(!gameOver && !victory)
		{

			int i = 0; 
			while(i < game.getObjectManager().getAllyCount())
			{
			
				((GameObject)(game.getObjectManager().getAllies().get(i))).update();
					
				i++;
			}
			i = 0; 
			while(i < game.getObjectManager().getEnemyCount())
			{
				((GameObject)(game.getObjectManager().getEnemies().get(i))).update();
					
				i++;
			}
			
		}
		else if (gameOver || victory )
		{
			//end the game process. 
			//Stop the timers.
			game.getObjectManager().stopTimer();
			game.getObjectManager().getAllies().clear();
			game.getObjectManager().getEnemies().clear();
		}
		
	}

	@Override
	public void render(Graphics graphics) 
	{
		if(!gameOver && !victory)
		{
			/*
			graphics.drawRect(0,700, 900, 10);
			graphics.setColor(Color.black);
			graphics.fillRect(0, 700, 900, 10);
			graphics.drawImage(ImageManager.heroImage, 50, 725, 100, 100, null);
			graphics.drawRect(160, 700, 10, 200);
			graphics.fillRect(160, 700, 10, 200);
			graphics.drawImage(ImageManager.catImage, 210, 725, 100, 100, null);
			graphics.drawString("Bear", 210, 850);
			graphics.drawString("Food:"+ShopManager.getBearRequiredFood(), 210, 875);
			*/
			graphics.drawImage(ImageManager.floor, 0, 0, 900, 900, null);
			//graphics.drawString("Mana" +((HeroObject)hero).getMana(), 0, 200);
			int i = 0; 
			while(i < game.getObjectManager().getAllyCount())
			{
				try {
					graphics.drawString("press 1-2 for soldier summon", 150, 150);
					graphics.drawString("Press A-D to move hero", 150, 200);
					((GameObject)(game.getObjectManager().getAllies().get(i))).render(graphics);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				i++;
			}
			i = 0; 
			while(i < game.getObjectManager().getEnemyCount())
			{
				try {
					graphics.drawString("press 1-2 for soldier summon", 150, 150);
					graphics.drawString("Press A-D to move hero", 150, 200);
					((GameObject)(game.getObjectManager().getEnemies().get(i))).render(graphics);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				i++;
			}
			i = 0;
			while(i < game.getObjectManager().getDeadObjectCount())
			{
				try {
					game.getObjectManager().getDeadObjects().get(i).renderDead(graphics);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				i++;
			}
		}
		else if (!gameOver && victory )
		{
			State.setState(game.getVictoryState());
			game.setGameState(new GameState());
			graphics.drawString("VICTORRRYYYYY!", 150, 150);
		}
		else if(gameOver && !victory)
		{
			game.setGameState(new GameState());
			graphics.drawString("GAME OVER", 150, 150);
		}
		

		
	}

}
