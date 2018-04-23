/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: 10.12.2017
 * ObjectManager is the class for managing the GameObjects, 
 * it has addObject method which adds an Ally instances to allyList, and Enemy instances to enemyList and dead GameObjects to deadObjects list.
 * and sets cooldown to the object added, and starts the timer. 
 */

package dev.animaluprising.GameControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import dev.animaluprising.GameModel.Ally;
import dev.animaluprising.GameModel.Bear;
import dev.animaluprising.GameModel.CastleObject;
import dev.animaluprising.GameModel.Crusader;
import dev.animaluprising.GameModel.Dog;
import dev.animaluprising.GameModel.Enemy;
import dev.animaluprising.GameModel.GameObject;
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

public class ObjectManager 
{
	//Attributes
	private ArrayList<Ally> allyList;
	private ArrayList<Enemy> enemyList;
	private ArrayList<GameObject> deadObjects;
	private int allyCount, enemyCount,deadObjectCount;
	private Timer objectTimer;
	private boolean bearCD, dogCD, monkeyCD, tortoiseCD, infantryCD, knightCD, crusaderCD, healCD, speedCD, hailCD, ravenCD, monkeyAttackCD;
	private boolean timerCancelled;
	
	//Constructor
	public ObjectManager() 
	{
		objectTimer = new Timer();
		allyList = new ArrayList<>();
		enemyList = new ArrayList<>();
		deadObjects = new ArrayList<>();
		allyCount = 0;
		enemyCount = 0;
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
		monkeyAttackCD = false;	
		timerCancelled = false;
	}


	/*
	 * addObject method, which takes a GameObject, and determies, which game object instance it belongs
	 * and adds to allyList or enemyList based on that. It also sets a cooldown for the class of that instance
	 * So that summoning that instance again is not possible for a while
	 */
	public void addObject(GameObject x)
	{
		//checks the instance, cd state and wheter or not the timer is cancelled
		//The same process is applied for all objects.
		if(x instanceof Bear && !bearCD && !timerCancelled)
		{
			//increases the count
			increaseAllyCount();
			//adds the object to the list
			allyList.add((Bear)x);
			//sets cooldown boolean true
			bearCD = true;
			//starts the timer for cooldown.
			objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						//after the timer is expired, the cooldown is set back to false.
						bearCD = false;
					}
				}, 300);
					
		}
		else if(x instanceof Dog && !dogCD && !timerCancelled)
		{
			
			increaseAllyCount();
			allyList.add((Dog)x);	
			dogCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					dogCD = false;
				}
			}, 200);
		
		}
		else if(x instanceof Monkey && !monkeyCD && !timerCancelled)
		{
		
				increaseAllyCount();
				allyList.add((Monkey)x);	
				monkeyCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						monkeyCD = false;
					}
				}, 400);
			
		}
		else if(x instanceof Tortoise && !tortoiseCD && !timerCancelled)
		{
				increaseAllyCount();
				allyList.add((Tortoise)x);
				tortoiseCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						tortoiseCD = false;
					}
				}, 500);
			
		}
		
		else if(x instanceof MonkeyAttack && !monkeyAttackCD && !timerCancelled)
		{
				increaseAllyCount();
				allyList.add((MonkeyAttack)x);
				monkeyAttackCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						monkeyAttackCD = false;
					}
				}, 2000);
			
		}
		else if(x instanceof Infantry && !infantryCD && !timerCancelled)
		{
				increaseEnemyCount();
				enemyList.add((Infantry)x);	
				infantryCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						infantryCD = false;
					}
				}, 200);
			
		}
		else if(x instanceof Knight && !knightCD && !timerCancelled)
		{
				increaseEnemyCount();
				enemyList.add((Knight)x);	
				knightCD = true; 
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						knightCD = false;
					}
				}, 600);
			
		}
		else if(x instanceof Crusader && !crusaderCD && !timerCancelled)
		{
				increaseEnemyCount();
				enemyList.add((Crusader)x);	
				crusaderCD = true;
				objectTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						crusaderCD = false;
					}
				}, 800);
			
		}
		else if (x instanceof HeroObject && !timerCancelled)
		{
			increaseAllyCount();
			allyList.add((HeroObject)x);
		}
		else if(x instanceof CastleObject && !timerCancelled)
		{
			increaseEnemyCount();
			enemyList.add((CastleObject)x);
		}
		else if(x instanceof HealSkill && !timerCancelled && !healCD)
		{
			increaseAllyCount();
			allyList.add((HealSkill)x);
			healCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					healCD = false;
				}
			}, 600);
		
			
		}
		else if(x instanceof SpeedBuffSkill && !timerCancelled && !speedCD)
		{
			increaseAllyCount();
			allyList.add((SpeedBuffSkill)x);
			speedCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					speedCD = false;
				}
			}, 600);
		
			
		}
		else if(x instanceof RavenStrike  && !timerCancelled && !ravenCD)
		{
			increaseAllyCount();
			allyList.add((RavenStrike)x);
			ravenCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					ravenCD = false;
				}
			}, 600);
		
			
		}
		else if(x instanceof HailStrike  && !timerCancelled && !hailCD)
		{
			increaseAllyCount();
			allyList.add((HailStrike)x);
			hailCD = true;
			objectTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					hailCD = false;
				}
			}, 600);
		
			
		}
	}

	//cancels objectTimer
	public void stopTimer()
	{
		timerCancelled = true;
		objectTimer.cancel();
	}

	//Getters and setters
	public ArrayList<GameObject> getDeadObjects() {
		return deadObjects;
	}

	public ArrayList<Ally> getAllies() {
		return allyList;
	}
	public ArrayList<Enemy> getEnemies(){
		return enemyList;
	}
	
	public int getDeadObjectCount() {
		return deadObjectCount;
	}

	public void setDeadObjectCount(int deadObjectCount) {
		this.deadObjectCount = deadObjectCount;
	}
	public boolean getHealCD()
	{
		return healCD;
	}
	
	public boolean isBearCD() {
		return bearCD;
	}

	public boolean isDogCD() {
		return dogCD;
	}

	public boolean isMonkeyCD() {
		return monkeyCD;
	}

	public boolean isTortoiseCD() {
		return tortoiseCD;
	}

	public boolean isInfantryCD() {
		return infantryCD;
	}

	public boolean isKnightCD() {
		return knightCD;
	}

	public boolean isCrusaderCD() {
		return crusaderCD;
	}

	public boolean isSpeedCD() {
		return speedCD;
	}

	public boolean isHailCD() {
		return hailCD;
	}

	public boolean isRavenCD() {
		return ravenCD;
	}

	public boolean isMonkeyAttackCD() {
		return monkeyAttackCD;
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
	public void decreaseDeadObjectCount()
	{
		deadObjectCount -=1;
	}
	public void increaseDeadObjectCount()
	{
		deadObjectCount += 1;
	}
	
		
	
}
