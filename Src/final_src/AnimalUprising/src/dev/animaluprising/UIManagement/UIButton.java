package dev.animaluprising.UIManagement;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import dev.animaluprising.GameControl.ImageManager;

/**
 * @author Ata Gun Ogun
 */
public class UIButton extends UIComponent {
//basip drag out etme olayi ekle
	
	ClickAction action;

	public UIButton(float x, float y, int w, int h,ClickAction a) {
		super(x, y, w, h);
		action=a;
		texture = ImageManager.blankButton;
	}
	
	//TODO add constructor /w bufferedimage to uicomponent
	public UIButton(float x, float y, int w, int h,BufferedImage texture,ClickAction a) {
		super(x, y, w, h,texture);
		action=a;
	}

	@Override
	public void render(Graphics g) {
			super.render(g);
			if(pressed)
				g.drawImage(ImageManager.shadow/*TODO make this pressed image*/, (int)x, (int)y,width,height, null);
		
	}

	@Override
	public void onClick(MouseEvent e) {
		action.onClick();
		//System.out.println("button onclick");
		
	}
	
}
