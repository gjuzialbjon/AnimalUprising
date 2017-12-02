package dev.animalgame.entities.creatures.enemies;

import java.awt.Graphics;

import dev.animalgame.entities.creatures.Creature;

public class EnemyCastle extends Creature implements Enemy{//Temporary note: "implements Enemy" is added during the first test of EntityManager. Make sure this class does not use the default tick method given by the interface

	public EnemyCastle(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
