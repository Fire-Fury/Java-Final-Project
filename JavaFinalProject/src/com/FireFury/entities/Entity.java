package com.FireFury.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;


public abstract class Entity {
	private World world;
	private String type;
	private BufferedImage texture;
	private int x,y;
	
	public Entity(World world, BufferedImage img, int x, int y, String type)
	{
		this.world = world;
		this.type = type;
		this.x = x;
		this.y = y;
		this.texture = img;
	}
	
	public abstract void update();
	public abstract void render(Graphics2D g2d);

	public String getType() {
		return type;
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
	public int getPixelX() {
		return x*Tile.TILEWIDTH;
	}

	public int getPixelY() {
		return y*Tile.TILEHEIGHT;
	}
	
	public void setX(int dx) {
		x += dx;
	}

	public void setY(int dy) {
		y += dy;
	}
	
}
