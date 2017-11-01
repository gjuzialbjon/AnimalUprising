package GameControl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager
{
	public static BufferedImage heroImage, enemyImage, catImage, dogImage, castleImage;
	public static BufferedImage loadImage(String path)
	{
		try 
		{
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
