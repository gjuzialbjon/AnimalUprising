package dev.animalgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage horse_right_run1,horse_right_run2;
	
	public static BufferedImage floor;

	public static BufferedImage horse_right_still;
	
	private static final int width = 128, height =128; // w-h of the tiles in the sprite sheet. make multiple different types of this if we decide to make different spritesheets/image sizes
	
	public static void initialize(){ //rename this maybe
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/horsesheet.png"));
		
		horse_right_run1 = sheet.crop(0, 0, width, 84);
		horse_right_run2 = sheet.crop(width,0,width,84); // width*tile_x,height*tile_y,width,height
		horse_right_still = sheet.crop(width*2, 0, width, 84);
		
		floor = ImageLoader.loadImage("/textures/floor.png");
	}

}
