package dev.animaluprising.UIManagement;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.animaluprising.GameControl.GameManager;
/**
 * @author Ata Gun Ogun
 */
public class UIManager {
	
	private GameManager game=GameManager.getGame();
	
	private ArrayList<UIComponent> components;
	
	public UIManager() {
		components = new ArrayList<>();
	}
	
	
	
	
	public void tick(){
		for(UIComponent cycler:components){
			cycler.tick();
		}
		
		MouseEvent e=game.getMouseManager().popLastRelease();
		if(e!=null && e.getButton()==MouseEvent.BUTTON1){//second part (after and)might be redundant
			for(UIComponent cycler:components){
				if(cycler.isHovered()){
					cycler.onClick(e);
				}
			}
		}
		
	}
	
	public void render(Graphics g){
		for(UIComponent cycler:components){
			cycler.render(g);
		}
	}
	
	public void addComponent(UIComponent c){
		components.add(c);
	}
	
}


//improvements that can be made for future projects:
/*
 *	hold clickable components in a seperate arraylist
 *	and do the click check thingy only for those 
 * 
 */