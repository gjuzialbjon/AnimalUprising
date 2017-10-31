package GameControl.States;

import java.awt.Graphics;

import GameControl.GameManager;
import GameModel.CastleObject;
import GameModel.Dog;
import GameModel.GameObject;
import GameModel.HeroObject;

public class GameState extends States
{

	private HeroObject hero;
	private CastleObject castle;
	private GameObject dog;
	public GameState(GameManager gameManager)
	{
		super(gameManager);
		hero = new HeroObject(0,400,30,40,100,gameManager);
		castle = new CastleObject(500, 400, 100, 100, 100,gameManager);
		dog = new Dog(100, 300, 30, 40, 100, gameManager);
	}
	
	@Override
	public void update()
	{
		hero.update();
		castle.update();
		dog.update();
	}

	@Override
	public void render(Graphics graphics) 
	{
		hero.render(graphics);
		castle.render(graphics);
		dog.render(graphics);
	}

}
