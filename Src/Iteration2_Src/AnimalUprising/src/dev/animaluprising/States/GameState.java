/*
 * Author: Bora Ecer
 * GameState class
 * Date: 1 November 2017
 * Version: 13.12.2017
 * Class which includes tick and render methods for the game state. 
 */
package dev.animaluprising.States;

import java.awt.Graphics;

import dev.animaluprising.GameControl.ImageManager;
import dev.animaluprising.GameControl.ObjectManager;
import dev.animaluprising.GameControl.ShopManager;
import dev.animaluprising.GameModel.CastleObject;
import dev.animaluprising.GameModel.GameObject;
import dev.animaluprising.GameModel.HeroObject;

public class GameState extends State
{

	//Attributes
	private GameObject hero;
	private GameObject castle;
	private boolean gameOver;
	private boolean victory;
	//Constructor
	public GameState()
	{
		super();
		game.setObjectManager(new ObjectManager());
		hero = new HeroObject(0,400,30,40);
		castle = new CastleObject(750, 250, 300, 300);
		gameOver = false;
		victory = false;
		game.getObjectManager().addObject(hero);
		game.getObjectManager().addObject(castle);
	}
	
	//tick method
	@Override
	public void tick()
	{
		//Checks whether the game state is over or not.
		if(((HeroObject)hero).getHealth() <= 0)
		{
			gameOver = true;
		}
		
		if(((CastleObject)castle).getHealth() <= 0)
		{
			victory = true;
		}
		
		//if GameState is not over
		if(!gameOver && !victory)
		{
			//updates the allies, and enemies
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
		//if the Game State is over, clears the allies and enemies list, and stops the cooldown timers.
		else if (gameOver || victory )
		{
			//end the game process. 
			//Stop the timers.
			game.getObjectManager().stopTimer();
			game.getObjectManager().getAllies().clear();
			game.getObjectManager().getEnemies().clear();
		}
		
	}

	//Render
	@Override
	public void render(Graphics graphics) 
	{
		if(!gameOver && !victory)
		{
			//if game state is not over, renders the floor and renders the updated allies and enemies and the dead objects for death animations.
			graphics.drawImage(ImageManager.floor, 0, 0, 1024, 568, null);
			int i = 0; 
			while(i < game.getObjectManager().getAllyCount())
			{
				try {
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
		//if game ended with castle being destroyed, changes state to victory state.
		else if (!gameOver && victory )
		{
			State.setState(game.getVictoryState());
			game.setGameState(new GameState());
		}

		//if game ended with hero being dead, changes state to game over state.
		else if(gameOver && !victory)
		{
			game.setGameState(new GameState());
			graphics.drawString("GAME OVER", 150, 150);
		}
	}

}
