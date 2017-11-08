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

public class ObjectManager 
{
	private ArrayList<GameObject> objectList; 
	private int objectCount;
	
	public ObjectManager() 
	{
		objectCount = 0;
		objectList = new ArrayList<>();

	}

	public ArrayList<GameObject> getObjects() {
		return objectList;
	}
	
	public void addObject(GameObject x)
	{
		if(x instanceof Bear)
		{
			if(!((Bear)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Bear)x).setCooldown(true);
				((Bear)x).resetTimer();
			}
		}
		else if(x instanceof Dog)
		{
			if(!((Dog)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Dog)x).setCooldown(true);
				((Dog)x).resetTimer();
			}
		}
		else if(x instanceof Monkey)
		{
			if(!((Monkey)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Monkey)x).setCooldown(true);
			}
		}
		else if(x instanceof Tortoise)
		{
			if(!((Tortoise)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Tortoise)x).setCooldown(true);
			}
		}
		else if(x instanceof Infantry)
		{
			if(!((Infantry)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Infantry)x).setCooldown(true);
			}
		}
		else if(x instanceof Knight)
		{
			if(!((Knight)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Knight)x).setCooldown(true);
			}
		}
		else if(x instanceof Crusader)
		{
			if(!((Crusader)x).isCooldown())
			{
				increaseObjectCount();
				objectList.add(x);	
				((Crusader)x).setCooldown(true);
			}
		}
		else if (x instanceof HeroObject)
		{
			increaseObjectCount();
			objectList.add(x);
		}
		else if(x instanceof CastleObject)
		{
			increaseObjectCount();
			objectList.add(x);
		}
	}
		
	public int getObjectCount()
	{
		return objectCount;
	}
	
	public void decreaseObjectCount()
	{
		objectCount -=1;
	}
	public void increaseObjectCount()
	{
		objectCount += 1;
	}
	
		
	
	
}
