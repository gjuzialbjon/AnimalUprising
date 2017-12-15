package dev.animaluprising.GameControl;

public class ShopManager
{
	
	//TODO coins will be added.
	private static int maxHeroHealth = 600;
	private static int maxLHeroMana = 100;
	private static int maxDogHealth = 800;
	private static int maxBearHealth = 200;
	private static int maxMonkeyHealth= 300;
	private static int maxTortoiseHealth = 600;
	private static int bearDamage = 50;
	private static int monkeyDamage = 15;
	private static int dogDamage = 10;
	private static int healAmount = -10;
	private static int tortoiseDamage=0;
	private static int dogRequiredFood = 10;
	private static int bearRequiredFood = 20;
	private static int monkeyRequiredFood = 30;
	private static int tortoiseRequiredFood = 40;
	private static int maxHeroFood = 100;
	private static int ravenDamage = 50;
	private static float heroSpeed = 3.0f;
	private static float dogSpeed = 3.0f;
	private static float bearSpeed = 3.0f;
	private static float monkeySpeed = 3.0f;
	private static float tortoiseSpeed = 1.0f;
	private static int healRequiredMana = 20;
	private static int speedRequiredMana = 20;
	private static int hailRequiredMana = 20;
	private static int ravenRequiredMana = 20;
	
