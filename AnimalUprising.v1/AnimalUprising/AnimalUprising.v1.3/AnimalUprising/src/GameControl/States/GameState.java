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
		hero = new HeroObject(0,400,30,40,100,gameManager);
		castle = new CastleObject(500, 400, 100, 100, 100,gameManager);
		
		gameManager.getObjectManager().addObject(hero);
		gameManager.getObjectManager().addObject(castle);
		
	}
	
	
	@Override
	public void update()
	{
		int i = 0; 
		while(i < gameManager.getObjectManager().getObjectCount())
		{
			if(gameManager.getObjectManager().getObjects().get(i).getPosX() == gameManager.getGameEngine().getWidth())
			{
				gameManager.getObjectManager().getObjects().get(i).die();
			}
			else
			{
				gameManager.getObjectManager().getObjects().get(i).update();
				startCooldown(gameManager.getObjectManager().getObjects().get(i));
			}
			i++;
		}
	}

	@Override
	public void render(Graphics graphics) 
	{
		int i = 0; 
		while(i < gameManager.getObjectManager().getObjectCount())
		{
			try {
				gameManager.getObjectManager().getObjects().get(i).render(graphics);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			i++;
		}
	}
	public void startCooldown(GameObject x)
	{
		if(x instanceof Bear)
		{
			if(((Bear)x).isCooldown())
			{
				((Bear)x).decreaseSpawnCooldown(); 
				if(((Bear)x).getSpawnCooldown() == 0)
				{
					((Bear)x).setCooldown(false);
					((Bear)x).resetTimer();
				}
			}
		}
		else if(x instanceof Dog)
		{
			if(((Dog)x).isCooldown())
			{
				((Dog)x).decreaseSpawnCooldown(); 
				if(((Dog)x).getSpawnCooldown() == 0)
				{
					((Dog)x).setCooldown(false);
					((Dog)x).resetTimer();
				}
			}
		}
		else if(x instanceof Monkey)
		{
			if(((Monkey)x).isCooldown())
			{
				((Monkey)x).decreaseSpawnCooldown();
				if(((Monkey)x).getSpawnCooldown() == 0)
				{
					((Monkey)x).setCooldown(false);
					((Monkey)x).resetTimer();
				}
			}
		}
		else if(x instanceof Tortoise)
		{
			if(((Tortoise)x).isCooldown())
			{
				((Tortoise)x).decreaseSpawnCooldown();
				if(((Tortoise)x).getSpawnCooldown() == 0)
				{
					((Tortoise)x).setCooldown(false);
					((Tortoise)x).resetTimer();
				}
			}
		}
		else if(x instanceof Infantry)
		{
			if(((Infantry)x).isCooldown())
			{
				((Infantry)x).decreaseSpawnCooldown();
				if(((Infantry)x).getSpawnCooldown() == 0)
				{
					((Infantry)x).setCooldown(false);
					((Infantry)x).resetTimer();
				}
			}
		}
		else if(x instanceof Knight)
		{
			if(((Knight)x).isCooldown())
			{
				((Knight)x).decreaseSpawnCooldown();
				if(((Knight)x).getSpawnCooldown() == 0)
				{
					((Knight)x).setCooldown(false);
					((Knight)x).resetTimer();
				}
			}
		}
		else if(x instanceof Crusader)
		{
			if(((Crusader)x).isCooldown())
			{
				((Crusader)x).decreaseSpawnCooldown();
				if(((Crusader)x).getSpawnCooldown() == 0)
				{
					((Crusader)x).setCooldown(false);
					((Crusader)x).resetTimer();
				}
			}		
		}
		
	}

}
