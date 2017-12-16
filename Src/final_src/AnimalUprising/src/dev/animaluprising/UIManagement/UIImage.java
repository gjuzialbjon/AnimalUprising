package dev.animaluprising.UIManagement;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
/**
 * @author Ata Gun Ogun
 */
public class UIImage extends UIComponent {

	public UIImage(float x, float y, int w, int h,BufferedImage texture) {
		super(x, y, w, h,texture);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//super.tick();
	}
	
	@Override
	public void onClick(MouseEvent e) {
		//do nothing, its just an image
	}

}
