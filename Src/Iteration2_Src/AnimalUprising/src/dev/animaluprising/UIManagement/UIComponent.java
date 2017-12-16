package dev.animaluprising.UIManagement;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import dev.animaluprising.GameControl.GameManager;
import dev.animaluprising.GameControl.ImageManager;

//notes: render method should be overwritten for container components
/**
 * @author Ata Gun Ogun
 */
public abstract class UIComponent {
	
	GameManager game=GameManager.getGame();
	
	//note: might wanna remove the setters of x,y. Read comment of the field:bounds
	float x,y;//upper left coordinate of the component //why are these float again?
	int width,height;//w,h of the component
	
	Rectangle bounds;	//this is implemented assuming the positions wont change after construction
	
	BufferedImage texture = ImageManager.placeholder;//This is mainly for debugging, make this empty or sth

	
	boolean hovered=false;//used for click stuff
	/**
	 * @return the hovered
	 */
	public boolean isHovered() {
		return hovered;
	}

	boolean pressed=false;//for animation/responsiveness purposes//exists here because UIManager does not have special cases for Pressable components and Pressable interface isn't even a thing so yeah
	
	//Comment this maybe change w,h to longer name
	public UIComponent(float x,float y,int w,int h) {
		this.x=x;
		this.y=y;
		this.width=w;
		this.height=h;
		
		bounds = new Rectangle((int)x, (int)y, w, h);
	}
	
	public UIComponent(float x,float y,int w,int h,BufferedImage texture){
		this(x,y,w,h);
		this.texture=texture;
	}
	
	public void tick(){//this has no use in most components but whatever
		if(bounds.contains(game.getMouseManager().getMousePoint())){
			hovered = true;
		}else{
			hovered = false;
		}
		
		//might wanna move the contents of this to UIButton and make this abstract/empty
		if(game.getMouseManager().isLeftPressed() && hovered){
			pressed = true;
		}else {
			pressed = false;
		}

	}
	
	/** direk texture'i renderliyo, tikliysa farkli bisi yaptigi yok!*/
	public  void render(Graphics g){
		g.drawImage(texture, (int)x, (int)y,width,height, null);//note: drawImage() has its own null-check for texture, does nothing if null
	}

	//might wanna get the MouseEvent object that triggered this, useful for containers and fancy components
	public abstract void onClick(MouseEvent e);//{//e is the event which triggered this method
	//this was abstract but keeping it empty also makes sense in some cases such as imageContainer
	//}

	
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
