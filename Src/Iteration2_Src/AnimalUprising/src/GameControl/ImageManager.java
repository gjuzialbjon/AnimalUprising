/*
 *  Author: Bora Ecer
 *  Date: 1 November 2017
 *  Version: v1
 *  ImageMAnager is the class for reading the images and setting them as static BufferedImage variables,
 *  This allows the program to read the images only once, and use the variables which the images are load into whenever it is necessary
 *  
 */

package GameControl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager
{
	public static BufferedImage crusader_sheet = loadImage("/Images/crusader_sprite.PNG");
	public static BufferedImage dog_sheet = loadImage("/Images/dog_sprite.PNG");
	public static BufferedImage heroImage, enemyImage, catImage, castleImage;
	public static BufferedImage[] dogImages = new BufferedImage[11];
	public static BufferedImage[] crusaderImages = new BufferedImage[10];
	
			
	
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
		crusaderImages[0] = loadImage("/Images/crusader_move1.PNG");
		crusaderImages[1] = loadImage("/Images/crusader_move2.PNG");
		crusaderImages[2] = loadImage("/Images/crusader_move3.PNG");
		crusaderImages[3] = loadImage("/Images/crusader_move4.PNG");
		crusaderImages[4] = loadImage("/Images/crusader_move5.PNG");
		crusaderImages[5] = loadImage("/Images/crusader_move6.PNG");
		crusaderImages[6] = loadImage("/Images/crusader_attack1.PNG");
		crusaderImages[7] = loadImage("/Images/crusader_attack2.PNG");
		crusaderImages[8] = loadImage("/Images/crusader_attack3.PNG");
		crusaderImages[9] = loadImage("/Images/crusader_attack4.PNG");
		heroImage = loadImage("/Images/Capture5.PNG");
		enemyImage = loadImage("/Images/Capture3.PNG");
		catImage = loadImage("/Images/Capture1.PNG");
		
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
		castleImage = loadImage("/Images/Capture4.PNG");
		
	}
}
