package dev.animalgame.gfx;

import dev.animalgame.Game;
import dev.animalgame.entities.Entity;
import dev.animalgame.levels.Level;

public class GameCamera {
	
	private float xOffset,yOffset;
	
	private Game game = Game.getGame(); //TODO MIGHT REMOVE THIS IDK LOOKS BAD
	
	public GameCamera(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	
	
	public void move(float xAmt,float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	
	//TODO maybe move the camera a little bit to the right of the focus so that it resembles paladog a little bit more
	public void centerOnEntity(Entity focusEntity){
		xOffset = focusEntity.getXpos() - game.getGameWidth()/2 + focusEntity.getWidth()/2;//TODO add/sub half of the focus entity width too if required
		//yOffset = focusEntity.getYpos() - game.getGameHeight()/2; //Not sure if we want to center on the Y axis. decide later.
		
		
		//this block is for not showing beyond the edge of the level
		if(xOffset<0)
			xOffset=0;
		else if(xOffset>Level.MAPWIDTH-game.getGameWidth())
			xOffset=Level.MAPWIDTH-game.getGameWidth();
	}
	
	
	/**
	 * @return the xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset the xOffset to set
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return the yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset the yOffset to set
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	
	
}
