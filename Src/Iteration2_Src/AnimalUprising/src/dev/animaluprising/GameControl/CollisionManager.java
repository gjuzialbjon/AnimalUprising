package dev.animaluprising.GameControl;
import java.util.ArrayList;

import dev.animaluprising.GameModel.Ally;
import dev.animaluprising.GameModel.Bear;
import dev.animaluprising.GameModel.CastleObject;
import dev.animaluprising.GameModel.Crusader;
import dev.animaluprising.GameModel.Dog;
import dev.animaluprising.GameModel.Enemy;
import dev.animaluprising.GameModel.HealSkill;
import dev.animaluprising.GameModel.HeroObject;
import dev.animaluprising.GameModel.Infantry;
import dev.animaluprising.GameModel.Knight;
import dev.animaluprising.GameModel.Monkey;
import dev.animaluprising.GameModel.MonkeyAttack;
import dev.animaluprising.GameModel.SpeedBuffSkill;
import dev.animaluprising.GameModel.Tortoise;

public class CollisionManager {
	
	GameManager game=GameManager.getGame();
	public CollisionManager()
	{
		
	}
	
	public boolean collision(Ally ally, ArrayList<Enemy> enemies )
	{
		for(int i = 0; i < enemies.size(); i++)
		{

			Enemy target = enemies.get(i);
			String className = target.getClass().getName();
			if(ally instanceof Monkey)
			{
				if(((Monkey)ally).getRangedCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
				{
					if(ally.getCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
					{
					
						System.out.println(((Monkey)ally).getHealth());
						return ((Monkey)ally).updateHealth(LevelManager.getDamage(className));

					}

					return true;
				}
			}
			if(ally.getCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
			{
			
				if(ally instanceof Bear)
				{
					return ((Bear)ally).updateHealth(LevelManager.getDamage(className));
				}
				else if(ally instanceof Dog)
				{

					return ((Dog)ally).updateHealth(LevelManager.getDamage(className));
				}
				
				else if(ally instanceof Tortoise)
				{

					return ((Tortoise)ally).updateHealth(LevelManager.getDamage(className));
				}
				else if(ally instanceof HeroObject)
				{

					return ((HeroObject)ally).updateHealth(LevelManager.getDamage(className));
				}
				else if(ally instanceof MonkeyAttack)
				{
					
				}
				
				return true;
			}
		}
		return false;
	}
	
	public boolean collision(Enemy enemy, ArrayList<Ally> allies )
	{
		for(int i = 0; i < allies.size(); i++)
		{
				Ally target = allies.get(i);
				if(target instanceof Monkey)
				{
					if(enemy.getCollisionRectangle().intersects(((Monkey)target).getRangedCollisionRectangle()))
					{
						((Monkey)target).throwProjectile();
					}
				}
			
				if(enemy.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
				{
					String className = target.getClass().getName();
					
					
					if(enemy instanceof Infantry)
					{

						((Infantry)enemy).updateHealth(ShopManager.getDamage(className));

						System.out.println(((Infantry)enemy).getHealth());

					}
					else if(enemy instanceof Knight)
					{

						((Knight)enemy).updateHealth(ShopManager.getDamage(className));

					}
					
					else if(enemy instanceof Crusader)
					{
						((Crusader)enemy).updateHealth(ShopManager.getDamage(className));

					}

					else if(enemy instanceof CastleObject)
					{

						((CastleObject)enemy).updateHealth(ShopManager.getDamage(className));
						System.out.println(((CastleObject)enemy).getHealth() + " target= " + className);

					}

					return true;
				}					
		}
		//}
		return false;
	}
	
	public boolean helpfullSkillCollision(Ally ally, ArrayList<Ally> allies)
	{
		if(ally instanceof HealSkill)
		{

			for(int i = 0; i < allies.size(); i++)
			{
				
				if(ally.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
				{
					Ally target = allies.get(i);
					String className = ally.getClass().getName();
				
					if(target instanceof Bear)
					{
						return ((Bear)target).updateHealth(ShopManager.getDamage(className));
					}
					else if(target instanceof Dog)
					{

						return ((Dog)target).updateHealth(ShopManager.getDamage(className));
					}
					

					else if(target instanceof Monkey)
					{


						return ((Monkey)target).updateHealth(ShopManager.getDamage(className));
					}


					else if(target instanceof Tortoise)
					{

						return ((Tortoise)target).updateHealth(ShopManager.getDamage(className));
					}
					else if(target instanceof HeroObject)
					{

						return ((HeroObject)target).updateHealth(ShopManager.getDamage(className));
					}	
					return true;
				}
			}
			return false;
		
		}
		else if(ally instanceof SpeedBuffSkill)
		{
			for(int i = 0; i < allies.size(); i++)
			{
				
				if(ally.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
				{
					Ally target = allies.get(i);
					String className = ally.getClass().getName();
				
					if(target instanceof Bear)
					{
						return ((Bear)target).updateSpeed(ShopManager.getSpeed(className));
					}
					else if(target instanceof Dog)
					{

						return ((Dog)target).updateSpeed(ShopManager.getSpeed(className));
					}
					

					else if(target instanceof Monkey)
					{


						return ((Monkey)target).updateSpeed(ShopManager.getSpeed(className));
					}


					else if(target instanceof Tortoise)
					{

						return ((Tortoise)target).updateSpeed(ShopManager.getSpeed(className));
					}
					else if(target instanceof HeroObject)
					{

					//	return ((HeroObject)target).updateSpeed(ShopManager.getSpeed(className));
						return true;
					}	
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	
}
