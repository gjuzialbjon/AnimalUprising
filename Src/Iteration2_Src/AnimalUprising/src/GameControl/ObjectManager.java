/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * ObjectManager is the class for managing the GameObjects, 
 * it has addObject method which adds an GameObject to the ObjectList
 * and sets cooldown to the object added. 
 * Note: the cooldown mechanism does not work at the moment, it will be fixed for the next iteration
 */



package GameControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import GameModel.Ally;
import GameModel.Bear;
import GameModel.CastleObject;
import GameModel.Crusader;
import GameModel.Dog;
import GameModel.Enemy;
import GameModel.GameObject;
import GameModel.HealSkill;
import GameModel.HeroObject;
import GameModel.Infantry;
import GameModel.Knight;
import GameModel.Monkey;
import GameModel.Skills;
import GameModel.Tortoise;
public class ObjectManager 
{
	private ArrayList<Ally> allyList;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Skills> skillList;
	private int allyCount, enemyCount,skillCount;
	private Timer objectTimer;
	private boolean bearCD, dogCD, monkeyCD, tortoiseCD, infantryCD, knightCD, crusaderCD, healCD, speedCD, hailCD, ravenCD;
	public ObjectManager() 
	{
		objectTimer = new Timer();
		allyCount = 0;
		enemyCount = 0;
		allyList = new ArrayList<>();
		enemyList = new ArrayList<>();
		skillList = new ArrayList<>();
		bearCD = false;
		dogCD = false;
		monkeyCD= false;
		tortoiseCD= false;
		infantryCD= false;
		knightCD= false;
		crusaderCD= false;
		healCD = false;
		speedCD = false;
		hailCD = false;
		ravenCD = false;
	}

	public ArrayList<Ally> getAllies() {
		return allyList;
	}
	public ArrayList<Enemy> getEnemies(){
		return enemyList;
	}
	public ArrayList<Skills> getSkills(){
		return skillList;
	}
	
	public void addObject(GameObject x)
	{
		if(x instanceof Bear && !bearCD)
		{
			increaseAllyCount();
			allyList.add((Bear)x);
			bearCD = true;
			objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						bearCD = false;
					}
				}, 20*100);
					
		}
		else if(x instanceof Dog && !dogCD)
		{
			
			increaseAllyCount();
			allyList.add((Dog)x);	
			dogCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					dogCD = false;
				}
			}, 20*100);
		
		}
		else if(x instanceof Monkey && !monkeyCD)
		{
		
				increaseAllyCount();
				allyList.add((Monkey)x);	
				monkeyCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						monkeyCD = false;
					}
				}, 20*100);
			
		}
		else if(x instanceof Tortoise && !tortoiseCD)
		{
				increaseAllyCount();
				allyList.add((Tortoise)x);
				tortoiseCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						tortoiseCD = false;
					}
				}, 20*100);
			
		}
		else if(x instanceof Infantry && !infantryCD)
		{
				increaseEnemyCount();
				enemyList.add((Infantry)x);	
				infantryCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						infantryCD = false;
					}
				}, 20*100);
			
		}
		else if(x instanceof Knight && !knightCD)
		{
				increaseEnemyCount();
				enemyList.add((Knight)x);	
				knightCD = true; 
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						knightCD = false;
					}
				}, 20*100);
			
		}
		else if(x instanceof Crusader && !crusaderCD)
		{
				increaseEnemyCount();
				enemyList.add((Crusader)x);	
				crusaderCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						crusaderCD = false;
					}
				}, 40*100);
			
		}
		else if (x instanceof HeroObject)
		{
			increaseAllyCount();
			allyList.add((HeroObject)x);
		}
		else if(x instanceof CastleObject)
		{
			increaseEnemyCount();
			enemyList.add((CastleObject)x);
		}
		else if(x instanceof HealSkill)
		{
			increaseSkillCount();
			
		}
	}
		
	public int getAllyCount()
	{
		return allyCount;
	}
	
	public int getEnemyCount()
	{
		return enemyCount;
	}
	
	
	public void decreaseAllyCount()
	{
		allyCount -=1;
	}
	public void increaseAllyCount()
	{
		allyCount += 1;
	}
	

	public void decreaseEnemyCount()
	{
		enemyCount -=1;
	}
	public void increaseEnemyCount()
	{
		enemyCount += 1;
	}
	public void decreaseSkillCount()
	{
		skillCount -=1;
	}
	public void increaseSkillCount()
	{
		skillCount += 1;
	}
	
	
}
