package com.FireFury.entities.items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.Worlds.World;
import com.FireFury.entities.Entity;

public class Item extends Entity{
	
	public Item(World world, BufferedImage img, int x, int y, String type) {
		super(world, img, x, y, type);
	}
	
	@Override
	public void update() {
		
	}
	@Override
	public void render(Graphics2D g2d) {
		
	}
	
	

}
