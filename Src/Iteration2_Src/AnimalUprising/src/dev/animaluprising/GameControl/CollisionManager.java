/*
 * CollisionManager Class
 * CollisionManager Class, which keeps the methods for checking collisions between objects
 * And updating their healths/movement speeds.
 * @ author: Bora Ecer
 * @ version  13.12.2016
 */


package dev.animaluprising.GameControl;
import java.util.ArrayList;

import dev.animaluprising.GameModel.Ally;
import dev.animaluprising.GameModel.Bear;
import dev.animaluprising.GameModel.CastleObject;
import dev.animaluprising.GameModel.Crusader;
import dev.animaluprising.GameModel.Dog;
import dev.animaluprising.GameModel.Enemy;
import dev.animaluprising.GameModel.HailStrike;
import dev.animaluprising.GameModel.HealSkill;
import dev.animaluprising.GameModel.HeroObject;
import dev.animaluprising.GameModel.Infantry;
import dev.animaluprising.GameModel.Knight;
import dev.animaluprising.GameModel.Monkey;
import dev.animaluprising.GameModel.MonkeyAttack;
import dev.animaluprising.GameModel.RavenStrike;
import dev.animaluprising.GameModel.SpeedBuffSkill;
import dev.animaluprising.GameModel.Tortoise;

public class CollisionManager {

	//GameManager object.
	public GameManager game=GameManager.getGame();
	
	//Default Contstructor
	public CollisionManager(){}

