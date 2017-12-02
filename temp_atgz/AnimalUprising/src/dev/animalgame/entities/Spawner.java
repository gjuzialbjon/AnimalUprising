package dev.animalgame.entities;

import java.awt.Graphics;

import dev.animalgame.entities.creatures.Creature;
//TODO subject to change, can be used to control spawn cooldowns
//
// _TODO_ DONE May change this to entity instead of creature since it is significantly different from a creature(but still an entity)
/**
 *  This is a special entity that takes care of spawning ally soldiers according to player input. It also takes care of summon cooldowns, food generation/consumption etc 
 *  TODO make this class get values of max health and basic attack from shopManager(or whatever its equivalent is) 
 *  	OR make the ShopManager class automatically update the values of this class.
 */
public class Spawner extends Entity {

	//TODO 
	public Spawner(float x, float y) {//TODO get the coordinate values from the Level class maybe?
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {

	}



}
