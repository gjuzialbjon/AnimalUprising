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
	public static BufferedImage heroImage, enemyImage, catImage, dogImage, castleImage;
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
		heroImage = loadImage("/Images/Capture5.PNG");
		enemyImage = loadImage("/Images/Capture3.PNG");
		catImage = loadImage("/Images/Capture1.PNG");
		dogImage = loadImage("/Images/Capture2.PNG");
		castleImage = loadImage("/Images/Capture4.PNG");
		
	}
}
