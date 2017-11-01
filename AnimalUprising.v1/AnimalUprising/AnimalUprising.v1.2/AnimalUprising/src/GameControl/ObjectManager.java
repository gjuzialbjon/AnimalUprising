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
	private boolean bearCD, dogCD, tortoiseCD, infantryCD, knightCD, monkeyCD, crusaderCD; 
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
			if(!Bear.isCDBear)
			{
				increaseObjectCount();
				objectList.add(x);	
				Bear.isCDBear = true;
			}
		}
		else if(x instanceof Dog)
		{
			if(!Dog.isCDDog)
			{
				increaseObjectCount();
				objectList.add(x);
				Dog.isCDDog = true;
			}
		}
		else if(x instanceof Monkey)
		{
			if(!Monkey.isCDMonkey)
			{
				increaseObjectCount();
				objectList.add(x);
				Monkey.isCDMonkey = true;
			}
		}
		else if(x instanceof Tortoise)
		{
			if(!Tortoise.isCDTortoise)
			{
				increaseObjectCount();
				objectList.add(x);
				Tortoise.isCDTortoise = true;
			}
		}
		else if(x instanceof Infantry)
		{
			if(!Infantry.isCDInfantry)
			{
				increaseObjectCount();
				objectList.add(x);
				Infantry.isCDInfantry = true;
			}
		}
		else if(x instanceof Knight)
		{
			if(!Knight.isCDKnight)
			{
				increaseObjectCount();
				objectList.add(x);
				Knight.isCDKnight = true;
			}
		}
		else if(x instanceof Crusader)
		{
			if(!Crusader.isCDCrusader)
			{
				increaseObjectCount();
				objectList.add(x);	
				Crusader.isCDCrusader = true;
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
