
/*
 *  Author: Bora Ecer
 *  Date: 1 November 2017
 *  Version: 12.12.2017
 *  ImageMAnager is the class for reading the images and setting them as static BufferedImage variables,
 *  This allows the program to read the images only once, and use the variables which the images are load into whenever it is necessary
 *  
 */

package dev.animaluprising.GameControl;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager
{
	public static BufferedImage castleImage;
	public static BufferedImage[] dogImages = new BufferedImage[18];
	public static BufferedImage[] heroImages = new BufferedImage[16];
	public static BufferedImage[] infantryImages = new BufferedImage[14];
	public static BufferedImage[] knightImages = new BufferedImage[14];
	public static BufferedImage[] crusaderImages = new BufferedImage[14];
	public static BufferedImage[] bearImages = new BufferedImage[16];
	public static BufferedImage[] tortoiseImages = new BufferedImage[5];
	public static BufferedImage[] monkeyImages = new BufferedImage[12];
	public static BufferedImage[] healSkillImages = new BufferedImage[5];
	public static BufferedImage[] speedBuffImages = new BufferedImage[5];
	public static BufferedImage[] ravenImages = new BufferedImage[8];
	public static BufferedImage mainMenuBackground;
	public static BufferedImage playButton;
	public static BufferedImage shopButton;
	public static BufferedImage settingsButton;
	public static BufferedImage howToButton;
	public static BufferedImage quitButton;
	public static BufferedImage backButton;
	public static BufferedImage gameMenuBackground;
	public static BufferedImage levelButton1,levelButton2,levelButton3,levelButton4,levelButton5;
	public static BufferedImage gameGuide;
	public static BufferedImage settingsBackground;
	public static BufferedImage monkeyAttackImage;
	public static BufferedImage placeholder;
	public static BufferedImage floor; 
	public static BufferedImage victoryScreen;
	public static BufferedImage mainMenuButton; 
			
			
	
	public static BufferedImage loadImage(String path)
	{
		try {
			return ImageIO.read(ImageManager.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void init()
	{
		floor = loadImage("/Images/floor.PNG");
		castleImage = loadImage("/Images/castle.PNG");
		tortoiseImages[0] = loadImage("/Images/turtle/1.PNG");
		tortoiseImages[1] = loadImage("/Images/turtle/2.PNG");
		tortoiseImages[2] = loadImage("/Images/turtle/3.PNG");
		tortoiseImages[3] = loadImage("/Images/turtle/4.PNG");
		tortoiseImages[4] = loadImage("/Images/turtle/row3/1.PNG");
		

		monkeyImages[0] = loadImage("/Images/monkey/row1/1.PNG");
		monkeyImages[1] = loadImage("/Images/monkey/row1/2.PNG");
		monkeyImages[2] = loadImage("/Images/monkey/row1/3.PNG");
		monkeyImages[3] = loadImage("/Images/monkey/row1/4.PNG");
		monkeyImages[4] = loadImage("/Images/monkey/row1/5.PNG");
		monkeyImages[5] = loadImage("/Images/monkey/row2/1.PNG");
		monkeyImages[6] = loadImage("/Images/monkey/row2/2.PNG");
		monkeyImages[7] = loadImage("/Images/monkey/row2/3.PNG");
		monkeyImages[8] = loadImage("/Images/monkey/row3/1.PNG");
		monkeyImages[9] = loadImage("/Images/monkey/row3/4.PNG");
		monkeyImages[10] = loadImage("/Images/monkey/row3/5.PNG");
		monkeyImages[11] = loadImage("/Images/monkey/row3/6.PNG");
		
		monkeyAttackImage = loadImage("/Images/monkey/row6/7.PNG");
		
		crusaderImages[0] = loadImage("/Images/crusader/crusadermoving/1.PNG");
		crusaderImages[1] = loadImage("/Images/crusader/crusadermoving/2.PNG");
		crusaderImages[2] = loadImage("/Images/crusader/crusadermoving/3.PNG");
		crusaderImages[3] = loadImage("/Images/crusader/crusadermoving/4.PNG");
		crusaderImages[4] = loadImage("/Images/crusader/crusadermoving/5.PNG");
		crusaderImages[5] = loadImage("/Images/crusader/crusadermoving/6.PNG");
		crusaderImages[6] = loadImage("/Images/crusader/crusaderattacking/4.PNG");
		crusaderImages[7] = loadImage("/Images/crusader/crusaderattacking/7.PNG");
		crusaderImages[8] = loadImage("/Images/crusader/crusaderattacking/6.PNG");
		crusaderImages[9] = loadImage("/Images/crusader/crusaderattacking/8.PNG");
		crusaderImages[10] = loadImage("/Images/crusader/crusaderdying/5.PNG");
		crusaderImages[11] = loadImage("/Images/crusader/crusaderdying/6.PNG");
		crusaderImages[12] = loadImage("/Images/crusader/crusaderdying/7.PNG");
		crusaderImages[13] = loadImage("/Images/crusader/crusaderdying/8.PNG");
		
		heroImages[0] = loadImage("/Images/Druid/DruidMove/6.PNG");
		heroImages[1] = loadImage("/Images/Druid/DruidMove/7.PNG");
		heroImages[2] = loadImage("/Images/Druid/DruidMove/8.PNG");
		heroImages[3] = loadImage("/Images/Druid/DruidMove/9.PNG");
		heroImages[4] = loadImage("/Images/Druid/DruidMove/10.PNG");
		heroImages[5] = loadImage("/Images/Druid/DruidMove/11.PNG");
		heroImages[6] = loadImage("/Images/Druid/DruidMove/12.PNG");
		heroImages[7] = loadImage("/Images/Druid/DruidAttacking/5.PNG");
		heroImages[8] = loadImage("/Images/Druid/DruidAttacking/6.PNG");
		heroImages[9] = loadImage("/Images/Druid/DruidAttacking/7.PNG");
		heroImages[10] = loadImage("/Images/Druid/DruidAttacking/9.PNG");
		heroImages[11] = loadImage("/Images/Druid/DruidMove/1.PNG");
		heroImages[12] = loadImage("/Images/Druid/DruidDeath/7.PNG");
		heroImages[13] = loadImage("/Images/Druid/DruidDeath/9.PNG");
		heroImages[14] = loadImage("/Images/Druid/DruidDeath/10.PNG");
		heroImages[15] = loadImage("/Images/Druid/DruidDeath/11.PNG");
		
		infantryImages[0] = loadImage("/Images/Infantry/InfantryMoving/9.PNG");
		infantryImages[1] = loadImage("/Images/Infantry/InfantryMoving/8.PNG");
		infantryImages[2] = loadImage("/Images/Infantry/InfantryMoving/7.PNG");
		infantryImages[3] = loadImage("/Images/Infantry/InfantryMoving/6.PNG");
		infantryImages[4] = loadImage("/Images/Infantry/InfantryMoving/5.PNG");
		infantryImages[5] = loadImage("/Images/Infantry/InfantryMoving/4.PNG");
		infantryImages[6] = loadImage("/Images/Infantry/InfantryAttackTwo/2.PNG");
		infantryImages[7] = loadImage("/Images/Infantry/InfantryAttackTwo/3.PNG");
		infantryImages[8] = loadImage("/Images/Infantry/InfantryAttackTwo/4.PNG");
		infantryImages[9] = loadImage("/Images/Infantry/InfantryAttackTwo/5.PNG");
		infantryImages[10] = loadImage("/Images/Infantry/InfantryDying/3.PNG");
		infantryImages[11] = loadImage("/Images/Infantry/InfantryDying/4.PNG");
		infantryImages[12] = loadImage("/Images/Infantry/InfantryDying/5.PNG");
		infantryImages[13] = loadImage("/Images/Infantry/InfantryDying/6.PNG");
		
		knightImages[0] = loadImage("/Images/knight/knightmoving/1.PNG");
		knightImages[1] = loadImage("/Images/knight/knightmoving/2.PNG");
		knightImages[2] = loadImage("/Images/knight/knightmoving/3.PNG");
		knightImages[3] = loadImage("/Images/knight/knightmoving/4.PNG");
		knightImages[4] = loadImage("/Images/knight/knightmoving/5.PNG");
		knightImages[5] = loadImage("/Images/knight/knightmoving/6.PNG");
		knightImages[6] = loadImage("/Images/knight/knightattacking/4.PNG");
		knightImages[7] = loadImage("/Images/knight/knightattacking/5.PNG");
		knightImages[8] = loadImage("/Images/knight/knightattacking/6.PNG");
		knightImages[9] = loadImage("/Images/knight/knightattacking/7.PNG");
		knightImages[10] = loadImage("/Images/knight/knightdying/6.PNG");
		knightImages[11] = loadImage("/Images/knight/knightdying/7.PNG");
		knightImages[12] = loadImage("/Images/knight/knightdying/8.PNG");
		knightImages[13] = loadImage("/Images/knight/knightdying/9.PNG");
		
		bearImages[0] = loadImage("/Images/bear/bearmoving/1.PNG");
		bearImages[1] = loadImage("/Images/bear/bearmoving/2.PNG");
		bearImages[2] = loadImage("/Images/bear/bearmoving/3.PNG");
		bearImages[3] = loadImage("/Images/bear/bearmoving/4.PNG");
		bearImages[4] = loadImage("/Images/bear/bearmoving/5.PNG");
		bearImages[5] = loadImage("/Images/bear/bearmoving/6.PNG");
		bearImages[6] = loadImage("/Images/bear/bearattacking/1.PNG");
		bearImages[7] = loadImage("/Images/bear/bearattacking/2.PNG");
		bearImages[8] = loadImage("/Images/bear/bearattacking/3.PNG");
		bearImages[9] = loadImage("/Images/bear/bearattacking/4.PNG");
		bearImages[10] = loadImage("/Images/bear/bearattacking/5.PNG");
		bearImages[11] = loadImage("/Images/bear/bearattacking/6.PNG");
		bearImages[12] = loadImage("/Images/bear/beardying/1.PNG");
		bearImages[13] = loadImage("/Images/bear/beardying/2.PNG");
		bearImages[14] = loadImage("/Images/bear/beardying/3.PNG");
		bearImages[15] = loadImage("/Images/bear/beardying/4.PNG");
		
		
		dogImages[0] = loadImage("/Images/dog_stand.PNG");
		dogImages[1] = loadImage("/Images/dog_move1.PNG");
		dogImages[2] = loadImage("/Images/dog_move2.PNG");
		dogImages[3] = loadImage("/Images/dog_move3.PNG");
		dogImages[4] = loadImage("/Images/dog_move4.PNG");
		dogImages[5] = loadImage("/Images/dog_move5.PNG");
		dogImages[6] = loadImage("/Images/dog_move6.PNG");
		dogImages[7] = loadImage("/Images/dog_attack1.PNG");
		dogImages[8] = loadImage("/Images/dog_attack2.PNG");
		dogImages[9] = loadImage("/Images/dog_attack3.PNG");
		dogImages[10] = loadImage("/Images/dog_attack4.PNG");
		dogImages[11]  = loadImage("/Images/Dog/DogDeath/1.PNG");
		dogImages[12]  = loadImage("/Images/Dog/DogDeath/2.PNG");
		dogImages[13]  = loadImage("/Images/Dog/DogDeath/3.PNG");
		dogImages[14]  = loadImage("/Images/Dog/DogDeath/4.PNG");
		dogImages[15]  = loadImage("/Images/Dog/DogDeath/5.PNG");
		dogImages[16]  = loadImage("/Images/Dog/DogDeath/6.PNG");
		dogImages[17]  = loadImage("/Images/Dog/DogDeath/7.PNG");
		
		healSkillImages[0] = loadImage("/Images/light/row1/1.PNG");
		healSkillImages[1] = loadImage("/Images/light/row1/2.PNG");
		healSkillImages[2] = loadImage("/Images/light/row1/3.PNG");
		healSkillImages[3] = loadImage("/Images/light/row1/4.PNG");
		healSkillImages[4] = loadImage("/Images/light/row1/5.PNG");
		

		speedBuffImages[0] = loadImage("/Images/light/row3/1.PNG");
		speedBuffImages[1] = loadImage("/Images/light/row3/2.PNG");
		speedBuffImages[2] = loadImage("/Images/light/row3/3.PNG");
		speedBuffImages[3] = loadImage("/Images/light/row3/4.PNG");
		speedBuffImages[4] = loadImage("/Images/light/row3/5.PNG");
		

		ravenImages[0] = loadImage("/Images/bird/down/1.PNG");
		ravenImages[1] = loadImage("/Images/bird/down/2.PNG");
		ravenImages[2] = loadImage("/Images/bird/down/3.PNG");
		ravenImages[3] = loadImage("/Images/bird/down/4.PNG");
		ravenImages[4] = loadImage("/Images/bird/right/1.PNG");
		ravenImages[5] = loadImage("/Images/bird/right/2.PNG");
		ravenImages[6] = loadImage("/Images/bird/right/3.PNG");
		ravenImages[7] = loadImage("/Images/bird/right/4.PNG");
		
		placeholder = loadImage("/textures/placeholder.png");
		
		//everything after this is here to stay
		mainMenuBackground= loadImage("/textures/mainmenu/background.png");
		playButton = loadImage("/textures/mainmenu/playButton.png");
		shopButton = loadImage("/textures/mainmenu/shopButton.png");
		settingsButton = loadImage("/textures/mainmenu/settingsButton.png");
		howToButton = loadImage("/textures/mainmenu/howToButton.png");
		quitButton = loadImage("/textures/mainmenu/quitButton.png");
		
		backButton =  loadImage("/textures/commons/backButton.png");
		
		gameMenuBackground =  loadImage("/textures/gamemenu/background.png");
		levelButton1 =  loadImage("/textures/gamemenu/level1.png");
		levelButton2 =  loadImage("/textures/gamemenu/level2.png");
		levelButton3 =  loadImage("/textures/gamemenu/level3.png");
		levelButton4 =  loadImage("/textures/gamemenu/level4.png");
		levelButton5 =  loadImage("/textures/gamemenu/level5.png");
		
		gameGuide =  loadImage("/textures/howto/howToPlay.png");
		
		settingsBackground =  loadImage("/textures/settings/background.png");
		victoryScreen = loadImage("/textures/victory/background.png");
		mainMenuButton = loadImage("/textures/victory/mainMenuButton.png");
		
		
	}
}