	public static int getDamage(String objectName)
	{
		if(objectName.equals("dev.animaluprising.GameModel.Bear") )
		{
			return getBearDamage();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.Dog"))
		{
			return getDogDamage();
		}

		else if(objectName.equals("dev.animaluprising.GameModel.MonkeyAttack"))
		{
			return getMonkeyDamage();
		}

		else if(objectName.equals("dev.animaluprising.GameModel.Tortoise"))
		{
			return getTortoiseDamage();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.HealSkill"))
		{
			return getHealAmount();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.RavenStrike"))
		{
			return getRavenDamage();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.HailStrike"))
		{
			return getRavenDamage();
		}
		else 
			return 0;
	}
	public static float getSpeed(String objectName)
	{
		if(objectName.equals("dev.animaluprising.GameModel.Bear") )
		{
			return getBearSpeed();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.Dog"))
		{
			return getDogSpeed();
		}

		else if(objectName.equals("dev.animaluprising.GameModel.MonkeyAttack"))
		{
			return getMonkeySpeed();
		}

		else if(objectName.equals("dev.animaluprising.GameModel.Tortoise"))
		{
			return getTortoiseSpeed();
		}
		else if(objectName.equals("dev.animaluprising.GameModel.HeroObject"))
		{
			return getHeroSpeed();
		}
		else
			return 0;
	}
	

	public static int getHealRequiredMana() {
		return healRequiredMana;
	}
	public static void setHealRequiredMana(int healRequiredMana) {
		ShopManager.healRequiredMana = healRequiredMana;
	}
	public static int getSpeedRequiredMana() {
		return speedRequiredMana;
	}
	public static void setSpeedRequiredMana(int speedRequiredMana) {
		ShopManager.speedRequiredMana = speedRequiredMana;
	}
	public static int getHailRequiredMana() {
		return hailRequiredMana;
	}
	public static void setHailRequiredMana(int hailRequiredMana) {
		ShopManager.hailRequiredMana = hailRequiredMana;
	}
	public static int getRavenRequiredMana() {
		return ravenRequiredMana;
	}
	public static void setRavenRequiredMana(int ravenRequiredMana) {
		ShopManager.ravenRequiredMana = ravenRequiredMana;
	}
	
	public static float getHeroSpeed() {
		return heroSpeed;
	}
	public static void setHeroSpeed(float heroSpeed) {
		ShopManager.heroSpeed = heroSpeed;
	}
	public static float getDogSpeed() {
		return dogSpeed;
	}
	public static void setDogSpeed(float dogSpeed) {
		ShopManager.dogSpeed = dogSpeed;
	}
	public static float getBearSpeed() {
		return bearSpeed;
	}
	public static void setBearSpeed(float bearSpeed) {
		ShopManager.bearSpeed = bearSpeed;
	}
	public static float getMonkeySpeed() {
		return monkeySpeed;
	}
	public static void setMonkeySpeed(float monkeySpeed) {
		ShopManager.monkeySpeed = monkeySpeed;
	}
	public static float getTortoiseSpeed() {
		return tortoiseSpeed;
	}
	public static void setTortoiseSpeed(float tortoiseSpeed) {
		ShopManager.tortoiseSpeed = tortoiseSpeed;
	}
	
	public static int getRavenDamage() {
		return ravenDamage;
	}
	public static void setRavenDamage(int ravenDamage) {
		ShopManager.ravenDamage = ravenDamage;
	}
	public static int getMaxHeroFood() {
		return maxHeroFood;
	}
	public static void setMaxHeroFood(int maxHeroFood) {
		ShopManager.maxHeroFood = maxHeroFood;
	}
	public static int getHealAmount() {
		return healAmount;
	}
	public static void setHealAmount(int healAmount) {
		ShopManager.healAmount = healAmount;
	}
	public static void setTortoiseDamage(int tortoiseDamage) {
		ShopManager.tortoiseDamage = tortoiseDamage;
	}
	public static int getTortoiseDamage() {
		return tortoiseDamage;
	}
	public static int getMaxHeroHealth() {
		return maxHeroHealth;
	}
	public static void setMaxHeroHealth(int maxHeroHealth) {
		ShopManager.maxHeroHealth = maxHeroHealth;
	}
	public static int getMaxLHeroMana() {
		return maxLHeroMana;
	}
	public static void setMaxLHeroMana(int maxLHeroMana) {
		ShopManager.maxLHeroMana = maxLHeroMana;
	}
	public static int getMaxDogHealth() {
		return maxDogHealth;
	}
	public static void setMaxDogHealth(int maxDogHealth) {
		ShopManager.maxDogHealth = maxDogHealth;
	}
	public static int getMaxBearHealth() {
		return maxBearHealth;
	}
	public static void setMaxBearHealth(int maxBearHealth) {
		ShopManager.maxBearHealth = maxBearHealth;
	}
	public static int getMaxMonkeyHealth() {
		return maxMonkeyHealth;
	}
	public static void setMaxMonkeyHealth(int maxMonkeyHealth) {
		ShopManager.maxMonkeyHealth = maxMonkeyHealth;
	}
	public static int getMaxTortoiseHealth() {
		return maxTortoiseHealth;
	}
	public static void setMaxTortoiseHealth(int maxTortoiseHealth) {
		ShopManager.maxTortoiseHealth = maxTortoiseHealth;
	}
	public static int getBearDamage() {
		return bearDamage;
	}
	public static void setBearDamage(int bearDamage) {
		ShopManager.bearDamage = bearDamage;
	}
	public static int getMonkeyDamage() {
		return monkeyDamage;
	}
	public static void setMonkeyDamage(int monkeyDamage) {
		ShopManager.monkeyDamage = monkeyDamage;
	}
	public static int getDogDamage() {
		return dogDamage;
	}
	public static void setDogDamage(int dogDamage) {
		ShopManager.dogDamage = dogDamage;
	}
	public static int getDogRequiredFood() {
		return dogRequiredFood;
	}
	public static void setDogRequiredFood(int dogRequiredFood) {
		ShopManager.dogRequiredFood = dogRequiredFood;
	}
	public static int getBearRequiredFood() {
		return bearRequiredFood;
	}
	public static void setBearRequiredFood(int bearRequiredFood) {
		ShopManager.bearRequiredFood = bearRequiredFood;
	}
	public static int getMonkeyRequiredFood() {
		return monkeyRequiredFood;
	}
	public static void setMonkeyRequiredFood(int monkeyRequiredFood) {
		ShopManager.monkeyRequiredFood = monkeyRequiredFood;
	}
	public static int getTortoiseRequiredFood() {
		return tortoiseRequiredFood;
	}
	public static void setTortoiseRequiredFood(int tortoiseRequiredFood) {
		ShopManager.tortoiseRequiredFood = tortoiseRequiredFood;
	}
	
	
}
