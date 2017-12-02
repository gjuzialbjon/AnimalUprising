package dev.animalgame.entities.backgrounds;

import dev.animalgame.entities.Entity;
import dev.animalgame.gfx.Assets;

public class Floor extends Entity {

	//TODO make the position of the floor a little bit higher up so that it give some space for error on the character images(makes it so that the space below their image is not important)
	public Floor() { //TODO make it so it just takes in a texture or maybe not even that, use default floor
		super(0, 384, 2048, 384); //TODO make it so it uses the default x,y,width and height values for Floors(add them too as static final stuff)
									//TODO note: make this use the Level width etc as width etc. Can probably get level from game manager.
		// TODO Auto-generated constructor stub
		texture = Assets.floor;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}



}
