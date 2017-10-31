package GameControl.States;

import java.awt.Graphics;

import GameControl.GameManager;
import GameModel.CastleObject;
import GameModel.HeroObject;
import GameModel.Soldier;

public class GameState extends States
{

	private HeroObject hero;
	private CastleObject castle;
	public GameState(GameManager gameManager)
	{
		super(gameManager);
		hero = new HeroObject(0,400,30,40,gameManager);
		castle = new CastleObject(500, 400, 100, 100, gameManager);
	}
	
	@Override
	public void update()
	{
		hero.update();
		castle.update();
	}

	@Override
	public void render(Graphics graphics) 
	{
		hero.render(graphics);
		castle.render(graphics);
	}

}