	/*
	 * Collision method:
	 * which checks the collision of a certain Ally instance, which is not Monkey instance
	 * and the enemy instances in the enemies list of ObjectManager.
	 * After the collision between the ally and one enemy object is confirmed, 
	 * the method updates the health of the Ally object. according to the damage of the collised enemy object
	 * and immediately returns, ending the possibility of the collising other enemy objects.
	 */
	public boolean collision(Ally ally, ArrayList<Enemy> enemies )
	{
		//Loop that iterates through enemies list.
		for(int i = 0; i < enemies.size(); i++)
		{
			Enemy target = enemies.get(i);
			String className = target.getClass().getName();
			/*
			 * The function also provides a ranged collision for Monkey instance of Ally.
			 * Monkey has two collision types: a normal collision, which checks if an enemy can attack the monkey.
			 * and a ranged collision, which checks, if the enemy is in range of monkey,
			 * so that the monkey can launch a Monkey Attack ranged attack.
			 */
			if(ally instanceof Monkey)
			{
				if(((Monkey)ally).getRangedCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
				{
					if(ally.getCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
					{
						//Updates the health of the Monkey, with the collised enemy's damage.
						return ((Monkey)ally).updateHealth(LevelManager.getDamage(className));
					}
					//Returns true so that the monkey animation would stop moving forward and start throwing projectiles.
					return true;
				}
			}
			
			//Determines if the Ally instance is in melee range of Enemy instances
			if(ally.getCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
			{
				//If ally is bear, update this bear instance's health with respect to the targetted enemy instance
				if(ally instanceof Bear)
				{
					return ((Bear)ally).updateHealth(LevelManager.getDamage(className));
				}

				//If ally is dog, update this dog instance's health with respect to the targetted enemy instance
				else if(ally instanceof Dog)
				{

					return ((Dog)ally).updateHealth(LevelManager.getDamage(className));
				}

				//If ally is Tortoise, update this Tortoise instance's health with respect to the targetted enemy instance
				else if(ally instanceof Tortoise)
				{

					return ((Tortoise)ally).updateHealth(LevelManager.getDamage(className));
				}

				//If ally is HeroObject, update the HeroObject instance's health with respect to the targetted enemy instance
				else if(ally instanceof HeroObject)
				{

					return ((HeroObject)ally).updateHealth(LevelManager.getDamage(className));
				}
				//Returns true for the other ally instances which cannot be attacked by the enemies: RavenStrike, HailStrike, HealSpell, SpeedBuffSpell
				return true;
			}
		}
		return false;
	}

	/*
	 * The same Collision method, but for targetting of ally instances for a single Enemy instance
	 * This function also acts differently for the Monkey instance
	 * As mentioned above, the Monkey launches a MonkeyAttack projectile 
	 * if the Enemy instance is in Monkey's range. 
	 * 
	 */
	public boolean collision(Enemy enemy, ArrayList<Ally> allies )
	{
		//For loop iterates through allies
		for(int i = 0; i < allies.size(); i++)
		{
			//gets targetted ally instance
			Ally target = allies.get(i);
			//If target is Monkey
			if(target instanceof Monkey)
			{
				//Checks ranged collision
				if(enemy.getCollisionRectangle().intersects(((Monkey)target).getRangedCollisionRectangle()))
				{
					//Monkey launces a MonkeyAttack.
					((Monkey)target).throwProjectile();
				}
			}

			//Checks the allies, and updates the Enemy's health according to it.
			if(enemy.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
			{
				String className = target.getClass().getName();
				//If the Enemy is an instance of Infantry, decrease it's health according to the targetted Ally.
				if(enemy instanceof Infantry)
				{
					((Infantry)enemy).updateHealth(ShopManager.getDamage(className));
					
					//If the targetted Ally is a skill, then the Enemy should not stop moving.
					if(target instanceof RavenStrike || target instanceof HailStrike)
					{
						return false;
					}
					else
					{
						return true;
					}
				}

				//If the Enemy is an instance of Knight, decrease it's health according to the targetted Ally.
				else if(enemy instanceof Knight)
				{

					((Knight)enemy).updateHealth(ShopManager.getDamage(className));
					//If the targetted Ally is a skill, then the Enemy should not stop moving.
					if(target instanceof RavenStrike || target instanceof HailStrike)
					{
						return false;
					}
					else
					{
						return true;
					}
				}

				//If the Enemy is an instance of Crusader, decrease it's health according to the targetted Ally.
				else if(enemy instanceof Crusader)
				{
					((Crusader)enemy).updateHealth(ShopManager.getDamage(className));
					//If the targetted Ally is a skill, then the Enemy should not stop moving.
					if(target instanceof RavenStrike || target instanceof HailStrike)
					{
						return false;
					}
					else
					{
						return true;
					}
				}

				//If the Enemy is the CastleObject, decrease it's health according to the targetted Ally.
				else if(enemy instanceof CastleObject)
				{

					((CastleObject)enemy).updateHealth(ShopManager.getDamage(className));
					//If the targetted Ally is a skill, then the Enemy should not stop moving.
					if(target instanceof RavenStrike || target instanceof HailStrike)
					{
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					//Returns false, just incase.
					return false;
				}
			}					
		}
		return false;
	}

	/*
	 * helpfullSkillCollision method,
	 * which checks the collision between an Ally instance, which can only be HealSkill or SpeedBuffSkill
	 * and updates the health/movement speed of the collised non-skill Ally instances which can only be: HeroObject, Bear, Dog, Tortoise or Monkey.
	 */
	public boolean helpfullSkillCollision(Ally ally, ArrayList<Ally> allies)
	{
		//For the HealSkill, the health of the collised ally instances will be increased.
		if(ally instanceof HealSkill)
		{
			for(int i = 0; i < allies.size(); i++)
			{
				if(ally.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
				{
					Ally target = allies.get(i);
					String className = ally.getClass().getName();
					
					if(target instanceof Bear && ((Bear)target).getHealth() < ShopManager.getMaxBearHealth())
					{
						return ((Bear)target).updateHealth(ShopManager.getHealAmount());

					}
					else if(target instanceof Dog && ((Dog)target).getHealth() < ShopManager.getMaxDogHealth())
					{

						return ((Dog)target).updateHealth(ShopManager.getHealAmount());
					}


					else if(target instanceof Monkey && ((Monkey)target).getHealth() < ShopManager.getMaxMonkeyHealth())
					{

						return ((Monkey)target).updateHealth(ShopManager.getHealAmount());
					}

					else if(target instanceof Tortoise && ((Tortoise)target).getHealth() < ShopManager.getMaxTortoiseHealth())
					{
						return ((Tortoise)target).updateHealth(ShopManager.getHealAmount());
					}
					else if(target instanceof HeroObject && ((HeroObject)target).getHealth() < ShopManager.getMaxHeroHealth())
					{
						return ((HeroObject)target).updateHealth(ShopManager.getHealAmount());
					}	
					return true;
				}
			}
			return false;

		}
		//If the skill is SpeedBuffSkill, then the movement speed of the collised ally objects will be increased.
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
					return true;
				}
			}
			return false;
		}
		return false;
	}


}
