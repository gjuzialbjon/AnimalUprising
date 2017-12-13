package GameControl.States;

import java.awt.Graphics;

import GameControl.GameManager;
import GameModel.Bear;
import GameModel.CastleObject;
import GameModel.Crusader;
import GameModel.Dog;
import GameModel.GameObject;
import GameModel.HeroObject;
import GameModel.Infantry;
import GameModel.Knight;
import GameModel.Monkey;
import GameModel.Tortoise;

public class GameState extends States
{

	private GameObject hero;
	private GameObject castle;
	public GameState(GameManager gameManager)
	{
		super(gameManager);
		hero = new HeroObject(0,400,30,40,1000,gameManager);
		castle = new CastleObject(500, 400, 100, 100, 1000,gameManager);
		
		gameManager.getObjectManager().addObject(hero);
		gameManager.getObjectManager().addObject(castle);
		
	}
	
	
	@Override
	public void update()
	{
		int i = 0; 
		while(i < gameManager.getObjectManager().getAllyCount())
		{
		
			((GameObject)(gameManager.getObjectManager().getAllies().get(i))).update();
			i++;
		}
		i = 0; 
		while(i < gameManager.getObjectManager().getEnemyCount())
		{
			
			((GameObject)(gameManager.getObjectManager().getEnemies().get(i))).update();
			i++;
		}
	}

	@Override
	public void render(Graphics graphics) 
	{
		int i = 0; 
		while(i < gameManager.getObjectManager().getAllyCount())
		{
			try {
				graphics.drawString("press 1-2 for soldier summon", 150, 150);
				graphics.drawString("Press A-D to move hero", 150, 200);
				((GameObject)(gameManager.getObjectManager().getAllies().get(i))).render(graphics);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			i++;
		}
		i = 0; 
		while(i < gameManager.getObjectManager().getEnemyCount())
		{
			try {
				graphics.drawString("press 1-2 for soldier summon", 150, 150);
				graphics.drawString("Press A-D to move hero", 150, 200);
				((GameObject)(gameManager.getObjectManager().getEnemies().get(i))).render(graphics);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			i++;
		}
	}

}
