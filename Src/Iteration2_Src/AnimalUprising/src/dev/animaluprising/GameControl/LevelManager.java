package dev.animaluprising.GameControl;

public class LevelManager 
{
	private static int maxCastleHealth = 200;
	private static int maxCrusaderHealth = 200;
	private static int maxInfantryHealth = 600;
	private static int maxKnightHealth = 600;
	
	private static int crusaderDamage = 15;
	private static int knightDamage = 15;
	private static int infantryDamage = 15;
	
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
	
	
	public static int getMaxCastleHealth() {
		return maxCastleHealth;
	}
	public static void setMaxCastleHealth(int maxCastleHealth) {
		LevelManager.maxCastleHealth = maxCastleHealth;
	}
	public static int getMaxCrusaderHealth() {
		return maxCrusaderHealth;
	}
	public static void setMaxCrusaderHealth(int maxCrusaderHealth) {
		LevelManager.maxCrusaderHealth = maxCrusaderHealth;
	}
	public static int getMaxInfantryHealth() {
		return maxInfantryHealth;
	}
	public static void setMaxInfantryHealth(int maxInfantryHealth) {
		LevelManager.maxInfantryHealth = maxInfantryHealth;
	}
	public static int getMaxKnightHealth() {
		return maxKnightHealth;
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
	
	
}
