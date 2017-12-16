package dev.animaluprising.UIManagement;

import java.awt.image.BufferedImage;

import dev.animaluprising.GameControl.GameManager;



public class UIBackground extends UIImage {

	public UIBackground(BufferedImage texture) {
		super(0f,0f,GameManager.getGame().getGameWidth(),GameManager.getGame().getGameHeight(),texture);	
		// TODO Auto-generated constructor stub
	}

}
