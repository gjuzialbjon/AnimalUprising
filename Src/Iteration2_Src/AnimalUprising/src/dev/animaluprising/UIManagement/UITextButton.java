package dev.animaluprising.UIManagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author Ata Gun Ogun
 */
public class UITextButton extends UIButton {
	
	String text;

	public UITextButton(float x, float y, int w, int h,String text, ClickAction a) {
		super(x, y, w, h, a);
		this.text=text;

	}
	
	public UITextButton(float x,float y, int w, int h, String text, BufferedImage texture, ClickAction a) {
		super(x,y,w,h,texture,a);
		this.text = text;
	}
	
	public void setText(String text){
		this.text=text;
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		g.drawString(text, (int)x+width/2-5, (int)y+height/2);
	}
}
