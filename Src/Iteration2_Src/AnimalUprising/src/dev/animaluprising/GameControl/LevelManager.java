/*
 * Author: Bora Ecer
 * Date: 10.12.2017
 * Version: 16.12.2017
 * Class for managing the levels,
 * Basically, it increases the base healths of the objects in each level.
 */
package dev.animaluprising.GameControl;

public class LevelManager 
{
	public static int unlockedLevels = 1;
	public static int currentLevel = 1;
	private static int maxCastleHealth = 1000;
	private static int maxCrusaderHealth = 800;
	private static int maxInfantryHealth = 600;
	private static int maxKnightHealth = 700;	
	private static int crusaderDamage = 20;
	private static int knightDamage = 15;
	private static int infantryDamage = 10;
	private static int increasedHealth = 50;
	
	public static void increaseMaxUnlockedLevel()
	{
		if(unlockedLevels < 5)
		{
			unlockedLevels +=1; 
		}
	}
	public static void setCurrentLevel(int level)
	{
		currentLevel = level;
	}
	//retuns damage of the given object
	public static int getDamage(String objectName)
	{
		if(objectName.equals("dev.animaluprising.GameModel.Crusader") )
		{
			return getCrusaderDamage();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.Knight"))
		{
			return getKnightDamage();
		}

		else if(objectName.equals("dev.animaluprising.GameModel.Infantry"))
		{
			return getInfantryDamage();
		}
		else 
			return 0;
	}
	
	//Getters and Setters
	public static int getMaxCastleHealth() {
		return (getIncreasedHealth()*currentLevel)+maxCastleHealth;
	}
	public static void setMaxCastleHealth(int maxCastleHealth) {
		LevelManager.maxCastleHealth = maxCastleHealth;
	}
	public static int getMaxCrusaderHealth() {
		return (getIncreasedHealth()*currentLevel)+maxCrusaderHealth;
	}
	public static void setMaxCrusaderHealth(int maxCrusaderHealth) {
		LevelManager.maxCrusaderHealth = maxCrusaderHealth;
	}
	public static int getMaxInfantryHealth() {
		return (getIncreasedHealth()*currentLevel)+maxInfantryHealth;
	}
	public static void setMaxInfantryHealth(int maxInfantryHealth) {
		LevelManager.maxInfantryHealth = maxInfantryHealth;
	}
	public static int getMaxKnightHealth() {
		return (getIncreasedHealth()*currentLevel)+maxKnightHealth;
	}
	public static void setMaxKnightHealth(int maxKnightHealth) {
		LevelManager.maxKnightHealth = maxKnightHealth;
	}
	public static int getCrusaderDamage() {
		return crusaderDamage;
	}
	public static void setCrusaderDamage(int crusaderDamage) {
		LevelManager.crusaderDamage = crusaderDamage;
	}
	public static int getKnightDamage() {
		return knightDamage;
	}
	public static void setKnightDamage(int knightDamage) {
		LevelManager.knightDamage = knightDamage;
	}
	public static int getInfantryDamage() {
		return infantryDamage;
	}
	public static void setInfantryDamage(int infantryDamage) {
		LevelManager.infantryDamage = infantryDamage;
	}
	public static int getIncreasedHealth()
	{
		return increasedHealth;
	}
}
