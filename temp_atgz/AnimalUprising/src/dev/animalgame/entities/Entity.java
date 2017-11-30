package dev.animalgame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.animalgame.Game;

public abstract class Entity {
	
	protected Game game;
	
	protected float xpos,ypos;
	protected int width,height;
	protected Rectangle collisionBox;
	
	protected BufferedImage texture;//TODO make this equal to a placeholder image so debugging becomes easier
	
	
	
	public Entity(float x, float y, int width, int height){
		game = Game.getGame();//TODO do this in the field part maybe? (aka the default field value)
		xpos=x;
		ypos=y;		
		this.width = width;
		this.height = height;
		
		collisionBox = new Rectangle(0, 0, width, height);//The collision box covers the whole image by default.
	}
	
	
	
	
	
	public abstract void tick();
	public void render(Graphics g){
		//updateCurrentTexture();//TODO make an interface for animated entities that have this method, override their render method so that they do this first.
		g.drawImage(texture, (int)(xpos-game.getGameCamera().getxOffset())
				,(int)(ypos-game.getGameCamera().getyOffset())
				,width, height, null);
		
		g.setColor(new Color(1, 0, 0,0.7f));
		g.fillRect((int)(xpos+collisionBox.x-game.getGameCamera().getxOffset()),(int)(ypos+collisionBox.y-game.getGameCamera().getyOffset()), collisionBox.width, collisionBox.height);
	}



	//TODO make an interface for animated entities, make them have/use this method
	/*protected void updateCurrentTexture() {
		// TODO Auto-generated method stub
		
	}*/





	/**
	 * @return the xpos
	 */
	public float getXpos() {
		return xpos;
	}





	/**
	 * @param xpos the xpos to set
	 */
	public void setXpos(float xpos) {
		this.xpos = xpos;
	}





	/**
	 * @return the ypos
	 */
	public float getYpos() {
		return ypos;
	}





	/**
	 * @param ypos the ypos to set
	 */
	public void setYpos(float ypos) {
		this.ypos = ypos;
	}





	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}





	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}





	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}





	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
}
