package com.FireFury.entities.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.entities.Entity;

public class Creature extends Entity{

	public Creature(BufferedImage img, int x, int y, String name) {
		super(img, x, y, name);

	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(getTexture(), getX(), getY(), null);
		
	}

}
