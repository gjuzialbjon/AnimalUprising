package GameControl;
import java.util.ArrayList;

import GameModel.Ally;
import GameModel.Enemy;
import GameModel.GameObject;
import GameModel.Skills;
public class CollisionManager {

	public static boolean collision(Ally ally, ArrayList<Enemy> enemies )
	{
		for(int i = 0; i < enemies.size(); i++)
		{
			if(ally.getCollisionRectangle().intersects(enemies.get(i).getCollisionRectangle()))
			{
				Enemy target = enemies.get(i);
				
				((GameObject)ally).updateHealth((((GameObject)target).getDamage()));
				return true;
			}
		}
		return false;
	}
	public static boolean collision(Enemy enemy, ArrayList<Ally> allies )
	{
		for(int i = 0; i < allies.size(); i++)
		{
			if(enemy.getCollisionRectangle().intersects(allies.get(i).getCollisionRectangle()))
			{
				Ally target = allies.get(i);
				
				((GameObject)enemy).updateHealth((((GameObject)target).getDamage()));
				return true;
			}
		}
		return false;
	}
	public static boolean helpfullSkillCollision(Skills skill, ArrayList<Ally> allies)
	{
		
		return false;
		
	}
}
