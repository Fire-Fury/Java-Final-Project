package com.FireFury.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entity {
	private String name;
	private BufferedImage texture;
	private int x,y;
	
	public Entity(BufferedImage img, int x, int y, String name)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.texture = img;
	}
	
	public abstract void update();
	public abstract void render(Graphics2D g2d);

	public String getName() {
		return name;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int dx) {
		x += dx;
	}

	public void setY(int dy) {
		y += dy;
	}
	
}
