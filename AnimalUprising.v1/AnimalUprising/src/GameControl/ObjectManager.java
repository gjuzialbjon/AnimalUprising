package GameControl;

import java.util.ArrayList;

import GameModel.*;

public class ObjectManager 
{
	private ArrayList<GameObject> objectList;  
	
	public ObjectManager() {
		objectList = new ArrayList<>();
	}

	public ArrayList<GameObject> getObjects() {
		return objectList;
	}
	
	public void addObject(GameObject x)
	{
		objectList.add(x);
	}
	
	public boolean isInRange(GameObject x, GameObject y)
	{
		return true;
	}

	
	
	
}
